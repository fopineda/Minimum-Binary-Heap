package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]
  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }
  
 // ------------------------------------------------- The methods I have to implement -----------------------------------------------
// [DONE]
@Override
public void insert(EntryPair entry) {
	EntryPair parentElement;
	EntryPair temp;
	
	if (size == 0){
		size++;
		array[size] = entry;
	}
	else {
		// make sure it keeps heap order property
		if (size > 0){
			size++;   	// Go ahead and give increment the size
			array[size] = entry;
			int currentIndex = size;
			int parentIndex = this.findParentIndex(currentIndex);
			parentElement = array[parentIndex];
			while ((parentIndex!= 0) && (entry.priority < parentElement.priority)){     // Inserted 5: Switch if 5 < 10 because 5 is a child of 10.
				
				temp = array[currentIndex];						// saves current element in temp
				array[currentIndex]= array[parentIndex];   // child = parent
				array[parentIndex] = temp;				  // parent = temp (child)
				
				currentIndex = parentIndex;
				parentIndex =  this.findParentIndex(currentIndex);
				parentElement = array[parentIndex];
			}	
		}
	 }
}


//[DONE]
@Override
public void delMin() {
	if (size == 0){  // Binary Heap is empty
		// nothing
	}
	else if (size == 1){  // Binary Heap has only one element (root)
		array[size] = null;
		size--;
	}
	else if (size > 1){  // has at least two elements
		EntryPair temp;
		array[1] = null;
		array[1] = array[size];
		array[size] = null;
		size--;
		
		int parentIndex = 1; // setup arguments
		int currentIndex = 0;  // index that will point towards the element that you are going to swap with
		int leftIndex = this.findLeftIndex(parentIndex);
		int rightIndex = this.findRightIndex(parentIndex);
		while (true){  // bubbling down process
			if ((array[leftIndex] == null) && (array[rightIndex] == null)){ // no children (leaf)
				break;
			}
			else { 
				if ((array[leftIndex] != null) && (array[rightIndex] == null)){ // only has a left child (because BH will never only have right child)
					currentIndex = leftIndex;
				}
				else {
					if (array[leftIndex].priority < array[rightIndex].priority){  // compares both left and right elements
						currentIndex = leftIndex;
					}
					else{
						currentIndex = rightIndex;
					}
				}
				if (array[parentIndex].priority > array[currentIndex].priority ){		// swapping of elements
					temp  = array[currentIndex];
					array[currentIndex] = array[parentIndex];
					array[parentIndex] = temp;
					parentIndex = currentIndex;
					leftIndex = this.findLeftIndex(parentIndex);
					rightIndex = this.findRightIndex(parentIndex);
				}
				else{
					break;
				}
			}
		
		}
	}
	
	
}

// [DONE]
@Override
public EntryPair getMin() {
	if (array == null){
		return null;
	}
	else{
		return array[1];
	}
}

// [DONE]
@Override
public int size() {
	return size;
}

// [DONE]
@Override
public void build(EntryPair[] entries) {
	for (int i = 1; i <= entries.length; i++){
		array[i] = entries[i-1];
		size++;
	}
	
	if (size > 1){
		int c =0;
		EntryPair temp;
		int decrementor = size;
		int parentIndex = this.findParentIndex(decrementor);
		int leftIndex = this.findLeftIndex(parentIndex);
		int rightIndex = this.findRightIndex(parentIndex);
		
		// every element before the first parent index will be a a parent as well.
		while (true){  // bubbling down process
			if (parentIndex != 0){
				if ((((parentIndex) > 1000) || (rightIndex) > 1000) || (leftIndex) > 1000) return;
				if ((array[leftIndex] == null) && (array[rightIndex] == null)){ // no children (leaf)
					break;
				}
				else { 
					if ((array[leftIndex] != null) && (array[rightIndex] == null)){ // only has a left child (because BH will never only have right child)
						c = leftIndex;
					}
					else {
						if (array[leftIndex].priority < array[rightIndex].priority){  // compares both left and right elements
							c = leftIndex;
						}
						else{
							c = rightIndex;
						}
					}
					if (array[parentIndex].priority > array[c].priority ){		// swapping of elements
						temp  = array[c];
						array[c] = array[parentIndex];
						array[parentIndex] = temp;
						if ((array[2*c] != null) || (array[((2*c)+1)] != null)){  // if c has at lease one child (basically to check if you still needed to bubble down
							if ((((2*c) > 1000) || ((2*c)+1) > 1000)) return;
							parentIndex = c;
							leftIndex = this.findLeftIndex(parentIndex);
							rightIndex = this.findRightIndex(parentIndex);
						}
						else{
							parentIndex--;
							leftIndex = this.findLeftIndex(parentIndex);
							rightIndex = this.findRightIndex(parentIndex);
						}
					}
					else{
						parentIndex--;
						leftIndex = this.findLeftIndex(parentIndex);
						rightIndex = this.findRightIndex(parentIndex);
					}
				}
			}//
			else{
				break;
			}
		
		}
		
	}
}


// --------------------------------------------------- MINE -----------------------------------------
public int findParentIndex(int n){
	return n/2;
}

public int findLeftIndex(int n){
	return 2*n;
}

public int findRightIndex(int n){
	return ((2*n)+1);
}



}