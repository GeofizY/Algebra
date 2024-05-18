public class SegmentTree<T> {
    private Object[] tree;
    private int n;
    private Monoid<T> monoid;

    public SegmentTree(T[] array, Monoid<T> monoid) {
        this.n = array.length;
        this.monoid = monoid;
        this.tree = new Object[2 * n];
        build(array);
    }

    private void build(T[] array) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = array[i];
        }
        for (int i = n - 1; i > 0; --i) {
            tree[i] = monoid.getBinOperation((T) tree[2 * i], (T) tree[2 * i + 1]);
        }
    }

    public T query(int left, int right) {
        T result = monoid.getNEl();
        left += n;
        right += n + 1;
        while (left < right) {
            if ((left & 1) == 1) {
                result = monoid.getBinOperation(result, (T) tree[left++]);
            }
            if ((right & 1) == 1) {
                result = monoid.getBinOperation(result, (T) tree[--right]);
            }
            left /= 2;
            right /= 2;
        }
        return result;
    }
}