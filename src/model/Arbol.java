/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class Arbol<T extends Comparable<T>> implements Comparable<Arbol>{

    private Nodo<T> raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(T elemento) {
        Nodo<T> nuevo = new Nodo(elemento);
        if (this.raiz == null) {
            this.raiz = nuevo;
        } else {
            Nodo<T> aux = this.raiz;
            Nodo<T> ant = null;
            while (aux != null) {
                ant = aux;
                if (elemento.compareTo(aux.getDato()) > 0) {
                    aux = aux.getDerecha();
                } else {
                    aux = aux.getIzquierda();
                }
            }
            if (elemento.compareTo(ant.getDato()) > 0) {
                ant.setDerecha(nuevo);
            } else {
                ant.setIzquierda(nuevo);
            }
        }
    }
    

    public void imprimirInOrden() {
        imprimirInOrden(this.raiz);
    }

    private void imprimirInOrden(Nodo<T> raiz) {
        if (raiz != null) {
            imprimirInOrden(raiz.getIzquierda());
            System.out.println(raiz.getDato());
            imprimirInOrden(raiz.getDerecha());
        }
    }
    
    private Nodo<T> girarIzquierda(Nodo<T> nodo) {
        if (nodo.getDerecha() != null) {
            Nodo<T> derecho = nodo.getDerecha();
            nodo.setDerecha(derecho.getDerecha());
            derecho.setDerecha(derecho.getIzquierda());
            derecho.setIzquierda(nodo.getIzquierda());
            nodo.setIzquierda(derecho);

            T aux = nodo.getDato();
            nodo.setDato(derecho.getDato());
            derecho.setDato(aux);
        }
        return nodo;
    }
    
    private Nodo<T> girarDerecha(Nodo<T> nodo) {
        if (nodo.getDerecha() != null) {
            Nodo<T> izquierdo = nodo.getIzquierda();
            nodo.setIzquierda(izquierdo.getIzquierda());
            izquierdo.setIzquierda(izquierdo.getDerecha());
            izquierdo.setDerecha(nodo.getDerecha());
            nodo.setDerecha(izquierdo);
            
            T aux = nodo.getDato();
            nodo.setDato(izquierdo.getDato());
            izquierdo.setDato(aux);
        }
        return nodo;
    }
    
    private Nodo<T> crearRamaDerecha(Nodo raiz) {
        while(raiz.getIzquierda() != null) {
            raiz = girarDerecha(raiz);
        }
        if (raiz.getDerecha() != null) {
            raiz.setDerecha(crearRamaDerecha(raiz.getDerecha()));
        }
        return raiz;
    }
    
    private int contarNodos(Nodo<T> raiz) {
        String rs;
        
        if(raiz == null) {
            return 0;
        }
        int cont = 1;
        while (raiz.getDerecha() != null) {
            raiz = raiz.getDerecha();
            cont++;
        }
        return cont;
    }
    
    
    public boolean isVacio() {
        return this.raiz == null;
    }

    @Override
    public int compareTo(Arbol t) {
        return this.raiz.compareTo(t.raiz);
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }
    
    
}
