public class GroupBool implements Group<Boolean> {
    @Override
    public Boolean getNEl() {
        return false; // Нейтральный элемент
    }
    @Override
    public Boolean binOperation(Boolean x, Boolean y) {
        return x || y; // Логическая операция +
    }
    @Override
    public Boolean inverse(Boolean x) {
        return !x; // Обратный элемент
    }
}
