package businessPack.Pieces.Wizard;

import businessPack.Block;
import businessPack.Pieces.Interfaces.IMovement;
import businessPack.Player;
import businessPack.Table;
import extras.BlockState;
import extras.Vetor;
import java.util.ArrayList;

public class WizardBishop implements IMovement {
    
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
         
        ultPos = behindBlocks(-1,1,vetor); //checar inferior esquerda
        missY = Math.abs(ultPos.getY() - vetor.getY());//calcular o que sobra
        missX = Math.abs(ultPos.getX() - vetor.getX());
        pickSideBlocks(-1,1,ultPos,missY);//redirecionar
        pickSideBlocks(-1,1,ultPos,missX);
        
        
        ultPos = behindBlocks(-1,-1, vetor);//checar superior esquerda
        missY =  Math.abs(ultPos.getY() - vetor.getY());
        missX =  Math.abs(ultPos.getX() - vetor.getX());
        pickSideBlocks(-1,-1,ultPos,missY);
        pickSideBlocks(-1,-1,ultPos,missX);
        
        
        ultPos = behindBlocks(1,-1,vetor);//checar superior direita
        missX = Math.abs(ultPos.getX() - vetor.getX());
        missY = Math.abs(ultPos.getY() - vetor.getY());
        pickSideBlocks(1,-1,ultPos,missY);
        pickSideBlocks(1,-1,ultPos,missX);
        
        
        ultPos = behindBlocks(1,1,vetor); // checar inferior direita
        missY = Math.abs(ultPos.getY() - vetor.getY());
        missX = Math.abs(ultPos.getX() - vetor.getX());
        pickSideBlocks(1,1,ultPos,missY);
        pickSideBlocks(1,1,ultPos,missX);
        
        
        return vect;
    }   
    // função que reconhece se há inimigos ou amigos
    public Vetor behindBlocks(int xGo, int yGo, Vetor vet, int num){
        int i = vet.getX() + xGo;
        int j = vet.getY() + yGo;
        Vetor auxVetor = new Vetor(i, j);
        //condições de parada
        if(j < 0 || j > 7 || i < 0 || i > 7 || num <= 0){
            return vet;
        }
        //verificar a existencia de inimigos
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Enemy){
            if(!vect.contains(tab.getBlock(auxVetor))){
                vect.add(tab.getBlock(auxVetor));
                //adicionado na posição auxVetor.getx e na auxVetor.getY
            }
            return auxVetor;
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
        num--;
        return behindBlocks(xGo,yGo, vet, num);

    }
    
    //função behind blocks com a condição de parada
    public Vetor behindBlocks(int xGo,int yGo, Vetor vet){
        int i = vet.getX() + xGo;
        int j = vet.getY() + yGo;
        Vetor auxVetor = new Vetor(i, j);
        //condições de parada
        if(j < 0 || j > 7 || i < 0 || i > 7){
            return vet;
        }
        //verificar a existencia de inimigos
        
        
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Enemy){
            if(!vect.contains(tab.getBlock(auxVetor))){
                vect.add(tab.getBlock(auxVetor));
                //adicionado na posição auxVetor.getx e na auxVetor.getY
            }
            return auxVetor;
        }
        // checa se tem amigos
        
        if(tab.getBlock(i,j).getBlockState(playing) == BlockState.Friend){
            return vet;
        }
        // checa se está vazio
        if(tab.getBlock(i, j).getBlockState(playing) == BlockState.Empty){
            if(!vect.contains(tab.getBlock(auxVetor))){
                vect.add(tab.getBlock(auxVetor));
                // se ele não existe, adiciiona na lista
            }
            
        }
        return behindBlocks(xGo,yGo,auxVetor);
    }
 
   
    public void pickSideBlocks(int xDir, int yDir, Vetor ultPos,int missC){
     int sides = 0;
        if((yDir == -1 && xDir == -1) || (yDir == 1 && xDir ==1)){
            while(sides<=missC){ 
                behindBlocks(-1,-1,ultPos,sides);
                behindBlocks(1, 1, ultPos,sides);
                ultPos.setX(ultPos.getX() + (-1 * xDir));
                ultPos.setY(ultPos.getY() + (-1 * yDir));
                System.out.println("-1 -1 / 1 1");
                System.out.println("faltando " + sides + " posicoes");
                System.out.println("Posicao encontrada: " + ultPos.getX() + " " + ultPos.getY());
                sides++;
            }

        }else if((yDir == -1 && xDir == 1)|| (yDir == 1 && xDir == -1)){
         while(sides<=missC){
            behindBlocks(-1,1,ultPos,sides); 
            behindBlocks(1,-1,ultPos,sides);
            ultPos.setX(ultPos.getX() + (-1 * xDir));
            ultPos.setY(ultPos.getY() + (-1 * yDir));
            System.out.println("-1 1 / 1 -1");
            System.out.println("faltando " + sides + " posicoes");
            System.out.println("Posicao encontrada: " + ultPos.getX() + " " + ultPos.getY());
            sides++;

         }
            
        }
           
    }
        
    }
    
    
    
    
    
