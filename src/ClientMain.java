import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class ClientMain implements Serializable {
    public static void main (String[] args){
        try{
            Socket socket = new Socket("127.0.0.1",8001);
            //10.195.75.145 audrey's school computer
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
//            GameData gameData = new GameData(null);
            String username = "";
            FOEFrame frame = new FOEFrame(os);
            ClientsListener cl = new ClientsListener(is,os,frame,username);
            Thread t = new Thread(cl);
            t.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
