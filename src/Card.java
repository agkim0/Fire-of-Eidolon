public class Card {
    private String name;
    private int skillType;
    private Tile tile;
    private boolean event;
    public static final int STR = 0;
    public static final int DEX = 1;
    public static final int INTEL = 2;
    public static final int SPECIAL = 3;

    public Card(String name, int skillType, Tile tile, boolean event) {
        this.name = name;
        this.skillType = skillType;
        this.tile = tile;
        this.event = event;
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

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }
}
