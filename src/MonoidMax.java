public class MonoidMax implements Monoid<Integer> {
    @Override
    public Integer getNEl() {
        return 0; // Нейтральный элемент
    }

    @Override
    public Integer getBinOperation(Integer x, Integer y) {
        return Math.max(x, y); // Взятие максимума
    }
}
