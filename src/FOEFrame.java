import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import javax.swing.*;
import java.util.ArrayList;

public class FOEFrame extends JFrame implements WindowFocusListener, KeyListener, Runnable{
    private String text = "";
    private String username;
    private Hero you;
    private static GameData gameDate = new GameData();
    ObjectInputStream os;
    private BufferedImage logo = null;

    private BufferedImage aelfric_Token = null;
    private BufferedImage aelfric_Action_Token = null;
    private BufferedImage aelfric_Special_Token = null;
    private BufferedImage aelfric_Character_Card = null;
    private BufferedImage cecelia_Token = null;
    private BufferedImage cecilia_Action_Token = null;
    private BufferedImage cecilia_Special_Token = null;
    private BufferedImage cecilia_Character_Card = null;
    private BufferedImage daga_Token = null;
    private BufferedImage daga_Action_Token = null;
    private BufferedImage daga_Special_Token = null;
    private BufferedImage daga_Character_Card = null;
    private BufferedImage kalistos_Token = null;
    private BufferedImage kalistos_Action_Token = null;
    private BufferedImage kalistos_Special_Token = null;
    private BufferedImage kalistos_Character_Card = null;
    private BufferedImage kaylana_Token = null;
    private BufferedImage kaylana_Action_Token = null;
    private BufferedImage kaylana_Special_Token = null;
    private BufferedImage kaylana_Character_Card = null;
    private BufferedImage sirius_Token = null;
    private BufferedImage sirius_Action_Token = null;
    private BufferedImage sirius_Special_Token = null;
    private BufferedImage sirius_Character_Card = null;
    private BufferedImage back_Of_CC = null;

    private BufferedImage difficulty_Levels = null;
    private BufferedImage df_Beginner = null;
    private BufferedImage df_Normal = null;
    private BufferedImage df_Extreme = null;
    private BufferedImage df_Glitch = null;
    private BufferedImage df_Hard = null;
    private BufferedImage df_Heroic = null;
    private BufferedImage df_Legendary = null;
    private BufferedImage df_Nightmare = null;
    private BufferedImage df_VeryHard = null;
    private BufferedImage scenario_1 = null;
    private BufferedImage scenario_2 = null;
    private BufferedImage scenario_3 = null;
    private BufferedImage scenario_4 = null;

    private BufferedImage back_Of_CT = null;
    private BufferedImage ct_AcidJets = null;
    private BufferedImage ct_ArrowTrap = null;
    private BufferedImage ct_DarkSlime = null;
    private BufferedImage ct_DenofSnakes = null;
    private BufferedImage ct_Dragonling = null;
    private BufferedImage ct_FelKnight = null;
    private BufferedImage ct_FOE = null;
    private BufferedImage ct_FloatingStones = null;
    private BufferedImage ct_HallofIlusions = null;
    private BufferedImage ct_LaughingShadow = null;
    private BufferedImage ct_LavaLake = null;
    private BufferedImage ct_MimicChest = null;
    private BufferedImage ct_Mindreader = null;
    private BufferedImage ct_Minotaur = null;
    private BufferedImage ct_OgerBrute = null;
    private BufferedImage ct_ParodoxPuzzle = null;
    private BufferedImage ct_PengulumBlades = null;
    private BufferedImage ct_Portal = null;
    private BufferedImage ct_Psycomancer = null;
    private BufferedImage ct_SPX = null;
    private BufferedImage ct_SPY = null;
    private BufferedImage ct_SkeletonGuards = null;
    private BufferedImage ct_SphynxsRiddle = null;
    private BufferedImage ct_SpikedPit = null;
    private BufferedImage ct_Vestibule = null;
    private BufferedImage ct_VoraciousPlant = null;
    private BufferedImage ct_VoraxsFocus = null;
    private BufferedImage getCt_VoraxsHeart = null;
    private BufferedImage ct_VoraxsKnowledge = null;

