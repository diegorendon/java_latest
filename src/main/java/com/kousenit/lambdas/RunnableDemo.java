package com.kousenit.lambdas;

public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {  // old style anonymous inner class
            @Override
            public void run() {
                System.out.println("Hello from anonymous inner class");
            }
        }).start();

        // expression lambda
        new Thread(() -> System.out.println("Hello from expression lambda")).start();

        // block lambda
        new Thread(() -> {
            System.out.println("Hello from block lambda");
        }).start();

        // assign lambda to variable
        Runnable r = () -> System.out.println("Assigned to a variable");
        new Thread(r).start();
    }
}
