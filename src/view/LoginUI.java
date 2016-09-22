package view;

import persistence.BibliotecarioDAO;
import persistence.ClienteDAO;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bibliotecario;
import model.Cliente;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("E-mail:");
		panel_7.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField = new JTextField();
		textField.setText("");
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(logar()){
					if(escolherMenu() == 0){
						MenuBibliotecarioUI frameB = new MenuBibliotecarioUI();
						frameB.setVisible(true);
						setVisible(false);
					}else{
					MenuClienteUI frameN = new MenuClienteUI();
					frameN.setVisible(true);
					setVisible(false);
					}
				}else{
					JOptionPane.showMessageDialog(panel, "Login Inválido");
				}
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
	}
	public int escolherMenu(){
		int escolherMenu = 3;
		String email = textField.getText();
		char[] senhaC = passwordField.getPassword();
		String senha = "";
		for (int i = 0; i < senhaC.length; i++) {
			senha = senha + "" + senhaC[i];
		}
		ClienteDAO dao = new ClienteDAO();
		ArrayList<Cliente> daoAL = dao.listar();
		for (Cliente cliente : daoAL) {
			if(cliente.getEmail().equalsIgnoreCase(email)){
				escolherMenu = 1;
			}
		}
		BibliotecarioDAO dao2 = new BibliotecarioDAO();
		ArrayList<Bibliotecario> daoB = dao2.listar();
		for (Bibliotecario bibliotecario : daoB) {
			if(bibliotecario.getEmail().equalsIgnoreCase(email)){
				escolherMenu = 0;
			}
		}
		return escolherMenu;
		}
	public boolean logar(){
		String email = textField.getText();
		char[] senhaC = passwordField.getPassword();
		String senha = "";
		for (int i = 0; i < senhaC.length; i++) {
			senha = senha + "" + senhaC[i];
		}
		boolean emailValido = false;
		boolean senhaValida = false;
		ClienteDAO dao = new ClienteDAO();
		ArrayList<Cliente> daoAL = dao.listar();
		for (Cliente cliente : daoAL) {
			if(cliente.getEmail().equalsIgnoreCase(email)){
				emailValido = true;
			}
			if(cliente.getSenha().equals(senha)){
				senhaValida = true;
			}
		}
		BibliotecarioDAO dao2 = new BibliotecarioDAO();
		ArrayList<Bibliotecario> daoB = dao2.listar();
		for (Bibliotecario bibliotecario : daoB) {
			if(bibliotecario.getEmail().equalsIgnoreCase(email)){
				emailValido = true;
			}
			if(bibliotecario.getSenha().equals(senha)){
				senhaValida = true;
			}
		}
		if(emailValido && senhaValida){
			return true;
		}else{
			return false;
		}
	}

}
