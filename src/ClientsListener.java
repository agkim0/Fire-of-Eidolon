import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ClientsListener implements Runnable,Serializable{
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private FOEFrame frame = null;
    private String username;

    public ClientsListener(ObjectInputStream is, ObjectOutputStream os, FOEFrame frame, String username){
        this.is = is;
        this.os = os;
        this.frame = frame;
    }

    @Override
    public void run(){
        while(true){
            try{
                CommandFromServer cfs = (CommandFromServer) is.readObject();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
