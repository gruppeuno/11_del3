package Game.Fields;

import Game.Fields.Field;
import Game.Player;
import Game.PlayerController;

public class Jail extends Field {
    public Jail(String name, int fieldNumber,String msg){
        super(name, fieldNumber, msg);
    }

    @Override
    public void fieldAction(Player player, PlayerController playerController) {
        player.setFieldNumber(6);
    }
}
