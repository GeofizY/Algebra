interface Group<T> extends Monoid<T> {
    T inverse(T a);
}