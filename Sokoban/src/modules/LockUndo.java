/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.io.File;
import java.net.URL;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modules.VerifyGridPaneBox;
/**
 *
 * @author Elias
 */
public class LockUndo {
   
    VerifyGridPaneBox verifyGridPaneBox = new VerifyGridPaneBox();
    private int counterLocks = 0 ; 
    private Node request; 
    private int X; 
    private int Y;
    private boolean col = false ; 
    private boolean row =  false ; 
    private double ConfigSound=0;
    public void CheckIfLockUndo(GridPane gridPane, Node Hongo, Button Undo, double configSound){
        ConfigSound = configSound;
        if(gridPane.getColumnIndex(Hongo) == 20 ||  gridPane.getColumnIndex(Hongo) == 1 ){
            Undo.setVisible(false);
            GameOver(); 
        }
        if(gridPane.getRowIndex(Hongo) ==  1 || gridPane.getRowIndex(Hongo)== 14 ){
            Undo.setVisible(false);
            GameOver(); 
        }
        if( row == false &&  getNodeByRowColumnIndex(gridPane.getRowIndex(Hongo) + 1 , gridPane.getColumnIndex(Hongo), gridPane, Hongo) == true ){
            counterLocks += 1 ;
            row= !row;
        }
        if(row == false && getNodeByRowColumnIndex(gridPane.getRowIndex(Hongo) - 1 , gridPane.getColumnIndex(Hongo), gridPane, Hongo) == true){
            counterLocks += 1 ; 
            row= !row;
        }
        if( col ==  false && getNodeByRowColumnIndex(gridPane.getRowIndex(Hongo)  , gridPane.getColumnIndex(Hongo) - 1, gridPane, Hongo) == true){
            counterLocks += 1 ; 
            col = !col;
        }
        if(col== false && getNodeByRowColumnIndex(gridPane.getRowIndex(Hongo)  , gridPane.getColumnIndex(Hongo) + 1, gridPane, Hongo) == true){
            counterLocks += 1 ; 
            col = !col;
        }
        if(counterLocks >=2){
            Undo.setVisible(false);  
            GameOver(); 
        }
        counterLocks = 0 ;
        col= false;
        row=false;
        request=null;
    }
    private boolean getNodeByRowColumnIndex (int row, int column, GridPane gridPane, Node Hongo) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
        result = node;
        if (result.idProperty().get() != null ) {
           if(gridPane.getColumnIndex(result) == column && gridPane.getRowIndex(result) == row && verifyGridPaneBox.VerifyExistBox(result.idProperty().get()) == true){
                return false;
           }
           else if( gridPane.getColumnIndex(result) == column && gridPane.getRowIndex(result) == row && result.idProperty().get().equals("avatar")){
                return false;
           }
           else if( gridPane.getColumnIndex(result) == column && gridPane.getRowIndex(result) == row && verifyGridPaneBox.VerifyNodeItNotLock(row, column, gridPane) ==true ){
                 if(request != result){
                    request =   result;       
                    return true; 
                 }else{
                    return false;
                 }
           }
      }
     
  }

  return false;
}
 private void GameOver(){
    URL resource = getClass().getResource("/Sounds/GameOver.mp3");
    Media media = new Media(resource.toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play();        
    mediaPlayer.setVolume(ConfigSound);
}
    
}
