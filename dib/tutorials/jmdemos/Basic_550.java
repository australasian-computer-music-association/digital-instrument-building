import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

/**
* This class is an outline for a drum class
* Being abstract it must be subclassed.
* It declares some useful protected objects for 
* making drum patterns in the subclasses.
* Subclasses should override the kckRhythmArray and 
* other rhythm arrays as required. Patterns starting
* with a rest should override the startTime
* @author Andrew R. Brown
*/

abstract class Basic_550 implements JMC {
	protected static Score drumScore = new Score("Drums", 130.0);
	protected static Part drums = new Part("Drum Part", 0, 9);
	static double barLength = 4.0;
	private static int scoreVolume = 100;
	private static int dynDeviation = 20;
	
	public Basic_550() {
	    drumScore.empty();
        drums.empty();
		makePattern();		
	}
	
	public void makePattern() {
        // add the part to the score
        drumScore.addPart(drums);
        drumScore.addPart(bassPartMaker());
	}
	
	public void changeDynamics() {
	    // change volume
	    //System.out.println("Change Dynamics to " + scoreVolume);
            if (scoreVolume < 0 || scoreVolume > 127) drums.setDynamic(scoreVolume);
            /*
                int tempDyn = 100;
                for (int i = 0; i < drums.size(); i++) {
                        for(int j = 0; j < drums.getPhrase(i).size(); j++) {
                                do {
                                tempDyn = (int)(Math.random() * dynDeviation + scoreVolume - dynDeviation/2);
                                } while (tempDyn < 0 || tempDyn > 127)
                                        drums.getPhrase(i).getNote(j).setDynamic(tempDyn);
                        }
                }
                */
        }
	
	public static void setBarLength(double newLength) {
	    barLength = newLength;
	}
	
	public static double getBarLength() {
	    return barLength;
	}
	
	public static Score getScore() {
	    return drumScore;
	}
	
	public static int getScoreVolume() {
	    return scoreVolume;
	}
	
	public static void setScoreVolume(int newVolume) {
	    if (newVolume > 1 && newVolume < 128) scoreVolume = newVolume;
	}
	
	public static int getDynDeviation() {
	    return dynDeviation;
	}
	
	public static void setDynDeviation(int newDeviationValue) {
	    if ( newDeviationValue> 1 && newDeviationValue< 128) dynDeviation = newDeviationValue;
	}
	
	//------------------------------
	// build the percussion phrases	
	//------------------------------
	
	// this method used by many others below
	private void makePhrase(int pitch, double[] rhythmArray, double startTime, int repeats) {
	    Phrase phrase = new Phrase(0.0);
	    if (startTime > 0.0) phrase.addNote(new Note(REST, startTime));
	    phrase.addNoteList(pitches(pitch, rhythmArray), rhythmArray);
	    if (repeats > 0) Mod.repeat(phrase, repeats);
	    drums.addPhrase(phrase);
	}
    
    // convert a single pitch into a pitch array of the 
	// length matching the rhythm array.
	private int[] pitches(int pitch, double[] rhythmArray) {
	    int[] pitchArray = new int[rhythmArray.length];
	    for (int i = 0; i < rhythmArray.length; i++) {
	        pitchArray[i] = pitch;
	    }
	    return pitchArray;
	}
	
    // kick	
	protected void kck(double[] rhythmArray) {
	    this.kck( rhythmArray, 0.0);
	}
	
	protected void kck(double[] rhythmArray, double startTime) {
	    this.kck( rhythmArray, startTime, 0);
	}
	
	protected void kck(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(C2, rhythmArray, startTime, repeats);
	}
	
	// snare
	protected void snr(double[] rhythmArray) {
	    this.snr(rhythmArray, 0.0);
	}
	
	protected void snr(double[] rhythmArray, double startTime) {
	    this.snr(rhythmArray, startTime, 0);
	}
	
	protected void snr(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(D2, rhythmArray, startTime, repeats);
	}
	
	// rim shot
	protected void side(double[] rhythmArray) {
	    this.side(rhythmArray, 0.0);
	}
	
	protected void side(double[] rhythmArray, double startTime) {
	    this.side(rhythmArray, startTime, 0);
	}
	
	protected void side(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(DS2, rhythmArray, startTime, repeats);
	}
	
	// closed hi hat
	protected void chh(double[] rhythmArray) {
	    this.chh(rhythmArray, 0.0);
	}
	
