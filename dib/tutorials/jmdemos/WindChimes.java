import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.util.Write;

/**
 * A short example which usess randomness to sound like wind chimes
 * @author Andrew R. Brown
 */
public final class WindChimes implements JMC{
	public static void main(String[] args){
		Score score = new Score("JMDemo - Wind Chimes");
		Part one = new Part("Chimes", BELLS, 0);
		Phrase phr1 = new Phrase(0.0); 
		Phrase phr2 = new Phrase(1.0); 
		Phrase phr3 = new Phrase(3.0); 
		Phrase phr4 = new Phrase(5.0); 
		
		// create a phrase of random durations up to a semibreve in length.
		for(int i=0;i<24;i++){
			Note note1 = new Note(c6, Math.random()*8, (int)(Math.random()*80 + 20));
			phr1.addNote(note1);
			Note note2 = new Note(f6, Math.random()*8, (int)(Math.random()*80 + 20));
			phr2.addNote(note2);
			Note note3 = new Note(g5, Math.random()*8, (int)(Math.random()*80 + 20));
			phr3.addNote(note3);
			Note note4 = new Note(d7, Math.random()*8, (int)(Math.random()*80 + 20));
			phr4.addNote(note4);
		}
		
		// add the phrase to a part
		one.addPhrase(phr1);
		one.addPhrase(phr2);
		one.addPhrase(phr3);
		one.addPhrase(phr4);
		
		// add part to the score
		score.addPart(one);
		
		// create a MIDI file of the score
		Write.midi(score, "WindChimes.mid");
	}
}