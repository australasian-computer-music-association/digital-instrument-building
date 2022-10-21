import jm.JMC;
import jm.music.data.*;
import jm.util.View;
import jm.util.Write;
import jm.audio.Instrument;

public final class SineTest implements JMC{
	public static void main(String[] args){
		Score s = new Score();
		s.setTempo(60);
		Part p = new Part("Sine", 0);
                
		//create the phrase note by note
		/*
                 for(int i=0; i<50;i++) {
                    Note n = new Note((int)(Math.random() * 80 + 20),
                                    SEMIBREVE, (int)(Math.random() * 100 + 20));
                    n.setPan(Math.random());
                    Phrase phr = new Phrase(n, Math.random() * 30.0);
                    p.addPhrase(phr);
		}
                 */
                
                for(int i=0; i<20;i++) {
                    Note n = new Note(Math.random() * 1000 + 1000 , 4.0);
                    n.setPan(Math.random());
                    Phrase phrase2  = new Phrase(n, Math.random() * 10);
                    p.addPhrase(phrase2);
                }
                
		s.addPart(p);

		Instrument inst = new SineInst(22000);
		Write.au(s,"SineTest.au", inst);

                View.print(s);
	}
}
