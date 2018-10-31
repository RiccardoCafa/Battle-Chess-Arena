package Xadrez;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Peca[][] pecas = new Peca[8][8];
		pecas[5][0] = new Torre(3, 4);
		pecas[4][0] = new Peao(4, 5);
		
		pecas[5][0].Mover();
		pecas[4][0].Mover();
	}

}
