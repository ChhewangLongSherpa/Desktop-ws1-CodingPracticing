/******************************************************************************
 *  Compilation:  javac SparseMatrix.java
 *  Execution:    java SparseMatrix
 *
 *  A sparse, square matrix, implementing using two arrays of sparse
 *  vectors, one representation for the rows and one for the columns.
 *
 *  For matrix-matrix product, we might also want to store the
 *  column representation.
 * Source: https://introcs.cs.princeton.edu/java/44st/SparseMatrix.java.html
 ******************************************************************************/

public class SparseMatrix {
    private final int n;           // n-by-n matrix
    private SparseVector[] rows;   // the rows, each row is a sparse vector

    // initialize an n-by-n matrix of all 0s
    public SparseMatrix(int n) {
        this.n = n;
        rows = new SparseVector[n];
        for (int i = 0; i < n; i++)
            rows[i] = new SparseVector(n);
    }

    // put A[i][j] = value
    public void put(int i, int j, double value) {
        if (i < 0 || i >= n) throw new RuntimeException("Illegal index");
        if (j < 0 || j >= n) throw new RuntimeException("Illegal index");
        rows[i].put(j, value);
    }

    // return A[i][j]
    public double get(int i, int j) {
        if (i < 0 || i >= n) throw new RuntimeException("Illegal index");
        if (j < 0 || j >= n) throw new RuntimeException("Illegal index");
        return rows[i].get(j);
    }

    // return the number of nonzero entries (not the most efficient implementation)
    public int nnz() {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += rows[i].nnz();
        return sum;
    }

    // return the matrix-vector product b = Ax
    public SparseVector times(SparseVector x) {
        if (n != x.size()) throw new IllegalArgumentException("Dimensions disagree");
        SparseVector b = new SparseVector(n);
        for (int i = 0; i < n; i++)
            b.put(i, this.rows[i].dot(x));
        return b;
    }

    // return this + that
    public SparseMatrix plus(SparseMatrix that) {
        if (this.n != that.n) throw new IllegalArgumentException("Dimensions disagree");
        SparseMatrix result = new SparseMatrix(n);
        for (int i = 0; i < n; i++)
            result.rows[i] = this.rows[i].plus(that.rows[i]);
        return result;
    }


    // return a string representation
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("n = " + n + ", nonzeros = " + nnz() + "\n");
        for (int i = 0; i < n; i++) {
            s.append(i + ": " + rows[i] + "\n");
        }
        return s.toString();
    }


    // test client
    public static void main(String[] args) {
        SparseMatrix a = new SparseMatrix(5);
        SparseVector x = new SparseVector(5);
        a.put(0, 0, 1.0);
        a.put(1, 1, 1.0);
        a.put(2, 2, 1.0);
        a.put(3, 3, 1.0);
        a.put(4, 4, 1.0);
        a.put(2, 4, 0.3);
        x.put(0, 0.75);
        x.put(2, 0.11);
        StdOut.println("x     : " + x);
        StdOut.println("A     : " + a);
        StdOut.println("Ax    : " + a.times(x));
        StdOut.println("A + A : " + a.plus(a));
    }

}


//Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
//Last updated: Fri Oct 20 14:12:12 EDT 2017.
