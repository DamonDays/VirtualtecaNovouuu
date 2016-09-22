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
import model.Estante;
import util.Constantes;

public class EstanteDAO implements IPersistence<Estante> {

	private static ArrayList<Estante> estantes = new ArrayList<Estante>();

	@Override
	public void cadastrar(Estante estante) {
		estantes.add(estante);
		gravarArquivo();
	}

	@Override
	public ArrayList<Estante> listar() {
		return estantes;
	}

	private void gravarArquivo() {
		File f = new File(Constantes.ARQUIVO_DE_ESTANTES);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for (Estante e : estantes) {
				bw.write(e.getIdentificacao() + ";" + e.getCapacidade());
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
		File f = new File(Constantes.ARQUIVO_DE_ESTANTES);

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
				Estante c = new Estante(Integer.parseInt(dados[0]), Integer.parseInt(dados[2]));
				estantes.add(c);
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
