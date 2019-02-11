package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Observable;
import java.util.Observer;

public class GameObserver implements Observer {
    //Observer for observing the game
    //Could easily be utilized if the game consists of several states

    private Ball ball;
    private PaddleRight paddleRight;
    private PaddleLeft paddleLeft;

    @Override
    public void update(Observable o, Object args){
        if (args instanceof Ball) {
            this.ball=((Ball)args);
        } else if (args instanceof PaddleLeft) {
            this.paddleLeft=((PaddleLeft)args);
        } else if (args instanceof PaddleRight) {
            this.paddleRight=((PaddleRight)args);
        }
    }

    @Override
    public String toString() {
        if (ball == null || paddleLeft == null || paddleRight == null) {
            return "One of the objects are null";
        }
        return "gameObserver{" +
                "ball=" + ball.toString() +
                "\npaddleRight=" + paddleRight.toString() +
                "\npaddleLeft=" + paddleLeft.toString() +
                '}';
    }

}
