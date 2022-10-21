import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.util.*;

public final class TimpaniTest implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Audio test");
		Part part = new Part("wave", 0);
		Phrase phr = new Phrase(0.0);
		int sampleRate = 44100;
		Instrument inst = new TimpaniInst(sampleRate);
		for (int i=0; i<8; i++ ) {
			Note note = new Note(C3 - i, 1.0);
			phr.addNote(note);
		}
		part.addPhrase(phr);
		score.addPart(part);
		Write.au(score, "TimpaniTest.au", inst);
	}
}