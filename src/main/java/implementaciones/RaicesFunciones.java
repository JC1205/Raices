/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;


import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

/**
 *
 * @author jpdl2
 */
public class RaicesFunciones {
    private int iteraciones;
    private final List<Iteracion> pasos;

    public RaicesFunciones() {
        this.iteraciones = 0;
        this.pasos = new ArrayList<>();
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public List<Iteracion> getPasos() {
        return pasos;
    }

    public double biseccion(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        pasos.clear();
        double xr = 0, xrAnterior = 0, ea = 100;
        iteraciones = 0;

        if (f.applyAsDouble(xi) * f.applyAsDouble(xf) > 0) {
            throw new IllegalArgumentException("El intervalo no es válido");
        }

        do {
            xrAnterior = xr;
            xr = (xi + xf) / 2.0;
            iteraciones++;

            if (iteraciones > 1) {
                ea = Math.abs((xr - xrAnterior) / xr) * 100;
            }

            double fxi = f.applyAsDouble(xi);
            double fxf = f.applyAsDouble(xf);
            double fxr = f.applyAsDouble(xr);

            pasos.add(new Iteracion(iteraciones, xi, xf, xr, fxi, fxf, fxr, ea));

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

        } while (ea > eamax && iteraciones < 1000);

        return xr;
    }

    public double reglaFalsa(DoubleUnaryOperator f, double xi, double xf, double eamax) {
        pasos.clear();
        double xr = 0, xrAnterior = 0, ea = 100;
        iteraciones = 0;

        if (f.applyAsDouble(xi) * f.applyAsDouble(xf) > 0) {
            throw new IllegalArgumentException("El intervalo no es válido");
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

            double fxr = f.applyAsDouble(xr);

            pasos.add(new Iteracion(iteraciones, xi, xf, xr, fxi, fxf, fxr, ea));

            if (fxi * fxr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }

        } while (ea > eamax && iteraciones < 1000);

        return xr;
    }
}