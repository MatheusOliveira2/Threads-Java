package main;

public class Threads {
    public static void main(String[] args) {
       GeneratePDF pdf = new GeneratePDF();
       LoadBar lb = new LoadBar(pdf);
       pdf.start();
       lb.start();
    }
}

class GeneratePDF extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Generate PDF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LoadBar extends Thread{

    private Thread generatePDF;

    public LoadBar(Thread thread)    {
        this.generatePDF = thread;
    }
    @Override
    public void run(){
        try {
            while (true){
                Thread.sleep(500);
                if (!this.generatePDF.isAlive()){
                    break;
                }else{
                    System.out.println("loading...");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

