/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Punto implements Comparable<Punto>{
    
    private Double x;
    private Double y;
    
    public Punto(){
        this.x = null;
        this.y = null;
    }
    
    public Punto(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
    
    @Override
    public int compareTo(Punto t) {
        return (int) (this.x - t.x - this.y - t.y);
    }

    @Override
    public String toString() {
        return String.format("{lat: %f, lng: %f}",this.x,this.y);
    }
    
}
