
import javax.swing.JOptionPane;

public class OrderMethods {

    int position;
    Integer[] array;
    int tempArray[];
    boolean ordered = false;

    OrderMethods() {
        array = new Integer[1];
        position = 0;
    }

    void addElement() {
        if (position < array.length) {
            array[position] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un valor"));
            position++;
        } else {
            tempArray = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                tempArray[j] = array[j];
            }
            array = new Integer[tempArray.length + 1];
            for (int j = 0; j < tempArray.length; j++) {
                array[j] = tempArray[j];
            }
            array[position] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor a añadir"));
            position++;
        }
        ordered = false;
    }

    void quicksort(int start, int end) {
        int left = start;
        int right = end;
        int pos = start;
        boolean band = true;
        while (band == true) {
            band = false;
            while (array[pos] <= array[right] && pos != right) {
                right--;
            }
            if (pos != right) {
                int aux = array[pos];
                array[pos] = array[right];
                array[right] = aux;
                pos = right;
                while (array[pos] >= array[left] && pos != left) {
                    left++;
                }
                if (pos != left) {
                    band = true;
                    aux = array[pos];
                    array[pos] = array[left];
                    array[left] = aux;
                    pos = left;
                }
            }
        }
        if (pos - 1 > start) {
            quicksort(start, pos - 1);
        }
        if (end > pos + 1) {
            quicksort(pos + 1, end);
        }
        ordered = true;
    }

    void directMergeSort(Comparable[] array) {
        Comparable[] tempArray = new Comparable[array.length];
        directMergeSort(array, tempArray, 0, array.length - 1);
        ordered = true;
    }

    void directMergeSort(Comparable[] array, Comparable[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            directMergeSort(array, tempArray, left, center);
            directMergeSort(array, tempArray, center + 1, right);
            interleave(array, tempArray, left, center + 1, right);
        }
    }

    void interleave(Comparable[] array, Comparable[] tempArray, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left].compareTo(array[right]) <= 0) {
                tempArray[k++] = array[left++];
            } else {
                tempArray[k++] = array[right++];
            }
        }
        while (left <= leftEnd) {
            tempArray[k++] = array[left++];
        }
        while (right <= rightEnd) {
            tempArray[k++] = array[right++];
        }
        for (int i = 0; i < num; i++, rightEnd--) {
            array[rightEnd] = tempArray[rightEnd];
        }
    }

    void binarySearch(int data, Integer[] array, int n) {
            int left = 1;
            int right = n;
            boolean ban = false;
            int cen = 0;
            while (left <= right && !ban) {
                if (cen >= array.length || cen < 0) {
                    break;
                }
                if (data == array[cen]) {
                    ban = true;
                } else {
                    if (data >= array[cen]) {
                        left = cen++;
                    } else {
                        right = cen--;
                    }
                }
            }
            if (ban) {
                JOptionPane.showMessageDialog(null, "La información está en la pocisión: " + cen + ", con valor: " + array[cen]);
            } else {
                JOptionPane.showMessageDialog(null, "La información no se encuentra en el arreglo");
            }
        
    }

    void print() {
        if (array[0] != 0) {
            String text = "";
            for (int i = 0; i < array.length; i++) {
                text += "[" + array[i] + "]";
            }
            JOptionPane.showMessageDialog(null, "Elementos: \n" + text);
        } else {
            JOptionPane.showMessageDialog(null, "No hay elementos");
        }
    }
}
