package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Exercise_1;

import java.util.Random;

public class Button {
    private Texture button;
    private Vector2 position;
    private Random rand;

    private Rectangle bounds;

    public Button(int x, int y, String texturePath) {
        button = new Texture(texturePath);

        position = new Vector2(x,y);

        rand = new Random();

        bounds = new Rectangle(position.x,position.y-50,100,100);
    }

    public void update() {

    }

    public Rectangle getBounds() {

        return bounds;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return button;
    }
}