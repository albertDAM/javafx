package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    public static SceneManager sm = null;
    @FXML
    GridPane mainP;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Image ceps = new Image(getClass().getResourceAsStream("/img/ceps.jpg"));
        ImageView cepsView = new ImageView(ceps);

        cepsView.setX(50);
        cepsView.setY(25);

        cepsView.setFitHeight(455);
        cepsView.setFitWidth(500);

       /* cepsView.setPreserveRatio(true);

        Group root = new Group(cepsView);

        Scene scene = new Scene(root,600,500);

        primaryStage.setScene(scene);*/



        sm = SceneManager.getInstance();
        sm.setStage(primaryStage);

        sm.changeSceneLevel(0);
        sm.getCurrentScene().getStylesheets().add(getClass().getResource("backgroud.css").toExternalForm());


    }

   /* TextFlow flow = new TextFlow(
            new Text("Has perdut la teva clau?"), new Hyperlink("Clica aquí")
    );*/

    public static void main(String[] args) {
        launch(args);
    }
}
