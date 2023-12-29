
public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();

        ClientWindow clientWindow1 = new ClientWindow();
        clientWindow1.client.server = serverWindow.server;
        ClientWindow clientWindow2 = new ClientWindow();
        clientWindow2.client.server = serverWindow.server;
    }   
}
