import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// this class introduces two instruments at a time

public class WaveformExample8 implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample8();
	}
	
	public WaveformExample8() {

		// make the jmusic score
		Part part0 = new Part("Multiple Sine waves", 0);
		Score score = new Score(part0);
		for (int i = 0; i < 8; i++) {
			part0.addPhrase(makeAPhrase());
		}
		
		// set up audio instrument
		Instrument sine = new SlowSineInst(22000);
		
		// add instruments to an instrument array
		Instrument[] ensemble = {sine};
		
		//display score
		View.show(score);
		
		// render audio file of the score
		Write.au(score, "WaveformExample8.au", ensemble);
	}
	
	public Phrase makeAPhrase() {
		Phrase melody = new Phrase();
		melody.setStartTime(Math.random() * 4);
		for(int i = 0; i < 5; i++) {
			Note n = new Note(
				(int)(Math.random() * 60)+30, 
				Math.random()* 4 + 4.0,
				(int)(Math.random() * 90 + 30));
			n.setPan(Math.random());
			melody.addNote(n);
		}
		return melody;
	}
}

	
