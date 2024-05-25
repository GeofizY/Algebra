public class PrefixSum {
    private final Group<Integer> group;
    private final int[] prefixSums;

    public PrefixSum(int[] array, Group<Integer> group) {
        this.group = group;
        this.prefixSums = new int[array.length + 1];
        buildPrefixSums(array);
    }

    private void buildPrefixSums(int[] array) {
        prefixSums[0] = group.getNEl();
        for (int i = 0; i < array.length; i++) {
            prefixSums[i + 1] = group.binOperation(prefixSums[i], array[i]);
        }
    }

    public int query(int left, int right) {
        return group.binOperation(prefixSums[right+1], group.inverse(prefixSums[left]));
    }
}
