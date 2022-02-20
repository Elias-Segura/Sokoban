/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

/**
 *
 * @author Elias
 */
public class Moves {
    
    private int moves ;
    private int pushes; 
    public Moves() {
        this(0,0);
    }

    public Moves(int moves, int pushes) {
        this.moves = moves;
        this.pushes = pushes;
    }
    public String getMovesString() {
        return Integer.toString(moves);
    }
    public String getPushesString(){
       return  Integer.toString(pushes);
    }
    public  int getMoves(){
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
    
    public void Moves(int move){
        setMoves(this.getMoves() + move);
        
    }
     public void Pushes(int pushes){
        setPushes(this.getPushes() + pushes);
        
    }
}
