package SetsAndMapsAdvanced;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        double[] grades = {3.10, 5.35, 3.30, 3.35, 5.64, 4.99, 2.75, 4.68};

        double sum = 0;
        for (double e:grades) {
            sum += e;
        }

        BigDecimal avg = new BigDecimal(sum).divide(new BigDecimal(grades.length));
    }




}
