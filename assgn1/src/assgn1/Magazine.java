package assgn1;

public class Magazine implements Comparable<Magazine>{
int magazineID;
String magazineName;
String PublisherName;

//to do: constructors and a print method that prints them on 3 lines, then /n
	public int compareTo(Magazine mag) {
		return Integer.compare(this.magazineID,mag.magazineID);
	
	}
	
	public Magazine Magazine(int ID, String name, String Pname) {
		
		magazineID=ID;
		magazineName=name;
		PublisherName=Pname;
		return this;
	}
	public int getID(){
		return magazineID;
	}
	public String getMagName(){
		return magazineName;
	}
	public String getPubName(){
		return PublisherName;
	}
	public void setID(int newID)
	{
		magazineID=newID;
	}
	public void setMagName(String NewM){
		magazineName = NewM;
	}
	public void setPubName(String NewP){
		PublisherName = NewP;
	}
	public void PrintMag(){
		System.out.println("Magazine ID = "+magazineID+'\n'
				+"Magazine name = "+magazineName+'\n'
				+"Publisher name = "+PublisherName+'\n');
	}
}
