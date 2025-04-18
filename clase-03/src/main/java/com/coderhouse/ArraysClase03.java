package com.coderhouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraysClase03 {

	public static void main(String[] args) {
		
		//Arrays
		//1
		int[] numerosEnteros = {4,15,7,9,10};
		//El array tiene un tamaño fijo y la lista tiene un tamaño dinamico
		
		//2
		int suma = 0;
		for(int num : numerosEnteros) {
			suma += num;
		};
		System.out.println("La suma es: " + suma);
		
		//3
		int maximo = numerosEnteros[0];
		for (int num : numerosEnteros) {
			if(num > maximo) {
				maximo = num;
			}
		};
		System.out.println("El numero mayor es: " + maximo);
		
		//4
		int minimo = numerosEnteros[0];
		for (int num : numerosEnteros) {
			if(num < minimo) {
				minimo = num;
			}
		};
		System.out.println("El numero menor es: " + minimo);
		
		//5
		int pares = 0;
		for (int num : numerosEnteros) {
			if(num % 2 == 0) {
				pares++;
			}
		};
		System.out.println("Hay " + pares + " numeros pares en el array.");
		
		
		//7
		String[] palabras = {"Miercoles","Feriado","Java","Ejercicios"};
		for (String p : palabras) {
			System.out.println(p);
		};
		
		
		//List
		//11
		List<Integer> enteros = new ArrayList<>();
		enteros.add(50);
		enteros.add(-12);
		enteros.add(200);
		enteros.add(-344);
		enteros.add(41);
		
		//12
		//enteros.remove(0);
		
		//13
//		System.out.println(enteros.size());
		
		//14
//		for (int num : enteros) {
//			suma += num;
//		};
//		System.out.println(suma);
//		
		//15
//		for(int num : enteros) {
//			if (num > maximo) {
//				maximo = num;
//			}
//		}
//		System.out.println(maximo);
		
		//18
		List<String> cadenasFrutales = new ArrayList<>();
        cadenasFrutales.add("Manzana");
        cadenasFrutales.add("Kiwi");
        cadenasFrutales.add("Banana");
        cadenasFrutales.add("Uva");
        cadenasFrutales.add("Mandarina");
		
		//19
//		for (String fruta : cadenasFrutales) {
//			System.out.println(fruta);
//		};
		
		//20
//		cadenasFrutales.clear();
		
		//Iterator
		//31
		Iterator<Integer> iterator = enteros.iterator();
//		while (iterator.hasNext()) {
//			int num = iterator.next();
//			System.out.println(num);
//		}
		
		//32
//		while (iterator.hasNext() ) {
//			int num = iterator.next();
//			if (num % 2 != 0) {
//				iterator.remove();
//			}
//		};
//		System.out.println(enteros);
		
		//33
		Iterator<String> iterator2 = cadenasFrutales.iterator();
//		while(iterator2.hasNext()) {
//			String a = iterator2.next();
//			System.out.println(a);
//		}
		
		//34
//		int contador = 0;
//		while(iterator2.hasNext()) {
//			iterator2.next();
//			contador++;
//		}
//		System.out.println(contador);
		
		//37
//		while (iterator.hasNext()) {
//			int num = iterator.next();
//			if (num > 50) {
//				System.out.println(num);
//			}
//		}
		
		//39
//		while (iterator.hasNext()) {
//			int num = iterator.next();
//			if (num > 0) {
//				System.out.println(num);
//			}
//		}
		
		//40
//		while(iterator2.hasNext()) {
//			String p = iterator2.next();
//			if (p.length() > 6) {
//				System.out.println(p);
//			}
//		}
		
		//Ciclo for
		//41 
//		for (int i = 1; i <= 10; i++) {
//			System.out.println(i);
//		}
		
		//42
//		int sumatoria = 0;
//		for (int i = 1; i <= 100; i++) {
//			sumatoria += i;
//		}
//		System.out.println(sumatoria);
		
		//43
//		for(int i = 2; i <= 20; i++) {
//			if (i % 2 == 0) {
//				System.out.println(i);
//			}
//		}
		
		//44
//		for(int i = 0; i < numerosEnteros.length; i++) {
//			System.out.println(numerosEnteros[i]);
//		}
		
		//45
//		for(int i = 5; i <= 50; i++) {
//			if (i % 5 == 0) {
//				System.out.println(i);
//			}
//		};
		
		//forEach
		
		//51
		for (String a : palabras) {
			System.out.println(a);
		}
		
		//52
		for (String a : cadenasFrutales) {
			System.out.println(a);
		}
		
		//53
		int sumaTotal = 0;
		for (int i : numerosEnteros) {
			sumaTotal += i;
		}
		System.out.println(sumaTotal);
		
		//54
		int multXtres = 0;
		for (int i : numerosEnteros) {
			multXtres = i * 3;
			System.out.println(multXtres);
		}
		
	}

}
