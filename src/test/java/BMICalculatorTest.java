public class BMICalculatorTest {

    @org.junit.Test
    public void testConstructorAndGetters() {
        BMICalculator bmiCalc = new BMICalculator("Max", "Mustermann", 180, 80.0, 'm');

        // Überprüfe, ob die Werte korrekt gesetzt wurden:
        org.junit.Assert.assertEquals("Max", bmiCalc.getFirstname());
        org.junit.Assert.assertEquals("Mustermann", bmiCalc.getLastname());
        org.junit.Assert.assertEquals(180, bmiCalc.getBodyHeight());
        org.junit.Assert.assertEquals(80.0, bmiCalc.getBodyWeight(), 0.0);
        org.junit.Assert.assertEquals('m', bmiCalc.getGender());
    }
}
