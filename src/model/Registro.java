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
public class Registro implements Comparable<Registro>{
    
    private String nombre;
    private String coordX;
    private String coordY;
    
    public Registro() {
        
    }
    
    public Registro(String[] campos) {
        this.nombre = "AGEB"+campos[2];
        this.coordX = campos[1];
        this.coordY = campos[0];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    @Override
    public int compareTo(Registro t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
