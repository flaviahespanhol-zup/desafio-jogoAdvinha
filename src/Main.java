import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int pontosUsuario = 0;
        List<Integer> palpitesCertosUsuario = new ArrayList<>();
        List<Integer> palpitesErradosUsuario = new ArrayList<>();
        int escolhaDificuldade = 0;
        boolean desejaContinuar = true;
        Scanner scanner = new Scanner(System.in);

        while (desejaContinuar) {
            if (escolhaDificuldade == 0) {
                System.out.println("""
                    Escolha uma dificuldade:
                    Digite 1 para FÁCIL
                    Digite 2 para MÉDIO
                    Digite 3 para DIFÍCIL
                    """);
                escolhaDificuldade = scanner.nextInt();

            }
            if (escolhaDificuldade == 1) {
                int numeroSorteado = numeroAleatorio(1);
                System.out.println("Palpite um número (entre 1 e 10): ");
                int palpite = palpiteDoUsuario(scanner);
                todosPalpites(numeroSorteado, palpite, palpitesCertosUsuario, palpitesErradosUsuario);

                pontosUsuario = jogoAdivinha(numeroSorteado, palpite, pontosUsuario);
                desejaContinuar = continuarJogo(scanner);
            } else if (escolhaDificuldade == 2) {
                int numeroSorteado = numeroAleatorio(2);
                System.out.println("Palpite um número (entre 1 e 50): ");
                int palpite = palpiteDoUsuario(scanner);
                todosPalpites(numeroSorteado, palpite, palpitesCertosUsuario, palpitesErradosUsuario);


                pontosUsuario = jogoAdivinha(numeroSorteado, palpite, pontosUsuario);
                desejaContinuar = continuarJogo(scanner);
            } else if (escolhaDificuldade == 3) {
                int numeroSorteado = numeroAleatorio(3);
                System.out.println("Palpite um número (entre 1 e 100): ");
                int palpite = palpiteDoUsuario(scanner);
                todosPalpites(numeroSorteado, palpite, palpitesCertosUsuario, palpitesErradosUsuario);

                pontosUsuario = jogoAdivinha(numeroSorteado, palpite, pontosUsuario);
                desejaContinuar = continuarJogo(scanner);
            }

        }

        resultadoUsuario(pontosUsuario, palpitesCertosUsuario, palpitesErradosUsuario);

        scanner.close();
    }

    public static int numeroAleatorio(int nivelDificuldade) {
        Random random = new Random();
        if (nivelDificuldade == 1) {
            return random.nextInt(10) + 1;
        } else if (nivelDificuldade == 2) {
            return random.nextInt(50) + 1;
        } else if (nivelDificuldade == 3) {
            return random.nextInt(100) + 1;
        }
        return 0;
    }

    public static int palpiteDoUsuario(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void todosPalpites(int numeroSorteado, int palpite, List<Integer> palpitesCertos, List<Integer> palpitesErrados) {
        if (palpite == numeroSorteado) {
            palpitesCertos.add(palpite);
        } else {
            palpitesErrados.add(palpite);
        }
    }

    public static void resultadoUsuario(int pontos, List<Integer> palpitesCertos, List<Integer> palpitesErrados) {
        System.out.printf("Acabou! Você acumulou %d pontos%n", pontos);
        System.out.println("Seus palpites certos: " + palpitesCertos);
        System.out.println("Seus palpites errados: " + palpitesErrados);
    }

    public static int jogoAdivinha(int numeroAleatorio, int palpite, int pontos) {
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