package java12_absendenaufgabe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class Dialog_Controller {

	
@FXML private Label messageLabel, detailsLabel;
	
	private Stage meineStage;
	private static String antwort="";
	
	@FXML protected void onNoKlick(ActionEvent event){
		antwort = ("");		
		meineStage.close();
	}
	
	
	@FXML protected void onYesKlick(ActionEvent event){
		antwort = ("42");
		meineStage.close();
	}
	
	public static String getAntwort(){
		return antwort;
	}
	

	public void setStage(Stage meineStage){
		this.meineStage = meineStage;
	}
	
	public void setUeberschrift(String ueberschrift){
		messageLabel.setText(ueberschrift);
	}
	
	public void setInfoText(String infoText){
		detailsLabel.setText(infoText);
	}
}
