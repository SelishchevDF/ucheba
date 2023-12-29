
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Server {

    String serverName = "TEST";

    static List<Client> clients; 

    public Server() {  
        clients = new ArrayList<Client>(); 
        start();    
    }
		
    // отправляем сообщение всем клиентам
    public static void sendMessageToAllClients(String msg) {

        msg = msg + "\n";

        for (Client c : clients) {
            c.resiveMassage(msg);
        }

        ServerWindow.updateTextArea(msg);

        try(FileWriter f = new FileWriter("log.txt")){
            f.append(msg);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    // добавляем клиента 
    public static void addClient(Client client){
        clients.add(client);
        Client cl = client;
        try {
            Path path = Paths.get("log.txt");
            List<String> lines = Files.readAllLines(path);
            for (String string : lines) {
                cl.resiveMassage(string);  
            }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    }

    //останавливаем сервер
    protected void stop(){
        sendMessageToAllClients("Сервер остановлен");
        File f = new File("log.txt");
        f.delete();
    }

    protected void start(){
        sendMessageToAllClients("Сервер запущен!");

    }
}