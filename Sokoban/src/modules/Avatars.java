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
public class Avatars {
    
    String [] avatarLeft = new String[] {"/image/Personaje_Left.png", "/image/personaje2_3.png", "/image/personaje3_Left.png", "/image/Personaje4Left.png" };
    String [] avatarRigth = new String[]{"/image/Personaje_Right.png", "/image/personaje2_2.png",  "/image/personaje3_Right.png", "/image/Personaje4Right.png"};
    String [] avatarUp = new String[] {"/image/personajeUPP.png", "/image/personaje2_.png",  "/image/personaje3_UP.png", "/image/Personaje4UP.png"};
    String [] avatarDown = new String[] {"/image/personaje.png", "/image/personaje2_1.png",  "/image/personaje3_Down.png",  "/image/Personaje4Down.png"};
    
    
    public String getAvatarLeft(int position){
      return avatarLeft[position];
    }
    public String getAvatarRigth(int position){
      return avatarRigth[position];
    }
    public String getAvatarUP(int position){
      return avatarUp[position];
    }
    public String getAvatarDown(int position){
      return avatarDown[position];
    }
}
