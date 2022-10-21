import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.music.tools.*;
import jm.util.*;

/**
 * An example which generates thed writing of two phrases
 * and saving as a jm file.
 * For use with JmMod.java which edits the jm file
 * @author Andrew R. Brown and Alistair Riddel
 */
 
public final class JmGenerate implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - jm Generate");
		Part part1 = new Part("part 1", FLUTE, 0); 
		Part part2 = new Part("part 2", PIANO, 1);
		Phrase phr = new Phrase(0.0);
		Phrase phr2 = new Phrase(0.0);
		
		double beat = Math.random() * 1.0;
		phr = note_density(beat);
		
		beat = Math.random() * 5.0 + 1.0;
		phr2 = note_density(beat);
		
		part1.addPhrase(phr);
		part2.addPhrase(phr2);
		score.addPart(part1);
		score.addPart(part2);
		
		// view the result
		View.show(score);

		//write a MIDI file to disk
		Write.midi(score, "generate.mid");
		
		//save as a jm file to disk
		Write.jm(score, "generate.jm");
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
			Note note = new Note(pitch, beat,dyn);
			note.setDuration(dur);
			phrase.addNote(note);
		}
		return phrase;
	 }	
}
