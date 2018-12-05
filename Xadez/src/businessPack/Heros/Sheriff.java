package businessPack.Heros;

import businessPack.Army;
import businessPack.Hero;
import businessPack.Pieces.*;
import businessPack.Players;
import businessPack.Table;
import businessPack.TypeHero;
import extras.Who;
import javafx.scene.image.Image;

public class Sheriff extends Hero {
    //atributos>>
    public static String description = "Este é O Sheriff, mantedor da paz na deserta cidade de Lawlesstown e "
                                     + "melhor gunslinger das redondezas. Boatos pela cidade "
                                     + "falam que nenhum forasteiro foi capaz de vencer "
                                     + "o Sheriff num duelo, pois não há ninguém mais rápido no gatilho... "
                                     + "Se tem uma coisa que se pode ter certeza nessa vida, é que O Sheriff "
                                     + "sempre atira primeiro...";
    public static String skills = ".peças armadas e aptas atiram imediatamente antes de serem atingidas\n"
                                + ".estão aptas a atirar a partir do momento em que seu cartucho enche\n"
                                + "  *(só começam a atirar quando o cartucho enche)\n"
                                + ".estão inaptas a atirar a partir do momento em que seu cartucho esvazia\n"
                                + "  *(só começam a recarregar quando o cartucho esvazia)\n"
                                + ".recarregam 1 bala quando são atingidos\n"
                                + ".não atiram se não houver alvo\n"
                                + ".causam dano com seu tiro de acordo com a quantidade de balas que havia no cartucho\n\n"
                                + "Peão:\n"
                                + " *max.cartucho: 1 bala\n"
                                + "   - atira na primeira peça à sua frente\n\n"
                                + "Farwell:\n"
                                + " *max.cartucho: 1 bala\n"
                                + "   - atira na primeira peça ao Leste e na primeira peça ao Oeste\n"
                                + "     *(gasta apenas 1 bala, mesmo se houver alvo nos dois lados)\n\n"
                                + "Torre:\n"
                                + " *max.cartucho: 1 bala\n"
                                + "   - permite atirar na última peça ao Norte, Sul, Leste ou Oeste\n"
                                + "   - as opções são dadas, cabendo ao jogador escolher a peça a ser atingida\n\n"
                                + "Rei:\n"
                                + " *max.cartucho: 2 balas\n"
                                + "   - atira na peça que o atingirá, ou que atingirá a Rainha\n";
    public static String movimentos = "Farwell:\n"
                                    + "   - Montaria do Sheriff\n"
                                    + "   - além do movimento padrão do Cavalo, pode andar 3 casas ao Norte, Sul, Leste ou Oeste";
    //construtor>>
    public Sheriff(){
        image = new Image(path + "animSheriff.gif", widthImg, heightImg, false, false);
        tpHero = TypeHero.sheriff;
    }
    //metodos>>
    @Override
    public void createArmy(Army army, int sentido, Who player){
        this.player = Players.getPlayer(player);
        for(int i = 0; i < 8; i++){
            if(i == 1 || i == 6)
                army.addPiece(new Peon(player, TypeHero.sheriff, i, (int)(3.5 + sentido*3.5)));//peões
            else
                army.addPiece(new Peon(player, TypeHero.sheriff, i, (int)(3.5 + sentido*2.5)));//peões
        }
        army.addPiece(new Bishop(player, TypeHero.sheriff, 2, (int)(3.5 + sentido*3.5)));//bispo
        army.addPiece(new Bishop(player, TypeHero.sheriff, 5, (int)(3.5 + sentido*3.5)));
        army.addPiece(new  Horse(player, TypeHero.sheriff, 1, (int)(3.5 + sentido*2.5)));//cavalo
        army.addPiece(new  Horse(player, TypeHero.sheriff, 6, (int)(3.5 + sentido*2.5)));
        army.addPiece(new  Tower(player, TypeHero.sheriff, 0, (int)(3.5 + sentido*3.5)));//torre
        army.addPiece(new  Tower(player, TypeHero.sheriff, 7, (int)(3.5 + sentido*3.5)));
        army.addPiece(new   King(player, TypeHero.sheriff, 4, (int)(3.5 + sentido*3.5)));//rei
        army.addPiece(new  Queen(player, TypeHero.sheriff, 3, (int)(3.5 + sentido*3.5)));//rainha
    }
    @Override
    public void GameManager(Table tab){ }
}