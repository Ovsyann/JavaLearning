package Nobilis.Training;

import Nobilis.Training.DataStructures.MyArrayList;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> jopaMy = new MyArrayList<Integer>(10);
        System.out.println(jopaMy.size());
        jopaMy.add(42);
        System.out.println(jopaMy.size());
        ArrayList<Integer> list = new ArrayList<Integer>();

        HashMap<Integer,String> map = new HashMap<>();
    }
}