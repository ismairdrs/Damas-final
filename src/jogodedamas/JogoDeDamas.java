
//RANDON
//PESQUISAR COMO USAR A CLASSE E LIMITAR A 8 POSIÇÕES


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodedamas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Junior
 */
public class JogoDeDamas extends JFrame{
	
	Tabuleiro tabuleiro;
	
	Ferramentas painel1;
	
	
	
	public JogoDeDamas() {
		super("Damas");
		iniciar();
		alinhar();
		setVisible(true);
		setResizable(false);
		
		setSize(480,520);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                                            
		
	}
	
        
        
	public void alinhar() {
		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());
		
		
		
		setLayout(new BorderLayout());
		add(tabuleiro, BorderLayout.CENTER);
		add(painel1, BorderLayout.NORTH);
	
	}
	
	public static void main(String[] args) {
		new JogoDeDamas();
	}
	
	public void AtualizarBotoes() {
		tabuleiro.resetarTabuleiro();
		tabuleiro.desenharBotoes();
	}
	
	public void iniciar() {
		tabuleiro = new Tabuleiro();
		painel1 = new Ferramentas(this,tabuleiro);
		
	}
}
