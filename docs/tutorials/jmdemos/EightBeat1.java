import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*; 


public class EightBeat1 extends Basic_550 {
    static double[] kckRhythmArray = {2.0, 0.5, 1.5};
    static double[] snrRhythmArray = {2.0, 1.0};
    static double[] chhRhythmArray = {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5};
    
    static double barLength = 4.0;
	static double[] accents = {1.0, 2.0, 3.0, 4.0}; 
	
	public static void main(String[] args) {
	    new EightBeat1();
	    View.print(drumScore);
	    Write.midi(drumScore, "EightBeat1.mid");
	}
	
	public EightBeat1() {
	    kck(kckRhythmArray);
	    snr(snrRhythmArray, 1.0);
	    chh(chhRhythmArray);
	    Mod.accents(drumScore, barLength, accents);
	}
}
