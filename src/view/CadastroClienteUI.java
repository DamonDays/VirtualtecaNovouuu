package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import persistence.ClienteDAO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class CadastroClienteUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClienteUI frame = new CadastroClienteUI();
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
	public CadastroClienteUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		panel.add(lblNomeCompleto);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("Idade:");
		panel_3.add(lblNewLabel);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_5.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_5.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		panel_5.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);
		
		JLabel lblEmail = new JLabel("E-mail:");
		panel_7.add(lblEmail);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		contentPane.add(panel_18);
		panel_18.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_18.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_18.add(panel_20);
		
		JLabel lblSenha = new JLabel("Senha:");
		panel_18.add(lblSenha);
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField);
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		panel_8.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_8.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_8.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_8.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_8.add(panel_17);
		
		JPanel panel_21 = new JPanel();
		panel_8.add(panel_21);
		
		JButton btnVoltar = new JButton("Voltar");
		panel_8.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuBibliotecarioUI menuFrame = new MenuBibliotecarioUI();
				menuFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Cadastrar");
		panel_9.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeCompleto = textField.getText();
				String idade = textField_3.getText();
				String telefone = textField_1.getText();
				String email = textField_2.getText();
				String senha = new String(passwordField.getPassword());
				Cliente clienteAux = new Cliente(nomeCompleto, idade, email, telefone, senha);
				ClienteDAO dao = new ClienteDAO();
				dao.cadastrar(clienteAux);
				JOptionPane.showMessageDialog(panel, "Cliente cadastrado com sucesso!");
				MenuBibliotecarioUI menuFrame = new MenuBibliotecarioUI();
				menuFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		
	}

}
