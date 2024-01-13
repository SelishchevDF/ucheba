package t2;

public class Client {
    protected String name;
    Server server;
    ClientWindow window;
 
    public Client(Server server, ClientWindow window)  {
        this.server = server;
        this.window = window;
    }


    protected void login (String name){
        this.name = name;
        server.addClient(this);

    }

    protected String createMsg(String msg){
        return name + ": " + msg + "\n";
    }

    protected void resiveMassage(String msg){
       window.printResivedMessage(msg);
    }

    protected void sendMessage(String msg){
        msg = createMsg(msg);
        server.sendMessageToAllClients(msg);
    }


}
