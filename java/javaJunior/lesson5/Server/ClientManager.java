package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientManager implements Runnable {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clients.add(this);
            //TODO: ...
            name = bufferedReader.readLine();
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        }
        catch (Exception e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        // Удаление клиента из коллекции
        removeClient();
        try {
            // Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            // Завершаем работу буфера для записи данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            // Закрытие соединения с клиентским сокетом
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление клиента из коллекции
     */
    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.");
    }

    /**
     * Отправка сообщения всем слушателям
     *
     * @param message сообщение
     */
    private void broadcastMessage(String message) {
        for (ClientManager client : clients) {
            try {
                if (!client.equals(this) && message != null){
                //if (!client.name.equals(name) && message != null) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (Exception e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private void privateMassage(String[] parsedMessage) {
        String message = "";
        int isClientExist = 0;

        //отправка личного
        for (ClientManager client : clients) {
            try {
                if (client.name.equals(parsedMessage[1])){
                    isClientExist ++;
                    message = parsedMessage[1] + ": ";
                    for (int i = 2; i < parsedMessage.length; i++){
                        message = message + parsedMessage[i] + " ";
                    }
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
        
            } catch (Exception e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }

        //отправка себе если не нашелся клиент
        if (isClientExist == 0){
            try {
                    this.bufferedWriter.write("Клиент не найден");
                    this.bufferedWriter.newLine();
                    this.bufferedWriter.flush();
            } catch (Exception e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }   
    }

    @Override
    public void run() {
        String massageFromClient;
        char privateMassageFlag = '@';

        while (!socket.isClosed()) {
            try {
                // Чтение данных
                massageFromClient = bufferedReader.readLine();

                //парсинг сообщения и выбор метода отправки в сокеты
                String[] tempMessage = massageFromClient.split(" ");
                if (tempMessage[1] != null && tempMessage[1].charAt(0) == privateMassageFlag){

                    tempMessage[1] = tempMessage[1].substring(1);

                    //Отправка личного сообщения
                    privateMassage(tempMessage);

                }
                else{
                    // Отправка данных всем слушателям
                    broadcastMessage(massageFromClient);
                }
            }
            catch (Exception e){
                closeEverything(socket, bufferedReader, bufferedWriter);
                //break;
            }
        }
    }
}