package br.edu.ifsc.ProjetoAutenticacao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Usuario {

	public static Usuario usuarios = new Usuario();

	private String usuario, senha, sal;
	private HashMap<String, Usuario> listaUsuarios;

	public Usuario() {
	}

	public Usuario(String usuario, String senha, String sal) {
		this.usuario = usuario;
		this.senha = senha;
		this.sal = sal;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getSal() {
		return sal;
	}

	public HashMap<String, Usuario> getListaUsuarios() {
		if (this.listaUsuarios == null)
			listaUsuarios = new HashMap<String, Usuario>();
		return listaUsuarios;
	}

	public static byte[] senhaHash(final char[] senha, final byte[] sal, final int interacoes, final int chaveTamanho) {

		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(senha, sal, interacoes, chaveTamanho);
			SecretKey chave = skf.generateSecret(spec);
			byte[] res = chave.getEncoded();
			return res;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return "\n Usuario [nome de usuario=" + usuario + ", sal=" + sal + ", senha=" + senha + "]" + "\n";
	}

}
