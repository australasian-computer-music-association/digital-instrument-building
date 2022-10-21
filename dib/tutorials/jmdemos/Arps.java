import jm.music.data.*;
import jm.music.tools.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

public class Arps implements JMC {
	
	public static void main(String[] args) {
		new Arps();
	}
	
	public Arps() {		
		// musical score construction
		int[] pitches = {60, 67, 72, 74};
		Phrase phrase1 = new Phrase();
		Phrase phrase2 = new Phrase();
		Phrase phrase3 = new Phrase();
		Part part1 = new Part("One", 0);
		Part part2 = new Part("Two", 1);
		Part part3 = new Part("Three", 2);
		
		// make arpeggios
		int loop = pitches.length;
		for (int i = 0; i < loop * 4; i++) {
			for (int j = 0; j < loop; j++) {
				for (int k = 0; k < loop; k++) {
					Note n3 = new Note(pitches[k] + 24, 0.0625, (int)(Math.random() * 60 + 20));
					n3.setPan(Math.random());
					phrase3.addNote(n3);
				}
				Note n = new Note(pitches[j], SEMI_QUAVER, (int)(Math.random() * 40 + 80));
				n.setPan(0.2);
				phrase1.addNote(n);
			}
			Note n2 = new Note(pitches[i % pitches.length] - 24, CROTCHET, (int)(Math.random() * 40 + 40));
			n2.setPan(0.8);
			phrase2.addNote(n2);
		}
		Mod.cycle(phrase3, pitches.length * 4.0 + 9.0);
		Mod.shuffle(phrase3);
		Mod.fadeOut(phrase3, 9.0);
		Mod.fadeIn(phrase1, 16);
		Mod.fadeOut(phrase2, 8);
		
		part1.addPhrase(phrase1);
		part2.addPhrase(phrase2);
		part3.addPhrase(phrase3);
		
		Score score = new Score(part1);
		score.addPart(part2);
		score.addPart(part3);
		
		View.show(score);
		
		// instrument declaration
		int sampleRate = 22000;
		Instrument saw = new SawtoothInst(sampleRate);
		Instrument tri = new TriangleInst(sampleRate);
		Instrument sin = new SineInst(sampleRate);
		Instrument[] ensemble = {tri, saw, sin};
		
		// render
		Write.au(score, "Arps.au", ensemble);
	}
}
