package intermittent.lying.continuous.progress.deprecated;

public class RangeSumQuery {
    int[][] matrix;
    public RangeSumQuery(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int row=row1;row<=row2;row++){
            for(int col=col1;col<=col2;col++){
                sum += matrix[row][col];
            }
        }
        return sum;
    }
}
