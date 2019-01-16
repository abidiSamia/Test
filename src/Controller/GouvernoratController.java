/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Gouvernorat;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrateur
 */
public class GouvernoratController {
    

    @FXML
    private Label label;
    
    @FXML
    private TextField wid;
    @FXML
    private TextField wlibelle_gouvernorat;
    @FXML
    private Button btajouter;
    
    
    static Connection con;
	//La méthode getConnexion nous permet d'éviter l'ecriture du code de connexion à chaque opération de CRUD avec la base
	public static Connection getConnection()
	{
	    try
	    {
	    	
	    	//Vérifier l'existance de MySQL JDBC Driver
	    	Class.forName("com.mysql.jdbc.Driver");
	    	//l'URL de la connexion**le nom de la machine physique(ou l@ IP) est suivi du numéro de port utilisé**Le nom de la base de donnée
	    	String url="jdbc:mysql://localhost:3307/heb_etudiants";
	    	//Etablir une connexion avec la base
	    	con= (Connection) DriverManager.getConnection(url,"root","");
	    	//Message
	    	//System.out.println("Connected");
	    	
	    }
	    catch(ClassNotFoundException | SQLException e)
	    {
	    	//On va affcher une fenetre qui indique la nature de l'exception 
	    	JOptionPane.showMessageDialog(null,"Erreur dans la connexion : "+e);
	    	
	    }
		return con;
	}
	/////////////////////////////////////////////
    //Methode enregistrer pour ajouter un employé
        @FXML
	public  int enregistrer(ActionEvent event)
	{
            int st=0;
		
		
		try
		{
	           String sql="INSERT INTO `gouvernorat`( `id`, `libelle_gouvernorat`) VALUES (?,?)";
		    Connection con=GouvernoratController.getConnection();
		    PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement(sql);
		    preparedStatement.setInt(1, Integer.parseInt(wid.getText().toString()));
		    preparedStatement.setString(2,wlibelle_gouvernorat.getText().toString());
		
		    
		    //Executer la requête 
		    st=preparedStatement.executeUpdate();
		    //Fermeture de la connexion avec la base de données
		    con.close();
		    JOptionPane.showMessageDialog(null,"Ajout avec succès");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return st;
	}
	///////////////////////////////////////////////////////////////////
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       
    }
    
      
    

}