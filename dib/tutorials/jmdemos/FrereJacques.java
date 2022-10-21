import             jm.JMC;
import jm.music.tools.Mod;
import        jm.util.Write;
import  jm.music.data.*;

public final class FrereJacques implements JMC 
{
    private FrereJacques() 
    {   
    }
    
    public static final void main(final String[] args) 
    {
            Part part = new Part(leader);
            
            Phrase voice2 = leader.copy();
            Phrase voice3 = leader.copy();
            Phrase voice4 = leader.copy();
            part.addPhrase(voice2);
            part.addPhrase(voice3);
            part.addPhrase(voice4);
            voice2.attemptAnchoringTo(leader, START_TOGETHER, 2 * BAR);
            voice3.attemptAnchoringTo(voice2, START_TOGETHER, 2 * BAR);
            voice4.attemptAnchoringTo(voice3, START_TOGETHER, 2 * BAR);

            Score score = new Score(part);
            score.setTempo(ALLEGRO);
            Write.midi(score, "frere-jacques.mid");
    }
    
    private static final double BEAT    = CROTCHET;
    
    private static final double BAR     = 4 * BEAT;
    
    private static final double ALLEGRO = 110.0;
    
    private static final Phrase leader = new Phrase(0 * BEAT, PIANO);
    static {
            // Frere Jacques,
            for (int i = 0; i < 2; i++) {
                    leader.addNote(articulatedNote(G4, CROTCHET, LEGATO));
                    leader.addNote(articulatedNote(A4, CROTCHET, LEGATO));
                    leader.addNote(articulatedNote(B4, CROTCHET, LEGATO));
                    leader.addNote((i == 0) 
                                   ? articulatedNote(G4, CROTCHET, LEGATO)
                                   : new Note(G4, CROTCHET));
            }
            // Dormez-vous?
            for (int i = 0; i < 2; i++) {
                    leader.addNote(articulatedNote(B4, CROTCHET, LEGATO));
                    leader.addNote(articulatedNote(C5, CROTCHET, LEGATO));
                    leader.addNote(new Note(D5, MINIM));
            }       
            // Sonnez les matines,
            for (int i = 0; i < 2; i++) {
                    leader.addNote(articulatedNote(D5, DOTTED_QUAVER, LEGATO));
                    leader.addNote(articulatedNote(E5, SEMI_QUAVER, LEGATO));
                    leader.addNote(articulatedNote(D5, QUAVER, LEGATO));
                    leader.addNote(articulatedNote(C5, QUAVER, LEGATO));
                    leader.addNote(articulatedNote(B4, CROTCHET, LEGATO));
                    leader.addNote((i ==0) 
                                   ? articulatedNote(G4, CROTCHET, LEGATO)
                                   : new Note(G4, CROTCHET));
            }              
            // Ding! Deng! Dong!
            for (int i = 0; i < 2; i++) {
                    leader.addNote(articulatedNote(G4, CROTCHET, LEGATO));
                    leader.addNote(articulatedNote(D4, CROTCHET, LEGATO));
                    leader.addNote(new Note(G4, MINIM));
            }   
            leader.setDynamic(P);
            Mod.crescendo(leader, 2 * BAR, (2 * BAR) + (2 *BEAT), P, MF);
            Mod.crescendo(leader, 3 * BAR, (3 * BAR) + (2 *BEAT), P, MF);
            Mod.diminuendo(leader, 4 * BAR, 5 * BAR, F, P);
            Mod.diminuendo(leader, 5 * BAR, 7 * BAR, F, P);
    }
    
    private static final Note articulatedNote(final int pitch, final double rv,
                                              final double articulation) 
    {
            Note note = new Note(pitch, rv);
            note.setDuration(rv * articulation);
            return note;
    }
}