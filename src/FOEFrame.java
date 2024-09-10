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
    private Hero you;
    private static GameData gameData = new GameData();
    ObjectOutputStream os;
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
    private BufferedImage ct_VoraxsHeart = null;
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
    private JTextArea text_numOfPlayersBox = new JTextArea("1");
    private JTextArea text_numOfPlayersLabel = new JTextArea("Number of Players");
    private JButton btn_numOfPlayersDecrease = new JButton("<");
    private JButton btn_numOfPlayersIncrease = new JButton(">");
    private JButton btn_gameRuleAddedCheckBox = new JButton("");

    public FOEFrame(/*GameDate gameDate,*/ ObjectOutputStream os) throws IOException{
        super("FOE Game");
        //this.gameDate = gameDate;
        this.os = os;
        addKeyListener(this);
        addWindowFocusListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
        logo = ImageIO.read(new File("Game images/Fire of Eidolon Title.png"));

        aelfric_Token = ImageIO.read(new File("token pieces/character tokens/aelfric character token.png"));
        aelfric_Action_Token = ImageIO.read(new File("character cards/aelfric action.png"));
        aelfric_Special_Token = ImageIO.read(new File("character cards/aelfric special.png"));
        aelfric_Character_Card = ImageIO.read(new File("character cards/aelfric character card.png"));
        cecelia_Token = ImageIO.read(new File("token pieces/character tokens/cecelia character token.png"));
        cecilia_Action_Token = ImageIO.read(new File("character cards/cecilia action.png"));
        cecilia_Special_Token = ImageIO.read(new File("character cards/cecilia special.png"));
        cecilia_Character_Card = ImageIO.read(new File("character cards/cecilia character card.png"));
        daga_Token = ImageIO.read(new File("token pieces/character tokens/dage character token.png"));
        daga_Action_Token = ImageIO.read(new File("character cards/dage action.png"));
        daga_Special_Token = ImageIO.read(new File("character cards/dage special.png"));
        daga_Character_Card = ImageIO.read(new File("character cards/dage character card.png"));
        kalistos_Token = ImageIO.read(new File("token pieces/character tokens/kalistos character token.png"));
        kalistos_Action_Token = ImageIO.read(new File("character cards/kalistos action.png"));
        kalistos_Special_Token = ImageIO.read(new File("character cards/kalistos special.png"));
        kalistos_Character_Card = ImageIO.read(new File("character cards/kalistos character card.png"));
        kaylana_Token = ImageIO.read(new File("token pieces/character tokens/kaylana character token.png"));
        kaylana_Action_Token = ImageIO.read(new File("character cards/kaylana action.png"));
        kaylana_Special_Token = ImageIO.read(new File("character cards/kaylana special.png"));
        kaylana_Character_Card = ImageIO.read(new File("character cards/kaylana character card.png"));
        sirius_Token = ImageIO.read(new File("token pieces/character tokens/sirius character token.png"));
        sirius_Action_Token = ImageIO.read(new File("character cards/sirius action.png"));
        sirius_Special_Token = ImageIO.read(new File("character cards/sirius special.png"));
        sirius_Character_Card = ImageIO.read(new File("character cards/sirius character card.png"));
        back_Of_CC = ImageIO.read(new File("character cards/Hero Card Back Side.png"));//token images

        difficulty_Levels = ImageIO.read(new File("difficulty cards/difficulty levels.png"));
        df_Beginner = ImageIO.read(new File("difficulty cards/beginner difficulty card.png"));
        df_Normal = ImageIO.read(new File("difficulty cards/normal difficulty card.png"));
        df_Extreme = ImageIO.read(new File("difficulty cards/extreme.png"));
        df_Glitch = ImageIO.read(new File("difficulty cards/glitch"));
        df_Hard = ImageIO.read(new File("difficulty cards/hard"));
        df_Heroic = ImageIO.read(new File("difficulty cards/heroic"));
        df_Legendary = ImageIO.read(new File("difficulty cards/legendary"));
        df_Nightmare = ImageIO.read(new File("difficulty cards/nightmare"));
        df_VeryHard = ImageIO.read(new File("difficulty cards/very hard"));
        scenario_1 = ImageIO.read(new File("difficulty cards/scenario 1.png"));
        scenario_2 = ImageIO.read(new File("difficulty cards/scenario 2.png"));
        scenario_3 = ImageIO.read(new File("difficulty cards/scenario 3.png"));
        scenario_4 = ImageIO.read(new File("difficulty cards/scenario 4.png"));//difficulty and secnario images

        ct_AcidJets = ImageIO.read(new File("Game images/Chamber Tiles/Acid jets.png"));
        ct_ArrowTrap = ImageIO.read(new File("Game images/Chamber Tiles/Arrow Trap.png"));
        back_Of_CT = ImageIO.read(new File("Game images/Chamber Tiles/Acid jets.png"));
        ct_DarkSlime = ImageIO.read(new File("Game images/Chamber Tiles/Dark Slime.png"));
        ct_DenofSnakes = ImageIO.read(new File("Game images/Chamber Tiles/Den of Snakes.png"));
        ct_Dragonling = ImageIO.read(new File("Game images/Chamber Tiles/Dragonling.png"));
        ct_FelKnight = ImageIO.read(new File("Game images/Chamber Tiles/Fel Knight.png"));
        ct_FOE = ImageIO.read(new File("Game images/Chamber Tiles/Fire of Eidolon.png"));
        ct_FloatingStones = ImageIO.read(new File("Game images/Chamber Tiles/Floating Stones.png"));
        ct_HallofIlusions = ImageIO.read(new File("Game images/Chamber Tiles/Hall of Ilusions.png"));
        ct_LaughingShadow = ImageIO.read(new File("Game images/Chamber Tiles/Laughing Shadow.png"));
        ct_LavaLake = ImageIO.read(new File("Game images/Chamber Tiles/Laval Lake.png"));
        ct_MimicChest = ImageIO.read(new File("Game images/Chamber Tiles/Mimic Chest.png"));
        ct_Mindreader = ImageIO.read(new File("Game images/Chamber Tiles/Mindreader.png"));
        ct_Minotaur = ImageIO.read(new File("Game images/Chamber Tiles/Minotaur.png"));
        ct_OgerBrute = ImageIO.read(new File("Game images/Chamber Tiles/Oger Brute.png"));
        ct_ParodoxPuzzle = ImageIO.read(new File("Game images/Chamber Tiles/Paradox puzzle.png"));
        ct_PengulumBlades = ImageIO.read(new File("Game images/Chamber Tiles/Pengulum Blades.png"));
        ct_Portal = ImageIO.read(new File("Game images/Chamber Tiles/Portal.png"));
        ct_Psycomancer = ImageIO.read(new File("Game images/Chamber Tiles/Psychomancer.png"));
        ct_SPX = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage X.png.png"));
        ct_SPY = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage Y.png"));
        ct_SkeletonGuards = ImageIO.read(new File("Game images/Chamber Tiles/Skeleton Guards.png"));
        ct_SphynxsRiddle = ImageIO.read(new File("Game images/Chamber Tiles/Sphynx_s Riddle.png"));
        ct_SpikedPit = ImageIO.read(new File("Game images/Chamber Tiles/Spiked pit.png"));
        ct_Vestibule = ImageIO.read(new File("Game images/Chamber Tiles/Start.png"));
        ct_VoraciousPlant = ImageIO.read(new File("Game images/Chamber Tiles/Voracious Plant.png"));
        ct_VoraxsFocus = ImageIO.read(new File("Game images/Chamber Tiles/Vorax_s Focus.png"));
        ct_VoraxsHeart = ImageIO.read(new File("Game images/Chamber Tiles/Vorax_s Heart.png"));
        ct_VoraxsKnowledge = ImageIO.read(new File("Game images/Chamber Tiles/Vorax_s Knowledge.png"));//chamber tiles


        btn_Host.setBounds(500,500,50,50);
        add(btn_Host);
        btn_Join.setBounds(400,400,50,50);
        add(btn_Join);
        btn_RB.setBounds(10,10,25,25);
        add(btn_RB);



    }

    public void removeEverythingFromScreen(){
        btn_Host.setVisible(false);
        btn_Join.setVisible(false);
        btn_RB.setVisible(false);
        btn_gameRuleAddedCheckBox.setVisible(false);
        btn_numOfPlayersDecrease.setVisible(false);
        btn_numOfPlayersIncrease.setVisible(false);
        text_numOfPlayersBox.setVisible(false);
        text_numOfPlayersLabel.setVisible(false);
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

    public void host(){

    }
}
