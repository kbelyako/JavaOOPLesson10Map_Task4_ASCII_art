package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map;

public class AsciiDict {

	private Map<Character, String[]> dict;
	private int heigh;

	public AsciiDict() {
		super();
		this.dict = mapFill("Alpha1.txt");
		this.heigh = 9;
	}

	private Map<Character, String[]> mapFill(String path) {
		Map<Character, String[]> dict = new HashMap();
		String[] array = new String[6];
		String res = "";
		try (BufferedReader f = new BufferedReader(new FileReader(path))) {
			String temp_str = "";
			int lineCounter = 0;
			for (; (temp_str = f.readLine()) != null;) {
				lineCounter = lineCounter + 1;
				// if (temp_str.charAt(0)!=' ' || temp_str.charAt(0)!='*') {
				if (temp_str.matches("[A-Z?]")) {
					char key = temp_str.charAt(0);
					String[] asii_Char = new String[9];
					for (int i = 0; i < 9; i++) {
						String str2 = "";
						temp_str = f.readLine();
						for (int j = 0; j <= 12 - temp_str.length(); j++) {
							str2 = str2 + " ";
						}
						temp_str = temp_str + str2;
						 //System.out.println(temp_str);
						asii_Char[i] = temp_str;
					}
					// dict.put(key, asii_Char);
					dict.put(key, asii_Char);
				}
			}

		} catch (IOException e) {
			System.out.println("ERROR");
		}
		addBlank(dict);
		return dict;
	}

	public void print(String text) {
		char[] charArray = text.toCharArray();
		String temp_str = "";
		for (int j = 0; j < this.heigh; j++) {
			String res_str = "";
			for (int i = 0; i < charArray.length; i++) {
				temp_str = dict.get(charArray[i])[j];
				res_str = res_str + temp_str;
			}
			System.out.println(res_str);
		}
	}
	
	private void addBlank(Map<Character, String[]> inMap) {
		
		String[] asii_Char = new String[9];
		for (int i = 0; i < asii_Char.length; i++) {
			asii_Char[i]="          ";
		}		
		inMap.put(' ', asii_Char);
		//Map<Character, String[]> dict = new HashMap();

	}

}
