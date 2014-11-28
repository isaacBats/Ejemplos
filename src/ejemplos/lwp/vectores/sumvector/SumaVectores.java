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

	int n, m, nec, i, k, dif;
	
	Scanner leer = new Scanner(System.in);
	
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
        if(n>m){
//            for(i=0;i<n;i++){
//                    c[i]=a[i];
//            }
//            int aux = 0;
//            dif = 0;
//            for (int d=0; d<m; d++){
//                aux = b[d];
//                //for(int e=0; e<a.length; e++){
//                    if(!a.equals(aux)){
//                        dif++;
//                //    }
//                }                
//            }
//            int c[] = new int[n+nec]; 
//            for (i=0; i<c.length; i++){
//                c[i] = a[i];
//            }
//            for (i = n; i<c.length;i++){
//                
//            }
//            
            Arrays.sort(a);
            int aux = 0;
            for (k=0; k<m; k++){
                aux = b[k];
                if(Arrays.equals(a, b)){
                    
                } else {
                }
            }
            
        }else{
            for(i=0;i<m;i++){
                    c[i]=b[i];
            }   
        }
	
//	nec=n-1;
//	
//	for(k=0;k<m;k++){
//		i=0;
//		while((i<n) && (b[k]!=a[i])){
//			i=i+1;
//			
//		}
//		if(i>n){
//			nec=nec+1;
//			c[nec]=b[k];
//		}
//	}
//	
//	//for(i=0;i<nec;i++){
//	for(i=0;i<c.length;i++){
//		System.out.println("Valor del vector C["+i+"]: "+c[i]);
//	}
//	
	}
}

