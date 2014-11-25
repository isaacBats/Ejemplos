/**
 * @author Isaac Batista
 * twitter @codeisaac
 *
 * Programa en java que gestiona la informacion de pabellones 
 * con ficheros.
 * Para laWebDelProgramador
 * 
 * Este codigo se realizo con NetBeans, pero tambien se puede ejecutar desde la consola 
 * compilandolo con el comando javac Pabellon.java
 * y ejecutandolo con java Pabellon.
 * 
 * El codigo se realizo en una sola hoja para que no se confundan con los archivos de las
 * clases en caso de que ballan empezando a programar.
 * 
 * Para los que ya tienen un poco de tiempo como ejercicio pueden separar las clases 
 * y compilarlo por separado.
 */

package ejemplos.lwp.archivosIO;


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Integer.parseInt;


import java.text.DateFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class UnPabellon{

	private int codigoP;
	private String descripcionP;
	private int aforoP;
	private String fechaIniP;

	//Constructor por default
	public UnPabellon(){

	} 

	//Segundo constructor
	public UnPabellon(int codigoP, String descripcionP, int aforoP, String fechaIniP){
		this.codigoP = codigoP;
		this.descripcionP = descripcionP;
		this.aforoP = aforoP;
		this.fechaIniP = fechaIniP;
	}

	//setters de la clase UnPabellon.
	public void setCodigoP(int codigoP)			{ this.codigoP = codigoP; }
	public void setDescripcionP(String descripcionP) 	{ this.descripcionP = descripcionP; }
	public void setAforoP(int aforoP) 			{ this.aforoP = aforoP; }
	public void setFechaIniP(String fechaIniP) 		{ this.fechaIniP = fechaIniP; }

	//getters de la clase UnPabellon.
	public int getCodigoP() 				{ return codigoP; }
	public String getDescripcionP() 			{ return descripcionP; }
	public int getAforoP() 					{ return aforoP; }
	public String getFechaIniP() 				{ return fechaIniP; }

	//Sobrecargamos el metodo toString para que nos muestre los datos de la clase UnPabellon
	@Override
	public String toString(){

		StringBuilder sb = new StringBuilder();

		sb.append("\n Código del Pabellón: ");
		sb.append(codigoP);
		sb.append("\n Descripción del Pabellón: ");
		sb.append(descripcionP);
		sb.append("\n Aforo del Pabellón: ");
		sb.append(aforoP);
		sb.append("\n Fecha de construcción del Pabellón: ");
		sb.append(fechaIniP);

		return sb.toString();
	}
}

class Ventana extends Frame{
    
    //private Frame frame;
    private JPanel panel;
    
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    
    private final static int ANCHO = 300;
    private final static int ALTO = 200;
    
    private UnPabellon aux;
    
    private File file;
    
    
    public Ventana (){
        inicializa();
        
    }
    
