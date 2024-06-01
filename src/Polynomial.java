import java.util.ArrayList;
import java.util.List;

public class Polynomial<T> {
    private final Ring<T> ring;
    public final List<T> coefficients;

    public Polynomial(Ring<T> ring, List<T> coefficients) {
        this.ring = ring;
        this.coefficients = coefficients;
    }

    public T getCoefficient(int degree) {
        if (degree >= coefficients.size()) {
            return ring.getNElZero();
        }
        return coefficients.get(degree);
    }

    public Polynomial<T> sum(Polynomial<T> other) {
        int maxDegree = Math.max(this.coefficients.size(), other.coefficients.size());
        List<T> resultCoefficients = new ArrayList<>(maxDegree);

        for (int i = 0; i < maxDegree; i++) {
            T thisCoeff = (i < this.coefficients.size()) ? this.coefficients.get(i) : null;
            T otherCoeff = (i < other.coefficients.size()) ? other.coefficients.get(i) : null;

            if (thisCoeff == null) {
                resultCoefficients.add(otherCoeff);
            } else if (otherCoeff == null) {
                resultCoefficients.add(thisCoeff);
            } else {
                resultCoefficients.add(ring.sum(thisCoeff, otherCoeff));
            }
        }

        return new Polynomial<>(ring, resultCoefficients);
    }

    public Polynomial<T> multiply(Polynomial<T> other) {
        int thisDegree = this.coefficients.size();
        int otherDegree = other.coefficients.size();
        int resultDegree = thisDegree + otherDegree - 1;
        List<T> resultCoefficients = new ArrayList<>(resultDegree);

        for (int i = 0; i < resultDegree; i++) {
            resultCoefficients.add(ring.getNElZero());
        }

        for (int i = 0; i < thisDegree; i++) {
            for (int j = 0; j < otherDegree; j++) {
                T product = ring.multiply(this.getCoefficient(i), other.getCoefficient(j));
                resultCoefficients.set(i + j, ring.sum(resultCoefficients.get(i + j), product));
            }
        }

        return new Polynomial<>(ring, resultCoefficients);
    }

    public Polynomial<T> subtract(Polynomial<T> other) {
        int maxDegree = Math.max(this.coefficients.size(), other.coefficients.size());
        List<T> resultCoefficients = new ArrayList<>(maxDegree);

        for (int i = 0; i < maxDegree; i++) {
            T thisCoeff = (i < this.coefficients.size()) ? this.coefficients.get(i) : null;
            T otherCoeff = (i < other.coefficients.size()) ? other.coefficients.get(i) : null;

            if (thisCoeff == null) {
                resultCoefficients.add(ring.multiply(otherCoeff, ring.unaryMinus(ring.getNElOne())));
            } else if (otherCoeff == null) {
                resultCoefficients.add(thisCoeff);
            } else {
                resultCoefficients.add(ring.sum(thisCoeff, ring.unaryMinus(otherCoeff)));
            }
        }

        return new Polynomial<>(ring, resultCoefficients);
    }
}
