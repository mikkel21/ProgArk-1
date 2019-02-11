package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Observable;
import java.util.Observer;

public class gameObserver extends Observer {
    //ball
    private Vector2 ballPosition;
    private boolean upHeading;
    private boolean rightHeading;
    private int speed;

    private Rectangle ballBounds;

    //Left paddle
    private Vector2 leftPosition;
    private Rectangle leftBounds;

    //right paddle
    private Vector2 rightPosition;
    private Rectangle rightBounds;

    @Override
    public void update(Observable o, Vector2 ballPosition, boolean upHeading, boolean rightHeading,
                       int speed, Rectangle ballBounds, Vector2 leftPosition, Rectangle leftBounds,
                       Vector2 rightPosition, Rectangle rightBounds){
        this.ballPosition = ballPosition;
    }
}
