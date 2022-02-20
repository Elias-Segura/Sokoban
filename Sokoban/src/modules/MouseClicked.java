/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import modules.VerifyGridPaneBox; 
import modules.Undo; 
import modules.Moves;
import modules.LockUndo; 
/**
 *
 * @author Elias Segura
 */
public class MouseClicked {
    
   public void MouseClicked(MouseEvent event, GridPane tablero,  VerifyGridPaneBox verifyGridPaneBox, ImageView avatar, Label Pushes, Label Moves, Moves moves, Undo undo, Button btn_Undo, LockUndo lockUndo, int position, double configSound  ){
        Node target = (Node) event.getTarget();
        if (target != tablero) {
            Node parent;
            while ((parent = target.getParent()) != tablero) {
                target = parent;
            }
        }
        Integer colIndex = tablero.getColumnIndex(target);
        Integer rowIndex = tablero.getRowIndex(target);
        int rowAvatar = tablero.getRowIndex(avatar);
        int columnAvatar =  tablero.getColumnIndex(avatar);
        if (colIndex != null && rowIndex != null && verifyGridPaneBox.VerifyNodeItNotLock(rowIndex, colIndex, tablero) == false) {      
            verifyGridPaneBox.VerifyNodeHongo(rowIndex, colIndex, avatar, tablero,rowAvatar, columnAvatar, target, Pushes, Moves, moves, undo, btn_Undo, lockUndo, position, configSound);       

        }
        }
}
