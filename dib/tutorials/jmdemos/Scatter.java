import jm.JMC;
import jm.util.*;
import jm.music.data.*;
import jm.music.tools.*;

/**
* This class scatters phrases over 100 beats or so.
* @ author Andrew R. Brown
*/

public final class Scatter implements JMC{
	
        /**
	 * The main method, where all good Java programs start
	 */
	public static void main(String[] args){
		Score s = new Score();
		// loop through 16 parts
		// incrementing the instrument and channel each time
		for(int i=0; i<16;i++) {
		    Part p = new Part("part",i,i);
		    // create a couple of phrases in each part
		    for(int j=0; j<2;j++) {
                        Phrase phrase = new Phrase();
			// Use the makePhrase method (below)
                        phrase = makePhrase();
	 		p.addPhrase(phrase);
                    }
                    s.addPart(p);
	 	}	
	 	// provide some rhythmic structure by
	 	// accenting particular beats
	 	double[] accentArray = {0.0, 1.0, 1.5, 1.75, 3.0};
	 	Mod.accents(s, 4.0, accentArray);
	 	View.show(s);
	 	Write.midi(s, "TestMIDI.mid");	
	}
        
	/**
	 * This method generates a phrase based on a  random walk
	 */
	private static Phrase makePhrase() {
	    Phrase phr = new Phrase((Math.random()*400) * SQ);
	    int pitch = (int)(Math.random()*60+30);
	    for(int i=0;i<50;i++) {
                //randomly shift the pitch 
	        pitch += (int)(Math.random()*10-5);
                
                // if the pitch walks out of the bounds, put it back to 60.
                if(pitch <6 || pitch > 94) pitch = 60;
                
                //make the note, with random velocity to make it interesting
                Note n = new Note(pitch, SQ, (int)(Math.random()*70 
                                          + 30));
		//add note to phrase
                phr.addNote(n);
            }
            return phr;
	}
}
