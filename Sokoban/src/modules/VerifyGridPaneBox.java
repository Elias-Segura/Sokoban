/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 *
 * @author Elias
 */
public class VerifyGridPaneBox {
    ShortestPath shortestPath =  new ShortestPath();
    private double ConfigSound = 0;
    int [][] array = new int[16][22];
    private double BoxesCount= 0.0;
    private String BoxName; 
    Avatars Avatar =  new Avatars();
      public double getBoxesCount() {
        return BoxesCount;
    }

    public void setConfigSound(double ConfigSound) {
        this.ConfigSound = ConfigSound;
    }

    public void setBoxesCount(double BoxesCount) {
        this.BoxesCount = BoxesCount;
    }
    public void llenarMatriz(GridPane gridPane){
           for(int i=0; i < 16; i++){
          for(int j=0; j < 22;j ++){
             if(VerifyNodeItNotLock(i, j, gridPane) == true){
             array[i][j]=0;
             }else{
                 
               array[i][j]=1;
               
              Node node = getNodeByRowColumnIndex(i, j, gridPane);
                 if (node!= null) {
                     if(VerifyExistBox(node.idProperty().get()) == true){
                       array[i][j]=0;
                     }
                 }
             }
             if (i==0 || i==15 || j==0 || j==21) {
                   array[i][j]=0;
              }
          }
        }
    }
    public boolean VerifyIfWin(int BoxSave, int CorX[], int CorY[], GridPane gridPane ){
        int counter = 0;
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            result = node;
            if (result.idProperty().get() != null &&  VerifyExistBox(result.idProperty().get())) {
                  for( int i = 0; i<  CorX.length; i++) {
                   if(gridPane.getRowIndex(result) == CorX[i] && gridPane.getColumnIndex(result) == CorY[i]){
                      counter++;
                   }
                  }
            }

        }
        if (counter!=0){
            setBoxesCount((double)counter / (double)BoxSave);
        }
        if(counter == BoxSave){
            URL resource = getClass().getResource("/Sounds/YouWin.mp3");
            Media media = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();      
            return true;

        }
        return false ;
    }
    public Boolean VerifyExistBox(String node){
       
     String Boxs[]  = {"Hongo_1", "Hongo_2", "Hongo_3", "Hongo_4", "Hongo_5", "Hongo_6", "Hongo_7", "Hongo_8", "Hongo_9", "Hongo_10", 
                      "Hongo_11", "Hongo_12", "Hongo_13", "Hongo_14", "Hongo_15", "Hongo_16", "Hongo_17", "Hongo_18", "Hongo_19", "Hongo_20"};
    
        for (int i = 0; i < 20; i++) {
            if(Boxs[i].equals(node)){
             return true;
            }
        }
        return false; 
        
    }
   public Node getNodeByRowColumnIndex (int row, int column, GridPane gridPane) {
  Node result = null;
  ObservableList<Node> childrens = gridPane.getChildren();

  for (Node node : childrens) {
   
      result = node;
      if (result.idProperty().get() != null) {
           if(gridPane.getColumnIndex(result) == column && gridPane.getRowIndex(result) == row && VerifyExistBox(result.idProperty().get())){
            return result;
           }
      }
     
  }

  return null;
}
   public boolean VerifyNodeItNotLock( int row, int column , GridPane gridPane){
   
     Node result = null;
  ObservableList<Node> childrens = gridPane.getChildren();

  for (Node node : childrens) {
   
      result = node;
      if (result.idProperty().get() != null) {
           if(gridPane.getColumnIndex(result) == column && gridPane.getRowIndex(result) == row && !VerifyExistBox(result.idProperty().get())){
            
            return true;
            
           }
      }
     
  }

  return false;
  
   }
      public boolean VerifyNodeItNotLockHongo( int row, int column , GridPane gridPane){
       
     Node result = null;
  ObservableList<Node> childrens = gridPane.getChildren();
  for (Node node : childrens) {
      result = node;
      if (result.idProperty().get() != null) {
           if(gridPane.getColumnIndex(result) == column && gridPane.getRowIndex(result) == row && VerifyExistBox(result.idProperty().get()) && result.idProperty().get() != "avatar"){
              
            return true; 
           }
      }  
  }
  
  return false;
  
   }
   public void VerifyNodeHongo( int row, int column, ImageView image, GridPane gridPane, int rowAvatar, int columnAvatar, Node target, Label Pushes, Label Moves, Moves moves, Undo undo, Button btn_Undo, LockUndo checkLockUndo, int position, double configSound) {
   setConfigSound(ConfigSound);
   llenarMatriz(gridPane);
   array[rowAvatar][columnAvatar]=1;
   boolean founded = false;
    Node result = null;
   ObservableList<Node> childrens = gridPane.getChildren();
 
   for (Node node : childrens) {
       result = node;
    
       if (result.idProperty().get() != null) {
      
            if(gridPane.getColumnIndex(result) == column && gridPane.getRowIndex(result) == row && VerifyExistBox(result.idProperty().get()) == true ){
               
                if(column == columnAvatar && row - 1 > 0 &&  row == rowAvatar - 1 && VerifyNodeItNotLock(row -1 , column, gridPane) == false &&  VerifyNodeItNotLockHongo(row - 1, column , gridPane) == false)
                { 
                    Image avatarImage = new Image(Avatar.getAvatarUP(position));
                    image.setImage(avatarImage);
                    gridPane.setRowIndex(image,row);
                    gridPane.setColumnIndex(image,column);
                    gridPane.setRowIndex(result,row-1 );
                    gridPane.setColumnIndex(result, column);
                    moves.Moves(1);
                    moves.Pushes(1);
                 
                    undo.MovesAfterUndo(result, row, column, image , rowAvatar, columnAvatar, 1,1, image.getImage());
                    founded=true;
                    checkLockUndo.CheckIfLockUndo(gridPane, result, btn_Undo,configSound);
                    MovesBox();
                }
                 else if(row == rowAvatar && column - 1 > 0 && column == columnAvatar- 1 && VerifyNodeItNotLock(row , column - 1, gridPane) == false && VerifyNodeItNotLockHongo(row, column - 1, gridPane) == false)
                 {
                    Image avartarImage = new Image(Avatar.getAvatarLeft(position));
                    image.setImage(avartarImage);
                    gridPane.setRowIndex(image, row );
                    gridPane.setColumnIndex(image,column);
                    gridPane.setRowIndex(result,row );
                    gridPane.setColumnIndex(result, column -1 );
                    undo.MovesAfterUndo(result, row, column, image , rowAvatar, columnAvatar, 1,1,image.getImage());
                    moves.Moves(1);
                    moves.Pushes(1);
                    founded=true;
                    checkLockUndo.CheckIfLockUndo(gridPane, result, btn_Undo,configSound);
                    MovesBox();
                }
               else  if(column == columnAvatar && row + 1 < 15 && row == rowAvatar + 1 && VerifyNodeItNotLock(row + 1 , column, gridPane) == false &&  VerifyNodeItNotLockHongo(row + 1, column, gridPane) == false)
               {
                    Image avatarImage = new Image(Avatar.getAvatarDown(position));
                    image.setImage(avatarImage);
                    gridPane.setRowIndex(image, row);
                    gridPane.setColumnIndex(image,column);
                    gridPane.setRowIndex(result,row +1 );
                    gridPane.setColumnIndex(result, column);
                    undo.MovesAfterUndo(result, row, column, image , rowAvatar, columnAvatar, 1,1,image.getImage());
                    moves.Moves(1);
                    moves.Pushes(1);
                    founded=true;
                    checkLockUndo.CheckIfLockUndo(gridPane, result, btn_Undo,configSound);
                    MovesBox();
               }
                else if(row == rowAvatar && column + 1 < 21 && column == columnAvatar + 1 && VerifyNodeItNotLock(row , column + 1, gridPane) == false &&  VerifyNodeItNotLockHongo(row, column + 1, gridPane) == false)
                {
                    Image avatarImage = new Image(Avatar.getAvatarRigth(position));
                    image.setImage(avatarImage);
                    gridPane.setRowIndex(image, row );
                    gridPane.setColumnIndex(image,column);
                    gridPane.setRowIndex(result,row );
                    gridPane.setColumnIndex(result, column  + 1 );
                    undo.MovesAfterUndo(result, row, column, image , rowAvatar, columnAvatar, 1,1,image.getImage());
                    moves.Moves(1);
                    moves.Pushes(1);
                    founded=true;
                    checkLockUndo.CheckIfLockUndo(gridPane, result, btn_Undo,configSound);
                    MovesBox();
                }
            }
       }

      }
    
       if ( founded == false ) 
       {   
            Image avatarImage = new Image(Avatar.getAvatarDown(position));
            image.setImage(avatarImage);
            llenarMatriz(gridPane);
            array[rowAvatar][columnAvatar]=1;
            if(array[row][column] !=0)
            {
                Point source = new Point(rowAvatar, columnAvatar); 
                Point dest = new Point(row, column); 
                int dist = shortestPath.ShortPath(array, source, dest); 
                if (dist != -1)
                {
                    gridPane.setRowIndex(image, row);
                    gridPane.setColumnIndex(image, column);
                    moves.Moves(dist);
                    undo.MovesAfterUndo(null, 0, 0, image, rowAvatar, columnAvatar, dist, 0,image.getImage());
                }else{
                 StreetItsLock();
                }
                
            }
       }
              
       Moves.setText(moves.getMovesString());
       Pushes.setText(moves.getPushesString());
    }
   public void MovesBox(){
    URL resource = getClass().getResource("/Sounds/MovesBox.mp3");
    Media media = new Media(resource.toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play(); 
    mediaPlayer.setVolume(ConfigSound);
   
   }
   private void StreetItsLock(){
     URL resource = getClass().getResource("/Sounds/StreetLock.mp3");
    Media media = new Media(resource.toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play(); 
    mediaPlayer.setVolume(ConfigSound);
   }
}
