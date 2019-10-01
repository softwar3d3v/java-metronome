import java.util.logging.Level;
import java.util.logging.logger;
import javax.sound.midi.*;

public class Metronome implements MetaEventListener {
	private Sequencer sequencer;
	private int bpm;
	public void start(int bpm) {
		try {
			this.bpm = bpm;
			openSequencer();
			Sequencer seq = createSequence();
			startSequence(seq);
		}
		catch(InvalidMidiDataException | MidiUnavailableException ex) {
			Logger.getLogger(Metronome)
		}
	}
}