/*REMINDER FOR MYSELF:
-NO ARRAYS
-AVOID CHAINING METHODS*/
import java.util.*;
import java.awt.*;
import java.io.*;
public class BabyNames {
	public static final int STARTING_YEAR = 1890;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 30;
	/*Main method shouldn't:
	-Draw on a drawing panel
	-Read lines from a file (nextLine)*/
	public static void main (String[]args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		Scanner names = new Scanner(new File("names.txt"));
		Scanner meanings = new Scanner(new File("meanings.txt"));
		String name = intro(console);
		String data = getData(names, name);
		String meaning = "";
		if (!(data.contains("not found"))){
			meaning = getMeaning(meanings, name);
			fixedGraphics(meaning);
		}
		System.out.println(data);
		System.out.println(meaning);
		
	}
	public static String intro (Scanner console){
		System.out.println("This program allows you to search through the");
		System.out.println("data from the Social Security Administration");
		System.out.println("to see how popular a particular name has been");
		System.out.println("since 1890.\n");
		System.out.print("Name: ");
		return console.nextLine().toUpperCase();
	}
	public static String getData (Scanner names, String name){
		while (names.hasNextLine()){
			String tempName = names.nextLine().toUpperCase();
			if (tempName.contains(name)){
				return tempName;
			}
		}
		return "\"" + name + "\" not found.";
	}
	public static String getMeaning (Scanner meanings, String name){
		while (meanings.hasNext()){
			String tempName = meanings.next();
			String tempMeaning = meanings.nextLine();
			if (tempName.toUpperCase().equals(name)){
				return tempName + tempMeaning;
			}
		}
		return "\"" + name + "\" not found.";
	}
	public static void fixedGraphics (String meaning){
		DrawingPanel panel = new DrawingPanel(780,560);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.WHITE);
		g.drawString(meaning,0,16);
	}
	public static void varyGraphics (){
		
	}
	
}