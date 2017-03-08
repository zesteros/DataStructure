
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CircularBufferMain {

    public static void main(String[] args) {
        String decision = null;
        String menu[] = {"Insertar", "Eliminar", "Mostrar", "Salir"};
        CircularBuffer circularBuffer = new CircularBuffer();
        
        while (!"Salir".equals(decision)) {
            decision = (String) JOptionPane.showInputDialog(
                    null,
                    "Bienvenido\n¿Qué desea hacer?",
                    "Colas Circulares",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(),
                    menu, menu[0]);
            switch (decision) {
                case "Insertar":
                    circularBuffer.insert();
                    break;
                case "Eliminar":
                    circularBuffer.delete();
                    break;
                case "Mostrar":
                    circularBuffer.print();
                    break;
            }
        }
    }

}
