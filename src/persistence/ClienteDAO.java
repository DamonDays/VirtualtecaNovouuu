package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.IPersistence;
import model.Cliente;
import util.Constantes;

public class ClienteDAO implements IPersistence<Cliente> {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	@Override
	public void cadastrar(Cliente cliente) {
		clientes.add(cliente);
		gravarArquivo();
	}

	@Override
	public ArrayList<Cliente> listar() {
		return clientes;
	}

	private void gravarArquivo() {
		File f = new File(Constantes.ARQUIVO_DE_CLIENTES);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for (Cliente c : clientes) {
				bw.write(c.getNome() + ";" + c.getIdade() + ";" + c.getEmail() + ";" + c.getTelefone() + ";" + c.getSenha());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static {
		File f = new File(Constantes.ARQUIVO_DE_CLIENTES);

		FileReader fr = null;
		BufferedReader br = null;

		try {
			if (!f.exists())
				f.createNewFile();

			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String linha;
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(";");

				Cliente c = new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4]);
				clientes.add(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
