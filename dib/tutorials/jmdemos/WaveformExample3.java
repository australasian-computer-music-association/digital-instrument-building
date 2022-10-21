import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// this class introduces triangle wave 

public class WaveformExample3 implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample3();
	}
	
	public WaveformExample3() {

		// make a jmusic score
		Phrase melody = new Phrase();
		for(int i = 0; i < 24; i++) {
			Note n = new Note((int)(Math.random() * 12) * 2 + 60, QUAVER);
			melody.addNote(n);
		}
		Score score = new Score(new Part(melody));
		
		// set up audio instrument
		Instrument wave = new TriangleInst(44100);
		// for jMusic 1.1 or earlier put the instrument in an array
		// Instrument[] ensemble = {wave};
		
		// render audio file of the score
		Write.au(score, "WaveformExample3.au", wave);
		// for jMusic 1.1 or earlier substitute the line above with
		// Write.au(score, "WaveformExample.au", ensemble);
	}
}

	
