package t2;
public class Main {
    public static void main(String[] args) {
        
        ServerWindow serverWindow = new ServerWindow();
        ClientWindow clientWindow1 = new ClientWindow(serverWindow.server);
        ClientWindow clientWindow2 = new ClientWindow(serverWindow.server);

    }   
}
