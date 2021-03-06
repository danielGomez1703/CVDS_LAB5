/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.guessGame;

import java.util.ArrayList;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "guessBean")
@SessionScoped

/**
 *
 * @author daniel.gomez-su
 * 
 */
public class GuessGame { 
        
    private int numero;
    private int intento;
    private int puntaje;
    private int perdidos;
    private int intentar;
    private String estado;
    private ArrayList intentos;
    
    public GuessGame() {
        numero = new Random().nextInt(100);
        intento = 0;
        puntaje = 0;
        perdidos = 10000;
        estado = "inicio";
        intentos = new ArrayList<Integer> ();

    }

    public ArrayList getIntentos() {
        return intentos;
    }

    public void setIntentos(ArrayList intentos) {
        this.intentos = intentos;
    }

    public int getIntentar() {
        return intentar;
    }

    public void setIntentar(int intentar) {
        this.intentar = intentar;
    }


    public void guess ( int validar){
            intento++;
            intentar = validar;
            estado = "no gano";
            System.out.println(validar);
            if (!intentos.contains(validar)){
                intentos.add(validar);
            }
            
            if (numero == validar) {
                puntaje = 100000 - (perdidos * intento);
                if (puntaje < 0) {
                    puntaje = 0;
                    estado = "puntos insuficientes";
                } else {
                    estado = "gano";
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Has Adivinado el Numero de la ronda anterior!, tu puntaje fue: ", " " + puntaje+ " y con una cantidad de " + intento + " intentos ;) El juego se Ha reiniciado "));
                //restart();
            } else {
                estado = "lo sentimos, vuelve a intentarlo";
            }

        }

    
    public void restart () {
        numero = new Random().nextInt(100);
        intento = 0;
        puntaje = 0;
        perdidos = 10000;
        estado = "inicio";
        intentos = new ArrayList<Integer> ();

    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
