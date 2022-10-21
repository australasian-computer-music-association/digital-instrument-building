import jm.music.data.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// this class introduces two instruments at a time

public class WaveformExample7 implements JMC {
	
	public static void main(String[] args) {
		new WaveformExample7();
	}
	
	public WaveformExample7() {

		// make the first jmusic score
		Phrase melody = new Phrase();
		for(int i = 0; i < 24; i++) {
			Note n = new Note(
				(int)(Math.random() * 12) * 2 + 50, 
				(int)(Math.random()* 4) * 0.5 + 0.5,
				(int)(Math.random() * 60 + 60));
			n.setPan(Math.random());
			melody.addNote(n);
		}
		Score score = new Score(new Part(melody));
		
		// add a second part
		Part part2 = new Part("Unison", 1);
		Phrase phrase2 = new Phrase();
		phrase2 = melody.copy();
		part2.addPhrase(phrase2);
		score.addPart(part2);
		
		// Create a counterpoint
		Phrase phrase3 = new Phrase();
		int[] intervals = {3, 5, 7, 9, 12};
		double rhythmValue;
		int pitch;
		for (int i = 0; i < melody.size(); i++) {
			rhythmValue = melody.getNote(i).getRhythmValue();
			rhythmValue = rhythmValue / 2.0;
			pitch = melody.getNote(i).getPitch() + 
				intervals[(int)(Math.random() * 
                                                intervals.length)];
			phrase3.addNote(new Note(pitch, rhythmValue));
			if (Math.random() > 0.5) { // passing note direction?
				pitch += 2;
			} else pitch -= 2;
			phrase3.addNote(new Note(pitch, rhythmValue));
		}
		Part part3 = new Part("Counterpoint", 2);
		part3.addPhrase(phrase3);
		score.addPart(part3);
		
		// set up audio instrument
		//Instrument sine = new SineInst(44100);
		Instrument chiff = new ChiffInst(44100);
		Instrument tri = new TriangleInst(44100);
		
		// add instruments to an instrument array
		Instrument[] ensemble = {chiff, tri};
		
		// render audio file of the score
		Write.au(score, "WaveformExample7.au", ensemble);
	}
}

	
