package mp1.ct;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author CarlT
 */
class LogInCredentials {
    private HashMap<String, String> credentials;

    LogInCredentials (){
        credentials = new HashMap<String, String>();
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader("runtime/loginCredentials.txt"));
            String input = br.readLine();

            while (input != null) {
                String user = input;
                String pass = br.readLine();

                credentials.put(user, pass);

                // read next user
                input = br.readLine();
            }
            br.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    public HashMap<String, String> getCredentials(){
        return credentials;
    }
}
class InvalidInputs extends Exception {
    public InvalidInputs(){
        super();
    }
}
public class LogInSc implements ActionListener {
    
    // Containers
    JFrame logFrame;
    
    // Components
    JTextField tField;
    JPasswordField pField;
    JButton logButton;
    JLabel mssgLabel;
    JLabel userLabel;
    JLabel passLabel;
   
    HashMap<String, String> credentials;
    private int tries = 0;                       // attempt counter

    public LogInSc(){                            // constructor
        logFrame = new JFrame("Login Screen");
        logButton = new JButton(" Login ");
        tField = new JTextField();
        pField = new JPasswordField();
        mssgLabel = new JLabel();
        userLabel = new JLabel("Username: ");
        passLabel = new JLabel("Password: ");
    }
    public void beginApp(LogInCredentials infos){    
        credentials = infos.getCredentials();
        
        // Frame modifications
        logFrame.add(userLabel);
        logFrame.add(passLabel);
        logFrame.add(mssgLabel);
        logFrame.add(tField);
        logFrame.add(pField);
        logFrame.add(logButton);
        
        logFrame.setSize(430, 360);
        logFrame.setLayout(null);
        logFrame.setVisible(true);
        
        // size modification of the components within the frame
        userLabel.setBounds(50, 100, 200, 30);
        passLabel.setBounds(50, 150, 200, 30);

        mssgLabel.setBounds(125, 250, 250, 35);
        mssgLabel.setFont(new Font(null, Font.ITALIC, 25));

        tField.setBounds(125, 100, 200, 30);
        pField.setBounds(125, 150, 200, 30);
        
        logButton.setBounds( 175, 200, 100, 30);
        logButton.addActionListener(this);
    }
    @Override
    public void actionPerformed (ActionEvent event){ // checking validity of input
        if (event.getSource() == logButton){
            String user = tField.getText();
            String pass = String.valueOf(pField.getPassword()); 

            try {
                if (credentials.containsKey(user) && credentials.get(user).equals(pass )){
                        logFrame.dispose();
                        Records record = new Records();
                } else {
                    throw new InvalidInputs();
                }
            } catch (InvalidInputs xinputs){
                tries++;
                if (tries >= 3){
                    JOptionPane.showConfirmDialog(null,
                "Sorry, you have reached the limit of 3 tries, good bye!",
                    "Error Screen", JOptionPane.CLOSED_OPTION);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(logFrame, "Incorrect Username/Password", 
                     "Error Screen", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}


    