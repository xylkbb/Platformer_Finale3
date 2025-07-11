package gamestates;

import main.Game;
import ui.AudioOptions;
import ui.PauseButton;
import ui.UrmButton;
import utilz.Constants;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.URMButtons.URM_SIZE;

public class GameOptions extends State implements Statemethods {

    private AudioOptions audioOptions;
    private BufferedImage backgroundImg, optionsBackgroundImg;
    private int bgX, bgY, bgW, bgH;
    private UrmButton menuB;

    public GameOptions(Game game) {
        super(game);
        loadImgs();
        loadButton();
        audioOptions = game.getAudioOptions();
    }

    private void loadButton() {
        int menuX = (int) (387 * Constants.Game.SCALE);
        int menuY = (int) (325 * Constants.Game.SCALE);
        menuB = new UrmButton(menuX, menuY, URM_SIZE, URM_SIZE, 2);

    }

    private void loadImgs() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND_IMG);
        optionsBackgroundImg = LoadSave.GetSpriteAtlas(LoadSave.OPTIONS_MENU);

        bgW = (int) (optionsBackgroundImg.getHeight() * Constants.Game.SCALE);
        bgH = (int) (optionsBackgroundImg.getHeight() * Constants.Game.SCALE);
        bgX = Constants.Game.GAME_WIDTH / 2 - bgW / 2;
        bgY = (int) (33 * Constants.Game.SCALE);

    }

    @Override
    public void update() {
        menuB.update();
        audioOptions.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 9, Constants.Game.GAME_WIDTH, Constants.Game.GAME_HEIGHT, null);
g.drawImage(optionsBackgroundImg, bgX, bgY, bgW, bgH, null);

menuB.draw(g);
audioOptions.draw(g);


    }

    public void mouseDragged(MouseEvent e) {
        audioOptions.mouseDragged(e);
        // TODO: call audioOptions.mouseDragged() passing in e
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(isIn(e, menuB)){
            menuB.setMousePressed(true);
        }else{
            audioOptions.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(e, menuB)){
            if (menuB.isMousePressed()){
                Gamestate.state = Gamestate.MENU;
            }
        }else{
            audioOptions.mouseReleased(e);
        }menuB.resetBools();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        menuB.setMouseOver(false);
        if (isIn(e, menuB)){
            menuB.setMouseOver(true);
        }else{
            audioOptions.mouseMoved(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            Gamestate.state = Gamestate.MENU;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO: nothing in this method.  It must exist, but it does nothing

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO: nothing in this method.  It must exist, but it does nothing
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
        return b.getBounds().contains(e.getX(), e.getY());
    }

}