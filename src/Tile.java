import java.util.ArrayList;

public class Tile {
    private String name;
    private String skillType;
    private boolean token;
    private int cultistNum;
    private ArrayList<Hero> heroesOn;
    private boolean onBoard;
    private boolean inVoid;
    private Card card;
    private boolean topSide;
    private boolean bottomSide;
    private boolean leftSide;
    private boolean rightSide;

    public Tile(boolean rightSide, boolean leftSide, boolean topSide, boolean bottomSide, Card card, ArrayList<Hero> heroesOn, String skillType, String name) {
        this.rightSide = rightSide;
        this.leftSide = leftSide;
        this.topSide = topSide;
        this.bottomSide = bottomSide;
        this.card = card;
        this.heroesOn = heroesOn;
        this.skillType = skillType;
        this.name = name;
    }

    public Tile(String name, String skillType, boolean token, int cultistNum, ArrayList<Hero> heroesOn, boolean onBoard, boolean inVoid, Card card, boolean topSide, boolean bottomSide, boolean leftSide, boolean rightSide) {
        this.name = name;
        this.skillType = skillType;
        this.token = token;
        this.cultistNum = cultistNum;
        this.heroesOn = heroesOn;
        this.onBoard = onBoard;
        this.inVoid = inVoid;
        this.card = card;
        this.topSide = topSide;
        this.bottomSide = bottomSide;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public boolean isToken() {
        return token;
    }

    public void setToken(boolean token) {
        this.token = token;
    }

    public int getCultistNum() {
        return cultistNum;
    }

    public void setCultistNum(int cultistNum) {
        this.cultistNum = cultistNum;
    }

    public ArrayList<Hero> getHeroesOn() {
        return heroesOn;
    }

    public void setHeroesOn(ArrayList<Hero> heroesOn) {
        this.heroesOn = heroesOn;
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public boolean isInVoid() {
        return inVoid;
    }

    public void setInVoid(boolean inVoid) {
        this.inVoid = inVoid;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isTopSide() {
        return topSide;
    }

    public void setTopSide(boolean topSide) {
        this.topSide = topSide;
    }

    public boolean isBottomSide() {
        return bottomSide;
    }

    public void setBottomSide(boolean bottomSide) {
        this.bottomSide = bottomSide;
    }

    public boolean isLeftSide() {
        return leftSide;
    }

    public void setLeftSide(boolean leftSide) {
        this.leftSide = leftSide;
    }

    public boolean isRightSide() {
        return rightSide;
    }

    public void setRightSide(boolean rightSide) {
        this.rightSide = rightSide;
    }

    public void rotateLeft(){
        boolean newTop = false;
        boolean newBot = false;
        boolean newLeft = false;
        boolean newRight = false;
        if(topSide){
            newLeft = true;
        }
        if(leftSide){
            newBot = true;
        }
        if(bottomSide){
            newRight = true;
        }
        if(rightSide){
            newTop = true;
        }

        topSide = newTop;
        leftSide = newLeft;
        bottomSide = newBot;
        rightSide = newRight;
    }
    public void rotateRight(){
        boolean newTop = false;
        boolean newBot = false;
        boolean newLeft = false;
        boolean newRight = false;
        if(topSide){
            newRight= true;
        }
        if(leftSide){
            newTop = true;
        }
        if(bottomSide){
            newLeft = true;
        }
        if(rightSide){
            newBot = true;
        }

        topSide = newTop;
        leftSide = newLeft;
        bottomSide = newBot;
        rightSide = newRight;
    }
}
