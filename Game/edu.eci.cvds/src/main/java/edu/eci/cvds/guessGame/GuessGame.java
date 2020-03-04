/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.guessGame;

import java.util.ArrayList;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
    private String estado;
    
    public GuessGame() {
        numero = new Random().nextInt(100);
        intento = 0;
        puntaje = 0;
        perdidos = 10000;
        estado = "inicio";

    }


        public void guess ( int validar){
            intento++;
            estado = "no gano";
            if (numero == validar) {
                puntaje = 100000 - (perdidos * intento);
                if (puntaje < 0) {
                    puntaje = 0;
                    estado = "puntos insuficientes";
                } else {
                    estado = "gano";
                }

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Has Adivinado el Numero de la ronda anterior!, tu puntaje fue: ", " " + puntaje+ " y con una cantidad de " + intento + " intentos ;) El juego se Ha reiniciado "));
                restart();
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
