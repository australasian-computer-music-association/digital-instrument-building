import jm.music.data.*;
import jm.music.tools.*;
import jm.JMC;
import jm.audio.*;
import jm.util.*;

// Gong-like timbres inspired by Claude Risset's early computer music pieces

public class Gongs implements JMC {
	
	public static void main(String[] args) {
		new Gongs();
	}
	
	public Gongs() {		
		// musical score construction
		CPhrase notes1 = new CPhrase();
		
		int[] pitches = {CS4, BF4, D5, E5, A5};
		notes1.addChord(pitches, 8.0);
		notes1.addChord(pitches, 8.0);
		notes1.addChord(pitches, 8.0);
		notes1.addChord(pitches, 8.0);
		Part part0 = new Part("Gongs go here", 0);
		part0.addCPhrase(notes1);
		Score score = new Score(part0);
		
		View.show(score);
		
		// instrument declaration
		int sampleRate = 22000;
		Instrument variableSine = new SimpleSineInst(sampleRate);

		// render
		Write.au(score, "Gongs.au", variableSine);
	}
}
