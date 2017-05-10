package java12_absendenaufgabe;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator_launcher extends Application{
	@Override
	public void start(Stage meineStage) throws Exception{
		FXMLLoader meinLoader = new FXMLLoader(getClass().getResource("sb_calculator.fxml"));
		Parent root = meinLoader.load();
		Calculator_Controller meinController = meinLoader.getController();
		meinController.setStage(meineStage);
		
		Scene meineScene = new Scene(root, 400, 250);
				
		meineStage.setTitle("Rechner mit FXML");
		meineStage.setScene(meineScene);
		meineStage.show();
	}
	

	
	public static void main(String[] args){
		launch(args);
		
	}
}
