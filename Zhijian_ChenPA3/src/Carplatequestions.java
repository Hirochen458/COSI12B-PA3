/**
* Zhijian Chen
* chen5340@brandeis.edu
* 10/05/2021
* PA3
* This program/class mainly focus on fixing problem with car plates.
* Known Bugs: explain bugs/null pointers/etc.
*/


import java.util.Scanner;
import java.util.*;


public class Carplatequestions {

	public static void main(String[] args) {
		createRandomPlate("123AB4", 9);
		nextPlate("215BG2");
		nextPlate("499ZZ9");
		nextPlate("999ZZ9");
		getSerial("215BG2");
		String plate1 = "LOBSTA";
		String plate2 = "AAA22A";
		String plate3 = "abcdef";
		isLegalVanityPlate(plate1);
		isLegalVanityPlate(plate2);
		isLegalVanityPlate(plate3);
		//String[] plates = new String[]{"215BG2","399ZZ2","399ZZ3","1ABC21"};
	    //getMonthStats(plates);
	    //String[] plates = new String[]
				//{"215BG2","399ZZ2","399ZZ3","1LLC21"}; 
		//String[] serials = new
				//String[] {"12AB34","123AB4","1AB234","1ABC23"};
		//getSerialStats(plates, serials);
		//String partial = "39-ZZ";
		//String[] plates = new String[]{"215BG2","399ZZ2","399ZZ3","1LLC21"};
		//matchPlate(partial, plates); 
		
	}
	public static String createRandomPlate(String serial, int month) {
		String number = "123456789";
		String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String newplate = "";
		Random rand = new Random();
		int rNN = rand.nextInt(9);
		int rNL = rand.nextInt(25);
		
		for (int i = 0; i <= 4; i++) {
			Boolean norl = Character.isDigit(serial.charAt(i));
			if (norl) {
				newplate += number.substring(rNN, rNN+1);
				rNN = rand.nextInt(9);
			}else {
				newplate += letter.substring(rNL,rNL+1);
				rNL = rand.nextInt(25);
			}
		}
		//String m = String.valueOf(month);
		String m = number.substring(month-1,month);
		newplate += m;
		System.out.println(newplate);
		return newplate;
			
		}
	
	
	public static String nextPlate(String plate) {
		int r = 1;
		String newplate = "";
		if (plate.equals("999ZZ9")) {
			System.out.println("error");
			return "error";
		} else {
			for (int i = 5; i>=0; i--) {
				Boolean n = Character.isDigit(plate.charAt(i));
		        Boolean l = Character.isLetter(plate.charAt(i));
				char ch = plate.charAt(i);
				if (r > 0) {
					if (l) {
						if (ch == 'Z') {
							newplate = 'A' + newplate;
							r = 1;
						} else {
							newplate = (char)(ch + 1) + newplate;
							r = 0;
						}
					} else if (n) {
						if (ch == '9') {
							newplate = '0' + newplate;
							r = 1;
						} else {
							newplate = (char)(ch + 1) + newplate;
							r = 0;
						}
					}
				} else {
					newplate = ch + newplate;
				}
			}
		}
		System.out.println(newplate);
		return newplate;
		
	}
	
	
	public static String getSerial(String plate) {
		String serial = "";
		String number = "123456789";
		String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int n = 0;
		int l = 0;
		
		for (int i = 0; i <= 5; i++) {
			Boolean norl = Character.isDigit(plate.charAt(i));
			if (norl) {
				serial += number.substring(n,n+1);
				n +=1;
				
			}else {
				serial += letter.substring(l,l+1);
				l +=1;
				
			}
		}
		
		//System.out.println(serial);
		return serial;
	}
	
	
	public static boolean isLegalVanityPlate(String plate) {
		//boolean t = true;
		boolean f = false;
		boolean torf = true;
		if (Character.isLetter(plate.charAt(0))!= true && Character.isLetter(plate.charAt(1))!=true){
			return f;
		}
		if (plate.length() > 6 || plate.length()<2) {
			return f;
		}
		for (int i = plate.length()-1; i>=1; i--) {
			if (Character.isLetter(plate.charAt(i))== true) {
				if (plate.charAt(i)>='A' && plate.charAt(i)<='Z') {
					if (Character.isDigit(plate.charAt(i-1))==true) {
					    //System.out.println("false");
					    return f;
				    }
				}else {
					//System.out.println("false");
					return f;
				}
				
			}else if(Character.isLetter(plate.charAt(i))!= true && Character.isDigit(plate.charAt(i))!= true) {
				return f;
			}
		}
		
		
		//System.out.println("true");
		return torf;
	}
	
	
	public static float[] getMonthStats(String[] plates) {
		float[] month = new float[10];
		int[] time = new int[10];
		int total = 0;
		for (int i = 0; i < plates.length; i++) {
			char c = plates[i].charAt(5);
			int b = c - 48;
			time[b] += 1;
		}
		for (int o = 0; o < time.length; o++) {
			total += time[o];
		}
		for (int p = 0; p < month.length; p++) {
			month[p] = (float) time[p]/total;
		}
		//System.out.println(Arrays.toString(time));
		//System.out.println(total);
		//System.out.println(Arrays.toString(month));
		return month;
	}
	
	
	
	
	
