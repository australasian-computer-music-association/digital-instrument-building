import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.audio.Instrument;
import java.awt.*;

/**
 * An example which creates a known chorale played in various tuning systems
 * It exploits the ability to specify audio notes by frequency.
 * @author Andrew R. Brown
 */

public final class Tuning_Systems_MIDI implements JMC{
    public static void main(String[] args){
        new Tuning_Systems_MIDI();
    }
    
    FileDialog fd;
    
    public Tuning_Systems_MIDI() {
        //chose a file
        fd = new FileDialog(new Frame(), "choose a midi file...", fd.LOAD);
        fd.show();
        //create a score
        Score score = new Score();
	Read.midi(score, fd.getDirectory()+fd.getFile());
	
        fd.dispose();
        fd = null;
        
        // current mode
        double[] modeRatios = PYTHAGOREAN;
        
                
        //change pitch frequencies in the parts to the score
	for (int i=0; i<score.size(); i++) {
	    modifyPart(score.getPart(i), 0, modeRatios);
	}
        
        Write.au(score, "TuningSystemsMIDI.au", new SquareLPFInst(44100, 500));
        
    }


    private void modifyPart(Part part, int instrument, double[] modeRatios) {
	part.setInstrument(instrument);
	// process notes
	for(int j=0; j<part.size(); j++) {
	    Phrase phr = part.getPhrase(j);
	    for(int k=0; k<phr.size(); k++) {
		Note n = phr.getNote(k);
		int pitch = n.getPitch();
                System.out.println("pitch = " + pitch);
		if (pitch != REST ) {
		    int degree = pitch%12; // assumes we're in C maj or A min
		    n.setFrequency( FRQ[pitch - degree] * modeRatios[degree]);
		}
	    }
	}
    }
}
	
