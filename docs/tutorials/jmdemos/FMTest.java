import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.audio.*;
import jm.util.View;
import jm.util.Write;

/**
 * @author Andrew R. Brown
 */
public final class FMTest implements JMC{
	public static void main(String[] args){
		Score s = new Score();
		Part p = new Part("Flute", 0);
		Phrase  phr = new Phrase();
		SimpleFMInst inst = new SimpleFMInst(22000, 400, 7.2);
		Instrument[] ensemble = {inst};
		
		//create the sclae phrase note by note
	    for(int i=0;i<6;i++) {
	        Note n = new Note(A2+i*6, 0.5*(i+1));
		    phr.addNote(n);
		}
		p.addPhrase(phr);
		s.addPart(p);
		
		View.show(s);
		
		Write.au(s, "FMTest.au", ensemble);
	}
}
