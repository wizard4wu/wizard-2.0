package com.dev.wizard.music;

import org.jfugue.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class QiFengLeDemo {
    public static void main(String[] args) throws IOException, InvalidMidiDataException {

        Player player = new Player();
       // player.play(new URL("https://www.aigei.com/s?q=%E8%B5%B7%E9%A3%8E%E4%BA%86&type=midi"));

//        Pattern pattern = player.loadMidi(new File("C:\\Users\\wizard\\Desktop\\起风了2.mid"));
//        player.play(pattern);
    }
}
