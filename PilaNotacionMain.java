
import javax.swing.*;

public class PilaNotacionMain {

    public static void main(String[] args) {

        PilaDemo pilaDemo = new PilaDemo();
        String menu[] = {"Mostrar notación posfija", "Salir"};
        String outMenu[] = {"Si", "No"};
        String outDecision = null;
        while (!"No".equals(outDecision)) {
            String equation = JOptionPane.showInputDialog(
                    "Ingrese una ecuación cualquiera");
            String decision = (String) JOptionPane.showInputDialog(
                    null,
                    "¿Qué desea hacer?",
                    null,
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(),
                    menu, menu[0]);
            switch (decision) {
                case "Mostrar notación posfija":
                    pilaDemo.postFix(equation);
                    pilaDemo.stackIn.clear();
                    pilaDemo.stackTemp.clear();
                    pilaDemo.stackOut.clear();
                    outDecision = (String) JOptionPane.showInputDialog(
                            null,
                            "¿Desea intentar de nuevo?",
                            null,
                            JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(),
                            outMenu, outMenu[0]);
                    break;
                case "Salir":
                    outDecision = "No";
                    break;
            }
        }
    }
}