    private Ventana inicializa(){
        //frame = new Frame("MENÚ");
        setTitle("MENÚ");
        panel = new JPanel();
        
        boton1 = new JButton("Introducir Pabellón");
        boton2 = new JButton("Ver datos de Pabellón");
        boton3 = new JButton("Ver Pabellón de mayor aforo");
        boton4 = new JButton("Ver Pabellones construidos según fecha");
        boton5 = new JButton("Salir");
        
        //Introduce Pabellon
        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev){
                List<UnPabellon> newPabellon;
                
                newPabellon = new ArrayList<>();
                newPabellon.add(leerPabellon());
                guardaPabellon(newPabellon);
            }
        });
        
        //Accion para buscar un pabellon por codigo.
        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev){
                int buscaCodigoPabellon;
                aux = new UnPabellon();
                
                buscaCodigoPabellon = parseInt(JOptionPane.showInputDialog("Introduzca el código del "
                                                            + "pabellón a visualizar"));
                
                aux = mostrarPabellon(buscaCodigoPabellon);
                if(aux.getCodigoP() != 0){
                    JOptionPane.showMessageDialog(boton2, aux.toString());                
                }else{
                    JOptionPane.showMessageDialog(boton2, "El codigo no es valido o no se encuentra en la base de datos");                                    
                }
                //JOptionPane.showMessageDialog(boton2, mostrarPabellon());
                
            }
        });
        
        //Busca el pabellon con mayor aforo
        boton3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ev){
            aux = new UnPabellon();
            
            aux = mostrarPabellon();
            if(aux.getCodigoP() != 0){
                    JOptionPane.showMessageDialog(boton3, aux.toString());                
                }else{
                    JOptionPane.showMessageDialog(boton3, "No se encuentra en la base de datos");                                    
                }
        }
        });
        
        //Buscar entre rangos de fecha y mostrar codigo y aforo
        boton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String fechaIn, fechaFi;
                StringBuilder sb = new StringBuilder();
                
                fechaIn = JOptionPane.showInputDialog("Introduce fecha inicial");
                fechaFi = JOptionPane.showInputDialog("Introduce fecha final");
                List<UnPabellon> busqueda = buscarPabellones(fechaIn, fechaFi);
                  
                sb.append("Los datos entre ");
                sb.append(fechaIn);
                sb.append(" y ");
                sb.append(fechaFi);
                sb.append(" son:");
                sb.append("\nCodigo\t---\tAforo");
                for (UnPabellon unPabellon : busqueda) {
                    sb.append("\n");
                    sb.append("  ");
                    sb.append(unPabellon.getCodigoP());
                    sb.append("\t---\t");
                    sb.append(unPabellon.getAforoP());
                    //sb.append(" ");
                    //sb.append(unPabellon.getFechaIniP());
                }
                JOptionPane.showMessageDialog(boton4, sb);
            }
        });
        

        //Accion para cerrar la ventana con el boton de "Salir"
        boton5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        
        //Evento para cerrar la Ventana.
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        add(panel);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setSize(ANCHO, ALTO);
        setVisible(true);
        
        return this;
    }
    
    /**
     * Metodo para consultar los datos que se encuentra entre un rango de fechas
     * @param fecha1
     * @param fecha2
     * @return consulta
     */
    private List<UnPabellon> buscarPabellones(String fecha1, String fecha2){
        List<UnPabellon> consulta;
        String descripcion;
        String fecha;
        int codigo;
        int aforo;
        Scanner sc;
        
        file = new File("Pabellones.dat");
        consulta = new ArrayList<>();
        try{
            sc = new Scanner(file);
            while(sc.hasNext()){
                String linea = sc.nextLine();
                Scanner scLinea = new Scanner(linea);
                scLinea.useDelimiter("^*&|#");
                
                codigo = parseInt(scLinea.next());
                descripcion = scLinea.next();
                aforo = parseInt(scLinea.next());
                fecha = scLinea.next();
                
                if(consultaFecha(fecha1, fecha2, fecha)){
                    aux = new UnPabellon (codigo, descripcion, aforo, fecha);
                    consulta.add(aux);
                }
                
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error en la lectura del archivo: "+ ex);
        }
        
        return consulta;
    }
       
    /**
     * Metodo para verificar si una fecha se encuentra dentro del rango de fechas dada
     * popr el usuario
     * 
     * @param fechaInicio   String
     * @param fechaFin      String
     * @param fecha         String
     * @return dentro       Boolean
     */
    private boolean consultaFecha(String fechaInicio, String fechaFin, String fecha){
        boolean dentro = false;
           
        try {
            DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
            Date date1 = f.parse(fechaInicio);
            Date date2 = f.parse(fechaFin);
            Calendar cal1 = new GregorianCalendar();
            cal1.setTime(date1);
            Calendar cal2 = new GregorianCalendar();
            cal2.setTime(date2);
            Date date3 = f.parse(fecha);
            Calendar cal3 = new GregorianCalendar();
            cal3.setTime(date3);
            
            /*
                Te dejo de tarea el por que elegi el if de en medio, como pista tiene que 
                ver con los operadores logicos que utilice.
            */
            
            //if (cal3.compareTo(cal1) == 0 || cal3.after(cal1) && cal3.compareTo(cal2) == 0 || cal3.before(cal2)){
            if (cal3.compareTo(cal1) == 0 | cal3.after(cal1) && cal3.compareTo(cal2) == 0 | cal3.before(cal2)){
            //if ( cal3.after(cal1) && cal3.before(cal2)){
                dentro = true;
                return dentro;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error en el formato de Fecha "+ ex);
        }
        return dentro;
    }
    
    //metodo para insertar un nuevo pabellon.
    private UnPabellon leerPabellon(){
            String descripcion;
            String fecha;
            int codigo;
            int aforo;
            
            //UnPabellon aux;
            
            codigo      = parseInt(JOptionPane.showInputDialog("Código del Pabellón"));
            descripcion = JOptionPane.showInputDialog("Descripción del Pabellón");
            aforo       = parseInt(JOptionPane.showInputDialog("Aforo del Pabellón"));
            fecha       = JOptionPane.showInputDialog("Fecha de construcción del Pabellón");
            
            aux = new UnPabellon(codigo, descripcion, aforo, fecha);
            return aux;
    }
    
    //Metodo que guarda los datos insertados en el documento Pabellones.dat
    private void guardaPabellon(List<UnPabellon> pabellones){
        //File file; 
        FileWriter fw;
        
        file = new File("Pabellones.dat"); 
        try {
            fw = new FileWriter(file, true);
            
            for (UnPabellon unPabellon : pabellones) {
                fw.append(unPabellon.getCodigoP()+ "&" 
                         +unPabellon.getDescripcionP() + "&"
                         +unPabellon.getAforoP() + "&"
                         +unPabellon.getFechaIniP()+ "#\n");
            }
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error al crear ó escribir el archivo: " +  ex);
        }
        
    }
    
    /**
     * sobrecarga del metodo mostrarPabellon, sin argumentos muestra el pabellon
     * con mayor aforo
     * @return aux   : objeto de tipo un pabellon mayor aforo
     */
    private UnPabellon mostrarPabellon (){
        
        String descripcion;
        String fecha;
        int codigo;
        int aforo;
        Scanner sc;
        
        file = new File("Pabellones.dat");
        
        UnPabellon mayor = new UnPabellon();
        mayor.setAforoP(0);
        
        try{
            sc = new Scanner(file);
            while(sc.hasNext()){
                String linea = sc.nextLine();
                Scanner scLinea = new Scanner(linea);
                scLinea.useDelimiter("^*&|#");
                
                codigo = parseInt(scLinea.next());
                descripcion = scLinea.next();
                aforo = parseInt(scLinea.next());
                fecha = scLinea.next();
                
                if(aforo > mayor.getAforoP()){
                    mayor = aux = new UnPabellon (codigo, descripcion, aforo, fecha);
                }
                
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error en la lectura del archivo: "+ ex);
        }
        return aux;
    }
    
    /**
     * Metodo que retorna el pabellon buscado por codigo.
     * @param codigoP
     * @return aux 
     */
    private UnPabellon mostrarPabellon(int codigoP){
    //private int mostrarPabellon(){
        
        String descripcion;
        String fecha;
        int codigo;
        int aforo;
        Scanner sc;
        
        file = new File("Pabellones.dat");
        try {
            sc = new Scanner(file);
            while(sc.hasNext()){
                String linea = sc.nextLine();
                Scanner scLinea = new Scanner(linea);
                //scLinea.useDelimiter("\\s*&\\s*");
                scLinea.useDelimiter("^*&|#");
                
                codigo = parseInt(scLinea.next());
                descripcion = scLinea.next();
                aforo = parseInt(scLinea.next());
                fecha = scLinea.next();
                
                if(codigo == codigoP){
                    aux = new UnPabellon(codigo, descripcion, aforo, fecha);
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error en la lectura del archivo: "+ ex);
        }
        return aux;
    }

}

public class Pabellon{

        public static void main(String[] args) {
            
             new Ventana();

	}

}