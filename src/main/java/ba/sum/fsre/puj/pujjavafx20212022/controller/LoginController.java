package ba.sum.fsre.puj.pujjavafx20212022.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Label errorMsg;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    protected void onLogin() {
        String username = this.usernameTxt.getText().toString();
        String password = this.passwordTxt.getText().toString();

        if (username.equals("") || password.equals("")){
            this.errorMsg.setText("Morate unijeti sva polja!");
        } else {
            this.errorMsg.setText("");
        }
    }
}