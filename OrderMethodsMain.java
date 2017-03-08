
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OrderMethodsMain {

    public static void main(String[] args) {
        String menu[] = {"Insertar Elemento", "Seleccionar método", "Imprimir", "Salir"};
        String decision = null;
        OrderMethods orderMethods = new OrderMethods();
        while (!"Salir".equals(decision)) {
            decision = (String) JOptionPane.showInputDialog(null, "Seleccione una opción",
                    "Métodos de ordenamiento",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(),
                    menu, menu[0]);
            switch (decision) {
                case "Insertar Elemento":
                    orderMethods.addElement();
                    break;
                case "Seleccionar método":
                    String menu1[] = {"Quicksort", "Mezcla Directa", "Búsqueda Binaria"};
                    switch ((String) JOptionPane.showInputDialog(null,
                            "Seleccione una opción",
                            "Quicksort",
                            JOptionPane.PLAIN_MESSAGE,
                            new ImageIcon(),
                            menu1,
                            menu1[0])) {
                        case "Quicksort":
                            orderMethods.quicksort(0, orderMethods.array.length - 1);
                            JOptionPane.showMessageDialog(null, "Elementos ordenados por Quicksort");
                            break;
                        case "Mezcla Directa":
                            orderMethods.directMergeSort(orderMethods.array);
                            JOptionPane.showMessageDialog(null, "Elementos ordenados por Mezcla Directa");
                            break;
                        case "Búsqueda Binaria":
                            if (orderMethods.ordered) {
                                orderMethods.binarySearch(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar")), orderMethods.array, orderMethods.array.length);
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ordenará la información automáticamente...");
                                orderMethods.quicksort(0, orderMethods.array.length - 1);
                                orderMethods.binarySearch(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a buscar")), orderMethods.array, orderMethods.array.length);
                            }
                            break;
                    }
                    break;
                case "Imprimir":
                    orderMethods.print();
                    break;
            }
        }
    }

}
