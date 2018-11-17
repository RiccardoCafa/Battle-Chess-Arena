package businessPack;

import extras.Who;

public class Players {
    //atributos>>
    static Player player1;
    static Player player2;
    //construtor>>
    public Players(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    //metodos>>
    public static Player getPlayer(Who player){
        if(player1.getWho() == player) return player1;
        else return player2;
    }
    //getset>>
    public static void setPlayer1(Player player){
        player1 = player;
    }
    public static void setPlayer2(Player player){
        player2 = player;
    }
}