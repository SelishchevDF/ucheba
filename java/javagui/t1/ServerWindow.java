
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerWindow extends JFrame{
    final static private int HEIGHT = 500;
    final static private int WIDTH = 500;

    private JButton btnStart, btnStop;
    private static JTextArea textArea;
    protected Server server;
    //private SettingWindow settingWindow;

    ServerWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        server = new Server();

        setTitle("Server Window");
        setResizable(false);
        setVisible(true);
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        textArea = new JTextArea();
        

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);

        add(panBottom, BorderLayout.SOUTH);
        add(textArea, BorderLayout.CENTER);
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
