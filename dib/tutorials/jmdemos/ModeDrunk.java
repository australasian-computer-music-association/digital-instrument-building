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
 * A short example which generates a melody based on random walk (drunk) pitches
 * which are constrained to the C minor scale
 * Writes to a MIDI file called modeDrunk.mid
 * @author Andrew R. Brown
 */
public final class ModeDrunk implements JMC {
	public static void main(String[] args){
		Score modeScore = new Score("Drunk walk demo");
		Part inst = new Part("Bass", SYNTH_BASS, 0);
		Phrase phr = new Phrase(); 
		int pitch = C3; // variable to store the calculated pitch (initialized with a start pitch value)
		int offset;
						
		// create a phrase of 32 quavers following a random walk within C minor.
		for(short i=0;i<32;) {
		// next note within plus or minus a 5th.
			offset = 0;
			while(offset == 0) {
				offset = (int)((Math.random()*14) - 7); 
			}
			pitch += offset; // add the offset to the pitch to find the next pitch
			// check that it is a note in the mode using the isScale method.
			// several other scale constants are available in the JMC
			if (pitch>=0){
				Note note = new Note(pitch, Q);
				if(note.isScale(MINOR_SCALE)) {
					phr.addNote(note);
					i++;
				}
			}
		}
		
		// add the phrase to an instrument and that to a score
		inst.addPhrase(phr);
		modeScore.addPart(inst);
		
		// create a MIDI file of the score
		Write.midi(modeScore, "modeDrunk.mid");
	}
}