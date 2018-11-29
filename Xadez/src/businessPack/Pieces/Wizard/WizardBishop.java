package businessPack.Pieces.Wizard;

import businessPack.Block;
import businessPack.Pieces.Interfaces.ItypePiece;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;



public class WizardBishop implements ItypePiece {
    
    Table tab;
    ArrayList<Block> vect;
    Player playing;
    
    public WizardBishop(Player p){
        this.playing = p;
    }
    
    @Override
    public ArrayList<Block> IcheckMove(Table table, Vetor vetor){
        vect = new ArrayList<>();
        tab = table;
        int missX, missY;
        Vetor ultPos;
        
        ultPos = behindBlocks(-1,1,vetor); //checar superior esquerda
        missY = Math.abs(ultPos.getY() - vetor.getY());//calcular o que sobra
        pickSideBlocks(-1,1,ultPos,missY);//redirecionar
        
        ultPos = behindBlocks(-1,-1, vetor);//checar superior direita
        missY =  Math.abs(ultPos.getY() - vetor.getY());
        pickSideBlocks(-1,-1,ultPos,missY);
        
        ultPos = behindBlocks(1,-1,vetor);//checar inferior direita
        missX = Math.abs(ultPos.getX() - vetor.getX());
        pickSideBlocks(1,-1,ultPos,missX);
        
        ultPos = behindBlocks(1,1,vetor); // checar inferior esquerda
        missX = Math.abs(ultPos.getX() - vetor.getX());
        pickSideBlocks(1,1,ultPos,missX);
        return vect;
    }
    @Override
    public Table Ireaction(Table table, Vetor vetor) {
        return table;
    }   
    
    public Vetor behindBlocks(int xGo, int yGo, Vetor vet, int num){
        int i = vet.getX() + xGo;
        int j = vet.getY() + yGo;
        Vetor auxVetor = new Vetor(i, j);
        //condições de parada
        if(j < 0 || j > 7 || i < 0 || i > 7 || num == 0){
            return vet;
        }
        //verificar a existencia de inimigos
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Enemy){
            if(!vect.contains(tab.getBlock(auxVetor))){
                vect.add(tab.getBlock(auxVetor));
                //adicionado na posição auxVetor.getx e na auxVetor.getY
            return auxVetor;
            }
        }
        // checa se tem amigos
        if(tab.getBlock(i,j).getBlockState(playing) == BlockState.Friend){
            return vet;
            
        }
        // checa se está vazio
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Empty){
            if(!vect.contains(tab.getBlock(auxVetor))){
                // se ele não existe, adiciiona na lista
                vect.add(tab.getBlock(auxVetor));
            }
        }
        // condição de parada com o num
            return behindBlocks(xGo,yGo, vet, num--);

    }
    
    //mesma função sem o num para a condição de parada
    public Vetor behindBlocks(int xGo,int yGo, Vetor vet){
        
        int i = vet.getX() + xGo;
        int j = vet.getY() + yGo;
        Vetor auxVetor = new Vetor(i, j);
        //condições de parada
        System.out.println("If is rigth?");
        if(j < 0 || j > 7 || i < 0 || i > 7){
            return vet;
        }
        //verificar a existencia de inimigos
        
        System.out.println("There is a enemy here?");
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Enemy){
            if(!vect.contains(tab.getBlock(auxVetor))){
                vect.add(tab.getBlock(auxVetor));
                return auxVetor;
                //adicionado na posição auxVetor.getx e na auxVetor.getY
            }
           
        }
        // checa se tem amigos
        System.out.println("there is a friend here");
        if(tab.getBlock(i,j).getBlockState(playing) == BlockState.Friend){
            return vet;
            
        }
        // checa se está vazio
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Empty){
            if(!vect.contains(tab.getBlock(auxVetor))){
                vect.add(tab.getBlock(auxVetor));
                // se ele não existe, adiciiona na lista
                return behindBlocks(xGo,yGo,auxVetor);
            }
        }
        return vet;
    }
 
    
    public void pickSideBlocks(int xDir, int yDir, Vetor ultPos,int missC){
        int sides = 0;
        if(xDir != 0){
            do{
                behindBlocks(1,1,ultPos); 
                behindBlocks(1,-1,ultPos);
                sides++;
               ultPos.setX(ultPos.getX() + (-1 * xDir));
            }while(sides<missC);
            
        }else if(yDir != 0){
            do{
                behindBlocks(-1, 1, ultPos);
                behindBlocks(-1,-1,ultPos);
                sides++;
                ultPos.setY(ultPos.getY() + (-1 * yDir));
            }while(sides<missC);
            
        }
    }  
      
}
