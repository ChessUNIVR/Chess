package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;

/**
 *
 * @author Matteo
 */
public class Bottone extends JButton {
    private int x;
    private int y;
    
    public Bottone(){
        super();
    }
    public Bottone(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }
 
    public int getXb() {
        return x;
    }
    
    public int getYb() {
        return y;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
