public class PrefixSum<T> {
    private final Group<T> group;
    private final T[] prefixSums;

    @SuppressWarnings("unchecked")
    public PrefixSum(T[] array, Group<T> group) {
        this.group = group;
        this.prefixSums = (T[]) new Object[array.length + 1];
        buildPrefixSums(array);
    }

    private void buildPrefixSums(T[] array) {
        prefixSums[0] = group.getNEl();
        for (int i = 0; i < array.length; i++) {
            prefixSums[i + 1] = group.binOperation(prefixSums[i], array[i]);
        }
    }

    public T query(int left, int right) {
        return group.binOperation(prefixSums[right+1], group.inverse(prefixSums[left]));
    }
}
