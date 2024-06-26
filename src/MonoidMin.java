public class MonoidMin implements Monoid<Double> {
    @Override
    public Double getNEl() {
        return Double.MAX_VALUE; // Нейтральный элемент
    }

    @Override
    public Double binOperation(Double x, Double y) {
        return Math.min(x, y); // Взятие минимума
    }
}