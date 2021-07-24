/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuderestaurant.ferianur;

import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Main {

    // DEFINO VARIABLE GLOBAL CON STATIC;  
    private static String[][] menu = {{"HAMBURGUESAS", "PIZZAS", "PASTAS", "GASEOSAS", "VOLVER AL MENU PRINCIPAL"},
    {"MC SIMPLE", "MC DOBLE", "MC TRIPLE", "VOLVER"},
    {"MC JAMON Y QUESO", "MC PEPERONI", "MC HAWAIANA", "VOLVER"},
    {"MC BOLONESA", "MC FETUCHINI", "MC RAVIOLES", "VOLVER"},
    {"COCACOLA", "FANTA", "SPRITE", "VOLVER"}
    };
    // DEFINO VARIABLE GLOBAL CON STATIC;  
    private static String[][] precios = {
        {"20", "27", "32"},
        {"27", "30", "33"},
        {"44", "40", "44"},
        {"10", "10", "10"}};

    private String[] opcionesVentanaPrincipal = {
        "Ver el Menu",
        "Ver Carrito de Pedidos",
        "Editar Pedido",
        "Finalizar Pedido",
        "Salir De Restaurant Online MC"};

    private void mostrarVentaPrincipal() {

        //AQUI HAGO UN FOR PARA RECORRER EL ARREGLO DE OPCIONESVENTANAPRINCIPAL;
        for (int Principal = 0; Principal < opcionesVentanaPrincipal.length; Principal++) {
            System.out.println("(" + (Principal + 1) + ")" + opcionesVentanaPrincipal[Principal]);
        }

    }

    private void setTitulos(int opcion) {
        switch (opcion) {
            case 0:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("               Bienvenidos al restaurant online ");
                System.out.println("                         MASTERCHEF");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("NAVEGUE POR EL MENU DIGITANO LOS VALORES NUMERICOS \nASIGNADOS A LA OPCION DE SU PREFERENCIA.");
                System.out.println("-------------------------------------------------------------------");
                break;
            case 1:
                System.out.println("----------------------------------------");
                System.out.println("           MENU MASTER CHEF");
                System.out.println("----------------------------------------");
                break;
            case 2:
                System.out.println("----------------------------------------------------------------------");
                System.out.println("                    CARRITO DE COMPRAS:");
                System.out.println("----------------------------------------------------------------------");
                break;
            case 3:
                System.out.println("----------------------------------------------------------------");
                System.out.println("                        EDITAR PEDIDO");
                System.out.println("----------------------------------------------------------------");
                break;
            case 4:
                System.out.println("---------------------------------------------------------");
                System.out.println("FINALIZANDO PEDIDO");
                System.out.println("---------------------------------------------------------");
                System.out.println("SU OREN ES :");
                break;
            case 5:
                System.out.println("---------------------------------------------------------");
                System.out.println("GRACIAS POR VISITAR MASTER CHEF ONLINE");
                System.out.println("---------------------------------------------------------");
            default:
                break;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //CREO UNA VARIABLE BOOLEANA PARA CONTROLAR CUANDO TERMINA EL PROGRAMA;
        boolean ingresar = true;
        //CREO UN INTEGER LLAMADO OPCIONES PARA CONTROLAR SI EL USUARIO VUELVE O NO AL MENU PRINCIPAL;
        int opciones = 0;
        /*Menu Carta;
        Carta = new Menu(Menu, Precios); */
        //INSTANCIO EL CONSTRUCTOR DE LA CLASE MENU;
        Menu carta = new Menu(menu, precios);
        //Menu Carta1 = new Menu(Menu, Precios);
        Main principal = new Main();

       

        while (ingresar) {

            try {

                if (opciones == 0) {
                    //LLAMO A LA FUNCION SETTITULOS DE LA CLASE MAIN;
                    principal.setTitulos(opciones);
                    //LLAMO A LA FUNCION MOSTRAR VENTANA PRINCIPAL DE LA CLASE MAIN;
                    principal.mostrarVentaPrincipal();
                    String aux = scan.nextLine();
                    opciones = Integer.parseInt(aux);
                }

                if (opciones == 1) {

                    Boolean semaforo = true;

                    while (semaforo) {
                        //LLAMO A LA FUNCION SETTITULOS DE LA CLASE MAIN;
                        principal.setTitulos(opciones);

                        //AQUI HAGO UN FOR PARA RECORRER LA MATRIZ MENU HASTA LA LONGITUD 
                        //DE LA FILA EN LA POSICION 0 DE LA MATRIZ QUE ES LA POSICION DE (HAMBURGUESAS PIZZAS PASTAS Y GASEOSAS);                       
                        for (int i = 0; i < menu[0].length; i++) {
                            System.out.println("(" + (i + 1) + ")" + menu[0][i]);
                        }
                        //AQUI LE PIDO AL USUARIO QUE NAVEGUE POR LOS MENUS (HAMBURGUESAS PIZZAS PASTAS Y GASEOSAS) SEGUN EL NUMERO
                        //ASOCIASO AL MISMO Y ASOCIO EL RESULTADO A LA VARIABLE --"NAVEGAR"--;
                        System.out.println("DIGITE EL NUMERO ASOCIADO AL MENU QUE DESEA VER");
                        String aux1 = scan.nextLine();
                        int navegar = Integer.parseInt(aux1);

                        if (navegar == 5) {
                            opciones = 0;
                            semaforo = false;
                        } else if (navegar < 0 || navegar > 5) {
                            System.out.println("----------------------------------------------");
                            System.out.println("Ingrese un numero asociado a una opcion valida");
                            System.out.println("----------------------------------------------");
                        } else {
                            carta.agregarCarrito(navegar);
                        }
                    }
                }

                if (opciones == 2) {
                    //RECORRO LA MATRIZ CARRITO DE TIPO STRING QUE ESTA VACIO , Y COMO SE
                    //QUE POR DEFECTO CUANDO ES STRING Y ESTA VACIO DIRA NULL , HAGO UN IF
                    //PARA QUE CUANDO ENCUENTRE LA PALABRA NULL EN LA FILA Y COLUMNA VISITADA 
                    //LA CAMBIE Y BORRE LA PALABRA NULL Y SOLO SE MUESTRE UN ESPACIO VACIO;
                    boolean back = true;
                    //CREO UN WHILE CON UNA BOLEANA INICIALIZADA EN TRUE PARA CONTROLAR QUE 
                    //EL USUARIO NO PUEDA SALIR DE ESTA SECCION AL MENOS QUE DIJITE EL NUMERO
                    //ASIGNADO PARA VOLVER A LA VENTANA PRINCIPAL;
                    while (back) {
                        //LLAMO A LA FUNCION SETTITULOS DE LA FUNCION MAIN;
                        principal.setTitulos(opciones);

                        carta.verCarritoDeCompras();

                        System.out.println("--------------------------------------");
                        System.out.println("DIGITE 1 PARA VOLVER AL MENU PRINCIPAL");
                        System.out.println("--------------------------------------");
                        System.out.println("______");
                        String aux2 = scan.nextLine();
                        int volver = Integer.parseInt(aux2);
                        if (volver == 1) {
                            back = false;
                            opciones = 0;
                        }
                    }
                }

                if (opciones == 3) {
                    //LLAMO A LA FUNCION SETTITULOS DE LA CLASE MAIN;
                    principal.setTitulos(opciones);

                    //LLAMO A LA FUNCION VERCARRITODECOMPRAS DE LA CLASE MENU;
                    carta.verCarritoDeCompras();
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("------------------------!!!!Atencion!!!!---------------------------");
                    System.out.println("1.-DIGITE EL [NUMERO] ASOCIADO A LA ORDEN PARA QUITAR DEL CARRITO");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("2.-DIGITE [0] PARA VOLVER AL MENU PRINCIPAL :");
                    String aux3 = scan.nextLine();
                    int quitar = Integer.parseInt(aux3);

                    //boolean back = true;
                    //while (back) {
                    if (quitar == 0) {
                        // back = false;
                        opciones = 0;
                    } else if (quitar <= carta.carrito2.length && quitar > 0) {
                        //
                        //LLAMO A LA FUNCION EDITAR CARITO DE LA CLASE MENU;
                        carta.quitaDeCarrito(quitar);
                        // back = false;
                    } else {
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Debe digitar el numero de una orden valida para cancelar");
                        System.out.println("--------------------------------------------------------");
                    }
                    //

                }

                if (opciones == 4) {
                    boolean fin = true;
                    while (fin) {
                        //LLAMO A LA FUNCION SETTITULOS DE LA DE LA CLASE MAIN;
                        principal.setTitulos(opciones);

                        //LLAMO A LA FUNCION PARA FINALIZAR PEDIDO;
                        carta.verCarritoDeCompras();
                        //LLAMO A LA FUNCION CALCULARTOTALAPAGAR;
                        //int Suma = 

                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("El total a cancelar es : " + carta.calcularTotalFactura() + "Bs");
                        System.out.println("-----------------------------------------------------------------");

                        System.out.println("Desea finalizar su orden?");
                        System.out.println("Digite[1] para si " + " Digite[2] para no");
                        String aux04 = scan.nextLine();
                        int finalizar = Integer.parseInt(aux04);
                        if (finalizar == 1) {
                            System.out.println("Digite su direccion para enviar el pedido");
                            String direccion = scan.nextLine();
                            System.out.println("==================================================================");
                            System.out.println("Gracias!! su orden ha sido procesada correctamente");
                            System.out.println("Su pedido sera enviado a " + direccion + " en no mas de 30 minutos");
                            System.out.println("==================================================================");
                            fin = false;
                            ingresar = false;
                        } else if (finalizar == 2) {
                            fin = false;
                            opciones = 0;
                        }

                    }

                }

                if (opciones == 5) {
                    //LLAMO A LA FUNCION SETTITULOS DE LA CALSE MAIN;
                    principal.setTitulos(opciones);

                    ingresar = false;
                }

                if (opciones < 0 || opciones > 5) {
                    System.out.println("========================================");
                    System.out.println("Ingrese un valor numerico correcto");
                    System.out.println("========================================");
                    opciones = 0;
                }

            } catch (NumberFormatException e) {
                System.out.println("--------------------------------------------------");
                System.out.println("SOLO PUEDE NAVEGAR POR EL PROGRAMA USANDO \nVALORES NUMERICOS");
                System.out.println("--------------------------------------------------");
            }

        }
    }

}
