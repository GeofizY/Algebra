class MatrixRing<T> implements Ring<Matrix<T>> {
    private final Ring<T> elementRing;
    private int size;

    public MatrixRing(Ring<T> ring, int size) {
        this.elementRing = ring;
        this.size = size;
    }

    public Ring<T> getElementRing() {
        return elementRing;
    }

    @Override
    public Matrix<T> getNElOne() {
        T[][] identityData = (T[][]) new Object[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                identityData[i][j] = (i == j) ? elementRing.getNElOne() : elementRing.getNElZero();
            }
        }
        return new Matrix<T>(this, identityData);
    }

    @Override
    public Matrix<T> multiply(Matrix<T> x, Matrix<T> y) {
        return x.multiply(y);
    }

    @Override
    public Matrix<T> getNElZero() {
        T[][] identity = (T[][]) new Object[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                identity[i][j] = elementRing.getNElZero();
            }
        }

        return new Matrix<T>(this, identity);
    }

    @Override
    public Matrix<T> sum(Matrix<T> x, Matrix<T> y) {
        return x.sum(y);
    }

    @Override
    public Matrix<T> unaryMinus(Matrix<T> z) {
        T[][] inverseData = (T[][]) new Object[z.getRowLength()][z.getColumnLength()];

        for (int i = 0; i < z.getRowLength(); i++) {
            for (int j = 0; j < z.getColumnLength(); j++) {
                inverseData[i][j] = elementRing.unaryMinus(z.data[i][j]);
            }
        }
        return new Matrix<>(this, inverseData);
    }
}