package com.assessment;


import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTests {

   private final StringCalculator calculator = new StringCalculator();


   @Test
   public void emptyString() {
      assertEquals(0,calculator.Add(""));
   }

   @Test
   public void oneNumber() {
      assertEquals(1,calculator.Add("1"));
   }

}
