class Solution {
    public void rotate(int[][] matrix) {
        // THOUGHT PROCESS:
        // Brute force: Create new matrix and copy rotated elements - O(n²) time, O(n²) space
        // This works but uses extra space for the new matrix
        //
        // Better: In-place rotation using four-way swap - O(n²) time, O(1) space
        // Pseudocode:
        // 1. Process layers from outside to inside (like peeling an onion)
        // 2. For each layer, swap elements in groups of 4
        // 3. Each group rotates: top→right, right→bottom, bottom→left, left→top
        // 4. Continue until all layers processed
        
        // Four-way swap approach - rotate elements in groups of 4
        // Example: [[1,2,3],[4,5,6],[7,8,9]] → [[7,4,1],[8,5,2],[9,6,3]]
        int n = matrix.length;
        
        // Process layers from outside to inside (like rings of an onion)
        // For 3x3: outer layer has corners 1,3,9,7 then inner layer has just 5
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            for (int pos = 0; pos < n / 2; pos++) {
                // For matrix [[1,2,3],[4,5,6],[7,8,9]] at layer=0, pos=0:
                // matrix[2][0] = 7 → temp = 7
                int temp = matrix[n - 1 - pos][layer];
                
                // matrix[2][0] = matrix[2][2] → 7 = 9
                matrix[n - 1 - pos][layer] = matrix[n - 1 - layer][n - pos - 1];
                
                // matrix[2][2] = matrix[0][2] → 9 = 3  
                matrix[n - 1 - layer][n - pos - 1] = matrix[pos][n - 1 - layer];
                
                // matrix[0][2] = matrix[0][0] → 3 = 1
                matrix[pos][n - 1 - layer] = matrix[layer][pos];
                
                // matrix[0][0] = temp → 1 = 7
                matrix[layer][pos] = temp;
                
                // Result after first swap: 1→7, 3→1, 9→3, 7→9
            }
        }
    }
}

/* BRUTE FORCE SOLUTION (for reference):
public void rotate(int[][] matrix) {
    int n = matrix.length;
    int[][] rotated = new int[n][n];
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            rotated[j][n - 1 - i] = matrix[i][j];
        }
    }
    
    // Copy back to original matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = rotated[i][j];
        }
    }
}
*/