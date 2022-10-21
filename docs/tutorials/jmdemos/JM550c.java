import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;
import qt.*; 
import java.awt.*;
import java.awt.event.*;


public class JM550c extends Frame implements JMC, ActionListener, AdjustmentListener {
    private static Button start, stop;
    private static QTCycle player;
    private static Scrollbar tempoSlider, volumeSlider;
    private static Label tempoValue, volumeValue;
    private static Basic_550 pat;
    
    public static void main(String[] args) {
        new JM550c();
        // pattern
        pat = new EightBeat1();
    }
    
    public JM550c() {
        super("JM-550 Drum Machine");
        this.setSize(640, 465);
        // create transport panel
        Panel transport = new Panel();
        
        start = new Button("Play");
        start.addActionListener(this);
        transport.add(start);
        
        stop = new Button("Stop");
        stop.addActionListener(this);
        transport.add(stop);
        
        this.add(transport, "South");
        
        // Tempo panel
        Panel tempoPanel = new Panel();
        tempoPanel.setLayout(new BorderLayout());
       
        Label tempoLabel = new Label("Tempo", Label.CENTER);
        tempoPanel.add(tempoLabel, "North");

        // Scrollbar arguments - orientation, initial value, visuble amount, min, max
        tempoSlider = new Scrollbar(Scrollbar.VERTICAL, 250 - 130, 20, 0, 250);
        tempoSlider.addAdjustmentListener(this);
        tempoPanel.add("Center", tempoSlider);
        tempoValue = new Label("130", Label.CENTER);
        tempoPanel.add(tempoValue, "South");
        
        this.add(tempoPanel, "West");
        
        // volume sider
        // Tempo panel
        Panel volumePanel = new Panel();
        volumePanel.setLayout(new BorderLayout());
       
        Label volumeLabel = new Label("Volume", Label.CENTER);
        volumePanel.add(volumeLabel, "North");

        // Scrollbar arguments - orientation, initial value, visuble amount, min, max
        volumeSlider = new Scrollbar(Scrollbar.VERTICAL, 3, 1, 0, 10);
        volumeSlider.addAdjustmentListener(this);
        volumePanel.add("Center", volumeSlider);
        volumeValue = new Label("100", Label.CENTER);
        volumePanel.add(volumeValue, "South");
        
        this.add(volumePanel, "East");
      
        //this.pack();
        this.setVisible(true);
    }
    
    // deal with button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) 
        	if (!Play.cycleIsPlaying()) pat.playback();
        if (ae.getSource() == stop) pat.stopPlayback();
    }
    
    // deal with slider movements
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        // tempo
        if (ae.getSource() == tempoSlider) {
            int value = 250 - tempoSlider.getValue();
            tempoValue.setText(Integer.toString(value));
            pat.setTempo((double)value);
        }
        // volume
        if (ae.getSource() == volumeSlider) {
        		int value = 12 * (10 - volumeSlider.getValue());
            volumeValue.setText(Integer.toString(value));
            pat.setScoreVolume(value);
            pat.changeDynamics();
        }
    }
}
