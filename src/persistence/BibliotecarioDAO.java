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
import model.Bibliotecario;
import util.Constantes;

public class BibliotecarioDAO implements IPersistence<Bibliotecario> {
	private static ArrayList<Bibliotecario> bibliotecarios = new ArrayList<Bibliotecario>();

	@Override
	public void cadastrar(Bibliotecario bibliotecario) {
		bibliotecarios.add(bibliotecario);
		gravarArquivo();
	}

	@Override
	public ArrayList<Bibliotecario> listar() {
		return bibliotecarios;
	}

	private void gravarArquivo() {
		File f = new File(Constantes.ARQUIVO_DE_BIBLIOTECARIOS);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for (Bibliotecario b : bibliotecarios) {
				bw.write(b.getNome() + ";" + b.getIdade() + ";" + b.getEmail() + ";" + b.getTelefone() + ";" + b.getSenha());
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
		File f = new File(Constantes.ARQUIVO_DE_BIBLIOTECARIOS);

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

				Bibliotecario c = new Bibliotecario(dados[0], dados[1], dados[2], dados[3], dados[4]);
				bibliotecarios.add(c);
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

