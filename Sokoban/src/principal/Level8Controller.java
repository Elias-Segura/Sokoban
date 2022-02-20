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
import modules.PutWall;
import modules.Timer;
/**
 *
 * @author Elias
 */
public class Level8Controller implements Initializable {
    private double ConfigSound=0;
    private double ConfigVolume=0;
    private int position;
    private int i=0;
    private String Name;
    Achievements achievement = new Achievements();
    ArrayList<Achievements> lista = new ArrayList<Achievements>();
    private VerifyGridPaneBox verifyGridPaneBox = new VerifyGridPaneBox();
    private MovesKeyPressed movesKeyPressed =  new MovesKeyPressed();
    private MouseClicked mouseClicked = new MouseClicked(); 
    private Undo undo = new Undo();
    private Moves moves = new Moves();
    private LockUndo lockUndo = new LockUndo();
    private PutWall putWall = new PutWall();
    private Timer timer = new Timer();
    Avatars Avatar =  new Avatars();
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
    private int X[] = new int[]{11,11,11,11,12,12,12,12,12,12,13,13,13,13,13,13};
    private int Y[] = new int[]{4,5,8,9,4,5,6,7,8,9, 4,5,6,7,8,9};
    private static final int BoxsSave = 16;
    @FXML
    private Label Moves;
    @FXML
    private Label Pushes;
    @FXML
    private Button btn_Undo;
    @FXML
    private ImageView Hongo_7;
    @FXML
    private ImageView Hongo_8;
    @FXML
    private ImageView Hongo_10;
    @FXML
    private ImageView Hongo_9;
    @FXML
    private Label TiempoLevel;
    @FXML
    private ImageView Hongo_12;
    @FXML
    private ImageView Hongo_13;
    @FXML
    private ImageView Hongo_14;
    @FXML
    private ImageView Hongo_15;
    @FXML
    private ImageView Hongo_16;
    @FXML
    private ImageView Hongo_11;
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
    public void getListaAchievements( ArrayList<Achievements> achievement, String name){
        lista = new ArrayList<Achievements>(achievement);
        Name =  name; 
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
        achievement = new Achievements(Name, "Level8",moves.getMoves() , moves.getPushes(),i,verifyGridPaneBox.getBoxesCount());
        lista.add(achievement);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level9.fxml"));
        Parent tableViewParent = loader.load();
        Level9Controller level9ControllerInstancia = (Level9Controller) loader.getController();
        level9ControllerInstancia.setPositionForAvatar(position);
        level9ControllerInstancia.getListaAchievements(lista, Name);
        level9ControllerInstancia.setConfigVolum(ConfigVolume, ConfigSound);
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
        achievement = new Achievements(Name, "Level8",0,0,0,verifyGridPaneBox.getBoxesCount());
        lista.add(achievement);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OptionsMenu.fxml"));
        Parent tableViewParent = loader.load();
        OptionsMenuController optionsMenuControllerInstancia =  (OptionsMenuController)loader.getController();
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
        achievement = new Achievements(Name, "Level8",0,0,0,verifyGridPaneBox.getBoxesCount());
        lista.add(achievement);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Level8.fxml"));
        Parent tableViewParent = loader.load();
        Level8Controller level8ControllerInstancia =  (Level8Controller)loader.getController();
        level8ControllerInstancia.setPositionForAvatar(position);
        level8ControllerInstancia.getListaAchievements(lista,Name);
        level8ControllerInstancia.setConfigVolum(ConfigVolume, ConfigSound);
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
        undo.UNDO(tablero, moves, avatar);
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
