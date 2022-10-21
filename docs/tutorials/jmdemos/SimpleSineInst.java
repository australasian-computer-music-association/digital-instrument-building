

import jm.audio.io.*;

import jm.audio.synth.*;

import jm.music.data.Note;

import jm.audio.AudioObject;



/**

 * A basic wavtebable synthesis instrument implementation

 * which implements envelope and volume control

 * @author Andrew Sorensen

 */



public final class SimpleSineInst extends jm.audio.Instrument{

	//----------------------------------------------

	// Attributes

	//----------------------------------------------

	/** the sample rate passed to the instrument */

	private int sampleRate;

    /** the sample rate passed to the instrument */

	private int channels;



	//----------------------------------------------

	// Constructor

	//----------------------------------------------

	/**

	 * Basic default constructor to set an initial 

	 * sampling rate.

	 * @param sampleRate 

	 */

	public SimpleSineInst(int sampleRate){

	    this.sampleRate = sampleRate;

	    this.channels = 1;

	}



	//----------------------------------------------

	// Methods 

	//----------------------------------------------

	   

	/**

	 * Initialisation method used to build the objects that

	 * this instrument will use.

	 * Declares the primary audio object array and the

	 * audio object(s) in that array. (One array element per channel)

	 */

	public void createChain(){

                Oscillator wt = new Oscillator(this, Oscillator.SINE_WAVE, 
                                               sampleRate, channels);
                
                
		Envelope env = new Envelope(wt, new EnvPoint[] {

			new EnvPoint((float)0.0, (float)0.0),
			new EnvPoint((float)0.02, (float)1.0),
			new EnvPoint((float)0.15, (float)0.6),
			new EnvPoint((float)0.9, (float)0.4),
			new EnvPoint((float)1.0, (float)0.0)

		});

		SampleOut sout = new SampleOut( env, "jmusic.tmp");

	}	

}



