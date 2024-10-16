import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversorDeMoneda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Formateador para limitar el número de decimales y evitar notación científica
        DecimalFormat df = new DecimalFormat("#,###.00");

        while (continuar) {
            System.out.println("************************************************");
            System.out.println("Bienvenido/a a tu Conversor de Moneda Preferido");
            System.out.println("\nSelecciona la moneda de origen:");
            System.out.println("1. Pesos Colombianos (COP)");
            System.out.println("2. Dólares (USD)");
            System.out.println("3. Euros (EUR)");
            System.out.println("4. Libras Esterlinas (GBP)");
            System.out.println("5. Real Brasileño (BRL)");
            System.out.println("6. Peso Argentino (ARS)");
            System.out.println("7. Salir");
            System.out.println("************************************************");

            int monedaOrigen = scanner.nextInt();
            if (monedaOrigen == 7) {
                System.out.println("************************************************");
                System.out.println("Gracias por usar el conversor de moneda. ¡Adiós!");
                System.out.println("************************************************");
                continuar = false;
                break;
            }

            System.out.println("************************************************");
            System.out.println("\nSeleccione la moneda a la que desea convertir:");
            System.out.println("1. Pesos Colombianos (COP)");
            System.out.println("2. Dólares (USD)");
            System.out.println("3. Euros (EUR)");
            System.out.println("4. Libras Esterlinas (GBP)");
            System.out.println("5. Real Brasileño (BRL)");
            System.out.println("6. Peso Argentino (ARS)");
            System.out.println("************************************************");

            int monedaDestino = scanner.nextInt();

            if (monedaOrigen == monedaDestino) {
                System.out.println("No puedes convertir entre la misma moneda.");
                continue;
            }

            System.out.print("\nIngresa la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            double tasaConversion = obtenerTasaConversion(monedaOrigen, monedaDestino);

            if (tasaConversion == 0) {
                System.out.println("Esta opción no es válida.");
            } else {
                double resultado = cantidad * tasaConversion;
                System.out.println("El resultado de la conversión es: " + df.format(resultado));
            }
        }


        scanner.close();
    }

    // Método que devuelve la tasa de conversión según las monedas seleccionadas
    public static double obtenerTasaConversion(int origen, int destino) {
        double tasa = 0.0;

        switch (origen) {
            case 1: // COP
                switch (destino) {
                    case 2: tasa = 1 / 4000.0; break;
                    case 3: tasa = 1 / 4500.0; break;
                    case 4: tasa = 1 / 5200.0; break;
                    case 5: tasa = 1 / 800.0; break;
                    case 6: tasa = 1 / 9.0; break;
                }
                break;
            case 2: // USD
                switch (destino) {
                    case 1: tasa = 4000.0; break;
                    case 3: tasa = 0.88; break;
                    case 4: tasa = 0.77; break;
                    case 5: tasa = 5.0; break;
                    case 6: tasa = 450.0; break;
                }
                break;
            case 3: // EUR
                switch (destino) {
                    case 1: tasa = 4500.0; break;
                    case 2: tasa = 1.14; break;
                    case 4: tasa = 0.87; break;
                    case 5: tasa = 5.7; break;
                    case 6: tasa = 510.0; break;
                }
                break;
            case 4: // GBP
                switch (destino) {
                    case 1: tasa = 5200.0; break;
                    case 2: tasa = 1.30; break;
                    case 3: tasa = 1.15; break;
                    case 5: tasa = 6.5; break;
                    case 6: tasa = 580.0; break;
                }
                break;
            case 5: // BRL
                switch (destino) {
                    case 1: tasa = 800.0; break;
                    case 2: tasa = 0.20; break;
                    case 3: tasa = 0.18; break;
                    case 4: tasa = 0.15; break;
                    case 6: tasa = 90.0; break;
                }
                break;
            case 6: // ARS
                switch (destino) {
                    case 1: tasa = 9.0; break;
                    case 2: tasa = 0.0022; break;
                    case 3: tasa = 0.00196; break;
                    case 4: tasa = 0.0017; break;
                    case 5: tasa = 0.011; break;
                }
                break;
        }

        return tasa;
    }
}