/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author Administrateur
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField wcin;
    
    @FXML
    private Button btGouvernorat;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        label.setText(wcin.getText().toString());
    }
    
    @FXML
    private void ViewGouvernorat(ActionEvent event) throws IOException {
            ((Node)(event.getSource())).getScene().getWindow().hide();
             Parent parent=FXMLLoader.load(getClass().getResource("/View/GouvernoratView.fxml"));
             Stage stage=new Stage();
             Scene scene=new Scene(parent);
             stage.setScene(scene);
             stage.show();
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
