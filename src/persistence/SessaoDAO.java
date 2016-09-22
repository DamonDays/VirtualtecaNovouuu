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
import model.Sessao;
import util.Constantes;

public class SessaoDAO implements IPersistence<Sessao> {

	private static ArrayList<Sessao> sessoes = new ArrayList<Sessao>();

	@Override
	public void cadastrar(Sessao sessao) {
		sessoes.add(sessao);
		gravarArquivo();
	}

	@Override
	public ArrayList<Sessao> listar() {
		return sessoes;
	}

	private void gravarArquivo() {
		File f = new File(Constantes.ARQUIVO_DE_SESSOES);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for (Sessao s : sessoes) {
				bw.write(s.getIdentificacao() + ";" + s.getNome() + ";" + s.getIdentificacaoEstante());
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
		File f = new File(Constantes.ARQUIVO_DE_SESSOES);

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
				Sessao c = new Sessao(dados[0], dados[1], dados[2]);
				sessoes.add(c);
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
