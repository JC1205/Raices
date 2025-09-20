/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

/**
 *
 * @author jpdl2
 */
public class Iteracion {

        private int n;
        private double xi;
        private double xf;
        private double xr;
        private double fxi;
        private double fxf;
        private double fxr;
        private double ea;

        public Iteracion(int n, double xi, double xf, double xr, double fxi, double fxf, double fxr, double ea) {
            this.n = n;
            this.xi = xi;
            this.xf = xf;
            this.xr = xr;
            this.fxi = fxi;
            this.fxf = fxf;
            this.fxr = fxr;
            this.ea = ea;
        }

        public Object[] toRow() {
            return new Object[]{
                n,
                String.format("%.6f", xi),
                String.format("%.6f", xf),
                String.format("%.6f", xr),
                String.format("%.6f", fxi),
                String.format("%.6f", fxf),
                String.format("%.6f", fxr),
                String.format("%.6f", ea)
            };
        }
    }

