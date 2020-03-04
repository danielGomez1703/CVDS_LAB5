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
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "guessBean")
@SessionScoped
/**
 *
 * @author daniel.gomez-su
 */
public class GuessGame { 
    
    private int numero;
    private int intento;
    private int puntaje;
    private int perdidos;
    
    
    public GuessGame (){
        
        numero = new Random().nextInt(100);
        intento=0;
        puntaje=0;
        perdidos=100000;
        
        
    }
    
   public void jugar (int intento){
       if (!(intento == numero)){
           
       }
     
   }
    
             
      
    
}
