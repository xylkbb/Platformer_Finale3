package objects;

import utilz.Constants;

public class Potion extends GameObject {

    private float hoverOffset;
    private int maxHoverOffset, hoverDir = 1;

    public Potion(int x, int y, int objType) {
        super(x, y, objType);
        doAnimation = true;

        initHitbox(7, 14);

        xDrawOffset = (int) (3 * Constants.Game.SCALE);
        yDrawOffset = (int) (2 * Constants.Game.SCALE);

maxHoverOffset = (int) (10 * Constants.Game.SCALE);
    }

    public void update(){
        updateAnimationTick();
        updateHover();
    }

    private void updateHover(){
        hoverOffset += (0.075f * Constants.Game.SCALE * hoverDir);
        if ( hoverOffset >= maxHoverOffset){
            hoverDir = -1;
        }else{
            hoverDir = 1;
        }

        hitbox.y = y + hoverOffset;
    }


}
