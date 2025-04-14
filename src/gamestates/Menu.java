package gamestates;

import main.Game;
import ui.MenuButton;
import utilz.Constants;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends State implements Statemethods {

    private MenuButton[] buttons = new MenuButton[3];
    private BufferedImage backgroundImg, backgroundImgPink;
    private int menuX, menuY, menuWidth, menuHeight;

    public Menu(Game game) {
        super(game);
        loadButtons();
        loadBackground();
        backgroundImgPink = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND_IMG);
        // TODO: call loadButtons()
        // TODO: call loadBackground()
        // TODO: setbackgroundImgPink to LoadSave.GetSpriteAtlas() passing in LoadSave.MENU_BACKGROUND_IMG
    }

    private void loadBackground() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
        menuWidth = (int) (backgroundImg.getWidth() * Constants.Game.SCALE);
        menuHeight = (int) (backgroundImg.getHeight() * Constants.Game.SCALE);
        menuX = Constants.Game.GAME_WIDTH / 2 - menuWidth / 2;
        menuY = (int) (45 * Constants.Game.SCALE);
    }

    private void loadButtons() {
        buttons[0] = new MenuButton(Constants.Game.GAME_WIDTH / 2, (int) (150 * Constants.Game.SCALE), 0, Gamestate.PLAYING);
        buttons[1] = new MenuButton(Constants.Game.GAME_WIDTH / 2, (int) (220 * Constants.Game.SCALE), 1, Gamestate.OPTIONS);
        buttons[2] = new MenuButton(Constants.Game.GAME_WIDTH / 2, (int) (290 * Constants.Game.SCALE), 2, Gamestate.QUIT);

    }

    @Override
    public void update() {
        for (MenuButton mb : buttons) {
            mb.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImgPink, 0, 0, Constants.Game.GAME_WIDTH, Constants.Game.GAME_HEIGHT, null);
        g.drawImage(backgroundImg, menuX, menuY, menuWidth, menuHeight, null);
        for (MenuButton mb : buttons) {
            mb.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO: nothing here.  Method must exist
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButton mb : buttons){
            if(isIn(e, mb)){
                mb.setMousePressed(true);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (MenuButton mb : buttons){
            if(isIn(e,mb)){
                if(mb.isMousePressed()){
                    mb.applyGamestate();
                }if(mb.getState() == Gamestate.PLAYING){
                    game.getAudioPlayer().setLevelSong(game.getPlaying().getLevelManager().getLevelIndex());
                }break;
            }resetButtons();
        }

    }

    private void resetButtons() {
        for(MenuButton mb : buttons){
            mb.resetBools();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MenuButton mb : buttons){
            mb.setMouseOver(false);
        } for (MenuButton mb : buttons){
            if (isIn(e, mb)){
                mb.setMouseOver(true);
            }break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO: nothing here.  Method must exist
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO: nothing here.  Method must exist
    }

}