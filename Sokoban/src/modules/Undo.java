/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modules.Moves;
/**
 *
 * @author Elias
 */
public class Undo {
   
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    ArrayList<Integer> column = new ArrayList<Integer>();
    ArrayList<Integer> rowAvatar = new ArrayList<Integer>();
    ArrayList<Integer> columnAvatar =  new ArrayList<Integer>();
    ArrayList<Integer> Moves =  new ArrayList<Integer>();
    ArrayList<Integer> Pushes = new ArrayList<Integer>();
    ArrayList<Node> avatar = new ArrayList<Node>();
    ArrayList<Image> images =  new ArrayList<Image>();
    
    public void MovesAfterUndo(Node node, int Row, int Column, Node Avatar, int RowAvatar, int ColumnAvatar, int moves, int pushes, Image image){
     
        nodes.add(node);
       row.add(Row);
       column.add(Column);
       avatar.add(Avatar);
       rowAvatar.add(RowAvatar);
       columnAvatar.add(ColumnAvatar);
       Moves.add(moves);
       Pushes.add(pushes);
       images.add(image);
     
    }  
    public void getRow(){
  
    }
    public void UNDO( GridPane  gridPane, Moves moves, ImageView image){
        if (avatar.size() > 0) {
            if(nodes.get(nodes.size() - 1 ) != null ){
                
                gridPane.setColumnIndex(nodes.get(column.size() -1),column.get(column.size() -1));
                gridPane.setRowIndex(nodes.get(row.size() -1),row.get(row.size() -1));
                gridPane.setColumnIndex(avatar.get(columnAvatar.size() - 1 ),columnAvatar.get(columnAvatar.size() - 1));
                gridPane.setRowIndex(avatar.get(rowAvatar.size() - 1 ),rowAvatar.get(rowAvatar.size() - 1));
                moves.Moves(-(Moves.get(Moves.size() - 1)));
                moves.Pushes(-(Pushes.get(Pushes.size() - 1)));
                image.setImage(images.get(images.size()- 1));
                
             }else{
                 gridPane.setColumnIndex(avatar.get(columnAvatar.size() - 1 ),columnAvatar.get(columnAvatar.size() - 1));
                 gridPane.setRowIndex(avatar.get(rowAvatar.size() - 1 ),rowAvatar.get(rowAvatar.size() - 1));
                 moves.Moves(-(Moves.get(Moves.size() - 1)));
                 image.setImage(images.get(images.size()- 1));
             }
            nodes.remove(nodes.size() - 1);
            row.remove(row.size() - 1);
            column.remove(column.size() - 1);
            avatar.remove(avatar.size() - 1);
            rowAvatar.remove(rowAvatar.size() - 1);
            columnAvatar.remove(columnAvatar.size() - 1);
            Moves.remove(Moves.size() - 1);
            Pushes.remove(Pushes.size() - 1);
            images.remove(images.size() - 1);
        }
    }
}
