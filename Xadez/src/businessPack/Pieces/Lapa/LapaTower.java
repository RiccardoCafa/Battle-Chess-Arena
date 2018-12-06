package businessPack.Pieces.Lapa;

import businessPack.Block;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;
import businessPack.Pieces.Interfaces.IMovement;


public class LapaTower implements IMovement {

    Player player;
    int casasOffSet;
    int count;
    Table table;
    ArrayList<Block> myMoves;
    
    public LapaTower(Player player) {
        this.player = player;
    }

    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor) {
        myMoves = new ArrayList<>();
        Vetor lastPosition;
        int xOffSet, yOffSet;
        this.table = table;
        
//        System.out.println("Starting at: " + vetor.getX() + " " + vetor.getY());
        
        // Checa em cima dele quantas casas estão livres
//        System.out.println("Going up");
        lastPosition = LookForLast(0, -1, vetor);
//        System.out.println("Last Position: " + lastPosition.getX() + " " + lastPosition.getY());
        // Calcula quantas casas sobram
                //xOffSet = Math.abs(lastPosition.getX() - vetor.getX());
        yOffSet = Math.abs(lastPosition.getY() - vetor.getY());
        // Pega todas as casas restantes
//        System.out.println("Looking for lefting blocks");
        TakeLeftingBlocks(0, -1, lastPosition, yOffSet);
        
//        System.out.println();
        
        // Checa em baixo dele
//        System.out.println("Going down");
        lastPosition = LookForLast(0, 1, vetor);
        // Calcula quantas casas sobram
        //xOffSet = Math.abs(lastPosition.getX() - vetor.getX());
        yOffSet = Math.abs(lastPosition.getY() - vetor.getY());
        // Pega todas as casas restantes
//        System.out.println("Looking for lefting blocks");
        TakeLeftingBlocks(0, 1, lastPosition, yOffSet);
        
//        System.out.println();
        
        // Checa na direita dele
//        System.out.println("Going right");
        lastPosition = LookForLast(1, 0, vetor);
        // Calcula quantas casas sobram
        xOffSet = Math.abs(lastPosition.getX() - vetor.getX());
            //yOffSet = Math.abs(lastPosition.getY() - vetor.getY());
        // Pega todas as casas restantes
//        System.out.println("Looking for lefting blocks");
        TakeLeftingBlocks(1, 0, lastPosition, xOffSet);
        
//        System.out.println();
        
        // Checa esquerda dele
//        System.out.println("Going left");
        lastPosition = LookForLast(-1, 0, vetor);
        // Calcula quantas casas sobram
        xOffSet = Math.abs(lastPosition.getX() - vetor.getX());
            //yOffSet = Math.abs(lastPosition.getY() - vetor.getY());
        // Pega todas as casas restantes
//        System.out.println("Looking for lefting blocks");
        TakeLeftingBlocks(-1, 0, lastPosition, xOffSet);
        
//        System.out.println();
        
        return myMoves;
    }
    
    public void TakeLeftingBlocks(int xDirection, int yDirection, Vetor lastPos, int offSet) {
        int lefting = 0;
        if(xDirection != 0) {
            while(lefting < offSet) {
                LookForLast(0, 1, lastPos, lefting); // Encontre em baixo, lefting blocks
                LookForLast(0, -1, lastPos, lefting); // Encontre em cima, lefting blocks
                lefting++; // Aumenta os lefting
                lastPos.setX(lastPos.getX() +( -1 * xDirection) ); // se mexa em direção x
            }
        } else if(yDirection != 0) {
            while(lefting < offSet) {
                LookForLast(1, 0, lastPos, lefting); // Encontre na direita, lefting blocks
                LookForLast(-1, 0, lastPos, lefting); // Encontre na esquerda, lefting blocks
                lefting++; // Aumenta os lefting
                lastPos.setY(lastPos.getY() +( -1 * yDirection)); // se mexa em direção y
                
            }
        }
    }
    
    public Vetor LookForLast(int xDirection, int yDirection, Vetor vetor, int num) {
        Vetor newVetor;
        int i = vetor.getX() + xDirection;
        int j = vetor.getY() + yDirection;
        newVetor = new Vetor(i, j); // Cria um novo vetor
        int xMax = xDirection == 1 ? Table.getM() - 1 : 0;
        int yMax = yDirection == 1 ? Table.getN() - 1 : 0;
        // Checo se o vetor está dentro do tabuleiro (pode fazer do seu jeito)
        // Checo também se num == 0
        // São condicoes de parada
        if(xDirection == 0) {
            if(((yMax == 0 && j < yMax) || (yMax == Table.getN()-1 && j > yMax)) || num == 0) {
                return vetor;
            }
        } else if(yDirection == 0) {
            if(((xMax == 0 && i < xMax) || (xMax == Table.getM()-1 && i > xMax)) || num == 0) {
                return vetor;
            }
        }
        
        // Checo se existe um inimigo na casa atual que estoua agora
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Enemy) {
            if(!myMoves.contains(table.getBlock(newVetor))) { // Se essa casa não está na lista
                myMoves.add(table.getBlock(newVetor)); // Add na lista
            }
            return newVetor; // C.P.
        }
        // Se for amigo, C.P.
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Friend) {
            return vetor;
        }
        // Se for vazio, 
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Empty) {
            // Se não tiver na lista
            if(!myMoves.contains(table.getBlock(newVetor))) {
                myMoves.add(table.getBlock(newVetor)); // Adiciona na lista
//                System.out.println("Adicionado bloco na posição: " + newVetor.getX() + " " + newVetor.getY());
            }
            if(num != 0) // Se num não for zero
                return LookForLast(xDirection, yDirection, newVetor, --num); // Chamada recursiva
            else return vetor; // num == 0 retorna C.P.
        }
        return newVetor;
    }
    
    public Vetor LookForLast(int xDirection, int yDirection, Vetor vetor) {
        Vetor newVetor;
        int i = vetor.getX() + xDirection;
        int j = vetor.getY() + yDirection;
        newVetor = new Vetor(i, j);
        int xMax = xDirection == 1 ? Table.getM() - 1 : 0;
        int yMax = yDirection == 1 ? Table.getN() - 1 : 0;
        if(xDirection == 0) {
            if((yMax == 0 && j < yMax) || (yMax == Table.getN()-1 && j > yMax)) {
                return vetor;
            }
        } else if(yDirection == 0) {
            if((xMax == 0 && i < xMax) || (xMax == Table.getM()-1 && i > xMax)) {
                return vetor;
            }
        }
        
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Enemy) {
            if(!myMoves.contains(table.getBlock(newVetor))) { 
                myMoves.add(table.getBlock(newVetor));
//                System.out.println("Adicionado bloco na posição (enemy): " + newVetor.getX() + " " + newVetor.getY());
            }
            return newVetor;
        }
    
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Friend) {
            return vetor;
        }
        
        if(table.getBlock(i, j).getBlockState(player) == BlockState.Empty) {
            
            if(!myMoves.contains(table.getBlock(newVetor))) { 
                myMoves.add(table.getBlock(newVetor));
//                System.out.println("Adicionado bloco na posição: " + newVetor.getX() + " " + newVetor.getY());
            }
            return LookForLast(xDirection, yDirection, newVetor);
        }
        return newVetor;
    }
}