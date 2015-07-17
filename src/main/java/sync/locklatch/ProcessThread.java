package sync.locklatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by LuoLiBing on 15/6/17.
 */
public class ProcessThread extends Thread {

    private final String ident;

    private final CountDownLatch countDownLatch;

    public ProcessThread(String _ident, CountDownLatch _countDownLatch) {
        this.ident = _ident;
        this.countDownLatch = _countDownLatch;
    }

    public String getIdent() {
        return ident;
    }

    public void initialize() {
        System.out.println(ident + "执行完毕！");
        countDownLatch.countDown();
        try {
            int threadSleep =  new Random().nextInt()*1000;
            Thread.sleep(threadSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        initialize();
    }
}
