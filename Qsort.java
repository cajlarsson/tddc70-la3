import java.util.Arrays;
class Qsort 
{
   // After execution a[x] <= a[y] <= a[z] should hold.
   static void sort3(QIntA a, int x, int y, int z) 
   {
      
      if (a.get(y) < a.get(x))
	  a.swap(y,x);
      if (a.get(z) < a.get(y))
	 a.swap(z,y);
      if (a.get(y) < a.get(x))
	  a.swap(y,x);
   }
   

   public static void quickSort(QIntA a, int left, int right, int m) 
   {
      int size = right - left  +1;
      
      if ( size < m)
      {
	      sort3(a,left,left+1, right);
	      return;
      } 
          
      int middle = (right + left) /2;

      sort3(a, left,  middle ,right);
      
      int newPiv = partition(a,left,right,middle); 

      quickSort(a, newPiv , right ,m);      
      quickSort(a, left, newPiv ,  m);

      
      //insertionSort(a,left,right);
   }

   public static void insertionSort(QIntA a, int low, int high) 
   {
      for (int i = low+1; i < high; i++)
      {
	 int j = i;
	 int val = a.get(i);
	 while ((j > low) && (a.get(j-1) > val))
	 {
	    a.set(j,a.get(j-1));
	    j--;
	 }
	 a.set(j,val);
      }
      
   }
/*

 public static void insertion_srt(int array[], int n){
    for (int i = 1; i < n; i++){
      int j = i;
      int B = array[i];
      while ((j > 0) && (array[j-1] > B)){
        array[j] = array[j-1];
        j--;
      }
      array[j] = B;
    }
  }
  }*/
    
    
	
   private static int partition ( QIntA a, int left, int right, int pivot)
   {
      int piv = a.get(pivot);
      a.swap(pivot, right);
      int storeIndex = left;
      for (int i= left ; i < right-1  ; i++)
      {
	 if (a.get(i) <= piv)
	 {
	    a.swap(i, storeIndex);
	    storeIndex += 1;
	 }
      }
      a.swap(storeIndex,right);
      return storeIndex;
   }
}
   
