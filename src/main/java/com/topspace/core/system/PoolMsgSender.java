/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-24 下午8:46:07
 * TODO //
 */
package com.topspace.core.system;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

import com.topspace.core.framework.listener.ApplicationInterface;
import com.topspace.core.framework.misc.SystemConstant;



@Component("PoolMsgSender")
public class PoolMsgSender extends AbstractMsgSender implements Runnable, ApplicationInterface {



    private final static String FileName = SystemConstant.getRealPath() + "/cache/MsgQueue";

    private ConcurrentLinkedQueue<Message> queue = new ConcurrentLinkedQueue<Message>();

    public PoolMsgSender() {
        Thread t = new Thread(this);
        t.start();
    }

	public boolean sendMsg(Message msg) {
		// TODO Auto-generated method stub
		return false;
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

//    @Override
//    public boolean sendMsg(Message msg) {
//        queue.add(msg);
//        myNotify();
//        return true;
//    }

//    @Override
//    public void run() {
//        while(true){
//            while(!queue.isEmpty()){
//                Message msg = queue.poll();
//                send(msg);
//            }
//            myWait();
//        }
//    }

//    @Override
//    public void start() {
//        Object object = FileUtil.readObjectFromFile(FileName);
//        if(object instanceof ConcurrentLinkedQueue){
//            queue = (ConcurrentLinkedQueue<Message>) object;
//            myNotify();
//        }
//    }

//    @Override
//    public void shutdown() {
//        if(queue.isEmpty()){
//            FileUtil.deleteFile(FileName);
//        }else{
//            FileUtil.writeObjectToFile(queue, FileName);
//        }
//    }

//    private void myNotify() {
//        synchronized(this){
//            notify();
//        }
//    }

//    private void myWait() {
//        try{
//            // Thread.sleep(1000*60);
//            synchronized(this){
//                wait();
//            }
//        }catch(InterruptedException e){
//            log.error(e.getMessage(), e);
//        }
//    }
}