	protected void chh(double[] rhythmArray, double startTime) {
	    this.chh(rhythmArray, startTime, 0);
	}
	
	protected void chh(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(FS2, rhythmArray, startTime, repeats);
	}
	
	// open hi hat
	protected void ohh(double[] rhythmArray) {
	    this.ohh(rhythmArray, 0.0);
	}
	
	protected void ohh(double[] rhythmArray, double startTime) {
	    this.ohh(rhythmArray, startTime, 0);
	}
	
	protected void ohh(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(AS2, rhythmArray, startTime, repeats);
	}
	
	// Pedal hi hat
	protected void phh(double[] rhythmArray) {
	    this.phh(rhythmArray, 0.0);
	}
	
	protected void phh(double[] rhythmArray, double startTime) {
	    this.phh(rhythmArray, startTime, 0);
	}
	
	protected void phh(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(GS2, rhythmArray, startTime, repeats);
	}
	
	// Low tom
	protected void ltm(double[] rhythmArray) {
	    this.ltm(rhythmArray, 0.0);
	}
	
	protected void ltm(double[] rhythmArray, double startTime) {
	    this.ltm(rhythmArray, startTime, 0);
	}
	
	protected void ltm(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(F2, rhythmArray, startTime, repeats);
	}
	
	// mid tom
	protected void mtm(double[] rhythmArray) {
	    this.mtm(rhythmArray, 0.0);
	}
	
	protected void mtm(double[] rhythmArray, double startTime) {
	    this.mtm(rhythmArray, startTime, 0);
	}
	
	protected void mtm(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(A2, rhythmArray, startTime, repeats);
	}
	
	// hi tom
	protected void htm(double[] rhythmArray) {
	    this.htm(rhythmArray, 0.0);
	}
	
	protected void htm(double[] rhythmArray, double startTime) {
	    this.htm(rhythmArray, startTime, 0);
	}
	
	protected void htm(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(A2, rhythmArray, startTime, repeats);
	}
	
	// crash cymbal
	protected void crsh(double[] rhythmArray) {
	    this.crsh(rhythmArray, 0.0);
	}
	
	protected void crsh(double[] rhythmArray, double startTime) {
	    this.crsh(rhythmArray, startTime, 0);
	}
	
	protected void crsh(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(CS3, rhythmArray, startTime, repeats);
	}
	
	// ride cymbal
	protected void ride(double[] rhythmArray) {
	    this.ride(rhythmArray, 0.0);
	}
	
	protected void ride(double[] rhythmArray, double startTime) {
	    this.ride(rhythmArray, startTime, 0);
	}
	
	protected void ride(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(DS3, rhythmArray, startTime, repeats);
	}
	
	// cow bell
	protected void cowBell(double[] rhythmArray) {
	    this.ride(rhythmArray, 0.0);
	}
	
	protected void cowBell(double[] rhythmArray, double startTime) {
	    this.ride(rhythmArray, startTime, 0);
	}
	
	protected void cowBell(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(GS3, rhythmArray, startTime, repeats);
	}
	
	// Hand Clap
	protected void clap(double[] rhythmArray) {
	    this.clap(rhythmArray, 0.0);
	}
	
	protected void clap(double[] rhythmArray, double startTime) {
	    this.clap(rhythmArray, startTime, 0);
	}
	
	protected void clap(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(DS2, rhythmArray, startTime, repeats);
	}
	
	// cabasa
	protected void cabasa(double[] rhythmArray) {
	    this.cabasa(rhythmArray, 0.0);
	}
	
	protected void cabasa(double[] rhythmArray, double startTime) {
	    this.cabasa(rhythmArray, startTime, 0);
	}
	
	protected void cabasa(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(A4, rhythmArray, startTime, repeats);
	}
	
	// Tambourine
	protected void tambourine(double[] rhythmArray) {
	    this.tambourine(rhythmArray, 0.0);
	}
	
	protected void tambourine(double[] rhythmArray, double startTime) {
	    this.tambourine(rhythmArray, startTime, 0);
	}
	
	protected void tambourine(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(FS3, rhythmArray, startTime, repeats);
	}
	
	// HiQ
	protected void hiq(double[] rhythmArray) {
	    this.hiq(rhythmArray, 0.0);
	}
	
	protected void hiq(double[] rhythmArray, double startTime) {
	    this.hiq(rhythmArray, startTime, 0);
	}
	
	protected void hiq(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(G5, rhythmArray, startTime, repeats);
	}
	
