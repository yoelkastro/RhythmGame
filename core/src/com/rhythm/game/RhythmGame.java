package com.rhythm.game;

import java.io.File;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class RhythmGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	ShapeRenderer sr;
	
	Player p1 = new Player();
	
	InputHandler ih;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		sr = new ShapeRenderer();
		
		System.out.println();
		MidiPlayer.initialize(new File("assets/audio/metronome.mid"), 120);
		
		ih = new InputHandler(p1, null);
		
		Gdx.input.setInputProcessor((InputProcessor) ih);
		
		MidiPlayer.start();
	}

	@Override
	public void render () {
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
	public void dispose () {
		//mp.dispose();
		batch.dispose();
		font.dispose();
	}

	
}
