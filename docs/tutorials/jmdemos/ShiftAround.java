//==========================================================
//File:                 Shift up, down, left, right
//Function:             Demonstartes phrase positioning and transposing 
//						in both time and pitch dimensions.
//Author:               Andrew R. Brown
//Environment           Java 1.1.7 with jMusic extensions
//============================================================
import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.midi.*;
import jm.util.*;


public class ShiftAround implements JMC{

	public static void main(String[] args) {
		Score score = new Score("JMDemo - Simple Auto Arranging");
		Part flutePart = new Part("Flute", FLUTE, 0);
		Phrase phr1 = new Phrase();
		double[] riff = {60, SQ, 67, SQ, 65, Q, 67, Q, 60, Q, 62, SQ, 67, SQ, 62, SQ, 59, SQ, 64, C};
		
		// create an initial phrase
		phr1.addNoteList(riff);
				
		// make sequenced phrases
		Phrase phr2 = phr1.copy();
		Mod.transpose(phr2, 2);
		Phrase phr3 = phr1.copy();
		Mod.transpose(phr3, 4);
		
		// add phrases to the part
		flutePart.addPhrase(phr1);
		flutePart.addPhrase(phr2);
		flutePart.addPhrase(phr3);
	    	    
		// add part to score
		score.addPart(flutePart);
		
		//arrange at random later on
		double currentEnd = score.getEndTime();
		int times = (int)(Math.random()* 8 + 7);
		for(int i=1;i<times;i++){
			// make a copy of the phrase
			Phrase temp = phr1.copy();
			// adjust the start time of the copy
			double newStart = (double)(int)(Math.random()*32) + currentEnd;
			temp.setStartTime(newStart);
			//shift the phrase in octaves at random
			Mod.transpose(temp, (int)(Math.random()*5 -2) *12);
			//add the copied phrase to the  part then score
			Part p = new Part("Part "+i, 56 + (int)(Math.random() * 23), i);
			// avoid GM drums
			if (p.getChannel() == 9) p.setChannel(16);
			// package phrase into jm score
			p.addPhrase(temp);
			score.addPart(p);
		}
		
	    Mod.shake(score, 50);

		// display
		View.show(score);
		
		//write a MIDI file to disk
		Write.midi(score, "ShiftAround.mid");
	}
}
