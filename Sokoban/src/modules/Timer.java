/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Elias Segura
 */
public class Timer {
    private int i;

    public int getI() {
        return i;
    }
    private boolean  run = true ;
    public void ShowTimer( MouseEvent event, Label TiempoLevel, int counter){
     this.i = counter;
     Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        TiempoLevel.setText("Time: "+Integer.toString(i));
                        i+=1;
                    }
                };
                while (run) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    Platform.runLater(updater);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    public void StopTimer(){
      run = false;
    }
}
