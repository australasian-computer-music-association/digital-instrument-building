import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// this class introduces two instruments at a time

public class WaveformExample6 implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample6();
	}
	
	public WaveformExample6() {

		// make a jmusic score
		Phrase melody = new Phrase();
		for(int i = 0; i < 10; i++) {
			Note n = new Note(
                                 (int)(Math.random() * 12) * 2 + 60, 
                                 (int)(Math.random()* 5) * 0.25 + 0.25,
                                 (int)(Math.random() * 60 + 60));
			melody.addNote(n);
		}
		Score score = new Score(new Part(melody));
		
		// add a second part
		Part part2 = new Part("Unison", 1);
		Phrase phrase2 = new Phrase();
		phrase2 = melody.copy();
		part2.addPhrase(phrase2);
		score.addPart(part2);
		
		// set up audio instrument
		Instrument chiff = new ChiffInst(44100);
		Instrument tri = new TriangleInst(44100);
		
		// add instruments to an instrument array
		Instrument[] ensemble = {chiff, tri};
		
		// render audio file of the score
		Write.au(score, "WaveformExample6.au", ensemble);
	}
}

	
