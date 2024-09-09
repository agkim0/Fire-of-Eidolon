import java.io.Serializable;
import java.util.ArrayList;

public class GameData implements Serializable {
    private Tile[][] grid = new Tile[61][61];
    private boolean allTilesOpen;
    private ArrayList<Card> fullDeck;
    private ArrayList<Card> currDeck;
    private ArrayList<Tile> tileDeck;
    private ArrayList<Hero> allHeroes;
    private Hero turn;
    private ArrayList<Hero> orderOfTurns;
    private int threatLevel;
    private String difficultyLevel;
    private boolean unstableVoid;
    private boolean vagrantPortal;
    private boolean invasionOfTheShadowCult;
    private boolean shadesOfVorax;
    private ArrayList<String> msgs;

    public GameData(){

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
        Tile pendulumBlades = new Tile("Pendulum Blades",Tile.DEX,true,false,true,false);
        Tile vagrantPortal = new Tile("Vagrant Portal", Tile.SPECIAL,false,false,true,false);
        Tile psychomancer = new Tile("Psychomancer",Tile.INTEL,true,true,true,true);
        Tile secretPassageX = new Tile("Secret Passage X",Tile.SPECIAL,true,true,true,true);
        Tile secretPassageY = new Tile("Secret Passage Y",Tile.SPECIAL,true,true,true,true);
        Tile skeletalGuards = new Tile("Skeletal Guards",Tile.STR,true,false,true,false);
        Tile sphynxsRiddle = new Tile("Sphynx's Riddle",Tile.INTEL,true,false,true,false);
        Tile spikedPit = new Tile("Spiked Pit",Tile.DEX,true,true,true,false);
        Tile vestibule = new Tile("Vestibule",Tile.SPECIAL,true,true,true,true);
        Tile voraciousPlant = new Tile("Voracious Plant",Tile.STR,true,true,true,true);
        Tile voraxsFocus = new Tile("Vorax's Focus",Tile.DEX,false,false,true,false);
        Tile voraxsHeart = new Tile("Vorax's Heart",Tile.STR,false,false,true,false);
        Tile voraxsKnowledge = new Tile("Vorax's Knowledge",Tile.INTEL,false,false,true,false);

        /*
        Dexterity has been abbreviated to "Dex"
        Strength has been abbreviated to "Str"
        Inteligece has been abbreviated to "Intel"
         */

    }























































    //start here
    public void createAllHero(){
        allHeroes = new ArrayList<>();
        allHeroes.add(new Hero("Aelfric",1,2,3,0,0,0,false,false,false,false,3,false));
        allHeroes.add(new Hero("Cecilia",1,3,2,0,0,0,false,false,false,false,3,false));
        allHeroes.add(new Hero("Dage",2,3,1,0,0,0,false,false,false,false,3,false));
        allHeroes.add(new Hero("Kalistos",3,1,2,0,0,0,false,false,false,false,3,false));
        allHeroes.add(new Hero("Kaylana",2,1,3,0,0,0,false,false,false,false,3,false));
        allHeroes.add(new Hero("Sirus",3,2,1,0,0,0,false,false,false,false,3,false));

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

    public Tile getThisTile(String tt){
        //loop though all tiles find which one matches
    }
    public Hero getThisHero(String nh){

    }
    public void restart(){}
    public void nextTurn(){}
    public boolean checkLoss(){

    }
    public boolean checkWin(){

    }
    public int cardDrawAmount(){

    }
}
