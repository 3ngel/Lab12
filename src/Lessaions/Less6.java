package Lessaions;

import java.util.Arrays;
import java.util.Random;

public class Less6 {
    private static int index = 0;
    private static int max;
    public static void main(String[] args){
        Random r = new Random();
        int[] mass = new int[20];
        for (int i =0; i<mass.length; i++){
            mass[i]=r.nextInt(100);
        }
        System.out.println(Arrays.toString(mass));
        System.out.println(Runtime.getRuntime().availableProcessors()+" кол-во ядер");
        for(int i=0; i<Runtime.getRuntime().availableProcessors();i++){
            Thread thread  = new Thread(()->{
                while(index<mass.length){
                    maxNumver(mass[index]);
                    System.out.println(Thread.currentThread().getName()+" поток\n"
                            +"Индекс"+index+"\n"+
                            "Сумма на данный момент "+max);
                    index++;
                }
            });
            thread.setName("Thread-"+i);
            thread.start();
        }
        System.out.println(max+" сумма");

    }
    public static void maxNumver(int number){
        max+=number;
    }
}
