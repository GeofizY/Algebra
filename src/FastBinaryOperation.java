public class FastBinaryOperation<T> {
    private final Monoid<T> monoid;

    public FastBinaryOperation(Monoid<T> monoid) {
        this.monoid = monoid;
    }
    public T getBaseInExponent(T base, int exponent){
        T result = monoid.getNEl();
        T mult = base;
        if (exponent == 0) return result;
        while (exponent != 0) {
            if (exponent % 2 == 1)
                result = monoid.binOperation(result, mult);
            mult = monoid.binOperation(mult, mult);
            exponent /= 2;
        }
        return result;
    }
}
