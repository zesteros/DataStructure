
import javax.swing.JOptionPane;

public class CircularBuffer {

    protected String data;
    protected String circularBuffer[];
    protected int front;
    protected int end;

    CircularBuffer() {
        this.circularBuffer = new String[6];
        front = end = 0;
    }

    /*PRIMERO COMPROBAR SI ESTA LLENA Y LUEGO AGREGAR DATO
    *******************************
    *****************
    ************
    ********/
    void insert() {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, cola circular llena,"
                    + " por favor elimine un dato e intente de nuevo.");
        } else {
            data = JOptionPane.showInputDialog(null, "Ingresa el nuevo dato:");
            
            if (isEmpty()) {
                circularBuffer[front] = data;
                JOptionPane.showMessageDialog(null, "Dato agregado exitosamente");
                end = front;
            } else if (end + 1 >= circularBuffer.length) {
                for (int i = 0; i < front; i++) {
                    if (circularBuffer[i] == null) {
                        circularBuffer[i] = data;
                        JOptionPane.showMessageDialog(null, "Dato agregado exitosamente");
                        end = i;
                        break;
                    }
                }
            } else if (end < circularBuffer.length) {
                end++;
                circularBuffer[end] = data;
                JOptionPane.showMessageDialog(null, "Dato agregado exitosamente");
            }
        }
    }

    void delete() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, la cola esta vacía");
        } else {
            circularBuffer[front] = null;
            if (front + 1 >= circularBuffer.length) {
                front = 0;
            } else {
                front = front + 1;
            }
            JOptionPane.showMessageDialog(null, "Dato del frente eliminado");
        }

    }

    void print() {
        if (!isEmpty()) {
            String orderedBuffer = "";
            String checkContent = "";
            int i = front;
            while (i < circularBuffer.length) {
                checkContent = circularBuffer[i];
                if (checkContent != null) {
                    orderedBuffer += "[" + checkContent + "] ";
                }
                i++;
            }
            i = 0;
            if (circularBuffer[i] != null && front > i) {
                while (i < front) {
                    checkContent = circularBuffer[i];
                    if (checkContent != null) {
                        orderedBuffer += "[" + checkContent + "] ";
                    }
                    i++;
                }
            }
            JOptionPane.showMessageDialog(null, "Elementos ordenados de la Cola Circular:\nFrente >" + orderedBuffer + "< Final");
        } else {
            JOptionPane.showMessageDialog(null, "Lo sentimos, la cola esta vacía");
        }
    }

    boolean isEmpty() {
        return circularBuffer[front] == null;
    }

    boolean isFull() {
        boolean isFull = true;
        for (String circularBuffer1 : circularBuffer) {
            if (circularBuffer1 == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
}
