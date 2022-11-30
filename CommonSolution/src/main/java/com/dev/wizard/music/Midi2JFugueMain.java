package com.dev.wizard.music;


import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;

public class Midi2JFugueMain {

    public static void main(String[] args) {

        args = new String[3];
        args[0] = "11";
        args[1] = "C:\\Users\\wizard\\Desktop\\起风了0.mid";
        args[2] = "C:\\Users\\wizard\\Desktop\\起风了0.jfugue";

        Player player = new Player();
        Pattern pattern = null;

//        try {
//       //    pattern = player.loadMidi(new File(args[1]));
////            pattern.savePattern(new File(args[2]));
//        } catch (IOException var4) {
//            var4.printStackTrace();
//        } catch (InvalidMidiDataException var5) {
//            var5.printStackTrace();
//        }

        System.exit(0);
    }

    public static void printUsage() {
        System.out.println("Midi2JFugue - convert MIDI files to a JFugue MusicString pattern");
        System.out.println("Usage: Midi2JFugue <input-midi-filename> <output-pattern-filename>");
        System.out.println("Example: Midi2JFugue MySong.mid MyPattern.jfugue");
    }
}
