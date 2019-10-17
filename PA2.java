
public class PA2 {
		public static int DynamicLeastCost(int[] matrices, int i, int j)
		{
			if (j <= i + 1) {
				return 0;
			}
			
			int min = Integer.MAX_VALUE;

			for (int k = i + 1; k <= j - 1; k++)
			{
				int cost = DynamicLeastCost(matrices, i, k);
				cost += DynamicLeastCost(matrices, k, j);
				cost += matrices[i] * matrices[k] * matrices[j];

				if (cost < min) {
					min = cost;
				}
			}
			return min;
		}
		
		
		public static int GreedyLeastCost(int [] matrices) {
			int min = Integer.MAX_VALUE;		
	        int size = matrices.length;
	        int minIndex = -1;			
	        
	        if(size <= 2) return 0;
	        if (size == 3) return matrices[0] * matrices[1] * matrices[2];
	        
	        for(int i = 0; i < size - 2; i++) {
	        	int first = matrices[i];
	        	int mid = matrices[i + 1];
	        	int last = matrices[i + 2];
	        	
	        	int cost = first * mid * last;
	        	if (cost < min) {
	        		min = cost;
	        		minIndex = i + 1;
	        	}
	        }
	        
	        int arr[] = new int[size - 1];
	        for (int i = 0, j = 0; i < size; i++) {
	        	if (i != minIndex) {
	        		arr[j] = matrices[i];
	        		j++;
	        	}
	        }
	        
	        return min + GreedyLeastCost(arr);
		}
		

		public static void main(String[] args)
		{
			int[] matrixdimensions = {30,35,15,5,10,20,25};

			System.out.println("Minimum cost using DP - " +
					DynamicLeastCost(matrixdimensions, 0, matrixdimensions.length - 1));
			
			System.out.println ("Minimum cost using Greedy - " +
					GreedyLeastCost(matrixdimensions));
		}
	
		
		/*Greedy algorithm using cheapest cost calculated first will not give the optimal solution. 
		 * it will lead to doing the 2x1 and 1x2 matrix first which has a cost of 4 
		 * The resulting matrix would be  2x2 matrix. multiplying that with the 2x5 matrix will have a cost of 20 making it a total cost of 24. 
		 * But my dynamic program  shows the minimum cost is 20 if you do the 1x2 and 2x5 matrices first resulting in a 1x5 matrix with a cost of 10. 
		 * Then the 2x1 and 1x5 matrices which has a cost of 10 making the cheapest cost 20 as opposed to 24 following the greedy algorithm

*/
}
