import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.lang.classfile.ClassSignature;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("Hello");
        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Produce starting...");
            wait();
            System.out.println("Produce resume");
        }
    }

    public void consume() throws InterruptedException {

        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        synchronized (this){
            scanner.nextLine();
            notify();
        }
    }
}







