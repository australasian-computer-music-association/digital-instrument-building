import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// this class introduces chiff noise

public class WaveformExample5 implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample5();
	}
	
	public WaveformExample5() {

		// make a jmusic score
		Phrase melody = new Phrase();
		for(int i = 0; i < 16; i++) {
			Note n = new Note(
                                        (int)(Math.random() * 12) * 2 + 60, 
                                        (int)(Math.random()* 5) * 0.25 + 0.25);
			melody.addNote(n);
		}
		Score score = new Score(new Part(melody));
		
		// set up audio instrument
		Instrument wave = new ChiffInst(44100);
		
		// for jMusic 1.1 or earlier put the instrument in an array
		// Instrument[] ensemble = {wave};
		
		// render audio file of the score
		Write.au(score, "WaveformExample5.au", wave);
		// for jMusic 1.1 or earlier substitute the line above with
		// Write.au(score, "WaveformExample.au", ensemble);
	}
}

	
