package Sommatif;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SampleController implements Initializable {

// Acceuil
 
//Identiter
@FXML
 private AnchorPane BF2;//Bouton de Fermeture

 //Longeur

//Identiter
 
 @FXML
private Tab Longeur;

@FXML
private TextField LongeurC; 

@FXML
private Button BFL;

@FXML
private Button LSMaLSI;

@FXML
private Button LSIaLSM;

@FXML
private TextField LongeurVN;

@FXML
private ComboBox<String> LongeurSI;

@FXML
private ComboBox<String> LongeurSM;

//Masse

//Identiter

@FXML
private Button BFM;


@FXML
private Button MSIaMSM;

@FXML
private Button MSMaMSI;

@FXML
private TextField MasseVN;

@FXML
private TextField MasseC;

@FXML
private ComboBox<String> MasseSI;

@FXML
private Tab Masse;

@FXML
private ComboBox<String> MasseSM;

//Volume

//Identiter

@FXML
private Button BFV;

@FXML
private Button VSMaVSI;

@FXML
private Button VSIaVMS;

@FXML
private TextField VolumeVN;

@FXML
private ComboBox<String> VolumeSM;

@FXML
private TextField VolumeC;

@FXML
private Tab Volume;

@FXML
private ComboBox<String> VolumeSI;


 //Alert

 //La liste et tableau des combos boxes:
    

    
 //Longeur:
 
 public ObservableList<String>listLM=FXCollections.observableArrayList("​Kilomètre","Hectomètre","​Décamètre","Mètre","Décimètre","Centimètre","​Millimètre");
 public ObservableList<String>listLI=FXCollections.observableArrayList("Mile","Yard","Pied","Pouce", "Mile nautique");
 //Tableau
 double[]LongeurLM= {1000,100,10,1,0.1,0.01,0.001};
 double[]LongeurLI= {0.000621371,1.09361,3.28084,39.3701,0.000539957};

 //Masse:
 
 public ObservableList<String>listMM=FXCollections.observableArrayList("​Kilogramme","Hectogramme","​Décagramme","Gramme","​Décigramme","Centigramme","​Milligramme");
 public ObservableList<String>listMI=FXCollections.observableArrayList("Tonne Imperial","Livre","Once","Stone");
 //Tableau
 double []MasseMM= {1000,100,10,1,0.1,0.01,0.001};
 double []MasseMI= {1000000,453.592,28.3495,6350.29};

 //Volume:
 
 public ObservableList<String>listVM=FXCollections.observableArrayList("​Kilomètre Cube ","​Hectomètre Cube ","​Décamètre Cube ","Mètre cube","Décimètre Cube","Centimètre Cube","​Millimètre Cube");
 public ObservableList<String>listVI=FXCollections.observableArrayList("Gallon","Litre","Pinte","Tasse","Once liquide","Cuillerée à soupe","Cuillère à café"); 
 //Tableau
 double []VolumeVM= {1000000000,1000000,1000,1,0.001,0.000001,0.000000001};
 double []VolumeVI= {0.00454609,0.001,0.000568261,0.000284131,0.000028413,0.000017758,0.0000059194};


 
 @Override
	public void initialize(URL location, ResourceBundle resources) {
   
    	//La liste dans les combos boxes
    	
    	// Longeur:
    	
    	LongeurSM.setItems(listLM);	
    	LongeurSI.setItems(listLI);
    	LongeurSM.getSelectionModel().selectFirst();	
    	LongeurSI.getSelectionModel().selectFirst();
    	
    	//Masse:
    	
    	MasseSM.setItems(listMM);
    	MasseSI.setItems(listMI);
    	MasseSM.getSelectionModel().selectFirst();
    	MasseSI.getSelectionModel().selectFirst();
    	
    	//Volume:
    	
    	VolumeSM.setItems(listVM);
    	VolumeSI.setItems(listVI);
    	VolumeSM.getSelectionModel().selectFirst();
    	VolumeSI.getSelectionModel().selectFirst();
 }
 // Pour que le programme prends seuleument les valeurs numerique
 public void verifNum(TextField a){
 {
 if(a.getText().equals("")) a.setText("0");
 a.textProperty().addListener((observable,oldValue,newValue)->
 {
 if(!newValue.matches("^[0-9](\\.[0-9]+)?$"))
 {
 a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
 }
 });}}

 //Les calculs pour la conversion des longeurs
 @FXML
 void CalculLongeur()
 {
	 
	 try {
		
		 int Long1=LongeurSM.getSelectionModel().getSelectedIndex();
		 int Long2=LongeurSI.getSelectionModel().getSelectedIndex();
		 double taux=LongeurLM[Long1]*LongeurLI[Long2];
		 double conversion=taux*(Double.parseDouble(LongeurVN.getText()));
		 LongeurC.setText(String.format("%.2f", conversion));
	
	 } catch (NumberFormatException e)   // catch block
		
		{
			Alert alert=new Alert(AlertType.ERROR);//Alert
			alert.setHeaderText("Attention, vous avez commis une erreur");
			alert.setTitle("Une erreur a été commise");
			alert.setContentText("Vous avez écrit une valeur non numérique dans la case sélectionnée. Veuillez corriger votre erreur pour poursuivre le programme de conversion. Si vous souhaitez partir, veuillez appuyer sur le bouton dans le coin inférieur droit nommé Fermer");
			alert.show();
			LongeurC.requestFocus();
			
	 
		}}
	 
	 
 
 @FXML
 void CalculLongeur2()
 {
	 try {
		
		 int Long1=LongeurSI.getSelectionModel().getSelectedIndex();
		 int Long2=LongeurSM.getSelectionModel().getSelectedIndex();
		 double tauxLongeur=LongeurLI[Long1]*LongeurLM[Long2];
		 double conversionLongeur=tauxLongeur*(Double.parseDouble(LongeurC.getText()));
		 LongeurVN.setText(String.format("%.2f", conversionLongeur));
	
	 } catch (NumberFormatException e) { // catch block
		
		
		{
			Alert alert=new Alert(AlertType.ERROR);//Alert
			alert.setHeaderText("Attention, vous avez commis une erreur");
			alert.setTitle("Une erreur a été commise");
			alert.setContentText("Vous avez écrit une valeur non numérique dans la case sélectionnée. Veuillez corriger votre erreur pour poursuivre le programme de conversion. Si vous souhaitez partir, veuillez appuyer sur le bouton dans le coin inférieur droit nommé Fermer");
			alert.show();
			LongeurVN.requestFocus();
			
		}
	 }
 }
 
 // Les calculs pour les convertions de masse
 
 
 @FXML
 void CalculMasse()
 {
	 
	 try {
		
		 int Masse1= MasseSM.getSelectionModel().getSelectedIndex();
		 int Masse2= MasseSI.getSelectionModel().getSelectedIndex();
		 double tauxMasse=MasseMM[Masse1]/MasseMI[Masse2];
		 double conversionMasse=tauxMasse*(Double.parseDouble(MasseVN.getText()));
		 MasseC.setText(String.format("%.2f", conversionMasse));
	
	 } catch (NumberFormatException e) // catch block
		
	 {
		Alert alert=new Alert(AlertType.ERROR);//Alert
		alert.setHeaderText("Attention, vous avez commis une erreur");
		alert.setTitle("Une erreur a été commise");
		alert.setContentText("Vous avez écrit une valeur non numérique dans la case sélectionnée. Veuillez corriger votre erreur pour poursuivre le programme de conversion. Si vous souhaitez partir, veuillez appuyer sur le bouton dans le coin inférieur droit nommé Fermer");
		alert.show();
		MasseC.requestFocus();
		
	 }
	 
 } 
	 
 @FXML
 void CalculMasse2()
 {
	 try {
		
		 int Masse1= MasseSI.getSelectionModel().getSelectedIndex();
		 int Masse2= MasseSM.getSelectionModel().getSelectedIndex();
		 double tauxMasse=MasseMI[Masse1]/MasseMM[Masse2];
		 double conversionMasse=tauxMasse*(Double.parseDouble(MasseC.getText()));
		 MasseVN.setText(String.format("%.2f", conversionMasse));
	
	 } catch (NumberFormatException e)  //catch block
		
	
	 {
			Alert alert=new Alert(AlertType.ERROR);//Alert
			alert.setHeaderText("Attention, vous avez commis une erreur");
			alert.setTitle("Une erreur a été commise");
			alert.setContentText("Vous avez écrit une valeur non numérique dans la case sélectionnée. Veuillez corriger votre erreur pour poursuivre le programme de conversion. Si vous souhaitez partir, veuillez appuyer sur le bouton dans le coin inférieur droit nommé Fermer");
			alert.show();
			MasseVN.requestFocus();
		
	 }
 }	
 

 // Les calculs pour les conversions de Volume
 
 @FXML
 void CalculVolume()
 {
	 
	 try {
		
		 int Volume1= VolumeSM.getSelectionModel().getSelectedIndex();
		 int Volume2= VolumeSI.getSelectionModel().getSelectedIndex();
		 double tauxVolume=VolumeVM[Volume1]*VolumeVI[Volume2];
		 double conversionVolume=tauxVolume*(Double.parseDouble(VolumeVN.getText()));
		 VolumeC.setText(String.format("%.2f", conversionVolume));
	
	 } catch (NumberFormatException e) //catch block
		
	
	 {
			Alert alert=new Alert(AlertType.ERROR);//Alert
			alert.setHeaderText("Attention, vous avez commis une erreur");
			alert.setTitle("Une erreur a été commise");
			alert.setContentText("Vous avez écrit une valeur non numérique dans la case sélectionnée. Veuillez corriger votre erreur pour poursuivre le programme de conversion. Si vous souhaitez partir, veuillez appuyer sur le bouton dans le coin inférieur droit nommé Fermer");
			alert.show();
			VolumeC.requestFocus();
			
	 }
 }
	 
 @FXML
 void CalculVolume2()
 {
	 try {
		
		 int Volume1= VolumeSI.getSelectionModel().getSelectedIndex();
		 int Volume2= VolumeSM.getSelectionModel().getSelectedIndex();
		 double tauxVolume=VolumeVI[Volume1]*VolumeVM[Volume2];
		 double conversionVolume=tauxVolume*(Double.parseDouble(VolumeC.getText()));
		 VolumeVN.setText(String.format("%.2f", conversionVolume));
	
	 } catch (NumberFormatException e) // catch block
		
	
	 {
			Alert alert=new Alert(AlertType.ERROR);//Alert
			alert.setHeaderText("Attention, vous avez commis une erreur");
			alert.setTitle("Une erreur a été commise");
			alert.setContentText("Vous avez écrit une valeur non numérique dans la case sélectionnée. Veuillez corriger votre erreur pour poursuivre le programme de conversion. Si vous souhaitez partir, veuillez appuyer sur le bouton dans le coin inférieur droit nommé Fermer");
			alert.show();
			VolumeVN.requestFocus();
			
	 }
 }	 
 
//Button de sortie:
   
    @FXML
   private void Fermer()
   
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);//Confirmation pour quitter
    	alert.setHeaderText("Confirmation");
    	alert.setTitle("Avertissement");
    	alert.setContentText("Etes-vous sûr de vouloir quitter le convertisseur?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK)
    	{
    	System.exit(0);
    	}
		 
 
 
 
 }


}

    