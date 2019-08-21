//4. Реализуйте программу, которая сопоставит каждой букве ее представление в виде ASCII - art, например
//А 
//          *
//        *   *
//       *     *
//       *******
//    *            *
//  *                *
//Ваша программа должна дать возможность вывода произвольного
//текста на экран в виде его ASCII-art представления.

package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		       
		
		AsciiDict testDict = new AsciiDict();		
	   
	    testDict.print("TEST MESSAGE");

	}
	
	

}
