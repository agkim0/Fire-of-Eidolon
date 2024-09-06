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

    public void createAllTiles(){
        Tile acidJets

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
