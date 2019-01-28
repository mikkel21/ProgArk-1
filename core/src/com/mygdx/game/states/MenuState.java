package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Exercise_1;

public class MenuState extends State{

    private Texture background;
    private Texture playBtn;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        //background = new Texture("bg.png");
        playBtn = new Texture("one.png");

    }

    @Override
    protected void handleInput() {
        //TODO: implement so that different clicks of buttons renders different tasks
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        //sb.draw(background,0,0, Exercise_1.WIDTH,Exercise_1.HEIGHT);
        sb.draw(playBtn,(Exercise_1.WIDTH/2)-(playBtn.getWidth()/2), Exercise_1.HEIGHT/2,80,80);
        sb.end();
    }

    @Override
    public void dispose() {
        //background.dispose();
        playBtn.dispose();
    }
}
