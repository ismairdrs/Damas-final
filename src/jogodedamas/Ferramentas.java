/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodedamas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;


/**
 *
 * @author Junior
 */
public class Ferramentas extends JPanel implements ActionListener{

	private JMenu menu, menu2;
		
	private JMenuBar barra;

	private JogoDeDamas jogoDeDamas;
	
	private Tabuleiro tabuleiro;
                    
                    
                      
                      private JMenuItem novaPartida, sair, trocarModo;
                    
   
	
	private void iniciar() {
                                           menu = new JMenu("Ferramentas");
                                           menu2 = new JMenu("Sair");
		barra = new JMenuBar();
		barra.add(menu);
                                           barra.add(menu2);
                                           novaPartida = new JMenuItem("Nova Partida");
                                           sair = new JMenuItem("Sair");
                                           trocarModo = new JMenuItem("Trocar Modo");
                                            menu.add(novaPartida);
                                            menu.add(sair);
                                            menu.add(trocarModo);
                                           trocarModo.addActionListener(this);
                                           novaPartida.addActionListener(this);
                                           sair.addActionListener(this);
                                     
                                           menu.addActionListener(this);
                                      
                                         
                                   
                                      
                                            menu2.addActionListener(this);
                                       
                                            
                          
                                             
}
         
	

	private void alinhar() {
		setLayout(new BorderLayout());
		add(barra,BorderLayout.CENTER);
	}
	
	public Ferramentas(JogoDeDamas PjogoDeDamas,Tabuleiro jogo) {
		iniciar();
		alinhar();
		tabuleiro = jogo;
		jogoDeDamas = PjogoDeDamas;
	}

@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == novaPartida) {
			new NovaPartida(jogoDeDamas,tabuleiro).abrir();
		}
		if(e.getSource() == sair) {
			jogoDeDamas.dispose();
		}
		
		if(e.getSource() == trocarModo) {
			new SelecionarModo(jogoDeDamas,tabuleiro).abrir();;
		}
	}
}