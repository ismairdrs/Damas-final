/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodedamas;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class NovaPartida extends JFrame implements ActionListener{

	private Label vermelhas,pretas,vs;
	
	private JButton botao1,botao2;
	
	private JComboBox<Object> combo1,combo2;
	
	private JogoDeDamas jogoDeDamas;
	
	private Tabuleiro tabuleiro;
	
	public void iniciar() {
		
		botao1= new JButton("Começar Partida");
		botao1.setBounds(50,70,140,30);
		botao1.addActionListener(this);
		
		botao2= new JButton("Sair");
		botao2.setBounds(220,70,100,30);
		botao2.addActionListener(this);
		
		vermelhas = new Label("vermelhas");
		vermelhas.setBounds(120,10,30,20);
		pretas = new Label("pretas");
		pretas.setBounds(230,10,35,20);
		vs = new Label("VS");
		vs.setBounds(185, 35, 30, 20);
		
		combo1 = new JComboBox<>();
		combo1.addItem("");
		combo1.addItem("Automatico");
		combo1.addItem("Manual");
		combo2 = new JComboBox<>();
		combo2.addItem("");
		combo2.addItem("Automatico");
		combo2.addItem("Manual");
		
		combo1.setBounds(100,35,70,20);
		combo2.setBounds(220,35,70,20);
	}
	
	public NovaPartida(JogoDeDamas pjogoDeDamas,Tabuleiro ptabuleiro) {
		iniciar();
		jogoDeDamas = pjogoDeDamas;
		tabuleiro = ptabuleiro;
		setLayout(null);
		getContentPane().add(vermelhas);
		getContentPane().add(pretas);
		getContentPane().add(combo1);
		getContentPane().add(combo2);
		getContentPane().add(vs);
		getContentPane().add(botao1);
		getContentPane().add(botao2);
		setResizable(false);
		setSize(400,150);
		setLocationRelativeTo(jogoDeDamas);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public NovaPartida() {
		
	}
	
	public void abrir() {
		
	}
	
	@SuppressWarnings("null")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botao1) {
			if(combo1.getSelectedIndex() == 0 || combo2.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(jogoDeDamas,"Os campos não podem estar vazios");
			}else {
				jogoDeDamas.AtualizarBotoes();
				tabuleiro.trocar(combo1.getSelectedIndex(), combo2.getSelectedIndex());
				dispose();
			}
		}else {
			dispose();
		}
		
	}
}

