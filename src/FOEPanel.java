import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
public class FOEPanel extends JPanel{
    private GameData gameData;
    private boolean hostGameSetUpScreen;//screen that the host enters in order to set game rules
        private boolean showUnstableVoid = false;
        private boolean showVagrantPortal = false;
        private boolean showInvasionOfTheShadowCult = false;
        private boolean showShadesOfVorax = false;
    private boolean drawRitualDeck = false;
    private boolean hostRoomCodeScreen;
    private boolean setUpJoinScreen;
    private boolean drawTitlePage;
    private boolean characterselectscreen;
    private boolean gamescreen;
    private boolean ccscreen;
    private boolean drawrulebook;
    private String rbNum;
    private boolean showingTileOnTop;
    private Tile[][] board = new Tile[5][5];

    public boolean isShowingTileOnTop() {
        return showingTileOnTop;
    }
    public void setShowingTileOnTop(boolean showingTileOnTop) {
        this.showingTileOnTop = showingTileOnTop;
    }
    public Tile[][] getBoard() {
        return board;
    }
    public void setBoard(Tile[][] board) {
        this.board = board;
    }
    public String getRbNum() {
        return rbNum;
    }
    public void setRbNum(String rbNum) {
        this.rbNum = rbNum;
    }
    public boolean isDrawrulebook() {
        return drawrulebook;
    }
    public void setDrawrulebook(boolean drawrulebook) {
        this.drawrulebook = drawrulebook;
    }
    public void setCcscreen(boolean ccscreen) {
        this.ccscreen = ccscreen;
    }
    public boolean isGamescreen() {
        return gamescreen;
    }
    public void setGamescreen(boolean gamescreen) {
        this.gamescreen = gamescreen;
    }
    public boolean isCharacterselectscreen() {
        return characterselectscreen;
    }
    public void setCharacterselectscreen(boolean characterselectscreen) {
        this.characterselectscreen = characterselectscreen;
    }
    public final int AELFRIC = 0;
    public final int CECELIA = 1;
    public final int DAGA = 2;
    public final int KALISTOS = 3;
    public final int KAYLANA = 4;
    public final int SIRIUS = 5;
    private int curHero;
    private int ind = 0;
    private BufferedImage rotated;

    public int getInd() {
        return ind;
    }
    public void setInd(int ind) {
        this.ind = ind;
    }
    public int getCurHero() {
        return curHero;
    }
    public void setCurHero(int curHero) {
        this.curHero = curHero;
    }
    public boolean isSetUpJoinScreen() {
        return setUpJoinScreen;
    }
    public void setSetUpJoinScreen(boolean setUpJoinScreen) {
        this.setUpJoinScreen = setUpJoinScreen;
    }

    private BufferedImage logo = null;

    private BufferedImage aelfric_Token = null;
    private BufferedImage aelfric_Action_Token = null;
    private BufferedImage aelfric_Special_Token = null;
    private BufferedImage aelfric_Character_Card = null;
    private BufferedImage cecelia_Token = null;
    private BufferedImage cecelia_Action_Token = null;
    private BufferedImage cecelia_Special_Token = null;
    private BufferedImage cecelia_Character_Card = null;
    private BufferedImage daga_Token = null;
    private BufferedImage daga_Action_Token = null;
    private BufferedImage daga_Special_Token = null;
    private BufferedImage daga_Character_Card = null;
    private BufferedImage kalistos_Token = null;
    private BufferedImage kalistos_Action_Token = null;
    private BufferedImage kalistos_Special_Token = null;
    private BufferedImage kalistos_Character_Card = null;
    private BufferedImage kaylana_Token = null;
    private BufferedImage kaylana_Action_Token = null;
    private BufferedImage kaylana_Special_Token = null;
    private BufferedImage kaylana_Character_Card = null;
    private BufferedImage sirius_Token = null;
    private BufferedImage sirius_Action_Token = null;
    private BufferedImage sirius_Special_Token = null;
    private BufferedImage sirius_Character_Card = null;
    private BufferedImage back_Of_CC = null;

    private BufferedImage difficulty_Levels = null;
    private BufferedImage df_Beginner = null;
    private BufferedImage df_Normal = null;
    private BufferedImage df_Extreme = null;
    private BufferedImage df_Glitch = null;
    private BufferedImage df_Hard = null;
    private BufferedImage df_Heroic = null;
    private BufferedImage df_Legendary = null;
    private BufferedImage df_Nightmare = null;
    private BufferedImage df_VeryHard = null;
    private BufferedImage scenario_1 = null;
    private BufferedImage scenario_2 = null;
    private BufferedImage scenario_3 = null;
    private BufferedImage scenario_4 = null;

    private BufferedImage df_BeginnerLevelBar = null;
    private BufferedImage df_NormalLevelBar = null;
    private BufferedImage df_ExtremeLevelBar = null;
    private BufferedImage df_GlitchLevelBar = null;
    private BufferedImage df_HardLevelBar = null;
    private BufferedImage df_HeroicLevelBar = null;
    private BufferedImage df_LegendaryLevelBar = null;
    private BufferedImage df_NightmareLevelBar = null;
    private BufferedImage df_VeryHardLevelBar = null;

