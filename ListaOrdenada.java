
import javax.swing.JOptionPane;

public class ListaOrdenada {

    class Node {

        int data;
        Node next;
    }

    private Node start;
    private Node fin;

    public ListaOrdenada() {
        start = null;
    }

    void insertarNuevo(int x) {
        if (start == null) {
            Node newNode = new Node();
            newNode.data = x;
            start = newNode;
            fin = newNode;
        } else {
            Node newNode = new Node();
            newNode.data = x;
            fin.next = newNode;
        }
    }

    void addElementInIOrder(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (start == null) {
            start = newNode;
        } else {
            if (data < start.data) {
                newNode.next = start;
                start = newNode;
            } else {
                Node selector = start;
                Node prev = start;
                while (data >= selector.data && selector.next != null) {
                    prev = selector;
                    selector = selector.next;
                }
                if (data >= selector.data) {
                    selector.next = newNode;
                } else {
                    newNode.next = selector;
                    prev.next = newNode;
                }
            }
        }
    }

    public void imprimir() {
        Node reco = start;
        while (reco != null) {
            System.out.print(reco.data + "-");
            reco = reco.next;
        }
        System.out.println();
    }

    public static void main(String[] ar) {
        int decision = 10;
        ListaOrdenada lo = new ListaOrdenada();
        while (decision != 0) {
            decision = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea hacer"
                    + "\n1° insertar"
                    + "\n2° imprimir"
                    + "\n0° salir"));
            switch (decision) {
                case 1:
                    int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE VALOR"));
                    lo.addElementInIOrder(valor);
                    break;
                case 2:
                    lo.imprimir();
                    break;
            }
        }
    }
}
