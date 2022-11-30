package com.dev.wizard.music;



import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CangHaiYiShengXiao {
    public static void main(String[] args) throws IOException, InvalidMidiDataException {
        Player player = new Player();
        player.getMidiParserListener();

       // Pattern pattern = player.loadMidi(new File("C:\\Users\\wizard\\Desktop\\沧海一声笑-任贤齐.mid"));
       // String s = pattern.getMusicString();
        //System.out.println(pattern.getMusicString());
       // player.play(s);
    }
}
