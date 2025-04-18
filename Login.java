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

    private void updateSessionStartTime(JSONObject user

