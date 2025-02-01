    public class BMICalculator {
        // Attribute
        private String firstname;
        private String lastname;
        private int bodyHeight;     // in cm
        private double bodyWeight;  // in kg
        private char gender;        // 'm' oder 'w'

        // Konstruktor: Initialisiert alle Attribute
        public BMICalculator(String firstname, String lastname, int bodyHeight, double bodyWeight, char gender) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.bodyHeight = bodyHeight;
            this.bodyWeight = bodyWeight;
            this.gender = gender;
        }

        // Getter-Methoden
        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public int getBodyHeight() {
            return bodyHeight;
        }

        public double getBodyWeight() {
            return bodyWeight;
        }

        public char getGender() {
            return gender;
        }

        // Setter für bodyHeight und bodyWeight
        public void setBodyHeight(int bodyHeight) {
            this.bodyHeight = bodyHeight;
        }

        public void setBodyWeight(double bodyWeight) {
            this.bodyWeight = bodyWeight;
        }

        /**
         * Berechnet den BMI:
         * BMI = bodyWeight / ((bodyHeight / 100)^2)
         * und rundet das Ergebnis auf 2 Dezimalstellen.
         */
        public double calculateBMI() {
            double bmi = bodyWeight / Math.pow(bodyHeight / 100.0, 2);
            return round(bmi);
        }

        // Private Hilfsmethode zum Runden auf 2 Dezimalstellen
        private double round(double value) {
            return Math.round(value * 100) / 100.0;
        }

        /**
         * Berechnet die BMI-Kategorie basierend auf dem BMI und Geschlecht.
         *
         * Für männlich:
         *   - BMI < 16.0         : -2
         *   - 16.0 <= BMI < 18.5   : -1
         *   - 18.5 <= BMI < 25.0   : 0
         *   - 25.0 <= BMI < 35.0   : 1
         *   - BMI >= 35.0          : 2
         *
         * Für weiblich:
         *   - BMI < 15.0         : -2
         *   - 15.0 <= BMI < 17.5   : -1
         *   - 17.5 <= BMI < 24.0   : 0
         *   - 24.0 <= BMI < 34.0   : 1
         *   - BMI >= 34.0          : 2
         */
        public int calculateBMICategory() {
            double bmi = calculateBMI();
            if (gender == 'm' || gender == 'M') {
                if (bmi < 16.0) {
                    return -2;
                } else if (bmi < 18.5) {
                    return -1;
                } else if (bmi < 25.0) {
                    return 0;
                } else if (bmi < 35.0) {
                    return 1;
                } else {
                    return 2;
                }
            } else if (gender == 'w' || gender == 'W') {
                if (bmi < 15.0) {
                    return -2;
                } else if (bmi < 17.5) {
                    return -1;
                } else if (bmi < 24.0) {
                    return 0;
                } else if (bmi < 34.0) {
                    return 1;
                } else {
                    return 2;
                }
            }
            throw new IllegalArgumentException("Ungültiger Geschlechtswert: " + gender);
        }

        /**
         * Gibt den Namen der BMI-Kategorie zurück, basierend auf calculateBMICategory():
         * -2 -> "Sehr starkes Untergewicht"
         * -1 -> "Untergewicht"
         *  0 -> "Normalgewicht"
         *  1 -> "Übergewicht"
         *  2 -> "Sehr starkes Übergewicht"
         */
        public String getBMICategoryName() {
            int category = calculateBMICategory();
            switch (category) {
                case -2:
                    return "Sehr starkes Untergewicht";
                case -1:
                    return "Untergewicht";
                case 0:
                    return "Normalgewicht";
                case 1:
                    return "Übergewicht";
                case 2:
                    return "Sehr starkes Übergewicht";
                default:
                    return "Unbekannte Kategorie";
            }
        }
    }


