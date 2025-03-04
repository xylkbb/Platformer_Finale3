package utilz;

import static utilz.Constants.EnemyConstants.CRABBY;
import static utilz.Constants.ObjectConstants.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Crabby;
import main.Game;
import objects.Cannon;
import objects.GameContainer;
import objects.Potion;
import objects.Projectile;
import objects.Spike;

public class HelpMethods {

    public static boolean IsTileSolid(int xTile, int yTile, int[][] lvlData) {
        // TODO: create an int named value and assign lvlData[yTile][xTile] to it.
        // TODO: check if value is greater than or equal to 48 or value < 0 or value != 11
        // TODO: (cont). when the condition is true return true, else false
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) {
        // TODO: create an int called maxWidth and set to lvlData[0].length * Game.TILES_SIZE
        // TODO check if x is less than 0 or x is greater than or equal to maxWidth.
        // TODO: (cont.) if the condition is true return true
        // TODO: check if y is less than 0 or y is greater than or equal to Game.GAME_HEIGHT
        // TODO: (cont.) if the condition is true return true

        // TODO: make a float called xIndex and set to x / Game.TILES_SIZE
        // TODO: repeat for y

        // TODO: create an int named xTile and set to (int) xIndex.  This casts the float to an int chopping off the decimal.
        // TODO: repeat for y

        // TODO: return IsTileSolid passing in xTile, yTile, and lvlData
    }

    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
        // TODO: This checks if the four corners of something is able to move.
        // TODO: we will need 4 booleans first.  Initialize them all to false.
        // TODO: make one called bottomLeftGood
        // TODO: another called topRightGood
        // TODO: another called bottomRightGood
        // TODO: and finally one called topLeftGood
        // TODO: assign to bottomLeftGood !IsSolid(x, y, lvlData)
        // TODO: assign to topRightGood !IsSolid(x + width, y + height, lvlData)
        // TODO: assign to bottomRightGood !IsSolid(x + width, y, lvlData)
        // TODO: assign to topLeftGood !IsSolid(x, y + height, lvlData)

        return bottomLeftGood && topRightGood && bottomRightGood && topLeftGood;
    }


    public static boolean IsProjectileHittingLevel(Projectile p, int[][] lvlData) {
        // TODO: create a float named hitboxCenterX and set to (p.getHitbox().x + p.getHitbox().width) / 2
        // TODO: repeat for hitboxCenterY in the same fashion but use y and height instead
        return IsSolid(
                hitboxCenterX,
                hitboxCenterY,
                lvlData);
    }


    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
        // TODO: create an int named currentTile and set to (int) (hitbox.x / Game.TILES_SIZE)
        // TODO: check if xSpeed is positive.  (This is the Right)
        // TODO: (cont.) if the condition is true do the following
        // TODO: (cont.) create an int named tileXPos and set to currentTile * Game.TILES_SIZE
        // TODO: (cont.) create an int named xOffset and set to (int)(Game.TILES_SIZE - hitbox.width
        // TODO: (cont.) return tileXPos + xOffset - 1
        // TODO: else return currentTile * GAME.TILES_SIZE  (This is the Left)
    }

    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
        // TODO: create an int named currentTile and set to (int) (hitbox.y / Game.TILES_SIZE)
        // TODO: check if airSpeed is positive.  (This is the Falling - touching floor)
        // TODO: (cont.) if the condition is true do the following
        // TODO: (cont.) create an int named tileYPos and set to currentTile * Game.TILES_SIZE
        // TODO: (cont.) create an int named yOffset and set to (int)(Game.TILES_SIZE - hitbox.height
        // TODO: (cont.) return tileXPos + yOffset - 1
        // TODO: else return currentTile * GAME.TILES_SIZE  (This is Jumping)
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {

    }

    public static boolean IsFloor(Rectangle2D.Float hitbox, float xSpeed, int[][] lvlData) {

    }

    public static boolean CanCannonSeePlayer(int[][] lvlData, Rectangle2D.Float firstHitbox, Rectangle2D.Float secondHitbox, int yTile) {

    }

    public static boolean IsAllTilesClear(int xStart, int xEnd, int y, int[][] lvlData) {

    }

    public static boolean IsAllTilesWalkable(int xStart, int xEnd, int y, int[][] lvlData) {

    }

    public static boolean IsSightClear(int[][] lvlData, Rectangle2D.Float firstHitbox, Rectangle2D.Float secondHitbox, int yTile) {

    }

    public static int[][] GetLevelData(BufferedImage img) {

    }

    public static ArrayList<Crabby> GetCrabs(BufferedImage img) {

    }

    public static Point GetPlayerSpawn(BufferedImage img) {

    }

    public static ArrayList<Potion> GetPotions(BufferedImage img) {

    }

    public static ArrayList<GameContainer> GetContainers(BufferedImage img) {

    }

    public static ArrayList<Spike> GetSpikes(BufferedImage img) {

    }

    public static ArrayList<Cannon> GetCannons(BufferedImage img) {

    }

}