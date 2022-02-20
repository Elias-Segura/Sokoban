/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
/**
 *
 * @author Elias Segura
 */
public class Achievements {
  
    private String Nombre;
    private String Level; 
    private int moves; 
    private int pushes; 
    private int time; 
    private double BoxesCount= 0.0;
    private boolean founded  = false; 
    private boolean ShowMessageWin = false; 
    private int counter =0 ; 
    private int[] MovesAchievements =  new int[]{230, 585, 640, 436, 907, 312, 407,942,620,892,713,1012};
    private String[] Levels =  new String[]{"Level1", "Level2", "Level3", "Level4", "Level5", "Level6","Level7", "Level8", "Level9", "Level10", "Level11", "Level12"};
    private int [] TimeLevel = new int[]{40,120,130,95,182,64,92,195,140,230,220,240};
     public Achievements() {
       
    }
    public Achievements(String Nombre, String Level, int moves, int pushes, int time, double boxesCount) {
        this.Nombre = Nombre;
        this.Level = Level;
        this.moves = moves;
        this.pushes = pushes;
        this.time = time ; 
        this.BoxesCount = boxesCount;
    }

    public boolean getShowMessageWin() {
        return ShowMessageWin;
    }

    public void setShowMessageWin(boolean ShowMessageWin) {
        this.ShowMessageWin = ShowMessageWin;
    }
    
    public double getBoxesCount() {
        return BoxesCount;
    }

    public void setBoxesCount(double BoxesCount) {
        this.BoxesCount = BoxesCount;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getPushes() {
        return pushes;
    }

    public void setPushes(int pushes) {
        this.pushes = pushes;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
   public void ShowAchievements(ArrayList<Achievements> achievements, Pane[] LevelsPane, HBox [] timeLevel, Label [] movesLabels, Label[] timerLabels, ProgressBar [] progress){
       counter=0;
       int Moves;
       int Timer;
       int movesX;
       int timerX;
       double ProgressLevel;
       for (int j = 0; j < 12; j++) {
            movesX=0;
            timerX=0;
            Moves=1000;
            Timer=1000;
            ProgressLevel = 0.0;
           for (int i = 0; i < achievements.size(); i++) {
              
               if(achievements.get(i).getLevel() == Levels[j] && achievements.get(i).getMoves() <= MovesAchievements[j] &&  achievements.get(i).getMoves() !=0){
                    if(Moves > achievements.get(i).getMoves()){
                        Moves = achievements.get(i).getMoves();
                        movesX = i;
                        Tooltip tooltip =  new Tooltip("Player:" + achievements.get(movesX).getNombre() + " Moves: " + achievements.get(movesX).getMoves() + " Pushes: " + achievements.get(movesX).getPushes());
                        movesLabels[j].setTooltip(tooltip);
                    }
                    LevelsPane[j].setOpacity(0.99);  
               }
               if(achievements.get(i).getLevel() == Levels[j] && achievements.get(i).getTime()<= TimeLevel[j] &&  achievements.get(i).getTime()!=0){   
                   timeLevel[j].setOpacity(0.99);
                   if(Timer > achievements.get(i).getTime()){
                        Timer= achievements.get(i).getTime();
                        timerX = i;
                        Tooltip tooltip =  new Tooltip("Player: " + achievements.get(timerX).getNombre() + " Time: " + achievements.get(timerX).getTime() + " seconds");
                        timerLabels[j].setTooltip(tooltip);
                    }
                }
                if(achievements.get(i).getLevel() == Levels[j] && achievements.get(i).getBoxesCount() > ProgressLevel){
                   
                    ProgressLevel = achievements.get(i).getBoxesCount(); 
                    progress[j].setProgress(ProgressLevel);
               } 
                if(achievements.get(i).getLevel() == Levels[j] && founded==false){
                  counter +=1;
                  founded=true;
                  if(achievements.get(i).getTime()<= TimeLevel[j] &&  achievements.get(i).getTime()!=0){
                        counter +=1;
                  }
                }
               
               
       }
           founded=false;
    }
       if(counter==24){setShowMessageWin(true);}
      
   }
    public boolean checkIfLevelItsCompleted(ArrayList<Achievements> achievements){
      
        for (int j = 0; j < 12; j++) {      
           for (int i = 0; i < achievements.size(); i++) {
               if(achievements.get(i).getLevel() == Levels[j]){
                   return true;
                }  
       }
       }
       return false; 
    }
}
