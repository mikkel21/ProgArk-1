package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Exercise_1;

import java.util.Random;

public class Heli {
    private Texture heli;
    private Vector2 position;
    private Sprite heliSprite;
    private boolean upHeading;
    private boolean rightHeading;
    private int speed;
    private Animation heliAnimation;
    private Random rand;

    private Rectangle bounds;

    public Heli(int x, int y) {
        Texture texture = new Texture("animation.png");
        heliAnimation = new Animation(new TextureRegion(texture), 4, 0.4f);
        heli = new Texture("heli1.png");

        heliSprite= new Sprite(heli);
        heliSprite.flip(true,false);

        position = new Vector2(x,y);


        rand = new Random();
        int random = rand.nextInt(20)+1;
        speed = 50*random;

        upHeading=((random%2)==0);
        random=rand.nextInt(3)+1;
        rightHeading=((random%2)==0);

        bounds = new Rectangle(position.x,position.y,heli.getWidth(),heli.getHeight());
    }

    public void update(float dt, Heli h2, Heli h3) {
        heliAnimation.update(dt);

        System.out.println("y: "+position.y+" x: "+position.x);

        if(this.getBounds().overlaps(h2.getBounds()) || this.getBounds().overlaps(h3.getBounds())){
            this.upHeading=!this.upHeading;
            this.rightHeading=!this.rightHeading;
        }

        this.moveY(speed*dt);
        this.moveX(speed*dt);

        bounds.setPosition(position.x, position.y);
    }

    public Rectangle getBounds() {
        return bounds;
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
            //heliSprite.flip(true,false);
        }

        if(!rightHeading && (position.x < 0)) { //         if(rightHeading && (position.x> (Exercise_1.WIDTH - heli.getWidth()))) {
            position.x += speed;
            rightHeading = true;
            //heliSprite.flip(true, false);
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

    public TextureRegion getTexture() {
        return heliAnimation.getFrame();
    }
}