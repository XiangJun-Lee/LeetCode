package com.leetcode2022;

class IntToRoman {
	public static String intToRoman(int num) {
		char[] numToChar = String.valueOf(num).toCharArray();
		StringBuilder result = new StringBuilder();
		for(int i=0;i<numToChar.length;i++) {
			int  n= numToChar[i]-'0';
			result.append(change(n,numToChar.length-i-1));
		}
		return result+"";
    }

	private static String change(int num, int i) {
		// TODO Auto-generated method stub
		String result = "";
		String one =null;
		String five = null;
		String ten ="";
		switch (i) {
		case 2:
			one = "C";
			five = "D";
			ten = "M";
			break;
		case 1:
			one = "X";
			five = "L";
			ten = "C";
			break;
		case 0:
			one = "I";
			five = "V";
			ten = "X";
			break;
		default:
			one = "M";
			break;
		}
		if(num<4) {
			for(int j=0;j<num;j++) {
				result+=one;
			}
			return result;
		}
		if(num==4) {
			return one+five;
		}
		if(num==5) {
			return five;
		}
		if(num>5&&num<9) {
			result = five;
			for(int j=5;j<num;j++) {
				result+=one;
			}
			return result;
		}
		if(num==9) {
			return one+ten;
		}
		return result;
		
	}

	public static void main(String[] args) {
		int num = 49;
		System.out.println(intToRoman(num));
	}
}
