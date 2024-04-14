package Lessaions;

import java.time.LocalTime;

public class Less2 {
    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            for (int i=0; i<10; i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
