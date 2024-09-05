import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import javax.swing.*;
import java.util.ArrayList;

public class FOEFrame extends JFrame implements WindowFocusListener, KeyListener, Runnable{
    private String text = "";
    private String username;
    //private Character character = "";
    //private GameData gameDate = new GameDate;
    ObjectInputStream os;
    private BufferedImage logo = null;
    private BufferedImage aelfric_Token = null;
    private BufferedImage cecelia_Token = null;
    private BufferedImage daga_Token = null;
    private BufferedImage kalistos_Token = null;
    private BufferedImage kaylana_Token = null;
    private BufferedImage sirius_Token = null;
    private JButton btn_Host = new JButton("Host");
    private JButton btn_Join = new JButton("Join");
    private JButton btn_RB = new JButton("");

    public FOEFrame(/*GameDate gameDate,*/ ObjectInputStream os, String username){
        super("FOE Game");
        //this.gameDate = gameDate;
        this.os = os;
        this.username = username;
        addKeyListener(this);
        addWindowFocusListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
        logo = ImageIO.read(new File(""));
        btn_Host.setBounds(500,500,50,50);
        add(btn_Host);
        btn_Join.setBounds(400,400,50,50);
        add(btn_Join);
        btn_RB.setBounds(10,10,25,25);
        add(btn_RB);

    }
    public void paint(Graphics g){}
    public void move(){}
    public void explore(){}
    public void attack(){}
    public void challenge(){}
    public void wait_A(){}
    public void skill(){}
    public void message(){}
    public void sendCommand(){}

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void windowGainedFocus(WindowEvent e) {

    }
    @Override
    public void windowLostFocus(WindowEvent e) {

    }
    @Override
    public void run() {

    }
}
