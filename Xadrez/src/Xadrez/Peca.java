package Xadrez;

public abstract class Peca {
	private int x;
	private int y;
	
	public int essaVarPertenceAPeca;
	
	public Peca(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public abstract void Mover();

	protected int getY() {
		return y;
	}

	protected void setY(int y) {
		this.y = y;
	}

	private int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}
	
	public void TesteCOmuna() {
		
	}
}
