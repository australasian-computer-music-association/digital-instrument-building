import jm.music.data.*;
import jm.JMC;
import jm.util.View;

import java.awt.*;

public class HistogramTest implements JMC {

    public static void main(String[] args) {
        Phrase phr = new Phrase();
        for(int i=0; i<1000; ) {
            Note n = new Note((int)(Math.random() * 127) , (int)(Math.random() * 20) * 0.25, (int)(Math.random() * 127));
            n.setPan(Math.random());
            if (n.isScale(MAJOR_SCALE)) {
                phr.addNote(n);
                i++;
            }
        }
        Score s = new Score (new Part(phr));
        
        View.histogram(s);
        
        View.histogram(s, RHYTHM, 40, 30);
        
        View.histogram(s, DYNAMIC, 80, 60);
        
        View.histogram(s, PAN, 120, 90);
        
        View.histogram();
    }

}