package com.mycompany.filemonitoring.helper;

import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.Date;

public class AddFormUI extends JPanel {
    public JComboBox<String> typeBox;
    public JComboBox<OfficeOption> officeBox;
    public JTextField receivedF;
    public JTextField fileNameF;
    public JDateChooser dateChooser;
    public JSpinner timeSpinner;
    public JButton addButton;
    public JButton cancelButton;
    
    public AddFormUI() {
        setLayout(new GridLayout(0, 2, 5, 5));
        
        add(new JLabel("Type:"));
        typeBox = new JComboBox<>(new String[]{"in", "out"});
        add(typeBox);
        
        add(new JLabel("Office:"));
        officeBox = new JComboBox<>(new OfficeOption[]{
            new OfficeOption("President", "president"),
            new OfficeOption("Executive Vice President", "executive_vp"),
            new OfficeOption("Vice President of Academic Affairs", "vp_of_academic_affairs"),
            new OfficeOption("Vice President for Administration and Finance", "vp_for_administration_and_finance"),
            new OfficeOption("College and Board Secretary", "college_and_board_secretary"),
            new OfficeOption("Others", "others")
        });
        add(officeBox);
        
        add(new JLabel("Received:"));
        receivedF = new JTextField();
        add(receivedF);
        
        add(new JLabel("File Name:"));
        fileNameF = new JTextField();
        add(fileNameF);
        
        add(new JLabel("Date:"));
        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        add(dateChooser);
        
        add(new JLabel("Time:"));
        SpinnerDateModel model = new SpinnerDateModel();
        timeSpinner = new JSpinner(model);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm"));
        timeSpinner.setValue(new Date());
        add(timeSpinner);
        
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        add(addButton);
        add(cancelButton);
        
    }
}
