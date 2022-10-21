

import jm.audio.io.*;

import jm.audio.synth.*;

import jm.music.data.Note;

import jm.audio.AudioObject;

//import jm.audio.lang.*;



/**

 * A basic additive synthesis instrument implementation

 * which implements envelope and volume control

 * @author Andrew Sorensen

 */



public final class SineInst extends jm.audio.Instrument{

	//----------------------------------------------

	// Attributes

	//----------------------------------------------

	/** The points to use in the construction of Envelopes */

	private EnvPoint[] pointArray = new EnvPoint[10];

	/** The number of channels */

	private int channels;

	/** the sample rate passed to the instrument */

	private int sampleRate;



	//----------------------------------------------

	// Constructor

	//----------------------------------------------

	/**

	 * Basic default constructor to set an initial 

	 * sampling rate.

	 * @param sampleRate 

	 */

	public SineInst(int sampleRate){

	    this(sampleRate, 2);

	}

	/**

	 * A constructor to set an initial 

	 * sampling rate and number of channels.

	 * @param sampleRate 

	 */

	public SineInst(int sampleRate, int channels){

		this.sampleRate = sampleRate;

		this.channels = channels;

		EnvPoint[] tempArray = {

			new EnvPoint((float)0.0, (float)0.0),

			new EnvPoint((float)1.0, (float)0.15),

			new EnvPoint((float)0.4, (float)0.3),

			new EnvPoint((float)0.3, (float)0.9),

			new EnvPoint((float)0.0, (float)1.0)

		};

		pointArray = tempArray;

	}



	//----------------------------------------------

	// Methods 

	//----------------------------------------------

	   

	/**

	 * Initialisation method used to build the objects that

	 * this instrument will use

	 */

	public void createChain(){

		Oscillator wt = new Oscillator(this, Oscillator.SINE_WAVE, sampleRate, channels);
                
		Envelope env = new Envelope(wt, pointArray);

		Volume vol = new Volume(env,(float)1.0);

		StereoPan span = new StereoPan(vol);

		SampleOut sout = new SampleOut(span);

	}	

}



