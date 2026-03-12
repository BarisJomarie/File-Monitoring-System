package com.mycompany.filemonitoring.helper;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;
import java.util.Date;

public class AddFormUI extends JPanel {
    public JRadioButton inR;
    public JRadioButton outR;
    public JComboBox<OfficeOption> officeBox;
    public JTextField receivedF;
    public JTextField fileNameF;
    public JDateChooser dateChooser;
    public JSpinner timeSpinner;
    public JButton addButton;
    public JButton cancelButton;
    
    public AddFormUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // helper method to add label + component
        int row = 0;

        //TYPE
        addLabel("Type:", row, gbc);
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        inR = new JRadioButton("IN");
        outR = new JRadioButton("OUT");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(inR);
        typeGroup.add(outR);
        inR.setSelected(true);
        typePanel.add(inR);
        typePanel.add(outR);
        addField(typePanel, row++, gbc);
        
        
       //OFFICE
        addLabel("Office:", row, gbc);
        officeBox = new JComboBox<>(new OfficeOption[]{
            new OfficeOption("President", "president"),
            new OfficeOption("Executive Vice President", "executive_vp"),
            new OfficeOption("Vice President of Academic Affairs", "vp_of_academic_affairs"),
            new OfficeOption("Vice President for Administration and Finance", "vp_for_administration_and_finance"),
            new OfficeOption("College and Board Secretary", "college_and_board_secretary"),
            new OfficeOption("Others", "others")
        });
        addField(officeBox, row++, gbc);

        //RECEIVED
        addLabel("Received:", row, gbc);
        receivedF = new JTextField();
        addField(receivedF, row++, gbc);

        //FILE NAME
        addLabel("File Name:", row, gbc);
        fileNameF = new JTextField();
        addField(fileNameF, row++, gbc);

        //DATE
        addLabel("Date:", row, gbc);
        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        addField(dateChooser, row++, gbc);
        
        //TIME
        addLabel("Time:", row, gbc);
        SpinnerDateModel model = new SpinnerDateModel();
        timeSpinner = new JSpinner(model);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm"));
        timeSpinner.setValue(new Date());
        addField(timeSpinner, row++, gbc);

        // BUTTONS
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        addLabel("", row, gbc);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        addField(buttonPanel, row, gbc); 
    }
    
    private void addLabel(String text, int row, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0; // fixed width
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(100, 25)); // fixed width
        add(label, gbc);
    }
    
    private void addField(JComponent comp, int row, GridBagConstraints gbc) {
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 1; // take remaining space
        add(comp, gbc);
    }
}
