import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;

public class Login extends javax.swing.JFrame {

    private static String usname, pass;

    private static final String filepath = "src\\netnexus.json";
    private static JSONParser jsonParser = new JSONParser();
    private static JSONObject record = new JSONObject();
    private static JSONArray users = new JSONArray();

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // GUI code remains unchanged
    }

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {
        // Placeholder for username field action
    }

    private void passwrdActionPerformed(java.awt.event.ActionEvent evt) {
        // Placeholder for password field action
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            usname = username.getText();
            pass = passwrd.getText();

            try {
                filecheck();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (org.json.simple.parser.ParseException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            int checker = 0;
            for (int a = 0; a < users.size(); a++) {
                JSONObject userObject = (JSONObject) users.get(a);
                String searchedUname = (String) userObject.get("username");
                String searchedPswd = (String) userObject.get("password");

                if (usname.equals(searchedUname) && pass.equals(searchedPswd)) {
                    checker++;
                    long logins = (long) userObject.getOrDefault("logins", 0L);
                    userObject.put("logins", logins + 1);

                    // Set or update the session start time
                    updateSessionStartTime(userObject);

                    break;
                }
            }

            if (checker == 0) {
                JOptionPane.showMessageDialog(this, "No account has been found.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                dispose(); // Close login window and open dashboard
                Dashboard x = new Dashboard();
                x.setVisible(true);
            }

            save();
        } catch (IOException | org.json.simple.parser.ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateSessionStartTime(JSONObject userObject) {
        try {
            // Ensure the session array exists
            JSONArray sessions = (JSONArray) record.getOrDefault("sessions", new JSONArray());

            boolean sessionFound = false;
            for (int i = 0; i < sessions.size(); i++) {
                JSONObject session = (JSONObject) sessions.get(i);
                String username = (String) session.get("username");

                if (username.equals(usname)) {
                    sessionFound = true;
                    session.put("startTime", getCurrentTime()); // Update start time to current time
                    session.put("active", true); // Activate the session
                    break;
                }
            }

            if (!sessionFound) {
                // Create a new session for this user
                JSONObject newSession = new JSONObject();
                newSession.put("username", usname);
                newSession.put("startTime", getCurrentTime());
                newSession.put("userTime", "01:00:00"); // Default user time (can be customized)
                newSession.put("remainingTime", "01:00:00");
                newSession.put("active", true);
                sessions.add(newSession);
            }

            record.put("sessions", sessions); // Update the sessions array in the record
        } catch (Exception e) {
            System.err.println("Error updating session start time: " + e.getMessage());
        }
    }

    private String getCurrentTime() {
        // Return the current time in HH:mm:ss format
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String getusname() {
        return usname;
    }

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {
        username.setText("");
        passwrd.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    public static void filecheck() throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        FileReader reader = new FileReader(filepath);

        if (reader.ready()) {
            Scanner scan = new Scanner(reader);
            String line = "";

            while (scan.hasNext()) {
                line = line + scan.nextLine();
            }

            if (!line.equals("")) {
                reader.close();
                try (FileReader read = new FileReader(filepath)) {
                    record = (JSONObject) jsonParser.parse(read);
                    users = (JSONArray) record.get("users");
                }
            }
        }
    }

    public static void save() throws IOException {
        try (FileWriter file = new FileWriter(filepath)) {
            file.write(record.toJSONString());
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JTextField passwrd;
    private javax.swing.JTextField username;
    // End of variables declaration                   
}
