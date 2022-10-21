

import jm.audio.io.*;
import jm.audio.Instrument;
import jm.audio.synth.*;
import jm.music.data.Note;
import jm.audio.AudioObject;
import jm.audio.io.RTIn;

public final class GranularInst extends jm.audio.Instrument{
	//----------------------------------------------
	// Attributes
	//----------------------------------------------
	/** the name of the sample file */
	private String fileName;
	/** How many channels is the sound file we are using */
	private int numOfChannels;
	/** the base frequency of the sample file to be read in */
	private double baseFreq;
	/** should we play the wholeFile or just what we need for note duration */
	private boolean wholeFile;
	/** The points to use in the construction of Envelopes */
	private EnvPoint[] pointArray = new EnvPoint[10];

	private Granulator grain;
	private int bufsize;
        private Volume vol;
        private StereoPan pan;
	//----------------------------------------------
	// Constructor
	//----------------------------------------------
	/**
	 * Constructor
	 */
	public GranularInst(String fileName,int bufsize){
		this.fileName = fileName;
		this.bufsize = bufsize;
                this.numOfChannels = 2;
	}

	//----------------------------------------------
	// Methods
	//----------------------------------------------
	/**
	 * Create the Audio Chain for this Instrument 
	 * and assign the primary Audio Object(s). The 
	 * primary audio object(s) are the one or more
	 * objects which head up the chain(s)
	 */
	public void createChain(){
		//define the chain
		//RTIn osc = new RTIn(this,44100,2,bufsize);
		SampleIn osc = new SampleIn(this,this.fileName);
		//Oscillator osc = new Oscillator(this,0,44100,2);
		grain = new Granulator(osc,50,100); 
		vol = new Volume(grain,0.5f);
                Volume vol2 = new Volume(vol,0.1f);
                pan = new StereoPan(vol2);
                SampleOut sout = new SampleOut(pan);
	}

	public void setGrainsPerSecond(int sp){
		grain.setGrainsPerSecond(sp);
	}

	public void setGrainDuration(int gdur){
		grain.setGrainDuration(gdur);
	}
	
	public void setFreqMod(float fmod){
		grain.setFreqMod(fmod);
	}
	public void setRandomIndex(boolean b){
		grain.setRandomIndex(b);
	}
	public void setRandomGrainDuration(boolean b){
		grain.setRandomGrainDuration(b);
	}
	
	public void setRandomGrainTop(int top){
		grain.setRandomGrainTop(top);
	}
	public void setRandomGrainBottom(int b){
		grain.setRandomGrainBottom(b);
	}
	public void setRandomFreq(boolean bool){
		grain.setRandomFreq(bool);
	}
	public void setRandomFreqBottom(double d){
		grain.setRandomFreqBottom(d);
	}
	public void setRandomFreqTop(double d){
		grain.setRandomFreqTop(d);
	}
        public void setVolume(float d){
		vol.setVolume(d);
	}
        public void setPan(float p){
		pan.setPan(p);
	}
}