    private BufferedImage back_Of_RDC = null;
    private BufferedImage rdc_AcidJets = null;
    private BufferedImage rdc_ArrowTrap = null;
    private BufferedImage rdc_BlueEvent = null;
    private BufferedImage rdc_GreenEvent = null;
    private BufferedImage rdc_RedEvent = null;
    private BufferedImage rdc_DarkSlime = null;
    private BufferedImage rdc_DenofSnakes = null;
    private BufferedImage rdc_Dragonling = null;
    private BufferedImage rdc_FelKnight = null;
    private BufferedImage rdc_FloatingStones = null;
    private BufferedImage rdc_HallofIlusions = null;
    private BufferedImage rdc_LaughingShadow = null;
    private BufferedImage rdc_LavaLake = null;
    private BufferedImage rdc_MimicChest = null;
    private BufferedImage rdc_Mindreader = null;
    private BufferedImage rdc_Minotaur = null;
    private BufferedImage rdc_OgerBrute = null;
    private BufferedImage rdc_ParodoxPuzzle = null;
    private BufferedImage rdc_PengulumBlades = null;
    private BufferedImage rdc_Psycomancer = null;
    private BufferedImage rdc_SkeletonGuards = null;
    private BufferedImage rdc_SphynxsRiddle = null;
    private BufferedImage rdc_SpikedPit = null;
    private BufferedImage rdc_VoraciousPlant = null;

    private BufferedImage rb_1 = null;
    private BufferedImage rb_2 = null;
    private BufferedImage rb_3 = null;
    private BufferedImage rb_4 = null;
    private BufferedImage rb_5 = null;
    private BufferedImage rb_6 = null;
    private BufferedImage rb_7 = null;
    private BufferedImage rb_8 = null;
    private BufferedImage rb_9 = null;

    private BufferedImage book_Relic_Front = null;
    private BufferedImage book_Relic_Back = null;
    private BufferedImage crystal_Relic_Front = null;
    private BufferedImage crystal_Relic_Back = null;
    private BufferedImage heart_Relic_Front = null;
    private BufferedImage heart_Relic_Back = null;
    private BufferedImage cultist_Token = null;
    private BufferedImage dex_Token = null;
    private BufferedImage str_Token = null;
    private BufferedImage int_Token = null;
    private BufferedImage fireBall_Token = null;
    private BufferedImage tl_Token = null;
    private BufferedImage blueVorax_Token = null;
    private BufferedImage greenVorax_Token = null;
    private BufferedImage purpleVorax_Token = null;
    private BufferedImage redVorax_Token = null;

    private JButton btn_Host = new JButton("Host");
    private JButton btn_Join = new JButton("Join");
    private JButton btn_RB = new JButton("");

    public FOEFrame(/*GameDate gameDate,*/ ObjectInputStream os, String username) throws IOException {
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
        logo = ImageIO.read(new File("Game images/Fire of Eidolon Title.png"));
        aelfric_Token = ImageIO.read(new File("token pieces/character tokens/aelfric character token.png"));
        aelfric_Action_Token = ImageIO.read(new File())
        cecelia_Token = ImageIO.read(new File("token pieces/character tokens/cecelia character token.png"));
        daga_Token = ImageIO.read(new File("token pieces/character tokens/dage character token.png"));
        kalistos_Token = ImageIO.read(new File("token pieces/character tokens/kalistos character token.png"));
        kaylana_Token = ImageIO.read(new File("token pieces/character tokens/kaylana character token.png"));
        sirius_Token = ImageIO.read(new File("token pieces/character tokens/sirius character token.png"));

        btn_Host.setBounds(500,500,50,50);
        add(btn_Host);
        btn_Join.setBounds(400,400,50,50);
        add(btn_Join);
        btn_RB.setBounds(10,10,25,25);
        add(btn_RB);

    }
    public void reset(){
        System.out.println("reset");
        //character = new Hero();
        repaint();
    }
    public void paint(Graphics g){

    }
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
