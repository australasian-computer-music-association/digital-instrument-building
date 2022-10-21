import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

public class WaveformExample implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample();
	}
	
	public WaveformExample() {
		// make a jmusic score
		Note n = new Note(C4, MINIM);
		Score score = new Score(new Part(new Phrase(n)));
		
		// set up audio instrument
		Instrument sineWave = new SimpleSineInst(44100);
		
		// for jMusic 1.1 or earlier put the instrument in an array
		// Instrument[] ensemble = {sineWave};
		
		// render audio file of the score
		Write.au(score, "WaveformExample.au", sineWave);
		// for jMusic 1.1 or earlier substitute the line above with
		// Write.au(score, "WaveformExample.au", ensemble);
	}
}

	
