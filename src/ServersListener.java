import java.io.*;
import java.util.ArrayList;

public class ServersListener implements Runnable, Serializable {
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private static ArrayList<GameData> gameDatas = new ArrayList<GameData>();
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

                if(cfc.getCommand()==CommandFromClient.HOSTING){
                    gameDatas.add(cfc.getGameData());
                }
                else if(cfc.getCommand()==CommandFromClient.CHECK_USERNAME){
                    System.out.println("Check username recieved");
                    if(cfc.getGameData().getUsernames().contains(cfc.getData())){
                        System.out.println("sending valid");
                        sendCommand(CommandFromServer.USERNAME_INVALID,null,null);
                    }
                    else{
                        System.out.println("sending valid");
                        sendCommand(CommandFromServer.USERNAME_VAlID,null,null);
                        cfc.getGameData().getUsernames().add(cfc.getData());
                    }
                }
                else if(cfc.getCommand()==CommandFromClient.LOBBY_CODE_ATTEMPT){
                    String[] x = cfc.getData().split(",",1);
                    String attemptCode = x[0];
                    String usernameAttempt = x[1];
                    boolean lobbycodefound = false;
                    for(GameData gd:gameDatas){
                        if(gd.getLobbyCode().equals(attemptCode)){
                            lobbycodefound=true;
                            if(gd.getUsernames().size() == gd.getNumOfPlayers()){
                                sendCommand(CommandFromServer.GAME_IS_FULL,null,null);
                                break;
                            }
                            if(gd.getUsernames().contains(usernameAttempt)){
                                sendCommand(CommandFromServer.USERNAME_INVALID,null,null);
                                break;
                            }
                            else{
                                gd.getUsernames().add(usernameAttempt);
                                sendCommand(CommandFromServer.LOBBY_CODE_VALID,usernameAttempt,gd);
                            }
                        }
                    }
                    if(!lobbycodefound){
                        sendCommand(CommandFromServer.LOBBY_CODE_INVALID,null,null);
                    }
                }

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
