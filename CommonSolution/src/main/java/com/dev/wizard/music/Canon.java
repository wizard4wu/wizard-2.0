package com.dev.wizard.music;


import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Canon {

public static void main(String[] args) throws IOException {
        InputStream fs = new FileInputStream("C:\\Users\\wizard\\Desktop\\沧海一声笑.txt");
        //Read notes from music file
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        ArrayList lines = new ArrayList();
        String line = null;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("#")) {
                lines.add(line.trim());
            }
        }
        br.close();

        // Create note pattern with tempo, key, and voice information
        Pattern p = new Pattern();
        int lastLineToAdd = lines.size();
        for (int y = 0; y < lastLineToAdd; y++) {
            p.add((String) lines.get(y));
        }

        Player player = new Player();
        player.play(p);

    }
}

