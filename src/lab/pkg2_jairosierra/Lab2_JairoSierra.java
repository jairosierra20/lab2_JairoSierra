/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg2_jairosierra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jairo Sierra
 */
public class Lab2_JairoSierra {

    static Scanner leer = new Scanner(System.in);
    static ArrayList<Casas> lista = new ArrayList<Casas>();
    static String[] login = {"leobanegas", "99"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        boolean bandera = false;
        while (opcion != 4) {
            System.out.println("Usuario para login: " + login[0]);
            System.out.println("Contraseña para login: " + login[1]);
            System.out.println("Menu\n"
                    + "Opcion 1: Registro de Casas\n"
                    + "Opcion 2: Manejo de Estados\n"
                    + "Opcion 3: Log in\n"
                    + "Opcion 4: Salir\n"
                    + "Ingrese su opcion: ");
            opcion = leer.nextInt();
            while (opcion <= 0 || opcion >= 5) {
                System.out.println("Menu\n"
                        + "Opcion 1: Registro de Casas\n"
                        + "Opcion 2: Manejo de Estados\n"
                        + "Opcion 3: Log in\n"
                        + "Opcion 4: Salir\n"
                        + "Ingrese su opcion: ");
                opcion = leer.nextInt();
            }//fin del while de validacion de opcion
            if (opcion == 3) {//Login
                System.out.println("Ingrese su usuario: ");
                String usuario = leer.next();
                System.out.println("Ingrese la contraseña: ");
                String contra = leer.next();
                bandera = Login(usuario, contra);
                if (bandera) {
                    System.out.println("Bienvenido!!!");
                } else {
                    System.out.println("Usuario o Contraseña Incorrectos");
                }
            }
            if (bandera) {//Permite usar las otras opciones luego de hacer el login
                if (opcion == 1) {
                    Registro();
                }
                if (opcion == 2) {
                    ManejoEstados();
                }
            } else {
                System.out.println("Debe iniciar su sesion.");
            }
        }//fin del while de la opcion

    }//fin del main

    public static boolean Login(String usu, String contra) {//valida el login
        if (usu.equals(login[0]) && contra.equals(login[1])) {
            return true;
        } else {
            return false;
        }
    }//fin del login

