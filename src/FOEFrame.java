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
import java.text.AttributedCharacterIterator;
import java.util.Collection;
import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FOEFrame extends JFrame implements WindowFocusListener, KeyListener, Runnable{
    private String text = "";
    private Hero you;
    String username;
    private GameData gameData;
    private boolean usernameValid;
    private boolean lobbycodevalid;
    private boolean gameFull;
    ObjectOutputStream os;
    public static final int TP = 0;
    public static final int RB = 1;
    public static final int SUG = 2;
    public static final int LOBBY = 3;
    public static final int ROOM = 4;
    public static final int SUC = 5;
    public static final int GAME = 6;
    public static final int CC = 7;
    public static final int WIN = 8;
    public static final int LOSE = 9;
    private FOEPanel foePanel;
    private JButton btn_rulebookLEFT = new JButton("<");
    private JButton btn_rulebookRIGHT = new JButton(">");
    private JButton btn_rbBack = new JButton("<-");
    private JTextField tf_pgnl = new JTextField();
    private JTextField tf_pgnr = new JTextField();
    private JButton btn_Host = new JButton("Host");
    private JButton btn_Join = new JButton("Join");
    private JButton btn_RB = new JButton("");

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

    private JTextField textBox_getUsername = new JTextField();
    private JLabel text_roomCode = new JLabel();
    private JButton btn_checkUsername = new JButton("o");

    private boolean paintRuleBook = false;
    private boolean flipRB12 = false;
    private boolean flipRB34 = false;
    private boolean flipRB56 = false;
    private boolean flipRB78 = false;
    private boolean flipRB9 = false;
    private int before;
    private int currentPage;

    public FOEFrame(ObjectOutputStream os) throws IOException{
        super("FOE Game");
        this.gameData = gameData;
        this.os = os;
        addKeyListener(this);
        addWindowFocusListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1500,1000);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);

        btn_rulebookLEFT.setBounds(100,500,75,75);
        add(btn_rulebookLEFT);
        btn_rulebookLEFT.setVisible(false);
        btn_rulebookRIGHT.setBounds(900,500,75,75);
        add(btn_rulebookRIGHT);
        btn_rulebookRIGHT.setVisible(false);
        btn_rbBack.setBounds(50,50,75,75);
        add(btn_rbBack);
        btn_Host.setBounds(900,400,300,75);
        add(btn_Host);
        btn_Join.setBounds(900,500,300,75);
        add(btn_Join);
        btn_RB.setBounds(10,10,100,100);
        add(btn_RB);

        btn_startLobby.setBounds(50,550,300,75);
        add(btn_startLobby);
        btn_backToHome.setBounds(50,650,300,75);
        add(btn_backToHome);
        text_numOfPlayersBox.setBounds(675,250,150,150);
        add(text_numOfPlayersBox);
        btn_numOfPlayersDecrease.setBounds(588,288,75,75);
        add(btn_numOfPlayersDecrease);
        btn_numOfPlayersIncrease.setBounds(850,288,75,75);
        add(btn_numOfPlayersIncrease);
        btn_backGameScenario.setBounds(488,788,75,75);
        add(btn_backGameScenario);
        btn_forwardGameScenario.setBounds(1000,788,75,75);
        add(btn_forwardGameScenario);
        checkbox_GameScenarioSelected.setBounds(700,600,50,50);
        add(checkbox_GameScenarioSelected);
        btn_lowerDifficulty.setBounds(1238,188,75,75);
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

        text_roomCode.setBounds(700,550,300,100);
        add(text_roomCode);
        textBox_getUsername.setBounds(700,400,300,100);
        add(textBox_getUsername);
        btn_checkUsername.setBounds(1000,425,50,50);
        add(btn_checkUsername);


        tf_pgnl.setBounds(50,900,75,75);
        add(tf_pgnl);
        tf_pgnl.setBounds(900,900,75,75);
        add(tf_pgnr);
        foePanel = new FOEPanel();
        foePanel.setBounds(0,0,1500,1000);
        add(foePanel);
        btn_Host.addActionListener(e->{host();});
        btn_RB.addActionListener(e->{
            before = currentPage;
            drawRuleBook();
        });
        btn_rbBack.addActionListener(e -> {
            if(before == 0)
            {
                //paint title page;
            }
            else if(before == 1){
                //nope
            }
            else if(before == 2){
                //paint set up game
            }
            else if(before == 3){
                //paint lobby code page
            }
            else if(before == 4){
                //paint room code page
            }
            else if(before == 5){
                //paint set up character
            }
            else if(before == 6){
                //paint game
            }
            else if(before == 7){
                //nope
            }
            else if(before == 8){
                //nope
            }
            else if(before == 9){
                //nope
            }
            else{
                //didnt set before at some point
            }
        });
        btn_rulebookLEFT.addActionListener(e->{
            System.out.print("rb left");
            String temp = tf_pgnl.getText();
            int lpn = parseInt(temp);
            flipRB(lpn,"left");
        });
        btn_rulebookRIGHT.addActionListener(e->{
            System.out.print("rb right");
            String temp = tf_pgnl.getText();
            int lpn = parseInt(temp);
            flipRB(lpn,"right");
        });
        btn_checkUsername.addActionListener(e->{checkUsername();});
        btn_startLobby.addActionListener(e->{startLobby();});
        btn_numOfPlayersIncrease.addActionListener(e->{numOfPlayersIncrease();});
        btn_numOfPlayersDecrease.addActionListener(e->{numOfPlayersDecrease();});
        btn_backGameScenario.addActionListener(e->{backGameScenario();});
        btn_forwardGameScenario.addActionListener(e->{forwardGameScenario();});
        btn_lowerDifficulty.addActionListener(e->{lowerDifficulty();});
        btn_raiseDifficulty.addActionListener(e->{raiseDifficulty();});


        removeEverythingFromScreen();
        btn_RB.setVisible(true);
        btn_Join.setVisible(true);
        btn_Host.setVisible(true);
        text_numOfPlayersBox.setOpaque(true);
        text_numOfPlayersBox.setVisible(true);

    }

    public void removeEverythingFromScreen(){
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

        btn_checkUsername.setVisible(false);
        textBox_getUsername.setVisible(false);
        text_roomCode.setVisible(false);
        btn_rulebookLEFT.setVisible(false);
        btn_rulebookLEFT.setVisible(false);
        btn_rbBack.setVisible(false);
        tf_pgnl.setVisible(false);
        tf_pgnr.setVisible(false);
    }
    public void reset(){
        System.out.println("reset");
        //character = new Hero();
        repaint();
    }
    public void drawRuleBook(){
        currentPage = RB;
        removeEverythingFromScreen();
        btn_rbBack.setVisible(true);
        btn_rbBack.setEnabled(true);
        btn_rulebookLEFT.setVisible(true);
        btn_rulebookLEFT.setEnabled(false);
        btn_rulebookRIGHT.setVisible(true);
        btn_rulebookRIGHT.setEnabled(true);
        foePanel.setHostGameSetUpScreen(false);
//        foePanel.setRuleBookSetUpScreen(true);
        foePanel.repaint();
        tf_pgnl.setVisible(true);
        tf_pgnr.setVisible(true);
        tf_pgnl.setText("1");
        tf_pgnr.setText("2");
    }
    public void flipRB(int lpn, String dir){
        if(lpn == 1 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB34 = true;
            repaint();
            flipRB34 = false;
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("3");
            tf_pgnr.setText("4");
        }
        else if(lpn == 3 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB56 = true;
            repaint();
            flipRB56 = false;
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("5");
            tf_pgnr.setText("6");
        }
        else if(lpn == 3 && dir.equals("left")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB12 = true;
            repaint();
            flipRB12 = false;
            btn_rulebookLEFT.setEnabled(false);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("1");
            tf_pgnr.setText("2");
        }
        else if(lpn == 5 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB78 = true;
            repaint();
            flipRB78 = false;
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("7");
            tf_pgnr.setText("8");
        }
        else if(lpn == 5 && dir.equals("left")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB34 = true;
            repaint();
            flipRB34 = false;
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("3");
            tf_pgnr.setText("4");
        }
        else if(lpn == 7 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB9 = true;
            repaint();
            flipRB9 = false;
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(false);
            tf_pgnl.setText("9");
            tf_pgnr.setText(" ");
        }
        else if(lpn == 7 && dir.equals("left")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB56 = true;
            repaint();
            flipRB56 = false;
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("5");
            tf_pgnr.setText("6");
        }
        else if(lpn == 9 && dir.equals("right")){
            btn_rbBack.setVisible(true);
            btn_rbBack.setEnabled(true);
            flipRB78 = true;
            repaint();
            flipRB78 = false;
            btn_rulebookLEFT.setEnabled(true);
            btn_rulebookRIGHT.setEnabled(true);
            tf_pgnl.setText("7");
            tf_pgnr.setText("8");
        }
    }

    public void move(){}
    public void explore(){}
    public void attack(){}
    public void challenge(){}
    public void wait_A(){}
    public void skill(){}
    public void message(){}
    public void sendCommand(int com, String data, GameData gameData){
        System.out.println("num player in gd"+gameData.getNumOfPlayers());
        CommandFromClient cfc = new CommandFromClient(com,data,gameData);
        try{
            os.writeObject(cfc);
        }catch (Exception e){
            e.printStackTrace();
        }
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

    }

    public void host(){
        removeEverythingFromScreen();
        gameData = new GameData();
        foePanel.setHostGameSetUpScreen(true);
        foePanel.repaint();
        btn_RB.setVisible(true);
        text_numOfPlayersBox.setVisible(true);
        text_numOfPlayersBox.setOpaque(true);
        btn_numOfPlayersIncrease.setVisible(true);
        btn_numOfPlayersDecrease.setVisible(true);
        btn_raiseDifficulty.setVisible(true);
        btn_lowerDifficulty.setVisible(true);
        btn_backToHome.setVisible(true);
        btn_startLobby.setVisible(true);
        btn_backGameScenario.setVisible(true);
        btn_forwardGameScenario.setVisible(true);
        checkbox_GameScenarioSelected.setVisible(true);




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
        }
        if(gameRuleSlidesIndex == 1){
            foePanel.setShowVagrantPortal(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            foePanel.setShowShadesOfVorax(false);
        }
        if(gameRuleSlidesIndex == 2){
            foePanel.setShowInvasionOfTheShadowCult(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowShadesOfVorax(false);
        }
        if(gameRuleSlidesIndex == 3){
            foePanel.setShowShadesOfVorax(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
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
        }
        if(gameRuleSlidesIndex == 1){
            foePanel.setShowVagrantPortal(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
            foePanel.setShowShadesOfVorax(false);
        }
        if(gameRuleSlidesIndex == 2){
            foePanel.setShowInvasionOfTheShadowCult(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowShadesOfVorax(false);
        }
        if(gameRuleSlidesIndex == 3){
            foePanel.setShowShadesOfVorax(true);
            foePanel.setShowUnstableVoid(false);
            foePanel.setShowVagrantPortal(false);
            foePanel.setShowInvasionOfTheShadowCult(false);
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
        gameData.setNumOfPlayers(Integer.parseInt(text_numOfPlayersBox.getText()));
        sendCommand(CommandFromClient.HOSTING,username,gameData);
        removeEverythingFromScreen();
        foePanel.setGameData(gameData);
        btn_checkUsername.setVisible(true);
        text_roomCode.setVisible(true);
        text_roomCode.setOpaque(true);
        text_roomCode.setText(gameData.getLobbyCode());
        textBox_getUsername.setVisible(true);
    }

    public void checkUsername(){
        System.out.println(gameData.getNumOfPlayers());
        sendCommand(CommandFromClient.CHECK_USERNAME, text_numOfPlayersBox.getText(),gameData);


    }
    public void usernameValid(boolean valid){
        System.out.println("usernamehelpter");
        if(valid){
            System.out.println("valid");
            btn_checkUsername.setVisible(false);
            textBox_getUsername.setEnabled(false);
            if(gameData.getNumOfPlayers()==gameData.getUsernames().size()){
                //character selection
            }
        }
        else{
            System.out.println("invalid");
        }
    }

    public void join(){

    }
    public void enterGame(){
        sendCommand(CommandFromClient.LOBBY_CODE_ATTEMPT,"Room code,Username",gameData);
    }

    public void lobbyCodeValid(boolean valid){
        if(!valid){
            //make txtbox say code is invalid
        }
    }

    public void gameFull(boolean full){
        if(full){
            //make txt say lobby is full
        }
    }


    public boolean getUsernameValid(){
        return usernameValid;
    }

    public void setUsernameValid(boolean usernameValid){
        this.usernameValid = usernameValid;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public boolean isUsernameValid() {
        return usernameValid;
    }

    public boolean isLobbycodevalid() {
        return lobbycodevalid;
    }

    public void setLobbycodevalid(boolean lobbycodevalid) {
        this.lobbycodevalid = lobbycodevalid;
    }

    public boolean isGameFull() {
        return gameFull;
    }

    public void setGameFull(boolean gameFull) {
        this.gameFull = gameFull;
    }
    
    public void repaintPanel(){
        foePanel.setGameData(gameData);
        foePanel.repaint();
        foePanel.repaint();
    }
}
