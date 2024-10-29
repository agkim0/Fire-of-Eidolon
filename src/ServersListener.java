import java.io.*;
import java.util.ArrayList;

public class ServersListener implements Runnable, Serializable {
    private boolean acceptedName;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    private static ArrayList<ObjectOutputStream> outs = new ArrayList<>();
    private Room room;
    public ServersListener (ObjectInputStream is, ObjectOutputStream os, Room room){
        this.is = is;
        this.os = os;
        this.room = room;
        if(room!=null){
//            System.out.println(room.getUsers().toString());
//            System.out.println("Adding room");
            rooms.add(room);
            room.getOuts().add(os);
        }
        outs.add(os);
    }

    @Override
    public void run(){
        while(true){
            try{
                CommandFromClient cfc = (CommandFromClient) is.readObject();
                if(cfc.getCommand()==CommandFromClient.LOBBY_CODE_ATTEMPT){
                    String[] x = cfc.getData().split(",",2);
                    String attemptCode = x[0];
                    String usernameAttempt = x[1];
                    boolean lobbycodefound = false;
                    for(Room r:rooms){
                        if(r.getGameData().getLobbyCode().equals(attemptCode)){
                            lobbycodefound=true;
                            if(r.getUsers().size() == r.getGameData().getNumOfPlayers()){
                                sendCommand(CommandFromServer.GAME_IS_FULL,null,null);
                                break;
                            }
                            System.out.println(r.getUsers());
                            if(r.getUsers().contains(usernameAttempt)){
                                sendCommand(CommandFromServer.USERNAME_INVALID,null,null);
                                break;
                            }
                            else{
                                room = r;
                                System.out.println(usernameAttempt+" valid");
                                acceptedName = true;
                                room.getUsers().add(usernameAttempt);
                                room.getGameData().getUsernames().add(usernameAttempt);
                                sendCommand(CommandFromServer.LOBBY_CODE_AND_USERNAME_VALID,usernameAttempt,room.getGameData());
                                room.getOuts().add(os);
                                serverMessage(usernameAttempt+ " has joined the game!");
                                sendCommandtoAllUsers(CommandFromServer.NEW_USER_JOINED,null,room.getGameData());
                                break;
                            }
                        }
                    }
                    if(!lobbycodefound){
                        sendCommand(CommandFromServer.LOBBY_CODE_INVALID,null,null);
                    }
                }
                else if(cfc.getCommand()==CommandFromClient.LOBBY_FULL){
                    sendCommandtoAllUsers(CommandFromServer.CHARACTER_SELECTION_STARTING,null,room.getGameData());
                }
                else if(cfc.getCommand()==CommandFromClient.HERO_SELECTED){
                    String x[] = cfc.getData().split(",",2);
                    String user = x[1];
                    String wantedCharacter=x[0];
                    System.out.println("Wanted Character: "+cfc.getData());
                    boolean taken=true;
                    if(wantedCharacter.equals("Aelfric")){
                        if(room.getGameData().getAelfricPlayer().equals("")){
                            taken = false;
                            room.getGameData().setAelfricPlayer(user);
                            room.getGameData().getHeroesPlaying().add(GameData.AELFRIC);
                        }
                    }
                    else if(wantedCharacter.equals("Cecelia")){
                        if(room.getGameData().getCeceliaPlayer().equals("")){
                            taken = false;
                            System.out.println("Player taking C: "+user);
                            room.getGameData().setCeceliaPlayer(user);
                            room.getGameData().getHeroesPlaying().add(GameData.CECELIA);
                        }
                    }
                    else if(wantedCharacter.equals("Daga")){
                        if(room.getGameData().getDagaPlayer().equals("")){
                            taken = false;
                            room.getGameData().setDagaPlayer(user);
                            room.getGameData().getHeroesPlaying().add(GameData.DAGA);
                        }
                    }
                    else if(wantedCharacter.equals("Kalistos")){
                        if(room.getGameData().getKalistosPlayer().equals("")){
                            taken = false;
                            room.getGameData().setKalistosPlayer(user);
                            room.getGameData().getHeroesPlaying().add(GameData.KALISTOS);
                        }
                    }
                    else if(wantedCharacter.equals("Kaylana")){
                        if(room.getGameData().getKaylanaPlayer().equals("")){
                            taken = false;
                            room.getGameData().setKaylanaPlayer(user);
                            room.getGameData().getHeroesPlaying().add(GameData.KAYLANA);
                        }
                    }
                    else if(wantedCharacter.equals("Sirius")){
                        if(room.getGameData().getSiriusPlayer().equals("")){
                            taken = false;
                            room.getGameData().setSiriusPlayer(user);
                            room.getGameData().getHeroesPlaying().add(GameData.SIRIUS);
                        }
                    }
                    if(taken){
                        System.out.println("Character Was Taken");
                        sendCommand(CommandFromServer.CHARACTER_TAKEN,"Character Taken",null);
                    }
                    else{
                        System.out.println("Character Untaken");
                        sendCommand(CommandFromServer.CHARACTER_UNTAKEN,null,room.getGameData());
                        sendCommandtoAllUsers(CommandFromServer.CHARACTER_SELECTED,user+" has selected "+cfc.getData(),room.getGameData());
                        if(room.getGameData().getNumOfPlayers()==room.getGameData().getHeroesPlaying().size()){
                            sendCommandtoAllUsers(CommandFromServer.START_GAME,null,room.getGameData());
                        }
                    }
                }
                else if(cfc.getCommand()==CommandFromClient.MSG){
                    sendCommandtoAllUsers(CommandFromServer.MESSAGE,cfc.getData(),null);
                }
                else if(cfc.getCommand()==CommandFromClient.ACTION){
                    sendCommandtoAllUsers(CommandFromServer.ACTION,null,cfc.getGameData());
                }
                else if(cfc.getCommand()==CommandFromClient.END_TURN){
                    if(room.getGameData().getOrderOfTurnIndex()+1==room.getGameData().getOrderOfTurns().size()){
                        room.getGameData().setOrderOfTurnIndex(0);
                    }
                    else{
                        room.getGameData().setOrderOfTurnIndex(room.getGameData().getOrderOfTurnIndex()+1);
                    }
                    
                    room.getGameData().setTurn(room.getGameData().getOrderOfTurns().get(room.getGameData().getOrderOfTurnIndex()));
                    sendCommandtoAllUsers(CommandFromServer.ENDTURN,null,room.getGameData());
                }
                else if(cfc.getCommand()==CommandFromClient.DIVE){
                    room.setGameData(cfc.getGameData());
                    sendCommandtoAllUsers(CommandFromServer.DIVE,cfc.getData(),cfc.getGameData());
                }
                else if (cfc.getCommand()==CommandFromClient.DOVE){
                    room.setGameData(cfc.getGameData());
                    if(cfc.getGameData().getPlayersNeedingDive().size()==0){
                        room.getGameData().
                    }
                    sendCommandtoAllUsers();
                }
                else if(cfc.getCommand()==CommandFromClient.END_CULTIST_TURN){
                    sendCommandtoAllUsers(CommandFromServer.END_CULTIST_TURN,cfc.getData(),cfc.getGameData());
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void sendCommand(int com, String data, GameData gameData){
        CommandFromServer cfs = new CommandFromServer(com,data,gameData);
        try{
            os.writeObject(cfs);
            os.reset();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sendCommandtoAllUsers(int com, String data, GameData gameData){
        CommandFromServer cfs = new CommandFromServer(com,data,gameData);
        for(ObjectOutputStream o: room.getOuts()){
            try{
                o.writeObject(cfs);
                o.reset();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void serverMessage(String msg){
        room.getGameData().getMsgs().add("Server: "+msg);
        sendCommandtoAllUsers(CommandFromServer.MESSAGE,"Server: "+msg,room.getGameData());
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
