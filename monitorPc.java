import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.util.Timer;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class monitorPc extends javax.swing.JFrame {

    private static final String filepath = "C:\\Users\\User\\Documents\\NetBeansProjects\\NetNexus\\src\\netnexus.json";
    private Timer autoLogoutTimer;

    public monitorPc() {
        initComponents();
        loadUserData();
        startAutoLogoutTimer();
    }

    private void initComponents() {
        // GUI code remains unchanged
    }

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {
        Admin adminScreen = new Admin();
        adminScreen.setVisible(true);
        this.dispose();
    }

    private void outBtnActionPerformed(java.awt.event.ActionEvent evt) {
        forceLogoutUser();
    }

    private void refBtnActionPerformed(java.awt.event.ActionEvent evt) {
        loadUserData();
        JOptionPane.showMessageDialog(this, "Table refreshed successfully.");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new monitorPc().setVisible(true);
        });
    }

    private void startAutoLogoutTimer() {
        if (autoLogoutTimer != null) {
            autoLogoutTimer.cancel();
        }
        autoLogoutTimer = new Timer(true);
        autoLogoutTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    checkAndLogoutUsers();
                    removeInactiveUsers();
                } catch (Exception e) {
                    System.err.println("Error in TimerTask: " + e.getMessage());
                }
            }
        }, 0, 1000); // Schedule task every second
    }

    private void checkAndLogoutUsers() {
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                return;
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
            JSONArray sessions = (JSONArray) jsonObject.get("sessions");
            boolean dataUpdated = false;

            long currentTime = System.currentTimeMillis() / 1000; // Current time in seconds

            for (Object obj : sessions) {
                JSONObject session = (JSONObject) obj;

                Boolean isActive = (Boolean) session.get("active");
                if (isActive == null || !isActive) {
                    continue; // Skip inactive sessions
                }

                String startTimeStr = (String) session.get("startTime");
                String userTimeStr = (String) session.get("userTime");

                if (startTimeStr == null || userTimeStr == null) {
                    System.err.println("Missing startTime or userTime for session on PC: " + session.get("pcNo"));
                    continue;
                }

                int startTime = parseTimeToSeconds(startTimeStr);
                int userTime = parseTimeToSeconds(userTimeStr);

                int elapsedTime = (int) (currentTime - startTime);
                int remainingTime = userTime - elapsedTime;

                if (remainingTime > 0) {
                    session.put("remainingTime", formatSecondsToTime(remainingTime));
                } else {
                    session.put("active", false);
                    session.put("remainingTime", formatSecondsToTime(0));
                    System.out.println("Session on PC " + session.get("pcNo") + " logged out automatically.");
                }

                dataUpdated = true;
            }

            if (dataUpdated) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(jsonObject.toJSONString());
                }
                loadUserData();
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error checking session time: " + e.getMessage());
        }
    }

    private void forceLogoutUser() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to force logout.");
            return;
        }

        String username = (String) jTable1.getValueAt(selectedRow, 1);

        try {
            File file = new File(filepath);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "JSON file not found at: " + filepath);
                return;
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
            JSONArray users = (JSONArray) jsonObject.get("users");

            boolean userFound = false;

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (username.equalsIgnoreCase((String) user.get("username"))) {
                    userFound = true;
                    user.put("active", false);
                    user.put("remainingTime", formatSecondsToTime(0));
                    break;
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(this, "User not found.");
                return;
            }

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(jsonObject.toJSONString());
            }

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

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
            JSONArray sessions = (JSONArray) jsonObject.get("sessions");
            JSONArray users = (JSONArray) jsonObject.get("users");

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            for (Object obj : sessions) {
                JSONObject session = (JSONObject) obj;
                Boolean isActive = (Boolean) session.get("active");

                if (isActive != null && isActive) {
                    String pcNo = "PC-" + session.get("pcNo");
                    String username = (String) session.get("username");
                    String remainingTime = (String) session.get("remainingTime");

                    JSONObject user = findUserByUsername(users, username);
                    String balance = user != null ? String.valueOf(user.get("amount")) : "N/A";
                    int logins = user != null ? ((Long) user.get("logins")).intValue() : 0;
                    String rank = determineRank(logins);

                    tableModel.addRow(new Object[]{pcNo, username, remainingTime, balance, logins, rank});
                }
            }
        } catch (HeadlessException | IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error loading user data: " + e.getMessage());
        }
    }

    private JSONObject findUserByUsername(JSONArray users, String username) {
        for (Object obj : users) {
            JSONObject user = (JSONObject) obj;
            if (username.equals(user.get("username"))) {
                return user;
            }
        }
        return null;
    }

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

    private int parseTimeToSeconds(String time) {
        try {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            return (hours * 3600) + (minutes * 60) + seconds;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String formatSecondsToTime(int seconds) {
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private void removeInactiveUsers() {
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                return;
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
            JSONArray users = (JSONArray) jsonObject.get("users");

            long currentTime = System.currentTimeMillis();
            long thirtyDaysInMillis = 30L * 24 * 60 * 60 * 1000;

            users.removeIf(obj -> {
                JSONObject user = (JSONObject) obj;
                String lastActivityStr = (String) user.get("lastActivity");
                if (lastActivityStr == null) {
                    return false;
                }

                try {
                    long lastActivity = parseDateToMillis(lastActivityStr);
                    return (currentTime - lastActivity) > thirtyDaysInMillis;
                } catch (Exception e) {
                    return false;
                }
            });

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(jsonObject.toJSONString());
            }

            System.out.println("Inactive users removed successfully.");
        } catch (IOException | ParseException e) {
            System.err.println("Error removing inactive users: " + e.getMessage());
        }
    }

    private long parseDateToMillis(String dateStr) throws java.text.ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = dateFormat.parse(dateStr);
        return date.getTime();
    }

    private javax.swing.JButton backBtn2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton outBtn;
    private javax.swing.JButton refBtn;
}
