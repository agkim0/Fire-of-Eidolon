import java.io.Serializable;

public class CommandFromServer implements Serializable {
    private int command;
    private String data="";
    private GameData gameData;
    public static final int LOBBY_CODE_INVALID = 1;
    public static final int LOBBY_CODE_AND_USERNAME_VALID = 2;
    public static final int JOINING_HOST_GAME = 3;
    public static final int CHARACTER_SELECTED = 4;
    public static final int ACTION = 5;
    public static final int MESSAGE = 6;
    public static final int EXCHANGE = 7;
    public static final int ENDTURN = 8;
    public static final int USERNAME_VAlID = 9;
    public static final int USERNAME_INVALID = 10;
    public static final int GAME_IS_FULL = 11;
    public static final int NEW_USER_JOINED = 12;
    public static final int CHARACTER_SELECTION_STARTING = 13;
    public static final int CHARACTER_TAKEN=14;
    public static final int CHARACTER_UNTAKEN=15;
    public static final int START_GAME=16;
    public static final int DIVE=17;
    public static final int END_CULTIST_TURN=18;



    public CommandFromServer(int command, String data, GameData gameData){
        this.command = command;
        this.data = data;
        this.gameData = gameData;
    }

    public int getCommand() {
        return command;
    }

    public String getData() {
        return data;
    }

    public GameData getGameData() {
        return gameData;
    }
}
