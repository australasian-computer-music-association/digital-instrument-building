import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.util.*;

public final class HarmonicsTest implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Audio test");
		Part part = new Part("wave", 0);
		Phrase phr = new Phrase(0.0);
		int sampleRate = 44100;
		Instrument inst = new OvertoneInst(sampleRate);
		Note note = new Note(C4, 4.0);
		phr.addNote(note);
		part.addPhrase(phr);
		score.addPart(part);
		Write.au(score, "HarmonicsTest.au", inst);
	}
}