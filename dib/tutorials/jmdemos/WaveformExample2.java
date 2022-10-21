import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

public class WaveformExample2 implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample2();
	}
	
	public WaveformExample2() {
		// make a jmusic score
		Phrase melody = new Phrase();
		for(int i = 0; i < 24; i++) {
			Note n = new Note((int)(Math.random() * 12) * 2 + 60, 
                                          SQ);
			melody.addNote(n);
		}
		Score score = new Score(new Part(melody));
		
		// set up audio instrument
		Instrument sineWave = new SimpleSineInst(44100);
		
		// for jMusic 1.1 or earlier put the instrument in an array
		// Instrument[] ensemble = {sineWave};
		
		// render audio filec of the score
		Write.au(score, "WaveformExample2.au", sineWave);
		// for jMusic 1.1 or earlier substitute the line above with
		// Write.au(score, "WaveformExample.au", ensemble);
	}
}

	
