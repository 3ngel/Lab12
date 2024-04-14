package Lessaions;

public class Less4 {
    public static void main(String[] args){
        for (int i =0; i<10; i++){
            Thread thread = new Thread(()->{
               System.out.println(Thread.currentThread().getName());
            });
            thread.setName("Thread-"+i);
            thread.start();

        }
    }
}
