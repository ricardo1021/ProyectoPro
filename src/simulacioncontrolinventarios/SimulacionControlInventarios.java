/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacioncontrolinventarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author RICARDO
 */
public class SimulacionControlInventarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer n = null;
        Integer demanda;
        Integer stock = 10;
        Integer cantidadPedida = 9;
        Integer diaEspera;
        Integer penuria = null;
        Integer pagoPedido = 60;
        Integer costoItem = 150;
        Double mantenInv = 1.0;
        Float demRndom = null;
        Float diaRndom = null;

        System.out.println("Ingrese número de días-> ");
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(entrada.readLine());

        } catch (IOException e) {
        }

        System.out.println("NoDias\tDemanda\tStock\tCantidadPedida\tDias Espera\tPenuria\tP-P\tCe\tMi");
        System.out.println("0\t--\t10\t9\t\t4\t\t--\t60\t1350\t1");
        int aux = 0;
        int dias = 0;

        for (int i = 1; i <= n; i++) {

//            dias = i + 1;
            demRndom = (float) Math.random();
            diaRndom = (float) Math.random();
            demanda = demandaCalculo(demRndom);
            diaEspera = diaEsperaCalculo(diaRndom);

            if (stock > demanda) {
                stock = stock - demanda;
                aux = aux + demanda;
                if (((i) % 5) == 0) {
                    stock = 9;
                    stock = stock + cantidadPedida;
                    cantidadPedida = aux + cantidadPedida;
//                System.out.println(""+(i-1)+"  es mod de 5");
                    aux = 0;
                    pagoPedido = pagoPedido + 60;
                    costoItem = costoItem * cantidadPedida;

                } else {
                    cantidadPedida = 0;
                }
            } else if ((stock < demanda)) {
                stock = 0;
                penuria = 155 * (demanda - stock);
                if (((i) % 5) == 0) {
                    stock = 9;
                    stock = stock + cantidadPedida;
                    cantidadPedida = aux + cantidadPedida;
//                System.out.println(""+(i-1)+"  es mod de 5");
                    aux = 0;
                    pagoPedido = pagoPedido + 60;
                    costoItem = costoItem * cantidadPedida;

                } else {
                    cantidadPedida = 0;
                }
            }

            mantenInv = stock * 0.1;
            System.out.println("" + (i) + "\t" + demanda + "\t" + stock + "\t" + cantidadPedida + "\t\t" + diaEspera + "\t\t" + penuria + "\t" + pagoPedido + "\t" + costoItem + "\t" + mantenInv);

        }

    }

    public static Integer demandaCalculo(float dRndom) {
        if (dRndom <= 0.135) {
            return 1;
        }
        if (dRndom > 0.135 && dRndom <= 0.406) {
            return 2;
        }
        if (dRndom > 0.406 && dRndom <= 0.677) {
            return 3;
        }
        if (dRndom > 0.677 && dRndom <= 0.857) {
            return 4;
        }
        if (dRndom > 0.857 && dRndom <= 0.947) {
            return 5;
        }
        if (dRndom > 0.947 && dRndom <= 0.983) {
            return 6;
        }
        if (dRndom > 0.983 && dRndom <= 0.995) {
            return 7;
        }
        if (dRndom > 0.995 && dRndom <= 0.999) {
            return 8;
        }
        if (dRndom > 0.999 && dRndom <= 1) {
            return 9;
        }
        return 0;
    }

    public static Integer diaEsperaCalculo(float dRndom) {
        if (dRndom <= 0.3) {
            return 1;
        }
        if (dRndom > 0.3 && dRndom <= 0.7) {
            return 2;
        }
        if (dRndom > 0.7 && dRndom <= 1) {
            return 3;
        }
        return 0;
    }

}
