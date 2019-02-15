package cmpe343hw4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import edu.princeton.cs.algs4.StdOut;

public class constructor {
	
	public static String readFileAsString(String filename) {
	    String text = "";
	    try {
	      text = new String(Files.readAllBytes(Paths.get(filename)));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	    return text;
	  }

	public static void main(String[] args) {
		//String ara ="It is a far, far better thing that I do, than I have ever done";
		//String ara ="START OF THIS PROJECT GUTENBERG EBOOK A TALE OF TWO CITIES";
		//String ara ="END: FULL LICENSE";
		String ara ="Let me take your arm,";
		//String ara ="Every afternoon at about the time when the public lamps";
		String TXT = readFileAsString("tale.txt");
		
		
		//Starting timer and looking KMP time spending.
        long startTime = System.currentTimeMillis(); 
        KMP kmp1 = new KMP(ara);
        int offset1 = kmp1.search(TXT);
        long endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime; 
        double KMP = (double)estimatedTime/1000;
        System.out.println("Result for KMP: " + offset1);
        System.out.println("Time spended for KMP: "+KMP);
        //Calculating time as a second.
        StdOut.println("-----------------------------------------------------------------------------");
        
      //Starting timer and looking BM time spending.
        long startBM = System.currentTimeMillis(); 
        BM boyermoore1 = new BM(ara);
        int offsetBM = boyermoore1.search(TXT);
        long endTimeBM = System.currentTimeMillis();
        long estimatedTimeBM = endTimeBM - startBM; 
        double BMR = (double)estimatedTimeBM/1000;
        System.out.println("Result for BM: " + offsetBM);
        System.out.println("Time spended for BM: "+BMR);
        //Calculating time as a second.
        StdOut.println("-----------------------------------------------------------------------------");
        
      //Starting timer and looking RK time spending.
        long startRK = System.currentTimeMillis(); 
        RK searcher = new RK(ara);
        int offsetRK = searcher.search(TXT);
        long endTimeRK = System.currentTimeMillis();
        long estimatedTimeRK = endTimeRK - startRK; 
        double RK = (double)estimatedTimeRK/1000;
        System.out.println("Result for RK: " + offsetRK);
        System.out.println("Time spended for RK: "+RK);
        //Calculating time as a second.
        StdOut.println("-----------------------------------------------------------------------------");
        
      //Starting timer and looking BRUTE - FORCE time spending.
        long startBrute = System.currentTimeMillis(); 
        int offsetBrute = Brute.search1(ara, TXT);
        long endTimeBrute = System.currentTimeMillis();
        long estimatedTimeBrute = endTimeBrute - startBrute; 
        double Brute = (double)estimatedTimeBrute/1000;
        System.out.println("Result for Brute: " + offsetBrute);
        System.out.println("Time spended for Brute: "+Brute);
        //Calculating time as a second.
        StdOut.println("-----------------------------------------------------------------------------");
        
        
		
	}

}
