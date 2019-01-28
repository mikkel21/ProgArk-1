package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.states.PlayState;

public class Ball {
    private Texture ball;
    private Vector2 position;
    private boolean upHeading;
    private boolean rightHeading;
    private int speed;

    public Ball(int x, int y) {
        position = new Vector2(x,y);
        ball = new Texture("ball.png");
        upHeading = true;
        rightHeading = true;
        speed = 10;
    }

    public void update(float dt, PlayState ps) {
        if (position.y > 590) {
            ps.incRightScore();
        }
        if (position.x < 10) {
            ps.incLeftScore();
        }
        this.moveY(speed);
        this.moveX(speed);
    }


    public void moveX(int speed) {
        if(rightHeading) {
            position.x += speed;
        }
        else {
            position.x -= speed;
        }


        if(rightHeading && (position.x > 600)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - ball.getWidth()))) {
            position.x -= speed;
            rightHeading=false;
        }

        if(!rightHeading && (position.x < 0)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - ball.getWidth()))) {
            position.x += speed;
            rightHeading = true;
        }

    }

    public void moveY(int speed) {
        if(upHeading) {
            position.y += speed;
        }
        else {
            position.y -= speed;
        }

        if(upHeading && (position.y > 600)) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - ball.getHeight()))) {
            position.y -= speed;
            upHeading=false;
        }

        if(!upHeading && (position.y < 0)) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - ball.getHeight()))) {
            position.y += speed;
            upHeading=true;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return ball;
    }
}