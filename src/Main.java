import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        // Point 1
        System.out.println("Point 1");

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
        System.out.println("\nPoint 2");

        Integer[] arrForSum = {9, 5, 7, 2, 4, 3, 4};
        Double[] arrForMul = {4.6, 6.2, 1.1, 3.6, 9.2, 2.5};

        // Вычисление суммы
        PrefixSum<Integer> prefixForSum = new PrefixSum<>(arrForSum, new GroupSum());
        System.out.println("Prefix (sum) on range: " + prefixForSum.query(1, 4));

        // Вычисление произведения
        PrefixSum<Double> prefixForMul = new PrefixSum<>(arrForMul, new GroupMultiply());
        System.out.println("Prefix (multiply) on range: " + prefixForMul.query(1, 4));


        // Point 3
        System.out.println("\nPoint 3");

        // Кольцо над логическими значениями
        Ring<Boolean> ringBool = new RingBase<>(new MonoidBool(), new GroupBool());
        System.out.println("Test boolean ring " + ringBool.sum(false, false));

        // Пример использования матриц над кольцом целых чисел
        Ring<Integer> ringInt = new RingBase<>(new MonoidMultiply(), new GroupSum());

        Integer[][] arrForMatrixInt1 = {
                {1, 2},
                {3, 4}
        };
        Integer[][] arrForMatrixInt2 = {
                {2, 5},
                {3, 7}
        };

        Matrix<Integer> matrixInt1 = new Matrix<>(ringInt, arrForMatrixInt1);
        Matrix<Integer> matrixInt2 = new Matrix<>(ringInt, arrForMatrixInt2);

        Matrix<Integer> matSum = matrixInt1.add(matrixInt2);
        Matrix<Integer> matProduct = matrixInt1.multiply(matrixInt2);

        System.out.println("Matrix Sum:");
        for (int i = 0; i < matSum.getRowLength(); i++) {
            for (int j = 0; j < matSum.getColumnLength(); j++) {
                System.out.print(matSum.getElement(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix Product:");
        for (int i = 0; i < matProduct.getRowLength(); i++) {
            for (int j = 0; j < matProduct.getColumnLength(); j++) {
                System.out.print(matProduct.getElement(i, j) + " ");
            }
            System.out.println();
        }

//
//        // Пример использования полинома над кольцом целых чисел
//        Ring<Integer> integerRing = new RingBase<>(new MonoidMultiply(), new GroupSum());
//
//        List<Integer> polyCoefficients1 = List.of(1, 2, 3); // 1 + 2x + 3x^2
//        List<Integer> polyCoefficients2 = List.of(4, 5); // 4 + 5x
//
//        Polynomial<Integer> poly1 = new Polynomial<>(polyCoefficients1, integerRing);
//        Polynomial<Integer> poly2 = new Polynomial<>(polyCoefficients2, integerRing);
//
//        Polynomial<Integer> polySum = poly1.add(poly2);
//        Polynomial<Integer> polyProduct = poly1.multiply(poly2);
//
//        System.out.println("\nPolynomial Sum:");
//        for (int i = 0; i < polySum.coefficients.size(); i++) {
//            System.out.println("Coefficient of x^" + i + ": " + polySum.getCoefficient(i));
//        }
//
//        System.out.println("\nPolynomial Product:");
//        for (int i = 0; i < polyProduct.coefficients.size(); i++) {
//            System.out.println("Coefficient of x^" + i + ": " + polyProduct.getCoefficient(i));
//        }

    }
}