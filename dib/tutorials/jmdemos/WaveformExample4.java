import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// this class introduces white noise

public class WaveformExample4 implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample4();
	}
	
	public WaveformExample4() {

		// make a jmusic score
		Phrase melody = new Phrase();
		for(int i = 0; i < 24; i++) {
			Note n = new Note(
                                        (int)(Math.random() * 12) * 2 + 60, 
                                        (int)(Math.random()* 5) * 0.25 + 0.1);
			melody.addNote(n);
		}
		Score score = new Score(new Part(melody));
		
		// set up audio instrument
		Instrument wave = new NoiseInst(44100);
		
		// for jMusic 1.1 or earlier put the instrument in an array
		// Instrument[] ensemble = {wave};
		
		// render audio file of the score
		Write.au(score, "WaveformExample4.au", wave);
		// for jMusic 1.1 or earlier substitute the line above with
		// Write.au(score, "WaveformExample.au", ensemble);
	}
}

	
