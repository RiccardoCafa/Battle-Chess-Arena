package Xadrez;

public class Peao extends Peca {

	public Peao(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Mover() {
		// TODO Auto-generated method stub
		System.out.println("Frente + 2");
		essaVarPertenceAPeca = 3;
	}

}
