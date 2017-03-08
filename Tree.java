
import javax.swing.JOptionPane;

public class Tree {
    Node root;
    int data;
    String text = "";
    void addElement(int data) {
        Node newNode = new Node(data, 0);
        if (!isEmpty()) {
            Node aux = root;
            while (aux != null) {
                if (data <= aux.data) {
                    if (aux.left != null) {
                        aux = aux.left;
                    } else {
                        aux.left = newNode;
                        break;
                    }
                } else if (data >= aux.data) {
                    if (aux.right != null) {
                        aux = aux.right;
                    } else {
                        aux.right = newNode;
                        break;
                    }
                }
            }
            updateBalanceFactor(root);
            checkBalanceFactor(root);
        } else {
            root = newNode;
        }
    }
    void checkBalanceFactor(Node aux) {
        if (aux != null) {
            checkBalanceFactor(aux.left);
            checkBalanceFactor(aux.right);
            if (aux.fe < -1 || aux.fe > 1) {
                if (aux.fe < -1) {
                    Node node1 = aux.left;
                    if (node1.fe <= 0) {
                        aux.left = node1.right;
                        node1.right = aux;
                        aux.fe = 0;
                        node1.fe = 0;
                        Node pointer = root;
                        while(pointer != null){
                            if(pointer.left != null){
                                if(pointer.left == aux){
                                    pointer.left = node1;
                                }
                            }
                            pointer = pointer.left;
                        }
                        if(root.left == aux){
                            root.left = node1 = aux;
                        }
                        if (aux == root) {
                            root = aux = node1;
                        }
                        aux = node1;
                    } else {
                        Node node2 = node1.right;
                        node1.right = node2.left;
                        node2.left = node1;
                        aux.left = node2.right;
                        node2.right = aux;
                        switch (node2.fe) {
                            case -1:
                                aux.fe = 1;
                                node1.fe = 0;
                                node2.fe = 0;
                                break;
                            case 0:
                                aux.fe = 0;
                                node1.fe = 0;
                                node2.fe = 0;
                                break;
                            case 1:
                                aux.fe = 0;
                                node1.fe = -1;
                                node2.fe = 0;
                                break;
                        }
                        if(root.left == aux){
                            root.left = node2;
                        }
                        if (aux == root) {
                            root = aux = node2;
                        }
                        aux = node2;
                    }
                } else if (aux.fe > 1) {
                    Node node1 = aux.right;
                    if (node1.fe >= 0) {
                        aux.right = node1.left;
                        node1.left = aux;
                        aux.fe = 0;
                        node1.fe = 0;
                        Node pointer = root;
                        while(pointer != null){
                            if(pointer.right != null){
                                if(pointer.right == aux){
                                    pointer.right = node1;
                                }
                            }
                            pointer = pointer.left;
                        }
                        if(root.right == aux){
                            root.right = node1;
                        }
                        if (aux == root) {
                            root = aux = node1;
                        }
                        aux = node1;
                    } else {
                        Node node2 = node1.left;
                        node1.left = node2.right;
                        node2.right = node1;
                        aux.right = node2.left;
                        node2.left = aux;
                        switch (node2.fe) {
                            case -1:
                                aux.fe = 0;
                                node1.fe = 1;
                                node2.fe = 0;
                                break;
                            case 0:
                                aux.fe = 0;
                                node1.fe = 0;
                                node2.fe = 0;
                                break;
                            case 1:
                                aux.fe = -1;
                                node1.fe = 0;
                                node2.fe = 0;
                                break;
                        }
                        if (root.right == aux) {
                            root.right = node2;
                        }
                        if (aux == root) {
                            root = aux = node2;
                        }
                        aux = node2;
                    }
                }
            }
        }
    }
    void print(String type) {
        switch (type) {
            case "Preorden":
                runsPreOrder(root);
                break;
            case "Inorden":
                runsInOrder(root);
                break;
            case "Posorden":
                runsPostOrder(root);
                break;
        }
        JOptionPane.showMessageDialog(null, type + ": \n\n" + text);
        text = "";
    }
    String runsPreOrder(Node aux) {
        if (aux != null) {
            text += (aux == root) ? "Raíz: (" + aux.data + ") fe: " + aux.fe + "\n" : "(" + aux.data + ") fe: " + aux.fe + "\n";
            runsPreOrder(aux.left);
            runsPreOrder(aux.right);
        }
        return text;
    }
    String runsInOrder(Node aux) {
        if (aux != null) {
            runsInOrder(aux.left);
            text += (aux == root) ? "Raíz: (" + aux.data + ") fe: " + aux.fe + "\n" : "(" + aux.data + ") fe: " + aux.fe + "\n";
            runsInOrder(aux.right);
        }
        return text;
    }
    String runsPostOrder(Node aux) {
        if (aux != null) {
            runsPostOrder(aux.left);
            runsPostOrder(aux.right);
            text += (aux == root) ? "Raíz: (" + aux.data + ") fe: " + aux.fe + " " : "(" + aux.data + ") fe: " + aux.fe + "\n";
        }
        return text;
    }
    void updateBalanceFactor(Node aux) {
        if (aux != null) {
            aux.fe = height(aux.right) - height(aux.left);
            updateBalanceFactor(aux.left);
            updateBalanceFactor(aux.right);
        }
    }
    public int height(Node aux) {
        if (aux == null) {
            return 0;
        }
        return Math.max(height(aux.left), height(aux.right)) + 1;
    }
    boolean isEmpty() {
        return root == null;
    }
}