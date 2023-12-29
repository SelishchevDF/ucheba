

public class Client {
    protected static String name;
    Server server;
 
    public Client() {
    }


    protected void login (String name){
        Client.name = name;
        Server.addClient(this);

    }

    protected String createMsg(String msg){
        return name + ": " + msg;
    }

    protected void resiveMassage(String msg){
        ClientWindow.updateTextArea(msg);
    }

    protected void sendMessage(String msg){
        msg = createMsg(msg);
        Server.sendMessageToAllClients(msg);
    }


}
