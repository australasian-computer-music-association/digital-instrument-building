/*

< This Java Class is tutorial file with the jMusic API >

Copyright (C) 2000 Andrew Sorensen & Andrew R. Brown

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or any
later version.

This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.

*/
import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.util.*;

/**
 * A short example which generates a random melody and constrains 
 * it so that it only contain notes found in the C major scale.
 * Writes to a MIDI file called modeMelody.mid
 * @author Andrew Sorensen
 */
public final class ModeMelody implements JMC {
	public static void main(String[] args){
		Score modeScore = new Score("Mode Melody");
		Part inst = new Part("Guitar", SGUITAR, 0);
		Phrase phr = new Phrase(); 
		int temp; //variable to store random number
		int[] mode = {0,2,4,5,7,9,11,12}; //C major scale degrees
		
		// create a phrase of 32 randomly pitched quavers within C major.
		for(short i=0;i<32;){
			// generate a random number between 30 and 85 (avoids excessively high and low notes).
			temp = (int)(Math.random()*55 + 30);
			//check that it is a note in the mode (C major scale)
			for (short j=0; j< mode.length; j++) {
				if ( temp%12 == mode[j]) {
					// if it is then add it to the phrase and move to the next note in the phrase
					Note note = new Note(temp, Q);
					phr.addNote(note);
					i++; // only move onto the next note when a valid pitch is found.
				}
			}
		}
		
		// add the phrase to an instrument and that to a score
		inst.addPhrase(phr);
		modeScore.addPart(inst);
		
		// create a MIDI file of the score
		Write.midi(modeScore, "modeMelody.mid");
	}
}