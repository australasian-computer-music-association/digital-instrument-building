/**
 * Real-time Granulator Line
 * Author: Timothy Opie
 * Latest Update: 24/06/2002
 * Designed to function with jMusic designed by
 * Andrew Sorensen and Andrew R. Brown
 */

import jm.music.rt.RTLine;
import jm.audio.Instrument;
import jm.music.data.Note;
import javax.swing.*;

public class RTSliderGrainLine extends RTLine {
    private Note n = new Note(72, 1000.0); // 50 was 500,000 too large for mic :(
    private int pitch = 72;
    private int dynamic = 100;
    private GranularInst[] inst;
    private boolean asyn = false;
    
    // Constructor
    public RTSliderGrainLine(Instrument[] instArray, double controlRate, int bufferSize) {
        super(instArray, controlRate, bufferSize);
        inst = new GranularInst[instArray.length];
        for (int i=0; i<instArray.length; i++) {
            inst[i] = (GranularInst)instArray[i];
        }
    }
    
    public synchronized Note getNote(){
        n.setPitch(pitch);
        n.setDynamic(dynamic);
        //n.setDuration(n.getRhythmValue());
        return n;
    }
    
    // added for control change
    
    public synchronized void externalAction(Object obj, int actionNumber){
        
        if(actionNumber == 1){ // grain duration
            JSlider slider = (JSlider)obj;
            int duration = (slider.getValue()* (44100/1000));
            // propgate to all instruments
            for(int i=0;i<inst.length;i++){
                inst[i].setGrainDuration(duration);
            }
        }
        
        if(actionNumber == 2){ // Grain Density
            JSlider slider = (JSlider)obj;
            int length = slider.getValue();
            // propgate to all instruments
            for(int i=0;i<inst.length;i++){
                inst[i].setGrainsPerSecond(length);
            }
        }
        
        if(actionNumber == 3){ // Grain Volume
            JSlider slider = (JSlider)obj;
            float vol = (float)slider.getValue();
            // propgate to all instruments
            for(int i=0;i<inst.length;i++){
                inst[i].setVolume(vol);
            }
        }
        if(actionNumber == 4){ //toggle A/Syncronicity
            if(asyn == true) asyn=false;
            else asyn=true;
            for(int i=0;i<inst.length;i++){
                inst[i].setRandomIndex(asyn);
            }
        }
    }
}
