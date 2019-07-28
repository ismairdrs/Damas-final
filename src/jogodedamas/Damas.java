/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodedamas;

import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class Damas {

	private final int tabuleiro[][];
	private final int vermelhas = 1, pretas = 2, rainhaVermelha = 3, rainhaPreta = 4, vazio = 5;
                    private char cor = 'P';
                      
	public char getcor() {
		return cor;
	}
	public int getVazio() {
		return vazio;
	}
	public int getVermelhas() {
		return vermelhas;
	}
	public int getPretas() {
		return pretas;
	}
	public int getRainhaVermelha() {
		return rainhaVermelha;
	}
	public int getRainhaPreta() {
		return rainhaPreta;
	}
	
	public void trocarDeCor() {
		if(cor == 'V') {
			cor = 'P';
		}else {
			cor = 'V';
		}
	}

	public Damas() {
		tabuleiro = new int[8][8];
	}

	public int verDamas(int i,int j) {
		possibilidadeRainha();
		return tabuleiro[i][j];
	}
	
	public void colocarFichas() {	
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (j % 2 == 0) {
					tabuleiro[1][j] = vermelhas;
					tabuleiro[7][j] = pretas;
					tabuleiro[5][j] = vazio;
					tabuleiro[3][j] = vazio;
				} else {
					tabuleiro[0][j] = vermelhas;
					tabuleiro[6][j] = pretas;
					tabuleiro[2][j] = vazio;
					tabuleiro[4][j] = vazio;
				}
			}
		}
	}

	
	public boolean verificarExistenciaDeFicha(char cor, int x,int y) {
		if(cor == 'P') {
			if(tabuleiro[x][y] == pretas || tabuleiro[x][y] == rainhaPreta) {
				return true;
			}
		}else if(cor == 'V'){
			if(tabuleiro[x][y] == vermelhas || tabuleiro[x][y] == rainhaVermelha) {
				return true;
			}
		}
		return false;
	}
	
	
	public void imprimir(int contadorN, int contadorR, char cor) {

	}
	public void mostrarTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.print(tabuleiro[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public boolean jogar(char cor, int x, int y, int x1, int y1) {
		boolean passa = false;
		int variavel, rainha, inimigo, rainhaInimiga;
		if (cor == 'V') {
			inimigo = pretas;
			rainhaInimiga = rainhaPreta;
			variavel = vermelhas;
			rainha = rainhaVermelha;
		} else {
			rainhaInimiga = rainhaVermelha;
			inimigo = vermelhas;
			variavel = pretas;
			rainha = rainhaPreta;
		}
		while (passa == false) {
			
			if (tabuleiro[x][y] == variavel) {
				if (y1 > -1 && x1 > -1 && y1 < 8 && x1 < 8) {
					if (tabuleiro[x1][y1] == 5) {
						if (variavel == pretas) {
							
							if (x1 == x - 1) {
								
								if (y1 == y - 1 || y1 == y + 1) {
									tabuleiro[x][y] = 5;
									tabuleiro[x1][y1] = pretas;
									passa = true;
								}
							}
							if (x1 == x - 2) {
								if (y1 == y + 2) {
									if (tabuleiro[x - 1][y + 1] == inimigo || tabuleiro[x - 1][y + 1] == rainhaInimiga) {
										tabuleiro[x - 1][y + 1] = 5;
										tabuleiro[x][y] = 5;
										tabuleiro[x1][y1] = pretas;
										passa = true;
									}
								} else if (y1 == y - 2) {
									if (tabuleiro[x - 1][y - 1] == inimigo || tabuleiro[x - 1][y - 1] == rainhaInimiga) {
										tabuleiro[x - 1][y - 1] = 5;
										tabuleiro[x][y] = 5;
										tabuleiro[x1][y1] = pretas;
										passa = true;
									}

								}
							}
                                                             
                                                     //   System.out.println("VEZ DAS PEÇAS VERMELHAS");
						} else if (variavel == vermelhas) {
                                                                                                                                 
                                                                                                                                 //    System.out.println("VEZ DAS PEÇAS PRETAS");
                                                                                                                                   
							if (x1 == x + 1) {
								if (y1 == y - 1 || y1 == y + 1) {
									tabuleiro[x][y] = 5;
									tabuleiro[x1][y1] = vermelhas;
									passa = true;
                                                                      
                                                                 
								}
							}
							if (x1 == x + 2) {
								if (y1 == y + 2) {
									if (tabuleiro[x + 1][y + 1] == inimigo || tabuleiro[x + 1][y + 1] == rainhaInimiga) {
										tabuleiro[x + 1][y + 1] = 5;
										tabuleiro[x][y] = 5;
										tabuleiro[x1][y1] = vermelhas;
										passa = true;
									}
								} else if (y1 == y - 2) {
									if (tabuleiro[x + 1][y - 1] == inimigo || tabuleiro[x + 1][y - 1] == rainhaInimiga) {
										tabuleiro[x + 1][y - 1] = 5;
										tabuleiro[x][y] = 5;
										tabuleiro[x1][y1] = vermelhas;
										passa = true;
									}

								}
							}
						}
					}

				} else {
					
				}
			} 
			
			
			else if (tabuleiro[x][y] == rainha) {
				// movimento da rainha
				int menorx = 0, menory = 0;

				if (x == x1 || y == y1) {
					 //JOptionPane.showMessageDialog(null, "movimento invalido");
				} else if (tabuleiro[x1][y1] == variavel) {
					// JOptionPane.showMessageDialog(null, "movimento invalido, já existe uma ficha aqui");
				} else if (tabuleiro[x1][y1] == 5) {
					for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
						menory = i;
						menorx = j;
					}
					for (int i = menory, j = menorx; i < tabuleiro[0].length; i++, j++) {
						if (i == x1 && j == y1) {

							if (x > x1 && y > y1) {

								for (int j2 = x, i2 = y; i2 >= y1 || j2 >= x1; j2--, i2--) {
									if (tabuleiro[j2][i2] == variavel || tabuleiro[j2][i2] == rainha) {

									} else {
										tabuleiro[j2][i2] = 5;
										passa = true;
									}

								}
							} else if (x < x1 && y < y1) {

								for (int j2 = x, i2 = y; i2 < y1 || j2 < x1; j2++, i2++) {
									tabuleiro[j2][i2] = 5;
									passa = true;
								}
							}

							tabuleiro[x][y] = 5;
							tabuleiro[x1][y1] = rainha;
							passa = true;
						}
					}
					for (int i = x, j = y; i >= 0; i--, j++) {
						menory = i;
						menorx = j;
					}
					for (int i = menory, j = menorx; i < tabuleiro[0].length; i++, j--) {
						if (i == x1 && j == y1) {
							if (x < x1 && y > y1) {

								for (int j2 = x, i2 = y; i2 >= y1 || j2 < x1; j2++, i2--) {
									if (tabuleiro[j2][i2] == variavel || tabuleiro[j2][i2] == rainha) {

									} else {
										tabuleiro[j2][i2] = 5;
										passa = true;
									}
								}
							} else if (x > x1 && y < y1) {
								for (int j2 = x, i2 = y; i2 < y1 || j2 >= x1; j2--, i2++) {
									if (tabuleiro[j2][i2] == variavel || tabuleiro[j2][i2] == rainha) {

									} else {
										tabuleiro[j2][i2] = 5;
										passa = true;
									}
								}
							}
							tabuleiro[x][y] = 5;
							tabuleiro[x1][y1] = rainha;
							passa = true;
						}
					}
					if (passa == false) {
						 //JOptionPane.showMessageDialog(null, "movimento invalido");
					} else {
						//JOptionPane.showMessageDialog(null, "movimento feito");
                                                                                                                                 //       System.out.println("MOVIMENTOU UMA FICHA");
					}
				} else {
					// JOptionPane.showMessageDialog(null, "Tem que comer uma ficha!");
                                                     //   System.out.println("TEM QUE COMER UMA FICHA");
				}
			} else {
				// System.out.println("Peça não existe");
                                 //    System.out.println("PEÇA NÃO EXISTE");
				passa = false;
			}
			if(passa == false) {
				break;
			}
		}
		return passa;
	}

	public boolean verificar(char cor) {
		int contadorN = 0, contadorR = 0;
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[0].length; j++) {
				if (tabuleiro[i][j] == vermelhas || tabuleiro[i][j] == rainhaVermelha) {
					contadorR++;
				} else if (tabuleiro[i][j] == pretas || tabuleiro[i][j] == rainhaPreta) {
					contadorN++;
				}
			}
		}
		imprimir(contadorN, contadorR, cor);
		if (contadorN == 0 && contadorR > 0) {
			JOptionPane.showMessageDialog(null, "Vermelhas ganharam!");
			return true;
		} else if (contadorR == 0 && contadorN > 0) {
			JOptionPane.showMessageDialog(null, "Pretas ganharam!");
			return true;
		}
		return false;
	}

	public void possibilidadeRainha() {
		for (int j = 0; j < tabuleiro[0].length; j++) {
			if (tabuleiro[0][j] == pretas) {
				tabuleiro[0][j] = rainhaPreta;
                                
                                                                        System.out.println("Virou rainha preta");
			} else if (tabuleiro[7][j] == vermelhas) {
				tabuleiro[7][j] = rainhaVermelha;
                                                                             System.out.println("Virou rainha vermelha");
			}
		}
	}
}
