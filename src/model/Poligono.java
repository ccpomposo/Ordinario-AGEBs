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
public class Poligono implements Comparable<Poligono>{

    private ListaDoble<Punto> puntos;
    private String nombre;

    public Poligono(String nombre) {
        this.puntos = new ListaDoble();
        this.nombre = nombre;
    }

    public Poligono(String nombre,ListaDoble<Punto> puntos) {
        this.puntos = puntos;
        this.nombre = nombre;
    }

    public void addPunto(Punto punto) {
        this.puntos.insertarFinal(punto);
    }

    public ListaDoble<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(ListaDoble<Punto> puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public String toString() {
        String rs = "[";
        for (Object punto : puntos) {
            rs += ((Punto) punto).toString() + ",\n";

        }
        rs += this.puntos.getInicio().getDato().toString() + "];\n";
        return rs;
    }

    @Override
    public int compareTo(Poligono t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
