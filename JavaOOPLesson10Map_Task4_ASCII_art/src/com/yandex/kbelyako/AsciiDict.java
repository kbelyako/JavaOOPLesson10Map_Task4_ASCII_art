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
		this.heigh = 9;
		this.dict = mapFill("Alpha1.txt");
	}

	private Map<Character, String[]> mapFill(String path) {
		Map<Character, String[]> dict = new HashMap();
		String[] array = new String[6];
		String res = "";
		try (BufferedReader f = new BufferedReader(new FileReader(path))) {
			String tempStr = "";
			int lineCounter = 0;
			for (; (tempStr = f.readLine()) != null;) {
				lineCounter = lineCounter + 1;
				// if (tempStr.charAt(0)!=' ' || tempStr.charAt(0)!='*') {
				if (tempStr.matches("[A-Z?]")) {
					char key = tempStr.charAt(0);
					String[] asiiChar = new String[this.heigh];
					for (int i = 0; i < this.heigh; i++) {
						String str2 = "";
						tempStr = f.readLine();
						for (int j = 0; j <= 12 - tempStr.length(); j++) {
							str2 = str2 + " ";
						}
						tempStr = tempStr + str2;
						// System.out.println(tempStr);
						asiiChar[i] = tempStr;
					}
					dict.put(key, asiiChar);
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
		String tempStr = "";
		for (int j = 0; j < this.heigh; j++) {
			String res_str = "";
			for (int i = 0; i < charArray.length; i++) {
				tempStr = dict.get(charArray[i])[j];
				res_str = res_str + tempStr;
			}
			System.out.println(res_str);
		}
	}

	private void addBlank(Map<Character, String[]> inMap) {
		String[] asiiChar = new String[this.heigh];
		for (int i = 0; i < asiiChar.length; i++) {
			asiiChar[i] = "          ";
		}
		inMap.put(' ', asiiChar);
	}

}
