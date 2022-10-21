import jm.JMC;import jm.music.data.*;import jm.util.*; /** * An example which generates two different * score arrangements from the same phrase material */	 public final class Form implements JMC{	public static void main(String[] args){		Score s = new Score();		Part p = new Part();				System.out.println("Starting part length is  "+p.getEndTime());				//create the first score form		p.addPhrase(makePhrase1());		p.addPhrase(makePhrase2());		s.addPart(p);						System.out.println("Form1 part length is  "+p.getEndTime());				// save the first form		Write.midi(s, "Form1.mid");				// reuse the same objects by deleting their contents		p.empty();	    s.empty();				//create the second score form		p.addPhrase(makePhrase2());		p.addPhrase(makePhrase1());		p.addPhrase(makePhrase2());		s.addPart(p);				System.out.println("Form2 part length is  "+p.getEndTime());				// save the second form		Write.midi(s, "Form2.mid");	}		private static Phrase makePhrase1() {		Phrase phrase = new Phrase();		for(short i=0;i<12;i++){			Note n = new Note(c5+i, Q);			phrase.addNote(n);		}		return phrase;	}		private static Phrase makePhrase2() {		Phrase phrase = new Phrase();		for(short i=12;i>0;i--){			Note n = new Note(c5+i, Q);			phrase.addNote(n);		}		return phrase;	}		}