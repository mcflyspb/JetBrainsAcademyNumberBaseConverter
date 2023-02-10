import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        BigInteger result = new BigInteger(String.valueOf(1));
        for (int x = n; x > 0; x -= 2) {
            result = result.multiply(BigInteger.valueOf(x));
        }
        return result;
    }
}