import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientMain {
    public static void main (String[] args){
        try{
            Socket socket = new Socket("127.0.0.1",8000);
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
