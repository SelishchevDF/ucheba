package t2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientWindow extends JFrame implements ClientWindowInterface {
    final static private int HEIGHT = 500;
    final static private int WIDTH = 500;

    private JButton btnLogin, btnSend;
    private JTextArea textArea;
    private JTextField textFieldName;
    private JTextField textFieldMassage;
    protected Client client;

    ClientWindow(Server serv){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        client = new Client(serv, this);

        setTitle("Client Window");
        setResizable(false);
        setVisible(true);
        btnLogin = new JButton("Login");
        btnSend = new JButton("Send");
        textArea = new JTextArea();
        textFieldMassage = new JTextField();
        textFieldName = new JTextField();

        
        JPanel msgPanel = new JPanel(new GridLayout(1,2));
        msgPanel.setVisible(true);
        msgPanel.add(textFieldMassage);
        msgPanel.add(btnSend);

        JPanel loginPanel = new JPanel(new GridLayout(1,2));
        loginPanel.setVisible(true);
        loginPanel.add(textFieldName);
        loginPanel.add(btnLogin);

        add(msgPanel, BorderLayout.SOUTH);
        add(loginPanel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer(textFieldName.getText());
                loginPanel.setVisible(false);
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(textFieldMassage.getText());
                textFieldMassage.setText("");
            }
        });

        textFieldName.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    connectToServer(textFieldName.getText());
                    loginPanel.setVisible(false);
                }
            }
         
            public void keyReleased(KeyEvent e) {
                         
            }
         
            public void keyTyped(KeyEvent e) {
                         
            }
        });

        textFieldMassage.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                sendMessage(textFieldMassage.getText());
                textFieldMassage.setText("");
                }
            }
         
            public void keyReleased(KeyEvent e) {
                         
            }
         
            public void keyTyped(KeyEvent e) {
                         
            }
        });       
    }

    protected void updateTextArea(String text) {
        try{
        textArea.append(text);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message){
        client.sendMessage(message);
    }
    
    //@Override
    public void printResivedMessage(String message) {
        updateTextArea(message);
    }

    @Override
    public void connectToServer(String name){
        client.login(name);
    }

}
