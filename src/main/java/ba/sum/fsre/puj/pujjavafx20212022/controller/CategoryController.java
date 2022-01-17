package ba.sum.fsre.puj.pujjavafx20212022.controller;

import ba.sum.fsre.puj.pujjavafx20212022.model.Category;
import ba.sum.fsre.puj.pujjavafx20212022.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @FXML
    TextField categoryNameTxt;

    @FXML
    TableView categoryTbl;

    @FXML
    TableColumn categoryIDCol;

    @FXML
    TableColumn categoryNameCol;

    @FXML
    Button addCategoryBtn;

    Category selectedCategory = null;

    @FXML
    protected void addCategory (){
        String name = this.categoryNameTxt.getText();
        if (name.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Molimo unesite naziv kategorije!", ButtonType.OK);
            alert.setTitle("Upozorenje");
            alert.setHeaderText("Greška s unosom!");
            alert.showAndWait();
        } else
            if (this.selectedCategory == null){
                Category c = new Category();
                c.setName(name);
                try {
                    c.save();
                    this.categoryNameTxt.setText("");
                    this.fillCategories();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                this.selectedCategory.setName(name);
                try {
                    this.selectedCategory.update();
                    this.removeSelection();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.categoryIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.categoryNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.fillCategories();
    }

    private void fillCategories(){
        try {
            List<?> categoriesList = Table.list(Category.class);
            ObservableList<?> categoriesObservableList = FXCollections.observableList(categoriesList);
            this.categoryTbl.setItems(categoriesObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void deleteCategory(){
        if (selectedCategory != null){
            try {
                selectedCategory.delete();
                this.fillCategories();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    protected void selectCategory(){
        this.selectedCategory = (Category) this.categoryTbl.getSelectionModel().getSelectedItem();
        this.addCategoryBtn.setText("Uredi kategoriju");
        this.categoryNameTxt.setText(this.selectedCategory.getName());
    }

    @FXML
    protected void removeSelection(){
        this.selectedCategory = null;
        this.fillCategories();
        this.addCategoryBtn.setText("Dodaj kategoriju");
        this.categoryNameTxt.setText("");
    }
}
