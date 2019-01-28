package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Exercise_1;

public class Heli {
    private Texture heli;
    private Vector3 position;
    private Sprite heliSprite;
    private boolean upHeading;
    private boolean rightHeading;

    public Heli(int x, int y) {
        position = new Vector3(x,y,0);
        heli = new Texture("heli1.png");
        heliSprite= new Sprite(heli);
        heliSprite.flip(true,false);
        upHeading = true;
        rightHeading = true;
    }

    public void update(float dt) {
        System.out.println("y: "+position.y+" x: "+position.x);
        int speed = 3;

        if(upHeading) {
            position.y += speed;
        }
        else {
            position.y -= speed;
        }

        if(rightHeading) {
            position.x += speed;
        }
        else {
            position.x -= speed;
        }

        if(upHeading && (position.y > 300)) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - heli.getHeight()))) {
            position.y -= speed;
            upHeading=false;
        }
        if(rightHeading && (position.x > 300)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - heli.getWidth()))) {
            position.x -= speed;
            rightHeading=false;
            heliSprite.flip(true,false);
        }
        if(!upHeading && (position.y < 0)) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - heli.getHeight()))) {
            position.y += speed;
            upHeading=true;
        }
        if(!rightHeading && (position.x < 0)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - heli.getWidth()))) {
            position.x += speed;
            rightHeading=true;
            heliSprite.flip(true,false);

        }
    }

    public Sprite getHeliSprite() {
        return heliSprite;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return heli;
    }
}