    public static void Registro() {
        int opcion = 0;
        System.out.println("Menu\n"
                + "Opcion 1: Crear Casas\n"
                + "Opcion 2: Leer Casas\n"
                + "Opcion 3: Modificar Casas\n"
                + "Opcion 4: Borrar Casas\n"
                + "Ingrese una opcion: ");
        opcion = leer.nextInt();
        while (opcion <= 0 || opcion >= 5) {//validacion
            System.out.println("Menu\n"
                    + "Opcion 1: Crear Casas\n"
                    + "Opcion 2: Leer Casas\n"
                    + "Opcion 3: Modificar Casas\n"
                    + "Opcion 4: Borrar Casas\n"
                    + "Ingrese una opcion correcta: ");
            opcion = leer.nextInt();
        }//fin del while de la validacion del menu
        switch (opcion) {
            case 1://Crear Casas
                String nombre = "";
                String estado = "";
                System.out.println("Ingrese numero de casa: ");
                int casa = leer.nextInt();
                System.out.println("Ingrese numero de bloque: ");
                int bloque = leer.nextInt();
                System.out.println("Ingrese el color");
                String color = leer.next();
                System.out.println("Ingrese el ancho: ");
                double ancho = leer.nextDouble();
                System.out.println("Ingrese el largo: ");
                double largo = leer.nextDouble();
                System.out.println("Ingrese\n1)Ya fue comprada\n2)No fue comprada");
                int compra = leer.nextInt();
                while (compra < 1 || compra > 2) {
                    System.out.println("Opcion incorrecta");
                    System.out.println("Ingrese\n1)Ya fue comprada\n2)No fue comprada");
                    compra = leer.nextInt();
                }//fin del while de compra
                if (compra == 1) {
                    System.out.println("Ingrese el nombre del comprador: ");
                    leer.nextLine();
                    nombre = leer.nextLine();
                }
                System.out.println("Ingrese numero de pisos: ");
                int pisos = leer.nextInt();
                System.out.println("Ingrese numero de cuartos: ");
                int cuartos = leer.nextInt();
                System.out.println("Ingrese numero de baños: ");
                int banos = leer.nextInt();
                System.out.println("Ingrese nombre del ingeniero a cargo: ");
                leer.nextLine();
                String ingeniero = leer.nextLine();
                System.out.println("Menu de estados");
                System.out.println("1) Lista");
                System.out.println("2) Construccion");
                System.out.println("3) Espera Construccion");
                System.out.println("4) Espera Demolicion");
                System.out.println("Ingrese el estado: ");
                int estado1 = leer.nextInt();
                while (estado1 < 1 || estado1 > 4) {
                    System.out.println("Menu de estados");
                    System.out.println("1) Lista");
                    System.out.println("2) Construccion");
                    System.out.println("3) Espera Construccion");
                    System.out.println("4) Espera Demolicion");
                    System.out.println("Ingrese el estado: ");
                    estado1 = leer.nextInt();
                }
                if (estado1 == 1) {
                    estado = "Lista";
                }
                if (estado1 == 2) {
                    estado = "Construccion";
                }
                if (estado1 == 3) {
                    estado = "Espera Construccion";
                }
                if (estado1 == 4) {
                    estado = "Espera Demolicion";
                }
                lista.add(new Casas(estado, nombre, color, banos, cuartos, casa, compra, pisos, ancho, largo, bloque, ingeniero));
                break;
            case 2://Listar
                String salida = "";
                for (Object temp : lista) {
                    if (temp instanceof Casas) {
                        salida += lista.indexOf(temp) + "- " + temp + "\n";
                    }
                }
                System.out.println(salida);
                break;
            case 3://Modificar
                System.out.println("Ingrese la posicion en la lista de casas: ");
                int posicion = leer.nextInt();
                while (posicion < 0 || posicion >= lista.size()) {
                    System.out.println("Ingrese la posicion en la lista de casas: ");
                    posicion = leer.nextInt();
                }//fin del while de validacion de la posicion
                System.out.println("Elementos\n"
                        + "1- Numero de casas\n"
                        + "2- Numero de bloque\n"
                        + "3- Color\n"
                        + "4- Ancho\n"
                        + "5- Largo\n"
                        + "6- Comprada o aun no\n"
                        + "7- Numero de pisos\n"
                        + "8- Numero de baños\n"
                        + "9- Numero de cuartos\n"
                        + "10- Nombre del igeniero a cargo\n"
                        + "Que elemento desea cambiar?");
                int elemento = leer.nextInt();
                while (elemento <= 0 || elemento > 10) {
                    System.out.println("Elementos\n"
                            + "1- Numero de casas\n"
                            + "2- Numero de bloque\n"
                            + "3- Color\n"
                            + "4- Ancho\n"
                            + "5- Largo\n"
                            + "6- Comprada o aun no\n"
                            + "7- Numero de pisos\n"
                            + "8- Numero de baños\n"
                            + "9- Numero de cuartos\n"
                            + "10- Nombre del igeniero a cargo\n"
                            + "Que elemento desea cambiar?");
                    elemento = leer.nextInt();
                }//fin del while de validacion del elemento a modificar
                String nombre2 = "";
                switch (elemento) {
                    case 1:
                        System.out.println("Ingrese numero de casa: ");
                        int casa1 = leer.nextInt();
                        ((Casas) lista.get(posicion)).setcasa(casa1);
                        break;
                    case 2:
                        System.out.println("Ingrese numero de bloque: ");
                        int bloque1 = leer.nextInt();
                        ((Casas) lista.get(posicion)).setbloque(bloque1);
                        break;
                    case 3:
                        System.out.println("Ingrese el color");
                        String color1 = leer.next();
                        ((Casas) lista.get(posicion)).setcolor(color1);
                        break;
                    case 4:
                        System.out.println("Ingrese el ancho: ");
                        double ancho1 = leer.nextDouble();
                        ((Casas) lista.get(posicion)).setancho(ancho1);
                        break;
                    case 5:
                        System.out.println("Ingrese el largo: ");
                        double largo1 = leer.nextDouble();
                        ((Casas) lista.get(posicion)).setlargo(largo1);
                        break;
                    case 6:
                        System.out.println("Ingrese\n1)Ya fue comprada\n2)No fue comprada");
                        int compra1 = leer.nextInt();
                        ((Casas) lista.get(posicion)).setcompra(compra1);
                        while (compra1 < 1 || compra1 > 2) {
                            System.out.println("Opcion incorrecta");
                            System.out.println("Ingrese\n1)Ya fue comprada\n2)No fue comprada");
                            compra = leer.nextInt();
                        }//fin del while de compra
                        if (compra1 == 1) {
                            System.out.println("Ingrese el nombre del comprador: ");
                            leer.nextLine();
                            nombre2 = leer.nextLine();
                            ((Casas) lista.get(posicion)).setnombre(nombre2);
                        }
                        break;
                    case 7:
                        System.out.println("Ingrese numero de pisos: ");
                        int pisos1 = leer.nextInt();
                        ((Casas) lista.get(posicion)).setpisos(pisos1);
                        break;
                    case 8:
                        System.out.println("Ingrese numero de baños: ");
                        int banos1 = leer.nextInt();
                        ((Casas) lista.get(posicion)).setbanos(banos1);
                        break;
                    case 9:
                        System.out.println("Ingrese numero de cuartos: ");
                        int cuartos1 = leer.nextInt();
                        ((Casas) lista.get(posicion)).setcuartos(cuartos1);
                        break;
                    case 10:
                        System.out.println("Ingrese nombre del ingeniero a cargo: ");
                        leer.nextLine();
                        String ingeniero1 = leer.nextLine();
                        ((Casas) lista.get(posicion)).setingeniero(ingeniero1);
                        break;
                }//fin del switch del elemento
                break;
            case 4://Elimina las casas
                System.out.println("Ingrese la posicion en la lista de casas: ");
                int posicionel = leer.nextInt();
                while (posicionel < 0 || posicionel >= lista.size()) {
                    System.out.println("Ingrese la posicion en la lista de casas: ");
                    posicionel = leer.nextInt();
                }
                lista.remove(posicionel);
                System.out.println("Se elimino con exito.");
                break;
        }//fin del swith
    }//fin del registro

