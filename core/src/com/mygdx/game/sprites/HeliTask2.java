package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Exercise_1;

public class HeliTask2 {
    private Texture heli;
    private Vector2 position;
    private Sprite heliSprite;
    private boolean upHeading;
    private boolean rightHeading;
    private int speed;
    private boolean isFlipped;

    public HeliTask2(int x, int y) {
        position = new Vector2(x,y);
        heli = new Texture("heli1.png");
        heliSprite= new Sprite(heli);
        heliSprite.flip(true,false);
        upHeading = true;
        rightHeading = true;
        speed = 100;
        isFlipped=false;
    }

    public void update(float dt) {
        System.out.println("y: "+position.y+" x: "+position.x);

        moveToPos(dt);
        /*
        this.moveY(speed);
        this.moveX(speed);
        */
    }

    public void moveToPos(float dt) {
        //IS CURRENTLY FOLLOWING THE MOUSE-POINTER

        Vector2 mousePos = new Vector2(150,150);
        //if (Gdx.input.justTouched()) {
            mousePos.x = Gdx.input.getX();
            mousePos.y = 800-Gdx.input.getY();
        //}

        if(mousePos.x > position.x) {
            position.x +=speed*dt;
        } else if (mousePos.x < position.x) {
            position.x -= speed*dt;
        }

        if(mousePos.y > position.y) {
            position.y +=speed*dt;
        } else if (mousePos.y < position.y) {
            position.y -= speed*dt;
        }

/*
        float pathX = mousePos.x - position.x;
        float pathY = mousePos.y - position.y;

        float distance = (float) Math.sqrt(pathX * pathX + pathY * pathY);

        float directionX = pathX/distance;
        float directionY = pathY/distance;

        position.x += directionX * speed;
        position.y += directionY * speed;
        */
    }


    public void moveX(int speed) {
        if(rightHeading) {
            position.x += speed;
        }
        else {
            position.x -= speed;
        }


        if(rightHeading && (position.x > 300)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - heli.getWidth()))) {
            position.x -= speed;
            rightHeading=false;
            isFlipped=!isFlipped;
            heliSprite.flip(true,false);
        }

        if(!rightHeading && (position.x < 0)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - heli.getWidth()))) {
            position.x += speed;
            rightHeading = true;
            isFlipped=!isFlipped;
            heliSprite.flip(true, false);
        }
    }

    public void moveY(int speed) {
        if(upHeading) {
            position.y += speed;
        }
        else {
            position.y -= speed;
        }

        if(upHeading && (position.y > 300)) { //         if(upHeading && (position.y > (Exercise_1.HEIGHT - heli.getHeight()))) {
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