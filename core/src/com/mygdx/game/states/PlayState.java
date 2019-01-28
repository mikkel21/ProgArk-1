package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Exercise_1;
import com.mygdx.game.sprites.Heli;

public class PlayState extends State {
    private Heli heli1;
    private Heli heli2;
    private Heli heli3;
    private Heli heli4;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        heli1 = new Heli(20,20);
        heli2 = new Heli(Exercise_1.WIDTH-40,40);
        heli3 = new Heli(Exercise_1.WIDTH-40,600);
        heli4 = new Heli(20,600);
    }

    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        heli1.update(dt);
        heli2.update(dt);
        heli3.update(dt);
        heli4.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(heli1.getTexture(),heli1.getPosition().x, heli1.getPosition().y);

        sb.draw(heli2.getTexture(),heli2.getPosition().x, heli2.getPosition().y);

        sb.draw(heli3.getTexture(),heli3.getPosition().x, heli3.getPosition().y);

        sb.draw(heli4.getTexture(),heli4.getPosition().x, heli4.getPosition().y);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
