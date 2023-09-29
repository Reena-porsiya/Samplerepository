package multithreadingdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class sample1 {

    public static void main(String[] args) {
        String filename = "shared_file.txt";
        Thread thread1 = new Thread(new FileWriterThread(filename, "Thread 1 writes this line."));
        Thread thread2 = new Thread(new FileWriterThread(filename, "Thread 2 writes this line."));
        Thread thread3 = new Thread(new FileWriterThread(filename, "Thread 3 writes this line."));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished writing to the file.");
    }
}

class FileWriterThread implements Runnable {
    private final String filename;
    private final String data;

    public FileWriterThread(String filename, String data) {
        this.filename = filename;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            // Create a FileWriter in append mode
            FileWriter fileWriter = new FileWriter(filename, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(data);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