    private BufferedImage back_Of_CT = null;
    private BufferedImage ct_AcidJets = null;
    private BufferedImage ct_AcidJets_90 = null;
    private BufferedImage ct_AcidJets_180 = null;
    private BufferedImage ct_AcidJets_270 = null;
    private BufferedImage ct_ArrowTrap = null;
    private BufferedImage ct_ArrowTrap_90 = null;
    private BufferedImage ct_ArrowTrap_180 = null;
    private BufferedImage ct_ArrowTrap_270 = null;
    private BufferedImage ct_DarkSlime = null;
    private BufferedImage ct_DarkSlime_90 = null;
    private BufferedImage ct_DarkSlime_180 = null;
    private BufferedImage ct_DarkSlime_270 = null;
    private BufferedImage ct_DenofSnakes = null;
    private BufferedImage ct_DenofSnakes_90 = null;
    private BufferedImage ct_DenofSnakes_180 = null;
    private BufferedImage ct_DenofSnakes_270 = null;
    private BufferedImage ct_Dragonling = null;
    private BufferedImage ct_Dragonling_90 = null;
    private BufferedImage ct_Dragonling_180 = null;
    private BufferedImage ct_Dragonling_270 = null;
    private BufferedImage ct_FelKnight = null;
    private BufferedImage ct_FelKnight_90 = null;
    private BufferedImage ct_FelKnight_180 = null;
    private BufferedImage ct_FelKnight_270 = null;
    private BufferedImage ct_FOE = null;
    private BufferedImage ct_FOE_90 = null;
    private BufferedImage ct_FOE_180 = null;
    private BufferedImage ct_FOE_270 = null;
    private BufferedImage ct_FloatingStones = null;
    private BufferedImage ct_FloatingStones_90 = null;
    private BufferedImage ct_FloatingStones_180 = null;
    private BufferedImage ct_FloatingStones_270 = null;
    private BufferedImage ct_HallofIlusions = null;
    private BufferedImage ct_HallofIlusions_90 = null;
    private BufferedImage ct_HallofIlusions_180 = null;
    private BufferedImage ct_HallofIlusions_270 = null;
    private BufferedImage ct_LaughingShadow = null;
    private BufferedImage ct_LaughingShadow_90 = null;
    private BufferedImage ct_LaughingShadow_180 = null;
    private BufferedImage ct_LaughingShadow_270 = null;
    private BufferedImage ct_LavaLake = null;
    private BufferedImage ct_LavaLake_90 = null;
    private BufferedImage ct_LavaLake_180 = null;
    private BufferedImage ct_LavaLake_270 = null;
    private BufferedImage ct_MimicChest = null;
    private BufferedImage ct_MimicChest_90 = null;
    private BufferedImage ct_MimicChest_180 = null;
    private BufferedImage ct_MimicChest_270 = null;
    private BufferedImage ct_Mindreader = null;
    private BufferedImage ct_Mindreader_90 = null;
    private BufferedImage ct_Mindreader_180 = null;
    private BufferedImage ct_Mindreader_270 = null;
    private BufferedImage ct_Minotaur = null;
    private BufferedImage ct_Minotaur_90 = null;
    private BufferedImage ct_Minotaur_180 = null;
    private BufferedImage ct_Minotaur_270 = null;
    private BufferedImage ct_OgerBrute = null;
    private BufferedImage ct_OgerBrute_90 = null;
    private BufferedImage ct_OgerBrute_180 = null;
    private BufferedImage ct_OgerBrute_270 = null;
    private BufferedImage ct_ParodoxPuzzle = null;
    private BufferedImage ct_ParodoxPuzzle_90 = null;
    private BufferedImage ct_ParodoxPuzzle_180 = null;
    private BufferedImage ct_ParodoxPuzzle_270 = null;
    private BufferedImage ct_PengulumBlades = null;
    private BufferedImage ct_PengulumBlades_90 = null;
    private BufferedImage ct_PengulumBlades_180 = null;
    private BufferedImage ct_PengulumBlades_270 = null;
    private BufferedImage ct_Portal = null;
    private BufferedImage ct_Portal_90 = null;
    private BufferedImage ct_Portal_180 = null;
    private BufferedImage ct_Portal_270 = null;
    private BufferedImage ct_Psycomancer = null;
    private BufferedImage ct_Psycomancer_90 = null;
    private BufferedImage ct_Psycomancer_180 = null;
    private BufferedImage ct_Psycomancer_270 = null;
    private BufferedImage ct_SPX = null;
    private BufferedImage ct_SPX_90 = null;
    private BufferedImage ct_SPX_180 = null;
    private BufferedImage ct_SPX_270 = null;
    private BufferedImage ct_SPY = null;
    private BufferedImage ct_SPY_90 = null;
    private BufferedImage ct_SPY_180 = null;
    private BufferedImage ct_SPY_270 = null;
    private BufferedImage ct_SkeletonGuards = null;
    private BufferedImage ct_SkeletonGuards_90 = null;
    private BufferedImage ct_SkeletonGuards_180 = null;
    private BufferedImage ct_SkeletonGuards_270 = null;
    private BufferedImage ct_SphynxsRiddle = null;
    private BufferedImage ct_SphynxsRiddle_90 = null;
    private BufferedImage ct_SphynxsRiddle_180 = null;
    private BufferedImage ct_SphynxsRiddle_270 = null;
    private BufferedImage ct_SpikedPit = null;
    private BufferedImage ct_SpikedPit_90 = null;
    private BufferedImage ct_SpikedPit_180 = null;
    private BufferedImage ct_SpikedPit_270 = null;
    private BufferedImage ct_Vestibule = null;
    private BufferedImage ct_Vestibule_90 = null;
    private BufferedImage ct_Vestibule_180 = null;
    private BufferedImage ct_Vestibule_270 = null;
    private BufferedImage ct_VoraciousPlant = null;
    private BufferedImage ct_VoraciousPlant_90 = null;
    private BufferedImage ct_VoraciousPlant_180 = null;
    private BufferedImage ct_VoraciousPlant_270 = null;
    private BufferedImage ct_VoraxsFocus = null;
    private BufferedImage ct_VoraxsFocus_90 = null;
    private BufferedImage ct_VoraxsFocus_180 = null;
    private BufferedImage ct_VoraxsFocus_270 = null;
    private BufferedImage ct_VoraxsHeart = null;
    private BufferedImage ct_VoraxsHeart_90 = null;
    private BufferedImage ct_VoraxsHeart_180 = null;
    private BufferedImage ct_VoraxsHeart_270 = null;
    private BufferedImage ct_VoraxsKnowledge = null;
    private BufferedImage ct_VoraxsKnowledge_90 = null;
    private BufferedImage ct_VoraxsKnowledge_180 = null;
    private BufferedImage ct_VoraxsKnowledge_270 = null;

    private BufferedImage back_Of_RDC = null;
    private BufferedImage rdc_AcidJets = null;
    private BufferedImage rdc_ArrowTrap = null;
    private BufferedImage rdc_BlueEvent = null;
    private BufferedImage rdc_GreenEvent = null;
    private BufferedImage rdc_RedEvent = null;
    private BufferedImage rdc_DarkSlime = null;
    private BufferedImage rdc_DenofSnakes = null;
    private BufferedImage rdc_Dragonling = null;
    private BufferedImage rdc_FelKnight = null;
    private BufferedImage rdc_FloatingStones = null;
    private BufferedImage rdc_HallofIlusions = null;
    private BufferedImage rdc_LaughingShadow = null;
    private BufferedImage rdc_LavaLake = null;
    private BufferedImage rdc_MimicChest = null;
    private BufferedImage rdc_Mindreader = null;
    private BufferedImage rdc_Minotaur = null;
    private BufferedImage rdc_OgerBrute = null;
    private BufferedImage rdc_ParodoxPuzzle = null;
    private BufferedImage rdc_PengulumBlades = null;
    private BufferedImage rdc_Psycomancer = null;
    private BufferedImage rdc_SkeletonGuards = null;
    private BufferedImage rdc_SphynxsRiddle = null;
    private BufferedImage rdc_SpikedPit = null;
    private BufferedImage rdc_VoraciousPlant = null;

    private BufferedImage rb_1 = null;
    private BufferedImage rb_2 = null;
    private BufferedImage rb_3 = null;
    private BufferedImage rb_4 = null;
    private BufferedImage rb_5 = null;
    private BufferedImage rb_6 = null;
    private BufferedImage rb_7 = null;
    private BufferedImage rb_8 = null;
    private BufferedImage rb_9 = null;

