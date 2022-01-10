package ba.sum.fsre.puj.pujjavafx20212022.controller;

import ba.sum.fsre.puj.pujjavafx20212022.model.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CategoryController {
    @FXML
    TextField categoryNameTxt;

    @FXML
    protected void addCategory (){
        String name = this.categoryNameTxt.getText();
        Category c = new Category();
        c.setName(name);
        try {
            c.save();
            this.categoryNameTxt.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
