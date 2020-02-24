public class KthSmallestElementMatrix {
    
    public void kthSmallest(int matrix[][], int k) throws Exception {
        int row = matrix.length;
        int left = matrix[0][0], right = matrix[row - 1][row - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int great = count(matrix, mid);
            if (left < great) {
                right = mid;
                // left = mid + 1;
            } else {
                // right = mid;
                left = mid + 1;
            }
        }
        System.out.println(k + " smallest element is:" + left);
    }
    
    public int count(int matrix[][], int ele) {
        int size = matrix.length - 1;
        int count = 0;
        int j =0;
        for (int i = 0; i < size; i++) {
            j = size;
            while (j >= 0 && matrix[i][j] > ele) {
                j--;
            }
            count += j - 1;
        }
        return count;
    }
    
    public static void main(String args[]) {
        int matrix[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        
        KthSmallestElementMatrix smallest = new KthSmallestElementMatrix();
        
        int k = 8;
        try {
            smallest.kthSmallest(matrix, k);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
