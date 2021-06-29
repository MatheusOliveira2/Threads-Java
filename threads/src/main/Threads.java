package main;

public class Threads {
    public static void main(String[] args) {
       Thread thread = new Thread(new LoadBar());
       Thread thread2 = new Thread(new LoadBar2());
       thread.start();
       thread2.start();
    }
}

class GeneratePDF implements Runnable{

    @Override
    public void run() {
        System.out.println("Generate PDF");
    }
}

class LoadBar implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("loading ....");
    }
}

class LoadBar2 implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("LoadBar...");
    }
}
