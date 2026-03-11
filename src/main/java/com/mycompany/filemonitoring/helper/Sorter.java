package com.mycompany.filemonitoring.helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Sorter {
    private final JTextField searchField;
    private final JButton searchButton;
    private TableRowSorter<DefaultTableModel> sorter;

    public Sorter(JTextField searchField, JButton searchButton) {
        this.searchField = searchField;
        this.searchButton = searchButton;
    }

    public void attachTo(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Reset old listeners to avoid duplicates
        for (var listener : searchButton.getActionListeners()) {
            searchButton.removeActionListener(listener);
        }

        searchButton.addActionListener(e -> {
            String text = searchField.getText();
            if (text.trim().isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 3)); //FIle Name column.
            }
        });
    }
}
