package com.tests;

import com.hillel.SquareEquation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 20.04.2016.
 */
public class SquareEquationTest {
    public static final double ACCURACY = 1e-10;
    @Test
    public void solveTwoRoots()  {
        SquareEquation eq = new SquareEquation(1. , -5. , 6.);
        double [] result = eq.solve();
        assertNotNull( "result must be not null" ,  result );
        assertEquals(  "have to be 2 roots" , 2, result.length );
        assertTrue(
                ( Math.abs( result[0] - 2.0 ) < ACCURACY )
                 && ( Math.abs( result[1] - 3.0 ) < ACCURACY )
                || ( Math.abs( result[0] - 3.0 ) < ACCURACY )
                        && ( Math.abs( result[1] - 2.0 ) < ACCURACY ) );
    }
    @Test
    public void solveOneRoot(){
        SquareEquation eq = new SquareEquation(2. , -4. , 2.);
        double [] result = eq.solve();
        assertNotNull( "result must be not null" ,  result );
        assertEquals(  "have to be 1 roots" , 1, result.length );
        assertEquals( 1. , result[0] , ACCURACY );

    }
    @Test
    public void solveNoRoots(){
        SquareEquation eq = new SquareEquation(2. , 2. , 2.);
        double [] result = eq.solve();
        assertNotNull( "result must be not null" ,  result );
        assertEquals(  "have to be no1 roots" , 0, result.length );
    }
    @Test(expected = IllegalArgumentException.class )
    public void notSquareEquation(){
        SquareEquation eq = new SquareEquation(0 , 2. , 2.);
        double [] result = eq.solve();
    }

}