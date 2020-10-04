package com.rhythm.game;

import com.badlogic.gdx.audio.Music;

public class MusicPlayer {

	private Music music;
	private int bpm;
	
	public MusicPlayer(Music music, int bpm){
		
		this.music = music;
		this.bpm = bpm;
	}
	
	public boolean isBeat(){
		return this.distanceToBeat() == 0;
	}
	
	public float distanceToBeat(){
		return (this.music.getPosition() * 60f / (float) bpm) % 1;
	}
	
	public int getBeat(){
		return (int) (this.music.getPosition() * 60 / bpm);	
	}
	
	public float getPosition(){
		return this.music.getPosition();
	}
	
	public void start(){
		this.music.play();
	}
	
	public void setVolume(float volume){
		this.music.setVolume(volume);
	}
	
	public void setMusic(Music music, int bpm){
		this.music = music;
		this.bpm = bpm;
	}
	
	public void dispose(){
		this.music.dispose();
	}
	
}