    public static void ManejoEstados() {
        int contesp = 0, contlisto = 0;//contadores para la cantidad de casas en los estados
        String Listas = "", Construccion = "", ConstruccionEspera = "", EsperaDemolicion = "";
        for (Object temp : lista) {//guarda en strings las listas
            if (temp instanceof Casas) {
                if (((Casas) temp).getEstado().equals("Lista")) {
                    Listas += lista.indexOf(temp) + "- " + temp + "\n";
                }
                if (((Casas) temp).getEstado().equals("Construccion")) {
                    contesp++;
                    Construccion += lista.indexOf(temp) + "- " + temp + "\n";
                }
                if (((Casas) temp).getEstado().equals("Espera Construccion")) {
                    ConstruccionEspera += lista.indexOf(temp) + "- " + temp + "\n";
                }
                if (((Casas) temp).getEstado().equals("Espera Demolicion")) {
                    EsperaDemolicion += lista.indexOf(temp) + "- " + temp + "\n";
                    contlisto++;
                }
            }
        }//fin del for
        System.out.println("Las casas listas son: \n" + Listas);
        System.out.println("Las casas en construccion son: \n" + Construccion);
        System.out.println("Las casas en construccion en espera son: \n" + ConstruccionEspera);
        System.out.println("Las casas en espera de demolicion son: \n" + EsperaDemolicion);
        System.out.println("Ingrese la posicion en la lista de casas para cambiar su estado: ");
        int posicion = leer.nextInt();//se pide la posicion en el arraylist
        while (posicion < 0 || posicion >= lista.size()) {
            System.out.println("Ingrese la posicion en la lista de casas para cambiar su estado: ");
            posicion = leer.nextInt();
        }//fin del while de validacion de posicion
        if (((Casas) lista.get(posicion)).getEstado().equals("Lista")) {
            System.out.println("Cambios de estado posibles:\n"
                    + "1- Espera Demolicion\n"
                    + "Ingrese su opcion: ");
            int opc = leer.nextInt();
            while (opc != 1) {
                System.out.println("Cambios de estado posibles:\n"
                        + "1- Espera Demolicion\n"
                        + "Ingrese su opcion: ");
                opc = leer.nextInt();
            }
            if (opc == 1) {
                ((Casas) lista.get(posicion)).setEstado("Espera Demolicion");
            }
        } else {
            if (((Casas) lista.get(posicion)).getEstado().equals("Construccion") && contesp <= 5) {
                System.out.println("Cambios de estado posibles:\n"
                        + "1- Lista\n"
                        + "2- Espera Construccion\n"
                        + "Ingrese su opcion: ");
                int opc = leer.nextInt();
                while (opc != 1 && opc != 2) {
                    System.out.println("Cambios de estado posibles:\n"
                            + "1- Lista\n"
                            + "2- Espera Construccion\n"
                            + "Ingrese su opcion: ");
                    opc = leer.nextInt();
                }
                if (opc == 1) {
                    ((Casas) lista.get(posicion)).setEstado("Lista");
                }
                if (opc == 2) {
                    ((Casas) lista.get(posicion)).setEstado("Espera Construccion");
                }
            } else {
                if (((Casas) lista.get(posicion)).getEstado().equals("Espera Construccion")) {
                    System.out.println("Cambios de estado posibles:\n"
                            + "1- Construccion\n"
                            + "Ingrese su opcion: ");
                    int opc = leer.nextInt();
                    while (opc != 1) {
                        System.out.println("Cambios de estado posibles:\n"
                                + "1- Construccion\n"
                                + "Ingrese su opcion: ");
                        opc = leer.nextInt();
                    }
                    if (opc == 1) {
                        ((Casas) lista.get(posicion)).setEstado("Construccion");
                    }
                } else {
                    if (((Casas) lista.get(posicion)).getEstado().equals("Espera Demolicion") && contesp <= 5 && contlisto <= 3) {
                        System.out.println("Cambios de estado posibles:\n"
                                + "1- Demoler\n"
                                + "Ingrese su opcion: ");
                        int opc = leer.nextInt();
                        while (opc != 1) {
                            System.out.println("Cambios de estado posibles:\n"
                                    + "1- Demoler\n"
                                    + "Ingrese su opcion: ");
                            opc = leer.nextInt();
                        }
                        if (opc == 1) {
                            lista.remove(posicion);
                            System.out.println("Se elimino con exito.");
                        }
                    }
                }
            }
        }
    }//fin del manejo de estados
}//fin de la clase
