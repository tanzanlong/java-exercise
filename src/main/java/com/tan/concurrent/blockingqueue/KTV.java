package com.tan.concurrent.blockingqueue;

import java.util.concurrent.DelayQueue;

public class KTV implements Runnable{
    private DelayQueue<KTVConsumer> queue = new DelayQueue<>();

    public void begin(String name,String boxNum,int money){

      KTVConsumer man = new KTVConsumer(name,boxNum,20l*money+System.currentTimeMillis());
      System.out.println(man.getName()+" 等人交了"+money+"元钱，进入"+man.getBoxNum()+"号包厢,开始K歌...");
      this.queue.add(man);
    }

    public void end(KTVConsumer man){
      System.out.println(man.getName()+" 等人所在的"+man.getBoxNum()+"号包厢,时间到...");
    }

    @Override
    public void run() {
      // TODO Auto-generated method stub
      while(true){
        try {
          KTVConsumer man = queue.take();
          end(man);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    public static void main(String args[]){
      try{
        System.out.println("KTV正常营业");
        System.out.println("================================");
        KTV ktv = new KTV();
        Thread sing = new Thread(ktv);
        sing.start();
        new Thread(new Runnable() {
          @Override
          public void run() {
            ktv.begin("张三", "111", 500);
          }
        }).start();

        new Thread(new Runnable() {
          @Override
          public void run() {
            ktv.begin("李四", "666", 200);
          }
        }).start();

        Thread.sleep(2000);
        new Thread(new Runnable() {
          @Override
          public void run() {
            ktv.begin("王五", "888", 100);
            System.out.println("================================");
          }
        }).start();

      }
      catch(Exception ex){

      }

    }
}
