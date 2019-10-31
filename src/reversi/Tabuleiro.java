package reversi;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Tabuleiro extends JPanel
{
	private PecaMelhor[][] tabuleiro;
	private int currentPlayer;

	public Tabuleiro()
	{
		currentPlayer = 1;
		
		setLayout(new GridLayout(8,8));
		tabuleiro = new PecaMelhor[8][8];
		for(int l=0;l<8;l++)
			for(int c=0;c<8;c++)
			{
				tabuleiro[c][l] = new PecaMelhor();
				add(tabuleiro[c][l]);
				tabuleiro[c][l].addActionListener(onPecaClicada(c, l));
			}
		tabuleiro[3][3].setEstado(Estado.BRANCO);
		tabuleiro[4][4].setEstado(Estado.BRANCO);
		tabuleiro[3][4].setEstado(Estado.PRETO);
		tabuleiro[4][3].setEstado(Estado.PRETO);
		tabuleiro[5][5].setEstado(Estado.PRETO);
	}
	
	public ActionListener onPecaClicada(final int x, final int y) {
		return e -> {
			if (currentPlayer == 1) {
				currentPlayer = 2;
				tabuleiro[x][y].setEstado(Estado.PRETO);
			} else {
				currentPlayer = 1;
				tabuleiro[x][y].setEstado(Estado.BRANCO);
			}
		};
	}

}