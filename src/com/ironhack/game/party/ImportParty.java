package com.ironhack.game.party;

import com.ironhack.game.character.Warrior;
import com.ironhack.game.character.Wizard;
import com.ironhack.game.play.Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class ImportParty {

    public static void create(Player player) throws FileNotFoundException {

        Scanner scannerCSV = new Scanner(new File("src/com/ironhack/game/party/ImportFile.txt"));
        scannerCSV.useDelimiter(",");
        while (scannerCSV.hasNext()) {
            String type = scannerCSV.next().trim();
            String name = scannerCSV.next().trim();
            int HP = Integer.parseInt(scannerCSV.next().trim());
            int resource = Integer.parseInt(scannerCSV.next().trim());
            int attack = Integer.parseInt(scannerCSV.next().trim());
            updateCounter();

            if (type.equals("Warrior")) {
                Warrior warrior = new Warrior(name, HP, resource, attack);
                player.addCharacter(warrior);
            } else if (type.equals("Wizard")) {
                Wizard wizard = new Wizard(name, HP, resource, attack);
                player.addCharacter(wizard);
            }
        }
        scannerCSV.close();
    }
}
