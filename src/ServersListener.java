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
            rooms.add(room);
        }
        outs.add(os);
    }

    @Override
    public void run(){
        while(true){
            System.out.println("new server thread going.");
            try{
                CommandFromClient cfc = (CommandFromClient) is.readObject();
                System.out.println("I just read "+cfc);

//                if(cfc.getCommand()==CommandFromClient.CHECK_USERNAME){
////                    System.out.println("Check username recieved");
////                    System.out.println(cfc.getGameData().getNumOfPlayers());
//                    if(cfc.getGameData().getUsernames().contains(cfc.getData())){
//                        System.out.println("sending valid");
//                        sendCommand(CommandFromServer.USERNAME_INVALID,null,null);
//                    }
//                    else{
//                        System.out.println("sending valid");
//                        sendCommand(CommandFromServer.USERNAME_VAlID,null,null);
//                    }
//                }
                if(cfc.getCommand()==CommandFromClient.LOBBY_CODE_ATTEMPT){
                    System.out.println("LOBBY_CODE_ATTEMPT");
                    String[] x = cfc.getData().split(",",2);
                    System.out.println("length: "+x.length);
                    String attemptCode = x[0];
                    System.out.println(attemptCode);
                    String usernameAttempt = x[1];
                    boolean lobbycodefound = false;
                    for(Room r:rooms){
                        System.out.println("curr: "+r.getGameData().getLobbyCode()+"            attemptCode: "+attemptCode);
                        if(r.getGameData().getLobbyCode().equals(attemptCode)){
                            lobbycodefound=true;
                            System.out.println(usernameAttempt+" found room");
                            if(r.getUsers().size() == r.getGameData().getNumOfPlayers()){
                                sendCommand(CommandFromServer.GAME_IS_FULL,null,null);
                                break;
                            }
                            System.out.println(r.getUsers());
                            if(r.getUsers().contains(usernameAttempt)){
                                System.out.println(usernameAttempt+" invalid username");
                                sendCommand(CommandFromServer.USERNAME_INVALID,null,null);
                                break;
                            }
                            else{
                                room = r;
                                System.out.println(usernameAttempt+" valid");
                                acceptedName = true;
                                r.getUsers().add(usernameAttempt);
                                r.getGameData().getUsernames().add(usernameAttempt);
                                System.out.println("Users: "+r.getGameData().getUsernames());
                                sendCommand(CommandFromServer.LOBBY_CODE_AND_USERNAME_VALID,usernameAttempt,r.getGameData());
                                r.getOuts().add(os);
                                sendCommandtoAllUsers(CommandFromServer.NEW_USER_JOINED,null,r.getGameData());
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
