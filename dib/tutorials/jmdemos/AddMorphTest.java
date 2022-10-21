import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.util.*;
public final class AddMorphTest implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Additive Synthesis test");
		Part part = new Part("Spectra Notes", 0);
		Phrase phr = new Phrase(0.0);
		int sampleRate = 44100;
		Instrument inst = new AddMorphInst(sampleRate);
		Note note = new Note(C3, 8.0);
		phr.addNote(note);
		part.addPhrase(phr);
		score.addPart(part);
		Write.au(score, "AddMorphTest.au", inst);
	}
}