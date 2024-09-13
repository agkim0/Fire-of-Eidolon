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
                if(cfs.getCommand()==CommandFromServer.USERNAME_INVALID){
                    frame.setUsernameValid(false);
                }
                if(cfs.getCommand()==CommandFromServer.USERNAME_VAlID){
                    frame.setUsernameValid(true);
                    frame.setGameData(cfs.getGameData());
                }
                if(cfs.getCommand()==CommandFromServer.LOBBY_CODE_INVALID){
                    frame.setLobbycodevalid(false);
                }
                if(cfs.getCommand()==CommandFromServer.LOBBY_CODE_VALID){
                    frame.setGameData(cfs.getGameData());
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void sendCommand(int com, String data, GameData gameData){
        CommandFromClient cfc = new CommandFromClient(com,data,gameData);
            try{
                os.writeObject(cfc);
            }catch (Exception e){
                e.printStackTrace();
            }

    }
}
