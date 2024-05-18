public class Main {

    public static void main(String[] args) {

        Integer[] arrForMax = {5, 3, 9, 2, 7}; // Натуральные числа
        Double[] arrForMin = {1.5, 2.8, 4.1, 2.3}; // Вещественные числа

        // Вычисление максимума
        SegmentTree<Integer> treeMax = new SegmentTree<>(arrForMax, new MonoidMax());
        System.out.println("Max on range: " + treeMax.query(1, 4));

        // Вычисление минимума
        SegmentTree<Double> treeMin = new SegmentTree<>(arrForMin, new MonoidMin());
        System.out.println("Min on range: " + treeMin.query(0, 2));

        // Вычисление произведения
        SegmentTree<Integer> treeMultiply = new SegmentTree<>(arrForMax, new MonoidMultiply());
        System.out.println("Multiply on range: " + treeMultiply.query(1, 4));

        // Быстрое возведение в степень
        FastBinaryOperation<Integer> exponentiation = new FastBinaryOperation<>();
        System.out.println("Result of exponentiation: " + exponentiation.getBaseInExponent(2,13,new MonoidMultiply()));
    }
}