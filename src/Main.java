import java.util.List;
public class Main {

    public static void main(String[] args) {

        // Point 1
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

        // Point 2
        Integer[] arrForSum = {9, 5, 7, 2, 4, 3, 4};
        Double[] arrForMul = {4.6, 6.2, 1.1, 3.6, 9.2, 2.5};

        // Вычисление суммы
        PrefixSum<Integer> prefixForSum = new PrefixSum<>(arrForSum, new GroupSum());
        System.out.println("Prefix (sum) on range: " + prefixForSum.query(1, 4));

        // Вычисление произведения
        PrefixSum<Double> prefixForMul = new PrefixSum<>(arrForMul, new GroupMultiply());
        System.out.println("Prefix (multiply) on range: " + prefixForMul.query(1, 4));


        // Point 3

        // Кольцо над логическими значениями
        Ring<Boolean> ringBool = new RingBase<>(new MonoidBool(), new GroupBool());
        System.out.println("Test boolean ring " + ringBool.sum(false, false));


    }
}