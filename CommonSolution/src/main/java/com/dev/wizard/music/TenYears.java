package com.dev.wizard.music;


import org.jfugue.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TenYears {
    public static void main(String[] args) throws IOException, InvalidMidiDataException {
        Player player = new Player();
        String str = "T124 V0 I[piano] Rwwwh. Ab5i Bb5i C6q C6q Bb5q C6q Bb5i Ab5i G5i F5q. C5i F5i Eb5q. F5i G5q F5i Eb5i F5h Ab5i G5i F5i G5i F5wq. C5i Ab5i G5i F5i G5i F5w. " +
                "Rq Ab5i Bb5i C6q C6q Bb5q C6q Bb5i C6i Eb6i Ab5h C6i Bb5q Bb5q Bb5i Ab5i G5i Ab5h " +
                "Ab5i Ab5i G5i F5i G5i Ab5i F5hh. C5i G5i G5i F5i Eb5i F5q G5i F5iw. " +
                "Rq. Eb5i C6q Bb5i Ab5i Bb5q C6i Bb5q Eb5q. Ri Ab5i F5i G5i Ab5i F6i Eb6i Ab5i C6h " +
                "Ri C6i Bb5i C6i Db6w Bb5q. C6q. Db6q C6w " +
                "Rq. Ab5i Bb5i Eb6q C6h C6q Db6i Eb6i F6i Bb5q. Bb5q Db6i C6i Bb5i Ab5q. C5q Bb5i Ab5i G5i G5q F5q. " +
                "G5i G5i F5i G5q Db6i C6i Bb5q G5i Ab5ih Ab5i Ab5i Bb5i C6i F6q. C6i Db6q Eb6i C6q Bb5q " +
                "Ab5i Bb5i Eb6q C6h C6q Db6i Eb6i F6i Bb5q. Bb5q Db6i C6i Bb5i Ab5q. C5q Bb5i Ab5i G5i G5q F5q. " +
                "G5i G5i F5i G5q Db6i C6i Bb5q C6i Bb5q Ab5h Ab5i Bb5i C6i F6q. Eb6i C6q Ab5i Bb5ih. Ab5q Ab5w. Rh Ab6ww+Eb6ww+C6ww";

        player.play(str);
    }
}
