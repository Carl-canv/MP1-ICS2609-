package mp1.ct;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;

/**
 *
 * @author CarlT
 */
public class Records {
    public static int FRAME_WIDTH = 600;
    public static int FRAME_HEIGHT= 467;
    public static int LIST_PANEL_WIDTH = 480;
    public static int LIST_PANEL_HEIGHT = 250;

    //Frames
    JFrame mainF = new JFrame("List of Users");
    JFrame addRecordF = new JFrame("Add Record");
    JFrame updateRecordF = new JFrame("Update Record");
    JFrame deleteRecordF = new JFrame("Delete Record");
    JFrame logoutF = new JFrame("Logout");

    // Main Frame Components
    JButton addRecordB = new JButton("<html> <center> Add Record</center> </html>");
    JButton updateRecordB = new JButton("<html><center>Update Record </center></html>");
    JButton deleteRecordB = new JButton("<html><center>Delete Record </center></html>");
    JButton logoutB = new JButton ("<html><center>Logout </center></html>");

    JTextArea recordArea = new JTextArea();
    JScrollPane scrollP = new JScrollPane(recordArea);

    // Add Record Components

    // Remove Record Frame Components

    public Records(){
        // Main Frame Components

        scrollP.setBounds(55, 50, LIST_PANEL_WIDTH, LIST_PANEL_HEIGHT);
        recordArea.setEditable(false);
        recordArea.setFont(new Font("Courier New", Font.PLAIN, 13));
        recordArea.setText("           EMAIL           PASSWORD           ROLE\n");

        addRecordB.setBounds(35, 320, 130, 40);
        updateRecordB.setBounds(230, 320, 130, 40);
        deleteRecordB.setBounds(425, 320, 130, 40);
        logoutB.setBounds(0, 380, 587, 50);

        addRecordB.addActionListener(this::addRecord);
        updateRecordB.addActionListener(this::updateRecord);
        deleteRecordB.addActionListener(this::deleteRecord);
        logoutB.addActionListener(this::logout);

        // Add Record Components

        // Main Frame config
        mainF.add(scrollP);
        mainF.add(addRecordB);
        mainF.add(updateRecordB);
        mainF.add(deleteRecordB);
        mainF.add(logoutB);

        mainF.setLayout(null);
        mainF.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainF.setResizable(false);

        // Add Record Frame config

        addRecordF.setLocationRelativeTo(null);
        addRecordF.setLayout(null);
        addRecordF.setSize(600,300);
        addRecordF.setResizable(false);

        //Update record Frame config
        
        updateRecordF.setLocationRelativeTo(null);
        updateRecordF.setLayout(null);
        updateRecordF.setSize(600,300);
        updateRecordF.setResizable(false);

        mainF.setVisible(true);
    }
    // Functions of Main Frame Button Action Events
    private void addRecord(ActionEvent e){
        if (!updateRecordF.isVisible()){
            addRecordF.setVisible(true);
        } 
    }
    private void updateRecord(ActionEvent e){
        if (!addRecordF.isVisible()){
            updateRecordF.setVisible(true);
        } 
    }
    private void deleteRecord(ActionEvent e){
        if (!addRecordF.isVisible()){
            deleteRecordF.setVisible(true);
        }
    }
    private void logout(ActionEvent e) {
        
        int confirmation = JOptionPane.showConfirmDialog(mainF, 
                "Are you sure you want to logout?", "Logout", 
                JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            // Close all open frames:
            mainF.dispose();
            addRecordF.dispose();
            updateRecordF.dispose();
            deleteRecordF.dispose();
            logoutF.dispose();

            // Display the login frame:
            LogInCredentials infos = new LogInCredentials();
            LogInSc login = new LogInSc();
            login.beginApp(infos);
        }
}
    private void TextArea(){
        recordArea.setText("           EMAIL           PASSWORD           ROLE\n");
        String space1 = "           ";
        
    }
 
    //Add Record Frame Action Events

    // Update Record Frame Action Events

} // end of class Records