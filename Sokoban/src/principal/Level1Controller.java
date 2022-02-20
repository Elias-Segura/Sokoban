/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import modules.VerifyGridPaneBox;
import modules.Moves;
import modules.Undo;
import modules.LockUndo;
import modules.Avatars;
import modules.Achievements;
import modules.MouseClicked;
import modules.MovesKeyPressed;
import modules.Timer;
import modules.PutWall;
/**
 *
 * @author Elias
 */
public class Level1Controller implements Initializable {
    private double ConfigSound=0;
    private double ConfigVolume=0;
    private int i = 0;
    private int position;
    private String Name;
    private Achievements achievement;
    ArrayList<Achievements> lista = new ArrayList<Achievements>();
    private VerifyGridPaneBox verifyGridPaneBox = new VerifyGridPaneBox();
    private MovesKeyPressed movesKeyPressed = new MovesKeyPressed();
    private MouseClicked mouseClicked = new MouseClicked();
    private Undo undo = new Undo();
    private Moves moves = new Moves();
    private LockUndo lockUndo = new LockUndo();
    private Timer timer = new Timer();
    private PutWall putWall = new PutWall();
    private Avatars Avatar =  new Avatars();
    private String result;
    @FXML
    private GridPane tablero;
    private ImageView Puntero;
    private Circle Puntero_1;
    @FXML
    private ImageView avatar;
    @FXML
    private AnchorPane tabla;
    @FXML
    private ImageView Hongo_1;
    @FXML
    private ImageView Hongo_2;
    @FXML
    private ImageView Hongo_6;
    @FXML
    private ImageView Hongo_3;
    @FXML
    private ImageView Hongo_4;
    @FXML
    private ImageView Hongo_5;
    private int X[] = new int[]{11,11,11,12,12,12};
    private int Y[] = new int[]{2,3,4,2,3,4};
    private static final int BoxsSave = 6;
    @FXML
    private Label Moves;
    @FXML
    private Label Pushes;
    @FXML
    private Button btn_Undo;
    @FXML
    private Label TiempoLevel;
    @FXML
    private Button Timer;
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        putWall.PutWallID(tablero);
    }    
    public void setPositionForAvatar(int position){
        this.position = position;
        Image image =  new Image(Avatar.getAvatarDown(position));
        avatar.setImage(image);
    }
     public void setConfigVolum(double configVolume, double configSound){
        ConfigSound = configSound;
         ConfigVolume = configVolume;
     }
     public void getListaAchievements( ArrayList<Achievements> achievements, String Name){
        lista = new ArrayList<Achievements>(achievements);
        this.Name = Name;
    }
    @FXML
    private void Avatar(KeyEvent ke) throws Exception {
        movesKeyPressed.MovesCheckKeyPressed(ke, tablero, avatar, verifyGridPaneBox, position, btn_Undo, moves, lockUndo, undo, Avatar,ConfigSound);
        if(verifyGridPaneBox.VerifyIfWin(BoxsSave, X, Y, tablero) == true ){
              NextLevel();
        }
        if ((ke.getCode() == KeyCode.Z || ke.getCode() == KeyCode.Y) && ke.isShortcutDown() && btn_Undo.isVisible() == true ) {
           undo.UNDO(tablero, moves,avatar);
        }
        Moves.setText(moves.getMovesString());
        Pushes.setText(moves.getPushesString());
    }
    @FXML
    private void MouseClick(MouseEvent event) throws Exception {
        mouseClicked.MouseClicked(event, tablero, verifyGridPaneBox, avatar, Pushes, Moves, moves, undo, btn_Undo, lockUndo, position,ConfigSound);
        if(verifyGridPaneBox.VerifyIfWin(BoxsSave, X, Y, tablero) == true ){
              NextLevel();
        }
        Moves.setText(moves.getMovesString());
        Pushes.setText(moves.getPushesString());
    }
    private void NextLevel () throws Exception{
        i =timer.getI();
        timer.StopTimer();
        achievement = new Achievements(Name, "Level1",moves.getMoves() , moves.getPushes(),i,verifyGridPaneBox.getBoxesCount());
        lista.add(achievement);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level2.fxml"));
        Parent tableViewParent = loader.load();
        Level2Controller level2ControllerInstancia = (Level2Controller)loader.getController();
        level2ControllerInstancia.setPositionForAvatar(position);
        level2ControllerInstancia.getListaAchievements(lista, Name);
        level2ControllerInstancia.setConfigVolum(ConfigVolume, ConfigSound);
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = new Stage();
        window.getIcons().add(new Image("/image/BoxLevel5.png"));
        window.setTitle("Sokoban");
        window.setScene(tableViewScene);
        window.setFullScreen(true);
        window.show();
        ((Node)(tablero)).getScene().getWindow().hide();
    }
    @FXML
    private void ShowMenu(ActionEvent event) throws Exception{    
        timer.StopTimer();
        achievement = new Achievements(Name, "Level1",0 , 0,0,verifyGridPaneBox.getBoxesCount());
        lista.add(achievement);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OptionsMenu.fxml"));
        Parent tableViewParent = loader.load();
        OptionsMenuController optionsMenuControllerInstancia  =  (OptionsMenuController) loader.getController();
        optionsMenuControllerInstancia.setPositionForAvatar(position);
        optionsMenuControllerInstancia.Achievements(lista, Name);
        optionsMenuControllerInstancia.setConfigVolum(ConfigVolume, ConfigSound);
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
    private void Reset(ActionEvent event)  throws Exception {
        timer.StopTimer();
        achievement = new Achievements(Name, "Level1",0 , 0,0,verifyGridPaneBox.getBoxesCount());
        lista.add(achievement);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level1.fxml"));
        Parent tableViewParent = loader.load();
        Level1Controller level1ControllerInstancia  =  (Level1Controller)loader.getController();
        level1ControllerInstancia.setPositionForAvatar(position);
        level1ControllerInstancia.getListaAchievements(lista, Name);
        level1ControllerInstancia.setConfigVolum(ConfigVolume, ConfigSound);
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
    private void Undo(ActionEvent event) {
        undo.UNDO(tablero, moves,avatar);
        Moves.setText(moves.getMovesString());
        Pushes.setText(moves.getPushesString());
    }
    @FXML
    private void ClickTime(MouseEvent event) {
        if(moves.getMoves()==0){
          timer.ShowTimer(event, TiempoLevel, 0);
        }
    }
}
