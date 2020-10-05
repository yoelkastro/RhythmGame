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

public class RhythmGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	BitmapFont font;
	int points = 0;
	ShapeRenderer sr;
	float hitStunStart = -10;
	
	//MusicPlayer mp1;
	MidiPlayer mp;
	
	public boolean isStunned(){
		return mp.getPosition() - hitStunStart < (60f / mp.getBPM());
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		sr = new ShapeRenderer();
		
		//mp1 = new MusicPlayer(Gdx.audio.newMusic(Gdx.files.internal("audio/metronome.mp3")), 60);
		//mp.start();
		
		System.out.println();
		mp = new MidiPlayer(new File("assets/audio/metronome.mid"), 120);
		
		Gdx.input.setInputProcessor(this);
		
		mp.start();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, isStunned()? 0:1, isStunned()? 0:1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "" + points, 200, 300);
		batch.end();
		
		float dtb = mp.distanceToBeat();
		
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

	@Override
	public boolean keyDown(int keycode) {
		float dtb = mp.distanceToBeat();
		
		if(!isStunned()){
			if((dtb < 0.2f || dtb > 0.8f)){
					points ++;
			}
			else{
				hitStunStart = mp.getPosition();
			}
		}
		System.out.println((dtb < 0.1f || dtb > 0.9f));
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
