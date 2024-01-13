package t2;
public interface ServerStorageInterface {

    public void writeToStorage(String msg);
    public String getLog();   
    public void stopServer();
} 
