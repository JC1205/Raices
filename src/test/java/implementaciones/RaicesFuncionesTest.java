/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementaciones;

import java.util.function.DoubleUnaryOperator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpdl2
 */
public class RaicesFuncionesTest {
    
        @Test
    public void testBiseccionFuncionPolinomio() {
        RaicesFunciones rf = new RaicesFunciones();
        DoubleUnaryOperator f = x -> 4*Math.pow(x, 3) - 6*Math.pow(x, 2) + 7*x - 2.3;
        double raiz = rf.biseccion(f, 0.0, 1.0, 0.0001);
        assertTrue("la raiz no esta en el intervalo [0,1]", raiz >= 0.0 && raiz <= 1.0);
        assertEquals(0.0, f.applyAsDouble(raiz), 1e-2); 
        assertTrue(rf.getIteraciones() > 0);
    }

    @Test
    public void testReglaFalsaFuncionTrigonometrica() {
        RaicesFunciones rf = new RaicesFunciones();
        DoubleUnaryOperator g = x -> x * Math.abs(Math.cos(x)) - 5;
        double raiz = rf.reglaFalsa(g, 5.0, 6.0, 0.0001);

        assertTrue("La raiz no esta en el intervalo [5,6]", raiz >= 5.0 && raiz <= 6.0);
        assertEquals(0.0, g.applyAsDouble(raiz), 1e-2);
        assertTrue(rf.getIteraciones() > 0);
    }

        @Test(expected = IllegalArgumentException.class)
        public void testBiseccionIntervaloInvalido() {
            RaicesFunciones rf = new RaicesFunciones();
            DoubleUnaryOperator f = x -> x*x + 1; 
            rf.biseccion(f, 0.0, 2.0, 0.0001);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testReglaFalsaIntervaloInvalido() {
            RaicesFunciones rf = new RaicesFunciones();
            DoubleUnaryOperator f = x -> x*x + 1; 
            rf.reglaFalsa(f, 0.0, 2.0, 0.0001);
        }
    
}
