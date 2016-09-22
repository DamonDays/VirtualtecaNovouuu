package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuBibliotecarioUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBibliotecarioUI frame = new MenuBibliotecarioUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuBibliotecarioUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btnNewButton_8 = new JButton("Deslogar");
		panel_1.add(btnNewButton_8);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("MENU");
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Lista de Cliente");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastro de Cliente");
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroClienteUI cadastroClienteFrame = new CadastroClienteUI();
				cadastroClienteFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Lista de Livro");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cadastro de Livro");
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroLivroUI cadastroLivroFrame = new CadastroLivroUI();
				cadastroLivroFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Lista de Sess\u00E3o");
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Cadastro de Sess\u00E3o");
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroSessaoUI cadastroSessaoFrame = new CadastroSessaoUI();
				cadastroSessaoFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JButton btnNewButton_7 = new JButton("Lista de Estante");
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton = new JButton("Cadastro de Estante");
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroEstanteUI cadastroEstanteFrame = new CadastroEstanteUI();
				cadastroEstanteFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginUI loginFrame = new LoginUI();
				loginFrame.setVisible(true);
				setVisible(false);
			}
		});
	}
}
