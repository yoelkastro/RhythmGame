package com.rhythm.screens;

import java.io.File;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.rhythm.game.InputHandler;
import com.rhythm.game.MidiPlayer;
import com.rhythm.game.Player;

public class GameScreen implements Screen {

	private SpriteBatch batch;
	private BitmapFont font;
	private ShapeRenderer sr;
	
	private Player p1 = new Player();
	
	private InputHandler ih;
	
	private int screenWidth;
	private int screenHeight;
	
	public GameScreen(){
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		sr = new ShapeRenderer();
		
		MidiPlayer.initialize(new File("assets/audio/metronome.mid"), 120);
		
		ih = new InputHandler(p1, null);
		
		Gdx.input.setInputProcessor((InputProcessor) ih);
		
		MidiPlayer.start();
		
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
	}
	
	@Override
	public void show() {}

	@Override
	public void render(float deltaTime) {
		
		Gdx.gl.glClearColor(1, p1.isStunned()? 0:1, p1.isStunned()? 0:1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		font.draw(batch, "" + p1.getPoints(), 200, 300);
		batch.end();
		
		float dtb = MidiPlayer.distanceToBeat();
		
		sr.begin(ShapeType.Filled);
		sr.setColor(0, 0, (dtb < 0.05f || dtb > 0.95f)? 1:0, 0);
		sr.rect(200, 200, 50, 50);
		sr.end();
		
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
