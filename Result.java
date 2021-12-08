package La_Deuda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
     
    public static void main(String[] args) {
        long saldo = 0;
        List<Long> prestamo= Arrays.asList(1L,45L);

        int j = Result.calcularDias(prestamo).size()-1;
        int numeroDias= Math.toIntExact(Result.calcularDias(prestamo).get(j));
        System.out.println("Numero de días: " + numeroDias);
        for (int i = 0; i <numeroDias; i++) {
            System.out.println("Pago Día " + (i+1)  + "= " + Result.calcularDias(prestamo).get(i));
            saldo += Result.calcularDias(prestamo).get(i);
        }
        System.out.println("Saldo = " + saldo);

    }

    public static List<Long> calcularDias(List<Long> prestamo) {
        // Write your code here
        long dias= 0;
        long pago= 1;
        long saldoPago =0;

        List<Long> listDias= new ArrayList<>();

        for (int i = 1; i < prestamo.get(1); i++) {

            saldoPago += pago;
            if (saldoPago < prestamo.get(1)) {
                dias++;
                //listDias.add(dias);
                listDias.add(pago);
                pago *= 2;
            }else{
                saldoPago -= pago;
                pago = prestamo.get(1) - saldoPago;
                saldoPago += pago;
                dias++;
                //listDias.add(dias);
                listDias.add(pago);
                break;
            }
        }
        listDias.add(saldoPago);
        listDias.add(dias);
        return listDias;
    }
}







