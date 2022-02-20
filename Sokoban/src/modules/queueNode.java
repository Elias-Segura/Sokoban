/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;
import modules.Point;
/**
 *
 * @author Elias
 */
public class queueNode {
    Point pt;
    int dist;

    public queueNode(Point pt, int dist) {
        this.pt = pt;
        this.dist = dist;
    }
    
}
