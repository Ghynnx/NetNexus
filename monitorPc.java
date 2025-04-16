
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author User
 */
public class monitorPc extends javax.swing.JFrame {

    private static final String filepath = "C:\\Users\\User\\Documents\\NetBeansProjects\\NetNexus\\src\\netnexus.json";

    /**
     * Creates new form monitorPc
     */
    public monitorPc() {
        initComponents();
        loadUserData();
}
     // Load JSON data into jTable1
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        refBtn = new javax.swing.JButton();
        outBtn = new javax.swing.JButton();
        backBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {}
            ,
            new String [] {
                "Pc No.", "Username", "Time", "Balance", "Logins", "VIP rank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Pc No.");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Username");
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Time");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Balance");
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Logins");
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setHeaderValue("VIP rank");
        }

        refBtn.setText("Refresh");
        refBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refBtnActionPerformed(evt);
            }
        });

        outBtn.setText("Force Logout");
        outBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outBtnActionPerformed(evt);
            }
        });

        backBtn2.setText("Back");
        backBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outBtn))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn2)
                .addGap(118, 118, 118)
                .addComponent(refBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outBtn)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    Admin adminScreen = new Admin();
    adminScreen.setVisible(true);
    this.dispose(); // Close the current window

    }                                        

    private void outBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        forceLogoutUser();
    }                                      

    private void refBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
       refreshTableData();
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(monitorPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(monitorPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(monitorPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(monitorPc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new monitorPc().setVisible(true);
        });
    }

private void loadUserData() {
    try {
        File file = new File(filepath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "JSON file not found at: " + filepath);
            return;
        }

        // Parse JSON file
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
        JSONArray users = (JSONArray) jsonObject.get("users");

        // Clear existing rows in the table
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);

        // Populate table with only active users
        for (Object obj : users) {
            JSONObject user = (JSONObject) obj;
            Boolean isActive = (Boolean) user.get("active");

            // Skip inactive users
            if (isActive == null || !isActive) {
                continue;
            }

            String pcNo = "PC-" + (users.indexOf(obj) + 1); // Placeholder PC number
            String username = (String) user.get("username");
            String remainingTime = (String) user.get("userTime");
            String balance = user.containsKey("balance") ? (String) user.get("balance") : "N/A"; // Optional field

            // Handle null 'logins' by defaulting to 0
            Long loginsLong = (Long) user.get("logins");
            int logins = (loginsLong != null) ? loginsLong.intValue() : 0;

            String rank = determineRank(logins);

            // Add row to the table
            tableModel.addRow(new Object[]{pcNo, username, remainingTime, balance, logins, rank});
        }
    } catch (HeadlessException | IOException | ParseException e) {
        JOptionPane.showMessageDialog(this, "Error loading user data: " + e.getMessage());
    }
}
// Helper method to determine rank based on logins
private String determineRank(int logins) {
    if (logins >= 30) {
        return "Gold";
    } else if (logins >= 20) {
        return "Silver";
    } else if (logins >= 10) {
        return "Bronze";
    } else {
        return "Unranked";
    }
}
private void forceLogoutUser() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a user to force logout.");
        return;
    }

    String username = (String) jTable1.getValueAt(selectedRow, 1); // Username is in column 1

    try {
        File file = new File(filepath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "JSON file not found at: " + filepath);
            return;
        }

        // Parse JSON file
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
        JSONArray users = (JSONArray) jsonObject.get("users");

        boolean userFound = false;

        // Update user data to set 'active' to false
        for (Object obj : users) {
            JSONObject user = (JSONObject) obj;
            if (username.equalsIgnoreCase((String) user.get("username"))) {
                userFound = true;

                // Set active to false and reset remaining time
                user.put("active", false);
                user.put("remainingTime", "0:00"); // Optional: Reset time
                break;
            }
        }

        if (!userFound) {
            JOptionPane.showMessageDialog(this, "User not found.");
            return;
        }

        // Write updated JSON back to file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonObject.toJSONString());
        }

        // Refresh table to remove the logged-out user
        loadUserData();

        JOptionPane.showMessageDialog(this, "User " + username + " has been logged out.");
    } catch (HeadlessException | IOException | ParseException e) {
        JOptionPane.showMessageDialog(this, "Error during force logout: " + e.getMessage());
    }
}
private void refreshTableData() {
    loadUserData(); // Reuse the existing method
    JOptionPane.showMessageDialog(this, "Table refreshed successfully.");
}
    // Variables declaration - do not modify                     
    private javax.swing.JButton backBtn2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton outBtn;
    private javax.swing.JButton refBtn;
    // End of variables declaration                   
}
