import java.io.Serializable;

public class CommandFromClient implements Serializable {
    private int command;
    private String data;
    public static final int CONNECTED = 1;
    public static final int HOSTING = 2;
    public static final int JOINING_HOST_GAME = 3;
    public static final int LOBBY_CODE_ATTEMPT = 4;
    public static final int CHARACTER_SELECTED = 5;
    public static final int ACTION = 6;
    public static final int EXCHANGE = 7;
    public static final int END_TURN = 8;

    public CommandFromClient(int command, String data) {
        this.command = command;
        this.data = data;
    }

    public int getCommand() {
        return command;
    }

    public String getData() {
        return data;
    }
}