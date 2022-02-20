/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import modules.VerifyGridPaneBox;
import modules.Moves;
import modules.LockUndo;
import modules.Undo; 
import modules.Avatars;

/**
 *
 * @author Elias
 */
public class MovesKeyPressed {
    
    
    public void MovesCheckKeyPressed(KeyEvent ke, GridPane tablero, ImageView avatar, VerifyGridPaneBox verifyGridPaneBox, int position, Button btn_Undo,Moves moves, LockUndo lockUndo, Undo undo, Avatars Avatar, double configSound){
        verifyGridPaneBox.setConfigSound(configSound);
        if ( (ke.getCode().equals(KeyCode.RIGHT) || ke.getCode().equals(KeyCode.D) ) && tablero.getColumnIndex(avatar) + 1 < 21)
        {
            if( verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar) + 1, tablero) ==  false  )
            {
                Image image = new Image(Avatar.getAvatarRigth(position));
                avatar.setImage(image);
                Node node =  verifyGridPaneBox.getNodeByRowColumnIndex(tablero.getRowIndex(avatar),tablero.getColumnIndex(avatar) +1,  tablero);
                if(node!= null &&verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node) , tablero.getColumnIndex(node) + 1, tablero) == true){
                    tablero.setRowIndex(node, tablero.getRowIndex(node));
                    tablero.setRowIndex(avatar, tablero.getRowIndex(avatar) );
                }
                else if( node != null && tablero.getRowIndex(avatar) == tablero.getRowIndex(node) &&  tablero.getColumnIndex(avatar)+1 == tablero.getColumnIndex(node)  && tablero.getColumnIndex(node)+1 <=20 && !verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(node), tablero.getColumnIndex(node) + 1, tablero))
                {
                    undo.MovesAfterUndo(node,tablero.getRowIndex(node), tablero.getColumnIndex(node), avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar), 1, 1, avatar.getImage());
                    tablero.setColumnIndex(node, tablero.getColumnIndex(node)+1);
                    tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar) + 1);
                    lockUndo.CheckIfLockUndo(tablero, node, btn_Undo,configSound);
                    moves.Moves(1);
                    moves.Pushes(1);
                    verifyGridPaneBox.MovesBox();
                }else if(node != null && verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node), tablero.getColumnIndex(node), tablero))
                {
                    tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar));
                } else {
                    undo.MovesAfterUndo(null,0, 0, avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar),1,0,avatar.getImage());
                    tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar)+1);
                    moves.Moves(1);
               }
           }
       
     } else if((ke.getCode().equals(KeyCode.LEFT) || ke.getCode().equals(KeyCode.A) ) &&   tablero.getColumnIndex(avatar) - 1 > 0){
            if(verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar) - 1 , tablero) == false ){
                Image image = new Image(Avatar.getAvatarLeft(position));
                avatar.setImage(image);
                Node node =  verifyGridPaneBox.getNodeByRowColumnIndex(tablero.getRowIndex(avatar),tablero.getColumnIndex(avatar)  - 1,  tablero);
                if(node!= null &&verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node) , tablero.getColumnIndex(node) - 1, tablero) == true){
                    tablero.setRowIndex(node, tablero.getRowIndex(node));
                    tablero.setRowIndex(avatar, tablero.getRowIndex(avatar) );
                }
                else if( node != null && tablero.getRowIndex(avatar) == tablero.getRowIndex(node) &&  tablero.getColumnIndex(avatar)  - 1 == tablero.getColumnIndex(node) && tablero.getColumnIndex(node) - 1 >=1 && !verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(node), tablero.getColumnIndex(node) - 1, tablero)){
                    undo.MovesAfterUndo(node,tablero.getRowIndex(node), tablero.getColumnIndex(node), avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar),1,1, avatar.getImage());
                    tablero.setColumnIndex(node, tablero.getColumnIndex(node)-1);
                    tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar)-1);
                    lockUndo.CheckIfLockUndo(tablero, node, btn_Undo,configSound);
                    moves.Moves(1);
                    moves.Pushes(1);
                    verifyGridPaneBox.MovesBox();
                }else if(node != null && verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node), tablero.getColumnIndex(node), tablero)){
                    tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar));
                } else{
                undo.MovesAfterUndo(null,0, 0, avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar),1,0, avatar.getImage());
                tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar)-1);
                moves.Moves(1);
                }
        }
     } 
     else if((ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.W) ) && tablero.getRowIndex(avatar) - 1 > 0){
        Image image = new Image(Avatar.getAvatarUP(position));
        avatar.setImage(image);        
        if(verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(avatar) - 1, tablero.getColumnIndex(avatar), tablero) == false ) {
            Node node =  verifyGridPaneBox.getNodeByRowColumnIndex(tablero.getRowIndex(avatar) - 1,tablero.getColumnIndex(avatar) ,  tablero);
            if(node!= null &&verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node) -1, tablero.getColumnIndex(node), tablero) == true){
                tablero.setRowIndex(node, tablero.getRowIndex(node));
                tablero.setRowIndex(avatar, tablero.getRowIndex(avatar) );
                      
            }
            else if( node != null && tablero.getRowIndex(avatar)-1 == tablero.getRowIndex(node) &&  tablero.getColumnIndex(avatar) == tablero.getColumnIndex(node) && tablero.getRowIndex(node)-1 >=1 && !verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(node) -1, tablero.getColumnIndex(node), tablero)){
                undo.MovesAfterUndo(node,tablero.getRowIndex(node), tablero.getColumnIndex(node), avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar),1,1, avatar.getImage());
                tablero.setRowIndex(node, tablero.getRowIndex(node)-1);
                tablero.setRowIndex(avatar, tablero.getRowIndex(avatar)-1);  
                lockUndo.CheckIfLockUndo(tablero, node, btn_Undo,configSound);
                moves.Moves(1);
                moves.Pushes(1);
                verifyGridPaneBox.MovesBox();
            }else if( node != null && verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node), tablero.getColumnIndex(node), tablero)){
                tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar));
            }else{
                undo.MovesAfterUndo(null,0, 0, avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar),1,0, avatar.getImage());
                tablero.setRowIndex(avatar, tablero.getRowIndex(avatar)-1);
                moves.Moves(1);        
            }
         
        }
  
     } else if((ke.getCode().equals(KeyCode.DOWN) || ke.getCode().equals(KeyCode.S) ) && tablero.getRowIndex(avatar)+1 < 15){
          Image image = new Image(Avatar.getAvatarDown(position));
          avatar.setImage(image);
        
          if(verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(avatar)+1, tablero.getColumnIndex(avatar), tablero) == false ){  
        
                Node node =  verifyGridPaneBox.getNodeByRowColumnIndex(tablero.getRowIndex(avatar) + 1,tablero.getColumnIndex(avatar) ,  tablero);
                if(node!= null &&verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node) +1, tablero.getColumnIndex(node), tablero) == true){
                
                    tablero.setRowIndex(node, tablero.getRowIndex(node));
                    tablero.setRowIndex(avatar, tablero.getRowIndex(avatar) );
                }
                else if(
                    node != null&&  tablero.getRowIndex(avatar)+1 == tablero.getRowIndex(node)
                    && tablero.getColumnIndex(avatar) == tablero.getColumnIndex(node)
                    && tablero.getRowIndex(node)+1 <=14 && !verifyGridPaneBox.VerifyNodeItNotLock(tablero.getRowIndex(node) +1, tablero.getColumnIndex(node), tablero)){
                        undo.MovesAfterUndo(node,tablero.getRowIndex(node), tablero.getColumnIndex(node), avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar),1,1, avatar.getImage());
                        tablero.setRowIndex(node, tablero.getRowIndex(node)+1);
                        tablero.setRowIndex(avatar, tablero.getRowIndex(avatar) + 1);
                        lockUndo.CheckIfLockUndo(tablero, node, btn_Undo, configSound);
                        moves.Moves(1);
                        moves.Pushes(1);
                        verifyGridPaneBox.MovesBox();
                }
                else if(node != null && verifyGridPaneBox.VerifyNodeItNotLockHongo(tablero.getRowIndex(node), tablero.getColumnIndex(node), tablero)){
                    tablero.setColumnIndex(avatar, tablero.getColumnIndex(avatar));
                    
                } else{
                    undo.MovesAfterUndo(null,0, 0, avatar, tablero.getRowIndex(avatar), tablero.getColumnIndex(avatar),1,0, avatar.getImage());
                    tablero.setRowIndex(avatar, tablero.getRowIndex(avatar) + 1);
                    moves.Moves(1);
                }

        }

     }
   

     }
}
