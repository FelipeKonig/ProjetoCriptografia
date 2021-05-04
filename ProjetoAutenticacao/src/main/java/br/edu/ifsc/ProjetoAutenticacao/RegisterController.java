package br.edu.ifsc.ProjetoAutenticacao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController {

	@FXML
	private TextField txtUsuario, txtSenha;

	@FXML
	private JFXButton btCadastrar, btVoltar;

	public void clique(ActionEvent e) throws IOException {
		Button btClicado = (Button) e.getSource();
		if (btClicado == btCadastrar) {

			if (txtUsuario.getText().isBlank() || txtSenha.getText().isBlank()) {
				Alert errorALert = new Alert(AlertType.WARNING);
				errorALert.setContentText("Preencha o nome de usuario e senha");
				errorALert.showAndWait();
			} else {
				if(verificarUsuario(txtUsuario.getText()))
					App.setRoot("login");
			}

		}
	}

	private boolean verificarUsuario(String nomeUsuario) {
		HashMap<String, Usuario> usuarios = Usuario.usuarios.getListaUsuarios();

		if (usuarios.containsKey(nomeUsuario)) {
			Alert errorALert = new Alert(AlertType.ERROR);
			errorALert.setContentText("Usuario ja cadastrado com esse nome");
			errorALert.showAndWait();
		} else {
			String sal = nomeUsuario;
			String senhaHash = criarSenhaHash(txtSenha.getText(), sal);
			Usuario novoUsuario = new Usuario(nomeUsuario, senhaHash, sal);
			usuarios.put(nomeUsuario, novoUsuario);
			System.out.println("novo usuario adicionado: " + novoUsuario);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Usuario cadastrado");
			alert.showAndWait();
			return true;
		}
		return false;
	}

	private String criarSenhaHash(String senha, String sal) {

		int interacoes = 10000;
		int chaveTamanho = 400;
		char[] senhaChars = senha.toCharArray();
		byte[] salBytes = sal.getBytes();

		byte[] hashBytes = Usuario.senhaHash(senhaChars, salBytes, interacoes, chaveTamanho);
		String hashString = Hex.encodeHexString(hashBytes);

		return hashString;
	}
}
