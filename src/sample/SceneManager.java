package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class SceneManager is for managing different scene of game.
 * @author kevingok
 *
 */
public class SceneManager {

    private static SceneManager instance = null;

    public static final int LOGIN = 0;
    public static final int REGISTER = 1;

    @FXML
    GridPane mainP;

    private int currentLevel;

    private ArrayList<Scene> scenes;

    public static Stage primaryStage = null;

    /**
     * Get instance of SceneManager
     * @return        Instance of SceneManager
     */
    public static SceneManager getInstance() throws IOException {
        if(instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    /**
     * Class constructor initiates all scene in an ArrayList and
     * sets initial scene as menu.
     */
    private SceneManager() throws IOException {

        Parent loginViewParent = FXMLLoader.load(getClass().getResource("../sample/sample.fxml"));
        Parent registerViewParent = FXMLLoader.load(getClass().getResource("../sample/register.fxml"));
        Parent recoverKeyParent = FXMLLoader.load(getClass().getResource("../sample/lostpwd.fxml"));
        Parent mainView = FXMLLoader.load(getClass().getResource("../sample/panel.fxml"));
        scenes = new ArrayList<Scene>();

        scenes.add(new Scene(loginViewParent, 600, 400));
        scenes.add(new Scene(registerViewParent, 450, 300));
        scenes.add(new Scene(recoverKeyParent, 450, 300));
        scenes.add(new Scene(mainView, 600, 400));

    }

    public void setStage(Stage stage){
        this.primaryStage = stage;
    }


    /**
     * Change scene of game.
     * @param sceneLevel      Type of scene as integer
     */
    public void changeSceneLevel(int sceneLevel) {
        currentLevel = sceneLevel;
        primaryStage.setScene(scenes.get(sceneLevel));

        primaryStage.show();
    }

    /**
     * Retrieve current type of scene.
     * @return           Type of scene as integer
     */
    public Scene getCurrentScene() {
        return scenes.get(currentLevel);
    }
}