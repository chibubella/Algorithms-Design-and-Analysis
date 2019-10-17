public class Assignment1 {

	public static void main(String[] args) {
		int[] Example = new int[20];
		
		for(int i =0; i<Example.length; i++) {
			Example[i] = (int) (Math.random()*1000000);
		}
		System.out.print("Array is: ");
		for(int i =0; i<Example.length; i++) {
			System.out.print(Example[i] + " ");
		}
		
		MinMax minmax = ArrMaxMin(Example, Example.length);
		System.out.println("\nThe maximum number is " + minmax.max);
		System.out.println("The minimum Number is " + minmax.min + "\n");
		
		//Recursive Call
		int []Example2 = new int[20];
		for(int i =0; i<Example2.length; i++) {
			Example2[i] = (int) (Math.random()*1000000);
		}
		System.out.print("Array is: ");
		for(int i =0; i<Example2.length; i++) {
			System.out.print(Example2[i] + " ");
		}
		MinMax minmax1 = new MinMax();
		minmax1.min = 1000000;
		
		ArrMaxMinR(Example2,0,Example2.length-1,minmax1);
		System.out.println("\nThe maximum number is " + minmax1.max);
		System.out.println("The minimum Number is " + minmax1.min + "\n");
		
	}
	
 static class MinMax {
		public int max;
		public int min;
	}
	
	public static MinMax ArrMaxMin(int[]arr, int length) {
		MinMax minmax = new MinMax();
		minmax.max = arr[0];
		minmax.min = arr[0];
		
		for(int i = 1; i<length; i++) {
			if(arr[i]>minmax.max) {
				minmax.max = arr[i];
			}
			if(arr[i]<minmax.min) {
				minmax.min = arr[i];
			}
		}
		return minmax;
	}
	
	public static void ArrMaxMinR(int []arr, int start, int end, MinMax minmax) {
		if (start == end)           
		{
		    if (minmax.max < arr[start]) {    
		        minmax.max = arr[start];
		    }
		    if (minmax.min > arr[end]) {   
		        minmax.min = arr[end];
		    }

		    return;
		}
		if ((end - start) == 1)            
		{
		    if (arr[start] < arr[end])      
		    {
		        if (minmax.min > arr[start]) {    
		            minmax.min = arr[start];
		        }

		        if (minmax.max < arr[end]) {   
		            minmax.max = arr[end];
		        }
		    }
		    else {
		        if (minmax.min > arr[end]) {   
		        	minmax.min = arr[end];
		        }
		        }
		        
		        if (minmax.max < arr[start]) {    
		            minmax.max = arr[start];
		        }
		        return;
		    }
		int middle = (start+end)/2;
		ArrMaxMinR(arr,start,middle,minmax);
		ArrMaxMinR(arr,middle+1,end,minmax);
	}
	
	
	
}