	// Bongo Low
	protected void bongoLow(double[] rhythmArray) {
	    this.bongoLow(rhythmArray, 0.0);
	}
	
	protected void bongoLow(double[] rhythmArray, double startTime) {
	    this.bongoLow(rhythmArray, startTime, 0);
	}
	
	protected void bongoLow(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(CS4, rhythmArray, startTime, repeats);
	}
	
	// Bongo High
	protected void bongoHigh(double[] rhythmArray) {
	    this.bongoHigh(rhythmArray, 0.0);
	}
	
	protected void bongoHigh(double[] rhythmArray, double startTime) {
	    this.bongoHigh(rhythmArray, startTime, 0);
	}
	
	protected void bongoHigh(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(C4, rhythmArray, startTime, repeats);
	}
	
	// Agogo Low
	protected void agogoLow(double[] rhythmArray) {
	    this.agogoLow(rhythmArray, 0.0);
	}
	
	protected void agogoLow(double[] rhythmArray, double startTime) {
	    this.agogoLow(rhythmArray, startTime, 0);
	}
	
	protected void agogoLow(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(GS4, rhythmArray, startTime, repeats);
	}
	
	// Agogo High
	protected void agogoHigh(double[] rhythmArray) {
	    this.agogoHigh(rhythmArray, 0.0);
	}
	
	protected void agogoHigh(double[] rhythmArray, double startTime) {
	    this.agogoHigh(rhythmArray, startTime, 0);
	}
	
	protected void agogoHigh(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(G4, rhythmArray, startTime, repeats);
	}
	
	// Low Conga
	protected void congaLow(double[] rhythmArray) {
	    this.congaLow(rhythmArray, 0.0);
	}
	
	protected void congaLow(double[] rhythmArray, double startTime) {
	    this.congaLow(rhythmArray, startTime, 0);
	}
	
	protected void congaLow(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(E4, rhythmArray, startTime, repeats);
	}
	
	// Slap Conga
	protected void congaSlap(double[] rhythmArray) {
	    this.congaSlap(rhythmArray, 0.0);
	}
	
	protected void congaSlap(double[] rhythmArray, double startTime) {
	    this.congaSlap(rhythmArray, startTime, 0);
	}
	
	protected void congaSlap(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(D4, rhythmArray, startTime, repeats);
	}
	
	// High Conga
	protected void highConga(double[] rhythmArray) {
	    this.ride(rhythmArray, 0.0);
	}
	
	protected void highConga(double[] rhythmArray, double startTime) {
	    this.ride(rhythmArray, startTime, 0);
	}
	
	protected void highConga(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(DS4, rhythmArray, startTime, repeats);
	}
	
	// Clave
	protected void clave(double[] rhythmArray) {
	    this.clave(rhythmArray, 0.0);
	}
	
	protected void clave(double[] rhythmArray, double startTime) {
	    this.clave(rhythmArray, startTime, 0);
	}
	
	protected void clave(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(DS5, rhythmArray, startTime, repeats);
	}
	
	// Whistle
	protected void whistle(double[] rhythmArray) {
	    this.whistle(rhythmArray, 0.0);
	}
	
	protected void whistle(double[] rhythmArray, double startTime) {
	    this.whistle(rhythmArray, startTime, 0);
	}
	
	protected void whistle(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(C5, rhythmArray, startTime, repeats);
	}
	
	// Shaker - Maracas
	protected void shaker(double[] rhythmArray) {
	    this.shaker(rhythmArray, 0.0);
	}
	
	protected void shaker(double[] rhythmArray, double startTime) {
	    this.shaker(rhythmArray, startTime, 0);
	}
	
	protected void shaker(double[] rhythmArray, double startTime, int repeats) {
	    makePhrase(AS5, rhythmArray, startTime, repeats);
	}
	
	private Part bassPartMaker() {
	    int inst =  6; //(int)(Math.random() * 9) * 10 + 6;
	    int chan = 0; //(int)(Math.random() * 16);
	    //System.out.println("Channel = " + (chan + 1 )+ " Instrument = " + inst);
	    Part bassPart = new Part("Bass", inst , chan);
	    Phrase bassPhrase = new Phrase();
	    for(int i = 0; i< (int)(barLength *2); i++) {
	        Note n = new Note((int)(Math.random() * 12 + 36), QUAVER);
	        bassPhrase.addNote(n);
	    }
	    bassPart.addPhrase(bassPhrase);
	    return bassPart;
	}
}
