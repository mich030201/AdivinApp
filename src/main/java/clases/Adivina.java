package clases;

import java.util.Scanner;

public class Adivina {
	
	public static void main(String[] args) {
		int n_aleatorio, intentos=0, entrada;
		Scanner scanner = new Scanner(System.in); 
		n_aleatorio = (int) (Math.random() * 100) + 1;
		
		do {
			System.out.println(n_aleatorio);
			System.out.println("Introduce un nuemro del 1 al 100");
			entrada = scanner.nextInt();
			
			if(entrada > n_aleatorio) {
				System.out.println("El numero es menor que "+ entrada);
				intentos = intentos+1;
			} else if(entrada < n_aleatorio) {
				System.out.println("El numero es mayor que "+ entrada);
				intentos = intentos+1;
			} else {
				System.out.println("Bien hecho, has acertado el numero " + n_aleatorio + " en " + intentos + " intentos");
			}	
		}while(entrada != n_aleatorio);	
		scanner.close();
	}
}
