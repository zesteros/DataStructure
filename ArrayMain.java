
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ArrayMain {

    public static void main(String[] args) {
        String menu[] = {"Insertar valor", "Búsqueda", "Eliminar", "Modificar datos", "Imprimir", "Salir"};
        String decision = null;
        Array arrayDemo = new Array();
        while (!"Salir".equals(decision)) {
            decision = (String) JOptionPane.showInputDialog(
                    null,
                    "¿Qué desea hacer?",
                    null,
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(),
                    menu, menu[0]);
            switch (decision) {
                case "Insertar valor":
                    arrayDemo.insert();
                    JOptionPane.showMessageDialog(null, "Valor agregado");
                    break;
                case "Búsqueda":
                    arrayDemo.search();
                    break;
                case "Eliminar":
                    arrayDemo.delete();
                    break;
                case "Modificar datos":
                    arrayDemo.modify();
                    break;
                case "Imprimir":
                    arrayDemo.print();
                    break;
            }
        }

    }

}
