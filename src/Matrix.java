public class Matrix<T> {
    protected final MatrixRing<T> ring;
    protected final T[][] data;

    public Matrix(MatrixRing<T> ring, T[][] data) {
        this.ring = ring;
        this.data = data;
    }
    public Matrix(Ring<T> ring, T[][] data) {
        this.ring = new MatrixRing<T>(ring, data.length);
        this.data = data;
    }

    public int getRowLength() {
        return data.length;
    }

    public int getColumnLength() {
        return data[0].length;
    }

    public T getElement(int row, int col) {
        return data[row][col];
    }

    public Matrix<T> sum(Matrix<T> other) {
        int rows = this.getRowLength();
        int cols = this.getColumnLength();

        T[][] result = (T[][]) new Object[rows][cols];

        if (rows != other.getRowLength() || cols != other.getColumnLength()) {
            throw new IllegalArgumentException("Rows or cols don't equal");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = ring.getElementRing().sum(this.getElement(i, j), other.getElement(i, j));
            }
        }

        return new Matrix<>(ring, result);
    }

    public Matrix<T> multiply(Matrix<T> other) {
        int rows = this.getRowLength();
        int cols = this.getColumnLength();
        int otherCols = other.getColumnLength();

        T[][] result = (T[][]) new Object[rows][cols];

        if (this.getColumnLength() != other.getRowLength()) {
            throw new IllegalArgumentException("Cols don't equal rows");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < otherCols; j++) {
                T sum = ring.getElementRing().getNElZero();
                for (int k = 0; k < cols; k++) {
                    sum = ring.getElementRing().sum(sum, ring.getElementRing().multiply(this.getElement(i, k), other.getElement(k, j)));
                }
                result[i][j] = sum;
            }
        }

        return new Matrix<>(ring, result);
    }
}
