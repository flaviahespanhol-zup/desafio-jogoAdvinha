import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
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

}