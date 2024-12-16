import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int pontosUsuario = 0;
        boolean desejaContinuar = true;
        Scanner scanner = new Scanner(System.in);

        while (desejaContinuar) {
            int numeroSorteado = numeroAleatorio();
            System.out.println("Palpite um número (entre 1 e 30): ");
            int palpite = palpiteDoUsuario(scanner);

            pontosUsuario = jogoAdvinha(numeroSorteado, palpite, pontosUsuario);

            desejaContinuar = continuarJogo(scanner);
        }

        System.out.printf("Acabou! Você acumulou %d pontos", pontosUsuario);
        scanner.close();
    }

    public static int numeroAleatorio() {
        Random random = new Random();
        return random.nextInt(30) + 1;
    }

    public static int palpiteDoUsuario(Scanner scanner) {
        return scanner.nextInt();
    }

    public static int jogoAdvinha(int numeroAleatorio, int palpite, int pontos) {
        if (numeroAleatorio == palpite) {
            pontos += 10;
            System.out.printf("PARABÉNS, ACERTOU O NÚMERO! VOCÊ TEM: %d PONTOS\n", pontos);
        } else if (numeroAleatorio + 1 == palpite || numeroAleatorio - 1 == palpite) {
            pontos += 5;
            System.out.printf("QUAASE! CHEGOU PERTO! VOCÊ GANHOU 5 PONTOS. VOCÊ TEM: %d PONTOS\n", pontos);
        } else {
            System.out.printf("Que pena! Você não acertou o número. Total de pontos: %d\n", pontos);
        }
        return pontos;
    }

    public static boolean continuarJogo(Scanner scanner) {
        System.out.println("Quer tentar de novo? (s/n)");
        String resposta = scanner.next();
        return resposta.equalsIgnoreCase("s");
    }

}