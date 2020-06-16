/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication53;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Maram Tanani
 */

public class JavaApplication53 {

    public static void main(String[] args) {
        
        MyThread a = new MyThread(100,"src/javaapplication53/a.txt");
        a.setName("File a : ");
        a.setPriority(Thread.MIN_PRIORITY);

        MyThread b = new MyThread(100,"src/javaapplication53/b.txt");
        b.setName("File b : ");
        b.setPriority(Thread.MAX_PRIORITY);

        a.start();
        b.start();
    }
}
    
    class MyThread extends Thread {

    private int sleep;
    private Scanner scanner;

    @Override
    public void run() {
        try {
            while (scanner.hasNextLine()) {
                System.out.println(this.getName() + " " + scanner.nextLine());
                Thread.sleep(sleep);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MyThread(int sleep, String f) {
        super();
        try {
            this.scanner = new Scanner(new File(f));
        } catch (FileNotFoundException ex) {
            System.out.println("not exsist. ");
        }
        this.sleep = sleep;
    }
}





