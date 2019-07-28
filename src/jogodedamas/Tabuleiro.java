/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodedamas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;


import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Junior
 */
public class Tabuleiro extends JPanel implements ActionListener {
    
                    private JButton botao[][];

	private Damas damas;

	private int tabuleiro[][] = new int[8][8];
                      
                     
	
	public void iniciar() {
		
		
                
                
                
		botao = new JButton[8][8];
		damas = new Damas();
                
		damas.colocarFichas();
		removeAll();
		for (int i = 0; i < botao.length; i++) {
			for (int j = 0; j < botao[0].length; j++) {

				botao[i][j] = new JButton();
				botao[i][j].setBackground(Color.WHITE);
                              
				botao[i][j].setBorderPainted(false);
				botao[i][j].setContentAreaFilled(false);
				botao[i][j].setOpaque(false);
				botao[i][j].addActionListener(this);
				botao[i][j].setIcon(new ImageIcon("./imagens/EspacoBranco.jpg"));
			}
		}
	}

	public void resetarTabuleiro() {
		damas.colocarFichas();
	}
	
	public void desenharTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
                                 
			for (int j = 0; j < tabuleiro.length; j++) {
                      
       
				if (j % 2 == 0) {
                                                                                                       
					tabuleiro[1][j] = 5;
					tabuleiro[7][j] = 5;
					tabuleiro[5][j] = 5;
					tabuleiro[3][j] = 5;
				} else {
                   
					tabuleiro[0][j] = 5;
					tabuleiro[6][j] = 5;
					tabuleiro[2][j] = 5;
					tabuleiro[4][j] = 5;
				}
			}
		}
                
                
	}
	
	public void criarTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < botao.length; j++) {
				if (tabuleiro[i][j] == damas.getPretas()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaPreta.jpg"));
				} else if (tabuleiro[i][j] == damas.getVermelhas()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaVermelha.jpg"));
				} else if (tabuleiro[i][j] == damas.getRainhaVermelha()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaRainhaVermelha.jpg"));
				} else if (tabuleiro[i][j] == damas.getRainhaPreta()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaRainhaPreta.jpg"));
				} else if (tabuleiro[i][j] == damas.getVazio()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/EspacoEscuro.jpg"));
				}
			}
		}
	}
	
	public void desenharBotoes() {
		damas.verificar(damas.getcor());
		for (int i = 0; i < botao.length; i++) {
			for (int j = 0; j < botao.length; j++) {
				if (damas.verDamas(i, j) == damas.getPretas()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaPreta.jpg"));
				} else if (damas.verDamas(i, j) == damas.getVermelhas()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaVermelha.jpg"));
				} else if (damas.verDamas(i, j) == damas.getRainhaVermelha()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaRainhaVermelha.jpg"));
				} else if (damas.verDamas(i, j) == damas.getRainhaPreta()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/FichaRainhaPreta.jpg"));
				} else if (damas.verDamas(i, j) == damas.getVazio()) {
					botao[i][j].setIcon(new ImageIcon("./imagens/EspacoEscuro.jpg"));
				}
			}
		}
	}

	public void alo() {
		damas.colocarFichas();
		desenharBotoes();
	}
                 
	public void alinhar() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < botao.length; i++) {
			for (int j = 0; j < botao[0].length; j++) {
				panel.add(botao[i][j]);
			}
		}
		add(panel);
	}

	public Tabuleiro() {
		iniciar();
		setLayout(new BorderLayout());
		
		setVisible(true);
		alinhar();
		desenharTabuleiro();
		criarTabuleiro();
	}

	public void trocar(int vermelhas,int pretas) {
		this.vermelhas = vermelhas;
		this.pretas = pretas;
	}
	
	int contar = 0;
	int x = 0, y = 0, x1 = 0, y1 = 0,vermelhas,pretas;
                                    
        
               
        
        public boolean jogarSozinho(boolean pasa) {
            
             int x = (int) (Math.random() * 8) + 0;
		int y = (int) (Math.random() * 8) + 0;
		int x1 = (int) (Math.random() * 8) + 0;
		int y1 = (int) (Math.random() * 8) + 0;
		if (damas.jogar(damas.getcor(), x, y, x1, y1) == true) {
			desenharBotoes();
			botao[x][y].setIcon(new ImageIcon("imagens/EspacoEscuro.jpg"));
			return true;
		}
		return pasa;
	}
        
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean passa = false;
		for (int i = 0; i < botao.length; i++) {
			for (int j = 0; j < botao[0].length; j++) {
				if(e.getSource() == botao[i][j]) {
					
					if(vermelhas == 1 && pretas == 1) {
						//Vermelhas:Automatico Vs Pretas:Automatico
						                               
						while(jogarSozinho(passa) == false) {
							
						}
						damas.trocarDeCor();
					}else if(vermelhas == 2 && pretas == 2) {
						//Vermelhas:Manual Vs Pretas:Manual
						if(damas.verificarExistenciaDeFicha(damas.getcor(), i, j)) {
							x = i;
							y = j;
							contar++;
						}else if(contar == 1) {
							if(damas.jogar(damas.getcor(), x, y, i, j)) {
								desenharBotoes();
								damas.trocarDeCor();
							}else {
								JOptionPane.showMessageDialog(null,"Movimento Invalido");
							}
							contar--;
						}
					}else if(vermelhas == 1 && pretas == 2) {
						//Vermelhas:Automatico Vs Pretas:Manual
						
						if(damas.getcor() == 'N') {
							if(damas.verificarExistenciaDeFicha(damas.getcor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jogar(damas.getcor(), x, y, i, j)) {
									desenharBotoes();
									damas.trocarDeCor();
								}else {
									JOptionPane.showMessageDialog(null,"Movimento Invalido");
								}
								contar--;
							}
						}else {
							while(jogarSozinho(passa) == false) {
								
							}
							damas.trocarDeCor();
						}
						
						
					}else if(vermelhas == 2 && pretas == 1) {
						//Vermelhas:Manual Vs Pretas:Automatico
						
						if(damas.getcor() == 'R') {
							if(damas.verificarExistenciaDeFicha(damas.getcor(), i, j)) {
								x = i;
								y = j;
								contar++;
							}else if(contar == 1) {
								if(damas.jogar(damas.getcor(), x, y, i, j)) {
									desenharBotoes();
									damas.trocarDeCor();
								}else {
									JOptionPane.showMessageDialog(null,"Movimento Invalido");
								}
								contar--;
							}
						}else {
							while(jogarSozinho(passa) == false) {
								
							}
							damas.trocarDeCor();
						}
						
					}
				}
			}
		}
	}
}