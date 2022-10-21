import jm.JMC;
import jm.util.*;
import jm.music.data.*;
import jm.midi.*;

import jm.audio.synth.*;
import jm.audio.Instrument;

import java.io.File;


public final class AddSynthTest implements JMC{
	public static void main(String[] args){
		Score s = new Score("Additive synthesis test");
		Part p = new Part("Flute", 0);
		Phrase  phr = new Phrase();
		//create the test note/score and display it
	    for(int i=0;i<6;i++) {
	        Note n = new Note(A2+i*6, 0.5*(i+1));
		    phr.addNote(n);
		}
		p.addPhrase(phr);
		s.addPart(p);
		
		//create the instrument
		AddSynthInst inst = new AddSynthInst(44100);
		Instrument[] ensemble = {inst};
		
		// write out the files
		Write.au(s, "AddSynthTest.au",ensemble);

	}
}
