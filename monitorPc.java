
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.util.Timer;
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
    private Timer autoLogoutTimer;

    /**
     * Creates new form monitorPc
     */
    public monitorPc() {
        initComponents();
        loadUserData();
        startAutoLogoutTimer();
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
        loadUserData(); // Reuse the existing method
        JOptionPane.showMessageDialog(this, "Table refreshed successfully.");
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

    // Start a timer to periodically check and log out users with remainingTime = 0
    private void startAutoLogoutTimer() {
        if (autoLogoutTimer != null) {
            autoLogoutTimer.cancel(); // Cancel any existing timer
        }

        autoLogoutTimer = new Timer(true); // Run as a daemon thread
        autoLogoutTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    checkAndLogoutUsers();
                } catch (Exception e) {
                    System.err.println("Error in TimerTask: " + e.getMessage());
                }
            }
        }, 0, 1000); // Check every second
    }

    // Method to check remaining time and log out users
    private void checkAndLogoutUsers() {
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                return; // Exit if file doesn't exist
            }

            // Parse JSON file
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
            JSONArray users = (JSONArray) jsonObject.get("users");
            boolean dataUpdated = false;

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                Boolean isActive = (Boolean) user.get("active");

                if (isActive != null && isActive) {
                    String startTimeStr = (String) user.get("startTime"); // Assuming startTime is stored as HH:MM:SS
                    String allocatedDurationStr = (String) user.get("allocatedDuration"); // Assuming duration is HH:MM:SS

                    // Convert times to seconds
                    int startTime = parseTimeToSeconds(startTimeStr);
                    int allocatedDuration = parseTimeToSeconds(allocatedDurationStr);
                    int currentTime = (int) (System.currentTimeMillis() / 1000);

                    // Calculate elapsed time and remaining time
                    int elapsedTime = currentTime - startTime;
                    int remainingTime = allocatedDuration - elapsedTime;

                    if (remainingTime > 0) {
                        user.put("remainingTime", formatSecondsToTime(remainingTime));
                        dataUpdated = true;
                    } else {
                        user.put("active", false); // Log out the user
                        user.put("remainingTime", "00:00:00");
                        dataUpdated = true;

                        System.out.println("User " + user.get("username") + " logged out automatically.");
                    }
                }
            }

            if (dataUpdated) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(jsonObject.toJSONString());
                }
                loadUserData(); // Refresh table
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error checking user time: " + e.getMessage());
        }
    }

    // Utility to parse time string (HH:MM:SS) to seconds
    private int parseTimeToSeconds(String time) {
        try {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            return (hours * 3600) + (minutes * 60) + seconds;
        } catch (NumberFormatException e) {
            return 0; // Return 0 if parsing fails
        }
    }

    // Utility to format seconds into time string (HH:MM:SS)
    private String formatSecondsToTime(int seconds) {
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
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
                    user.put("remainingTime", "00:00:00"); // Reset time
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

                if (isActive != null && isActive) {
                    String pcNo = "PC-" + user.get("pcNo");
                    String username = (String) user.get("username");
                    String remainingTime = (String) user.get("remainingTime");
                    String balance = user.containsKey("amount") ? String.valueOf(user.get("amount")) : "N/A";

                    Long loginsLong = (Long) user.get("logins");
                    int logins = (loginsLong != null) ? loginsLong.intValue() : 0;

                    String rank = determineRank(logins);

                    // Add row to the table
                    tableModel.addRow(new Object[]{pcNo, username, remainingTime, balance, logins, rank});
                }
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
