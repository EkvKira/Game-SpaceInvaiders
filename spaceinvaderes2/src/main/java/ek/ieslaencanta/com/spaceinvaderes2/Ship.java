/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ek.ieslaencanta.com.spaceinvaderes2;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import java.awt.Toolkit;

/**
 *
 * @author kirae
 */
public class Ship {
    private Point2D posicion;
    private int width=7;
    private int height=2;
    private Bullet bullets[];
    private static int max_bullets=5;
    private String cartoon[] = {
          "⢀⣀⣾⣷⣀⡀ ",
          "⣿⣿⣿⣿⣿⣿ "
    };
    
public Ship() {
        this.posicion = new Point2D();
        this.bullets = new Bullet[Ship.max_bullets];

    }
    public Ship(Point2D posicion) {
        this.posicion = posicion;
        this.bullets = new Bullet[Ship.max_bullets];

    }
    public Ship(int x, int y) {
        this.posicion = new Point2D(x, y);
        this.bullets = new Bullet[Ship.max_bullets];

    }
    public void moveHorizontal(int incx, int minx, int maxx) {
        if(this.posicion.getX()+incx>=minx && this.posicion.getX()+incx+this.width<maxx){
            this.posicion.addx(incx);
        }
        else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
//    public Ship(Bullet[] bullets) {
//        this.bullets = bullets;
//        this.init();
//    }

    public void paint(Screen s){
        char c;
        for(int i=0; i<this.height; i++){
            for(int j=0; j<this.width; j++){
                c=this.cartoon[i].charAt(j);
                 s.setCharacter(this.posicion.getX() + j,
                this.posicion.getY() + i,
                new TextCharacter(c,
                TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));
              }
        }
   
        for (int i=0; i<this.bullets.length; i++){
            if (this.bullets[i]!= null) {
            this.bullets[i].paint(s);
            }
        }
    }   
    public void movebullets() {
    for (int i=0; i<this.bullets.length; i++){
            if (this.bullets[i]!= null) {
            this.bullets[i].moveVertical(-1,0,24);
            if(this.bullets[i].getPosicion().getY()<=0){
                this.bullets[i]=new Bullet(); //esli postavit null to bydet besconechnosti
            }
            }
        }
}
    /**
     * @return the posicion
     */
    public Point2D getPosicion() {
        return posicion;
    }

    /**
     * @return the wigth
     */
    public int getWigth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the bullets
     */
    public Bullet[] getBullets() {
        return bullets;
    }
    public void shoot() {
        boolean encontado=false;
        for (int i=0; i<this.bullets.length &&!encontado; i++){
            if(this.bullets[i]==null){
        this.bullets[i]= new Bullet(
                this.posicion.getX()+this.width/2,
                this.posicion.getY()-2);
        encontado=true;
            }
        }
     }
}
