interface Group<T> extends Monoid<T> {
    T inverse(T z); // Обратный элемент бинарной операции
}