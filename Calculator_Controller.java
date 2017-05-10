package java12_absendenaufgabe;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx_texteditor.JavaFX_InfoDialog;

public class Calculator_Controller {
	private Stage meineStage;
	private int operation;
	@FXML private TextField eingabe1, eingabe2;
	@FXML public Label ergebnisLabel;
	
	@FXML protected void beendenKlick(ActionEvent event){
		Platform.exit();
	}
		
	@FXML protected void additionKlick(ActionEvent event){
		operation = 0;
	}
	
	@FXML protected void substraktionKlick(ActionEvent event){
		operation = 1;
	}
	
	@FXML protected void multiplikationKlick(ActionEvent event){
		operation = 2;
	}
	
	@FXML protected void divisionKlick(ActionEvent event){
		operation = 3;
	}	
	
	//Zeichenkette zurück
	@FXML protected void berechnen() {
		double zahl1= 0, zahl2=0, ergebnis=0;
			//ergebnis muss initialisiert werden
			boolean fehlerFlag = false;
			//jetzt mit Fehlerbehandlung und Ausgabe der Meldung durch eine eigene Methode
			try {
				zahl1 = Double.parseDouble(eingabe1.getText());
			}
			catch (Exception NumberFormatException) {
				//fehlermeldung(eingabe1);
				ergebnisLabel.setText("Nicht definiert");
			}
			
			try {
				zahl2 = Double.parseDouble(eingabe2.getText());
			}
			catch (Exception NumberFormatException) {
				//fehlermeldung(eingabe2);
				//das Ergebnis ist nicht definiert
				ergebnisLabel.setText("Nicht definiert");
			}
			//welche Operation ist ausgewählt?
			if (operation==0)
				ergebnis = zahl1 + zahl2;
			if (operation==1)
				ergebnis = zahl1 - zahl2;
			if (operation==2)
				ergebnis = zahl1 * zahl2;
			//bei der Division überprüfen wir den zweiten Wert auf 0
			if (operation==3) {
				if (zahl2 != 0)
					ergebnis = zahl1 / zahl2;
				else 
					fehlerFlag = true;
			}
			//wenn es keine Probleme gegeben hat, liefern wir das Ergebnis zurück
			if (fehlerFlag == false) {
				//die Formatvorgabe über die Klasse DecimalFormat
				DecimalFormat formatFolge = new DecimalFormat("0.##");
				//das Format anwenden, das Ergebnis ist eine Zeichenkette
				ergebnisLabel.setText(formatFolge.format(ergebnis));
			}
			else
				ergebnisLabel.setText("Nicht definiert");
		}
		
		/*private void fehlermeldung(JTextField eingabefeld) {
			JOptionPane.showMessageDialog(this, "Ihre Eingabe ist nicht gültig","Eingabefehler", JOptionPane.ERROR_MESSAGE);
			eingabefeld.requestFocus();
		}*/
			
	
	@FXML protected void dialogKlick(ActionEvent event){
		JavaFX_Dialog meinDialog = new JavaFX_Dialog(meineStage);
		meinDialog.setzeInfo("Hinweis", 
				"Antwort 42", 
				"Egal was das Ergebnis der Berechnung ist, Antwort auf die Frage nach dem Leben, dem Universum und dem ganzen Rest ist 42.");
		meinDialog.dialogZeigen();
		ergebnisLabel.setText(Dialog_Controller.getAntwort());
		
	}
	
	public void setStage(Stage meineStage){
		this.meineStage = meineStage;
	}

}
