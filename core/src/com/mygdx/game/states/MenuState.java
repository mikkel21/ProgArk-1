package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Exercise_1;
import com.mygdx.game.sprites.Button;

public class MenuState extends State{
    private Texture background;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private BitmapFont font;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        //background = new Texture("bg.png");
        button4 = new Button(350, 600, "one.png");
        button3 = new Button(350, 450, "two.png");
        button2 = new Button(350, 300, "three.png");
        button1 = new Button(350, 150, "four.png");

        font = new BitmapFont();
    }


    protected void handleInput() {
        //TODO: implement so that different clicks of buttons renders different tasks
        if(Gdx.input.justTouched()){
            Rectangle touch = new Rectangle(Gdx.input.getX(), Gdx.input.getY(),1,1);
            if(touch.overlaps(button1.getBounds())) {
                gsm.set(new PlayStateTask1(gsm));
                System.out.println("button 1");
            }
            else if(touch.overlaps(button2.getBounds())) {
                gsm.set(new PlayStateTask2(gsm));
                System.out.println("button 2");
            }
            else if(touch.overlaps(button3.getBounds())) {
                gsm.set(new PlayStateTask3(gsm));
                System.out.println("button 3");
            }
            else if(touch.overlaps(button4.getBounds())) {
                gsm.set(new PlayStateTask4(gsm));
                System.out.println("button 4");
            }
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
        sb.draw(button1.getTexture(),button1.getPosition().x,button1.getPosition().y,100,100);
        sb.draw(button2.getTexture(),button2.getPosition().x,button2.getPosition().y,100,100);
        sb.draw(button3.getTexture(),button3.getPosition().x,button3.getPosition().y,100,100);
        sb.draw(button4.getTexture(),button4.getPosition().x,button4.getPosition().y,100,100);

        font.draw(sb,"MENU \nClick a button to see the corresponding task",20,780);

        sb.end();
    }

    @Override
    public void dispose() {
    }
}
