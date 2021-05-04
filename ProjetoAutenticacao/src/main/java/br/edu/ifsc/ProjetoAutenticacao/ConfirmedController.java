package br.edu.ifsc.ProjetoAutenticacao;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConfirmedController {
	
	@FXML
	private JFXButton btVoltar;
	
	public void clique(ActionEvent e) throws IOException {
		Button btClicado = (Button) e.getSource();
		if (btClicado == btVoltar) {
			App.setRoot("login");
		} 
	}

}
