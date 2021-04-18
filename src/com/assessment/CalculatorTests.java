package com.assessment;


import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTests {

   private final StringCalculator calculator = new StringCalculator();

   @Rule
   public ExpectedException thrown = ExpectedException.none();


   @Test
   public void emptyString() {
      assertEquals(0,calculator.Add(""));
   }

   @Test
   public void oneNumber() {
      assertEquals(1,calculator.Add("1"));
   }

   @Test
   public void twoNumbers() {
      assertEquals(3,calculator.Add("1,2"));
   }

   @Test
   public void unknownAmountNumbers() {
      assertEquals(6,calculator.Add("1,2,3"));
   }

   @Test
   public void newLinesBwNumbers() {
      assertEquals(6,calculator.Add("1\n2,3"));
   }

   /**
    * “//[delimiter]\n[numbers…]”
    */

   @Test
   public void differentDelimiters() {
      assertEquals(3,calculator.Add("//;\n1;2"));
   }

   @Test
   public void negativeNumbers() {

      thrown.expect(RuntimeException.class);
      thrown.expectMessage("negatives not allowed -> -1,-2");

      assertEquals(6,calculator.Add("-1,-2,-3,4,5"));
   }

   /**
    * Numbers bigger than 1000 should be ignored
    */

   @Test
   public void biggerThan1000() {
      assertEquals(1003,calculator.Add("//;\n1;2,3000,2000;1000"));
   }


}
