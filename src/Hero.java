import java.io.Serializable;
import java.util.ArrayList;
public class Hero implements Serializable {
    private String name = "";
    private int strengthLevel;
    private int dexLevel;
    private int intelLevel;
    private int strTokenCount;
    private int dexTokenCount;
    private int intelTokenCount;
    private boolean hasFOE;
    private boolean fallen;
    private boolean dead;
    private boolean specialUsed;
    private int apCount;
    private boolean playing;

    public Hero(String name, int strengthLevel,int dexLevel,int intelLevel, int strTokenCount,int dexTokenCount,int intelTokenCount,boolean hasFOE, boolean fallen,boolean dead, boolean specialUsed, int apCount, boolean playing){
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.dexLevel = dexLevel;
        this.intelLevel = intelLevel;
        this.strTokenCount = strTokenCount;
        this.dexTokenCount = dexTokenCount;
        this.intelTokenCount = intelTokenCount;
        this.hasFOE = hasFOE;
        this.fallen = fallen;
        this.dead = dead;
        this.specialUsed = specialUsed;
        this.apCount = apCount;
        this.playing = playing;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStrengthLevel() {
        return strengthLevel;
    }
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }
    public int getDexLevel() {
        return dexLevel;
    }
    public void setDexLevel(int dexLevel) {
        this.dexLevel = dexLevel;
    }
    public int getIntelLevel() {
        return intelLevel;
    }
    public void setIntelLevel(int intelLevel) {
        this.intelLevel = intelLevel;
    }
    public int getStrTokenCount() {
        return strTokenCount;
    }
    public void setStrTokenCount(int strTokenCount) {
        this.strTokenCount = strTokenCount;
    }
    public int getDexTokenCount() {
        return dexTokenCount;
    }
    public void setDexTokenCount(int dexTokenCount) {
        this.dexTokenCount = dexTokenCount;
    }
    public int getIntelTokenCount() {
        return intelTokenCount;
    }
    public void setIntelTokenCount(int intelTokenCount) {
        this.intelTokenCount = intelTokenCount;
    }
    public boolean isHasFOE() {
        return hasFOE;
    }
    public void setHasFOE(boolean hasFOE) {
        this.hasFOE = hasFOE;
    }
    public boolean isFallen() {
        return fallen;
    }
    public void setFallen(boolean fallen) {
        this.fallen = fallen;
    }
    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public boolean isSpecialUsed() {
        return specialUsed;
    }
    public void setSpecialUsed(boolean specialUsed) {
        this.specialUsed = specialUsed;
    }
    public int getSpCount() {
        return apCount;
    }
    public void setSpCount(int spCount) {
        this.apCount = spCount;
    }
    public boolean isPlaying(){return playing;}
    public void setPlaying(boolean playing){this.playing = playing;}
    public void passiveAbility(){

    }
    public void specialAbility(){

    }
}
