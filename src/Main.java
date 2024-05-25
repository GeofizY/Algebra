public class Main {

    public static void main(String[] args) {

        Integer[] arrForMaxAndMul = {5, 3, 9, 2, 7}; // Натуральные числа
        Double[] arrForMin = {1.5, 2.8, 4.1, 2.3}; // Вещественные числа

        // Вычисление максимума
        SegmentTree<Integer> treeMax = new SegmentTree<>(arrForMaxAndMul, new MonoidMax());
        System.out.println("Max on range: " + treeMax.query(1, 4));

        // Вычисление минимума
        SegmentTree<Double> treeMin = new SegmentTree<>(arrForMin, new MonoidMin());
        System.out.println("Min on range: " + treeMin.query(1, 2));

        // Вычисление произведения
        SegmentTree<Integer> treeMultiply = new SegmentTree<>(arrForMaxAndMul, new MonoidMultiply());
        System.out.println("Multiply on range: " + treeMultiply.query(1, 4));

        // Быстрое возведение в степень
        FastBinaryOperation<Integer> exponentiation = new FastBinaryOperation<>(new MonoidMultiply());
        System.out.println("Result of exponentiation: " + exponentiation.getBaseInExponent(2,13));

        // Вычисление префиксной суммы
        int[] arrForSum = {9, 5, 7, 2, 4, 3, 4};
        GroupSum takeGroupSum = new GroupSum();
        PrefixSum prefixSum = new PrefixSum(arrForSum, takeGroupSum);
        System.out.println("Prefix sum query [1, 4]: " + prefixSum.query(1, 4));

        // Кольцо над логическими значениями
        Ring<Boolean> ringBool = new RingBase<>(new MonoidBool(), new GroupBool());
        System.out.println("|||||||||||||||||| " + ringBool.getSum(false, false));
    }
}