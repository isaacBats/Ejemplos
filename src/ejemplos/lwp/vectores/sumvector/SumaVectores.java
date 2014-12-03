/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos.lwp.vectores.sumvector;

/**
 *
 * @author Isaac Daniel Batista <@CodeIsaac>
 * ejemplo sacado de la web del programador.
 * link: http://www.lawebdelprogramador.com/foros/Java/1472113-Problema_de_arreglos.html
 */
import java.util.Arrays;
import java.util.Scanner;

public class SumaVectores {

    public static void main(String[]args){

	int n, m, i, k, dif;
		Scanner leer = new Scanner(System.in);
		int[] c;
		

		System.out.print("Número de elementos del vector A: ");
		n=leer.nextInt();
		System.out.print("Número de elementos del vector B: ");
		m=leer.nextInt();
		
		int a[] = new int [n];
		for(i=0;i<n;i++){
			System.out.print("Elemento del vector A: ["+i+"]");
			a[i]=leer.nextInt();
		}
		

		int b[] = new int [m];
		for(k=0;k<m;k++){
			System.out.print("Elemento del vector B: ["+k+"]");
			b[k]=leer.nextInt();
		}
		
		//Con esto siempre vamos a copiar en C el vector mas grande.
		//if(n>m){
			int aux = 0;
			dif = 0;
			for (int d=0; d<m; d++){
				aux = b[d];
				if(!duplicado(aux, a)){
					dif++;
				}
	 		}
			System.out.println("El tamaño del array C sera "+ (dif+n));
			
			 c = new int [dif + n];
                         
                         System.arraycopy(a, 0, c, 0, a.length);
                         
                         aux=0;
                         int g = 0;
                         for(i = 0; i < b.length; i++){
                             aux = b[i];
                             if(!duplicado(aux, a)){
                                 c[a.length+g] = aux;
                                 g++;
                             }
                         }
                         
                         for (int j=0; j < c.length; j++) {
                             System.out.println("C["+j+"]: "+c[j]);
                         }
    }
    public static boolean duplicado(int a, int array[]){
	int index;

	Arrays.sort(array);
        index=Arrays.binarySearch(array, a);
	if(index < 0){
            //Si NO se encuentra
            return false;
	}else if (index >= 0){
            return true;
	}
        return false;
    }
}

