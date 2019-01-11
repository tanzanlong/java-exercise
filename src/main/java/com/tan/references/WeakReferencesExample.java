package com.tan.references;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakReferencesExample {
 public static void main(String[] args) throws InterruptedException {
	Map<WeakKey,User> map=new HashMap<WeakKey,User>();
	WeakKey w=new WeakKey("tan1");
	User user=new User("zl1");
	map.put(w,user);
	for(int i=1;i<100000;i++){
		map.put(new WeakKey("tan"+i), new User("zl"+i));
		/*Thread.sleep(10);
		if(i%100==10){
			System.out.println("gc");
			//System.gc();
		}*/
	}
	//map=null;
	System.out.println(map.get(w).name);
	Thread.sleep(10*1000);
	System.gc();
	Thread.sleep(10*1000);
	System.out.println(user.name);
	while(true){
		Thread.sleep(3*1000);
		System.out.println("...........");
		
	}
}
 
 
 static class WeakKey extends WeakReference<String>{
	public WeakKey(String referent) {
		super(referent);
	}
	 
 }
 
 static class User{
	 public User(String name){
		 this.name= name;
	 }
	 String name;
 }
}
