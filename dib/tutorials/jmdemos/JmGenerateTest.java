import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.music.tools.*;
import jm.util.*;
import jm.gui.show.*;

/**
 * An example which generates two phrases
 * and shows the saving and loading of jm score, part, and phrase.
 * @author Andrew R. Brown and Alistair Riddel
 */
 
public final class JmGenerateTest implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - jm Generate test");
		Part part1 = new Part("part 1", 1, 0); 
		Part part2 = new Part("part 2", 1, 1); 
		Phrase phr = new Phrase(0.0);
		Phrase phr2 = new Phrase(0.0);
	
		double beat = Math.random() * 1.0;
		phr = note_density(beat);
		beat = Math.random() * 1.0;
		phr2 = note_density(beat);
				
		part1.addPhrase(phr);
		part2.addPhrase(phr2);
		score.addPart(part1);
		score.addPart(part2);
		
		// view the result
		View.show(score);

		//write a MIDI file to disk
		Write.midi(score, "generateTest.mid");
		
		//save as a jm file to disk
		Write.jm(score, "generateTest.jm");
		//save the part to disk
		Write.jm(part1, "generateTest.prt");
		//save the phrase to disk
		Write.jm(phr, "generateTest.phr");
		
		
		//create or empty and refill. Show to prove its back
		Score scoreCopy = new Score();
		Read.jm(scoreCopy, "generateTest.jm");
		scoreCopy.setTitle("Score Copy");
		View.show(scoreCopy, 10, 10);
		
		part1.empty();
		Read.jm(part1, "generateTest.prt");
		View.show(part1, 20, 20);
		
		phr.empty();
		Read.jm(phr, "generateTest.phr");
		View.show(phr, 40, 40);

		System.out.println("Done!");
	}
	

	private static Phrase note_density(double beat) {
	 	Phrase phrase = new Phrase();
 		int cnt;
 		int dyn = 100;
 		long dur = 350;
 		int pitch;
			
		cnt = (int)(Math.random() * 100);
    	System.out.println(cnt);
			
		for(short i=0;i<cnt;i++){
			pitch = (int)(Math.random() * 127);
			Note note = new Note(pitch, beat, dyn, dur);
			phrase.addNote(note);
		}
		return phrase;
	 }	
}
