class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        while(rowStart <= rowEnd && colStart <= colEnd){

            // Traverse top row
            for(int j=colStart; j<=colEnd; j++){
                result.add(matrix[rowStart][j]);
            }
            rowStart++;

            // Traverse right column
            for(int i=rowStart; i<=rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse bottom row
            if(rowStart <= rowEnd){
                for(int j=colEnd; j>=colStart; j--){
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            

            // Traverse left column
            if(colStart <= colEnd){
                for(int i=rowEnd; i>=rowStart; i--){
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }
            
        }
        return result;
    }
}