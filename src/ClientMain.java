import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class ClientMain implements Serializable {
    public static void main (String[] args){
        try{
            Socket socket = new Socket("127.0.0.1",8000);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

            FOEFrame frame = new FOEFrame(os,null);
            ClientsListener cl = new ClientsListener(is,os,frame);
            Thread t = new Thread(cl);
            t.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
