package com.rhythm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class BeatIndicator {

	public void render(ShapeRenderer sr){
		float dtb = MidiPlayer.distanceToBeat();
		
		sr.begin(ShapeType.Filled);
		sr.setColor(0, 0, (dtb < 0.05f || dtb > 0.95f)? 1:0, 0);
		float rectSize = Gdx.graphics.getWidth() / 10;
		sr.rect((Gdx.graphics.getWidth() - rectSize) / 2, Gdx.graphics.getHeight() - rectSize, rectSize, rectSize);
		sr.end();
	}
	
}
