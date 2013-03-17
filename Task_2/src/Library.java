import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Library {
		public static void main(String[] args) {
			
			ArrayList<Book1> objectBook = new ArrayList<Book1>();		//create the arraylist of Book1 objects
			ArrayList <String>	wrongBookList = new ArrayList<String>();	//create the arraylist for error books
			
			JFileChooser chooser = new JFileChooser();      // start the gui 
			chooser.setCurrentDirectory(new File("."));
		    
			 int r = chooser.showOpenDialog(new JFrame());
			 if (r == JFileChooser.APPROVE_OPTION) {
			 String file = chooser.getSelectedFile().getAbsolutePath();	      	      
			
			 File f = new File(file);			
				try {
					boolean goodBook = true;			//boolean method to check if the book contains any erros
					ArrayList<String> booklist = new ArrayList<String>();  //arraylist to store the input file
					 Scanner scanner = new Scanner(f);
		          
		            
		            while (scanner.hasNextLine()) {
		                String line = scanner.nextLine();
		                
		                booklist.add(line);			//add every line of the Book to the arraylist booklist
		            }
		  
		            	for (int i = 0;i < booklist.size(); i++){ 			//read the arraylist
		                	Scanner s = new Scanner(booklist.get(i)).useDelimiter("#");  //seperate the arguments using the delimiter
		                	
		                	String error = "Error: ";	//variable to store the errors
		                	
		                	while (s.hasNext()){
	                			//isbn    	
		                		Book1 book = new Book1();	
		                		String isbn = s.next();
		                		if (isIsbnValid(isbn)){				//check if the isbn is valid
	                				book.setIsbn(isbn);				//if yes add the isbn to the isbn of the object
		                		}
		                		else{
		                			error += " invalid isbn#";		//if not save the error the variable error
		                			goodBook = false;				// make the boolean variable false because the book contains errors
		                			book.setIsbn(isbn);
								}
		                		
		                		//copyNumber    
		                		if (s.hasNext()){       	 			
		                			String copyNumber = s.next();
       	 		        			try{
       	 		        				String aString = copyNumber ;
       	 		        				int copyNumberInt = Integer.parseInt(aString);	//is the copyNumber can convert to int
       	 		        				book.setCopyNumber(copyNumberInt);   
   	 		        				}		  	
       	 		        			catch(Exception e){
       	 		        				error += " invalid CopyNumber#";
       	 		        				goodBook = false;
       	 		        			}       	
       	 		        		}
		                		
		                		//Title
		                		if (s.hasNext()){
		                			String Title = s.next();
           	 		        		if(!Title.isEmpty()){				//check if the Title exists
           	 		        			book.setTitle(Title);   
           	 		        		}
           	 		        		else {
           	 		        			error += " invalid Title#";
           	 		        			goodBook = false;
           	 		        		}
   	 		        			}
		                		
		                		//Author		               			
		                		if (s.hasNext()){
		                			String Author = s.next();
		                			if(!Author.isEmpty()){				//check if the Author exists
		                				book.setAuthor(Author);  
 		        					}	
		                			else {
		                				error += " invalid Author#";
		                				goodBook = false;
		                			}
		                		}
		                		
		                		//Publisher
		                		if (s.hasNext()){
		                			String Publisher = s.next();
           	 		        		if (!Publisher.isEmpty()){			//check if the Publisher
           	 		        			book.setPublisher(Publisher);
           	 		        		}
           	 		        		else {
           	 		        			error += " invalid Publisher#";
		                				goodBook = false;
           	 		        		}			
		                		}
		                		
		                		//Year
		                		if (s.hasNext()){
		                			String Year = s.next();
		                			try {                
		                				int YearInt = Integer.parseInt(Year);		//check if the Year can convert to int
		                				book.setYear(YearInt);
		                			} 
		                			catch (NumberFormatException e) {
		                				error += " invalid Year#";
		                				goodBook = false;
		                			}
		                		}
						
		                		//Statistics
		                		if (s.hasNext()){
		                			String Stat = s.next();
		                			try{
		                				int StatInt = Integer.parseInt(Stat);		//check if the Statistics can convert to int
		                				book.setStat(StatInt);
		                			}catch (NumberFormatException e) {
		                				error += " invalid Stat#";
		                				goodBook = false;
									}
		                		}                   	
            	
		                		/*BorrowDate
		                		 * use simpleFormat to test if the String BorrowDate
		                		 * can covert to valid Date 
		                		 * after the covert the date must be equal to the String  	
		                		*/
		                		if (s.hasNext()){
		                			String BorrowDate = s.next();
		                			try {  
		                				DateFormat formatter ; 
		                				formatter = new SimpleDateFormat("yyMMdd");    
		                				Date date = formatter.parse(BorrowDate);
		                				if(formatter.format(date).equals(BorrowDate)){
		                					book.setBorrowDate(date);
		                				}else{
		                					error += " invalid BorrowDate#";
		                					goodBook = false;
		                				}
		                			} 
		                			catch (ParseException e) {
		                				error += " invalid BorrowDate#";
		                				goodBook = false;
									}
		                		}
		                		/*ReturnDate
		                		 * use simpleFormat to test if the String ReturnDate
		                		 * can covert to valid Date 
		                		 * after the covert the date must be equal to the String  	
		                		*/
		                		if (s.hasNext()){
		                			String ReturnDate = s.next();
		                			try {  
		                				DateFormat formatter ; 
		                				formatter = new SimpleDateFormat("yyMMdd");
		                				Date date = formatter.parse(ReturnDate);
		                				if(formatter.format(date).equals(ReturnDate)){
		                					book.setReturnDate(date);
		                				}else{
		                					error += " invalid ReturnDate#";
		                					goodBook = false;
		                				}
		                			} 
		                			catch (ParseException e) {
		                   				error += " invalid ReturnDate#";
		                				goodBook = false;
		                			}
		                		}
				
		                		//LcardNumber
		                		if (s.hasNext()){
		                			String LCardNumber = s.next();
		                			try{
		                				String aString1 = LCardNumber ;
		                				int LCardNumberInt = Integer.parseInt(aString1);	//check if the LcardNumber can covert to a string
		                				//			System.out.print(" LCArd :"+ LCardNumberInt);
		                				book.setLCardNumber(LCardNumberInt);     
		                			}	
		                			catch(NumberFormatException e){
		                				error += " invalid LcardNumber#";
		                			}       	
		                		}
                  
                     	/*if the book is ok (the goodbook variable remains true)
                     	 * the is added to the objectBook arraylist otherwise if the
                     	 * goodBook is false the book goes to wrongBookList
                     	 * */
		                		if (!goodBook ){										
		                			wrongBookList.add(error + booklist.get(i));
		                		}
		                		else{
		                			sortAuthor(objectBook);		//sort the objectBookList by Author
		                			objectBook.add(book);										
		                		}
		                	
		                	}// end of while
		                
		            	}// end of for
				
				}//end of try(JOption)
				
				
				catch (FileNotFoundException e) {					// if there is no file
					System.err.println("The file was not saved.");	//error message
					e.printStackTrace();
				}//ends catch
		                
			 } //Jr approve_option
			
			 //write the correct books to file
			try {
				File file5 = new File("NewBook.txt");
				PrintWriter output = new PrintWriter(file5);
				for (Book1 b : objectBook) {
					WriteAFile(b, output);
				}
				output.close();
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			//writing the error file
			
			WriteAFile21(wrongBookList);
		     
		     System.out.print("Closing");
		     System.exit(0);
		
		}	// end of main



		public static boolean isIsbnValid(String number) {
			int len = number.length();				//check if the isbn has 13 digits
				if (len != 13){
				return false;
			}else { 
				try {
					int sum= 0;
					for (int i = 0; i < number.length()-1; i++) {
						int x = Integer.parseInt(number.substring(i,i+1));	//convert to int every digit of the isbn
						if(i%2 == 0){										//find the the odd and even numbers
							sum += x;
						}else{
							sum += x *3;
						}
					}
					int lastDigit = Integer.parseInt(number.substring(12,13));	
					if((10-(sum%10)) == lastDigit ){
						return true;	
					}else{
						return false;
					}
					
				} catch (NumberFormatException e ){
					return false;
				}
			}	
		}

		//write the object to the file NewBooks
		private static void WriteAFile(Book1 b , PrintWriter output) {
					
			DateFormat formatter ; 
			formatter = new SimpleDateFormat("yyMMdd");
			output.write(b.getIsbn()+"#");
			output.write(b.getCopyNumber()+"#");
			output.write(b.getTitle()+"#");
			output.write(b.getAuthor()+"#");
			output.write(b.getPublisher()+"#");
			output.write(b.getYear()+"#");
			output.write(b.getStat()+"#");
			output.write(formatter.format(b.getBorrowDate()));
			if(b.getReturnDate() != null){
				output.write("#"+formatter.format(b.getReturnDate()));
				output.write("#"+ b.getLCardNumber()+"#");
			}
			output.write("\n");
		}
		//write the wrong arrayList to the file ErrorBooks
		private static void WriteAFile21(ArrayList<String> wrongBooklist) {
			try {
				    FileWriter fstream1 = new FileWriter("ErrorLines.txt");
	  	    	     BufferedWriter out2 = new BufferedWriter(fstream1);
	  	    	      for (int h = 0;h < wrongBooklist.size(); h++){
	  	    	      out2.write(wrongBooklist.get(h)+"#");
	  	    	      out2.write("\n");
	  	    	      }
				out2.close();
				
			} catch (IOException e) {
				System.out.print("Something went wrong with the file");
			}
		}
		
		//method to sort the array by the author
		public static void sortAuthor(ArrayList <Book1> objectBook){
			
			for (int i=0; i<objectBook.size(); i++){
				for (int j=(objectBook.size()-1); j>i; j--){
					Book1 book1 =objectBook.get(i);
					Book1 book2 = objectBook.get(j);
					if(book2.getAuthor().compareTo(book1.getAuthor()) < 0 ){
						Book1 temp = book1;
						objectBook.set(i, book2);
						objectBook.set(j, temp);
					}
				}
			}
		
		}
}



