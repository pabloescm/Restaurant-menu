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
public class Menu {

    public static Scanner scan = new Scanner(System.in);
    private String[][] menu;
    private String[][] precios;

    //CREO UN CARRITO DE COMPRAS PARA ALMACENAR LOS PEDIDOS DEL USUARIO;
    public String[][] carrito2 = new String[12][4];

    //CREO UN CONSTRUCTOR CON DOS MATRICES DE PARAMETROS;
    public Menu(String[][] Menu, String[][] Precios) {
        menu = Menu;
        precios = Precios;
    }

    public void agregarCarrito(int fila) {
        boolean volver = true;
        while (volver) {
            System.out.println("------------" + menu[0][fila - 1].toUpperCase() + "-------------");
            System.out.println("Digite el numero asociado a la " + menu[0][fila - 1].toLowerCase() + " de su eleccion");

            for (int i = 0; i < menu[1].length; i++) {
                if (i < menu[1].length - 1) {
                    //AQUI MUESTRO EL PLATO ELEJIDO DE LA MATRIZ MENU               Y EL PRECIO DE ESE PLATO EN LA MATRIZ PRECIOS;
                    System.out.println("(" + (i + 1) + ")" + menu[fila][i] + agregarEspacios(20, "(" + (i + 1) + ")" + menu[fila][i]) + precios[fila - 1][i] + " Bs");
                } else {
                    System.out.println("(" + (i + 1) + ")" + menu[fila][i]);
                }
            }

            String aux01 = scan.nextLine();
            int plato = Integer.parseInt(aux01);

            if (plato > 0 && plato < 4) {
                System.out.println("QUE CANTIDAD DESEA?");
                String aux001 = scan.nextLine();
                int Cantidad = Integer.parseInt(aux001);

                for (int AgregarACarrito = 0; AgregarACarrito < carrito2.length; AgregarACarrito++) {
                    if (carrito2[AgregarACarrito][0] == null) {
                        carrito2[AgregarACarrito][0] = Cantidad + "";
                        carrito2[AgregarACarrito][1] = menu[fila][plato - 1];
                        carrito2[AgregarACarrito][2] = precios[fila - 1][plato - 1];
                        carrito2[AgregarACarrito][3] = (Cantidad * Integer.parseInt(carrito2[AgregarACarrito][2])) + "";
                        break;
                    }
                }
            }
            if (plato == 4) {
                volver = false;
            }

        }
    }

    public void verCarritoDeCompras() {

        System.out.println("Especialiad" + agregarEspacios(30, "Especialiad") + "Cantidad" + agregarEspacios(15, "Cantidad")
                + "P/U" + agregarEspacios(15, "P/U") + "Total" + agregarEspacios(30, "Total"));
        System.out.println("==============================================================================================");
        for (int VerCarrito = 0; VerCarrito < carrito2.length; VerCarrito++) {
            if (carrito2[VerCarrito][0] != null) {

                String filaCarrito = "(" + (VerCarrito + 1) + ")" + carrito2[VerCarrito][1] + agregarEspacios(30, "(" + (VerCarrito + 1) + ")" + carrito2[VerCarrito][1])
                        + carrito2[VerCarrito][0] + agregarEspacios(15, carrito2[VerCarrito][0])
                        + carrito2[VerCarrito][2] + "Bs" + agregarEspacios(15, carrito2[VerCarrito][2] + "Bs")
                        + carrito2[VerCarrito][3] + "Bs" + agregarEspacios(30, carrito2[VerCarrito][3] + "Bs");
                System.out.println(filaCarrito);
            }
        }
        String Total = "EL TOTAL A CANCELAR ES :" + calcularTotalFactura() + "Bs";
        System.out.println(agregarEspacios(66, Total) + Total);

    }

    private String agregarEspacios(int anchoColumna, String dato) {

        int espaciosParaAgregar = anchoColumna - dato.length();
        String espacios = "";

        for (int i = 0; i < espaciosParaAgregar; i++) {
            espacios += " ";
        }
        return espacios;
    }

    public void quitaDeCarrito(int editar) {
        carrito2[editar - 1][0] = null;
        carrito2[editar - 1][1] = null;
        carrito2[editar - 1][2] = null;
        carrito2[editar - 1][3] = null;
    }

    public int calcularTotalFactura() {
        int Sumas = 0;

        for (int i = 0; i < carrito2.length; i++) {
            if (carrito2[i][0] != null) {
                Sumas = Sumas + Integer.parseInt(carrito2[i][3]);

            }
        }
        return Sumas;
    }

}
