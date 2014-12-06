/**
 * @author Isaac Daniel Batista
 * twitter @codeisaac
 *
 * Programa que pide dos array, los compara y une
 * los valores no duplicados en un tercer array.
 *
 * Codigo hecho para la web del programador en lenguaje JAVA orientado a objectos.
 *
 * @version 1.0
 *
 * Se permite la copia total o parcial del siguiente codigo siempre y cuando se le de credito 
 * al autor. 
 */
package ejemplos.lwp.vectores.fusionvector;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Isaac Daniel Batista <@CodeIsaac>
 * link: http://www.lawebdelprogramador.com/foros/Java/1472113-Problema_de_arreglos.html
 */
public class FusionVectores{
	private int[] a;
	private int[] b;
	private int[] c;
	private int tamA = 0;
	private int tamB = 0;

	private Scanner leer = new Scanner(System.in);

	//Constructor de FusionVectores
	public FusionVectores(){
		inicio();
		operacionesArray();
		mostrarC();
	}
	/**
	 * Metodo de inicion, pide el tamaño de los arrays y los manda a llenar. 
	 */
	private void inicio(){
		
		System.out.print("Tamaño de A: ");
		tamA = leer.nextInt();
		a = new int[tamA];
		llenarArray(a, "A");
		
		System.out.print("Tamaño de B: ");
		tamB = leer.nextInt();
		b = new int[tamB];
		llenarArray(b, "B");
	}

	/**
	 * Metodo para llenar arrays
	 * @param int[] array    	Que es el array a llenar
	 * @param String ident		Identificador de array
	 */
	private void llenarArray(int[] array, String ident){
		
		for (int i=0; i < array.length; i++) {
			System.out.print("Valor de "+ident+"["+i+"]: ");
			array[i] = leer.nextInt();
		}
	}

	/**
	 * Con este metodo se realizan las siguientes aperaciones:
	 *			> compara tamaños
	 *			> verifica si hay duplicados entre arrays
	 *			> ordena arrays
	 *			> inserta en un tercer array los valores que no son duplicados entre arrays
	 */
	private void operacionesArray(){

		int aux = 0;
		int dif = 0;

		Arrays.sort(a);
		Arrays.sort(b);

		if (a.length == b.length) {
			System.out.println("Los dos array tienen "+ a.length + " elementos.");
			if(Arrays.equals(a, b)){
				System.out.println("\nEl contenido de el array A y el array B es el mismo. \n");
				c = new int[a.length];
				c = Arrays.copyOf(a, a.length);
			}else{
				aux = 0;
				dif = 0;

				System.out.println("\nEl contenido de A es diferente de B..."+
					               "\n\nVialidando si hay duplicados.");
				for (int d = 0; d < b.length; d++){
					aux = b[d];
					if(!duplicado(aux, a)){
						dif++;
					}
	 			}

	 			System.out.println("\nHay "+ (b.length - dif) + " duplicado(s).");
			   
			    c = new int [dif + a.length];
                System.arraycopy(a, 0, c, 0, a.length);
                 
                aux=0;
                int g = 0;
                for(int i = 0; i < b.length; i++){
                	aux = b[i];
                    if(!duplicado(aux, a)){
                    	c[a.length+g] = aux;
                        g++;
                    }
                }
			}
		}else if(a.length > b.length){
			aux = 0;
			dif = 0;

			System.out.println("\nEl array de A es mayor al array B..."+
				               "\n\nVialidando si hay duplicados.");
			for (int d = 0; d < b.length; d++){
				aux = b[d];
				if(!duplicado(aux, a)){
					dif++;
				}
	 		}

 			System.out.println("\nHay "+ (b.length - dif) + " duplicado(s).");
			   
		    c = new int [dif + a.length];
            System.arraycopy(a, 0, c, 0, a.length);
                 
            aux=0;
            int g = 0;
            for(int i = 0; i < b.length; i++){
	           	aux = b[i];
    	        if(!duplicado(aux, a)){
        	       	c[a.length+g] = aux;
            	    g++;
            	}
            }
		}else{

			aux = 0;
			dif = 0;

			System.out.println("\nEl array de B es mayor al array A..."+
				               "\n\nVialidando si hay duplicados.");
			for (int d = 0; d < a.length; d++){
				aux = a[d];
				if(!duplicado(aux, b)){
					dif++;
				}
	 		}

 			System.out.println("\nHay "+ (a.length - dif) + " duplicado(s).");
			   
		    c = new int [dif + b.length];
            System.arraycopy(b, 0, c, 0, b.length);
                 
            aux=0;
            int g = 0;
            for(int i = 0; i < a.length; i++){
	           	aux = a[i];
    	        if(!duplicado(aux, b)){
        	       	c[b.length+g] = aux;
            	    g++;
            	}
            }

		}
	}

	/**
	 * Metodo para buscar duplicados en un array
	 */
	private static boolean duplicado(int a, int array[]){
			int index;

	        index=Arrays.binarySearch(array, a);
			if(index < 0){
		            //Si NO se encuentra
		            return false;
			}else if (index >= 0){
		        return true;
			}
		        return false;
		}

	/**
	 * Con este metodo se muestran los valores finales de el Array C
	 */
	private void mostrarC(){
		System.out.println("\nEl array C tiene " + c.length + " elementos." +
							"\n \n Sus valores son: ");
		Arrays.sort(c);

		StringBuilder resultado;
		resultado = new StringBuilder();

		resultado.append("\n C = { ");
		for (int i=0; i < c.length; i++) {
			resultado.append(c[i]);
			resultado.append(", ");
		}
		resultado.append("}\n");

		System.out.println(resultado);
	}
	
	/**
	 * Metodo Main()
	 */
	public static void main(String[] args) {
		new FusionVectores();
	}


}