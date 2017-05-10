package java12_absendenaufgabe;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx_texteditor.FXMLControllerInfoDialog;

public class JavaFX_Dialog extends Stage {
	private Dialog_Controller meinController;
	
	
	public JavaFX_Dialog(Stage fenster){
		super();
		initOwner(fenster);
		FXMLLoader meinLoader = new FXMLLoader(getClass().getResource("sb_dialog.fxml"));
		try{
			Parent root = meinLoader.load();
			meinController = meinLoader.getController();
			Scene meineScene = new Scene(root, 600, 150);
			setScene(meineScene);
			initModality(Modality.WINDOW_MODAL);
			initStyle(StageStyle.UTILITY);
			meinController.setStage(this);
		}
		catch (IOException e){
			System.out.println("Die Datei könnte nicht geladen werden");
		}
	}
	
	public void setzeInfo(String titel, String ueberschrift, String infoText){
		setTitle(titel);
		meinController.setUeberschrift(ueberschrift);
		meinController.setInfoText(infoText);
	}
	
	
	public void dialogZeigen(){
		showAndWait();
	}
}
