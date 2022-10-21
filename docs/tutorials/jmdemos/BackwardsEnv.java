import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.audio.*;
import jm.util.*;

 /**
 * @author Andrew R. Brown
 */
 
public final class BackwardsEnv implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Audio test");
		Part part = new Part("wave", 0); 
		Phrase phr = new Phrase(0.0);
		int sampleRate = 44100;
		Instrument inst = new SquareInst(sampleRate);
		Instrument inst2 = new SquareBackwardsInst(sampleRate);
		
		Instrument[] ensemble = {inst, inst2};
		
		for(int i = 0; i < 12; i++ ) {
			Note note = new Note((int)(Math.random() * 12) + 60, 
				0.25, 
				(int)(126 / 12 * i + 1));
			note.setPan(1.0 / 12.0 * i);
			phr.addNote(note);
		}
		part.addPhrase(phr);
		score.addPart(part);
		
		Phrase phr2 = phr.copy();
		phr2.setStartTime(phr.getEndTime());
		Mod.retrograde(phr2);
		Part part2 = new Part("back", 1);
		part2.addPhrase(phr2);
		score.addPart(part2);
		
        Write.au(score, "BackwardsEnv.au", ensemble); 
    }
}
