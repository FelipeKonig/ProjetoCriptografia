module br.edu.ifsc.ProjetoAutenticacao {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.jfoenix;
	requires javafx.base;
	requires commons.codec;

    opens br.edu.ifsc.ProjetoAutenticacao to javafx.fxml;
    exports br.edu.ifsc.ProjetoAutenticacao;
}