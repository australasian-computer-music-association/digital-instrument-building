import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

public class WaveformPrintOut implements JMC {
	
	public static void main(String[] args) {
		new WaveformPrintOut();
	}
	
	public WaveformPrintOut() {
		// make a jmusic score
		Note n = new Note(C4, QUAVER);
		Score score = new Score(new Part(new Phrase(n)));
		
		// set up audio instrument
		Instrument printout = new PrintSineInst(44100);
		
		// for jMusic 1.1 or earlier put the instrument in an array
		// Instrument[] ensemble = {printout};
		
		// render audio file of the score
		Write.au(score, "WaveformExample.au", printout);
		// for jMusic 1.1 or earlier substitute the line above with
		// Write.au(score, "WaveformExample.au", ensemble);
	}
}

	
