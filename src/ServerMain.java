import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
                    System.out.println("host connected in");
                    Room r = new Room(cfc.getGameData());
                    r.getUsers().add(cfc.getData());
                    r.getGameData().getUsernames().add(cfc.getData());

                    ServersListener sl = new ServersListener(is,os,r);
                    sl.serverMessage(cfc.getData()+" has started the lobby!");
                    Thread t = new Thread(sl);
                    t.start();

                }
                else if(cfc.getCommand()==CommandFromClient.JOINING_HOST_GAME){
                    System.out.println("non host");
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
