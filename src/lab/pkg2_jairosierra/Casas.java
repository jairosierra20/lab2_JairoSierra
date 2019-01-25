/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg2_jairosierra;

/**
 *
 * @author Jairo Sierra
 */
public class Casas {
    //Atributos
    private String nombre,color,estado,ingeniero;
    private int banos,cuartos,casa,compra,pisos,bloque;
            private double ancho,largo;
    //Constructores
    public Casas(){
        
    }
    public Casas(String estado,String nombre,String color,int banos,int cuartos,int casa,int compra,int pisos,double ancho,double largo,int bloque,String ingeniero){
        this.nombre=nombre;
        this.color=color;
        this.banos=banos;
        this.cuartos=cuartos;
        this.casa=casa;
        this.compra=compra;
        this.pisos=pisos;
        this.ancho=ancho;
        this.largo=largo;
        this.bloque=bloque;
        this.ingeniero=ingeniero;
        this.estado=estado;
    }
    //Mutadores
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public String getnombre(){
        return nombre;
    }
    public void setingeniero(String ingeniero){
        this.ingeniero=ingeniero;
    }
    public String getingeniero(){
        return ingeniero;
    }
    public void setcolor(String color){
        this.color=color;
    }
    public String getcolor(){
        return color;
    }
    public void setbanos(int banos){
        this.banos=banos;
    }
    public int getbanos(){
        return banos;
    }
    public void setcuartos(int cuartos){
        this.cuartos=cuartos;
    }
    public int getcuartos(){
        return cuartos;
    }
    public void setcasa(int casa){
        this.casa=casa;
    }
    public int getcasa(){
        return casa;
    }
    public void setcompra(int compra){
        this.compra=compra;
    }
    public int getcompra(){
        return compra;
    }
    public void setpisos(int pisos){
        this.pisos=pisos;
    }
    public int getpisos(){
        return pisos;
    }
    public void setbloque(int bloque){
        this.bloque=bloque;
    }
    public int getbloque(){
        return bloque;
    }
    public void setancho(double ancho){
        this.ancho=ancho;
    }
    public double getancho(){
        return ancho;
    }
    public void setlargo(double largo){
        this.largo=largo;
    }
    public double getlargo(){
        return largo;
    }
     public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    //ma
    public String toString(){
        String casa1="";
        if(compra == 1){
            casa1+="\nYa fue comprada "+"\nNombre del comprador = "+nombre;
        }
        else{
            casa1+="\nNo fue comprada";
        }
        return casa1+="\nNumero de casa = "+casa+"\nNumero de bloque = "+bloque+"\nColor = "+color+"\nAncho = "+ancho+"\nLargo = "+largo+"\nNumero de pisos = "+pisos+"\nNumero de baños = "+banos+"\nNumero de cuartos = "+cuartos+"\nEstado = "+estado+"\nNombre del ingeniero a cargo = "+ingeniero;
    }

}
