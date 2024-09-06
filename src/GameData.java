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






















}
