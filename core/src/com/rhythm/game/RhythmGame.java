package com.rhythm.game;

import com.badlogic.gdx.Game;
import com.rhythm.screens.GameScreen;

public class RhythmGame extends Game {
	
	@Override
	public void create () {
		
		this.setScreen(new GameScreen());
		
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}

	
}
