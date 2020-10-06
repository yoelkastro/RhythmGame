package com.rhythm.game;

public class Player {

	private int points;
	private float hitStunStart;
	
	public boolean isStunned(){
		return MidiPlayer.getPosition() - hitStunStart < (60f / MidiPlayer.getBPM());
	}
	
	public Player(){

	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public float getHitStunStart() {
		return hitStunStart;
	}

	public void setHitStunStart(float hitStunStart) {
		this.hitStunStart = hitStunStart;
	}
	
}
