import java.io.Serializable;
import java.util.ArrayList;

public class Tile implements Serializable {
    public static final int STR = 0;
    public static final int DEX = 1;
    public static final int INTEL = 2;
    public static final int SPECIAL = 3;
    private String name;
    private int skillType;
    private boolean broken;
    private boolean token = true;
    private int cultistNum = 0;
    private ArrayList<Hero> heroesOn = new ArrayList<Hero>();
    private boolean onBoard;
    private boolean inVoid;
    private boolean collapsing=false;
    private Card card;
    private boolean topSide;
    private boolean bottomSide;
    private boolean leftSide;
    private boolean rightSide;
    private int degRot = 0;

    public int getDegRot() {
        return degRot;
    }
    public void setDegRot(int degRot) {
        this.degRot = degRot;
    }

    public Tile(String name, int skillType, Card card, boolean topSide, boolean rightSide, boolean bottomSide, boolean leftSide) {
        this.rightSide = rightSide;
        this.leftSide = leftSide;
        this.topSide = topSide;
        this.bottomSide = bottomSide;
        this.card = card;
        this.skillType = skillType;
        this.name = name;
    }
    public Tile(String name,int skillType,boolean topSide,boolean rightSide,boolean bottomSide,boolean leftSide) {
        this.rightSide = rightSide;
        this.leftSide = leftSide;
        this.topSide = topSide;
        this.bottomSide = bottomSide;
        this.card = null;
        this.heroesOn = new ArrayList<Hero>();
        this.skillType = skillType;
        this.name = name;
    }

    public Tile(String name, int skillType, boolean token, int cultistNum, ArrayList<Hero> heroesOn, boolean onBoard, boolean inVoid, Card card, boolean topSide, boolean bottomSide, boolean leftSide, boolean rightSide) {
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


    public void rotateCounterClockwise(){
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
    public void rotateClockwise(){
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
        if(degRot==270){
            degRot=0;
        }
        else{
            degRot+=90;
        }
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public String toString(){
        return name.charAt(0)+"";
    }

    public boolean isCollapsing() {
        return collapsing;
    }

    public void setCollapsing(boolean collapsing) {
        this.collapsing = collapsing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillType() {
        return skillType;
    }

    public void setSkillType(int skillType) {
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

}
