package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Exercise_1;
import com.mygdx.game.sprites.Heli;

public class PlayState extends State {
    private Heli heli;
    private BitmapFont font;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        heli = new Heli(50,100);
        font = new BitmapFont();
        cam.setToOrtho(false, Exercise_1.WIDTH/2,Exercise_1.HEIGHT/2);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            float x = Gdx.input.getX();
            float y = Gdx.input.getY();
        }
    }

    @Override
    public void update(float dt) {
        //handleInput();
        heli.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        //sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(heli.getHeliSprite(),heli.getPosition().x, heli.getPosition().y);
        font.draw(sb,"x,y: " + heli.getPosition().x + "," + heli.getPosition().y,20,20);
        //sb.draw(tube.getTopTube(), tube.getPosBotTube().x, tube.getPosTopTube().y);
        //sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
