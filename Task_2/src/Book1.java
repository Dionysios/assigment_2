import java.util.Date;


public class Book1 {

	public String Isbn;

    public int copyNumber = 0;

    public String Title;

    public String Publisher;
    
    public String Author;
    
    public int Year = 0;
    
    public int Stat = 0;
    

	public Date BorrowDate; //change to date
    
    public Date ReturnDate; // change to date
    
    public int LCardNumber = 0;	  

    public Date getBorrowDate() {
    	return BorrowDate;
    }
    
    public void setBorrowDate(Date borrowDate) {
    	BorrowDate = borrowDate;
    }
    
    public Date getReturnDate() {
    	return ReturnDate;
    }
    
    public void setReturnDate(Date returnDate) {
    	ReturnDate = returnDate;
    }

    public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String isbn) {
		this.Isbn = isbn;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getStat() {
		return Stat;
	}

	public void setStat(int stat) {
		Stat = stat;
	}


	public int getLCardNumber() {
		return LCardNumber;
	}

	public void setLCardNumber(int lCardNumber) {
		LCardNumber = lCardNumber;
	}


	   
   void changeIsbn (String newValue){
	   Isbn = newValue;
   }
	
   void changecopyNumber (int newValue){
	   copyNumber = newValue;
   }
   
   void changeTitle (String newValue){
	   Title = newValue;
   }
   public void changeAuthor(String newValue) {
	  Author = newValue;
	   
   }
   
   void changePublisher (String newValue){
	   Publisher = newValue;
   }
   
   void changeYear (int newValue){
	   Year = newValue;
   }
   
   void changeStat (int newValue){
	   Stat = newValue;
   }
   
   
 //  void applyBrakes (){
//	   speed = speed - decrement;
 //  }
   void printStates(){
	   System.out.println("Isdn: "+ Isbn +" copyNumber "+ copyNumber + " Title "+ Title +
			   " Publisher :" + Publisher + " Year :" + Year + " Stat :" + Stat + " BorrowDate :" + 
			   "ReturnDate :"+ ReturnDate + "LCard :" + LCardNumber);
   }

public Book1() {
	}

}
