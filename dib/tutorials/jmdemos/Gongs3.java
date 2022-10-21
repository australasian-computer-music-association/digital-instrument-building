import jm.music.data.*;
import jm.music.tools.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// Gong-like timbres inspired by Claude Risset's early computer music pieces

public class Gongs3 implements JMC {
	
	public static void main(String[] args) {
		new Gongs3();
	}
	
	public Gongs3() {		
		// musical score construction
		Score score = new Score("Gongs 3");
		int partCounter = 0;
		double startTime = 0.0;
		// loop for a number of gongs
		for (int j = 0; j < 5; j++) {
			startTime = score.getEndTime();
			int fundPitch = (int)(Math.random() * 12 + C2);
			int pitch = 60;
			double length = Math.random() * 10.0 + 4.0;
			// loop for the number of partials in each gong
			for (int i = 0; i < 8; i++) {
				Part p = new Part("Part" + partCounter, partCounter);
				partCounter ++;
				Phrase phrase = new Phrase(startTime);
				if (i == 0 ) { // base pitch
					pitch = fundPitch;
					phrase.addNote(new Note(pitch, length + 2.0, 
						127 + C2 - pitch - (int) (Math.random() * 20)));
				} else { // overtones
					pitch = (int)(Math.random() * 16 + fundPitch + 8);
					phrase.addNote(new Note(pitch, length, 
						127 + C2 - pitch - (int) (Math.random() * 20)));
				}
				p.addPhrase(phrase);
				score.addPart(p);
			}
		}
		
		View.show(score);
		
		// instrument declaration
		int sampleRate = 11000;
		
		Instrument[] ensemble = new Instrument[partCounter];
		
		for (int k = 0; k < partCounter; k++) {
			ensemble[k] = new VaryDecaySineInst(sampleRate);
		}
			
		// render
		Write.au(score, "Gongs3.au", ensemble);
	}
}
