import jm.JMC;
import jm.music.data.*;
import jm.music.tools.Mod;
import qt.*;

/**
* This class provides a musical scores for any class that calls the makeMusic method.
*/

public class NewGameMusic implements JMC{
    private int tempo = 60;
    private int numberOfBars = 4;
    public NewGameMusic() {
    }

    /**
    * Create a score and return it to the calling class.
    */
    protected Score makeMusic() {
        Phrase phr = new Phrase();
        int pitch = 60;
        Note n = new Note(pitch , 0.25);
        for(int i=0; i<8; ) {
            while (!n.isScale(PENTATONIC_SCALE)) {
                pitch = 60 + (int)(Math.random() * 12);
                n.setPitch(pitch);
            }
            phr.addNote(n.copy());
            i++;
            pitch = 60 + (int)(Math.random() * 12);
            n.setPitch(pitch);
        }
        Mod.repeat(phr, numberOfBars);
        // select the instrument at random
        int inst = (int)(Math.random() * 50);
        Part p = new Part("music", inst, 0);
        p.addPhrase(phr);
        // increase the tempo each time
        Score score = new Score(tempo++);
        score.addPart(p);

        // add hats
        Phrase perc = new Phrase();
        for(int i=0; i<16; i++) {
            perc.addNote(new Note(69, DSQ, (int)(Math.random() * 30 + 80)));
        }
        Mod.repeat(perc, numberOfBars);
        Part drums = new Part("drums", 0, 9);
        drums.addPhrase(perc);
        score.addPart(drums);
        
        return score;
    }
}