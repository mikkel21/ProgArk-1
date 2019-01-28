package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Exercise_1;
import com.mygdx.game.sprites.Heli;

public class PlayState extends State {
    private Heli heli;
    private BitmapFont font;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        heli = new Heli(150,150);
        font = new BitmapFont();
    }

    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        heli.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(heli.getTexture(),heli.getPosition().x, heli.getPosition().y);
        font.draw(sb,"x,y: " + heli.getPosition().x + "," + heli.getPosition().y,20,20);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
