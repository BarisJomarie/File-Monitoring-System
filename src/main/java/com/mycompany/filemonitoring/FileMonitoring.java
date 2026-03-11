/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filemonitoring;

import com.mycompany.filemonitoring.helper.Sorter;
import com.mycompany.filemonitoring.helper.tableStyle;
import java.sql.Connection;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ADMIN
 */
public class FileMonitoring extends JFrame {
    private Controller controller;
    private JTable table;
    private JScrollPane scrollPane;
    
    private String currentMode = "in"; // default table view
    private Sorter searchHelper;
    
    public FileMonitoring() {
        controller = new Controller();
        setTitle("File Monitoring System");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //Table
        table = controller.getInFilesTable();
        tableStyle.tStyle(table);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        //BUTTON PANEL
        JPanel switchPanel = new JPanel();
        switchPanel.setLayout(new BoxLayout(switchPanel, BoxLayout.Y_AXIS));
        switchPanel.setPreferredSize(new Dimension(150, 200)); 
        
        JButton inButton = new JButton("GOING IN");
        JButton outButton = new JButton("GOING OUT");
        
        JButton addButton = new JButton("Add");
        JButton refreshButton = new JButton("Refresh");
        JButton deleteButton = new JButton("Delete");
        
        inButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        outButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        
        addButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        refreshButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        deleteButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        
        switchPanel.add(inButton);
        switchPanel.add(Box.createVerticalStrut(10));
        switchPanel.add(outButton);
        switchPanel.add(Box.createVerticalStrut(50));
        switchPanel.add(addButton);
        switchPanel.add(Box.createVerticalStrut(10));
        switchPanel.add(refreshButton);
        switchPanel.add(Box.createVerticalStrut(10));
        switchPanel.add(deleteButton);
        
        add(switchPanel, BorderLayout.WEST);
        
        inButton.setEnabled(false);
        outButton.setEnabled(true);

        //FILTER PANEL
        JPanel filterPanel = new JPanel();
        JTextField searchBarF = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchHelper = new Sorter(searchBarF, searchButton);
        searchHelper.attachTo(table);
        
        filterPanel.add(new JLabel("Search File Name:"));
        filterPanel.add(searchBarF);
        filterPanel.add(searchButton);
        
        add(filterPanel, BorderLayout.NORTH);
        
        
        
        
        inButton.addActionListener(e -> {
            table = controller.getInFilesTable();
            tableStyle.tStyle(table);
            currentMode = "in";
            scrollPane.setViewportView(table);
            searchHelper.attachTo(table);
            
            inButton.setEnabled(false);
            outButton.setEnabled(true);
        });
        
        outButton.addActionListener(e -> {
            table = controller.getOutFilesTable();
            tableStyle.tStyle(table);
            currentMode = "outx";
            scrollPane.setViewportView(table);
            searchHelper.attachTo(table);
            
            inButton.setEnabled(true);
            outButton.setEnabled(false);
        });
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
        table.setRowSorter(sorter);

        searchButton.addActionListener(e -> {
            String text = searchBarF.getText();
            if (text.trim().length() == 0) {
                sorter.setRowFilter(null); // show all
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 3)); 
                // column index 3 = "File Name" (adjust if needed)
            }
        });

        
        addButton.addActionListener(e -> {
            AddFileLogDialog dialog = new AddFileLogDialog(this, controller);
            dialog.setVisible(true);
            refreshTable();
        });
        
        refreshButton.addActionListener(e -> refreshTable());
        
        deleteButton.addActionListener(e -> {
            int[] selectedRows = table.getSelectedRows();

            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this, "No rows selected.");
                return;
            }

            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete " + selectedRows.length + " row(s)?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                for (int row : selectedRows) {
                    int id = (int) table.getValueAt(row, 0);
                    if ("in".equals(currentMode)) {
                        controller.deleteLogbookIn(id);
                    } else {
                        controller.deleteLogbookOut(id);
                    }
                }
                refreshTable();
            }
        });

        setVisible(true);
    }
    
    public void refreshTable() {
        if ("in".equals(currentMode)) {
            table = controller.getInFilesTable();
        } else {
            table = controller.getOutFilesTable();
        }
        tableStyle.tStyle(table);
        scrollPane.setViewportView(table);
        searchHelper.attachTo(table);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(FileMonitoring::new);
    
        //DATABASE CHECKER kung match tayo <3
        Connection connect = DB.getConnection();
        if (connect != null) {
            System.out.println("Connected to database!");
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Database is not connected!",
                "Connection Error",
                JOptionPane.ERROR_MESSAGE
            );
        } 
    }
}