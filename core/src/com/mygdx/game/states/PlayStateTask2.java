package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Exercise_1;
import com.mygdx.game.sprites.Heli;
import com.mygdx.game.sprites.HeliTask2;

public class PlayStateTask2 extends State {
    private HeliTask2 heli;
    private BitmapFont font;

    public PlayStateTask2(GameStateManager gsm) {
        super(gsm);
        heli = new HeliTask2(150,150);
        font = new BitmapFont();
    }

    //@Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.X)) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        heli.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(heli.getHeliSprite(),heli.getPosition().x, heli.getPosition().y);
        font.draw(sb,"x,y: " + heli.getPosition().x + "," + heli.getPosition().y+"\nRress x to go back to menu\nThe heli follows the cursor",20,780);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
