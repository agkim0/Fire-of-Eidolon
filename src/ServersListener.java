import java.io.*;
import java.util.ArrayList;

public class ServersListener implements Runnable, Serializable {
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private static GameData gameData = new GameData();
    private static ArrayList<ObjectOutputStream> outs = new ArrayList<>();
    public ServersListener (ObjectInputStream is, ObjectOutputStream os){
        this.is = is;
        this.os = os;
        outs.add(os);
    }

    @Override
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
        CommandFromServer cfs = new CommandFromServer(com,data,gameData);
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
