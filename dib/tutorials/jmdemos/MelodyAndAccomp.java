import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import jm.audio.*;


/**
 * An example of simple audio rendering of a non-trivial jMusic score
 * @author Andrew R. Brown
 */

public class MelodyAndAccomp implements JMC{
	//----------------
	// Class Attributes
	//----------------
	private Score s = new Score("AU demo");	
	private Part p1 = new Part("Melody", 0);
	private Part p2 = new Part("Chords", 1);
	private int sampleRate = 22000;
	private Instrument[] insts = {new SineInst(sampleRate), 
		new TriangleInst(sampleRate)};
	private int bars = 4; //measures in American
	//---------------------
	// required main method
	//---------------------
	public static void main(String[] args) {	
		new MelodyAndAccomp();
	}
	
	//------------------
	// Constructor
	//------------------
	public MelodyAndAccomp() {
		makeMelody();
		makeChords();
		completeScore();
		renderAudio();
	}
	
	//-------------------
	// Methods
	//-------------------
	
	// Create the stochastic melodic phrase
	private void makeMelody() {
		Phrase phr = new Phrase();
		int temp, newPitch; //variable to store random number
		int[] mode = {0,2,4,5,7,9,11,12}; //C major scale degrees
		int prevPitch = 60; //start on middle C
		
		// create a melody of 25 randomly pitched quavers within C major.
		for(short i=0;i<bars*8-3;){
			// generate a random number up to two octaves (or so) above middle C.
			temp = (int)(Math.random()*14 - 7);
			// smooth the melodic contour
			newPitch = prevPitch + temp;
			//check that it is a note in the mode (C major in this case)
			for (short j=0; j< mode.length; j++) {
				if ( newPitch%12 == mode[j] && newPitch > 0 && newPitch < 127) {
					// if it is then add it to the phrase and move to the next note in the phrase
					if(i == bars*8-4) {
						Note n = new Note(newPitch, M, (int)(Math.random()*50+60));
						phr.addNote(n);
					} else {
						Note n = new Note(newPitch, Q, (int)(Math.random()*50+60));
						phr.addNote(n);
					}
					prevPitch = newPitch;
					i++;
				}
			}
		}
			
		// add the phrase to part 1
		p1.addPhrase(phr);
	}
	
	//make the chordal accompaniment
	private void makeChords() {
		// create a CPhrase
		CPhrase cp = new CPhrase(0.0);
		// Choose one of three chords sequences at random
		for(short i=0;i<bars*2;i++) {
			int x = (int)(Math.random()*3);
			System.out.println("chord var x is " + x);
			if (x==0) {
				int[] pitchArray = {c3,e3,g3};
				cp.addChord(pitchArray, SQ);
				cp.addChord(pitchArray, Q);
				cp.addChord(pitchArray, C);
				cp.addChord(pitchArray, SQ);
			} else if (x==1) {
				 int[] pitchArray = {d3,f3,a3};
				 cp.addChord(pitchArray, M);
			} else {
				int[] pitchArray = {b2,d3,g3};
				cp.addChord(pitchArray, C);
				cp.addChord(pitchArray, C);
			}			
		}
		// add the phrase to part 2
		p2.addCPhrase(cp);
	}
	
	// combine parts into a score
	private void completeScore() {
		s.addPart(p1);
		s.addPart(p2);
	}
	
	//save as an au audio file
	private void renderAudio() {
		Write.au(s, "Melody_and_Accomp.au", insts); 
	}
}
