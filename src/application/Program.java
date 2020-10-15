package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = scanner.nextLine();
		scanner.nextLine();
		
		Map<String, Integer> urna = new TreeMap<String, Integer>();
		
		try(BufferedReader read = new BufferedReader(new FileReader(path)))
		{
			String linha = read.readLine();
			while(linha != null) {
				String[] vect = linha.split(",");
				if(urna.containsKey(vect[0])) {
					int aux = urna.get(vect[0]);
					urna.remove(vect[0]);
					
					urna.put(vect[0], Integer.parseInt(vect[1]) + aux);
				}
				else {
					urna.put(vect[0], Integer.parseInt(vect[1]));
				}
				
				linha = read.readLine();
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		for(String key : urna.keySet()) {
			System.out.println(key + ": " + urna.get(key));
		}
		
		scanner.close();
	}

}
