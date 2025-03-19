import java.util.Arrays;

public class Sort 
{
	public static int[] bubbleSort(int[] arr, int direction)
											//positive int for ascending, negative int for descending
	{
		int i,j,swap;
		boolean clear = false;
		int len = arr.length;
		
		if(direction>0)
		{
			while(!clear)
			{
				clear = true;
				for(i=0;i<len;i++)
				{
					j = i + 1;
					if(i+1==len)
						j--;
					if(arr[i]>arr[j])
					{
						swap = arr[i];
						arr[i] = arr[j];
						arr[j] = swap;
						clear = false;
					}
				}
				display(arr);
			}
		}
		if(direction<0)
		{
			while(!clear)
			{
				clear = true;
				for(i=0;i<len;i++)
				{
					j = i + 1;
					if(i+1==len)
						j--;
					if(arr[i]<arr[j])
					{
						swap = arr[i];
						arr[i] = arr[j];
						arr[j] = swap;
						clear = false;
					}
				}
				display(arr);
			}
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] arr,int direction)
	{
		int i,j,swap,first;
		int len = arr.length;
		
		if(direction<0)//descending order
		{
			 for (i=len-1;i>0;i--) 
		     {
		          first=0;
		          for(j=1;j<=i;j++)  
		        	  if(arr[j]<arr[first])         
		                 first = j;
		          swap = arr[first];
		          arr[first] = arr[i];
		          arr[i] = swap; 
		          display(arr);
		      } 
		}
		if(direction>0)//ascending order
		{
			for (i=len-1;i>0;i--) 
		     {
		          first=0;
		          for(j=1;j<=i;j++)  
		        	  if(arr[j]>arr[first])         
		                 first = j;
		          swap = arr[first];
		          arr[first] = arr[i];
		          arr[i] = swap; 
		          display(arr);
		      } 
		}
		return arr;
	}
	
	public static int[] insertionSort(int[] arr,int direction)
	{
		int i,j,key;
		int len = arr.length;
		if(direction<0)
			for (j=1;j<len;j++)
		    {
				key = arr[j];
				for(i=j-1;(i >= 0)&&(arr[i]<key);i--)
					arr[i+1]=arr[i];
		        arr[i+1]=key;
		        display(arr);
		    }
		if(direction>0)
			for (j=1;j<len;j++)
		    {
				key = arr[j];
				for(i=j-1;(i >= 0)&&(arr[i]>key);i--)
					arr[i+1]=arr[i];
		        arr[i+1]=key;
		        display(arr);
		    }
		return arr;
	}

	static void display(int[] arr)
	{
		System.out.println(Arrays.toString(arr));
	}
}

