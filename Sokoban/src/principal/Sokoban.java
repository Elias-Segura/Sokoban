/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Elias
 */
public class Sokoban extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("OptionsMenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("/image/BoxLevel5.png"));
        stage.setTitle("Sokoban");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
         

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
