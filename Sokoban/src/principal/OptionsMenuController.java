/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import modules.Achievements;
import  modules.ShortestPath; 
import modules.Point;
/**
 * FXML Controller class
 *
 * @author Elias
 */
public class OptionsMenuController implements Initializable {
    private double ConfigSound=1;
    private double ConfigVolume=0.5;
    boolean win = false ;
    URL resource = getClass().getResource("/Sounds/Menu.mp3");
    Media media = new Media(resource.toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    Thread thread ;
    boolean run= true;
    Button btn = new Button();
    ShortestPath gbc =  new ShortestPath();
    Achievements achievements = new Achievements();  
    ArrayList<Achievements> lista = new ArrayList<Achievements>();
    private int position = 0;
    @FXML
    private GridPane PaneShow;
    @FXML
    private Circle circle_1;
    @FXML
    private Circle circle_2;
    @FXML
    private ImageView avatar;
    @FXML
    private GridPane About;
    @FXML
    private AnchorPane Container;
    @FXML
    private StackPane Start;
    @FXML
    private Circle CircleStart_1;
    @FXML
    private Circle CircleStart_2;
    @FXML
    private ImageView avatar1;
    @FXML
    private HBox Menu;
    @FXML
    private GridPane Perfile;
    @FXML
    private GridPane Achievement;
    @FXML
    private TextField Name;
    @FXML
    private ProgressBar LevelProgress1;
    @FXML
    private ProgressBar LevelProgress3;
    @FXML
    private ProgressBar LevelProgress2;
    @FXML
    private ProgressBar LevelProgress4;
    @FXML
    private ProgressBar LevelProgress5;
    @FXML
    private ProgressBar LevelProgress6;
    @FXML
    private ProgressBar LevelProgress7;
    @FXML
    private Pane Level1;
    @FXML
    private Pane Level2;
    @FXML
    private Pane Level3;
    @FXML
    private Pane Level4;
    @FXML
    private Pane Level5;
    @FXML
    private Pane Level6;
    @FXML
    private Pane Level7;
    @FXML
    private Pane Level8;
    @FXML
    private Pane Level9;
    @FXML
    private HBox TimelLevel1;
    @FXML
    private HBox TimelLevel2;
    @FXML
    private HBox TimelLevel3;
    @FXML
    private HBox TimelLevel4;
    @FXML
    private HBox TimelLevel5;
    @FXML
    private HBox TimelLevel6;
    @FXML
    private HBox TimelLevel7;
    @FXML
    private HBox TimelLevel8;
    @FXML
    private HBox TimelLevel9;
    @FXML
    private Label MovesLevel1;
    @FXML
    private Label MovesLevel2;
    @FXML
    private Label MovesLevel3;
    @FXML
    private Label MovesLevel4;
    @FXML
    private Label MovesLevel5;
    @FXML
    private Label MovesLevel7;
    @FXML
    private Label MovesLevel8;
    @FXML
    private Label MovesLevel9;
    @FXML
    private Label MovesLevel6;
    @FXML
    private Label TimerLevel1;
    @FXML
    private Label TimerLevel2;
    @FXML
    private Label TimerLevel3;
    @FXML
    private Label TimerLevel4;
    @FXML
    private Label TimerLevel5;
    @FXML
    private Label TimerLevel6;
    @FXML
    private Label TimerLevel7;
    @FXML
    private Label TimerLevel8;
    @FXML
    private Label TimerLevel9;
    @FXML
    private ProgressBar LevelProgress8;
    @FXML
    private ProgressBar LevelProgress9;
    @FXML
    private ProgressBar LevelProgress10;
    @FXML
    private ProgressBar LevelProgress11;
    @FXML
    private ProgressBar LevelProgress12;
    @FXML
    private Pane Level10;
    @FXML
    private Label MovesLevel10;
    @FXML
    private HBox TimelLevel10;
    @FXML
    private Label TimerLevel10;
    @FXML
    private Pane Level11;
    @FXML
    private Label MovesLevel11;
    @FXML
    private HBox TimelLevel11;
    @FXML
    private Label TimerLevel11;
    @FXML
    private Pane Level12;
    @FXML
    private Label MovesLevel12;
    @FXML
    private HBox TimelLevel12;
    @FXML
    private Label TimerLevel12;
    @FXML
    private Button resetGame;
    @FXML
    private BorderPane Border_1;
    @FXML
    private BorderPane Border_2;
    @FXML
    private BorderPane Border_3;
    @FXML
    private BorderPane Border_4;
    @FXML
    private Slider VolumeGame;
    @FXML
    private Slider SoundGame;
     
    /**
    * Initializes the controller class.
     */
   
     public void Achievements(ArrayList<Achievements> achievement, String name){
        lista = new ArrayList<Achievements>(achievement);
        Name.setText(name);
        initialize(null, null);
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SoundMenu();
       
        Pane [] PaneLevels = new Pane[]{Level1, Level2, Level3, Level4, Level5, Level6, Level7, Level8, Level9,Level10, Level11, Level12};
        ProgressBar []progress = new ProgressBar[]{LevelProgress1,LevelProgress2, LevelProgress3, LevelProgress4, LevelProgress5, LevelProgress6, LevelProgress7, LevelProgress8, LevelProgress9, LevelProgress10, LevelProgress11, LevelProgress12};
        HBox [] timeLevel = new HBox[]{TimelLevel1, TimelLevel2, TimelLevel3, TimelLevel4, TimelLevel5, TimelLevel6, TimelLevel7, TimelLevel8, TimelLevel9, TimelLevel10, TimelLevel11, TimelLevel12};
        Label [] timerLevel = new Label[]{TimerLevel1, TimerLevel2, TimerLevel3, TimerLevel4, TimerLevel5, TimerLevel6, TimerLevel7, TimerLevel8, TimerLevel9, TimerLevel10, TimerLevel11, TimerLevel12};
        Label [] movesLabel =  new Label[]{MovesLevel1, MovesLevel2, MovesLevel3, MovesLevel4, MovesLevel5, MovesLevel6, MovesLevel7,MovesLevel8, MovesLevel9, MovesLevel10, MovesLevel11, MovesLevel12};
                
    
        RotateStart(CircleStart_2, true, 360, 10);
        RotateStart(CircleStart_1, true, 180, 18);
        if(lista.size()!=0){achievements.ShowAchievements(lista, PaneLevels, timeLevel, movesLabel, timerLevel, progress);}
        
        CheckSelectPersonage();
         
         
   
         
    }    
   
   
     public void setPositionForAvatar(int position){
        this.position = position;
     }
     public void setConfigVolum(double configVolume, double configSound){
       ConfigSound = configSound;
       ConfigVolume = configVolume;
     }
  
     private void Rotate(Circle circle, boolean reverse, int angle, int duration){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), circle);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(6);
        rotateTransition.setCycleCount(40);
        rotateTransition.play();
    } 
      private void RotateStart(Circle circle, boolean reverse, int angle, int duration){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), circle);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(2);
        rotateTransition.setOnFinished(e -> ShowMenu());
        rotateTransition.play();
        
        
    }  
     
    private void ShowMenu(){
        Start.setVisible(false);
        Menu.setVisible(true);
        Rotate(circle_1, true, 360, 100);
        Rotate(circle_2, true, 180, 180); 
        
    }
    private void ShowMessage(){
     if(achievements.getShowMessageWin() == true){
         try {
            
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(
            Level1Controller.class.getResource("PlayerWin.fxml"));
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("/image/personaje.png"));
            stage.setTitle("Sokoban");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node)(Menu)).getScene().getWindow() );
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OptionsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
  @FXML
    private void ShowLevels(ActionEvent event) {
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #00a8cc;");
        btn = (Button)event.getSource();
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #f45905;");
        if(Name.getText().length() !=0){
       
        PaneShow.setVisible(true);
        circle_1.setVisible(false);
        circle_2.setVisible(false);
        avatar.setVisible(false);
        About.setVisible(false);
        Perfile.setVisible(false);
        Achievement.setVisible(false);
        resetGame.setVisible(false);
        Name.setStyle(null);
        }else{
        
        PaneShow.setVisible(false);
        circle_1.setVisible(false);
        circle_2.setVisible(false);
        avatar.setVisible(false);
        About.setVisible(false);
        Perfile.setVisible(true);
        Achievement.setVisible(false);
        Name.setStyle("-fx-border-color: red");
        resetGame.setVisible(false);
        }
      
    }
    
    @FXML
    private void ShowHome(ActionEvent event) {
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #00a8cc;");
        btn = (Button)event.getSource();
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #f45905;");
        Perfile.setVisible(false);
        PaneShow.setVisible(false);
        About.setVisible(false);
        circle_1.setVisible(true);
        circle_2.setVisible(true);
        Rotate(circle_1, true, 360, 100);
        Rotate(circle_2, true, 180, 180);
        avatar.setVisible(true);
        Achievement.setVisible(false);
        resetGame.setVisible(true); 
    }

    @FXML
    private void ShowAbout(ActionEvent event) {
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #00a8cc;");
        btn = (Button)event.getSource();
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #f45905;");
        PaneShow.setVisible(false);
        circle_1.setVisible(false);
        circle_2.setVisible(false);
        avatar.setVisible(false);
        About.setVisible(true);
        Perfile.setVisible(false);
        Achievement.setVisible(false);
        resetGame.setVisible(false);
    }
     @FXML
    private void ShowPerfile(ActionEvent event) {
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #00a8cc;");
        btn = (Button)event.getSource();
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #f45905;");
        PaneShow.setVisible(false);
        circle_1.setVisible(false);
        circle_2.setVisible(false);
        avatar.setVisible(false);
        About.setVisible(false);
        Perfile.setVisible(true);
        Achievement.setVisible(false);
        Name.setStyle(null);
        resetGame.setVisible(false);
    }
    @FXML
    private void ShowAchievements(ActionEvent event) {
        
        
         btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #00a8cc;");
        btn = (Button)event.getSource();
        btn.setStyle("-fx-background-color: #015668; -fx-border-color:   #f45905;");
        PaneShow.setVisible(false);
        circle_1.setVisible(false);
        circle_2.setVisible(false);
        avatar.setVisible(false);
        About.setVisible(false);
        Perfile.setVisible(false);
        Achievement.setVisible(true);
        resetGame.setVisible(false);       
    }
    @FXML
    private void ShowLevel1(MouseEvent event) throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);    
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level1.fxml"));
        Parent tableViewParent = loader.load();
        Level1Controller level1ControllerInstancia = (Level1Controller)loader.getController();
        level1ControllerInstancia.setPositionForAvatar(position);
        level1ControllerInstancia.getListaAchievements(lista, Name.getText());
        level1ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();    
       
    }

    @FXML
    private void ShowLevel2(MouseEvent event) throws Exception{
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level2.fxml"));
        Parent tableViewParent = loader.load();
        Level2Controller level2ControllerInstancia = (Level2Controller)loader.getController();
        level2ControllerInstancia.setPositionForAvatar(position);
        level2ControllerInstancia.getListaAchievements(lista, Name.getText());
        level2ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();   
        
    }

    @FXML
    private void ShowLevel3(MouseEvent event) throws Exception{
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level3.fxml"));
        Parent tableViewParent = loader.load();
        Level3Controller level3ControllerInstancia =  (Level3Controller)loader.getController();
        level3ControllerInstancia.setPositionForAvatar(position);
        level3ControllerInstancia.getListaAchievements(lista, Name.getText());
        level3ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();   
    }
   @FXML
    private void ShowLevel4(MouseEvent event) throws Exception{
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level4.fxml"));
        Parent tableViewParent = loader.load();
        Level4Controller level4ControllerInstancia =  (Level4Controller)loader.getController();
        level4ControllerInstancia.setPositionForAvatar(position);
        level4ControllerInstancia.getListaAchievements(lista, Name.getText());
        level4ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();   
    }

    @FXML
    private void ShowLevel5(MouseEvent event)  throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level5.fxml"));
        Parent tableViewParent = loader.load();
        Level5Controller level5ControllerInstancia =  (Level5Controller)loader.getController();
        level5ControllerInstancia.setPositionForAvatar(position);
        level5ControllerInstancia.getListaAchievements(lista, Name.getText());
        level5ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();   
    }

    @FXML
    private void ShowLevel6(MouseEvent event)  throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level6.fxml"));
        Parent tableViewParent = loader.load();
        Level6Controller level6ControllerInstancia =  (Level6Controller)loader.getController();
        level6ControllerInstancia.setPositionForAvatar(position);
        level6ControllerInstancia.getListaAchievements(lista, Name.getText());
        level6ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
     ;
        ((Node)(event.getSource())).getScene().getWindow().hide();   
    }

    @FXML
    private void ShowLevel7(MouseEvent event)  throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level7.fxml"));
        Parent tableViewParent = loader.load();
        Level7Controller level7ControllerInstancia = (Level7Controller) loader.getController();
        level7ControllerInstancia.setPositionForAvatar(position);
        level7ControllerInstancia.getListaAchievements(lista, Name.getText());
        level7ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
        
       ((Node)(event.getSource())).getScene().getWindow().hide();   
    }
 @FXML
    private void ShowLevel8(MouseEvent event) throws Exception{
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level8.fxml"));
        Parent tableViewParent = loader.load();
        Level8Controller level8ControllerInstancia = (Level8Controller) loader.getController();
        level8ControllerInstancia.setPositionForAvatar(position);
        level8ControllerInstancia.getListaAchievements(lista, Name.getText());
        level8ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
       ((Node)(event.getSource())).getScene().getWindow().hide();  
    }
  @FXML
    private void ShowLevel9(MouseEvent event) throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level9.fxml"));
        Parent tableViewParent = loader.load();
        Level9Controller level9ControllerInstancia = (Level9Controller) loader.getController();
        level9ControllerInstancia.setPositionForAvatar(position);
        level9ControllerInstancia.getListaAchievements(lista, Name.getText());
        level9ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }
   
    @FXML
    private void ShowLevel10(MouseEvent event) throws Exception{
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level10.fxml"));
        Parent tableViewParent = loader.load();
        Level10Controller level10ControllerInstancia = (Level10Controller) loader.getController();
        level10ControllerInstancia.setPositionForAvatar(position);
        level10ControllerInstancia.getListaAchievements(lista, Name.getText());
        level10ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }
     @FXML
    private void ShowLevel11(MouseEvent event) throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level11.fxml"));
        Parent tableViewParent = loader.load();
        Level11Controller level11ControllerInstancia = (Level11Controller) loader.getController();
        level11ControllerInstancia.setPositionForAvatar(position);
        level11ControllerInstancia.getListaAchievements(lista, Name.getText());
        level11ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @FXML
    private void ShowLevel12(MouseEvent event) throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run=false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level12.fxml"));
        Parent tableViewParent = loader.load();
        Level12Controller level12ControllerInstancia = (Level12Controller) loader.getController();
        level12ControllerInstancia.setPositionForAvatar(position);
        level12ControllerInstancia.getListaAchievements(lista, Name.getText());
        level12ControllerInstancia.setConfigVolum(VolumeGame.getValue(), SoundGame.getValue());
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
       ((Node)(event.getSource())).getScene().getWindow().hide();

    }

   
    @FXML
    private void SelectAvatar1(MouseEvent event) {
        position = 0; 
        CheckSelectPersonage();
    }
    @FXML
    private void SelectAvatar2(MouseEvent event) {
        position = 1; 
        CheckSelectPersonage();
    }
    @FXML
    private void SelectAvatar3(MouseEvent event) {
        position = 2;
        CheckSelectPersonage();
    }
    @FXML
    private void SelectAvatar4(MouseEvent event) {
        position = 3;
        CheckSelectPersonage();
    }
    private void SoundMenu(){
    thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                         VolumeGame.setValue(ConfigVolume);
                         SoundGame.setValue(ConfigSound);
                         mediaPlayer.play(); 
                         mediaPlayer.setVolume(VolumeGame.getValue());
                         if(win==false){
                            ShowMessage();
                            win=true;
                         }
                    }
                };

                while (run== true) {
                    try {
                        mediaPlayer.setVolume(VolumeGame.getValue());
                        mediaPlayer.stop();
                        Thread.sleep(8000);
                    } catch (InterruptedException ex) {
                    }

                    Platform.runLater(updater);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
     
                
    }

    

    @FXML
    private void DeleteAchievements(ActionEvent event) throws Exception {
        ConfigVolume=0;
        mediaPlayer.setVolume(0);
        run= false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OptionsMenu.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
   private void CheckSelectPersonage(){
     if(position==0){
      Border_1.setStyle("-fx-background-color:  #30475e;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_4.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_2.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_3.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
     }
     else if(position==1){
      Border_2.setStyle("-fx-background-color:  #30475e;-fx-background-radius: 100;  -fx-background-insets: 22 8;");
      Border_1.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_4.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_3.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
     }
      else if(position==2){
      Border_3.setStyle("-fx-background-color:  #30475e;-fx-background-radius: 100;  -fx-background-insets: 22 8;");
      Border_1.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_2.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_4.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
     }
      else if(position==3){
      Border_4.setStyle("-fx-background-color:  #30475e;-fx-background-radius: 100;  -fx-background-insets: 22 8;");
      Border_1.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_2.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
      Border_3.setStyle("-fx-background-color:  #116979;-fx-background-radius: 100;-fx-background-insets: 22 8;");
     }
     
     
     
   }

    @FXML
    private void VolumeScroll(MouseEvent event) {
             mediaPlayer.setVolume(VolumeGame.getValue());
             ConfigSound = SoundGame.getValue();
             ConfigVolume = VolumeGame.getValue();
    }
    
}
