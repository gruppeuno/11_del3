package Test;

import Game.PlayerController;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PlayerControllerTest {

    @Test
    public void PlayerNameTest() {
        PlayerController PNT = new PlayerController();


    }

    @Test
    public void NumberOfPlayerTest() {
        PlayerControllerTest NPT = new PlayerControllerTest();
        assertTrue(2 <= NPT.numberOfPlayers() && NPT.numberOfPlayers()<= 8);
    }

    public int numberOfPlayers(){
        int numberOfPlayers;

        //While loop til at sikre at der er indtastet mellem 2-8 spillere
        System.out.println("Indtast et antal spillere mellem 2-8");
        final int MAX = 8;
        final int MIN = 2;
        do{
            numberOfPlayers = (int)(Math.random() * 8) + 1;

            if (numberOfPlayers< MIN || numberOfPlayers> MAX)
                System.out.println("Ugyldigt antal spillere. Indtast et antal spillere mellem 2-8");
        }while (numberOfPlayers< MIN || numberOfPlayers> MAX);
        System.out.println("numberOfPlayers " + numberOfPlayers);
        System.out.println();

        return numberOfPlayers;
    }
}