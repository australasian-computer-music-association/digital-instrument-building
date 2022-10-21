import jm.audio.io.*;
import jm.audio.synth.*;
import jm.music.data.Note;
import jm.audio.AudioObject;


public final class RTPluckInst extends jm.audio.Instrument{
	//----------------------------------------------
	// Attributes
	//----------------------------------------------
	/** The number of channels */
	private int channels;
	/** the sample rate passed to the instrument */
	private int sampleRate;

	//----------------------------------------------
	// Constructor
	//----------------------------------------------
	/**
	 */
	public RTPluckInst(int sampleRate){
	    this(sampleRate, 1);
	}
	/**
	 * A constructor to set an initial 
	 * sampling rate and number of channels.
	 * @param sampleRate 
	 */
	public RTPluckInst(int sampleRate, int channels){
		this.sampleRate = sampleRate;
		this.channels = channels;
	}

	//----------------------------------------------
	// Methods 
	//----------------------------------------------
	   
	/**
	 * Initialisation method used to build the objects that
	 * this instrument will use
	 */
	public void createChain(){
            SimplePluck plk = new SimplePluck(this,sampleRate, channels);
            Volume vol = new Volume(plk);
	}	
}

