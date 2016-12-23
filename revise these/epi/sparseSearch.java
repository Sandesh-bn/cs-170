/*
Sparse  Search:  Given a sorted array of strings that  is  interspersed with empty strings, write a 
method to fi nd the location of a given string. 
EXAMPLE 
Input:  ball,{"at", 
""} 
Output:4 
*/
public static int spareSearch(String[] strings, String x, int low, int high){
	while (low <= high){
		
		int mid = (low + high) / 2;
		
		if (strings[mid].equals("")){
			int left = mid - 1;
			int right = mid + 1;
			
			// if arr[mid] is '' then move mid to rightmost non-empty index or leftmost non-empty index, whichever occurs first.
			while (true){
				if (left < low && right > high) // we ran out of indices
					return -1;
				else if(right <= high && !strings[right].equals("")){// we encountered a non-empty string on right side. set mid = right and break;
					mid = right;
					break;
				}
				//we encountered a non-empty string on left side. set mid = left and break;
				else if (left >= first && !strings[left].equals("")){
					mid = left;
					break;
				}
				// otherwise expand search for non-empty index
				right++;
				left--;
					
			}
		}
		
		int val = strings[mid].compareTo(x);
		if (val == 0)
			return mid;
		else if (val < 0) // target string is in the right half
			low = mid + 1;
		else
			high = mid - 1; // target string is in left half
		
	}
	return -1;
}



/*
The worst-case runtime for this algorithm is O ( n). In fact, it's impossible to have an algorithm for this
problem that is better than O(n) in the worst case. After all, you could have an array of all empty strings
except for one non-empty string. There is no "smart" way to find this non-empty string. In the worst case,
you will need to look at every element in the array.
Careful consideration should be given to the situation when someone searches for t he empty string. Should
we find the location (which is an O( n) operation)? Or should we handle this as an error?
There's no correct answer here. This is an issue you should raise with your interviewer. Simply asking this
question will demonstrate that you are a careful coder.
*/