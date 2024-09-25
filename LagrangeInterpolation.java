package lagrangeinterpolation;
import java.math.BigInteger;

public class LagrangeInterpolation {

    private static BigInteger decodeValue(String value, int base) {
        return new BigInteger(value, base);
    }

    private static double lagrangeInterpolation(int[] x, BigInteger[] y, int n) {
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            BigInteger term = y[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    term = term.multiply(BigInteger.valueOf(0 - x[j]))
                                .divide(BigInteger.valueOf(x[i] - x[j]));
                }
            }
            result += term.doubleValue();
        }

        return result;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int k1 = 3;
        int[] x1 = {1, 2, 3, 6};
        BigInteger[] y1 = {
            decodeValue("4", 10),
            decodeValue("111", 2),
            decodeValue("12", 10),
            decodeValue("213", 4)
        };

        int n2 = 9;
        int k2 = 6;
        int[] x2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BigInteger[] y2 = {
            decodeValue("28735619723837", 10),
            decodeValue("1A228867F0CA", 16),
            decodeValue("32811A4AA0B7B", 12),
            decodeValue("917978721331A", 11),
            decodeValue("1A22886782E1", 16),
            decodeValue("28735619654702", 10),
            decodeValue("71AB5070CC4B", 14),
            decodeValue("122662581541670", 9),
            decodeValue("642121030037605", 8)
        };

        double c1 = lagrangeInterpolation(x1, y1, k1);
        double c2 = lagrangeInterpolation(x2, y2, k2);

        System.out.printf("The constant term (c) for the first test case is: %f%n", c1);
        System.out.printf("The constant term (c) for the second test case is: %f%n", c2);
    }
}
