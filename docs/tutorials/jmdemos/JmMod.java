import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.music.tools.*;
import jm.util.*;

/**
 * An example which reads in, accesses,  and 
 * then modifies an existing jm score file
 * @author Andrew R. Brown and Alistair Riddel
 */
 
public final class JmMod implements JMC{

	public static void main(String[] args){
		Score score = new Score("JMDemo - Modify a jm file");
		Part inst = new Part(); 
		Part inst2 = new Part();
		Phrase phr = new Phrase(0.0);
		Phrase phr2 = new Phrase(0.0);

		//read in the jm file to be modified
		Read.jm(score, "generate.jm");
		
		View.show(score);
		
		//extract out the score bits to work on
		inst = score.getPart(0);
		inst2 = score.getPart(1);
     	phr = inst.getPhrase(0);
     	phr2 = inst2.getPhrase(0);
		
		//make the modification
		//make the phrases sequential rather than simultaneous
		phr2.setStartTime(phr.getEndTime());
		
		//Show the result
     	View.show(score);

		//write a JM Score file to disk
		Write.jm(score, "generateMod.jm");	

		//write a MIDI file to disk of the result
		Write.midi(score, "generateMod.mid");
	}	
}
