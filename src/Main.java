public class Main {

    public static void main(String[] args) {

        Integer[] arrForMax = {5, 3, 9, 2, 7}; // Натуральные числа
        Double[] arrForMin = {1.5, 2.8, 4.1, 2.3}; // Вещественные числа
//
//        Monoid<Integer> takeMax = new MonoidMax();
//        Monoid<Double> takeMin = new MonoidMin();
//
//        int max = takeMax.getNEl();
//        for (int el : arrForMax) {
//            max = takeMax.getBinOperation(max, el);
//        }
//
//        double min = takeMin.getNEl();
//        for (double el : arrForMin) {
//            min = takeMin.getBinOperation(min, el);
//        }
//
//        System.out.println("Максимальный: " + max);
//        System.out.println("Минимальный: " + min);

        SegmentTree<Integer> treeMax = new SegmentTree<>(arrForMax, new MonoidMax());
        System.out.println("Max on range: " + treeMax.query(1, 4));

        SegmentTree<Double> treeMin = new SegmentTree<>(arrForMin, new MonoidMin());
        System.out.println("Min on range: " + treeMin.query(0, 2));

        SegmentTree<Integer> treeMultiply = new SegmentTree<>(arrForMax, new MonoidMultiply());
        System.out.println("Multiply on range: " + treeMultiply.query(1, 4));

        FastBinaryOperation<Integer> exponentiation = new FastBinaryOperation<>();
        System.out.println("Result of exponentiation: " + exponentiation.getBaseInExponent(2,13,new MonoidMultiply()));
    }
}