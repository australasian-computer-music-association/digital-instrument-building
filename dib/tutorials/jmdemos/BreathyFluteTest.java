import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.util.*;

 /**
 * @author Andrew R. Brown
 */
 
public final class BreathyFluteTest implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Audio test");
		Part part = new Part("wave", 0); 
		Phrase phr = new Phrase(0.0);
		int sampleRate = 44100;
		Instrument inst = new BreathyFluteInst(sampleRate);
		
		Note rootNote = new Note(60, 0.25, (int)(Math.random() * 70 + 40));
		for (int i = 1; i < 24; i++) {
			Note note = new Note(i + 60, 0.25, (int)(Math.random() * 70 + 40));
			if (note.isScale(MINOR_SCALE)) {
				phr.addNote(rootNote);
				phr.addNote(note);
			}
		}
		Note lastNote = new Note(84, 2.0, (int)(Math.random() * 70 + 40));
		phr.addNote(lastNote);
		
		part.addPhrase(phr);
		score.addPart(part);
        Write.au(score, "/Users/browna/Documents/BreathyFluteTest.au", inst); 
    }
}
