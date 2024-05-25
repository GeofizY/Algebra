public class MonoidMultiply implements Monoid<Integer> {
    @Override
    public Integer getNEl() {
        return 1; // Нейтральный элемент
    }

    @Override
    public Integer binOperation(Integer x, Integer y) {
        return x * y; // Нахождение произведения
    }
}
