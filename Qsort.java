import java.util.Arrays;
class Qsort 
{
   // After execution a[x] <= a[y] <= a[z] should hold.
   static void sort3(QIntA a, int x, int y, int z) 
   {
      int intX = a.get(x);
      int intY = a.get(y);
      int intZ = a.get(z);
      
      if (intY < intX)
	 a.swap(y , x);
      if (intZ < intY)
	 a.swap(z,y);
      if (intY < intX)
	 a.swap(y,x);
   }
   

   public static void quickSort(QIntA a, int left, int right, int m) 
   {
      int size = right - left  +1;
      
      if ( size  < 3)
      {
	  return;
      } 
      /*      
      if (size == 3)
      {
 	 sort3(a,left,left+1, right);
 	 return;
	 }	*/ 
      
      int middle = (right + left) /2;
      
      sort3(a, left,  middle ,right);
      
      int newPiv = partition(a,left,right,middle); 

      quickSort(a, left, newPiv ,  m);
      quickSort(a, newPiv, right ,m);
      
      //insertionSort(a,left,right);
   }

   public static void insertionSort(QIntA a, int low, int high) 
   {
      Arrays.sort(a.a, low,high);
      ; // dummy code
   }

   private static int partition ( QIntA a, int left, int right, int pivot)
   {
      int piv = a.get(pivot);
      a.swap(pivot, right);
      int storeIndex = left;
      for (int i= left ; i < (right -1); i++)
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
   
/*

function partition(array, left, right, pivotIndex)
pivotValue := array[pivotIndex]
swap array[pivotIndex] and array[right] // Move pivot to end
storeIndex := left
for i from left to right - 1
   if array[i] ≤ pivotValue
     swap array[i] and array[storeIndex]
     storeIndex := storeIndex + 1
swap array[storeIndex] and array[right] // Pivot to final place
return storeIndex
*/