/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ek.ieslaencanta.com.spaceinvaderes2;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

/**
 *
 * @author kirae
 */
public class Wall {
    private Point2D posicion;
    private static int WIDTH=7;
    private static int HEIGHT=2;
    private char cartoon [][]= 
    {
        {'⣿', '⣿', '⣿', '⣿', '⣿', '⣿', '⣿'},
        {'⣿', '⣿', '⣿', '⣿', '⣿', '⣿', '⣿'}
    };
    
    public Wall() {
       this.posicion = new Point2D();
    }   
    public Wall(Point2D posicion) {
        this.posicion = posicion;
    }
    public Wall(int x, int y) {
       this.posicion = new Point2D(x, y);
    }
    
public void paint(Screen s){
        char c;
        for(int i=0; i<this.HEIGHT; i++){
            for(int j=0; j<this.WIDTH; j++){
                c=this.cartoon[i][j];
                 s.setCharacter(this.getPosicion().getX() + j,
                         this.getPosicion().getY() + i,
                new TextCharacter(c,TextColor.ANSI.WHITE, TextColor.ANSI.YELLOW));
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
     * @param posicion the posicion to set
     */
    public void setPosicion(Point2D posicion) {
        this.posicion = posicion;
    }
   public boolean collission (Bullet b){
       boolean collission=false;
       int coordenadax, coordenaday;
      /* if (this.posicion.getY()<=b.getPosicion().getY() 
               && this.posicion.getY()+Wall.HEIGHT > b.getPosicion().getY()
               && this.posicion.getX()<=b.getPosicion().getX() 
               && this.posicion.getX()+Wall.WIDTH > b.getPosicion().getX())*/
      if (this.posicion.getY()<=b.getPosicion().getY() 
               && this.posicion.getY()+2 > b.getPosicion().getY()
               && this.posicion.getX()<=b.getPosicion().getX() 
               && this.posicion.getX()+Wall.WIDTH > b.getPosicion().getX())  {
           coordenadax=b.getPosicion().getX()- this.posicion.getX();
           coordenaday=b.getPosicion().getY()- this.posicion.getY();
           if(this.cartoon[coordenaday][coordenadax]!=' '){
               collission=true;
               this.cartoon[coordenaday][coordenadax]=' ';
           }    
       }
       return collission;
   }
}
