package br.edu.ifsc.ProjetoAutenticacao;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.codec.binary.Hex;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

	@FXML
	private TextField txtUsuario, txtSenha;

	@FXML
	private JFXButton btAvancar, btCadastrar;

	public void clique(ActionEvent e) throws IOException {
		Button btClicado = (Button) e.getSource();

		if (btClicado == btCadastrar) {
			App.setRoot("register");
		} else {

			if (txtUsuario.getText().isBlank() || txtSenha.getText().isBlank()) {
				Alert errorALert = new Alert(AlertType.WARNING);
				errorALert.setContentText("Preencha o nome de usuario e senha");
				errorALert.showAndWait();
			} else {
				if (verificaLogin(txtUsuario.getText(), txtSenha.getText()))
					App.setRoot("confirmed");
			}
		}
	}

	private boolean verificaLogin(String nomeUsuario, String senha) {
		HashMap<String, Usuario> usuarios = Usuario.usuarios.getListaUsuarios();

		if (usuarios.containsKey(nomeUsuario)) {
			if (verificaSenhaHash(senha, usuarios.get(nomeUsuario).getSenha(), usuarios.get(nomeUsuario).getSal())) {

				System.out.println("usuario entrou: " + usuarios.get(nomeUsuario));
				return true;
			} else {
				Alert errorALert = new Alert(AlertType.ERROR);
				errorALert.setContentText("Senha incorreta");
				errorALert.showAndWait();
			}

		} else {
			Alert errorALert = new Alert(AlertType.ERROR);
			errorALert.setContentText("Usuário não cadastrado");
			errorALert.showAndWait();
		}
		return false;
	}

	private boolean verificaSenhaHash(String senha, String senha_usuario, String sal) {

		int interacoes = 10000;
		int chaveTamanho = 400;
		char[] senhaChars = senha.toCharArray();
		byte[] salBytes = sal.getBytes();

		byte[] hashBytes = Usuario.senhaHash(senhaChars, salBytes, interacoes, chaveTamanho);
		String hashString = Hex.encodeHexString(hashBytes);

		if (hashString.contentEquals(senha_usuario))
			return true;

		return false;
	}
}
