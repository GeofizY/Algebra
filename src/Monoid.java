public interface Monoid<T> {
    T getNEl(); // Получение нейтрального элемента
    T getBinOperation(T x, T y); // Получений результата бинарной операции
}
