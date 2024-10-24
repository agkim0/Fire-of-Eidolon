import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameData implements Serializable{
    private Tile[][] grid = new Tile[61][61];
    private boolean allTilesOpen;
    private ArrayList<Card> fullDeck = new ArrayList<>();
    private ArrayList<Card> currDeck = new ArrayList<>();
    private ArrayList<Tile> tileDeck = new ArrayList<>();
    private ArrayList<Tile> fullTileDeck = new ArrayList<>();
    private ArrayList<Hero> allHeroes = new ArrayList<>();
    private Hero curHero;
    private ArrayList<Hero> heroesPlaying = new ArrayList<Hero>();
    private Hero turn;
    private ArrayList<Hero> orderOfTurns = new ArrayList<>();
    private int orderOfTurnIndex=0;
    private int threatLevel=0;
    private String difficultyLevel="Beginner";
    private int numOfPlayers=0;
    private int playersDove=0;
    private int playersNeedingDive=0;
    private ArrayList<Tile> collapsingTiles=new ArrayList<>();

    private boolean unstableVoid=false;
    private boolean vagrantPortal=false;
    private boolean invasionOfTheShadowCult=false;
    private boolean shadesOfVorax=false;

    private ArrayList<String> msgs = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private String lobbyCode = "";


    private String aelfricPlayer = "";
    private String ceceliaPlayer = "";
    private String dagaPlayer = "";
    private String kalistosPlayer = "";
    private String kaylanaPlayer = "";
    private String siriusPlayer = "";
    public static final Hero AELFRIC = new Hero("Aelfric",1,2,3,0,0,0,false,false,false,false,3,false);
    public static final Hero CECELIA = new Hero("Cecilia",1,3,2,0,0,0,false,false,false,false,3,false);
    public static final Hero DAGA = new Hero("Daga",2,3,1,0,0,0,false,false,false,false,3,false);
    public static final Hero KALISTOS = new Hero("Kalistos",3,1,2,0,0,0,false,false,false,false,3,false);
    public static final Hero KAYLANA = new Hero("Kaylana",2,1,3,0,0,0,false,false,false,false,3,false);
    public static final Hero SIRIUS = new Hero("Sirius",3,2,1,0,0,0,false,false,false,false,3,false);

    public GameData(){//change game rule to actual game rules!!!
        createAllHero();
        curHero = allHeroes.get(0);
        Random rand = new Random();
        //lobby code generation
        for(int x=0;x<3;x++){
            char c = (char)(rand.nextInt(26)+'A');
            lobbyCode+=(c+"");
        }
        lobbyCode+="-";
        for(int x = 0;x<3;x++){
            lobbyCode+=((rand.nextInt(9))+"");
        }
    }

    public void startGame(){
        //create turn order of players
        for(int x = 0;x<heroesPlaying.size();x++){
            orderOfTurns.add(heroesPlaying.get(x));
        }
        Collections.shuffle(orderOfTurns);
        turn = orderOfTurns.get(orderOfTurnIndex);
        System.out.println("Turn: "+turn.getName());

        createAllTilesAndCards();
        for(int x = 0;x<tileDeck.size();x++){
            fullTileDeck.add(tileDeck.get(x));
        }
        for(int x=0; x< grid.length;x++){
            for(int y=0; y<grid[0].length; y++){
                grid[x][y]=getThistile("nuul");
                grid[x][y].setOnBoard(false);
            }
        }
        grid[31][31] = getThistile("Vestibule");
        grid[29][29].setOnBoard(true);
        grid[29][30].setOnBoard(true);
        grid[29][31].setOnBoard(true);
        grid[29][32].setOnBoard(true);
        grid[29][33].setOnBoard(true);
        grid[30][29].setOnBoard(true);
        grid[30][30].setOnBoard(true);
        grid[30][31].setOnBoard(true);
        grid[30][32].setOnBoard(true);
        grid[30][33].setOnBoard(true);
        grid[31][29].setOnBoard(true);
        grid[31][30].setOnBoard(true);
        grid[31][31].setOnBoard(true);
        grid[31][32].setOnBoard(true);
        grid[31][33].setOnBoard(true);
        grid[32][29].setOnBoard(true);
        grid[32][30].setOnBoard(true);
        grid[32][31].setOnBoard(true);
        grid[32][32].setOnBoard(true);
        grid[32][33].setOnBoard(true);
        grid[33][29].setOnBoard(true);
        grid[33][30].setOnBoard(true);
        grid[33][31].setOnBoard(true);
        grid[33][32].setOnBoard(true);
        grid[33][33].setOnBoard(true);
        //System.out.println("Vestibule set");
        grid[31][31].setHeroesOn(heroesPlaying);
        grid[31][31].setDegRot(90);
        tileDeck.remove(getThistile("Vestibule"));
        Collections.shuffle(tileDeck);
        Collections.shuffle(currDeck);
    }
    public void move(String dir){
        int crow = 0;
        int ccol = 0;
        for (int r=0;r<grid.length;r++){
            for (int c = 0;c<grid[0].length;c++){
                if(grid[r][c]==null&&grid[r][c].getHeroesOn().contains(turn)){
                    crow = r;
                    ccol = c;
                    break;
                }
            }
        }
        if(dir.equalsIgnoreCase("Up")&&grid[crow][ccol].isTopSide()){
            crow-=1;
        }
        if(dir.equalsIgnoreCase("Down")&&grid[crow][ccol].isBottomSide()){
            crow+=1;
        }
        if(dir.equalsIgnoreCase("Left")&&grid[crow][ccol].isLeftSide()){
            ccol-=1;
        }
        if(dir.equalsIgnoreCase("Right")&&grid[crow][ccol].isRightSide()){
            ccol+=1;
        }
        if(grid[crow][ccol]==null){//need to draw a tile
            //draw tile
        }
        else{
            //finish turn
        }
    }

    public void explore(){

    }

    public void placeTile(Tile tile,int r,int c){
        if(tileDeck.contains(tile)){
            grid[r][c]=tile;
            tileDeck.remove(tile);
        }


    }

    public void createAllTilesAndCards(){
        Tile acidJets = new Tile("Acid Jets",Tile.DEX,true,false,true,false);
        Tile arrowTrap = new Tile("Arrow Trap",Tile.DEX,false,true,true,true);
        Tile darkSlime = new Tile("Dark Slime",Tile.STR,false,true,true,false);
        Tile denOfSnakes = new Tile("Den of Snakes",Tile.DEX,true,true,true,false);
        Tile dragonling = new Tile("Dragonling",Tile.STR,true,false,true,true);
        Tile felKnight = new Tile("Fel Knight",Tile.DEX,true,true,true,false);
        Tile fireOfEidolon = new Tile("Fire of Eidolon",Tile.SPECIAL, false,false,true,false);
        Tile floatingStones = new Tile("Floating Stones",Tile.DEX,true,true,true,true);
        Tile hallOfIllustion = new Tile("Hall of Illusion",Tile.INTEL,false,true,true,false);
        Tile laughingShadow = new Tile("Laughing Shadow",Tile.INTEL,true,true,true,true);
        Tile lavaLake = new Tile("Lava Lake",Tile.DEX,false,false,true,true);
        Tile mimicChest = new Tile("Mimic Chest",Tile.INTEL,false,false,true,false);
        Tile mindEater = new Tile("Mind Eater", Tile.INTEL,false,true,true,true);
        Tile minotaur = new Tile("Minotaur",Tile.STR,true,true,true,true);
        Tile ogreBrute = new Tile("Ogre Brute", Tile.STR,false,false,true,true);
        Tile paradoxPuzzle = new Tile("Paradox Puzzle",Tile.INTEL, true,false,true,true);
        Tile pendulumBlades = new Tile("Pengulum Blades",Tile.DEX,true,false,true,false);
        Tile vagrantPortalChamber = new Tile("Vagrant Portal", Tile.SPECIAL,false,false,true,false);
        Tile psychomancer = new Tile("Psychomancer",Tile.INTEL,true,true,true,true);
        Tile secretPassageX = new Tile("Secret Passage X",Tile.SPECIAL,true,true,true,true);
        Tile secretPassageY = new Tile("Secret Passage Y",Tile.SPECIAL,true,true,true,true);
        Tile skeletalGuards = new Tile("Skeletal Guards",Tile.STR,true,false,true,false);
        Tile sphynxsRiddle = new Tile("Sphynx's Riddle",Tile.INTEL,true,false,true,false);
        Tile spikedPit = new Tile("Spiked Pit",Tile.DEX,true,true,true,false);
        Tile vestibule = new Tile("Vestibule",Tile.SPECIAL,true,true,true,true);
        Tile voraciousPlant = new Tile("Voracious Plant",Tile.STR,true,true,true,true);
        Tile voraxsFocus = new Tile("Vorax's Focus",Tile.SPECIAL,false,false,true,false);
        voraxsFocus.setBroken(false);
        Tile voraxsHeart = new Tile("Vorax's Heart",Tile.SPECIAL,false,false,true,false);
        voraxsHeart.setBroken(false);
        Tile voraxsKnowledge = new Tile("Vorax's Knowledge",Tile.SPECIAL,false,false,true,false);
        voraxsKnowledge.setBroken(false);
        Tile nuul = new Tile("nuul",Tile.SPECIAL,false,false,false,false);

        Card acidJetsCard = new Card("Acid Jets",Card.DEX,acidJets,false );
        Card arrowTrapCard = new Card("Arrow Trap", Card.DEX,arrowTrap,false);
        Card intelEventCard = new Card("Intelligence Event", Card.DEX, null, true);
        Card darkSlimeCard = new Card("Dark Slime", Card.STR, darkSlime, false);
        Card denOfSnakesCard = new Card("Den of Snakes",Card.DEX,denOfSnakes,false);
        Card dragonlingCard = new Card("Dragonling",Card.STR,dragonling,false);
        Card felKnightCard = new Card("Fel Knight", Card.STR,felKnight,false);
        Card floatingStonesCard = new Card("Floating Stones",Card.DEX,floatingStones,false);
        Card dexEventCard = new Card("Dexterity Event",Card.DEX,null,true);
        Card hallOfIllusionsCard = new Card("Hall of Illusions",Card.INTEL,hallOfIllustion,false);
        Card laughingShadowCard = new Card("Laughing Shadow",Card.INTEL,laughingShadow,false);
        Card lavaLakeCard = new Card("Lava Lake",Card.DEX,lavaLake,false);
        Card mimicChestCard = new Card("Mimic Chest",Card.INTEL,mimicChest,false);
        Card mindeaterCard = new Card("Mindeater",Card.INTEL,mindEater,false);
        Card minotaurCard = new Card("Minotaur",Card.STR,minotaur,false);
        Card ogreBruteCard = new Card("Ogre Brute",Card.STR,ogreBrute,false);
        Card paradoxPuzzleCard = new Card("Paradox Puzzle",Card.INTEL,paradoxPuzzle,false);
        Card pendulumBladesCard = new Card("Pendulum Blades",Card.DEX,pendulumBlades,false);
        Card psychomancerCard = new Card("Psychomancer",Card.INTEL,psychomancer,false);
        Card strEventCard = new Card("Strength Event",Card.STR,null,true);
        Card skeletalGuardsCard = new Card("Skeletal Guards",Card.STR,skeletalGuards,false);
        Card sphynxsRiddleCard = new Card("Sphynx's Riddle",Card.INTEL,sphynxsRiddle,false);
        Card spikedPitCard = new Card("Spiked Pit",Card.DEX,spikedPit,false);
        Card voraciousPlantCard = new Card("Voracios Plant",Card.STR,voraciousPlant,false);

        acidJets.setCard(acidJetsCard);
        arrowTrap.setCard(arrowTrapCard);
        darkSlime.setCard(darkSlimeCard);
        denOfSnakes.setCard(denOfSnakesCard);
        dragonling.setCard(dragonlingCard);
        felKnight.setCard(felKnightCard);
        floatingStones.setCard(floatingStonesCard);
        hallOfIllustion.setCard(hallOfIllusionsCard);
        laughingShadow.setCard(laughingShadowCard);
        lavaLake.setCard(lavaLakeCard);
        mimicChest.setCard(mimicChestCard);
        mindEater.setCard(mindeaterCard);
        minotaur.setCard(minotaurCard);
        ogreBrute.setCard(ogreBruteCard);
        paradoxPuzzle.setCard(paradoxPuzzleCard);
        pendulumBlades.setCard(pendulumBladesCard);
        psychomancer.setCard(psychomancerCard);
        skeletalGuards.setCard(skeletalGuardsCard);
        sphynxsRiddle.setCard(sphynxsRiddleCard);
        spikedPit.setCard(spikedPitCard);
        voraciousPlant.setCard(voraciousPlantCard);

        tileDeck.add(acidJets);
        tileDeck.add(arrowTrap);
        tileDeck.add(darkSlime);
        tileDeck.add(denOfSnakes);
        tileDeck.add(dragonling);
        tileDeck.add(felKnight);
        tileDeck.add(fireOfEidolon);
        tileDeck.add(floatingStones);
        tileDeck.add(hallOfIllustion);
        tileDeck.add(laughingShadow);
        tileDeck.add(lavaLake);
        tileDeck.add(mimicChest);
        tileDeck.add(mindEater);
        tileDeck.add(minotaur);
        tileDeck.add(ogreBrute);
        tileDeck.add(paradoxPuzzle);
        tileDeck.add(pendulumBlades);
        tileDeck.add(psychomancer);
        tileDeck.add(skeletalGuards);
        tileDeck.add(sphynxsRiddle);
        tileDeck.add(spikedPit);
        tileDeck.add(vestibule);
        tileDeck.add(voraciousPlant);
        tileDeck.add(voraxsFocus);
        tileDeck.add(voraxsHeart);
        tileDeck.add(voraxsKnowledge);
        tileDeck.add(nuul);

        if(vagrantPortal){
            tileDeck.add(secretPassageX);
            tileDeck.add(secretPassageY);
            tileDeck.add(vagrantPortalChamber);
        }

        /*
        Dexterity has been abbreviated to "Dex"
        Strength has been abbreviated to "Str"
        Inteligece has been abbreviated to "Intel"
         */

    }
    public void createAllHero(){
        allHeroes = new ArrayList<>();
        allHeroes.add(AELFRIC);
        allHeroes.add(CECELIA);
        allHeroes.add(DAGA);
        allHeroes.add(KALISTOS);
        allHeroes.add(KAYLANA);
        allHeroes.add(SIRIUS);
    }
    public void nextTurn(){
        orderOfTurnIndex++;
        if(orderOfTurnIndex==orderOfTurns.size()){
            orderOfTurnIndex=0;
        }
        turn=orderOfTurns.get(orderOfTurnIndex);
    }
    public Tile getThistile(String tileName){
        for(int x = 0;x<fullTileDeck.size();x++){
            if(fullTileDeck.get(x).getName().equals(tileName)){
                return fullTileDeck.get(x);
            }
            else{
                //System.out.println(fullTileDeck.get(x).getName()+"!="+tileName);
            }
        }
        System.out.println("fail");
        return null;
    }
    public void divingSequence(Tile t){
        playersNeedingDive=t.getHeroesOn().size();
        playersDove=0;
    }
    public boolean allPlayersDove(Tile t){
        if(playersDove==playersNeedingDive){
            playersDove=0;
            playersNeedingDive=0;
            return true;
        }
        else {
            return false;
        }
    }

    public Tile[][] getGrid() {
        return grid;
    }
    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }
    public boolean isAllTilesOpen() {
        return allTilesOpen;
    }
    public void setAllTilesOpen(boolean allTilesOpen) {
        this.allTilesOpen = allTilesOpen;
    }
    public ArrayList<Card> getFullDeck() {
        return fullDeck;
    }
    public void setFullDeck(ArrayList<Card> fullDeck) {
        this.fullDeck = fullDeck;
    }
    public ArrayList<Card> getCurrDeck() {
        return currDeck;
    }
    public void setCurrDeck(ArrayList<Card> currDeck) {
        this.currDeck = currDeck;
    }
    public ArrayList<Tile> getTileDeck() {
        return tileDeck;
    }
    public void setTileDeck(ArrayList<Tile> tileDeck) {
        this.tileDeck = tileDeck;
    }
    public ArrayList<Hero> getAllHeroes() {
        return allHeroes;
    }
    public void setAllHeroes(ArrayList<Hero> allHeroes) {
        this.allHeroes = allHeroes;
    }
    public Hero getTurn() {
        return turn;
    }
    public void setTurn(Hero turn) {
        this.turn = turn;
    }
    public ArrayList<Hero> getOrderOfTurns() {
        return orderOfTurns;
    }
    public void setOrderOfTurns(ArrayList<Hero> orderOfTurns) {
        this.orderOfTurns = orderOfTurns;
    }
    public Hero getCurHero() {
        return curHero;
    }
    public void setCurHero(Hero curHero) {
        this.curHero = curHero;
    }
    public int getThreatLevel() {
        return threatLevel;
    }
    public void setThreatLevel(int threatLevel) {
        this.threatLevel = threatLevel;
    }
    public String getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public boolean isUnstableVoid() {
        return unstableVoid;
    }
    public void setUnstableVoid(boolean unstableVoid) {
        this.unstableVoid = unstableVoid;
    }
    public boolean isVagrantPortal() {
        return vagrantPortal;
    }
    public void setVagrantPortal(boolean vagrantPortal) {
        this.vagrantPortal = vagrantPortal;
    }
    public boolean isInvasionOfTheShadowCult() {
        return invasionOfTheShadowCult;
    }
    public void setInvasionOfTheShadowCult(boolean invasionOfTheShadowCult) {
        this.invasionOfTheShadowCult = invasionOfTheShadowCult;
    }
    public boolean isShadesOfVorax() {
        return shadesOfVorax;
    }
    public void setShadesOfVorax(boolean shadesOfVorax) {
        this.shadesOfVorax = shadesOfVorax;
    }
    public ArrayList<String> getMsgs() {
        return msgs;
    }
    public void setMsgs(ArrayList<String> msgs) {
        this.msgs = msgs;
    }
    public String getAelfricPlayer() {
        return aelfricPlayer;
    }
    public void setAelfricPlayer(String aelfricPlayer) {
        this.aelfricPlayer = aelfricPlayer;
    }
    public String getCeceliaPlayer() {
        return ceceliaPlayer;
    }
    public void setCeceliaPlayer(String ceceliaPlayer) {
        this.ceceliaPlayer = ceceliaPlayer;
    }
    public String getDagaPlayer() {
        return dagaPlayer;
    }
    public void setDagaPlayer(String dagaPlayer) {
        this.dagaPlayer = dagaPlayer;
    }
    public String getKalistosPlayer() {
        return kalistosPlayer;
    }
    public void setKalistosPlayer(String kalistosPlayer) {
        this.kalistosPlayer = kalistosPlayer;
    }
    public String getKaylanaPlayer() {
        return kaylanaPlayer;
    }
    public void setKaylanaPlayer(String kaylanaPlayer) {
        this.kaylanaPlayer = kaylanaPlayer;
    }
    public String getSiriusPlayer() {
        return siriusPlayer;
    }
    public void setSiriusPlayer(String siriusPlayer) {
        this.siriusPlayer = siriusPlayer;
    }
    public ArrayList<Hero> getHeroesPlaying(){
        return this.heroesPlaying;
    }
    public void setHeroesPlaying(ArrayList<Hero> heroesPlaying){
        this.heroesPlaying = heroesPlaying;
    }
    public void addHeroesPlaying(Hero hero){
        heroesPlaying.add(hero);
    }
    public ArrayList<String> getUsernames() {
        return usernames;
    }
    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }
    public String getLobbyCode() {
        return lobbyCode;
    }
    public void setLobbyCode(String lobbyCode) {
        this.lobbyCode = lobbyCode;
    }
    public int getNumOfPlayers() {
        return numOfPlayers;
    }
    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public int getOrderOfTurnIndex() {
        return orderOfTurnIndex;
    }

    public void setOrderOfTurnIndex(int orderOfTurnIndex) {
        this.orderOfTurnIndex = orderOfTurnIndex;
    }

    public int getPlayersDove() {
        return playersDove;
    }

    public void setPlayersDove(int playersDove) {
        this.playersDove = playersDove;
    }

    public int getPlayersNeedingDive() {
        return playersNeedingDive;
    }

    public void setPlayersNeedingDive(int playersNeedingDive) {
        this.playersNeedingDive = playersNeedingDive;
    }

    public ArrayList<Tile> getCollapsingTiles() {
        return collapsingTiles;
    }

    public void setCollapsingTiles(ArrayList<Tile> collapsingTiles) {
        this.collapsingTiles = collapsingTiles;
    }
}
