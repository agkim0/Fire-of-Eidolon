import java.io.Serializable;
import java.util.ArrayList;

public class GameData implements Serializable {
    private Tile[][] grid = new Tile[61][61];
    private boolean allTilesOpen;
    private ArrayList<Card> fullDeck;
    private ArrayList<Card> currDeck;
    private ArrayList<Tile> tileDeck;
    private ArrayList<Hero> allHeroes;
    private ArrayList<Hero> heroesPlaying;
    private Hero turn;
    private ArrayList<Hero> orderOfTurns;
    private int threatLevel;
    private String difficultyLevel;
    private boolean unstableVoid;
    private boolean vagrantPortal;
    private boolean invasionOfTheShadowCult;
    private boolean shadesOfVorax;
    private ArrayList<String> msgs;
    private ArrayList<String> usernames;
    private String lobbyCode;

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
        Tile vagrantPortalChamber = new Tile("Vagrant Portal", Tile.SPECIAL,false,false,true,false);
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

//    public Tile getThisTile(String tt){
//        //loop though all tiles find which one matches
//    }
//    public Hero getThisHero(String nh){
//
//    }
//    public void restart(){}
    public void nextTurn(){
        for(int x=0 ;x<6; x++){
            if(allHeroes.get(x) == turn){
                if(x==5){
                    turn = allHeroes.get(0);
                }
                else{
                    turn = allHeroes.get(x+1);
                }
            }
        }
    }
//    public boolean checkLoss(){
//
//    }
//    public boolean checkWin(){
//
//    }
//    public int cardDrawAmount(){
//
//    }

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
}
