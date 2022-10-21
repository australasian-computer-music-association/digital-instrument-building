import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.util.*;
 
public final class VibratoTest implements JMC{
    public static void main(String[] args){
        Score score = new Score("JMDemo - Audio test");
        Part part = new Part("wave", 0); 
        Phrase phr = new Phrase(0.0);
        int sampleRate = 44100;
        Instrument inst = new VibratoInst(sampleRate);
        
        for(int i = 0; i < 4; i++) {
            Note note = new Note(C2 + i * 2, 0.5, (int)(Math.random() * 40 + 80)); 
            phr.addNote(note);
        }
        Note note = new Note(C5, 2.0); 
        phr.addNote(note);
 
        part.addPhrase(phr);
        score.addPart(part);
        Write.au(score, "VibratoTest.au", inst); 
    }
}