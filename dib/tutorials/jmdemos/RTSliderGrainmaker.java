import jm.JMC;
import jm.music.data.*;
import jm.audio.*;
import jm.audio.synth.Granulator;
import jm.util.*;
import jm.audio.RTMixer;
import jm.music.rt.RTLine;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

/**
 * Real-time Granulator sample
 * Made using JSliders.
 *
 * A more complex version of this instrument has been written using
 * MIDI control. It was used for the Poseidon - a Granular Texture Controlling Fish -
 * in the REV concert at the Brisbane Powerhouse. More information on this, and on
 * Granular Synthesis can be obtained at: http://zor.org/synthesis
 *
 * This file is used in conjunction with RTSliderGrainLine  
 *
 * Author: Timothy Opie
 * Latest Update: 24/06/2002
 * Designed to function with jMusic designed by
 * Andrew Sorensen and Andrew R. Brown
 */


public final class RTSliderGrainmaker implements JMC,ChangeListener,ActionListener {
    private RTMixer mixer;
    private RTSliderGrainLine grain;
    private JSlider duration, density, volume;
    private JToggleButton asyn;
    private int sampleRate = 44100;
    
    public static void main(String[] args){
        new RTSliderGrainmaker();
    }
    
    private GranularInst rtGranularInst;
    
    public RTSliderGrainmaker(){
        
        int channels = 2;
        double controlRate = 0.25;
        int bufferSize = (int)((sampleRate*channels) *controlRate);
        
        Instrument[] instArray = new Instrument[1];
        for(int i=0;i<instArray.length;i++){
            instArray[i] = new GranularInst("song1.au",bufferSize);
        }
        rtGranularInst = (GranularInst) instArray[0];
        grain = new RTSliderGrainLine(instArray, controlRate, bufferSize);
        RTLine[] lineArray = {grain};
        mixer = new RTMixer(lineArray, bufferSize, sampleRate, channels, controlRate);
        mixer.begin();
        makeGUI();
    }
    private void makeGUI(){
        JFrame f = new JFrame("Granular Synthesis");
        f.setSize(370, 180);
        JPanel pan = new JPanel();
        f.getContentPane().add(pan);
        //grainduration
        duration = new JSlider(0,10,60,30);
        duration.addChangeListener(this);
        pan.add(duration);
        JLabel val=new JLabel("Grain Duration");
        pan.add(val);
        
        // Grain Density
        density = new JSlider(0,5,120,60);
        density.addChangeListener(this);
        pan.add(density);
        JLabel val2=new JLabel("Grains per second");
        pan.add(val2);
        
        // Grain Volume
        volume = new JSlider(0,0,20,10);
        volume.addChangeListener(this);
        pan.add(volume);
        JLabel val3=new JLabel("Grain Volume");
        pan.add(val3);
        
        asyn = new JToggleButton("A/Syncronicity toggle");
        asyn.addActionListener(this);
        pan.add(asyn);
        
        f.setVisible(true);
    }
    
    public void stateChanged(ChangeEvent e){
        if(e.getSource() == duration) {
            mixer.actionLines(duration, 1);
        }
        if(e.getSource() == density) {
            mixer.actionLines(density, 2);
        }
        if(e.getSource() == volume) {
            mixer.actionLines(volume, 3);
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == asyn){
            mixer.actionLines(asyn, 4);
        }
    }
}

