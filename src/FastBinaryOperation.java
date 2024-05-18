public class FastBinaryOperation<T> {
    public T getBaseInExponent(T base, int exponent, Monoid<T> monoid){
        T result = monoid.getNEl();
        T mult = base;
        if (exponent == 0) return result;
        while (exponent != 0) {
            if (exponent % 2 == 1)
                result = monoid.getBinOperation(result, mult);
            mult = monoid.getBinOperation(mult, mult);
            exponent /= 2;
        }
        return result;
    }
}
