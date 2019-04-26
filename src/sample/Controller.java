package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sun.font.TextLabel;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public static String usuari1 = "Usuari";
    public static String nom1 = "Nom";
    public static String cognom1 = "Cognom";
    public static String direccio1 = "Direccio";
    public static String poblacio1 = "Poblacio";
    public static String cp1 = "CodiPostal";
    public static String pais1 = "Pais";
    public static String neixement1 = "DataNeixement";
    public static String correu1 = "Correu";
    public static String clau1 = "Clau";
    public static String buscador1 = "Buscador";

    @FXML ChoiceBox<String> pais;
    @FXML TextArea akitext;





    public void pressRegistrarBtn(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(1);

        ObservableList<String> list = FXCollections.observableArrayList("Afganistán", "Albania", "Alemania", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia");

        ChoiceBox<String> choiceBox = (ChoiceBox<String>) sm.getCurrentScene().lookup("#pais");
        choiceBox.setItems(list);


    }

    public void clauPerduda(ActionEvent event) throws IOException{
        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(2);


    }

    public void launchBuscar(ActionEvent event) throws IOException{

        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(3);
        TextField textField1 = (TextField) sm.getCurrentScene().lookup("#find");
        buscador1 = String.valueOf(textField1.getText());

        if (buscador1.equals("Cep")){

            sm.getCurrentScene().getStylesheets().add(getClass().getResource("cep.css").toExternalForm());
        }


    }
    public void pressAccedirBtn(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(3);
       // sm.getCurrentScene().getStylesheets().add(getClass().getResource("buscador.css").toExternalForm());

    }

    public void cancelaClau(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(0);

    }

    public void enviaclau(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();

        TextField textField1 = (TextField) sm.getCurrentScene().lookup("#correu");
        correu1 = String.valueOf(textField1.getText());

        TextField textField2 = (TextField) sm.getCurrentScene().lookup("#correu");
        clau1 = String.valueOf(textField2.getText());

        if (correu1.isEmpty() || clau1.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Advertència");
            alert.setHeaderText("S'han d'omplir tots els camps.");
            alert.showAndWait();
        }
        else  if (!(correu1.isEmpty() || clau1.isEmpty())){
            String emailRegEx;
            Pattern pattern;

            emailRegEx = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";

            pattern = Pattern.compile(emailRegEx);
            Matcher matcher = pattern.matcher(correu1);
            if (!matcher.find()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Advertència:");
                alert.setHeaderText("El correu no es vàlid.");
                alert.showAndWait();
            } else {
                //System.out.println(correu1);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Enviat al correu:");
                alert.setHeaderText(correu1);
                alert.showAndWait();
                sm.changeSceneLevel(0);
            }
        }




    }

    public void pressTornarBtn(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(0);
    }


    public void cancelRecover(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(0);
    }

    public void gotoRecover(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();
        sm.changeSceneLevel(2);
    }

    public void pressRegistremBtn(ActionEvent event) throws IOException {
        SceneManager sm = SceneManager.getInstance();
        TextField textField1 = (TextField) sm.getCurrentScene().lookup("#usuari");
        usuari1 = String.valueOf(textField1.getText());
        TextField textField2 = (TextField) sm.getCurrentScene().lookup("#nom");
        nom1 = String.valueOf(textField2.getText());
        TextField textField3 = (TextField) sm.getCurrentScene().lookup("#cognom");
        cognom1 = String.valueOf(textField3.getText());
        TextField textField4 = (TextField) sm.getCurrentScene().lookup("#direccio");
        direccio1 = String.valueOf(textField4.getText());
        TextField textField5 = (TextField) sm.getCurrentScene().lookup("#poblacio");
        poblacio1 = String.valueOf(textField5.getText());
        TextField textField6 = (TextField) sm.getCurrentScene().lookup("#cp");
        cp1 = String.valueOf(textField6.getText());
       ChoiceBox<String> textField7 = (ChoiceBox<String>) sm.getCurrentScene().lookup("#pais");
       pais1 = String.valueOf(textField7.getItems());




        if (usuari1.isEmpty() || nom1.isEmpty() || cognom1.isEmpty() || direccio1.isEmpty() || poblacio1.isEmpty() || cp1.isEmpty() || pais1.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Advertència");
            alert.setHeaderText("S'han d'omplir tots els camps.");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Advertència");
            alert.setHeaderText("Felicitats, t'has registrat");
            alert.showAndWait();
            sm.changeSceneLevel(0);
        }
    }


}
