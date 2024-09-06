public class Card {
    private String name;
    private String skillType;
    private Tile tile;
    private boolean event;

    public Card(String name, String skillType, Tile tile, boolean event) {
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

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
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
