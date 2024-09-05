import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ServersListener {
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private static GameData = new GameData();
    private static ArrayList<ObjectOutputStream> outs = new ArrayList<>();
    private String username;
    public ServersListener (ObjectInputStream is, ObjectOutputStream os, String username){
        this.is = is;
        this.os = os;
        this.username = username;
        outs.add(os);
    }
    public void run(){
        while(true){
            try{
                CommandFromClient cfc = (CommandFromClient) is.readObject();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void sendCommand(int com, String data, GameData gameData){
        CommandFromServer cfs = new CommandFromServer(com,data,gd);
        for(ObjectOutputStream o:outs){
            try{
                o.writeObject(cfs);
                o.reset();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
