



package tablapocisiones;

import java.util.Scanner;
public class Ingreso {
        static int [] Pos = new int [12];
        static int [][] tabla = new int [12][8];
        static String [] Nombre = new String [12];
        static int juegos = 0;
        static int puntos = 1;
        static int ganad = 2;
        static int empates = 3;
        static int jperdidos = 4;
        static int goles_favor = 5;
        static int goles_contra = 6;
        static int dif_goles = 7;
        static String golC;
        static String golF;
        static int jueg = 1;
  
  
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
 
        
        //private string[] nombre_Equipo
    
    public static void Ingresar() {
        
        for (int i = 0; i < 12; i++) {
                Scanner leer= new Scanner(System.in);

                tabla[i][juegos] = jueg;

                System.out.println("Como quedo "+ Nombre[i]+"?");
                System.out.println("1.Ganó");
                System.out.println("2.Empató");
                System.out.println("3.Perdió");
                int fut = leer.nextInt();
                switch(fut){
                    case 1:
                        tabla[i][puntos]= tabla[i][puntos]+3;
                        tabla[i][ganad]= tabla[i][ganad]+1;
                    break;
                    case 2:
                        tabla[i][puntos]= tabla[i][puntos]+1;
                        tabla[i][empates]= tabla[i][empates]+1;
                    break;
                    case 3:
                        tabla[i][jperdidos]= tabla[i][jperdidos]+1;
                    break;
                }

                System.out.println("Goles a favor del club: ");
                tabla[i][goles_favor] = leer.nextInt();
                
                System.out.println("Goles en contra del club: ");
                tabla[i][goles_contra] = leer.nextInt();
                
                tabla[i][dif_goles] =  tabla[i][goles_favor] - tabla[i][goles_contra];
            }  
            jueg = jueg +1;
            ordenar();
            MensajeOPC();
    }
    public static void MensajeOPC() {
        Scanner leer= new Scanner(System.in);
        System.out.println("\n"+ANSI_GREEN_BACKGROUND+"Desea regresar al menu de opciones?");
        System.out.println("1= Si \t 2= No\n");
        int palabraClave = leer.nextInt();

        switch (palabraClave)
        {
            case 1:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Menu();
            break;
            case 2:
            System.exit(0);
            break;
        }
    }
     public static void Menu() {
      
        Scanner leer= new Scanner(System.in);
        System.out.println("\t" +ANSI_CYAN_BACKGROUND + "--Bienvenido al registro de futbol--");
        System.out.println("\t1. Ver datos");
        System.out.println("\t2. Ingresar nombres de los equipos");
        System.out.println("\t3. Agregar una nueva Jornada");
        System.out.println("\t4. Cerrar");
        System.out.println("\t5. Crear y leer .Json");
        System.out.println("\t" +ANSI_CYAN_BACKGROUND + "Elije una opcion: ");
        int opcionUser = leer.nextInt();

        switch (opcionUser)
        {
            case 1:
            System.out.println(ANSI_GREEN_BACKGROUND + "Has elegido la opción 1");
            
            mostrar_Matriz();
            break;

            case 2:
            System.out.println(ANSI_GREEN_BACKGROUND + "Acá ingresaras los nombres de los clubs de futbol");     
            nom();                   
            break;

            case 3:
            System.out.println(ANSI_GREEN_BACKGROUND + "Se Gregara una nueva jornada");

            Ingresar(); 
            break;
            
            case 4:
            System.out.println(ANSI_GREEN_BACKGROUND + "Cerrando el programa...");
            System.exit(0);
            break;
            
            case 5:
            System.out.println(ANSI_GREEN_BACKGROUND + "Se creara y leera el .json");
            json();
            break;
            
            default:
            System.out.println("Elige una opcion valida porfavor");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            break;
            }

     }
      public static void mostrar_Matriz() {
            System.out.println(ANSI_YELLOW_BACKGROUND+"Posición       Nombre                   J       Pts     G       E       P       GF      GC      DG");
            for (int i = 0; i< 12;i++) {//tabla.Length por 12
                  System.out.printf("\n %-14s",i+1);
                  System.out.print( Nombre[i]+ "\t\t\t");
                  for (int j = 0; j< 8;j++){
                      
                    System.out.print(tabla [i][j] + "       ");
                }
            }
            MensajeOPC();
        } 
    public static void ordenar() {
      for (int i = 0; i < 12;i++) {
          for (int j = 0; j < 12 - i -1;j++) {
              //intercambia filas de la matriz
              if(tabla[j][1] < tabla[j+1][1]){
              int [] filaTemp = tabla [j];
              tabla [j] = tabla [j+1];
              tabla [j+1] = filaTemp;
              //intercambia los nombres
              String nombreTemp = Nombre[j];
              Nombre [j] = Nombre [j+1];
              Nombre [j+1] = nombreTemp;
              
              }else if(tabla[j][1] == tabla[j+1][1]){
               if(tabla[j][7] < tabla[j+1][7]){
                   
              int [] filaTemp = tabla [j];
              tabla [j] = tabla [j+1];
              tabla [j+1] = filaTemp;
              //intercambia los nombres
              String nombreTemp = Nombre[j];
              Nombre [j] = Nombre [j+1];
              Nombre [j+1] = nombreTemp;
                   
               }
              }
                  
          }
      }
      
    }
    public static void nom() {
        for (int i = 0; i < 12; i++) {
                Scanner leer= new Scanner(System.in);
      System.out.println("Ingrese nombre del club " + ": ");
                Nombre[i] = leer.nextLine();
        }
        MensajeOPC();
      }
    public static void json() {
        
    }
   
}

        

