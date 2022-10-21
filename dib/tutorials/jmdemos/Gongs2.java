import jm.music.data.*;
import jm.music.tools.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// Gong-like timbres inspired by Claude Risset's early computer music pieces

public class Gongs2 implements JMC {
	
	public static void main(String[] args) {
		new Gongs2();
	}
	
	public Gongs2() {		
		// musical score construction
		Score score = new Score();
		
		Part part0 = new Part("zero", 0);
		part0.addPhrase(new Phrase(new Note(CS4, 8.0)));
		Part part1 = new Part("one", 1);
		part1.addPhrase(new Phrase(new Note(BF4, 8.0)));
		Part part2 = new Part("two", 2);
		part2.addPhrase(new Phrase(new Note(D5, 8.0)));
		Part part3 = new Part("three", 3);
		part3.addPhrase(new Phrase(new Note(E5, 8.0)));
		Part part4 = new Part("four", 4);
		part4.addPhrase(new Phrase(new Note(A5, 8.0)));
		
		score.addPart(part0);
		score.addPart(part1);
		score.addPart(part2);
		score.addPart(part3);
		score.addPart(part4);
		
		
		View.show(score);
		
		// instrument declaration
		int sampleRate = 22000;
		Instrument variableSine1 = new VaryDecaySineInst(sampleRate);
		Instrument variableSine2 = new VaryDecaySineInst(sampleRate);
		Instrument variableSine3 = new VaryDecaySineInst(sampleRate);
		Instrument variableSine4 = new VaryDecaySineInst(sampleRate);
		Instrument variableSine5 = new VaryDecaySineInst(sampleRate);
		
		Instrument[] ensemble = {variableSine1, variableSine2, variableSine3, 
			variableSine4, variableSine5};
			
		// render
		Write.au(score, "Gongs2.au", ensemble);
	}
}
