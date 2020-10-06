package com.rhythm.game;

import com.badlogic.gdx.InputProcessor;

public class GameInputHandler implements InputProcessor {

	Player p1, p2;
	
	public GameInputHandler(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		float dtb = MidiPlayer.distanceToBeat();
		
		if(!p1.isStunned()){
			if((dtb < 0.2f || dtb > 0.8f)){
					p1.addPoints(1);
			}
			else{
				p1.setHitStunStart(MidiPlayer.getPosition());
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
