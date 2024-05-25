public interface Monoid<T> {
    T getNEl(); // Получение нейтрального элемента
    T binOperation(T x, T y); // Получений результата бинарной операции
}
