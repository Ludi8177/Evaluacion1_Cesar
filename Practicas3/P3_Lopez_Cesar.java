package Practicas3;


import java.util.Scanner;

public class P3_Lopez_Cesar {

	public static void main(String[] args) {
				
		
		Scanner sc = new Scanner(System.in);
		
	
	
		do {
		//Crear variables
	    String[] nombres;
        double[] alturas;
        double[] masas;
do {//Datos predeterminados
        System.out.println("Desea ingresar datos predeterminados? SI/NO");
        String respuesta = sc.nextLine();
       
        
        if (respuesta.equalsIgnoreCase("SI")){
        	nombres = new String[] {"Juan","Luis","Jorge"};
        	alturas = new double[] {1.78,1.89,1.60};
        	masas = new double[] {88,76,65};
        	
   break;
        }
        else if (respuesta.equalsIgnoreCase("NO")){
        //Datos colocados por el usuario	 
	        System.out.print("Introduzca la cantidad de personas: ");
	        int cantidadPersonas = sc.nextInt();
	        nombres = new String[cantidadPersonas];
	        alturas = new double[cantidadPersonas];
	        masas = new double[cantidadPersonas];
	        

	        // Ingresar los datos de las personas
	        asignarindividuos(nombres, alturas, masas, sc );
	     
	        break;
        } else {
        	System.out.println("Ingrese nuevamente su respuesta");
        }  } while(true);


        // Calcular e imprimir el IMC y la dieta recomendada  
        calcularimcymostrardietas(nombres, alturas, masas);
        // Clasificar a las personas a traves de su IMC
        contadordelimcdeusuarios(alturas,masas);
        // Calcular la altura mas baja
        alturamasbaja(alturas,nombres);
        // Calcular el paciente mas bajo
        pacientepesado(masas,nombres);
        // Calcular el IMC más alto y bajo
        mostrarelimcmasbajoyalto(nombres, alturas, masas);
        // Calcular la media y mediana de las altura y peso
        mediaymediana(nombres, alturas, masas);
    
	
	System.out.println("Desea continuar el programa?");
	String respuesta= sc.nextLine();
	if(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("Yes")) {
		
	}
	else if (respuesta.equalsIgnoreCase("no")) {
		break;
	}
	else { System.out.println("Ingrese la respuesta nuevamente");
	}
	
	} while(true); sc.close(); }
		
	
		
		private static void asignarindividuos(String[] nombres, double[] alturas, double[] masas, Scanner sc) {
		sc.nextLine();
		for (int i=0; i<nombres.length;i++) {
			System.out.println("Nombre del usuario " + (i+1) + ":");
			nombres[i]=sc.nextLine();
			System.out.println("La altura de " +  nombres[i]  +" es: ");
			alturas[i]=sc.nextDouble();
			System.out.println("El peso de " + nombres[i]   + " es: ");
			masas[i]=sc.nextDouble();
			sc.nextLine();
		}
	}
		private static void contadordelimcdeusuarios(double[] alturas, double[] masas) { 
			int obeso= 0;
			int sobrepeso= 0;
			int pesonormal= 0;
			int bajopeso= 0;
			for(int i=0; i < alturas.length; i++) {
				double imc = calcularIMC(alturas[i], masas[i]);
				if (imc >= 40) { obeso++;}
				else if (imc>= 25&& imc <40) {sobrepeso++;}
				else if (imc>= 18.5&& imc <25) {pesonormal++;}
				else { bajopeso++;}
			}
				System.out.println("Personas obesas: " + obeso);
			System.out.println("Personas con sobrepeso: " + sobrepeso);
			System.out.println("Personas con peso normal: " + pesonormal);
			System.out.println("Personas con bajo peso: " + bajopeso);
			
			
			
		}
		private static void calcularimcymostrardietas(String[] nombres, double[] alturas, double[] masas) {
			for(int i=0; i<nombres.length;i++) {
				double imc= calcularIMC(alturas[i], masas[i]);
				String metodo1 = condicion(imc);
				System.out.println("El IMC de " + nombres[i] + " es : " + imc);
				System.out.println("Dieta que debe de cumplir " + nombres[i] + " :" + metodo1);
				
				
				
			}
		}
		private static String condicion(double imc) {
			if (imc >= 40) {
		return "1500kcal (obesidad)";}
			else if (imc>= 25&& imc <40) {
				return "2000kcal (sobrepeso)";}
			else if (imc>= 18.5&& imc <25) {
			return "2500 kcal (peso normal)";}
			else { return "3000 kcal (bajo peso)";}
			
			
	}
		public static double calcularIMC(double alturas, double masas) {
			return masas/ (alturas*alturas);
				}
		private static void alturamasbaja(double[] alturas, String[] nombres) {
			double alturamasbaja = alturas[0];
			String usuariomasbajo = nombres[0];
			for(int i=1; i<alturas.length;i++) {
				if (alturas[i]<alturamasbaja) {
                      alturamasbaja=alturas[i];
                      usuariomasbajo=nombres[i];
                      
			                }
	          }
			System.out.println("El usuario mas bajo "+ usuariomasbajo + " tiene una altura de: "+ alturamasbaja);
        }
		private static void pacientepesado(double[] masas, String[] nombres) {
				double masamaspesada = masas[0];
				String usuariomaspesado = nombres[0];
				for(int i = 1; i<masas.length;i++) {
					if(masas[i]>masamaspesada) {
						masamaspesada=masas[i];
						usuariomaspesado=nombres[i];
					}
				}
				System.out.println("El usuario mas pesado " + usuariomaspesado + " tiene una masa de: " + masamaspesada);
				}
		
		private static void mostrarelimcmasbajoyalto(String[] nombres, double[] alturas, double[] masas) { 
			
			double imcmasbajo= calcularIMC (alturas[0],masas[0]);
			double imcmasalto= calcularIMC (alturas[0],masas[0]);
			String usuarioimcalto= nombres[0];
			String usuarioimcbajo= nombres[0];
			for(int i= 1; i<nombres.length; i++) {
				double imc = calcularIMC (alturas[i],masas[i]);
		     if(imc<imcmasbajo) {
			imcmasbajo=imc;
			usuarioimcbajo=nombres[i];
		     }
		     if(imc>imcmasalto) {
		    imcmasalto=imc;
		    usuarioimcalto=nombres[i];
		    	 
		     }
		     }
		     
			System.out.println("El usuario con el IMC más bajo " + usuarioimcbajo + " cuenta con: " + imcmasbajo);
		    System.out.println("El usuario con el IMC mas alto " + usuarioimcalto + " cuenta con: " + imcmasalto);
		}
		private static void mediaymediana(String[] nombres, double[] alturas, double[] masas) 
		
		{
				double sumaalturas= 0;
				double sumamasas= 0;
			for(double altura: alturas) {
				
				sumaalturas+=altura;
				
			}
			for(double masa: masas) {
				
				sumamasas+=masa;
			}
			double mediamasas= sumamasas / masas.length;
			double mediaalturas= sumaalturas / alturas.length;
			System.out.println("La media de las masas es: "+ mediamasas);
			System.out.println("La media de las alturas es: "+ mediaalturas);
				}
		
		
}
   



