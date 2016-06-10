package com.hillel.tyshchenko;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        ArrayListHW<Integer> arHWint = new ArrayListHW();
        ArrayListHW<String> arHWStr = new ArrayListHW();

        arHWint.add(new Integer(1));
        arHWint.add(new Integer(2));
        arHWint.add(new Integer(3));
        arHWint.add(new Integer(4));
        arHWint.add(new Integer(5));
        arHWint.add(new Integer(6));
        arHWint.add(new Integer(1));
        arHWint.add(new Integer(2));
        arHWint.add(new Integer(3));
        arHWint.add(new Integer(4));
        arHWint.add(new Integer(5));
        arHWint.add(new Integer(6));
        arHWint.add(new Integer(3));
        arHWint.add(new Integer(4));
        arHWint.add(new Integer(5));
        arHWint.add(new Integer(6));

        System.out.println(arHWint);
        arHWint.add(2,100500);
        System.out.println(arHWint);
        arHWStr.add("a");
        arHWStr.add("b");
        arHWStr.add("c");
        arHWStr.add("d");
        arHWStr.add("e");
        arHWStr.add("abc");
        System.out.println(arHWStr);
        System.out.println(arHWStr.get(3));
        arHWStr.set(3, "setEl");
        arHWStr.set(0, "setEl2");
        System.out.println(arHWStr);
        arHWStr.remove(2);
        System.out.println(arHWStr);
        arHWStr.clear();
        System.out.println(arHWStr);
        System.out.println(arHWint.get(3));
        arHWint.remove(3);
        System.out.println(arHWint);
        arHWint.set(0, new Integer(10));
        System.out.println(arHWint);
        arHWint.clear();
        System.out.println(arHWint);
        arHWint.remove(3);
        System.out.println(arHWint);
        arHWint.remove(0);
        arHWint.add(3);
        System.out.println(arHWint);
    }
}

class ArrayListHW<E> {
    int number = 10;
    private Object[] arrayList = new Object[number];
    private int size = 0;

    public void add(E el) {
        if (size < this.arrayList.length) {
            this.arrayList[size] = el;
            size++;
            checkAndAddLenght();
        }
    }


    public void add(int index, E el) {
        for (int i = arrayList.length-1; i > index - 1; i--) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = el;
        size++;
        checkAndAddLenght();
    }


    public E get(int index) {
        return (E) this.arrayList[index];
    }

    public E set(int index, E value) {
        Object temp = arrayList[index];
        arrayList[index] = value;
        return (E) temp;
    }

    public void remove(int index) {
        for (int i = index; i < arrayList.length - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        if (size > 0) {
            size--;
        }
    }

    public void clear() {
        for (int i = 0; i < arrayList.length - 1; i++) {
            arrayList[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.arrayList.length; i++) {
            if (arrayList[i] != null) {
                sb.append(arrayList[i] + ", ");
            }
        }
        return sb.toString();
    }

    private void checkAndAddLenght() {
        if (size > number - 1) {
            Object[] arrayListNew = new Object[number += 10];
            for (int i = 0; i < arrayList.length; i++) {
                arrayListNew[i] = arrayList[i];
            }
            arrayList = arrayListNew;
        }
    }
};
