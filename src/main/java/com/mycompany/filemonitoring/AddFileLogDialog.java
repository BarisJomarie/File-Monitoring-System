package com.mycompany.filemonitoring;
import com.mycompany.filemonitoring.helper.AddFormUI;
import com.mycompany.filemonitoring.helper.OfficeOption;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class AddFileLogDialog extends JDialog {
    private AddFormUI formUI;
    private Controller controller;
    
    
    public AddFileLogDialog(JFrame parent, Controller controller) {
        super (parent, "Add New Log", true);
        this.controller = controller;
        
        setSize(450, 300);
        setLocationRelativeTo(parent);
        
        formUI = new AddFormUI();
        formUI.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        add(formUI);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        buttonPanel.add(formUI.addButton);
        buttonPanel.add(formUI.cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);   
        
        // Actions
        formUI.addButton.addActionListener(e -> {
            OfficeOption selectedOffice = (OfficeOption) formUI.officeBox.getSelectedItem();
            String officeValue = selectedOffice != null ? selectedOffice.getValue() : "";
            String received = formUI.receivedF.getText().trim();
            String fileName = formUI.fileNameF.getText().trim();
            Date chosenDate = formUI.dateChooser.getDate();
            Date chosenTime = (Date) formUI.timeSpinner.getValue();
 
            // Validation
            if (officeValue.isEmpty() || received.isEmpty() || fileName.isEmpty() || chosenDate == null || chosenTime == null) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in all fields before adding.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE);
                return; // stop here, do not insert
            }
            
            LocalDate date = new java.sql.Date(chosenDate.getTime()).toLocalDate();
            LocalTime time = new java.sql.Time(chosenTime.getTime()).toLocalTime();
            
            String type = formUI.inR.isSelected() ? "in" : "out";

            controller.insertLog(officeValue, received, fileName, date, time, type);
            dispose();
        });
        
        formUI.cancelButton.addActionListener(e -> dispose());
    }
}
