package ArrayAndString;

public class RotateImage {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix){
        if (matrix.length == 0) {
            return;
        }
        int width = matrix.length;
        for(int i=0;i<width-1;i++){
            for(int j=0;j<width-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[width-j-1][width-i-1];
                matrix[width-j-1][width-i-1]=temp;
            }
        }
        for(int i=0;i<width;i++){
            for(int j=0;j<width/2;j++){
                int temp = matrix[j][i];
                matrix[j][i]=matrix[width-1-j][i];
                matrix[width-1-j][i]=temp;
            }
        }
    }
}