    private BufferedImage book_Relic_Front = null;
    private BufferedImage book_Relic_Back = null;
    private BufferedImage crystal_Relic_Front = null;
    private BufferedImage crystal_Relic_Back = null;
    private BufferedImage heart_Relic_Front = null;
    private BufferedImage heart_Relic_Back = null;
    private BufferedImage cultist_Token = null;
    private BufferedImage dex_Token = null;
    private BufferedImage str_Token = null;
    private BufferedImage int_Token = null;
    private BufferedImage fireBall_Token = null;
    private BufferedImage tl_Token = null;
    private BufferedImage blueVorax_Token = null;
    private BufferedImage greenVorax_Token = null;
    private BufferedImage purpleVorax_Token = null;
    private BufferedImage redVorax_Token = null;
    BufferedImage bg;
    public FOEPanel() throws IOException{
        setSize(1500,1000);
        this.gameData = new GameData();
        bg =ImageIO.read(new File("Game Images/eidolon bg.png"));
        {
            logo = ImageIO.read(new File("Game images/Fire of Eidolon Title.png"));
            aelfric_Token = ImageIO.read(new File("token pieces/character tokens/aelfric character token(Fix).png"));
            aelfric_Action_Token = ImageIO.read(new File("character cards/aelfric action.png"));
            aelfric_Special_Token = ImageIO.read(new File("character cards/aelfric special.png"));
            aelfric_Character_Card = ImageIO.read(new File("character cards/aelfric character card.png"));
            cecelia_Token = ImageIO.read(new File("token pieces/character tokens/cecelia character token(Fix).png"));
            cecelia_Action_Token = ImageIO.read(new File("character cards/cecelia action.png"));
            cecelia_Special_Token = ImageIO.read(new File("character cards/cecelia special.png"));
            cecelia_Character_Card = ImageIO.read(new File("character cards/cecelia character card.png"));
            daga_Token = ImageIO.read(new File("token pieces/character tokens/daga character token(Fix).png"));
            daga_Action_Token = ImageIO.read(new File("character cards/daga action.png"));
            daga_Special_Token = ImageIO.read(new File("character cards/daga special.png"));
            daga_Character_Card = ImageIO.read(new File("character cards/daga character card.png"));
            kalistos_Token = ImageIO.read(new File("token pieces/character tokens/kalistos character token(Fix).png"));
            kalistos_Action_Token = ImageIO.read(new File("character cards/kalistos action.png"));
            kalistos_Special_Token = ImageIO.read(new File("character cards/kalistos special.png"));
            kalistos_Character_Card = ImageIO.read(new File("character cards/kalistos character card.png"));
            kaylana_Token = ImageIO.read(new File("token pieces/character tokens/kaylana character token(Fix).png"));
            kaylana_Action_Token = ImageIO.read(new File("character cards/kaylana action.png"));
            kaylana_Special_Token = ImageIO.read(new File("character cards/kaylana special.png"));
            kaylana_Character_Card = ImageIO.read(new File("character cards/kaylana character card.png"));
            sirius_Token = ImageIO.read(new File("token pieces/character tokens/sirius character token(Fix).png"));
            sirius_Action_Token = ImageIO.read(new File("character cards/sirius action.png"));
            sirius_Special_Token = ImageIO.read(new File("character cards/sirius special.png"));
            sirius_Character_Card = ImageIO.read(new File("character cards/sirius character card.png"));
            back_Of_CC = ImageIO.read(new File("character cards/Hero Card Back Side.png"));//token images

            difficulty_Levels = ImageIO.read(new File("difficulty cards/difficulty levels.png"));
            df_Beginner = ImageIO.read(new File("difficulty cards/beginner difficulty card (Fixed).png"));
            df_Normal = ImageIO.read(new File("difficulty cards/normal difficulty card(Fixed).png"));
            df_Extreme = ImageIO.read(new File("difficulty cards/extreme.png"));
            df_Glitch = ImageIO.read(new File("difficulty cards/glitch.png"));
            df_Hard = ImageIO.read(new File("difficulty cards/hard.png"));
            df_Heroic = ImageIO.read(new File("difficulty cards/heroic.png"));
            df_Legendary = ImageIO.read(new File("difficulty cards/legendary.png"));
            df_Nightmare = ImageIO.read(new File("difficulty cards/nightmare.png"));
            df_VeryHard = ImageIO.read(new File("difficulty cards/very hard.png"));
            scenario_1 = ImageIO.read(new File("difficulty cards/scenario 1.png"));
            scenario_2 = ImageIO.read(new File("difficulty cards/scenario 2.png"));
            scenario_3 = ImageIO.read(new File("difficulty cards/scenario 3.png"));
            scenario_4 = ImageIO.read(new File("difficulty cards/scenario 4.png"));//difficulty and secnario images

            df_BeginnerLevelBar = ImageIO.read(new File("difficulty cards/beginner difficulty level bar.png"));
            df_NormalLevelBar = ImageIO.read(new File("difficulty cards/normal difficulty level bar.png"));
            df_ExtremeLevelBar = ImageIO.read(new File("difficulty cards/extreme difficulty level bar.png"));
            df_GlitchLevelBar = ImageIO.read(new File("difficulty cards/glitch difficulty level bar.png"));
            df_HardLevelBar = ImageIO.read(new File("difficulty cards/hard difficulty level bar.png"));
            df_HeroicLevelBar = ImageIO.read(new File("difficulty cards/heroic difficulty level bar.png"));
            df_LegendaryLevelBar = ImageIO.read(new File("difficulty cards/legendary difficulty level bar.png"));
            df_NightmareLevelBar = ImageIO.read(new File("difficulty cards/nightmare difficulty level bar.png"));
            df_VeryHardLevelBar = ImageIO.read(new File("difficulty cards/very hard difficulty bar.png"));

            ct_AcidJets = ImageIO.read(new File("Game images/Chamber Tiles/Acid jets.png"));
            ct_AcidJets_90 = ImageIO.read(new File("Game images/Chamber Tiles/Acid jets_90.png"));
            ct_AcidJets_180 = ImageIO.read(new File("Game images/Chamber Tiles/Acid jets_180.png"));
            ct_AcidJets_270 = ImageIO.read(new File("Game images/Chamber Tiles/Acid jets_270.png"));
            ct_ArrowTrap = ImageIO.read(new File("Game images/Chamber Tiles/Arrow Trap(final).png"));
            ct_ArrowTrap_90 = ImageIO.read(new File("Game images/Chamber Tiles/Arrow Trap_90.png"));
            ct_ArrowTrap_180 = ImageIO.read(new File("Game images/Chamber Tiles/Arrow Trap_180.png"));
            ct_ArrowTrap_270 = ImageIO.read(new File("Game images/Chamber Tiles/Arrow Trap_270.png"));
            back_Of_CT = ImageIO.read(new File("Game images/Chamber Tiles/Back of tiles.png"));
            ct_DarkSlime = ImageIO.read(new File("Game images/Chamber Tiles/Dark Slime.png"));
            ct_DarkSlime_90 = ImageIO.read(new File("Game images/Chamber Tiles/Dark Slime_90.png"));
            ct_DarkSlime_180 = ImageIO.read(new File("Game images/Chamber Tiles/Dark Slime_180.png"));
            ct_DarkSlime_270 = ImageIO.read(new File("Game images/Chamber Tiles/Dark Slime_270.png"));
            ct_DenofSnakes = ImageIO.read(new File("Game images/Chamber Tiles/Den of Snakes(final).png"));
            ct_DenofSnakes_90 = ImageIO.read(new File("Game images/Chamber Tiles/Den of Snakes_90.png"));
            ct_DenofSnakes_180 = ImageIO.read(new File("Game images/Chamber Tiles/Den of Snakes_180.png"));
            ct_DenofSnakes_270 = ImageIO.read(new File("Game images/Chamber Tiles/Den of Snakes_270.png"));
            ct_Dragonling = ImageIO.read(new File("Game images/Chamber Tiles/Dragonling.png"));
            ct_Dragonling_90 = ImageIO.read(new File("Game images/Chamber Tiles/Dragonling_90.png"));
            ct_Dragonling_180 = ImageIO.read(new File("Game images/Chamber Tiles/Dragonling_180.png"));
            ct_Dragonling_270 = ImageIO.read(new File("Game images/Chamber Tiles/Dragonling_270.png"));
            ct_FelKnight = ImageIO.read(new File("Game images/Chamber Tiles/Fel Knight(final).png"));
            ct_FelKnight_90 = ImageIO.read(new File("Game images/Chamber Tiles/Fel Knight_90.png"));
            ct_FelKnight_180 = ImageIO.read(new File("Game images/Chamber Tiles/Fel Knight_180.png"));
            ct_FelKnight_270 = ImageIO.read(new File("Game images/Chamber Tiles/Fel Knight_270.png"));
            ct_FOE = ImageIO.read(new File("Game images/Chamber Tiles/Fire of Eidolon(final).png"));
            ct_FOE_90 = ImageIO.read(new File("Game images/Chamber Tiles/Fire of Eidolon_90.png"));
            ct_FOE_180 = ImageIO.read(new File("Game images/Chamber Tiles/Fire of Eidolon_180.png"));
            ct_FOE_270 = ImageIO.read(new File("Game images/Chamber Tiles/Fire of Eidolon_270.png"));
            ct_FloatingStones = ImageIO.read(new File("Game images/Chamber Tiles/Floating Stones(final).png"));
            ct_FloatingStones_90 = ImageIO.read(new File("Game images/Chamber Tiles/Floating Stones_90.png"));
            ct_FloatingStones_180 = ImageIO.read(new File("Game images/Chamber Tiles/Floating Stones_180.png"));
            ct_FloatingStones_270 = ImageIO.read(new File("Game images/Chamber Tiles/Floating Stones_270.png"));
            ct_HallofIlusions = ImageIO.read(new File("Game images/Chamber Tiles/Hall of Ilusions(final).png"));
            ct_HallofIlusions_90 = ImageIO.read(new File("Game images/Chamber Tiles/Hall of Ilusions_90.png"));
            ct_HallofIlusions_180 = ImageIO.read(new File("Game images/Chamber Tiles/Hall of Ilusions_180.png"));
            ct_HallofIlusions_270 = ImageIO.read(new File("Game images/Chamber Tiles/Hall of Ilusions_270.png"));
            ct_LaughingShadow = ImageIO.read(new File("Game images/Chamber Tiles/Laughing Shadow.png"));
            ct_LaughingShadow_90 = ImageIO.read(new File("Game images/Chamber Tiles/Laughing Shadow_90.png"));
            ct_LaughingShadow_180 = ImageIO.read(new File("Game images/Chamber Tiles/Laughing Shadow_180.png"));
            ct_LaughingShadow_270 = ImageIO.read(new File("Game images/Chamber Tiles/Laughing Shadow_270.png"));
            ct_LavaLake = ImageIO.read(new File("Game images/Chamber Tiles/Lava Lake(final).png"));
            ct_LavaLake_90 = ImageIO.read(new File("Game images/Chamber Tiles/Lava Lake_90.png"));
            ct_LavaLake_180 = ImageIO.read(new File("Game images/Chamber Tiles/Lava Lake_180.png"));
            ct_LavaLake_270 = ImageIO.read(new File("Game images/Chamber Tiles/Lava Lake_270.png"));
            ct_MimicChest = ImageIO.read(new File("Game images/Chamber Tiles/Mimic Chest.png"));
            ct_MimicChest_90 = ImageIO.read(new File("Game images/Chamber Tiles/Mimic Chest_90.png"));
            ct_MimicChest_180 = ImageIO.read(new File("Game images/Chamber Tiles/Mimic Chest_180.png"));
            ct_MimicChest_270 = ImageIO.read(new File("Game images/Chamber Tiles/Mimic Chest_270.png"));
            ct_Mindreader = ImageIO.read(new File("Game images/Chamber Tiles/Mindreader(final).png"));
            ct_Mindreader_90 = ImageIO.read(new File("Game images/Chamber Tiles/Mindreader_90.png"));
            ct_Mindreader_180 = ImageIO.read(new File("Game images/Chamber Tiles/Mindreader_180.png"));
            ct_Mindreader_270 = ImageIO.read(new File("Game images/Chamber Tiles/Mindreader_270.png"));
            ct_Minotaur = ImageIO.read(new File("Game images/Chamber Tiles/Minotaur.png"));
            ct_Minotaur_90 = ImageIO.read(new File("Game images/Chamber Tiles/Minotaur_90.png"));
            ct_Minotaur_180 = ImageIO.read(new File("Game images/Chamber Tiles/Minotaur_180.png"));
            ct_Minotaur_270 = ImageIO.read(new File("Game images/Chamber Tiles/Minotaur_270.png"));
            ct_OgerBrute = ImageIO.read(new File("Game images/Chamber Tiles/Oger Brute.png"));
            ct_OgerBrute_90 = ImageIO.read(new File("Game images/Chamber Tiles/Oger Brute_90.png"));
            ct_OgerBrute_180 = ImageIO.read(new File("Game images/Chamber Tiles/Oger Brute_180.png"));
            ct_OgerBrute_270 = ImageIO.read(new File("Game images/Chamber Tiles/Oger Brute_270.png"));
            ct_ParodoxPuzzle = ImageIO.read(new File("Game images/Chamber Tiles/Paradox puzzle(final).png"));
            ct_ParodoxPuzzle_90 = ImageIO.read(new File("Game images/Chamber Tiles/Paradox puzzle_90.png"));
            ct_ParodoxPuzzle_180 = ImageIO.read(new File("Game images/Chamber Tiles/Paradox puzzle_180.png"));
            ct_ParodoxPuzzle_270 = ImageIO.read(new File("Game images/Chamber Tiles/Paradox puzzle_270.png"));
            ct_PengulumBlades = ImageIO.read(new File("Game images/Chamber Tiles/Pengulum Blades(final).png"));
            ct_PengulumBlades_90 = ImageIO.read(new File("Game images/Chamber Tiles/Pengulum Blades_90.png"));
            ct_PengulumBlades_180 = ImageIO.read(new File("Game images/Chamber Tiles/Pengulum Blades_180.png"));
            ct_PengulumBlades_270 = ImageIO.read(new File("Game images/Chamber Tiles/Pengulum Blades_270.png"));
            ct_Portal = ImageIO.read(new File("Game images/Chamber Tiles/Portal(final).png"));
            ct_Portal_90 = ImageIO.read(new File("Game images/Chamber Tiles/Portal_90.png"));
            ct_Portal_180 = ImageIO.read(new File("Game images/Chamber Tiles/Portal_180.png"));
            ct_Portal_270 = ImageIO.read(new File("Game images/Chamber Tiles/Portal_270.png"));
            ct_Psycomancer = ImageIO.read(new File("Game images/Chamber Tiles/Psychomancer(final).png"));
            ct_Psycomancer_90 = ImageIO.read(new File("Game images/Chamber Tiles/Psychomancer_90.png"));
            ct_Psycomancer_180 = ImageIO.read(new File("Game images/Chamber Tiles/Psychomancer_180.png"));
            ct_Psycomancer_270 = ImageIO.read(new File("Game images/Chamber Tiles/Psychomancer_270.png"));
            ct_SPX = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage X.png"));
            ct_SPX_90 = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage X_90.png"));
            ct_SPX_180 = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage X_180.png"));
            ct_SPX_270 = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage X_270.png"));
            ct_SPY = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage Y(final).png"));
            ct_SPY_90 = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage Y_90.png"));
            ct_SPY_180 = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage Y_180.png"));
            ct_SPY_270 = ImageIO.read(new File("Game images/Chamber Tiles/Secret Passage Y_270.png"));
            ct_SkeletonGuards = ImageIO.read(new File("Game images/Chamber Tiles/Skeleton Guards(final).png"));
            ct_SkeletonGuards_90 = ImageIO.read(new File("Game images/Chamber Tiles/Skeleton Guards_90.png"));
            ct_SkeletonGuards_180 = ImageIO.read(new File("Game images/Chamber Tiles/Skeleton Guards_180.png"));
            ct_SkeletonGuards_270 = ImageIO.read(new File("Game images/Chamber Tiles/Skeleton Guards_270.png"));
            ct_SphynxsRiddle = ImageIO.read(new File("Game images/Chamber Tiles/Sphynx_s Riddle.png"));
            ct_SphynxsRiddle_90 = ImageIO.read(new File("Game images/Chamber Tiles/Sphynx's Riddle_90.png"));
            ct_SphynxsRiddle_180 = ImageIO.read(new File("Game images/Chamber Tiles/Sphynx's Riddle_180.png"));
            ct_SphynxsRiddle_270 = ImageIO.read(new File("Game images/Chamber Tiles/Sphynx's Riddle_270.png"));
            ct_SpikedPit = ImageIO.read(new File("Game images/Chamber Tiles/Spiked pit.png"));
            ct_SpikedPit_90 = ImageIO.read(new File("Game images/Chamber Tiles/Spiked pit_90.png"));
            ct_SpikedPit_180 = ImageIO.read(new File("Game images/Chamber Tiles/Spiked pit_180.png"));
            ct_SpikedPit_270 = ImageIO.read(new File("Game images/Chamber Tiles/Spiked pit_270.png"));
            ct_Vestibule = ImageIO.read(new File("Game images/Chamber Tiles/Start.png"));
            ct_VoraciousPlant = ImageIO.read(new File("Game images/Chamber Tiles/Voracious Plant(final).png"));
            ct_VoraciousPlant_90 = ImageIO.read(new File("Game images/Chamber Tiles/Voracious Plant_90.png"));
            ct_VoraciousPlant_180 = ImageIO.read(new File("Game images/Chamber Tiles/Voracious Plant_180.png"));
            ct_VoraciousPlant_270 = ImageIO.read(new File("Game images/Chamber Tiles/Voracious Plant_270.png"));
            ct_VoraxsFocus = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Focus(final).png"));
            ct_VoraxsFocus_90 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Focus_90.png"));
            ct_VoraxsFocus_180 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Focus_180.png"));
            ct_VoraxsFocus_270 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Focus_270.png"));
            ct_VoraxsHeart = ImageIO.read(new File("Game images/Chamber Tiles/Vorax_s Heart.png"));
            ct_VoraxsHeart_90 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Heart_90.png"));
            ct_VoraxsHeart_180 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Heart _180.png"));
            ct_VoraxsHeart_270 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Heart _270.png"));
            ct_VoraxsKnowledge = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Knowledge(final).png"));
            ct_VoraxsKnowledge_90 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Knowledge_90.png"));
            ct_VoraxsKnowledge_180 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Knowledge_180.png"));
            ct_VoraxsKnowledge_270 = ImageIO.read(new File("Game images/Chamber Tiles/Vorax's Knowledge_270.png"));//chamber tiles

            back_Of_RDC = ImageIO.read(new File("Game images/Ritual Deck Cards/Back of card.png"));
            rdc_AcidJets = ImageIO.read(new File("Game images/Ritual Deck Cards/Acid jets_card.png"));
            rdc_ArrowTrap = ImageIO.read(new File("Game images/Ritual Deck Cards/Arrow Trap_card.png"));
            rdc_DarkSlime = ImageIO.read(new File("Game images/Ritual Deck Cards/Dark Slime_card.png"));
            rdc_DenofSnakes = ImageIO.read(new File("Game images/Ritual Deck Cards/Den of Snakes_card.png"));
            rdc_Dragonling = ImageIO.read(new File("Game images/Ritual Deck Cards/Dragonling_card.png"));
            rdc_FelKnight = ImageIO.read(new File("Game images/Ritual Deck Cards/Fel Knight_card.png"));
            rdc_FloatingStones = ImageIO.read(new File("Game images/Ritual Deck Cards/Floating Stones_card.png"));
            rdc_HallofIlusions = ImageIO.read(new File("Game images/Ritual Deck Cards/Hall of Ilusions_card.png"));
            rdc_LaughingShadow = ImageIO.read(new File("Game images/Ritual Deck Cards/Laughing Shadow_card.png"));
            rdc_LavaLake = ImageIO.read(new File("Game images/Ritual Deck Cards/Lava Lake_card.png"));
            rdc_MimicChest = ImageIO.read(new File("Game images/Ritual Deck Cards/Mimic Chest_card.png"));
            rdc_Mindreader = ImageIO.read(new File("Game images/Ritual Deck Cards/Mindreader_card.png"));
            rdc_Minotaur = ImageIO.read(new File("Game images/Ritual Deck Cards/Minotaur_card.png"));
            rdc_OgerBrute = ImageIO.read(new File("Game images/Ritual Deck Cards/Oger Brute_card.png"));
            rdc_ParodoxPuzzle = ImageIO.read(new File("Game images/Ritual Deck Cards/Paradox puzzle_card.png"));
            rdc_PengulumBlades = ImageIO.read(new File("Game images/Ritual Deck Cards/Pengulum Blades_card.png"));
            rdc_Psycomancer = ImageIO.read(new File("Game images/Ritual Deck Cards/Psychomancer_card.png"));
            rdc_SkeletonGuards = ImageIO.read(new File("Game images/Ritual Deck Cards/Skeleton Guards_card.png"));
            rdc_SphynxsRiddle = ImageIO.read(new File("Game images/Ritual Deck Cards/Sphynx_s Riddle_card.png"));
            rdc_SpikedPit = ImageIO.read(new File("Game images/Ritual Deck Cards/Spiked pit_card.png"));
            rdc_VoraciousPlant = ImageIO.read(new File("Game images/Ritual Deck Cards/Voracious Plant_card.png"));
            rdc_BlueEvent = ImageIO.read(new File("Game images/Ritual Deck Cards/blue event card.png"));
            rdc_GreenEvent = ImageIO.read(new File("Game images/Ritual Deck Cards/green event card.png"));
            rdc_RedEvent = ImageIO.read(new File("Game images/Ritual Deck Cards/red event card.png"));

            rb_1 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-1.png"));
            rb_2 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-2.png"));
            rb_3 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-3.png"));
            rb_4 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-4.png"));
            rb_5 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-5.png"));
            rb_6 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-6.png"));
            rb_7 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-7.png"));
            rb_8 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-8.png"));
            rb_9 = ImageIO.read(new File("Rulebook/FireOfEidolon Rulebook-9.png"));

            book_Relic_Back = ImageIO.read(new File("token pieces/relics/book relic back.png"));
            book_Relic_Front = ImageIO.read(new File("token pieces/relics/book relic.png"));
            crystal_Relic_Back = ImageIO.read(new File("token pieces/relics/crystal relic back.png"));
            crystal_Relic_Front = ImageIO.read(new File("token pieces/relics/crystal relic.png"));
            heart_Relic_Back = ImageIO.read(new File("token pieces/relics/heart relic back.png"));
            heart_Relic_Front = ImageIO.read(new File("token pieces/relics/heart relic.png"));
            cultist_Token = ImageIO.read(new File("token pieces/tokens of power-cultist token/cultist token.png"));
            dex_Token = ImageIO.read(new File("token pieces/tokens of power-cultist token/dexterity token of power (fix).png"));
            int_Token = ImageIO.read(new File("token pieces/tokens of power-cultist token/intellect token of power (fix).png"));
            str_Token = ImageIO.read(new File("token pieces/tokens of power-cultist token/strength token of power (fix).png"));
            fireBall_Token = ImageIO.read(new File("token pieces/tokens of power-cultist token/fireball.png"));
            tl_Token = ImageIO.read(new File("token pieces/tokens of power-cultist token/threat level.png"));
            blueVorax_Token = ImageIO.read(new File("token pieces/voraxes/blue vorax.png"));
            redVorax_Token = ImageIO.read(new File("token pieces/voraxes/red vorax.png"));
            purpleVorax_Token = ImageIO.read(new File("token pieces/voraxes/purple vorax.png"));
            greenVorax_Token = ImageIO.read(new File("token pieces/voraxes/green vorax.png"));
        }
        
    }
    public void paint(Graphics g){
        g.drawImage(bg,0,0,1500,1000, null);
        g.setColor(Color.white);

        if(hostGameSetUpScreen){

            if(showUnstableVoid){
                g.drawImage(scenario_1,440,550,550,350,null);
            }
            if(showVagrantPortal){
                g.drawImage(scenario_2,440,550,550,350,null);
            }
            if(showInvasionOfTheShadowCult){
                g.drawImage(scenario_3,440,550,550,350,null);
            }
            if(showShadesOfVorax){
                g.drawImage(scenario_4,440,550,550,350,null);
            }
            if(gameData.getDifficultyLevel().equals("Beginner")){
                g.drawImage(df_Beginner,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Normal")){
                g.drawImage(df_Normal,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Hard")){
                g.drawImage(df_Hard,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Very Hard")){
                g.drawImage(df_VeryHard,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Extreme")){
                g.drawImage(df_Extreme,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Heroic")){
                g.drawImage(df_Heroic,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Nightmare")){
                g.drawImage(df_Nightmare,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Legendary")){
                g.drawImage(df_Legendary,1100,250,350,550,null);
            }
            if(gameData.getDifficultyLevel().equals("Glitch")){
                g.drawImage(df_Glitch,1100,250,350,550,null);
            }
            g.drawImage(logo,50,50,600,500,null);
            g.setFont(new Font("Sans Serif",Font.BOLD,20));
            g.drawString("Username:",500,100);

        }
        if(hostRoomCodeScreen){
            //System.out.println("drawhostroomcode");
            g.setFont(new Font("Sans Serif",Font.BOLD,20));
            //g.drawString("Username:",700,300);
            g.drawString("Room Code",500,450);
            g.drawImage(logo,500,-10,600,500,null);
        }
        if(setUpJoinScreen){
            //System.out.println("drawjoinscreen");
            g.setFont(new Font("Sans Serif",Font.BOLD,20));
            g.drawString("Username:",500,450);
            g.drawString("Room Code:",500,600);
            g.drawImage(logo,500,-10,600,500,null);
        }
        if(drawrulebook){
            //System.out.println("here");
            if(rbNum.equals("1")){
                g.drawImage(rb_1,100,50,600,900,null);
                g.drawImage(rb_2,750,50,600,900,null);
            }
            else if (rbNum.equals("3")){
                g.drawImage(rb_3,100,50,600,900,null);
                g.drawImage(rb_4,750,50,600,900,null);
            }
            else if (rbNum.equals("5")){
                g.drawImage(rb_5,100,50,600,900,null);
                g.drawImage(rb_6,750,50,600,900,null);
            }
            else if (rbNum.equals("7")){
                g.drawImage(rb_7,100,50,600,900,null);
                g.drawImage(rb_8,750,50,600,900,null);
            }
            else if (rbNum.equals("9")){
                g.drawImage(rb_9,100,50,600,900,null);
            }
        }
        if(characterselectscreen){
            //System.out.println("drawcharacterselectscreen");
            g.setFont(new Font("Sans Serif",Font.BOLD,50));
            g.drawString("Choose Your Hero:",500,200);
            if(curHero == AELFRIC){
                g.drawImage(aelfric_Character_Card,500,250,550,350,null);
            }
            else if(curHero == CECELIA){
                g.drawImage(cecelia_Character_Card,500,250,550,350,null);
            }
            else if(curHero == DAGA){
                g.drawImage(daga_Character_Card,500,250,550,350,null);
            }
            else if(curHero == KALISTOS){
                g.drawImage(kalistos_Character_Card,500,250,550,350,null);
            }
            else if(curHero == KAYLANA){
                g.drawImage(kaylana_Character_Card,500,250,550,350,null);
            }
            else if(curHero == SIRIUS){
                g.drawImage(sirius_Character_Card,500,250,550,350,null);
            }
        }
        if(drawTitlePage){
            //System.out.println("drawTitlePage");
            g.drawImage(logo,50,150,700,600,null);
            g.drawImage(aelfric_Token,100,810,125,125,null);
            g.drawImage(cecelia_Token,250,810,125,125,null);
            g.drawImage(daga_Token,400,810,125,125,null);
            g.drawImage(kalistos_Token,550,810,125,125,null);
            g.drawImage(kaylana_Token,700,810,125,125,null);
            g.drawImage(sirius_Token,850,810,125,125,null);
        }
        if(gamescreen){
            g.setFont(new Font("Sans Serif",Font.BOLD,100));
            if(gameData.getHeroesPlaying().size()==1){
                //System.out.println("one");
            }
            for(int x=0; x<gameData.getHeroesPlaying().size(); x++){
                if(gameData.getHeroesPlaying().get(x).getName().equals("Aelfric") && curHero == 0){
                    g.drawImage(aelfric_Token,25,575,130,130,null);
                    g.drawImage(aelfric_Action_Token,1250,40,100,100,null);
                    g.drawImage(aelfric_Special_Token,1250,155,100,100,null);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getDexTokenCount()),15,810);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getStrTokenCount()),185,925);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getIntelTokenCount()),15,925);
                }
                else if(gameData.getHeroesPlaying().get(x).getName().equals("Cecilia") && curHero == 1){
                    g.drawImage(cecelia_Token,25,575,130,130,null);
                    g.drawImage(cecelia_Action_Token,1250,40,100,100,null);
                    g.drawImage(cecelia_Special_Token,1250,155,100,100,null);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getDexTokenCount()),15,810);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getStrTokenCount()),185,925);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getIntelTokenCount()),15,925);
                }
                else if(gameData.getHeroesPlaying().get(x).getName().equals("Daga") && curHero == 2){
                    g.drawImage(daga_Token,25,575,130,130,null);
                    g.drawImage(daga_Action_Token,1250,40,100,100,null);
                    g.drawImage(daga_Special_Token,1250,155,100,100,null);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getDexTokenCount()),15,810);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getStrTokenCount()),185,925);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getIntelTokenCount()),15,925);
                }
                else if(gameData.getHeroesPlaying().get(x).getName().equals("Kalistos") && curHero == 3){
                    g.drawImage(kalistos_Token,25,575,130,130,null);
                    g.drawImage(kalistos_Action_Token,1250,40,100,100,null);
                    g.drawImage(kalistos_Special_Token,1250,155,100,100,null);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getDexTokenCount()),15,810);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getStrTokenCount()),185,925);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getIntelTokenCount()),15,925);
                }
                else if(gameData.getHeroesPlaying().get(x).getName().equals("Kaylana") && curHero == 4){
                    g.drawImage(kaylana_Token,25,575,130,130,null);
                    g.drawImage(kaylana_Action_Token,1250,10,100,100,null);
                    g.drawImage(kaylana_Special_Token,1250,125,100,100,null);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getDexTokenCount()),15,810);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getStrTokenCount()),185,925);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getIntelTokenCount()),15,925);
                }
                else if(gameData.getHeroesPlaying().get(x).getName().equals("Sirius") && curHero == 5){
                    g.drawImage(sirius_Token,25,575,130,130,null);
                    g.drawImage(sirius_Action_Token,1250,40,100,100,null);
                    g.drawImage(sirius_Special_Token,1250,155,100,100,null);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getDexTokenCount()),15,810);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getStrTokenCount()),185,925);
                    g.drawString(Integer.toString(gameData.getHeroesPlaying().get(x).getIntelTokenCount()),15,925);
                }
            }
            g.drawImage(dex_Token,65,720,125,125,null);
            g.drawImage(str_Token,230,835,110,110,null);
            g.drawImage(int_Token,65,835,125,125,null);
            if(gameData.getDifficultyLevel().equals("Beginner")){
                g.drawImage(df_BeginnerLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Normal")) {
                g.drawImage(df_NormalLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Hard")) {
                g.drawImage(df_HardLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Very Hard")) {
                g.drawImage(df_VeryHardLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Extreme")) {
                g.drawImage(df_ExtremeLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Heroic")) {
                g.drawImage(df_HeroicLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Nightmare")) {
                g.drawImage(df_NightmareLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Legendary")) {
                g.drawImage(df_LegendaryLevelBar,1375,40,100,500,null);
            }
            else if (gameData.getDifficultyLevel().equals("Glitch")) {
                g.drawImage(df_GlitchLevelBar,1375,40,100,500,null);
            }
            //System.out.println(gameData.getThreatLevel());
            g.drawImage(tl_Token,1295,479-(47*(gameData.getThreatLevel())),175,75,null);
            //g.drawImage(tl_Token,1220,449,175,75,null);
            g.drawImage(back_Of_CT,25,425,150,150,null);
            g.drawImage(back_Of_RDC, 185,525,165,300,null);
            g.drawRect(25,150,200,200);
            g.drawRect(355,60,820,820);
            g.setFont(new Font("Sans Serif",Font.BOLD,20));
            g.drawString("Actions:", 55,175);
            
            if(board[3][3]!=null){
                //System.out.println("yay");
            }
            for(int r=0; r<board.length; r++){
                for(int c=0; c<board[0].length; c++){
                    if(board[r][c]!=null){
                        if(board[r][c].getName().equals("Acid Jets")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_AcidJets,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_AcidJets_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_AcidJets_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_AcidJets_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Arrow Trap")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_ArrowTrap,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_ArrowTrap_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_ArrowTrap_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_ArrowTrap_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Dark Slime")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_DarkSlime,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_DarkSlime_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_DarkSlime_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_DarkSlime_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Den of Snakes")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_DenofSnakes,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_DenofSnakes_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_DenofSnakes_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_DenofSnakes_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Dragonling")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_Dragonling,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_Dragonling_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_Dragonling_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_Dragonling_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Fel Knight")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_FelKnight,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_FelKnight_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_FelKnight_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_FelKnight_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Fire of Eidolon")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_FOE,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_FOE_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_FOE_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_FOE_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Floating Stones")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_FloatingStones,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_FloatingStones_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_FloatingStones_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_FloatingStones_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Hall of Illusion")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_HallofIlusions,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_HallofIlusions_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_HallofIlusions_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_HallofIlusions_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Laughing Shadow")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_LaughingShadow,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_LaughingShadow_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_LaughingShadow_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_LaughingShadow_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Lava Lake")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_LavaLake,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_LavaLake_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_LavaLake_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_LavaLake_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Mimic Chest")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_MimicChest,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_MimicChest_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_MimicChest_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_MimicChest_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Mind Eater")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_Mindreader,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_Mindreader_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_Mindreader_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_Mindreader_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Minotaur")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_Minotaur,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_Minotaur_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_Minotaur_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_Minotaur_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Ogre Brute")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_OgerBrute,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_OgerBrute_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_OgerBrute_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_OgerBrute_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Paradox Puzzle")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_ParodoxPuzzle,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_ParodoxPuzzle_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_ParodoxPuzzle_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_ParodoxPuzzle_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Pengulum Blades")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_PengulumBlades,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_PengulumBlades_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_PengulumBlades_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_PengulumBlades_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Vagrant Portal")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_Portal,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_Portal_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_Portal_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_Portal_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Psychomancer")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_Psycomancer,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_Psycomancer_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_Psycomancer_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_Psycomancer_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Secret Passage X")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_SPX,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_SPX_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_SPX_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_SPX_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Secret Passage Y")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_SPY,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_SPY_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_SPY_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_SPY_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Skeletal Guards")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_SkeletonGuards,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_SkeletonGuards_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_SkeletonGuards_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_SkeletonGuards_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Sphynx's Riddle")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_SphynxsRiddle,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_SphynxsRiddle_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_SphynxsRiddle_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_SphynxsRiddle_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Spiked Pit")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_SpikedPit,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_SpikedPit_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_SpikedPit_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_SpikedPit_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Vestibule")){
                            g.drawImage(ct_Vestibule,355+(c*164), 60+(r*164), 164,164,null);

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }

                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }

                        }
                        else if(board[r][c].getName().equals("Voracious Plant")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_VoraciousPlant,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_VoraciousPlant_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_VoraciousPlant_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_VoraciousPlant_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Vorax's Focus")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_VoraxsFocus,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_VoraxsFocus_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_VoraxsFocus_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_VoraxsFocus_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Vorax's Heart")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_VoraxsHeart,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_VoraxsHeart_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_VoraxsHeart_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_VoraxsHeart_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                        else if(board[r][c].getName().equals("Vorax's Knowledge")){
                            if(board[r][c].getDegRot()==0){
                                g.drawImage(ct_VoraxsKnowledge,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==90){
                                g.drawImage(ct_VoraxsKnowledge_90,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==180){
                                g.drawImage(ct_VoraxsKnowledge_180,355+(c*164), 60+(r*164), 164,164,null);
                            }
                            else if(board[r][c].getDegRot()==270){
                                g.drawImage(ct_VoraxsKnowledge_270,355+(c*164), 60+(r*164), 164,164,null);
                            }

                            if(board[r][c].getHeroesOn()!=null){
                                for(int x=0; x<board[r][c].getHeroesOn().size(); x++){
                                    if(board[r][c].getHeroesOn().get(x).getName().equals("Aelfric")){
                                        g.drawImage(aelfric_Token,355+(c*164),60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Cecilia")){
                                        g.drawImage(cecelia_Token,355+(c*164)+25,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Daga")){
                                        g.drawImage(daga_Token,355+(c*164)+50,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kalistos")){
                                        g.drawImage(kalistos_Token,355+(c*164)+75,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Kaylana")){
                                        g.drawImage(kaylana_Token,355+(c*164)+100,60+(r*164),50,50,null);
                                    }
                                    else if(board[r][c].getHeroesOn().get(x).getName().equals("Sirius")){
                                        g.drawImage(sirius_Token,355+(c*164)+125,60+(r*164),50,50,null);
                                    }
                                }
                            }
                            if(board[r][c].getCultistNum()==1){
                                g.drawImage(cultist_Token,355+(c*164)+20,60+(r*164)+52,45,45,null);
                            }
                            if(board[r][c].isToken()){
                                if(board[r][c].getSkillType()==0){
                                    g.drawImage(str_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==1){
                                    g.drawImage(dex_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                                else if(board[r][c].getSkillType()==2){
                                    g.drawImage(int_Token,355+(c*164)+102,60+(r*164)+52,40,40,null);
                                }
                            }
                        }
                    }
                }
            }
        }
        if(ccscreen){
            g.setFont(new Font("Sans Serif",Font.BOLD,75));
            g.drawString(Integer.toString(gameData.getHeroesPlaying().get(ind).getDexTokenCount()),545,650);
            g.drawImage(dex_Token,600,590,100,100,null);
            g.drawString(Integer.toString(gameData.getHeroesPlaying().get(ind).getStrTokenCount()),720,650);
            g.drawImage(str_Token,775,590,100,100,null);
            g.drawString(Integer.toString(gameData.getHeroesPlaying().get(ind).getIntelTokenCount()),895,650);
            g.drawImage(int_Token,950,590,100,100,null);
            g.setFont(new Font("Sans Serif",Font.BOLD,35));
            if(gameData.getHeroesPlaying().get(ind).getName().equals("Aelfric")) {
                g.drawString(gameData.getAelfricPlayer(),675,150);
                g.drawImage(aelfric_Character_Card,500,200,550,350,null);
            }
            else if(gameData.getHeroesPlaying().get(ind).getName().equals("Cecilia")) {
                g.drawString(gameData.getCeceliaPlayer(),675,150);
                g.drawImage(cecelia_Character_Card,500,200,550,350,null);
            }
            else if(gameData.getHeroesPlaying().get(ind).getName().equals("Daga")) {
                g.drawString(gameData.getDagaPlayer(),675,150);
                g.drawImage(daga_Character_Card,500,200,550,350,null);
            }
            else if(gameData.getHeroesPlaying().get(ind).getName().equals("Kalistos")) {
                g.drawString(gameData.getKalistosPlayer(),675,150);
                g.drawImage(kalistos_Character_Card,500,200,550,350,null);
            }
            else if(gameData.getHeroesPlaying().get(ind).getName().equals("Kaylana")) {
                g.drawString(gameData.getKaylanaPlayer(),675,150);
                g.drawImage(kaylana_Character_Card,500,200,550,350,null);
            }
            else if(gameData.getHeroesPlaying().get(ind).getName().equals("Sirius")) {
                g.drawString(gameData.getSiriusPlayer(),675,150);
                g.drawImage(sirius_Character_Card,500,200,550,350,null);
            }
        }
        if(showingTileOnTop){
//            System.out.println("showing tile on top");
            if(gameData.getTileDeck().get(0).getName().equals("Acid Jets")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_AcidJets,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_AcidJets_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_AcidJets_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_AcidJets_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Arrow Trap")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_ArrowTrap,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_ArrowTrap_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_ArrowTrap_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_ArrowTrap_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Dark Slime")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_DarkSlime,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_DarkSlime_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_DarkSlime_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_DarkSlime_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Den of Snakes")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_DenofSnakes,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_DenofSnakes_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_DenofSnakes_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_DenofSnakes_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Dragonling")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_Dragonling,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_Dragonling_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_Dragonling_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_Dragonling_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Fel Knight")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_FelKnight,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_FelKnight_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_FelKnight_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_FelKnight_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Floating Stones")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_FloatingStones,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_FloatingStones_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_FloatingStones_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_FloatingStones_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Hall of Illusions")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_HallofIlusions,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_HallofIlusions_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_HallofIlusions_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_HallofIlusions_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Laughing Shadow")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_LaughingShadow,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_LaughingShadow_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_LaughingShadow_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_LaughingShadow_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Lava Lake")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_LavaLake,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_LavaLake_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_LavaLake_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_LavaLake_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Mimic Chest")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_MimicChest,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_MimicChest_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_MimicChest_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_MimicChest_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Mindreader")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_Mindreader,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_Mindreader_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_Mindreader_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_Mindreader_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Minotaur")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_Minotaur,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_Minotaur_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_Minotaur_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_Minotaur_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Oger Brute")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_OgerBrute,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_OgerBrute_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_OgerBrute_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_OgerBrute_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Paradox Puzzle")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_ParodoxPuzzle,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_ParodoxPuzzle_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_ParodoxPuzzle_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_ParodoxPuzzle_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Pengulum Blades")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_PengulumBlades,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_PengulumBlades_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_PengulumBlades_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_PengulumBlades_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Psychomancer")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_Psycomancer,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_Psycomancer_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_Psycomancer_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_Psycomancer_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Secret Passage X")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_SPX,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_SPX_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_SPX_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_SPX_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Secret Passage Y")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_SPY,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_SPY_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_SPY_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_SPY_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Skeleton Guards")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_SkeletonGuards,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_SkeletonGuards_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_SkeletonGuards_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_SkeletonGuards_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Sphynx's Riddle")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_SphynxsRiddle,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_SphynxsRiddle_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_SphynxsRiddle_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_SphynxsRiddle_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Spiked Pit")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_SpikedPit,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_SpikedPit_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_SpikedPit_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_SpikedPit_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Voracious Plant")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_VoraciousPlant,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_VoraciousPlant_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_VoraciousPlant_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_VoraciousPlant_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Vorax's Focus")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_VoraxsFocus,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_VoraxsFocus_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_VoraxsFocus_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_VoraxsFocus_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Vorax's Heart")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_VoraxsHeart,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_VoraxsHeart_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_VoraxsHeart_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_VoraxsHeart_270,25,425,150,150,null);
                }
            }
            else if(gameData.getTileDeck().get(0).getName().equals("Vorax's Knowledge")){
                if(gameData.getTileDeck().get(0).getDegRot()==0){
                    g.drawImage(ct_VoraxsKnowledge,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==90){
                    g.drawImage(ct_VoraxsKnowledge_90,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==180){
                    g.drawImage(ct_VoraxsKnowledge_180,25,425,150,150,null);
                }
                else if(gameData.getTileDeck().get(0).getDegRot()==270){
                    g.drawImage(ct_VoraxsKnowledge_270,25,425,150,150,null);
                }
            }
        }
        if(drawRitualDeck){
            if(gameData.getCurrDeck().get(0).getName().equals("Acid Jets")){
                g.drawImage(rdc_AcidJets, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Arrow Trap")){
                g.drawImage(rdc_ArrowTrap, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Intelligence Event")){
                g.drawImage(rdc_BlueEvent, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Dark Slime")){
                g.drawImage(rdc_DarkSlime, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Den of Snakes")){
                g.drawImage(rdc_DenofSnakes, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Dragonling")){
                g.drawImage(rdc_Dragonling, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Fel Knight")){
                g.drawImage(rdc_FelKnight, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Floating Stones")){
                g.drawImage(rdc_FloatingStones, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Dexterity Event")){
                g.drawImage(rdc_GreenEvent, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Hall of Illusions")){
                g.drawImage(rdc_HallofIlusions, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Laughing Shadow")){
                g.drawImage(rdc_LaughingShadow, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Lava Lake")){
                g.drawImage(rdc_LavaLake, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Mimic Chest")){
                g.drawImage(rdc_MimicChest, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Mindeater")){
                g.drawImage(rdc_Mindreader, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Minotaur")){
                g.drawImage(rdc_Minotaur, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Ogre Brute")){
                g.drawImage(rdc_OgerBrute, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Paradox Puzzle")){
                g.drawImage(rdc_ParodoxPuzzle, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Pendulum Blades")){
                g.drawImage(rdc_PengulumBlades, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Psychomancer")){
                g.drawImage(rdc_Psycomancer, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Strength Event")){
                g.drawImage(rdc_RedEvent, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Skeletal Guards")){
                g.drawImage(rdc_SkeletonGuards, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Sphynx's Riddle")){
                g.drawImage(rdc_SphynxsRiddle, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Spiked Pit")){
                g.drawImage(rdc_SpikedPit, 185,525,165,300,null);
            }
            else if(gameData.getCurrDeck().get(0).getName().equals("Voracios Plant")){
                g.drawImage(rdc_VoraciousPlant, 185,525,165,300,null);
            }
        }
    }

    public static BufferedImage rotate(BufferedImage src, int deg){
        if(deg == 90){
//            System.out.println("rotate 90");
            int width = src.getWidth();
            int height = src.getHeight();
            BufferedImage wen = new BufferedImage(height, width, src.getType());
            Graphics2D graphics2D = wen.createGraphics();
            graphics2D.translate((height-width)/2, (height-width)/2);
            graphics2D.rotate(Math.PI/2, height/2,width/2);
            //graphics2D.drawRenderableImage(src, null);
            return  wen;
        }
        return null;
    }

    public void drawCenteredString(Graphics g,String text,int x, int y){
        //https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
    }

    public boolean isDrawRitualDeck() {
        return drawRitualDeck;
    }
    public void setDrawRitualDeck(boolean drawRitualDeck) {
        this.drawRitualDeck = drawRitualDeck;
    }

    public GameData getGameData() {
        return gameData;
    }
    public boolean isDrawTitlePage() {
        return drawTitlePage;
    }

    public void setDrawTitlePage(boolean drawTitlePage) {
        this.drawTitlePage = drawTitlePage;
    }

    public void setGameData(GameData gd) {
        //System.out.println("game data recieved: "+gd.getDifficultyLevel());
        this.gameData = gd;
    }

    public boolean isHostGameSetUpScreen() {
        return hostGameSetUpScreen;
    }

    public void setHostGameSetUpScreen(boolean hostGameSetUpScreen) {
        this.hostGameSetUpScreen = hostGameSetUpScreen;
    }

    public boolean isShowUnstableVoid() {
        return showUnstableVoid;
    }

    public void setShowUnstableVoid(boolean showUnstableVoid) {
        this.showUnstableVoid = showUnstableVoid;
    }

    public boolean isShowVagrantPortal() {
        return showVagrantPortal;
    }

    public void setShowVagrantPortal(boolean showVagrantPortal) {
        this.showVagrantPortal = showVagrantPortal;
    }

    public boolean isShowInvasionOfTheShadowCult() {
        return showInvasionOfTheShadowCult;
    }

    public void setShowInvasionOfTheShadowCult(boolean showInvasionOfTheShadowCult) {
        this.showInvasionOfTheShadowCult = showInvasionOfTheShadowCult;
    }

    public boolean isShowShadesOfVorax() {
        return showShadesOfVorax;
    }

    public void setShowShadesOfVorax(boolean showShadesOfVorax) {
        this.showShadesOfVorax = showShadesOfVorax;
    }

    public boolean isHostRoomCodeScreen() {
        return hostRoomCodeScreen;
    }

    public void setHostRoomCodeScreen(boolean hostRoomCodeScreen) {
        this.hostRoomCodeScreen = hostRoomCodeScreen;
    }
}
