package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.sprites.Ball;
import com.mygdx.game.sprites.PaddleLeft;
import com.mygdx.game.sprites.PaddleRight;


public class PlayState extends State {
    private PaddleLeft paddleLeft;
    private PaddleRight paddleRight;
    private Ball ball;
    private Texture bg;

    private Vector2 score;
    private BitmapFont font;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        paddleLeft = new PaddleLeft(30,30);
        paddleRight = new PaddleRight(540,30);
        ball = new Ball(300,150);
        bg = new Texture("bg.png");
        font = new BitmapFont();
        score = new Vector2(0,0);
    }

    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        paddleRight.update(dt);
        paddleLeft.update(dt);
        ball.update(dt,this);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0,0);
        sb.draw(paddleRight.getTexture(),paddleRight.getPosition().x,paddleRight.getPosition().y);
        sb.draw(paddleLeft.getTexture(),paddleLeft.getPosition().x,paddleLeft.getPosition().y);
        sb.draw(ball.getTexture(),ball.getPosition().x,ball.getPosition().y,20,20);
        font.draw(sb,"LEFT: " + ((int)this.score.x) + " RIGHT: " + ((int)this.score.y),250,590);
        sb.end();
    }

    public void setScore(Vector2 score){
        this.score=score;
    }

    public void incRightScore() {
        this.score.y +=0.5;
    }
    public void incLeftScore() {
        this.score.x +=0.5;
    }

    @Override
    public void dispose() {

    }
}
