package Game.Controller;

import Game.Model.Player;

import java.util.Scanner;

/**
 * PlayerController
 *
 * @author Gruppe11
 */

public class PlayerController {

    private int numberOfPlayers;
    private Scanner scan = new Scanner(System.in);
    private Player[] playerArray;
    PlayerControllerMessageController playerControllerMessages = new PlayerControllerMessageController();

    /**
     * kører for-loop og scanner hver spillers
     * spørger nyt navn hvis checkPlayerNam() er true
     */
    public void playerCreator() {
        numberOfPlayers();
        createPlayers();
        setStartBalance();
        System.out.println(playerControllerMessages.number(1));
        for (int i = 0; i < playerArray.length; i++) {
            int nr = i + 1;
            System.out.println(playerControllerMessages.number(2) + " " + nr + " " + playerControllerMessages.number(3));
            String currentName = scan.next();

            while (checkPlayerName(currentName, playerArray)) {
                System.out.print(playerControllerMessages.number(4) + "\n" + playerControllerMessages.number(5));
                currentName = scan.next();
            }
            playerArray[i].setPlayerName(currentName.toUpperCase());
        }
        System.out.println(playerControllerMessages.number(6)+ "\n");
    }

    /**
     * Loop der indlæser antal spillere melle 2-6 og sørger for indtastningen er gyldig
     */

    public void numberOfPlayers() {
        final int MAX = 4;
        final int MIN = 2;
        //While loop til at sikre at der er indtastet mellem 2-4 spillere
        System.out.println(playerControllerMessages.number(7));
        do {
            while (!scan.hasNextInt()) {
                System.out.println(playerControllerMessages.number(8));
                scan.next();
            }
            numberOfPlayers = scan.nextInt();

            if (numberOfPlayers < MIN || numberOfPlayers > MAX)
                System.out.println(playerControllerMessages.number(9));
        } while (numberOfPlayers < MIN || numberOfPlayers > MAX);
        System.out.println(playerControllerMessages.number(10) + numberOfPlayers + "\n");
    }

    /**
     * opretter spillere i playerArray
     */

    public void createPlayers() {
        this.playerArray = new Player[numberOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArray[i] = new Player("p" + i);
        }
    }

    /**
     * Tjekker i for loop om spillerene har samme navn. Hvis de har samme navn returneres true
     * if-statement benyttes til at tjekke om det indtastede navn er mellem 3-12 bogstaver
     * returnerer true hvis navnet er over 12 bogstaver eller udner 3 bogstaver
     *
     * @param name
     * @param array
     * @return
     */

    public boolean checkPlayerName(String name, Player[] array) {
        //Kontrollerer om navnet allerede er brugt
        for (int i = 0; i < playerArray.length; i++) {
            if (playerArray[i].getPlayerName().toLowerCase().equals(name.toLowerCase()))
                return true;
        }
        if (name.length() > 12 || name.length() < 3)
            return true;
        return false;
    }

    public int getPlayerArrayLength() {
        return playerArray.length;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void movePlayer(Player player, int dieValue) {
        int newSpot = player.getFieldNumber() + dieValue;
        if (newSpot > 23) {
            newSpot = newSpot - 24;
            player.getBankAccount().addBalance(2);
        }
        player.setFieldNumber(newSpot);
    }

    public Player getPlayerByName(String name) {
        for (Player player : playerArray) {
            if (player.getPlayerName().equals(name))
                return player;
        }
        return null;
    }

    //TODO: testmetode, må ikke slettes, ellers stopper integrationstest og unittest med at virke
    public void createPlayers(int numberOfPlayers) {
        this.playerArray = new Player[numberOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArray[i] = new Player("p" + i);
        }
        setStartBalance();
    }

    public void setStartBalance() {
        if (playerArray.length == 2)
            for (int i = 0; i < 2; i++)
                playerArray[i].getBankAccount().setBalance(20);

        else if (playerArray.length == 3)
            for (int i = 0; i < 3; i++)
                playerArray[i].getBankAccount().setBalance(18);

        else if (playerArray.length == 4)
            for (int i = 0; i < 4; i++)
                playerArray[i].getBankAccount().setBalance(16);
    }

    //TODO kan nok slettes senere hvis vi ikke skal bruge
    public int getPlayerArrayNumber(String playerName) {
        for (int i = 0; i < playerArray.length; i++) {
            if (playerName.equals(playerArray[i].getPlayerName()))
                return i;
        }
        //TODO: det her?
        return 0;
    }

}




