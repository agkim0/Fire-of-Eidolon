import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Room {
    public ArrayList<ObjectOutputStream> outs = new ArrayList<ObjectOutputStream>();
    public ArrayList<String> users = new ArrayList<String>();
    public GameData gameData;
    public String roomCode;

    public Room(GameData gameData) {
        this.gameData = gameData;
        if(!gameData.equals(null)){
            this.roomCode = gameData.getLobbyCode();
        }
    }

    public ArrayList<ObjectOutputStream> getOuts() {
        return outs;
    }

    public void setOuts(ArrayList<ObjectOutputStream> outs) {
        this.outs = outs;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }
}
