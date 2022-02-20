/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import modules.VerifyGridPaneBox;
/**
 *
 * @author Elias Segura
 */
public class PutWall {
    VerifyGridPaneBox verifyGridPaneBox = new VerifyGridPaneBox();
    String [] StylesName =  new String[]{"Pane", "Level2", "Level3", "Level4", "Level5", "Level6", "Level7", "Level8", "Level9", "Level10", "Level11", "Level12"};
    int counter = 0;
        int [][] array = new int[16][22];
    public void PutWallID(GridPane gridPane){
       for (int i = 1; i < 15; i++) {
            for (int j = 1; j <21; j++) {
                    Node node =  getNodeFromGridPane(gridPane, j, i);
                    if(node != null && CheckStyle(node.getStyleClass().toString()) == true){
                        node.setId("C"+counter);
                        counter++;
                    }
            }
        }
}
private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
        if ( null!= GridPane.getColumnIndex(node) &&  GridPane.getColumnIndex(node) == col && null!= GridPane.getRowIndex(node) && GridPane.getRowIndex(node) == row) {
            return node;
        }
    }
    return null;
}
private boolean CheckStyle(String Name){
    for (int i = 0; i < StylesName.length; i++) {
       if (Name.equals(StylesName[i])) {
            return true;
            }
        }
        return false;
    }
}
