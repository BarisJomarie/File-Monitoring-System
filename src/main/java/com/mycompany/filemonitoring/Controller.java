package com.mycompany.filemonitoring;

import com.mycompany.filemonitoring.helper.OfficeNameFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class Controller {
  
    //INSERT FILE
    public void insertLog(String office, String received, String file_name, LocalDate date, LocalTime time, String type) {
        try (Connection connect = DB.getConnection()) {
            String table_name = "logbook_" + type;
            String sql = "INSERT INTO " + table_name + " (office, received, file_name, date, time) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, office);
            ps.setString(2, received);
            ps.setString(3, file_name);
            ps.setDate(4, java.sql.Date.valueOf(date));
            ps.setTime(5, java.sql.Time.valueOf(time));
            ps.executeUpdate();
            System.out.println("Log inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //UPDATE FILE
    public void updateLogBookIn(int id, String columnName, Object newValue) {
        
        if("File Name".equals(columnName)) {
            columnName = "file_name";
        }
        
        String sql = "UPDATE logbook_in SET " + columnName + " = ? WHERE id = ?";
        try (Connection connect = DB.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setObject(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Updated row " + id + " column " + columnName + " to " + newValue);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    
    public void updateLogBookOut(int id, String columnName, Object newValue) {
        
        if("File Name".equals(columnName)) {
            columnName = "file_name";
        }
        
        String sql = "UPDATE logbook_out SET " + columnName + " = ? WHERE id = ?";
        try (Connection connect = DB.getConnection();
            PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setObject(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Updated row " + id + " column " + columnName + " to " + newValue);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    
    // DELETE FILE
    public void deleteLogbookIn(int id) {
        String sql = "DELETE FROM logbook_in WHERE id = ?";
        try (Connection connect = DB.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted row with ID " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteLogbookOut(int id) {
        String sql = "DELETE FROM logbook_out WHERE id = ?";
        try (Connection connect = DB.getConnection();
             PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted row with ID " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    //GUI TABLE
    //IN
    public JTable getInFilesTable() {
        String[] columns = {"ID", "Office", "Received", "File Name", "Date", "Time"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3;
            }
        };
        
        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();

            if (column == TableModelEvent.ALL_COLUMNS || row < 0) return;

            Object newValue = model.getValueAt(row, column);
            int id = (int) model.getValueAt(row, 0);
            String columnName = model.getColumnName(column);

            updateLogBookIn(id, columnName, newValue);
        });
        
        try (Connection connect = DB.getConnection()) {
            String sql = "SELECT * FROM logbook_in";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String office = OfficeNameFormatter.formatOfficeName(rs.getString("office"));
                
                Object[] row = {
                    rs.getInt("id"),
                    office,
                    rs.getString("received"),
                    rs.getString("file_name"),
                    rs.getDate("date"),
                    rs.getTime("time")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return new JTable(model);
    }
    
    //GUI TABLE
    //OUT
    public JTable getOutFilesTable() {
        String[] columns = {"ID", "Office", "Received", "File Name", "Date", "Time"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3;
            }
        };
        
        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();

            if (column == TableModelEvent.ALL_COLUMNS || row < 0) return;

            Object newValue = model.getValueAt(row, column);
            int id = (int) model.getValueAt(row, 0);
            String columnName = model.getColumnName(column);

            updateLogBookOut(id, columnName, newValue);
        });
        
        try (Connection connect = DB.getConnection()) {
            String sql = "SELECT * FROM logbook_out";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String office = OfficeNameFormatter.formatOfficeName(rs.getString("office"));
                
                Object[] row = {
                    rs.getInt("id"),
                    office,
                    rs.getString("received"),
                    rs.getString("file_name"),
                    rs.getDate("date"),
                    rs.getTime("time")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return new JTable(model);
    }
}
