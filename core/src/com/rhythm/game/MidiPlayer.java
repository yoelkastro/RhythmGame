package com.rhythm.game;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class MidiPlayer {

	private File midi;
	private Sequencer sequencer;
	private int bpm;
	private int originalBPM = 60;
	
	public MidiPlayer(File midi, int bpm){
		
		this.midi = midi;
		this.bpm = bpm;
		
		try {
			this.sequencer = MidiSystem.getSequencer();
			this.sequencer.open();
			
			Sequence sequence = MidiSystem.getSequence(this.midi);
			this.sequencer.setSequence(sequence);
			this.sequencer.setTempoInBPM(this.bpm);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isBeat(){
		return this.distanceToBeat() == 0;
	}
	
	public float distanceToBeat(){
		return (this.getPosition() * (float) bpm / 60f) % 1f;
	}
	
	public int getBeat(){
		return (int) (this.getPosition() * bpm / 60f);
	}
	
	public float getPosition(){
		// Gets the position in the sequence in seconds. 0.40 is the offset, might change for each device
		return this.sequencer.getMicrosecondPosition() / 1000000f * ((float) this.originalBPM / this.bpm) - 0.40f;
	}
	
	public void start(){
		this.sequencer.start();
	}
	
	public int getBPM(){
		return this.bpm;
	}
	
	public void setMusic(File midi, int bpm){
		this.midi = midi;
		this.bpm = bpm;
		
		try {
			this.sequencer = MidiSystem.getSequencer();
			this.sequencer.open();
			
			Sequence sequence = MidiSystem.getSequence(this.midi);
			this.sequencer.setSequence(sequence);
			this.sequencer.setTempoInBPM(this.bpm);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

