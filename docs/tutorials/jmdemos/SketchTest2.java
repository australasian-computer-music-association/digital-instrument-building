import jm.music.data.*;
import jm.JMC;
import jm.util.View;

//@author Andrew R. Brown

public class SketchTest2 implements JMC {
    public static void main(String[] args) {
        Score s = new Score("Sketch test 2");
        // make four parts
        for(int i=0;i<4;i++) {
            Part p = new Part("Part "+i, FLUTE + i, i);
            Phrase phr = makePhrase(50 + i*5);
            p.addPhrase(phr);
            s.addPart(p);
        }
        // display the phrase
        View.sketch(s);
    }

    // keep the random walk code as a  separate method so it can be reused by each part
    private static Phrase makePhrase(int pitch) {
        Phrase tempPhrase = new Phrase();
        for(int i = 0; i< 50; i++) {
	         Note n = new Note(pitch, DSQ * (int)(Math.random()*8 + 1));
	         tempPhrase.addNote(n);
	         pitch += (int)(Math.random()*20 - 10);
	         // constrain the pitch range
	         if(pitch < 36 || pitch > 90) pitch = 60;
        }  
         return tempPhrase;
     }
} 
