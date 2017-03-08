
import javax.swing.JOptionPane;

public final class Array {

    protected int array[];
    protected int tempArray[];
    protected int value;
    protected int defaultLength;
    protected int i;
    protected int l;
    protected int deletedPosition;
    protected boolean deleted;

    public Array() {
        setLength(5);
        this.array = new int[getLength()];
    }

    void insert() {
        if (getPosition() < array.length) {
            if (deleted) {
                array[getPosition() - 1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a añadir"));
                deleted = false;
            } else {
                array[getPosition()] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a añadir"));
                setPosition(getPosition() + 1);
            }
        } else {
            this.tempArray = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                tempArray[j] = array[j];
            }
            setLength(getLength() * 2);
            this.array = new int[getLength()];
            for (int j = 0; j < tempArray.length; j++) {
                array[j] = tempArray[j];
            }
            if (deleted) {
                array[getPosition() - 1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a añadir"));
                deleted = false;
            } else {
                array[getPosition()] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a añadir"));
                setPosition(getPosition() + 1);
            }
        }
    }

    void search() {
        boolean found = false;
        value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a buscar"));
        for (int j = 0; j < array.length; j++) {
            if (array[j] == value) {
                found = true;
                JOptionPane.showMessageDialog(null, "Valor:" + value + "\nencontrado en la pocisión del arreglo: " + j);
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Valor: " + value + "\nno encontrado");
        }
        found = false;
    }

    void delete() {
        int i = 0;
        boolean found = false;
        value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a eliminar"));
        for (int j = 0; j < array.length; j++) {
            if (array[j] == value) {
                i = j;
                found = true;
                JOptionPane.showMessageDialog(null, "Valor: " + value + "\nencontrado en la pocisión del arreglo: " + j);
                setDeletedPosition(i);
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Valor: " + value + "\nno encontrado");
        } else {
            deleted = true;
            while (i < array.length) {
                if (i + 1 > array.length - 1) {
                    break;
                } else {
                    array[i] = array[i + 1];
                }
                i++;
            }
            JOptionPane.showMessageDialog(null, "Valor eliminado");
        }
        found = false;
    }

    void modify() {
        boolean found = false;
        value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a modificar"));
        for (int j = 0; j < array.length; j++) {
            if (array[j] == value) {
                found = true;
                JOptionPane.showMessageDialog(null, "Valor:" + value + "\nencontrado en la pocisión del arreglo: " + j);
                value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el nuevo valor"));
                array[j] = value;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Valor: " + value + "\nno encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "Valor modificado");
        }
        found = false;
    }

    void print() {
        String output = "";
        for (int j = 0; j < getPosition(); j++) {
            output += "Pocisión en el arreglo: " + j + ", Valor: [" + array[j] + "]\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }

    protected void setPosition(int i) {
        this.i = i;
    }

    protected int getPosition() {
        return i;
    }

    protected void setLength(int l) {
        this.l = l;
    }

    protected int getLength() {
        return l;
    }

    public int getDeletedPosition() {
        return deletedPosition;
    }

    public void setDeletedPosition(int deletedPosition) {
        this.deletedPosition = deletedPosition;
    }

}
