import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;


public class EightBeat1FillIn extends Basic_550 {
    static double[] kckRhythmArray = {3.0, 1.0};
    static double[] snrRhythmArray = {0.25, 0.25};
    static double[] crshRhythmArray = {4.0};
    static double[] phhRhythmArray = {1.0, 1.0, 1.0, 1.0};
    static double[] ltmRhythmArray = {0.5, 0.5, 1.25};
    static double[] mtmRhythmArray = {0.5, 2.75};
    static double[] htmRhythmArray = {0.25, 3.75};
    
   	static double[] accents = {1.0, 2.0, 2.25, 3.0, 3.25, 4.0}; 
	
	public static void main(String[] args) {
	    setBarLength(4.0);
	    new EightBeat1FillIn();
	    View.print(drumScore);
	    Write.midi(drumScore, "EightBeat1FillIn.mid");
	  
	}
	
	public EightBeat1FillIn() {
	    kck(kckRhythmArray);
	    snr(snrRhythmArray, 3.0);
	    crsh(crshRhythmArray);
	    phh(phhRhythmArray);
	    ltm(ltmRhythmArray, 1.75);
	    mtm(mtmRhythmArray, 0.75);
	    htm(htmRhythmArray);
	    Mod.accents(drumScore, barLength, accents);
	}
}
