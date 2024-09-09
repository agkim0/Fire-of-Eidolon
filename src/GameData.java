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
        
    }






















}
