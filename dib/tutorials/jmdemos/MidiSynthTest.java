import jm.JMC;
import jm.util.*;
import jm.music.data.*;
import qt.QTPlayer;
import jm.music.tools.Mod;
import jm.midi.MidiSynth;

public final class MidiSynthTest implements JMC{
	/**
	 * Main method we're all good Java programs start
	 */
	public static void main(String[] args){
		Score s = new Score();
                s.setTempo(130.0);
		for(int i=0; i<3;i++) {
		    Part p = new Part("part",i*5,i);
                    p.setTempo(120.0 + (double)i * 0.5);
		    for(int j=0; j<1;j++) {
	 			Phrase phrase = new Phrase();
	 			phrase = makePhrase(0.0, 50); //(Math.random()*400) * C)
	 			p.addPhrase(phrase);
	 		}
	 		s.addPart(p);
	 	}	
	 	//View.show(s);
	 	//QTPlayer.display(s);
	 	Write.midi(s, "TestMIDI.mid");
                Play.midi(s);
	}
	
	private static Phrase makePhrase(double startTime, int length) {
	    Phrase phr = new Phrase(startTime);
	    int pitch = (int)(Math.random()*60+30);
	    for(int i=0; i < length; i++) {
	        pitch += (int)(Math.random()*10-5);
			Note n = new Note(pitch, CROTCHET, (int)(Math.random()*70 + 30));
			phr.addNote(n);
		}
		return phr;
	}
}
