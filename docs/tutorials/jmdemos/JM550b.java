import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;
import qt.*; 
import java.awt.*;
import java.awt.event.*;


public class JM550b extends Frame implements JMC, ActionListener {
    private static Button start, stop;
    private static QTCycle player;
    private static EightBeat1 pat;
    
    public static void main(String[] args) {
        new JM550b();
        // pattern
        pat = new EightBeat1();
        pat.playback();
    }
    
    public JM550b() {
        super("JM-550 Drum Machine");
        
        // create transport panel
        Panel transport = new Panel();
        
        start = new Button("Start");
        start.addActionListener(this);
        transport.add(start);
        
        stop = new Button("Stop");
        stop.addActionListener(this);
        transport.add(stop);
        
        this.add(transport);
      
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == start) 
	     	if (!Play.cycleIsPlaying()) pat.playback();
      if (ae.getSource() == stop) pat.stopPlayback();

    }
}
