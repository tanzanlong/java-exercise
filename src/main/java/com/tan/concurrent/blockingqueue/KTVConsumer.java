package com.tan.concurrent.blockingqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class KTVConsumer implements Delayed{
    private String name;
    //截止时间
    private long endTime;
    //包厢号
    private String boxNum;

    public KTVConsumer(String name,String boxNum,long endTime){
      this.name=name;
      this.boxNum=boxNum;
      this.endTime=endTime;
    }

    public String getName(){
      return this.name;
    }

    public String getBoxNum(){
      return this.boxNum;
    }

    /**
     * 用来判断是否到了截止时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
      // TODO Auto-generated method stub
      return unit.convert(endTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 相互比较排序用
     */
    @Override
    public int compareTo(Delayed o) {
      // TODO Auto-generated method stub
      if(o == null || ! (o instanceof KTVConsumer)) return 1;
      if(o == this) return 0;
      KTVConsumer s = (KTVConsumer)o;
      return endTime - s.endTime > 0 ? 1 :(endTime - s.endTime == 0 ? 0 : -1);
    }
}
