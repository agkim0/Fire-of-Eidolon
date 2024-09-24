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
                    frame.usernameValid(false);
                }
                if(cfs.getCommand()==CommandFromServer.USERNAME_VAlID){
                    frame.usernameValid(true);
                    frame.setGameData(cfs.getGameData());
                }
                if(cfs.getCommand()==CommandFromServer.LOBBY_CODE_INVALID){
                    frame.lobbyCodeValid(false);
                }
                if(cfs.getCommand()==CommandFromServer.LOBBY_CODE_VALID){
                    frame.setGameData(cfs.getGameData());
                    frame.checkUsername();
                }
                if(cfs.getCommand()==CommandFromServer.GAME_IS_FULL){
                    frame.gameFull(true);
                }
                if(cfs.getCommand()==CommandFromServer.NEW_USER_JOINED){
                    //make screen say that new user joined in chat
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
