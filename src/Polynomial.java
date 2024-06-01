import java.util.ArrayList;
import java.util.List;

public class Polynomial<T> {
    private final Ring<T> ring;
    public final List<T> coefficients;

    public Polynomial(Ring<T> ring, List<T> coefficients) {
        this.ring = ring;
        this.coefficients = coefficients;
    }

    public Polynomial(List<T> coefficients, Ring<T> ring) {
        this.coefficients = new ArrayList<>(coefficients);
        this.ring = ring;
    }

    public T getCoefficient(int degree) {
        if (degree >= coefficients.size()) {
            return ring.getNElZero();
        }
        return coefficients.get(degree);
    }

    public void setCoefficient(int degree, T value) {
        while (degree >= coefficients.size()) {
            coefficients.add(ring.getNElZero());
        }
        coefficients.set(degree, value);
    }

    public Polynomial<T> add(Polynomial<T> other) {
        int maxDegree = Math.max(this.coefficients.size(), other.coefficients.size());
        List<T> resultCoefficients = new ArrayList<>();

        for (int i = 0; i < maxDegree; i++) {
            T a = this.getCoefficient(i);
            T b = other.getCoefficient(i);
            resultCoefficients.add(ring.sum(a, b));
        }

        return new Polynomial<>(resultCoefficients, ring);
    }

    public Polynomial<T> multiply(Polynomial<T> other) {
        int degree = this.coefficients.size() + other.coefficients.size() - 1;
        List<T> resultCoefficients = new ArrayList<>();

        for (int i = 0; i < degree; i++) {
            resultCoefficients.add(ring.getNElZero());
        }

        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < other.coefficients.size(); j++) {
                T product = ring.multiply(this.getCoefficient(i), other.getCoefficient(j));
                resultCoefficients.set(i + j, ring.sum(resultCoefficients.get(i + j), product));
            }
        }

        return new Polynomial<>(resultCoefficients, ring);
    }
}
