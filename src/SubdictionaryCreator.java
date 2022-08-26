import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class SubdictionaryCreator {

	public static void main(String[] args) {
		PrintWriter dic = null;
		Scanner readFile = null;
		Scanner keyboard = new Scanner(System.in);
		try {
			readFile = new Scanner(new FileInputStream("PersonOfTheCentury.txt"));

		}catch(FileNotFoundException notFound){
			System.out.println("File was not found.");
		}
		ArrayList<String> allWords = new ArrayList<String>();
		ArrayList<String> sub = new ArrayList<String>();
		while(readFile.hasNext()) {
			String word = readFile.next();
			if (!(allWords.contains(word))) {
				allWords.add(word);
			}else {
				continue;
			}
			if(allWords.get(allWords.size()-1).length() == 1) {
				if(word.equals("i")||word.equals("I")||word.equals("a")||word.equals("A")) {
					if(!(sub.contains(allWords.get(allWords.size()-1).toUpperCase()))) {
						sub.add(allWords.get(allWords.size()-1).toUpperCase());
					}
				}
			}else {
				String [] arr = allWords.get(allWords.size()-1).split("");
				String correct = "";
				boolean num = false;
				for(int i = 0;i<arr.length;i++) {
					if(Character.isDigit(arr[i].charAt(0))==true) {
						num = true;
					}
				}
				if(num == true) {
					continue;
				}
				//System.out.println(allWords.get(allWords.size()-1));
				for(int i = 0;i<arr.length;i++){
					if(Character.isLetter(arr[i].charAt(0)) == true) {
						correct += arr[i];
					}
				}
				correct = correct.toUpperCase();
				//System.out.println(correct);
				if(!(sub.contains(correct)))
					sub.add(correct);
			}
		}
		for(int i = 0; i<sub.size(); i++)   //Holds each element
        {  
            for (int j = i+1; j<sub.size(); j++)  //Check for remaining elements 
            {  
               //compares each elements of the array to all the remaining elements  
               if(sub.get(i).compareTo(sub.get(j))>0)   
               {  
                   //swapping array elements  
                   String temp = sub.get(i);  
                   sub.set(i, sub.get(j)); 
                   sub.set(j, temp);
                }  
             }  
        }
		try {
			dic = new PrintWriter(new FileOutputStream("Sub-Dictionary.txt"));
			dic.println("The document produced this sub-dictionary, which includes "+sub.size()+" entries.");
			String prev = sub.get(0);
			dic.println(sub.get(0).charAt(0));
			dic.println("==");
			dic.println();
			for(String st: sub) {
				if(prev.charAt(0)!=st.charAt(0)) {
					dic.println(st.charAt(0));
					dic.println("==");
					dic.println();
				}
				dic.println(st);
				prev = st;
			}

		}catch(FileNotFoundException notFound){
			System.out.println("File was not found.");
		}
		dic.close();
	}

}
