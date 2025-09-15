/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import java.util.function.DoubleUnaryOperator;

/**
 *
 * @author jpdl2
 */
public class RaicesFunciones {
 private int iteraciones;
    

    public RaicesFunciones() {
        this.iteraciones = 0;
    }
    

    public int getIteraciones() {
        return iteraciones;
    }
    
    /**
     * Método de Biseccion para encontrar raices de funciones
     * @param f funcion de la cual buscar la raiz
     * @param xi valor inicial del intervalo
     * @param xf valor final del intervalo
     * @param eamax error aproximado maximo
     * @return raiz encontrada
     */
    public double biseccion(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        double xr = 0;
        double xrAnterior = 0;
        double ea = 100;
        iteraciones = 0;
        

        if (f.applyAsDouble(xi) * f.applyAsDouble(xf) > 0) {
            throw new IllegalArgumentException("El intervalo no es valido");
        }
        
        do {
            xrAnterior = xr;
            xr = (xi + xf) / 2.0; 
            iteraciones++;
            

            if (iteraciones > 1) {
                ea = Math.abs((xr - xrAnterior) / xr) * 100;
            }
            

            if (f.applyAsDouble(xi) * f.applyAsDouble(xr) < 0) {
                xf = xr; 
            } else {
                xi = xr; 
            }
            
        } while (ea > eamax && iteraciones < 1000); 
        
        return xr;
    }
    
    /**
     * Método de la Regla Falsa para encontrar raices de funciones
     * @param f funcion de la cual buscar la raiz
     * @param xi valor inicial del intervalo
     * @param xf valor final del intervalo
     * @param eamax error aproximado maximo
     * @return raiz encontrada
     */
    public double reglaFalsa(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        double xr = 0; 
        double xrAnterior = 0; 
        double ea = 100;
        iteraciones = 0;
        
        if (f.applyAsDouble(xi) * f.applyAsDouble(xf) > 0) {
            throw new IllegalArgumentException("El inervalo no es valido");
        }
        

        do {
            xrAnterior = xr;
            

            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);
            xr = xf - (fxf * (xi - xf)) / (fxi - fxf);
            
            iteraciones++;
            

            if (iteraciones > 1) {
                ea = Math.abs((xr - xrAnterior) / xr) * 100;
            }
            

            if (f.applyAsDouble(xi) * f.applyAsDouble(xr) < 0) {
                xf = xr; 
            } else {
                xi = xr; 
            }
            
        } while (ea > eamax && iteraciones < 1000); 
        
        return xr;
        
    }
}