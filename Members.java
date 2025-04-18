/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Members extends javax.swing.JFrame {

    private static final String filepath2 = "src\\netnexus.json";

    public Members() {
        initComponents();
        LogsTF.setEditable(false);
        DscntTF.setEditable(false);
        RnkTF.setEditable(false);
        UsnTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                UsnTFActionPerformed(null);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        UsnTF = new javax.swing.JTextField();
        DscntTF = new javax.swing.JTextField();
        LogsTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        TopUp = new javax.swing.JButton();
        AmtTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        RnkTF = new javax.swing.JTextField();
        TimeTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(14, 14, 14));

        jPanel3.setBackground(new java.awt.Color(5, 5, 5));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(82, 82, 82)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("NET");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("NEXUS");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("USER");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Amount");

        UsnTF.setBackground(new java.awt.Color(51, 51, 51));
        UsnTF.setForeground(new java.awt.Color(255, 255, 255));
        UsnTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsnTFActionPerformed(evt);
            }
        });

        DscntTF.setBackground(new java.awt.Color(51, 51, 51));
        DscntTF.setForeground(new java.awt.Color(255, 255, 255));
        DscntTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        DscntTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DscntTFActionPerformed(evt);
            }
        });

        LogsTF.setBackground(new java.awt.Color(51, 51, 51));
        LogsTF.setForeground(new java.awt.Color(255, 255, 255));
        LogsTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        LogsTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogsTFActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vip");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Logins");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Discount");

        Clear.setBackground(new java.awt.Color(255, 0, 0));
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("CLEAR");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        TopUp.setBackground(new java.awt.Color(56, 182, 255));
        TopUp.setForeground(new java.awt.Color(255, 255, 255));
        TopUp.setText("TOP UP");
        TopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopUpActionPerformed(evt);
            }
        });

        AmtTF.setBackground(new java.awt.Color(51, 51, 51));
        AmtTF.setForeground(new java.awt.Color(255, 255, 255));
        AmtTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmtTFActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username");

        RnkTF.setBackground(new java.awt.Color(51, 51, 51));
        RnkTF.setForeground(new java.awt.Color(255, 255, 255));
        RnkTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        RnkTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RnkTFActionPerformed(evt);
            }
        });

        TimeTF.setBackground(new java.awt.Color(51, 51, 51));
        TimeTF.setForeground(new java.awt.Color(255, 255, 255));
        TimeTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        TimeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeTFActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsnTF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(TopUp)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Clear))
                                .addComponent(AmtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RnkTF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(DscntTF, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsnTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RnkTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DscntTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TopUp)
                    .addComponent(Clear))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsnTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsnTFActionPerformed
        String enteredUsername = UsnTF.getText().trim();

        if (enteredUsername.isEmpty()) {
            return;
        }

        try {
            File file = new File(filepath2);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "JSON file not found at: " + filepath2);
                return;
            }

            FileReader reader = new FileReader(file);
            StringBuilder jsonBuilder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                jsonBuilder.append((char) ch);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(jsonBuilder.toString());
            JSONArray users = jsonObject.getJSONArray("users");

            boolean userFound = false;

            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                if (user.getString("username").equalsIgnoreCase(enteredUsername)) {
                    userFound = true;

                    int logins = user.getInt("logins");
                    int discount = user.optInt("discount", 0); // default to 0 if missing
                    String userTime = user.getString("userTime");

                    String rank = "Regular";
                    if (logins >= 30) {
                        rank = "Gold";
                    } else if (logins >= 20) {
                        rank = "Silver";
                    } else if (logins >= 10) {
                        rank = "Bronze";
                    }

                    LogsTF.setText(String.valueOf(logins));
                    DscntTF.setText(discount + "%");
                    RnkTF.setText(rank);
                    TimeTF.setText(userTime);

                    break;
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(this, "User not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading user info: " + e.getMessage());
        }
    }//GEN-LAST:event_UsnTFActionPerformed

    private void TopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopUpActionPerformed
        String enteredUsername = UsnTF.getText().trim();

        if (enteredUsername.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.");
            return;
        }

// Parse amount
        String amountStr = AmtTF.getText().trim();
        int amount = 0;
        try {
            amount = Integer.parseInt(amountStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered.");
            return;
        }

        try {
            File file = new File(filepath2);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "JSON file not found at: " + filepath2);
                return;
            }

            FileReader reader = new FileReader(file);
            StringBuilder jsonBuilder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                jsonBuilder.append((char) ch);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(jsonBuilder.toString());
            JSONArray users = jsonObject.getJSONArray("users");
            JSONArray sessions = jsonObject.getJSONArray("sessions");

            boolean userFound = false;

            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                if (user.getString("username").equalsIgnoreCase(enteredUsername)) {
                    userFound = true;

                    // Parse existing userTime
                    String currentTime = user.getString("userTime"); // e.g. "1:30"
                    String[] timeParts = currentTime.split(":");
                    int currentHours = Integer.parseInt(timeParts[0]);
                    int currentMinutes = Integer.parseInt(timeParts[1]);
                    int currentTotalMinutes = currentHours * 60 + currentMinutes;

                    // Convert amount to added minutes (₱10 = 30 minutes)
                    int addedMinutes = (amount * 30) / 10;

                    // New total time
                    int newTotalMinutes = currentTotalMinutes + addedMinutes;
                    int newHours = newTotalMinutes / 60;
                    int newMinutes = newTotalMinutes % 60;

                    String newUserTime = String.format("%d:%02d", newHours, newMinutes);
                    TimeTF.setText(newUserTime); // Show new time in GUI

                    // Update logins, discount, rank
                    int logins = user.getInt("logins") + 1;
                    user.put("logins", logins);
                    user.put("userTime", newUserTime);

                    String rank = "Regular";
                    int discount = 0;
                    if (logins >= 30) {
                        rank = "Gold";
                        discount = 15;
                    } else if (logins >= 20) {
                        rank = "Silver";
                        discount = 10;
                    } else if (logins >= 10) {
                        rank = "Bronze";
                        discount = 5;
                    }

                    user.put("discount", discount);

                    // Update session time
                    for (int s = 0; s < sessions.length(); s++) {
                        JSONObject session = sessions.getJSONObject(s);
                        if (session.getString("username").equalsIgnoreCase(enteredUsername)) {
                            session.put("remainingTime", newUserTime);
                            break;
                        }
                    }

                    // Save updated JSON
                    FileWriter writer = new FileWriter(file);
                    writer.write(jsonObject.toString(4));
                    writer.close();

                    // Update GUI
                    LogsTF.setText(String.valueOf(logins));
                    RnkTF.setText(rank);
                    DscntTF.setText(discount + "%");

                    break;
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(this, "User not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage());
        }
    }//GEN-LAST:event_TopUpActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        UsnTF.setText("");
        AmtTF.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    private void LogsTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogsTFActionPerformed

    }//GEN-LAST:event_LogsTFActionPerformed

    private void DscntTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DscntTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DscntTFActionPerformed

    private void AmtTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmtTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmtTFActionPerformed

    private void RnkTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RnkTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RnkTFActionPerformed

    private void TimeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeTFActionPerformed

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
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Members().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmtTF;
    private javax.swing.JButton Clear;
    private javax.swing.JTextField DscntTF;
    private javax.swing.JTextField LogsTF;
    private javax.swing.JTextField RnkTF;
    private javax.swing.JTextField TimeTF;
    private javax.swing.JButton TopUp;
    private javax.swing.JTextField UsnTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
