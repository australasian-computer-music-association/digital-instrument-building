import java.awt.*;import java.awt.event.*;import jm.JMC;import jm.music.data.*;import jm.util.*;import javax.swing.*;public class SimpleGUI5 extends JFrame implements ActionListener, JMC{    // declare the button as a class variable    // so that any method in the class can access it.    private JButton composeBtn;    // keep track of the number of button presses    private int musicNumber = 0;        ////////////////    // simple main method called when the class in run    ///////////////    public static void main(String[] args) {            new SimpleGUI5();    }        ////////////    // constructor    ////////////    public SimpleGUI5() {            //give the window a name            super("A simple GUI interface for jMusic");                        //add the button            composeBtn = new JButton("Compose");            composeBtn.addActionListener(this);            composeBtn.setActionCommand("Create");            this.getContentPane().add(composeBtn);                        //display the window            this.pack();							            this.setVisible(true);    }        ////////////    // Deal with the button click    ////////////    public void actionPerformed(ActionEvent ae){        if (ae.getSource() == composeBtn) makeMusic();        //update the counter of button presses        musicNumber++;        System.out.println("The button has been pressed " + musicNumber +                            " times");    }        /////////////    // The code that creates the jMusic score    // and writes it as MIDI file.    //////////////    public void makeMusic() {            Score scale = new Score("JMDemo - SimpleGUI");            Part inst = new Part("Piano", 1, 0);            Phrase phr = new Phrase(0.0);                         for(int i=0;i<12;i++){                    Note note = new Note((int)((Math.random()*20)+50),                                                 CROTCHET);                    phr.addNote(note);            }            inst.addPhrase(phr);            scale.addPart(inst);            //save file to disk            Write.midi(scale, "SimpleGUI.jm");        }}