package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Exercise_1;

public class HeliTask1 {
    private Texture heli;
    private Vector2 position;
    private Sprite heliSprite;
    private boolean upHeading;
    private boolean rightHeading;
    private int speed;
    private boolean isFlipped;

    public HeliTask1(int x, int y) {
        position = new Vector2(x,y);
        heli = new Texture("heli1.png");
        heliSprite= new Sprite(heli);
        heliSprite.flip(true,false);
        upHeading = true;
        rightHeading = true;
        speed = 200;
        isFlipped=false;
    }

    public void update(float dt) {
        System.out.println("y: "+position.y+" x: "+position.x);

        this.moveY(speed*dt);
        this.moveX(speed*dt);

    }


    public void moveX(float speed) {
        if(rightHeading) {
            position.x += speed;
        }
        else {
            position.x -= speed;
        }


        if(rightHeading && (position.x > Exercise_1.WIDTH-heli.getWidth())) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - heli.getWidth()))) {
            position.x -= speed;
            rightHeading=false;
            isFlipped=!isFlipped;
            heliSprite.flip(true, false);
        }

        if(!rightHeading && (position.x < 0)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - heli.getWidth()))) {
            position.x += speed;
            rightHeading = true;
            isFlipped=!isFlipped;
            heliSprite.flip(true, false);
        }
    }

    public void moveY(float speed) {
        if(upHeading) {
            position.y += speed;
        }
        else {
            position.y -= speed;
        }

        if(upHeading && (position.y > Exercise_1.HEIGHT-heli.getHeight())) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - heli.getHeight()))) {
            position.y -= speed;
            upHeading=false;
        }

        if(!upHeading && (position.y < 0)) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - heli.getHeight()))) {
            position.y += speed;
            upHeading=true;
        }
    }

    public Sprite getHeliSprite() {
        return heliSprite;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return heli;
    }
}