public class RingBase<T> implements Ring<T> {
    public Monoid<T> monoidMultiply; // Моноид по умножению
    public Group<T> groupSum; // Группа по сложению

    // Конструктор класса
    public RingBase(Monoid<T> monoidMultiply, Group<T> groupSum) {
        this.monoidMultiply = monoidMultiply;
        this.groupSum = groupSum;
    }

    @Override
    public T getNElOne() {
        return monoidMultiply.getNEl();
    }

    @Override
    public T getMultiply(T x, T y) {
        return monoidMultiply.getBinOperation(x, y);
    }

    @Override
    public T getNElZero() {
        return groupSum.getNEl();
    }

    @Override
    public T getSum(T x, T y) {
        return groupSum.getBinOperation(x, y);
    }

    @Override
    public T unaryMinus(T z) {
        return groupSum.inverse(z);
    }
}
