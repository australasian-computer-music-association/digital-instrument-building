import jm.audio.RTMixer;
import jm.audio.Instrument;
import jm.music.rt.RTLine;
import jm.JMC;

public class RTTest implements JMC{
	public static void main(String[] args){
		int sampleRate = 44100;
		int channels = 1;
		double controlRate = 0.1;		
		int bufferSize = (int)((sampleRate*channels)*controlRate);	
		System.out.println("Buffer Size: "+bufferSize);

		Instrument inst = new RTPluckInst(sampleRate);

                Instrument[] insts = new Instrument[] {inst};
                RTLine[] rtlines = {new RealtimeMelody(insts, controlRate, 
                                    bufferSize)};
					
		final RTMixer rtm = new RTMixer(rtlines, bufferSize,
                                  sampleRate, channels, controlRate);
		rtm.begin();
	}
		
}
