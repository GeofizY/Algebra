public class MonoidBool implements Monoid<Boolean> {
    @Override
    public Boolean getNEl() {
        return true; // Нейтральный элемент
    }

    @Override
    public Boolean getBinOperation(Boolean x, Boolean y) {
        return x && y; // Логическая операция *
    }
}
