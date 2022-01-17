package ba.sum.fsre.puj.pujjavafx20212022.controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label errorMsg;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    protected void onLogin() throws IOException {
        String username = this.usernameTxt.getText().toString();
        String password = this.passwordTxt.getText().toString();

        if (username.equals("") || password.equals("")){
            this.errorMsg.setText("Morate unijeti sva polja!");
        } else {
            this.errorMsg.setText("");
            Main.showWindow(
                    "category.fxml",
                    "Administracija kategorija", 600, 215);
        }
    }
}