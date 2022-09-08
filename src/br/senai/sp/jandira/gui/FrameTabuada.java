package br.senai.sp.jandira.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.senai.sp.jandira.Tabuada;

public class FrameTabuada {
	public Color corDeFundoDaTela;
	public String titulo;
	public int largura, altura;
	public Color corDoBotao;
	public Color corDoTextoDoBotao;
	public Font fonteDoTitulo;
	public Color corLetras;
	public Font fonteDoSubTitulo;
	public Color corDois;
	public Color corBasica;
	public LineBorder borda;

	// criar janela
	public void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);

		// obter a instancia do painel de controle
		Container painel = tela.getContentPane();
		painel.setBackground(corDeFundoDaTela);

		// criar os componentes da tela e colocar no painel (container)
		// x, y, larg, alt

		// simbolo

		// tabuada 1.0
		JLabel labelTitulo = new JLabel();
		labelTitulo.setText("Tabuada 1.0");
		labelTitulo.setBounds(100, 10, 130, 50);
		labelTitulo.setForeground(new Color(255, 0, 0));
		labelTitulo.setFont(fonteDoTitulo);

		// com a tabuada seus problemas acabaram
		JLabel labelTexto = new JLabel();
		labelTexto.setText("<html>Com a tabuada 1.0 os seus problemas acabaram. Calcule<br/>a tabuada que desejar em segundos!</html>");
		labelTexto.setBounds(100, 40, 600, 40);
		labelTexto.setForeground(corBasica);

		// multiplicando
		JLabel labelMultiplicando = new JLabel();
		labelMultiplicando.setText("Multiplicando:");
		labelMultiplicando.setBounds(100, 100, 100, 20);
		labelMultiplicando.setForeground(corLetras);
		labelMultiplicando.setFont(fonteDoSubTitulo);
		// caixa multiplicando
		JTextField textFieldMultiplicando = new JTextField();
		textFieldMultiplicando.setBounds(250, 95, 180, 30);
		textFieldMultiplicando.setBorder(borda);

		// minimo multiplicador
		JLabel labelMinMulti = new JLabel();
		labelMinMulti.setText("Mínimo Multiplicador:");
		labelMinMulti.setBounds(47, 150, 300, 20);
		labelMinMulti.setForeground(corLetras);
		labelMinMulti.setFont(fonteDoSubTitulo);
		// caixa minimo multiplicador
		JTextField textFieldMinMulti = new JTextField();
		textFieldMinMulti.setBounds(250, 145, 180, 30);
		textFieldMinMulti.setBorder(borda);

		// máximo multiplicador
		JLabel labelMaxMulti = new JLabel();
		labelMaxMulti.setText("Máximo Multiplicador:");
		labelMaxMulti.setBounds(47, 200, 300, 20);
		labelMaxMulti.setForeground(corLetras);
		labelMaxMulti.setFont(fonteDoSubTitulo);
		// caixa máximo multiplicador
		JTextField textFieldMaxMulti = new JTextField();
		textFieldMaxMulti.setBounds(250, 195, 180, 30);
		textFieldMaxMulti.setBorder(borda);

		// botao calcular
		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setBounds(47, 250, 220, 40);
		buttonCalcular.setForeground(corDoTextoDoBotao);
		buttonCalcular.setBackground(corDoBotao);
		buttonCalcular.setBorder(borda);

		// botao limpar
		JButton buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(280, 250, 150, 40);
		buttonLimpar.setForeground(corDoTextoDoBotao);
		buttonLimpar.setBackground(corDois);
		buttonLimpar.setBorder(borda);

		// resultado
		JLabel labelResultado = new JLabel();
		labelResultado.setText("Resultado:");
		labelResultado.setForeground(corLetras);
		labelResultado.setFont(fonteDoSubTitulo);
		labelResultado.setBounds(47, 300, 100, 30);
		// caixa resultado
		JList lista = new JList();
		JScrollPane scroll = new JScrollPane(lista);

		scroll.setBounds(47, 330, 400, 200);
		scroll.setBorder(borda);
		scroll.setBackground(corDois);

		// eventos
		buttonCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Tabuada tabuada = new Tabuada();
				tabuada.multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
				tabuada.minimoMultiplicador = Integer.parseInt(textFieldMinMulti.getText());
				tabuada.maximoMultiplicador = Integer.parseInt(textFieldMaxMulti.getText());

				String[] resultado = tabuada.getTabuada();
				System.out.println(resultado[0]);
				lista.setListData(resultado);
			}
		});
		
		buttonLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textFieldMultiplicando.setText("");
				textFieldMinMulti.setText("");
				textFieldMaxMulti.setText("");
			}
		});
		
		
		// add componentes ao painel (container)
		painel.add(labelTitulo);

		painel.add(labelTexto);

		painel.add(labelMultiplicando);
		painel.add(textFieldMultiplicando);

		painel.add(labelMinMulti);
		painel.add(textFieldMinMulti);

		painel.add(labelMaxMulti);
		painel.add(textFieldMaxMulti);

		painel.add(labelMaxMulti);
		painel.add(textFieldMaxMulti);

		painel.add(buttonCalcular);
		painel.add(buttonLimpar);

		painel.add(labelResultado);
		painel.add(scroll);
		
		tela.setVisible(true);

	}
}