import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main (String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8000);
            while(true){
                Socket socket = serverSocket.accept();
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());


                CommandFromClient cfc = (CommandFromClient) is.readObject();
                if(cfc.getCommand()==CommandFromClient.HOSTING){
                    Room r = new Room(cfc.getGameData());
                    r.getUsers().add(cfc.getData());

                    ServersListener sl = new ServersListener(is,os,r);
                    Thread t = new Thread(sl);
                    t.start();

                }
                else{
                    ServersListener sl = new ServersListener(is,os,null);
                    Thread t = new Thread(sl);
                    t.start();
                }
            }
        }catch(Exception e){
          e.printStackTrace();
        }

    }
}
