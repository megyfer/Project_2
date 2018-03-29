//Meg Fernandez

package assgn1;
import assgn1.Magazine;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MagazineList{
	private Magazine ma = new Magazine();
	static Scanner in = new Scanner(System.in);
	private Node head;
	
	private static class Node{
		private Magazine mag;
		private Node next;
		public Node(Magazine mag, Node next){
			this.mag = mag;
			this.next=next;
		}
	}
	
	MagazineList(){
		head=null;
	}//constructor
	void makeEmpty(){
		head=null;
	}
	Magazine findID(int ID){
		if(head==null){System.out.println("ID not found");
		}
		if(head.mag.getID()==ID){
			head.mag.PrintMag();
			return head.mag;
		}
		Node c=head;
		Node p=null;
		while(c !=null && !(c.mag.getID()==ID)){
			p=c;
			c=c.next;
		}
		if(c.mag.getID()==ID){
			p.mag.PrintMag();
			return p.mag;
		}
		else{
			System.out.println("ID not found");
		}
		return null;
		} //return null if not found
	boolean insertAtFront(Magazine mag){
		head=new Node(mag, head);
		return false;} //false if ID already exists
	Magazine deleteFromFront(){
			if(head == null){
				return null;
			}
			head.mag.PrintMag();
			Magazine p = head.mag;
			head=head.next;
			return null;
		} //delete and return mag or null 
	boolean deleteID(int ID){
		if(head==null){System.out.println("ID not found");}
		if(head.mag.getID()==ID){
			head=head.next;
			System.out.println("ID removed");
			return true;
		}
		Node c=head;
		Node p=null;
		while(c!=null&&!(c.mag.getID()==ID)){
			p=c;
			c=c.next;
		}
		if(c.mag.getID()==ID){
			p.next=c.next;
			System.out.println("ID removed");
			return true;
		}
		System.out.println("ID not found");
		return false;} //return false if not found
	boolean printRecord(int ID){
		if(this.findID(ID)!=null){
			return true;
		}
		
		return false;}//return false if not found
	void printAllRecords(){
		Node c=head;
		if(c==null){
			System.out.println("It's empty!");
		}
		while(c!=null){
			c.mag.PrintMag();
			c=c.next;
		}
		
	} //print all elements in order or do nothing
	
	
	public static void main(String[] args){
		MagazineList list = new MagazineList();
		String s="p";
		
		while(!(s.equalsIgnoreCase("quit"))){
		System.out.println("Hello! Your available commands are:"+'\n'+
				"Empty"+'\n'+
				"find ID" +'\n'+
				"put at front"+'\n'+
				"delete from front"+'\n'+
				"delete ID"+'\n'+
				"print ID"+'\n'+
				"print all"+'\n'
				+"quit");
		System.out.println("what would you like to do?");
		s = in.nextLine();
			if(s.equalsIgnoreCase("empty")){
				if(list.head!=null){
					list.makeEmpty();		
				System.out.println("Emptied");
				}
				else{
					System.out.println("It's already empty");
				}
				
			}
			else if(s.equalsIgnoreCase("find ID")){
				System.out.println("which ID would you like to find?");
				s=in.nextLine();
				list.findID(Integer.parseInt(s));
				
			}
			else if(s.equalsIgnoreCase("put at front")){
				System.out.println("What is the ID?");
				String i = in.nextLine();
				System.out.println("what is the magazine name?");
				String m=in.nextLine();
				System.out.println("what is the publisher name?");
				String p=in.nextLine();
				Magazine n = new Magazine();
				n.Magazine(Integer.parseInt(i), m, p);
				
				
				list.insertAtFront(n);
			}
			else if(s.equalsIgnoreCase("delete from front")){
				
				list.deleteFromFront();
			}
			else if(s.equalsIgnoreCase("delete ID")){
				System.out.println("Which ID would you like to delete?");
				s=in.nextLine();
				list.deleteID(Integer.parseInt(s));
			}
			else if(s.equalsIgnoreCase("print ID")){
				System.out.println("Which ID would you like to print?");
				s=in.nextLine();
				list.printRecord(Integer.parseInt(s));
			}
			else if(s.equalsIgnoreCase("print all")){
				list.printAllRecords();
			}
			else if(s.equalsIgnoreCase("quit")){
				System.exit(0);
			}
			else{System.out.println("Invalid command");}
		}
	} //print all operations available
}
