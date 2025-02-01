import org.junit.Test;

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
    @Test
    public void testCalculateBMI() {
        // Test 1: bodyHeight = 170 cm, bodyWeight = 70 kg
        BMICalculator bmiCalc1 = new BMICalculator("Anna", "Musterfrau", 170, 70.0, 'w');
        double bmi1 = bmiCalc1.calculateBMI();
        // Erwarteter Wert: ca. 24.22
        org.junit.Assert.assertEquals(24.22, bmi1, 0.01);

        // Test 2: bodyHeight = 180 cm, bodyWeight = 120 kg
        BMICalculator bmiCalc2 = new BMICalculator("John", "Doe", 180, 120.0, 'm');
        double bmi2 = bmiCalc2.calculateBMI();
        // Erwarteter Wert: ca. 37.04
        org.junit.Assert.assertEquals(37.04, bmi2, 0.01);
    }
    @Test
    public void testCalculateBMICategory() {
        // Für weiblich: bodyHeight = 170, bodyWeight = 70 → BMI ca. 24.22 → Kategorie 1 (Übergewicht, da 24.0 bis 33.9)
        BMICalculator bmiCalcFemale = new BMICalculator("Anna", "Musterfrau", 170, 70.0, 'w');
        org.junit.Assert.assertEquals(1, bmiCalcFemale.calculateBMICategory());

        // Für männlich: bodyHeight = 180, bodyWeight = 120 → BMI ca. 37.04 → Kategorie 2 (Sehr starkes Übergewicht, da >= 35.0)
        BMICalculator bmiCalcMale = new BMICalculator("John", "Doe", 180, 120.0, 'm');
        org.junit.Assert.assertEquals(2, bmiCalcMale.calculateBMICategory());
    }
}
