package businessPack.Pieces.Default;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class DefaultPeon implements ItypePiece {
    //metodos>>
    Table tab;
    ArrayList<Block> freeWay;
    Player player;
    int sentido;
    
    public DefaultPeon(Player player){
        this.player = player;
        sentido = player.getSentido();
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        freeWay = new ArrayList<>();
        tab = table;
        if(Table.isInside(vetor.getX(), vetor.getY() - sentido)){
            if(table.getBlock(vetor.getX(), vetor.getY() - sentido).getBlockState(player) == BlockState.Empty){
                freeWay.add(table.getBlock(vetor.getX(), vetor.getY() - sentido));
            }
        }
        if(Table.isInside(vetor.getX() - sentido, vetor.getY() - sentido)){
            if(table.getBlock(vetor.getX() - sentido, vetor.getY() - sentido).getBlockState(player) == BlockState.Enemy){
                freeWay.add(table.getBlock(vetor.getX() - sentido, vetor.getY() - sentido));
            }
        }
        if(Table.isInside(vetor.getX() + sentido, vetor.getY() - sentido)){
            if(table.getBlock(vetor.getX() + sentido, vetor.getY() - sentido).getBlockState(player) == BlockState.Enemy){
                freeWay.add(table.getBlock(vetor.getX() + sentido, vetor.getY() - sentido));
            }
        }
        return freeWay;
    }
}