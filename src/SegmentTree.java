public class SegmentTree<T> {
    private final Monoid<T> monoid;
    private final T[] tree;
    private final int size;

    @SuppressWarnings("unchecked")
    public SegmentTree(T[] array, Monoid<T> monoid) {
        this.monoid = monoid;
        this.size = array.length;
        this.tree = (T[]) new Object[2 * size];
        buildTree(array);
    }

    private void buildTree(T[] array) {
        System.arraycopy(array, 0, tree, size, size);
        for (int i = size - 1; i > 0; i--) {
            tree[i] = monoid.binOperation(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    public T query(int left, int right) {
        T result = monoid.getNEl();
        left += size;
        right += size + 1;
        while (left < right) {
            if ((left & 1) == 1) {
                result = monoid.binOperation(result, (T) tree[left++]);
            }
            if ((right & 1) == 1) {
                result = monoid.binOperation(result, (T) tree[--right]);
            }
            left /= 2;
            right /= 2;
        }
        return result;
    }
}