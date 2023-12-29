
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


public class ClientWindow extends JFrame {
    final static private int HEIGHT = 500;
    final static private int WIDTH = 500;

    private JButton btnLogin, btnSend;
    private static JTextArea textArea;
    private static JTextField textFieldName;
    protected static JTextField textFieldMassage;
    protected Client client;
    protected Server server;
    //private SettingWindow settingWindow;

    ClientWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        client = new Client();

        setTitle("Client Window");
        setResizable(false);
        setVisible(true);
        btnLogin = new JButton("Login");
        btnSend = new JButton("Send");
        textArea = new JTextArea();
        textFieldMassage = new JTextField();
        textFieldName = new JTextField();
        

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.login(textFieldName.getText());
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendMessage(textFieldMassage.getText());
            }
        });

        textFieldName.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    client.login(textFieldName.getText());
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
                client.sendMessage(textFieldMassage.getText());
                }
            }
         
            public void keyReleased(KeyEvent e) {
                         
            }
         
            public void keyTyped(KeyEvent e) {
                         
            }
        });

        JPanel msgPanel = new JPanel(new GridLayout(1,2));
        msgPanel.add(textFieldMassage);
        msgPanel.add(btnSend);

        JPanel loginPanel = new JPanel(new GridLayout(1,2));
        msgPanel.add(textFieldName);
        msgPanel.add(btnLogin);

        JPanel p = new JPanel(new BorderLayout());

        add(msgPanel, BorderLayout.SOUTH);

        p.add(loginPanel, BorderLayout.NORTH);
        p.add(textArea, BorderLayout.CENTER);

        add(p, BorderLayout.CENTER );
        
    }

    protected static void updateTextArea(String text) {
        try{
        textArea.append(text);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
