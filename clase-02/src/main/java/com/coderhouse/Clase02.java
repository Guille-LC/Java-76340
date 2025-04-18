package com.coderhouse;

import java.util.Scanner;

public class Clase02 {

	public static void main(String[] args) {
		
		//Ejercicios con if
		int numeroPositivo = 7;
		if (numeroPositivo > 0) {
			System.out.println("El numero " + numeroPositivo + " es positivo");
		};
		
		int edad = 9;
		if (edad >= 18) {
			System.out.println("Usted es mayor de edad");
		};
		
		if (numeroPositivo % 2 != 0) {
            System.out.println(numeroPositivo + " es impar.");
        };
        
        String stringRandom = "Buenas tardes";
        if (stringRandom.isEmpty() == false) {
        	System.out.println("El string no esta vacio porque contiene: " + stringRandom);
        };
        
        int numeroMultiplo = 25;
        if (numeroMultiplo % 5 == 0) {
        	System.out.println(numeroMultiplo + " es multiplo de 5.");
        };
        
        //if-else
        if (numeroPositivo % 2 == 0) {
        	System.out.println(numeroPositivo + " es par.");
        } else {
        	System.out.println(numeroPositivo + " es un numero impar.");
        };
        
        if (edad >= 18) {
        	System.out.println("Usted es mayor de edad y puede votar");
        } else {
        	System.out.println("Usted es menor de edad y no puede votar");
        };
        
        char letraRandom = 'a';
        if (letraRandom == 'a' || letraRandom == 'e' || letraRandom == 'i' || letraRandom == 'o' || letraRandom == 'u') {
        	System.out.println(letraRandom + " es una vocal.");
        } else {
        	System.out.println(letraRandom + " no es una vocal.");
        };
        
        if (numeroPositivo < 0 || numeroPositivo > 0) {
        	System.out.println(numeroPositivo + " es mayor o menor que 0.");
        } else {
        	System.out.println(numeroPositivo + " es igual a 0.");
        }
        
        int anioBisiesto = 2013;
        if (anioBisiesto % 4 == 0 && anioBisiesto % 100 != 0 || (anioBisiesto % 400 == 0)) {
        	System.out.println("Es un año bisiesto.");
        } else {
        	System.out.println("No es un año bisiesto");
        }
        
        int categoriaPersona = 66;
        if (categoriaPersona < 2) {
        	System.out.println("Es un bebe");
        } else if (categoriaPersona > 2 && categoriaPersona <= 12) {
        	System.out.println("Es un niño");
        } else if (categoriaPersona > 12 && categoriaPersona <= 18) {
        	System.out.println("Es un adolescente");
        } else if (categoriaPersona > 18 && categoriaPersona <= 64) {
        	System.out.println("Es un adulto");
        } else if (categoriaPersona > 64) {
        	System.out.println("Es un anciano");
        };
        
        if (edad <= 17) {
        	System.out.println("Usted tiene que pagar 5€");
        } else if (edad >= 18 && edad <= 30) {
        	System.out.println("Usted tiene que pagar 10€");
        } else {
        	System.out.println("Usted tiene que pagar 7€");
        };
        
        int notaEvaluacion = 50;
        if (notaEvaluacion >= 90) {
        	System.out.println("Obtuviste una A");
        } else if (notaEvaluacion >= 80) {
        	System.out.println("Obtuviste una B");
        } else if (notaEvaluacion >= 70) {
        	System.out.println("Obtuviste una C");
        } else if (notaEvaluacion >= 60) {
        	System.out.println("Obtuviste una D");
        } else {
        	System.out.println("Obtuviste una F");
        };
        
        if (numeroPositivo == 0) {
        	System.out.println(numeroPositivo + " es igual a 0.");
        } else if (numeroPositivo > 0){
        	System.out.println(numeroPositivo + " es mayor a 0.");
        } else {
        	System.out.println(numeroPositivo + " es menor a 0.");
        };
        
        String estadoVolcan = "activo";
        if (estadoVolcan == "dormido") {
        	System.out.println("El volcan esta " + estadoVolcan);
        } else if (estadoVolcan == "activo") {
        	System.out.println("El volcan esta " + estadoVolcan);
        } else {
        	System.out.println("La erupcion del volcan es inminente");
        };
        
        //Switch
        int diaDeLaSemana = 2;
        switch (diaDeLaSemana) {
         case 1:
        	 System.out.println("Hoy es lunes");
        	 break;
         case 2:
        	 System.out.println("Hoy es martes");
        	 break;
         case 3:
        	 System.out.println("Hoy es miercoles");
        	 break;
         case 4:
        	 System.out.println("Hoy es jueves");
        	 break;
         case 5:
        	 System.out.println("Hoy es viernes");
        	 break;
         case 6:
        	 System.out.println("Hoy es sabado");
        	 break;
         case 7:
        	 System.out.println("Hoy es domingo");
        	 break;
         default:
        	 System.out.println("No es un dia valido");
        	 break;
        }
        
        int mes = 10;
        switch (mes) {
         case 1:
        	 System.out.println("enero");
        	 break;
         case 2:
        	 System.out.println("febrero");
        	 break;
         case 3:
        	 System.out.println("marzo");
        	 break;
         case 4:
        	 System.out.println("abril");
        	 break;
         case 5:
        	 System.out.println("mayo");
        	 break;
         case 6:
        	 System.out.println("junio");
        	 break;
         case 7:
        	 System.out.println("julio");
        	 break;
         case 8:
        	 System.out.println("agosto");
        	 break;
         case 9:
        	 System.out.println("septiembre");
        	 break;
         case 10:
        	 System.out.println("octubre");
        	 break;
         case 11:
        	 System.out.println("noviembre");
        	 break;
         case 12:
        	 System.out.println("diciembre");
        	 break;
         default:
        	 System.out.println("No es un mes valido");
        	 break;
        };
        
        int estacionDelAnio = 3;
        switch (estacionDelAnio) {
        case 1:
       	 System.out.println("invierno");
       	 break;
        case 2:
       	 System.out.println("primavera");
       	 break;
        case 3:
       	 System.out.println("verano");
       	 break;
        case 4:
       	 System.out.println("otoño");
       	 break;
       	default:
       	 System.err.println("no es una estacion valida");
	    }
        
        char operador = '+';
        switch (operador) {
        case '+':
       	 System.out.println("suma");
       	 break;
        case '-':
       	 System.out.println("resta");
       	 break;
        case '*':
       	 System.out.println("multiplicacion");
       	 break;
        case '/':
       	 System.out.println("division");
       	 break;
       	default:
       	 System.err.println("no es un operador valido");
	    };
	    
	    int fruta = 4;
        switch (fruta) {
        case 1:
       	 System.out.println("manzana");
       	 break;
        case 2:
       	 System.out.println("platano");
       	 break;
        case 3:
       	 System.out.println("naranja");
       	 break;
        case 4:
       	 System.out.println("uva");
       	 break;
       	default:
       	 System.err.println("no es una fruta valida");
	    };
	    
	    //Operadores ternarios
	    int nuevoNumero = 11;
	    boolean condicion = nuevoNumero % 2 == 0;
	    String resultado = condicion ? "El numero es par" : "El numero es impar";
	    System.out.println(resultado);
	    
	    System.out.println((edad >= 18) ? "Es mayor de edad" : "Es menor de edad");
	    
	    System.out.println((nuevoNumero > 0) ? "Es positivo" : "Es negativo");
	    
	    int primerNumero = 9;
	    int segundoNumero = 5;
	    boolean res = primerNumero > segundoNumero;
	    System.out.println(res 
	    		? primerNumero + " es mayor que " + segundoNumero 
	    		: primerNumero + " es menor que " + segundoNumero);
	    
	    int notaAlumno = 6;
	    System.out.println((notaAlumno >= 7) ? "Aprobado" : "Desaprobado");
	    
	    //Math.random()
	    int min = 1;
	    int max = 10;
	    int numeroRandom = (int)(Math.random() * (max - min + 1) + min);
	    System.out.println(numeroRandom > 5 ? numeroRandom + " es mayor a 5" : numeroRandom + " no es mayor a 5");
	    
	    int dadoMin = 1;
	    int dadoMax = 6;
	    int dado = (int)(Math.random() * (dadoMax - dadoMin + 1) + dadoMin);
	    System.out.println(dado);
	    
	    int cero = 0;
	    int cien = 100;
	    int aleatorio = (int)(Math.random() * (cien - cero + 1) + cero);
	    System.out.println(aleatorio > 50 ? aleatorio + " es mayor a 50" : aleatorio + " no es mayor a 50");
	    
	    int cara = 0;
	    int cruz = 1;
	    int moneda = (int)(Math.random() * (cruz - cero + 1) + cara);
	    System.out.println(moneda == 0 ? "Cara" : "Cruz");
	    
	    int uno = 1;
	    int esMultiplo = (int)(Math.random() * (cien - uno + 1) + uno);
	    System.out.println( esMultiplo % 10 == 0 ? esMultiplo + " Es multiplo" : esMultiplo + " No es multiplo");
	    
	    //Combinando condicionales
	    System.out.println(nuevoNumero > 0 ? nuevoNumero + " es positivo" : nuevoNumero + " es negativo");
	
	    int dos = 2; 
	    int tres = 3;
	    int semaforo = (int)(Math.random() * (tres - uno + 1) + uno);
	    if (semaforo == 1) {
	    	System.out.println("Verde");
	    } else if (semaforo == 2) {
	    	System.out.println("Amarillo");
	    } else {
	    	System.out.println("Rojo");
	    };
	    
	    int loteria = (int) (Math.random() * (10 - 1 + 1) + 1);
	    System.out.println(loteria == 6 ? loteria + " es el numero ganador!" : "Siga participando...");
	    
	    int esDivisible = (int) (Math.random() * (100 - 1 + 1) + 1);
	    if (esDivisible % 3 == 0 && esDivisible % 5 == 0) {
	    	System.out.println(esDivisible + " es divisible por tres y por cinco");
	    } else if (esDivisible % 3 == 0) {
	    	System.out.println(esDivisible + " es divisible por tres");
	    } else if (esDivisible % 5 == 0) {
	    	System.out.println(esDivisible + " es divisible por cinco");
	    } else {
	    	System.err.println(esDivisible + " no es divisible ni por tres ni por cinco");
	    };
	    
	    System.out.println(dado >= 4 ? dado + " es mayor o igual a 4" : "Es menor a 4");
	    
	    if (esMultiplo < 30) {
	    	System.out.println("Bajo");
	    } else if (esMultiplo >= 30 && esMultiplo <= 70) {
	    	System.out.println("Medio");
	    } else {
	    	System.out.println("Alto");
	    };
	    
	    //Ejercicio 37
	    if (esMultiplo % 1 == 0 && esMultiplo % esMultiplo == 0) {
	        System.out.println(esMultiplo + " es un numero primo");
	    }; 
	    
//	    Scanner numeroUsuario = new Scanner(System.in);
//	    System.out.println("Diga un numero del 1 al diez");
//	    int numeroIngresado = numeroUsuario.nextInt();
//	    if (numeroIngresado == loteria) {
//	    	System.out.println("¡Acertaste!. El numero correcto es el " + loteria);
//	    } else {
//	    	System.err.println(numeroIngresado + " no es el numero correcto. El numero correcto es " + loteria);
//	    };
	    //numeroUsuario.close(); 
	    
	    int unoCincuenta = (int) (Math.random() * (50 - 1 + 1) + 1);
	    if (unoCincuenta >= 20 && unoCincuenta <= 30) {
	    	System.out.println(unoCincuenta + " esta entre 20 y 30.");
	    } else {
	    	System.err.println(unoCincuenta + " no esta en el rango 20, 30.");
	    };
	    
	    //Avanzados basicos
	    int dadoUno = (int) (Math.random() * (6 - 1 + 1) + 1);
	    int dadoDos = (int) (Math.random() * (6 - 1 + 1) + 1);
	    int dadoTres = (int) (Math.random() * (6 - 1 + 1) + 1);
	    if (dadoUno + dadoDos + dadoTres > 10) {
	    	System.out.println("Los tres dados dieron: " + dadoUno+ " " + dadoDos + " " + dadoTres + " Y juntos suman mas de diez.");
	    } else {
	    	System.out.println("Los tres dados dieron: " + dadoUno+ " " + dadoDos + " " + dadoTres + " Y juntos no suman mas de diez.");
	    };
	    
	    int ruletaColores = (int) (Math.random() * (5 - 1 + 1) + 1);
	    switch (ruletaColores) {
	    case 1:
	    	System.out.println(ruletaColores + " es azul.");
	    	break;
	    case 2:
	    	System.out.println(ruletaColores + " es rojo.");
	    	break;
	    case 3:
	    	System.out.println(ruletaColores + " es amarillo.");
	    	break;
	    case 4:
	    	System.out.println(ruletaColores + " es verde.");
	    	break;
	    case 5:
	    	System.out.println(ruletaColores + " es naranja.");
	    	break;
	    };
	    
//	    System.out.println("¿Que tipo de cliente es usted? Normal, Miembro o VIP");
//	    Scanner tipoCliente = new Scanner(System.in);
//	    String cliente = tipoCliente.nextLine().toLowerCase();
//	    switch (cliente) {
//	    case "normal": 
//	    	System.out.println("Usted es " + cliente + " y no tiene descuento.");
//	    	break;
//	    case "miembro": 
//	    	System.out.println("Usted es " + cliente + " y tiene 10% de descuento.");
//	    	break;
//	    case "vip": 
//	    	System.out.println("Usted es " + cliente + " y tiene 20% de descuento.");
//	    	break;
//	    default: 
//	    	System.out.println("Usted no es un cliente valido.");
//	    	break;
//	    };
//	    tipoCliente.close();
	    
	    int clima = (int) (Math.random() * (4 - 1 + 1) + 1);
	    switch(clima) {
	    case 1: 
	    	System.out.println("Habra clima soleado.");
	    	break;
	    case 2: 
	    	System.out.println("Habra clima nublado.");
	    	break;
	    case 3: 
	    	System.out.println("Habra clima lluvioso.");
	    	break;
	    case 4: 
	    	System.out.println("Habra clima nevado.");
	    	break;
	    };
	    
	    
 }
}