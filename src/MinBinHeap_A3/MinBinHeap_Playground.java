package MinBinHeap_A3;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!

	  tester();
//	  TestBuild();
//	  TestBuild2();
//	  myBuildTest();
//	  emptyTest();
  }
  
  
  public static void tester(){
	  MinBinHeap mbh= new MinBinHeap();
	  mbh.insert(new EntryPair("a", 1));
	  mbh.insert(new EntryPair("b", 3));
	  mbh.insert(new EntryPair("c", 6));
	  mbh.insert(new EntryPair("d", 5));
	  mbh.insert(new EntryPair("e", 9));
	  mbh.insert(new EntryPair("f", 8));
	  mbh.insert(new EntryPair("g", 4));
	  mbh.insert(new EntryPair("h", 2));
	  
//	  mbh.insert(new EntryPair("h", 2));
	  printHeap(mbh.getHeap(), mbh.size());
	  
	  System.out.println("\nAfter deleteMin...");
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  
	  System.out.println("\nAfter deleteMin...");
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[8];
    collection[0]=new EntryPair("i",3);
    collection[1]=new EntryPair("b",5);
    collection[2]=new EntryPair("c",1);
    collection[3]=new EntryPair("d",0);
    collection[4]=new EntryPair("e",46);
    collection[5]=new EntryPair("f",5);
    collection[6]=new EntryPair("g",6);
    collection[7]=new EntryPair("h",17);
    mbh.build(collection);
    printHeapCollection(collection);
    printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void emptyTest(){
	  MinBinHeap mbh= new MinBinHeap();
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  System.out.println(mbh.getMin());
	  
  }
  
  public static void myBuildTest(){
	  MinBinHeap mbh= new MinBinHeap();
	    EntryPair[] collection= new EntryPair[5];
	    collection[0]=new EntryPair("a",5);
	    collection[1]=new EntryPair("b",4);
	    collection[2]=new EntryPair("c",3);
	    collection[3]=new EntryPair("d",2);
	    collection[4]=new EntryPair("e",1);

	    mbh.build(collection);
	    printHeapCollection(collection);
	    printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void TestBuild2(){ 
	    // constructs a new minbinheap, constructs an array of EntryPair, 
	    // passes it into build function. Then print collection and heap.
	    MinBinHeap mbh= new MinBinHeap();
	    EntryPair[] collection= new EntryPair[32];
	    collection[0]=new EntryPair("i",31);
	    collection[1]=new EntryPair("i",30);
	    collection[2]=new EntryPair("i",29);
	    collection[3]=new EntryPair("i",28);
	    collection[4]=new EntryPair("i",27);
	    collection[5]=new EntryPair("i",26);
	    collection[6]=new EntryPair("i",25);
	    collection[7]=new EntryPair("i",24);
	    collection[8]=new EntryPair("i",23);
	    collection[9]=new EntryPair("i",22);
	    collection[10]=new EntryPair("i",21);
	    collection[11]=new EntryPair("i",20);
	    collection[12]=new EntryPair("i",19);
	    collection[13]=new EntryPair("i",18);
	    collection[14]=new EntryPair("i",17);
	    collection[15]=new EntryPair("i",16);
	    collection[16]=new EntryPair("i",15);
	    collection[17]=new EntryPair("i",14);
	    collection[18]=new EntryPair("i",13);
	    collection[19]=new EntryPair("i",12);
	    collection[20]=new EntryPair("i",11);
	    collection[21]=new EntryPair("i",10);
	    collection[22]=new EntryPair("i",9);
	    collection[24]=new EntryPair("i",8);
	    collection[25]=new EntryPair("i",7);
	    collection[26]=new EntryPair("i",6);
	    collection[27]=new EntryPair("i",5);
	    collection[28]=new EntryPair("i",4);
	    collection[29]=new EntryPair("i",3);
	    collection[30]=new EntryPair("i",2);
	    collection[31]=new EntryPair("i",1);
//	    collection[31]=new EntryPair("i",3);
	    
	    mbh.build(collection);
	    printHeapCollection(collection);
	    printHeap(mbh.getHeap(), mbh.size());
	  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}
