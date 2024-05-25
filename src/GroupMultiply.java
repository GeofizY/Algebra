public class GroupMultiply implements Group<Double> {
    @Override
    public Double getNEl() {
        return 1.0;
    }

    @Override
    public Double getBinOperation(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double inverse(Double x) {
        if (x == 0) throw new ArithmeticException("Cannot invert zero");
        return 1 / x;
    }
}