	public static float[] getSerialStats(String[] plates, String[] serials) {
		float[] stats = new float[serials.length];
		int[] time = new int[serials.length];
		int total = 0;
		String[] formattotal = new String[plates.length];
		String[] formattotal2 = new String[serials.length];
		String format = "";
		String format2 = "";
		for (int i = 0; i < plates.length; i++) {
			for (int u= 0; u < 6; u++) {
				if (Character.isLetter(plates[i].charAt(u))== true) {
					format += 0;
				}else {
					format += 1;
				}
			}
			formattotal[i] = format;
			format ="";
		}
		for (int y = 0; y < serials.length; y++) {
			for (int t= 0; t < 6; t++) {
				if (Character.isLetter(serials[y].charAt(t))== true) {
					format2 += 0;
				}else {
					format2 += 1;
				}
			}
			formattotal2[y] = format2;
			format2 ="";
		}
		for (int p = 0; p < plates.length; p++) {
			for (int r = 0; r < serials.length; r++) {
				if (formattotal[p].equals(formattotal2[r])) {
					time[r] += 1;
				}
			}
		}
		for (int e = 0; e < formattotal2.length; e++) {
			total += time[e];
		}
		for (int w = 0; w < stats.length; w++) {
			stats[w] = (float) time[w]/total;
		}
		
		//System.out.println(format);
		//System.out.println(Arrays.toString(formattotal));
		//System.out.println(format2);
		//System.out.println(Arrays.toString(formattotal));
		//System.out.println(total);
		//System.out.println(Arrays.toString(stats));
		return stats;
	}
	
	
	public static String[] matchPlate(String partial, String[] plates) {
		//String sameplate[];
		
		int num = 0;
		int numofsameplate = 0;
		//sameplate[1] = "ABCDEF";
		
		String str1 = "";
		String str2 = "";
		//String makesure = "";
		//String makesure2 = "";
		
		for (int i = 0; i < partial.length(); i++) {
			if (partial.substring(i, i+1).equals("-")) {
				str1 = partial.substring(0,i);
				str2 = partial.substring(i+1,partial.length());
			}
		}
		for (int t = 0; t< plates.length; t++) {
			if (plates[t].indexOf(str1,0)!= -1 && plates[t].indexOf(str2,0)!= -1) {
				numofsameplate +=1;
				//System.out.println(plates[t]);
			}
		}
		String[] sameplate = new String[numofsameplate];
		for (int p = 0; p <plates.length; p++) {
			if (plates[p].indexOf(str1,0)!= -1 && plates[p].indexOf(str2,0)!= -1) {
				//System.out.println(plates[p]);
				sameplate[num] = plates[p];
				num +=1;
			}
		}
		
		//System.out.println(str1);
		//System.out.println(str2);
		//System.out.println(numofsameplate);
	    //System.out.println(Arrays.toString(sameplate));
	    return sameplate;
	}
	

}
