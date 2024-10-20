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
                    System.out.println("USERNAME_INVALID");
                    frame.usernameValid(false);
                }
                if(cfs.getCommand()==CommandFromServer.LOBBY_CODE_INVALID){
                    System.out.println("LOBBY_CODE_INVALID");
                    frame.lobbyCodeValid(false);
                }
                if(cfs.getCommand()==CommandFromServer.LOBBY_CODE_AND_USERNAME_VALID){
                    System.out.println("LOBBY_CODE_AND_USERNAME_VALID");
                    frame.setGameData(cfs.getGameData());
                    frame.usernameValid(true);
//                    frame.both(true);
                }
                if(cfs.getCommand()==CommandFromServer.GAME_IS_FULL){
                    frame.gameFull(true);
                }

                if(cfs.getCommand()==CommandFromServer.NEW_USER_JOINED){
                    //make screen say that new user joined in chat
                    frame.setGameData(cfs.getGameData());
                }
                if(cfs.getCommand()==CommandFromServer.CHARACTER_SELECTION_STARTING){
                    //method for character selection screen
                    frame.setGameData(cfs.getGameData());
                    frame.charactersetUpScreen();
                }
                if(cfs.getCommand()==CommandFromServer.CHARACTER_TAKEN){
                    frame.setGameData(cfs.getGameData());
                    frame.heroSelected(false);
                }
                if(cfs.getCommand()==CommandFromServer.CHARACTER_UNTAKEN){
                    frame.setGameData(cfs.getGameData());
                    frame.heroSelected(true);
                }
                if(cfs.getCommand()==CommandFromServer.CHARACTER_SELECTED){
                    frame.setGameData(cfs.getGameData());
                }
                if(cfs.getCommand()==CommandFromServer.MESSAGE){
                    frame.recieveMsg(cfs.getData());
                }
                if(cfs.getCommand()==CommandFromServer.START_GAME){
                    frame.setGameData(cfs.getGameData());
                    frame.makeGameScreen();
                }
                if(cfs.getCommand()==CommandFromServer.ACTION){
                    frame.setGameData(cfs.getGameData());
                    frame.repaintPanel();
                }
                if(cfs.getCommand()==CommandFromServer.ENDTURN){
                    frame.setGameData(cfs.getGameData());
                    frame.repaintPanel();
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
