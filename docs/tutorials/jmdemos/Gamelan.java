import jm.music.data.*;
import jm.JMC;
import jm.midi.*;
import jm.util.Write;
import jm.util.View;

/* 
* A class which creates a polyphonic texture of bell tone
* based on the [oitch class and rhythmic style of
* Indonesian gamelan music.
* @author Natalie Rouillon and Andrew R. Brown
*/

public final class Gamelan implements JMC{
	static int[] mode = {0,1,3,7,8};
	static double[] rhythm = {1.0,2.0};
		
	public static void main(String[] args){
		Score s = new Score("Gamelan");
		Part p = new Part("gong", BELLS, 0);
		
		//make phrases
		for(int i=0;i<2;i++) {
			Phrase phr = makePhrase(24);
			phr.setStartTime(0.0);
			p.addPhrase(phr);
		}
		
		s.addPart(p);

		Write.midi(s, "gamelan.mid");				
	}
	
	public static Phrase makePhrase(int howManyNotes) {
		Phrase tempPhrase = new Phrase();
		int temp; //variable to store random number
		int num;
		for(short i=0;i<howManyNotes;){
			// generate a random number between 65 and 77.
			temp = (int)(Math.random()*12 + 53);
			//check that it is a note in the mode 
			for (short j=0; j< mode.length; j++) {
				if ( temp%12 == mode[j]) {
					// We have a valid pitch now, called temp
					// Pick a random rhythm from the rhythm array
					num = (int)(Math.random()*rhythm.length);
					// if it is then add it to the phrase and move 
					// to the next note in the phrase
					Note n = new Note(temp,rhythm[num],(int)(Math.random()*40+60));
					tempPhrase.addNote(n);
					i++;
				}
			}
		}
		return tempPhrase;
	}
}
