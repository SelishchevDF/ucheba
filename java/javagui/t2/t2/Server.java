package t2;
import java.util.ArrayList;
import java.util.List;

public class Server {

    static List<Client> clients; 
    ServerStorage serverStorage;
    ServerWindow serverWindow;

    public Server(ServerWindow serverWindow) { 
        serverStorage = new ServerStorage(); 
        this.serverWindow = serverWindow;
        clients = new ArrayList<Client>();     
    }
		
    // отправляем сообщение всем клиентам
    public void sendMessageToAllClients(String msg) {

        for (Client c : clients) {
            c.resiveMassage(msg);
        }

        serverWindow.updateTextArea(msg);

        serverStorage.writeToStorage(msg);
        
    }

    // добавляем клиента 
    public void addClient(Client client){
        clients.add(client);
        client.resiveMassage(serverStorage.getLog());
    }

    //останавливаем сервер
    protected void stop(){
        sendMessageToAllClients("Сервер остановлен" + "\n");
        serverStorage.stopServer();
    }

    protected void start(){
        sendMessageToAllClients("Сервер запущен!" + "\n");

    }
}