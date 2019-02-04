package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Exercise_1;
import com.mygdx.game.sprites.Heli;
import com.mygdx.game.sprites.HeliTask3;

public class PlayStateTask3 extends State {
    private HeliTask3 heli1;
    private HeliTask3 heli2;
    private HeliTask3 heli3;

    private boolean flip;

    private BitmapFont font;


    public PlayStateTask3(GameStateManager gsm) {
        super(gsm);
        heli1 = new HeliTask3(20,20);
        heli2 = new HeliTask3(Exercise_1.WIDTH-40,40);
        heli3 = new HeliTask3(Exercise_1.WIDTH-40,600);

        flip=false;

        font = new BitmapFont();
    }

    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.X)) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        heli1.update(this,dt, heli2, heli3);
        heli2.update(this,dt, heli1, heli3);
        heli3.update(this,dt, heli1, heli2);
    }

    public void flip() {

        //this.flip=true;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(heli1.getTexture(),heli1.getPosition().x, heli1.getPosition().y);

        sb.draw(heli2.getTexture(),heli2.getPosition().x, heli2.getPosition().y);

        sb.draw(heli3.getTexture(),heli3.getPosition().x, heli3.getPosition().y);

        font.draw(sb,"Press x to go back to menu",20,780);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
