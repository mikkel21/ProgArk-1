package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PaddleRight {
    private Vector2 position;
    private Texture paddle;

    private Rectangle bounds;

    //singleton
    private static PaddleRight paddle_instance;

    public static PaddleRight getInstance(int x, int y) {
        if (paddle_instance == null) {
            paddle_instance = new PaddleRight(x,y);
        }
        return paddle_instance;
    }

    private PaddleRight(int x, int y){
        position=new Vector2(x,y);
        paddle = new Texture("paddle.png");

        bounds = new Rectangle(position.x,position.y,paddle.getWidth(),paddle.getHeight());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float dt) {
        bounds.setPosition(position.x,position.y);

        if (position.y < 0) {
            position.y = 0;
        }
        if (position.y > 450) {
            position.y = 450;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += 4;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            position.y -= 4;
        }
    }

    public Vector2 getPosition() {
        return position;
    }
    public Texture getTexture() {
        return paddle;
    }
}
