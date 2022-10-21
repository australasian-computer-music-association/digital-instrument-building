import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.util.*;

 /**
  * @author Timothy Opie
  * Updated 24/06/2002
  *
  * Non-real-time demo of granular synthesis
  */
 
public final class GranulatorTest implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Audio test");
		Part part = new Part("wave", 0); 
		Phrase phr = new Phrase(0.0);
		int sampleRate = 44100;
                int bufferSize = sampleRate/4;
		GranularInst inst = new GranularInst("song1.au", bufferSize);
		Note note = new Note(A4, 4.0); //about 4k
		phr.addNote(note);
		part.addPhrase(phr);
		score.addPart(part);
		Write.au(score, "GranularTest.au", inst); 
    }
}
