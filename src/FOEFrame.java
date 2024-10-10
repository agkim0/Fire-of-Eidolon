import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.server.ExportException;
import java.text.AttributedCharacterIterator;
import java.util.Collection;
import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FOEFrame extends JFrame implements WindowFocusListener, KeyListener, Runnable{

    //player and game info
    private Hero you;
    String username;
    private GameData gameData;
    private FOEPanel foePanel;
    ObjectOutputStream os;

    public static final int TP = 0;//title page
    public static final int RB = 1;//rulebook
    public static final int SUG = 2;//set up game
    public static final int HLS = 3;//host lobby screen
    public static final int JOIN = 4;//join
    public static final int SUC = 5;//set up characters
    public static final int GAME = 6;//the game
    public static final int CC = 7;//character card
    public static final int WIN = 8;
    public static final int LOSE = 9;


    //start up screen
    private JButton btn_Host = new JButton("Host");
    private JButton btn_Join = new JButton("Join");
    private JButton btn_RB = new JButton("");

    //host set up screen
    private JButton btn_backToHome = new JButton("Back to Home");
    private JButton btn_startLobby = new JButton("Start Lobby");
    private JButton btn_backGameScenario = new JButton("<");
    private JButton btn_forwardGameScenario = new JButton(">");
    private JCheckBox checkbox_GameScenarioSelected = new JCheckBox();
    private JButton btn_lowerDifficulty = new JButton("^");
    private JButton btn_raiseDifficulty = new JButton("v");
    private ArrayList<String> difficultyLevel = new ArrayList<>();
    private int difficultyLevelIndex = 0;
    private JLabel text_numOfPlayersBox = new JLabel("1",JLabel.CENTER);
    private JButton btn_numOfPlayersDecrease = new JButton("<");
    private JButton btn_numOfPlayersIncrease = new JButton(">");
    private JButton btn_gameRuleAddedCheckBox = new JButton("");
    private ArrayList<String> gameRuleSlides = new ArrayList<>();
    private int gameRuleSlidesIndex = 0;

    //username and lobby screen
    private JTextField textBox_getUsername = new JTextField();
    private JLabel text_roomCode = new JLabel();
    private JTextField textBox_getRoomCode = new JTextField();
    private JButton btn_checkRoomCode = new JButton("o");

    private ArrayList<String> characterCards = new ArrayList<>();
    private int ccLevelIndex = 0;

    //chat box
    private JTextField msgBox = new JTextField();
    private JList msgList = new JList(new ArrayList<String>().toArray());
    private JScrollPane msgScroll = new JScrollPane(msgList,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JButton btn_sendMsg = new JButton("send");

    //Character Selection screen
    private JButton btn_selectCharacter = new JButton("Select");
    private BufferedImage aelfric_Token = null;
    private BufferedImage cecelia_Token = null;
    private BufferedImage daga_Token = null;
    private BufferedImage kalistos_Token = null;
    private BufferedImage kaylana_Token = null;
    private BufferedImage sirius_Token = null;
    private JButton btn_aelfric = new JButton();
    private JButton btn_cecilia = new JButton();
    private JButton btn_daga = new JButton();
    private JButton btn_kalistos = new JButton();
    private JButton btn_kaylana = new JButton();
    private JButton btn_sirius = new JButton();
    private String currSelectedHero;
    public static final Hero AELFRIC = new Hero("Aelfric",1,2,3,0,0,0,false,false,false,false,3,false);
    public static final Hero CECELIA = new Hero("Cecilia",1,3,2,0,0,0,false,false,false,false,3,false);
    public static final Hero DAGA = new Hero("Daga",2,3,1,0,0,0,false,false,false,false,3,false);
    public static final Hero KALISTOS = new Hero("Kalistos",3,1,2,0,0,0,false,false,false,false,3,false);
    public static final Hero KAYLANA = new Hero("Kaylana",2,1,3,0,0,0,false,false,false,false,3,false);
    public static final Hero SIRIUS = new Hero("Sirius",3,2,1,0,0,0,false,false,false,false,3,false);

    //Rulebook
    private JButton btn_rulebookLEFT = new JButton("<");
    private JButton btn_rulebookRIGHT = new JButton(">");
    private JButton btn_rbBack = new JButton("Back");
    private JTextField tf_pgnl = new JTextField();
    private JTextField tf_pgnr = new JTextField();
    private boolean paintRuleBook = false;
    private boolean flipRB12 = false;
    private boolean flipRB34 = false;
    private boolean flipRB56 = false;
    private boolean flipRB78 = false;
    private boolean flipRB9 = false;
    private int before;
    private int currentPage;

    private boolean[] enabled = {true,true,true,true,true,true};

    private JButton btn_cc = new JButton("-O-");
    //private TextField tf_action = new TextField();

    //actual game screen
    private ArrayList allA = new ArrayList<String>();
    private JList actions = new JList(allA.toArray());
    private JButton btn_aelfaction = new JButton();
    private JButton btn_aelfspec = new JButton();
    private JButton btn_ceciaction = new JButton();
    private JButton btn_cecispec = new JButton();
    private JButton btn_dagaaction = new JButton();
    private JButton btn_dagaspec = new JButton();
    private JButton btn_kaliaction = new JButton();
    private JButton btn_kalispec = new JButton();
    private JButton btn_kaylaaction = new JButton();
    private JButton btn_kaylaspec = new JButton();
    private JButton btn_siriaction = new JButton();
    private JButton btn_sirispec = new JButton();
    private JButton btn_screenUp = new JButton();
    private JButton btn_screenDown = new JButton();
    private JButton btn_screenRight = new JButton();
    private JButton btn_screenLeft = new JButton();
    private JButton btn_rot90 = new JButton("90");
    private BufferedImage aelfric_Action_Token = null;
    private BufferedImage aelfric_Special_Token = null;
    private BufferedImage cecelia_Action_Token = null;
    private BufferedImage cecelia_Special_Token = null;
    private BufferedImage daga_Action_Token = null;
    private BufferedImage daga_Special_Token = null;
    private BufferedImage kalistos_Action_Token = null;
    private BufferedImage kalistos_Special_Token = null;
    private BufferedImage kaylana_Action_Token = null;
    private BufferedImage kaylana_Special_Token = null;
    private BufferedImage sirius_Action_Token = null;
    private BufferedImage sirius_Special_Token = null;
    private BufferedImage buffer;

    //Character info screen
    private JButton btn_backcc = new JButton("<");
    private JButton btn_frontcc = new JButton(">");
    private JButton btn_backfromcc = new JButton("Back");
    private int ind = 0;


    public FOEFrame(ObjectOutputStream os) throws IOException{
        super("FOE Game");
        this.gameData = new GameData();;
        this.os = os;
        you=AELFRIC;
        addKeyListener(this);
        addWindowFocusListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1500,1000);
        buffer = new BufferedImage(1500,100,BufferedImage.TYPE_4BYTE_ABGR);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
        setLayout(null);
        //looking at character card screen
        btn_cc.setBounds(150,10,100,100);
        add(btn_cc);
        btn_backfromcc.setBounds(25,25,100,50);
        add(btn_backfromcc);
        btn_backcc.setBounds(425,275,50,50);
        add(btn_backcc);
        btn_frontcc.setBounds(1075,275,50,50);
        add(btn_frontcc);

        //host set up screen
        btn_startLobby.setBounds(50,550,300,75);
        add(btn_startLobby);
        btn_backToHome.setBounds(50,650,300,75);
        add(btn_backToHome);
        text_numOfPlayersBox.setBounds(825,250,150,150);
        add(text_numOfPlayersBox);
        btn_numOfPlayersDecrease.setBounds(738,288,75,75);
        add(btn_numOfPlayersDecrease);
        btn_numOfPlayersIncrease.setBounds(1000,288,75,75);
        add(btn_numOfPlayersIncrease);
        btn_backGameScenario.setBounds(355,688,75,75);
        add(btn_backGameScenario);
        btn_forwardGameScenario.setBounds(995,688,75,75);
        add(btn_forwardGameScenario);
        checkbox_GameScenarioSelected.setBounds(700,500,50,50);
        add(checkbox_GameScenarioSelected);
        btn_lowerDifficulty.setBounds(1233,170,75,75);
        add(btn_lowerDifficulty);
        btn_raiseDifficulty.setBounds(1238,800,75,75);
        add(btn_raiseDifficulty);
        difficultyLevel.add("Beginner");
        difficultyLevel.add("Normal");
        difficultyLevel.add("Hard");
        difficultyLevel.add("Very Hard");
        difficultyLevel.add("Extreme");
        difficultyLevel.add("Heroic");
        difficultyLevel.add("Nightmare");
        difficultyLevel.add("Legendary");
        difficultyLevel.add("Glitch");
        gameRuleSlides.add("Unstable Void");
        gameRuleSlides.add("Vagrant Portal");
        gameRuleSlides.add("Invasion of the Shadow Cult");
        gameRuleSlides.add("Shades of Vorax");
        characterCards.add("Aelfric");
        characterCards.add("Cecilia");
        characterCards.add("Daga");
        characterCards.add("Kalistos");
        characterCards.add("Kaylana");
        characterCards.add("Sirius");

        //username and lobby code screen
        text_roomCode.setBounds(700,425,300,50);
        add(text_roomCode);
        textBox_getUsername.setBounds(700,50,300,50);
        add(textBox_getUsername);
        textBox_getRoomCode.setBounds(700,550,300,50);
        add(textBox_getRoomCode);
        btn_checkRoomCode.setBounds(1200,575,200,50);
        add(btn_checkRoomCode);

        //character selection
        btn_selectCharacter.setBounds(575,650,300,75);
        add(btn_selectCharacter);
        aelfric_Token = ImageIO.read(new File("token pieces/character tokens/aelfric character token(Fix).png"));
        cecelia_Token = ImageIO.read(new File("token pieces/character tokens/cecelia character token(Fix).png"));
        daga_Token = ImageIO.read(new File("token pieces/character tokens/daga character token(Fix).png"));
        kalistos_Token = ImageIO.read(new File("token pieces/character tokens/kalistos character token(Fix).png"));
        kaylana_Token = ImageIO.read(new File("token pieces/character tokens/kaylana character token(Fix).png"));
        sirius_Token = ImageIO.read(new File("token pieces/character tokens/sirius character token(Fix).png"));
        btn_aelfric = new JButton(new ImageIcon(aelfric_Token));
        btn_aelfric.setBorderPainted(false);
        btn_aelfric.setFocusPainted(false);
        btn_aelfric.setContentAreaFilled(false);
        btn_aelfric.setBounds(100,100,100,100);
        add(btn_aelfric);
        btn_cecilia = new JButton(new ImageIcon(cecelia_Token));
        btn_cecilia.setBorderPainted(false);
        btn_cecilia.setFocusPainted(false);
        btn_cecilia.setContentAreaFilled(false);
        btn_cecilia.setBounds(100,200,100,100);
        add(btn_cecilia);
        btn_daga = new JButton(new ImageIcon(daga_Token));
        btn_daga.setBorderPainted(false);
        btn_daga.setFocusPainted(false);
        btn_daga.setContentAreaFilled(false);
        btn_daga.setBounds(100,300,100,100);
        add(btn_daga);
        btn_kalistos = new JButton(new ImageIcon(kalistos_Token));
        btn_kalistos.setBorderPainted(false);
        btn_kalistos.setFocusPainted(false);
        btn_kalistos.setContentAreaFilled(false);
        btn_kalistos.setBounds(100,400,100,100);
        add(btn_kalistos);
        btn_kaylana = new JButton(new ImageIcon(kaylana_Token));
        btn_kaylana.setBorderPainted(false);
        btn_kaylana.setFocusPainted(false);
        btn_kaylana.setContentAreaFilled(false);
        btn_kaylana.setBounds(100,500,100,100);
        add(btn_kaylana);
        btn_sirius = new JButton(new ImageIcon(sirius_Token));
        btn_sirius.setBorderPainted(false);
        btn_sirius.setFocusPainted(false);
        btn_sirius.setContentAreaFilled(false);
        btn_sirius.setBounds(100,600,100,100);
        add(btn_sirius);

        //chatBox
        msgBox.setBounds(1200,900,200,50);
        add(msgBox);
        btn_sendMsg.setBounds(1400,900,50,50);
        add(btn_sendMsg);
        ArrayList<String> msgTest = new ArrayList<>();
        this.gameData = new GameData();
        gameData.setMsgs(msgTest);
        msgList.setListData(gameData.getMsgs().toArray());
        msgScroll.setBounds(1200,600,250,250);
        add(msgScroll);

        //rulebook
        tf_pgnl.setBounds(10,850,75,75);
        add(tf_pgnl);
        tf_pgnr.setBounds(1360,850,75,75);
        add(tf_pgnr);
        btn_rulebookLEFT.setBounds(10,500,75,75);
        add(btn_rulebookLEFT);
        btn_rulebookRIGHT.setBounds(1375,500,75,75);
        add(btn_rulebookRIGHT);
        btn_rbBack.setBounds(10,10,75,75);
        add(btn_rbBack);
        btn_Host.setBounds(900,400,300,75);
        add(btn_Host);
        btn_Join.setBounds(900,500,300,75);
        add(btn_Join);
        btn_RB.setBounds(10,10,100,100);
        add(btn_RB);

        //panel
        foePanel = new FOEPanel();
        foePanel.setBounds(0,0,1500,1000);
        add(foePanel);

        //game screen
        allA.add("move");
        allA.add("explore");
        allA.add("exchange");
        allA.add("attack");
        allA.add("wait");
        allA.add("challenge");
        allA.add("skill");
        actions.setListData(allA.toArray());
        actions.setBounds(24,188,200,150);
        add(actions);
        aelfric_Action_Token = ImageIO.read(new File("character cards/aelfric action.png"));
        aelfric_Special_Token = ImageIO.read(new File("character cards/aelfric special.png"));
        cecelia_Action_Token = ImageIO.read(new File("character cards/cecelia action.png"));
        cecelia_Special_Token = ImageIO.read(new File("character cards/cecelia special.png"));
        daga_Action_Token = ImageIO.read(new File("character cards/daga action.png"));
        daga_Special_Token = ImageIO.read(new File("character cards/daga special.png"));
        kalistos_Action_Token = ImageIO.read(new File("character cards/kalistos action.png"));
        kalistos_Special_Token = ImageIO.read(new File("character cards/kalistos special.png"));
        kaylana_Action_Token = ImageIO.read(new File("character cards/kaylana action.png"));
        kaylana_Special_Token = ImageIO.read(new File("character cards/kaylana special.png"));
        sirius_Action_Token = ImageIO.read(new File("character cards/sirius action.png"));
        sirius_Special_Token = ImageIO.read(new File("character cards/sirius special.png"));
        btn_aelfaction = new JButton(new ImageIcon(aelfric_Action_Token));
        btn_aelfaction.setBorderPainted(false);
        btn_aelfaction.setFocusPainted(false);
        btn_aelfaction.setContentAreaFilled(false);
        btn_aelfaction.setBounds(900,750,125,125);
        add(btn_aelfaction);
        btn_aelfspec = new JButton(new ImageIcon(aelfric_Special_Token));
        btn_aelfspec.setBorderPainted(false);
        btn_aelfspec.setFocusPainted(false);
        btn_aelfspec.setContentAreaFilled(false);
        btn_aelfspec.setBounds(900,850,125,125);
        add(btn_aelfspec);
        btn_ceciaction = new JButton(new ImageIcon(cecelia_Action_Token));
        btn_ceciaction.setBorderPainted(false);
        btn_ceciaction.setFocusPainted(false);
        btn_ceciaction.setContentAreaFilled(false);
        btn_ceciaction.setBounds(900,750,125,125);
        add(btn_ceciaction);
        btn_cecispec = new JButton(new ImageIcon(cecelia_Special_Token));
        btn_cecispec.setBorderPainted(false);
        btn_cecispec.setFocusPainted(false);
        btn_cecispec.setContentAreaFilled(false);
        btn_cecispec.setBounds(900,850,125,125);
        add(btn_cecispec);
        btn_kaliaction = new JButton(new ImageIcon(kalistos_Action_Token));
        btn_kaliaction.setBorderPainted(false);
        btn_kaliaction.setFocusPainted(false);
        btn_kaliaction.setContentAreaFilled(false);
        btn_kaliaction.setBounds(900,750,125,125);
        add(btn_kaliaction);
        btn_kalispec = new JButton(new ImageIcon(kalistos_Special_Token));
        btn_kalispec.setBorderPainted(false);
        btn_kalispec.setFocusPainted(false);
        btn_kalispec.setContentAreaFilled(false);
        btn_kalispec.setBounds(900,850,125,125);
        add(btn_kalispec);
        btn_kaylaaction = new JButton(new ImageIcon(kaylana_Action_Token));
        btn_kaylaaction.setBorderPainted(false);
        btn_kaylaaction.setFocusPainted(false);
        btn_kaylaaction.setContentAreaFilled(false);
        btn_kaylaaction.setBounds(900,750,125,125);
        add(btn_kaylaaction);
        btn_kaylaspec = new JButton(new ImageIcon(kaylana_Special_Token));
        btn_kaylaspec.setBorderPainted(false);
        btn_kaylaspec.setFocusPainted(false);
        btn_kaylaspec.setContentAreaFilled(false);
        btn_kaylaspec.setBounds(900,850,125,125);
        add(btn_kaylaspec);
        btn_dagaaction = new JButton(new ImageIcon(daga_Action_Token));
        btn_dagaaction.setBorderPainted(false);
        btn_dagaaction.setFocusPainted(false);
        btn_dagaaction.setContentAreaFilled(false);
        btn_dagaaction.setBounds(900,750,125,125);
        add(btn_dagaaction);
        btn_dagaspec = new JButton(new ImageIcon(daga_Special_Token));
        btn_dagaspec.setBorderPainted(false);
        btn_dagaspec.setFocusPainted(false);
        btn_dagaspec.setContentAreaFilled(false);
        btn_dagaspec.setBounds(900,850,125,125);
        add(btn_dagaspec);
        btn_siriaction = new JButton(new ImageIcon(sirius_Action_Token));
        btn_siriaction.setBorderPainted(false);
        btn_siriaction.setFocusPainted(false);
        btn_siriaction.setContentAreaFilled(false);
        btn_siriaction.setBounds(900,750,125,125);
        add(btn_siriaction);
        btn_sirispec = new JButton(new ImageIcon(sirius_Special_Token));
        btn_sirispec.setBorderPainted(false);
        btn_sirispec.setFocusPainted(false);
        btn_sirispec.setContentAreaFilled(false);
        btn_sirispec.setBounds(900,850,125,125);
        add(btn_sirispec);

        btn_screenUp.setBounds(715,10,100,50);
        add(btn_screenUp);
        btn_screenDown.setBounds(715,885,100,50);
        add(btn_screenDown);
        btn_screenRight.setBounds(1175,445,100,50);
        add(btn_screenRight);
        btn_screenLeft.setBounds(255,445,100,50);
        add(btn_screenLeft);
        btn_rot90.setBounds(25,360,100,50);
        add(btn_rot90);
//        btn_rot180.setBounds(150,375,100,50);
//        add(btn_rot180);
//        btn_rot270.setBounds(25,450,100,50);
//        add(btn_rot270);
//        btn_rot360.setBounds(150,450,100,50);
//        add(btn_rot360);




        btn_selectCharacter.addActionListener(e->{selectHero();});
        btn_aelfric.addActionListener(e->{aelfricSelect();});
        btn_cecilia.addActionListener(e->{ceceliaSelect();});
        btn_daga.addActionListener(e->{dagaSelect();});
        btn_kalistos.addActionListener(e->{kalistosSelect();});
        btn_kaylana.addActionListener(e->{kaylanaSelect();});
        btn_sirius.addActionListener(e->{siriusSelect();});
        btn_backToHome.addActionListener(e->{
            backToHome();
        });
        btn_Host.addActionListener(e->{
            before = currentPage;
            currentPage = SUG;
            host();
        });
        btn_Join.addActionListener(e->{
            before = currentPage;
            currentPage = JOIN;
            join();
        });
        btn_startLobby.addActionListener(e->{
            startLobby();
        });
        btn_RB.addActionListener(e->{
            before = currentPage;
            currentPage = RB;
            drawRuleBook();
        });
        btn_rbBack.addActionListener(e -> {
            rbReturn();
        });
        btn_rulebookLEFT.addActionListener(e->{
            rbleft();
        });
        btn_rulebookRIGHT.addActionListener(e->{
            rbright();
        });
        btn_numOfPlayersIncrease.addActionListener(e->{numOfPlayersIncrease();});
        btn_numOfPlayersDecrease.addActionListener(e->{numOfPlayersDecrease();});
        btn_backGameScenario.addActionListener(e->{backGameScenario();});
        btn_forwardGameScenario.addActionListener(e->{forwardGameScenario();});
        btn_lowerDifficulty.addActionListener(e->{lowerDifficulty();});
        btn_raiseDifficulty.addActionListener(e->{raiseDifficulty();});
        btn_checkRoomCode.addActionListener(e->{checkRoomCode();});

        btn_sendMsg.addActionListener(e->{sendMsg();});
        backToHome();
        currentPage = TP;
        before = -1;
        btn_cc.addActionListener(e->{chCa();});
        btn_backcc.addActionListener(e->{
            //System.out.println("Start bcc");
            bcc();});
        btn_frontcc.addActionListener(e->{
            //System.out.println("Start fcc");
            fcc();});
        btn_backfromcc.addActionListener(e->{
            makeGameScreen();
        });

        Thread t = new Thread(this);
        t.start();
    }

    public void removeEverythingFromScreen(){
        btn_rulebookLEFT.setVisible(false);
        btn_rulebookRIGHT.setVisible(false);
        actions.setVisible(false);
        btn_frontcc.setVisible(false);
        btn_backcc.setVisible(false);
        btn_backfromcc.setVisible(false);
        btn_cc.setVisible(false);
        btn_rot90.setVisible(false);
//        btn_rot180.setVisible(false);
//        btn_rot270.setVisible(false);
//        btn_rot360.setVisible(false);
        btn_screenUp.setVisible(false);
        btn_screenDown.setVisible(false);
        btn_screenRight.setVisible(false);
        btn_screenLeft.setVisible(false);
        //tf_action.setVisible(false);
        btn_aelfaction.setVisible(false);
        btn_aelfspec.setVisible(false);
        btn_ceciaction.setVisible(false);
        btn_cecispec.setVisible(false);
        btn_dagaaction.setVisible(false);
        btn_dagaspec.setVisible(false);
        btn_kaliaction.setVisible(false);
        btn_kalispec.setVisible(false);
        btn_kaylaaction.setVisible(false);
        btn_kaylaspec.setVisible(false);
        btn_siriaction.setVisible(false);
        btn_sirispec.setVisible(false);

        btn_aelfric.setVisible(false);
        btn_cecilia.setVisible(false);
        btn_kalistos.setVisible(false);
        btn_kaylana.setVisible(false);
        btn_sirius.setVisible(false);
        btn_daga.setVisible(false);
        btn_selectCharacter.setVisible(false);
        btn_Host.setVisible(false);
        btn_Join.setVisible(false);
        btn_RB.setVisible(false);
        btn_gameRuleAddedCheckBox.setVisible(false);
        btn_numOfPlayersDecrease.setVisible(false);
        btn_numOfPlayersIncrease.setVisible(false);
        text_numOfPlayersBox.setVisible(false);
        btn_backGameScenario.setVisible(false);
        btn_forwardGameScenario.setVisible(false);
        btn_backToHome.setVisible(false);
        btn_startLobby.setVisible(false);
        btn_lowerDifficulty.setVisible(false);
        btn_raiseDifficulty.setVisible(false);
        checkbox_GameScenarioSelected.setVisible(false);

        textBox_getUsername.setVisible(false);
        text_roomCode.setVisible(false);
        textBox_getRoomCode.setVisible(false);
        btn_checkRoomCode.setVisible(false);
        btn_rulebookLEFT.setVisible(false);
        btn_rulebookLEFT.setVisible(false);
        btn_rbBack.setVisible(false);
        tf_pgnl.setVisible(false);
        tf_pgnr.setVisible(false);

        msgBox.setVisible(false);
        btn_sendMsg.setVisible(false);
        msgScroll.setVisible(false);
        msgList.setVisible(false);
    }
    public void sendCommand(int com, String data, GameData gameData){
        CommandFromClient cfc = new CommandFromClient(com,data,gameData);
        try{
            System.out.println("writing"+cfc);
            os.writeObject(cfc);
            System.out.println("wrote"+cfc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //host methods
    public void host(){
        removeEverythingFromScreen();
        gameData = new GameData();
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setHostGameSetUpScreen(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setDrawrulebook(false);
        btn_RB.setVisible(true);
        textBox_getUsername.setBounds(700,50,300,50);
        textBox_getUsername.setVisible(true);
        text_numOfPlayersBox.setVisible(true);
        text_numOfPlayersBox.setOpaque(true);
        btn_numOfPlayersIncrease.setVisible(true);
        btn_numOfPlayersDecrease.setVisible(true);
        btn_raiseDifficulty.setVisible(true);
        btn_lowerDifficulty.setVisible(true);
        btn_backToHome.setBounds(50,650,300,75);
        btn_backToHome.setVisible(true);
        btn_startLobby.setVisible(true);
        btn_backGameScenario.setVisible(true);
        btn_forwardGameScenario.setVisible(true);
        checkbox_GameScenarioSelected.setVisible(true);

        foePanel.setShowUnstableVoid(true);
        gameRuleSlidesIndex = 0;
        gameData.setUnstableVoid(false);
        gameData.setVagrantPortal(false);
        gameData.setInvasionOfTheShadowCult(false);
        gameData.setShadesOfVorax(false);
        gameData.setDifficultyLevel("Beginner");
        repaintPanel();
    }
    public void numOfPlayersDecrease(){
        if(!text_numOfPlayersBox.getText().equals("1")){
            text_numOfPlayersBox.setText((Integer.parseInt(text_numOfPlayersBox.getText())-1)+"");
        }
        gameData.setNumOfPlayers(Integer.parseInt(text_numOfPlayersBox.getText()));
    }
    public void numOfPlayersIncrease(){
        if(!text_numOfPlayersBox.getText().equals("6")){
            text_numOfPlayersBox.setText((Integer.parseInt(text_numOfPlayersBox.getText())+1)+"");
        }
        gameData.setNumOfPlayers(Integer.parseInt(text_numOfPlayersBox.getText()));
    }
    public void backGameScenario(){
        if(checkbox_GameScenarioSelected.isSelected()){
            if(gameRuleSlidesIndex == 0){
                gameData.setUnstableVoid(true);
            }
            if(gameRuleSlidesIndex == 1){
                gameData.setVagrantPortal(true);
            }
            if(gameRuleSlidesIndex == 2){
                gameData.setInvasionOfTheShadowCult(true);
            }
            if(gameRuleSlidesIndex == 3){
                gameData.setShadesOfVorax(true);
            }
        }
        else{
            if(gameRuleSlidesIndex == 0){
                gameData.setUnstableVoid(false);
            }
            if(gameRuleSlidesIndex == 1){
                gameData.setVagrantPortal(false);
            }
            if(gameRuleSlidesIndex == 2){
                gameData.setInvasionOfTheShadowCult(false);
            }
            if(gameRuleSlidesIndex == 3){
                gameData.setShadesOfVorax(false);
            }
        }
        if(gameRuleSlidesIndex-1>=0){
            gameRuleSlidesIndex-=1;
        }
        else{
            gameRuleSlidesIndex=3;
        }
        if(gameRuleSlidesIndex == 0){
            foePanel.setShowUnstableVoid(true);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            foePanel.setShowShadesOfVorax(false);
            if(gameData.isUnstableVoid()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }
        if(gameRuleSlidesIndex == 1){
            foePanel.setShowVagrantPortal(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            foePanel.setShowShadesOfVorax(false);
            if(gameData.isVagrantPortal()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }
        if(gameRuleSlidesIndex == 2){
            foePanel.setShowInvasionOfTheShadowCult(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowShadesOfVorax(false);
            if(gameData.isInvasionOfTheShadowCult()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }
        if(gameRuleSlidesIndex == 3){
            foePanel.setShowShadesOfVorax(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            if(gameData.isShadesOfVorax()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }

        repaintPanel();
    }
    public void forwardGameScenario(){
        if(checkbox_GameScenarioSelected.isSelected()){
            if(gameRuleSlidesIndex == 0){
                gameData.setUnstableVoid(true);
            }
            if(gameRuleSlidesIndex == 1){
                gameData.setVagrantPortal(true);
            }
            if(gameRuleSlidesIndex == 2){
                gameData.setInvasionOfTheShadowCult(true);
            }
            if(gameRuleSlidesIndex == 3){
                gameData.setShadesOfVorax(true);
            }
        }
        else{
            if(gameRuleSlidesIndex == 0){
                gameData.setUnstableVoid(false);
            }
            if(gameRuleSlidesIndex == 1){
                gameData.setVagrantPortal(false);
            }
            if(gameRuleSlidesIndex == 2){
                gameData.setInvasionOfTheShadowCult(false);
            }
            if(gameRuleSlidesIndex == 3){
                gameData.setShadesOfVorax(false);
            }
        }
        if(gameRuleSlidesIndex+1<4){
            gameRuleSlidesIndex+=1;
        }
        else{
            gameRuleSlidesIndex=0;
        }
        if(gameRuleSlidesIndex == 0){
            foePanel.setShowUnstableVoid(true);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            foePanel.setShowShadesOfVorax(false);
            if(gameData.isUnstableVoid()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }
        if(gameRuleSlidesIndex == 1){
            foePanel.setShowVagrantPortal(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            foePanel.setShowShadesOfVorax(false);
            if(gameData.isVagrantPortal()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }
        if(gameRuleSlidesIndex == 2){
            foePanel.setShowInvasionOfTheShadowCult(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowShadesOfVorax(false);
            if(gameData.isInvasionOfTheShadowCult()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }
        if(gameRuleSlidesIndex == 3){
            foePanel.setShowShadesOfVorax(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            if(gameData.isShadesOfVorax()){
                checkbox_GameScenarioSelected.setSelected(true);
            }
            else{
                checkbox_GameScenarioSelected.setSelected(false);
            }
        }

        repaintPanel();
    }
    public void lowerDifficulty(){
        if(difficultyLevelIndex>0){
            difficultyLevelIndex--;
        }
        else{
            difficultyLevelIndex = difficultyLevel.size()-1;
        }
        gameData.setDifficultyLevel(difficultyLevel.get(difficultyLevelIndex));
        repaintPanel();
    }
    public void raiseDifficulty(){
        if(difficultyLevelIndex<difficultyLevel.size()){
            difficultyLevelIndex++;
        }
        else{
            difficultyLevelIndex = 0;
        }
        gameData.setDifficultyLevel(difficultyLevel.get(difficultyLevelIndex));
        repaintPanel();
    }
    public void startLobby(){
        before = currentPage;
        currentPage = HLS;
        if(!textBox_getUsername.getText().equals("")){
            gameData.setNumOfPlayers(Integer.parseInt(text_numOfPlayersBox.getText()));
            username = textBox_getUsername.getText();
            sendCommand(CommandFromClient.HOSTING,username,gameData);
            removeEverythingFromScreen();
            foePanel.setGameData(gameData);
            foePanel.setSetUpJoinScreen(false);
            foePanel.setDrawTitlePage(false);
            foePanel.setCharacterselectscreen(false);
            foePanel.setHostGameSetUpScreen(false);
            foePanel.setSetUpJoinScreen(false);
            foePanel.setHostRoomCodeScreen(true);
            repaintPanel();
            //text_roomCode.setBounds(1150,25,300,30);
            text_roomCode.setVisible(true);
            text_roomCode.setOpaque(true);
            text_roomCode.setText(gameData.getLobbyCode());
            msgBox.setVisible(true);
            btn_sendMsg.setVisible(true);
            msgList.setVisible(true);
            msgScroll.setVisible(true);
        }
        else{
            textBox_getUsername.setText("Please Enter Username");
        }
        if(gameData.getNumOfPlayers()==1){
            sendCommand(CommandFromClient.LOBBY_FULL,null,gameData);
        }


        //textBox_getUsername.setVisible(true);
    }

    //join methods
    public void join(){
        removeEverythingFromScreen();
        foePanel.setDrawrulebook(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setSetUpJoinScreen(true);
        repaintPanel();
        textBox_getUsername.setBounds(700,450,300,50);
        textBox_getUsername.setVisible(true);
        textBox_getRoomCode.setVisible(true);
        btn_checkRoomCode.setVisible(true);
        btn_backToHome.setBounds(50,500,300,75);
        btn_backToHome.setVisible(true);

    }
    public void checkRoomCode(){
        boolean tf = true;
        if(textBox_getRoomCode.getText().equals("")){
            textBox_getRoomCode.setText("Please Enter Room Code");
            tf=false;
        }
        if(textBox_getUsername.getText().equals("")){
            textBox_getUsername.setText("Please Enter Username");
            tf=false;
        }
        if(tf){
            System.out.println(textBox_getRoomCode.getText()+","+textBox_getUsername.getText());
            sendCommand(CommandFromClient.JOINING_HOST_GAME,textBox_getRoomCode.getText()+","+textBox_getUsername.getText(),gameData);
            sendCommand(CommandFromClient.LOBBY_CODE_ATTEMPT,textBox_getRoomCode.getText()+","+textBox_getUsername.getText(),gameData);
        }

    }
    public void lobbyCodeValid(boolean valid){
        if(!valid){
            textBox_getRoomCode.setText("Lobby Not Found");
        }
    }
    public void gameFull(boolean full){
        if(full){
            textBox_getRoomCode.setText("Lobby Full");
        }
    }
    public void usernameValid(boolean valid){
        System.out.println("usernamehelpter: "+text_numOfPlayersBox.getText());
        if(valid){
            username = textBox_getUsername.getText();
            System.out.println("valid");
            btn_checkRoomCode.setVisible(false);
            textBox_getUsername.setEnabled(false);
            text_roomCode.setEnabled(false);
            btn_RB.setVisible(true);
            msgBox.setVisible(true);
            btn_sendMsg.setVisible(true);
            msgList.setVisible(true);
            msgScroll.setVisible(true);
            msgList.setListData(gameData.getMsgs().toArray());
            if(gameData.getNumOfPlayers()==gameData.getUsernames().size()){
                sendCommand(CommandFromClient.LOBBY_FULL,null,gameData);
            }
        }
        else{
            textBox_getUsername.setText("Username Taken");
        }
    }

    //chat box methods
    public void sendMsg(){
        String msg = msgBox.getText();
        msgBox.setText("");
        sendCommand(CommandFromClient.MSG,username+": "+msg,gameData);
    }
    public void recieveMsg(){
        msgList.setListData(gameData.getMsgs().toArray());
    }

    //character selection methods
    public void charactersetUpScreen(){
        before = currentPage;
        currentPage = SUC;
        removeEverythingFromScreen();
        btn_RB.setVisible(true);
        btn_selectCharacter.setVisible(true);
        for(int x=0; x<gameData.getHeroesPlaying().size(); x++){
            if(gameData.getHeroesPlaying().get(x).getName().equals("Aelfric")){
                btn_aelfric.setEnabled(false);
                enabled[0] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Cecilia")){
                btn_cecilia.setEnabled(false);
                enabled[1] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Daga")){
                btn_daga.setEnabled(false);
                enabled[2] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Kalistos")){
                btn_kalistos.setEnabled(false);
                enabled[3] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Kaylana")){
                btn_kaylana.setEnabled(false);
                enabled[4] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Sirius")){
                btn_sirius.setEnabled(false);
                enabled[5] = false;
            }
        }
        for(int y=0; y<enabled.length; y++){
            if(enabled[y] == true){
                foePanel.setCurHero(y);
                break;
            }
        }
        foePanel.setDrawrulebook(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostRoomCodeScreen(false);
        foePanel.setCharacterselectscreen(true);
        foePanel.repaint();
        currSelectedHero="Aelfric";
        btn_aelfric.setVisible(true);
        btn_cecilia.setVisible(true);
        btn_kalistos.setVisible(true);
        btn_kaylana.setVisible(true);
        btn_sirius.setVisible(true);
        btn_daga.setVisible(true);
        btn_RB.setVisible(true);
        msgBox.setVisible(true);
        btn_sendMsg.setVisible(true);
        msgList.setVisible(true);
        msgScroll.setVisible(true);
        msgList.setListData(gameData.getMsgs().toArray());
    }
    public void aelfricSelect(){
        checkselectedcc();
        you = AELFRIC;
        System.out.println("selected aelfric");
        foePanel.setCurHero(0);
        foePanel.setCharacterselectscreen(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.repaint();
        currSelectedHero = "Aelfric";
        if(!gameData.getAelfricPlayer().equals("")){
            btn_selectCharacter.setText("taken");
            btn_selectCharacter.setEnabled(false);
        }
        else{
            btn_selectCharacter.setEnabled(true);
            btn_selectCharacter.setText("Select");
        }
    }
    public void ceceliaSelect(){
        you = CECELIA;
        System.out.println("selected cecilia");
        foePanel.setCurHero(1);
        foePanel.setCharacterselectscreen(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.repaint();
        currSelectedHero = "Cecelia";
        if(!gameData.getCeceliaPlayer().equals("")){
            btn_selectCharacter.setText("taken");
            btn_selectCharacter.setEnabled(false);
        }
        else{
            btn_selectCharacter.setEnabled(true);
            btn_selectCharacter.setText("Select");
        }
    }
    public void dagaSelect(){
        you = DAGA;
        System.out.println("selected daga");
        foePanel.setCurHero(2);
        foePanel.setCharacterselectscreen(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.repaint();
        currSelectedHero = "Daga";
        if(!gameData.getDagaPlayer().equals("")){
            btn_selectCharacter.setText("taken");
            btn_selectCharacter.setEnabled(false);
        }
        else{
            btn_selectCharacter.setEnabled(true);
            btn_selectCharacter.setText("Select");
        }
    }
    public void kalistosSelect(){
        you = KALISTOS;
        System.out.println("selected kalistos");
        foePanel.setCurHero(3);
        foePanel.setCharacterselectscreen(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.repaint();
        currSelectedHero = "Kalistos";
        if(!gameData.getKalistosPlayer().equals("")){
            btn_selectCharacter.setText("taken");
            btn_selectCharacter.setEnabled(false);
        }
        else{
            btn_selectCharacter.setEnabled(true);
            btn_selectCharacter.setText("Select");
        }
    }
    public void kaylanaSelect(){
        you = KAYLANA;
        //System.out.println("selected kaylana");
        foePanel.setCurHero(4);
        foePanel.setCharacterselectscreen(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.repaint();
        currSelectedHero = "Kaylana";
        if(!gameData.getKaylanaPlayer().equals("")){
            btn_selectCharacter.setText("taken");
            btn_selectCharacter.setEnabled(false);
        }
        else{
            btn_selectCharacter.setEnabled(true);
            btn_selectCharacter.setText("Select");
        }
    }
    public void siriusSelect(){
        you = SIRIUS;
        System.out.println("selected sirius");
        foePanel.setCurHero(5);
        foePanel.setCharacterselectscreen(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.repaint();
        currSelectedHero = "Sirius";
        if(!gameData.getSiriusPlayer().equals("")){
            btn_selectCharacter.setText("taken");
            btn_selectCharacter.setEnabled(false);
        }
        else{
            btn_selectCharacter.setEnabled(true);
            btn_selectCharacter.setText("Select");
        }
    }
    public void selectHero(){

        sendCommand(CommandFromClient.HERO_SELECTED,currSelectedHero+","+username,gameData);
    }
    public void heroSelected(boolean selected){
        if(selected){
            btn_selectCharacter.setEnabled(false);
            System.out.println(foePanel.getCurHero());
            String name = "";
            if(foePanel.getCurHero() == 0){
                name = "Aelfric";
            }
            else if(foePanel.getCurHero() == 1){
                name = "Cecilia";
            }
            else if(foePanel.getCurHero() == 2){
                name = "Daga";
            }
            else if(foePanel.getCurHero() == 3){
                name = "Kalistos";
            }
            else if(foePanel.getCurHero() == 4){
                name = "Kaylana";
            }
            else if(foePanel.getCurHero() == 5){
                name = "Sirius";
            }
            for(int x=0; x<gameData.getAllHeroes().size(); x++){
                if(gameData.getAllHeroes().get(x).equals(name)){
                    gameData.addHeroesPlaying(gameData.getAllHeroes().get(x));
                    you = gameData.getAllHeroes().get(x);
                    break;
                }
            }
            enabled[foePanel.getCurHero()] = false;
            btn_aelfric.setEnabled(false);
            btn_cecilia.setEnabled(false);
            btn_daga.setEnabled(false);
            btn_kalistos.setEnabled(false);
            btn_kaylana.setEnabled(false);
            btn_sirius.setEnabled(false);
            btn_selectCharacter.setEnabled(false);
            btn_selectCharacter.setVisible(false);
        }
        else{
            btn_selectCharacter.setText("Character Taken");
        }
    }
    public void checkselectedcc(){
        for(int x=0; x<gameData.getHeroesPlaying().size(); x++){
            if(gameData.getHeroesPlaying().get(x).getName().equals("Aelfric")){
                btn_aelfric.setEnabled(false);
                enabled[0] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Cecilia")){
                btn_cecilia.setEnabled(false);
                enabled[1] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Daga")){
                btn_daga.setEnabled(false);
                enabled[2] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Kalistos")){
                btn_kalistos.setEnabled(false);
                enabled[3] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Kaylana")){
                btn_kaylana.setEnabled(false);
                enabled[4] = false;
            }
            else if(gameData.getHeroesPlaying().get(x).getName().equals("Sirius")){
                btn_sirius.setEnabled(false);
                enabled[5] = false;
            }
        }
        /*for(int y=0; y<enabled.length; y++){
            if(enabled[y] == true){
                foePanel.setCurHero(y);
                break;
            }
        }*/
    }

//    public void paint(Graphics g)
//    {
//        Graphics bg = buffer.getGraphics();
//        super.paint(bg);
//        BufferedImage temp =buffer = new BufferedImage(actions.getWidth(),actions.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
//        actions.paint(temp.getGraphics());
//        //System.out.println("x"+actions.getX());
//        bg.drawImage(temp,actions.getX(),actions.getY(),null);
//        g.drawImage(buffer,24,188,null);
//    }

    //rulebook methods
    public void drawRuleBook(){
        currentPage = RB;
        removeEverythingFromScreen();
        tf_pgnl.setVisible(true);
        tf_pgnr.setVisible(true);
        tf_pgnl.setText("1");
        tf_pgnr.setText("2");
        tf_pgnr.setEnabled(false);
        tf_pgnl.setEnabled(false);
        btn_rbBack.setVisible(true);
        btn_rbBack.setEnabled(true);
        btn_rulebookLEFT.setVisible(true);
        btn_rulebookLEFT.setEnabled(false);
        btn_rulebookRIGHT.setVisible(true);
        btn_rulebookRIGHT.setEnabled(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setGamescreen(false);
        foePanel.setRbNum(tf_pgnl.getText());
        foePanel.setDrawrulebook(true);
        foePanel.repaint();
    }
    public void rbleft(){
        //System.out.print("rb left");
        String temp = tf_pgnl.getText();
        int lpn = parseInt(temp);
        flipRB(lpn,"left");
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setRbNum(tf_pgnl.getText());
        foePanel.setDrawrulebook(true);
        foePanel.repaint();
    }
    public void rbright(){
        //System.out.print("rb right");
        String temp = tf_pgnl.getText();
        int lpn = parseInt(temp);
        flipRB(lpn,"right");
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setRbNum(tf_pgnl.getText());
        foePanel.setDrawrulebook(true);
        foePanel.repaint();
    }
    public void flipRB(int lpn, String dir){
        if(lpn == 1 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("3");
            tf_pgnr.setText("4");
        }
        else if(lpn == 3 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("5");
            tf_pgnr.setText("6");
        }
        else if(lpn == 3 && dir.equals("left")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(false);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("1");
            tf_pgnr.setText("2");
        }
        else if(lpn == 5 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("7");
            tf_pgnr.setText("8");
        }
        else if(lpn == 5 && dir.equals("left")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("3");
            tf_pgnr.setText("4");
        }
        else if(lpn == 7 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(false);
            tf_pgnl.setText("9");
            tf_pgnr.setText(" ");
        }
        else if(lpn == 7 && dir.equals("left")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("5");
            tf_pgnr.setText("6");
        }
        else if(lpn == 9 && dir.equals("left")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("7");
            tf_pgnr.setText("8");
        }
    }
    public void rbReturn(){
        if(before == TP)
        {
            backToHome();
        }
        else if(before == SUG){
            host();
        }
        else if(before == JOIN){
            join();
        }
        else if(before == SUC){
            charactersetUpScreen();
        }
        else if(before == GAME){
            makeGameScreen();
        }
    }


    //character card methods
    public void chCa(){
        removeEverythingFromScreen();
        ind = 0;
        btn_backcc.setVisible(true);
        btn_frontcc.setVisible(true);
        btn_backfromcc.setVisible(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostRoomCodeScreen(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setGamescreen(false);
        foePanel.setCcscreen(true);
        foePanel.setInd(ind);
        foePanel.repaint();
        System.out.println("Index: "+ind);
    }
    public void bcc(){
        System.out.println("Index Bef: "+ind);
        if(ind==0){
            ind=gameData.getHeroesPlaying().size()-1;
        }
        else{
            System.out.println("Index Bef: "+ind);
            ind-=1;
        }
        System.out.println("Index aft: "+ind);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostRoomCodeScreen(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setGamescreen(false);
        foePanel.setInd(ind);
        foePanel.setCcscreen(true);
        foePanel.repaint();
    }
    public void fcc(){
        System.out.println("Index bef: "+ind);
        if(ind>=gameData.getHeroesPlaying().size()-1){
            ind=0;
        }
        else{
            ind+=1;
        }
        System.out.println("Index aft: "+ind);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setHostRoomCodeScreen(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setGamescreen(false);
        foePanel.setInd(ind);
        foePanel.setCcscreen(true);
        foePanel.repaint();
        System.out.println("Index: "+ind);
    }

    //main game screen
    public void makeGameScreen(){
        before = currentPage;
        currentPage = GAME;
        removeEverythingFromScreen();
        btn_RB.setVisible(true);
        btn_cc.setVisible(true);
        btn_rot90.setVisible(true);
        btn_screenUp.setVisible(true);
        btn_screenDown.setVisible(true);
        btn_screenRight.setVisible(true);
        btn_screenLeft.setVisible(true);
        msgBox.setVisible(true);
        btn_sendMsg.setVisible(true);
        msgList.setVisible(true);
        msgScroll.setVisible(true);
        msgList.setListData(gameData.getMsgs().toArray());
        actions.setVisible(true);
        actions.setListData(allA.toArray());
        if(you.getName().equals("Aelfric")){
            btn_aelfaction.setVisible(true);
            btn_aelfspec.setVisible(true);
            foePanel.setCurHero(0);
        }
        else if(you.getName().equals("Cecilia")){
            btn_ceciaction.setVisible(true);
            btn_cecispec.setVisible(true);
            foePanel.setCurHero(1);
        }
        else if(you.getName().equals("Daga")){
            btn_dagaaction.setVisible(true);
            btn_dagaspec.setVisible(true);
            foePanel.setCurHero(2);
        }
        else if(you.getName().equals("Kalistos")){
            btn_kaliaction.setVisible(true);
            btn_kalispec.setVisible(true);
            foePanel.setCurHero(3);
        }
        else if(you.getName().equals("Kaylana")){
            btn_kaylaaction.setVisible(true);
            btn_kaylaspec.setVisible(true);
            foePanel.setCurHero(4);
        }
        else if(you.getName().equals("Sirius")){
            btn_siriaction.setVisible(true);
            btn_sirispec.setVisible(true);
            foePanel.setCurHero(5);
        }
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setDrawrulebook(false);
        foePanel.setHostRoomCodeScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setCharacterselectscreen(false);
        foePanel.setDrawTitlePage(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setCcscreen(false);
        foePanel.setGamescreen(true);
        repaintPanel();

    }
    public void move(){}
    public void explore(){}
    public void attack(){}
    public void challenge(){}
    public void wait_A(){}
    public void skill(){}
    public void message(){}
    public void reset(){
        System.out.println("reset");
        //character = new Hero();
        repaint();
    }

    //getters and setters
    public GameData getGameData() {
        return gameData;
    }
    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
    public Hero getYou() {
        return you;
    }
    public void setYou(Hero you) {
        this.you = you;
    }

    //misc
    //misc
    public void paint(Graphics g){
        paintComponents(g);
    }
    public void paintComponents(Graphics g){
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,getWidth(),getHeight());
//        g.drawImage(img,50,50, 800,800,null);
        btn_Host.repaint();
        btn_Join.repaint();
        btn_RB.repaint();
        btn_backToHome.repaint();
        btn_startLobby.repaint();
        btn_backGameScenario.repaint();
        btn_forwardGameScenario.repaint();
        btn_lowerDifficulty.repaint();
        btn_raiseDifficulty.repaint();
        text_numOfPlayersBox.repaint();
        btn_numOfPlayersDecrease.repaint();
        btn_numOfPlayersIncrease.repaint();
        checkbox_GameScenarioSelected.repaint();
        textBox_getUsername.repaint();
        text_roomCode.repaint();
        textBox_getRoomCode.repaint();
        btn_checkRoomCode.repaint();
        msgBox.repaint();
        msgList.repaint();
        msgScroll.repaint();
        btn_sendMsg.repaint();
        btn_selectCharacter.repaint();
        btn_aelfric.repaint();
        btn_cecilia.repaint();
        btn_daga.repaint();
        btn_kalistos.repaint();
        btn_kaylana.repaint();
        btn_sirius.repaint();
        btn_rulebookLEFT.repaint();
        btn_rulebookRIGHT.repaint();
        btn_rbBack.repaint();
        tf_pgnl.repaint();
        tf_pgnr.repaint();
        btn_cc.repaint();
        actions.repaint();
        btn_aelfaction.repaint();
        btn_aelfspec.repaint();
        btn_ceciaction.repaint();
        btn_cecispec.repaint();
        btn_dagaaction.repaint();
        btn_dagaspec.repaint();
        btn_kaliaction.repaint();
        btn_kalispec.repaint();
        btn_kaylaaction.repaint();
        btn_kaylaspec.repaint();
        btn_siriaction.repaint();
        btn_sirispec.repaint();
        btn_screenUp.repaint();
        btn_screenDown.repaint();
        btn_screenRight.repaint();
        btn_screenLeft.repaint();
        btn_rot90.repaint();
        btn_backcc.repaint();
        btn_frontcc.repaint();
        btn_backfromcc.repaint();
    }
    public void repaintPanel(){
        foePanel.setGameData(this.gameData);
        foePanel.repaint();
    }
    public void backToHome(){
        removeEverythingFromScreen();
        btn_Join.setVisible(true);
        btn_Host.setVisible(true);
        btn_RB.setVisible(true);
        foePanel.setSetUpJoinScreen(false);
        foePanel.setDrawTitlePage(true);
        foePanel.setCharacterselectscreen(false);
        foePanel.setHostGameSetUpScreen(false);
        foePanel.setSetUpJoinScreen(false);
        foePanel.repaint();
    }


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
        while(true)
        {
            try
            {
                Thread.sleep(15);
                repaint();
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
        }


    }
}
