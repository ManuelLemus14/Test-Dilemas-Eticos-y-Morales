/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

/**
 *
 * @author manue
 */
public class InfoUsuario {
    String Nombre,Apellido;
    int TiempoI,TiempoF;
    
         public void getNombres(String nomUsuario){
          Nombre=nomUsuario;
        }
        
        public String setNombres(){   
         return Nombre;   
        }
        
        public void getApellidos(String apeUsuario){
            Apellido=apeUsuario;
        }
        
        public String setApellidos(){
          return Apellido; 
        }
        
}
