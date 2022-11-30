package com.dev.wizard.music;


import org.jfugue.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicDemo {

    public static void main(String[] args) throws InvalidMidiDataException, IOException {
        Player player = new Player();

        Path path = Paths.get("C:\\Users\\wizard\\Desktop\\沧海一声笑-许冠杰.jfugue");
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
       String strs = lines.collect(Collectors.joining(System.lineSeparator()));

        //Pattern pattern = player.loadMidi(new File("C:\\Users\\wizard\\Desktop\\起风了0.mid"));
        String str = " @0 V0 A6/0.02857142857142857a112d0\n" +
                " @32 V0 G6/0.014285714285714285a112d0 \n" +
                " @48 V0 E6/0.02857142857142857a112d0 \n" +
                " @80 V0 D6/0.02857142857142857a112d0 \n" +
                " @112 V0 C6/0.11428571428571428a112d0 \n" +
                " @240 V0 E6/0.02857142857142857a112d0\n" +
                " @272 V0 D6/0.014285714285714285a112d0 \n" +
                " @288 V0 C6/0.02857142857142857a112d0\n" +
                " @320 V0 A5/0.02857142857142857a112d0 \n" +
                " @352 V0 G5/0.11428571428571428a112d0 \n" +
                " @480 V0 G5/0.02857142857142857a112d0\n" +
                " @512 V0 A5/0.014285714285714285a112d0 \n" +
                " @528 V0 G5/0.02857142857142857a112d0 \n" +
                " @560 V0 A5/0.014285714285714285a112d0 \n" +
                " @576 V0 C6/0.02857142857142857a112d0 \n" +
                " @608 V0 D6/0.014285714285714285a112d0\n" +
                " @624 V0 E6/0.02857142857142857a112d0 \n" +
                " @656 V0 G6/0.02857142857142857a112d0 \n" +
                " @688 V0 A6/0.02857142857142857a112d0 \n" +
                " @720 V0 G6/0.014285714285714285a112d0 \n" +
                " @736 V0 E6/0.014285714285714285a112d0\n" +
                " @752 V0 D6/0.014285714285714285a112d0 \n" +
                " @768 V0 C6/0.02857142857142857a112d0 \n" +
                " @800 V0 D6/0.11428571428571428a112d0";

        String a = " V0 @0 T308 V1 @0 V0 I[Piano] \n" +
                " @0 V0 F5/0.07792207792207792a50d0 \n" +
                " @0 V0 C5/0.15584415584415584a50d0\n" +
                " @96 V0 F#5/0.07792207792207792a50d0 \n" +
                " @192 V0 G5/0.07792207792207792a50d0 \n" +
                " @288 V0 C#5/0.07792207792207792a50d0 \n" +
                " @0 V0 C#5/0.3116883116883117a50d0 \n" +
                " @288 V0 G#5/0.15584415584415584a50d0\n" +
                " @480 V0 Eb5/0.07792207792207792a50d0 \n" +
                " @576 V0 C#6/0.07792207792207792a50d0 \n" +
                " @384 V0 D5/0.3116883116883117a50d0\n" +
                " @768 V0 Bb4/0.15584415584415584a50d0 \n" +
                " @960 V0 B4/0.15584415584415584a50d0\n" +
                " @672 V0 A5/0.7012987012987013a50d0 \n" +
                " @1152 V0 C#5/0.3116883116883117a50d0 \n" +
                " @1536 V0 Eb5/0.07792207792207792a50d0\n" +
                " @1632 V0 E5/0.07792207792207792a50d0 \n" +
                " @1536 V0 C5/0.15584415584415584a50d0\n" +
                " @1728 V0 F5/0.07792207792207792a50d0 \n" +
                " @1728 V0 G#4/0.15584415584415584a50d0 \n" +
                " @1824 V0 F#5/0.15584415584415584a50d0";
        player.play(a);
    }


}
