
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TreeMain {

    public static void main(String[] args) {
        Tree tree = new Tree();
        String menu[] = {"Insertar", "Imprimir", "Limpiar Memoria", "Salir"};
        String decision = null;
        while (!"Salir".equals(decision)) {
            decision = (String) JOptionPane.showInputDialog(
                    null,
                    "Bienvenido\n¿Qué desea hacer?",
                    "Árboles",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(),
                    menu, menu[0]);

            switch (decision) {
                case "Insertar":
                    int tree1[] = {65, 50, 23, 70, 82, 68, 39};
                    int tree2[] = {75, 58, 43, 86, 65, 70, 67, 73, 93, 69, 25, 66, 68, 47, 62, 10, 60};
                    String menu2[] = {
                        "Insertar un nodo",
                        "Árbol 1 (Valores 65,50,23,70,82,68,39)",
                        "Árbol 2 (Valores 75,58,43,86,65,70,67,73,93,69,25,66,68,47,62,10,60)"};
                    String decision2;
                    decision2 = ((String) JOptionPane.showInputDialog(
                            null,
                            "¿Qué desea insertar?",
                            "Insercción",
                            JOptionPane.QUESTION_MESSAGE,
                            new ImageIcon(),
                            menu2, menu2[0]));
                    switch (decision2) {
                        case "Árbol 1 (Valores 65,50,23,70,82,68,39)":
                            for (int i = 0; i < tree1.length; i++) {
                                tree.addElement(tree1[i]);
                            }
                            tree.updateBalanceFactor(tree.root);
                            JOptionPane.showMessageDialog(null, "Árbol agregado exitosamente.");
                            break;
                        case "Árbol 2 (Valores 75,58,43,86,65,70,67,73,93,69,25,66,68,47,62,10,60)":
                            for (int i = 0; i < tree2.length; i++) {
                                tree.addElement(tree2[i]);
                            }
                            tree.updateBalanceFactor(tree.root);
                            JOptionPane.showMessageDialog(null, "Árbol agregado exitosamente.");
                            break;
                        case "Insertar un nodo":
                            tree.addElement(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el dato del nuevo nodo")));
                            tree.updateBalanceFactor(tree.root);
                            JOptionPane.showMessageDialog(null, "Nodo agregado exitosamente.");
                            break;

                    }
                    break;
                case "Imprimir":
                    if (!tree.isEmpty()) {
                        String menu1[] = {"Preorden", "Inorden", "Posorden"};
                        tree.print((String) JOptionPane.showInputDialog(
                                null,
                                "¿Qué recorrido desea imprimir?",
                                "Recorridos",
                                JOptionPane.QUESTION_MESSAGE,
                                new ImageIcon(),
                                menu1, menu1[0]));
                    } else {
                        JOptionPane.showMessageDialog(null, "El árbol esta vacío");
                    }
                    break;
                case "Limpiar Memoria":
                    tree.root = null;
                    JOptionPane.showMessageDialog(null, "Árbol eliminado de memoria");
                    break;
            }
        }
    }

}
