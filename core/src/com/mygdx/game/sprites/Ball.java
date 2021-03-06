package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.states.PlayStateTask4;

public class Ball {
    private Texture ball;
    private Vector2 position;
    private boolean upHeading;
    private boolean rightHeading;
    private int speed;

    private Rectangle bounds;


    public Ball(int x, int y) {
        position = new Vector2(x,y);
        ball = new Texture("ball.png");
        upHeading = true;
        rightHeading = true;
        speed = 600;
        bounds = new Rectangle(position.x,position.y,20,20);
    }

    public void update(float dt, PlayStateTask4 ps, PaddleLeft pl, PaddleRight pr) {
        bounds.setPosition(position.x,position.y);

        if(bounds.overlaps(pl.getBounds()) || bounds.overlaps(pr.getBounds())){
            this.rightHeading=!this.rightHeading;
        }

        this.moveY(speed*dt);
        this.moveX(speed*dt, ps);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void moveX(float speed, PlayStateTask4 ps) {
        if(rightHeading) {
            position.x += speed;
        }
        else {
            position.x -= speed;
        }


        if(position.x > 600) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - ball.getWidth()))) {
            position.x = 290;
            position.y = 290;
            rightHeading=false;
            upHeading=!upHeading;
            ps.incLeftScore();
        }
        if(position.x < 0) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - ball.getWidth()))) {
            position.x = 290;
            position.y = 290;
            rightHeading=true;
            upHeading=!upHeading;
            ps.incRightScore();
        }

    }

    public void moveY(float speed) {
        if(upHeading) {
            position.y += speed;
        }
        else {
            position.y -= speed;
        }

        if(upHeading && (position.y > 580)) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - ball.getHeight()))) {
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