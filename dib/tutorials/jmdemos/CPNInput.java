import jm.JMC;
import jm.music.data.*;
import jm.midi.*;
import jm.util.*;

/**
 * A common practice notation stave is presented to the user.
 * Notes can be added by clicking  and dragging on the stave
 * and listened to using the QT player.
 * Scores can be edited and saved as MIDI or jm files 
 * using items in the CPN menu.
 * @author Andrew R. Brown
 */
public class CPNInput implements JMC{
    private Score score = new Score();
    
    public static void main(String[] args){
        new CPNInput();
    }
    
    public CPNInput() {
        Part part = new Part();
        Phrase phrase = new Phrase();
        //Note n = new Note(60, 2.0, 120);
        //phrase.addNote(n);
        //part.addPhrase(phrase);
        //score.addPart(part);
        View.notate(phrase);
                
        Play.midi(score, false);
    }
}
