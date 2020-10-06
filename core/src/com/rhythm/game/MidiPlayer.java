package com.rhythm.game;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class MidiPlayer {

	private static File midi;
	private static Sequencer sequencer;
	private static int bpm;
	private static int originalBPM = 60;
	
	public static void initialize(File mid, int bpmSet){
		
		midi = mid;
		bpm = bpmSet;
		
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence sequence = MidiSystem.getSequence(midi);
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(bpm);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean isBeat(){
		return distanceToBeat() == 0;
	}
	
	public static float distanceToBeat(){
		return (getPosition() * (float) bpm / 60f) % 1f;
	}
	
	public static int getBeat(){
		return (int) (getPosition() * bpm / 60f);
	}
	
	public static float getPosition(){
		// Gets the position in the sequence in seconds. 0.40 is the offset, might change for each device
		return sequencer.getMicrosecondPosition() / 1000000f * ((float) originalBPM / bpm) - 0.4f;
	}
	
	public static void start(){
		sequencer.start();
	}
	
	public static int getBPM(){
		return bpm;
	}
	
}

