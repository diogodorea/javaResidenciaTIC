package ConversorTemperatura;

import java.util.Scanner;

public class ConversorTemperatura {
	
	// Método para converter Celsius para Fahrenheit
	public static double celsiusParaFahrenheit(double temperaturaCelsius) {
		return (temperaturaCelsius * 9 / 5) + 32;
	}
	
	// Método para converter Fahrenheit para Celsius
	public static double fahrenheitParaCelsius(double temperaturaFahrenheit) {
		return (temperaturaFahrenheit - 32) * 5 / 9;
	}
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha a conversão:");
        System.out.println("1 - Celsius para Fahrenheit");
        System.out.println("2 - Fahrenheit para Celsius");
        int escolha = sc.nextInt();

        double temperatura, resultado;
        String unidadeOrigem, unidadeDestino;
                
        switch (escolha) {
            case 1:
                System.out.println("Digite a temperatura em Celsius:");
                temperatura = sc.nextDouble();
                resultado = celsiusParaFahrenheit(temperatura);
                unidadeOrigem = "Celsius";
                unidadeDestino = "Fahrenheit";
                break;
            case 2:
                System.out.println("Digite a temperatura em Fahrenheit:");
                temperatura = sc.nextDouble();
                resultado = fahrenheitParaCelsius(temperatura);
                unidadeOrigem = "Fahrenheit";
                unidadeDestino = "Celsius";
                break;
            default:
                System.out.println("Escolha inválida!");
                sc.close();
                return;
        }

        System.out.println("A temperatura em " + unidadeDestino + " é: " + resultado + " " + unidadeDestino);
        sc.close();
    }

}
