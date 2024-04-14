package Lessaions;

public class Less3 {
    private static final Object lock = new Object();
    private static int number =1;
    public static void main(String[] args){
        Thread evenThred  = new Thread(()->{
            synchronized (lock){
                while(number<10){
                    if (number%2==0){
                        System.out.println(Thread.currentThread().getName()+": "+number);
                        number++;
                    } else{
                        try{
                            lock.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });
        Thread oldThred  = new Thread(()->{
            synchronized (lock){
                while(number<10){
                    if (number%2!=0){
                        System.out.println(Thread.currentThread().getName()+": "+number);
                        number++;
                    } else{
                        try{
                            lock.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });
        evenThred.setName("EvenThread");
        oldThred.setName("Odd Thread");

        evenThred.start();
        oldThred.start();
    }
}
