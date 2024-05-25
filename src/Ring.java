public interface Ring<T> {
    T getNElOne(); // Выделенный элемент 1
    T getMultiply(T x, T y); // Бинарная опреация - умножение
    T getNElZero(); // Выделенный элемент 0
    T getSum(T x, T y); // Бинарная опреация - сложение
    T unaryMinus(T z); // Унарный минус
}