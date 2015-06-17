package sync.locklatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by LuoLiBing on 15/6/17.
 */
public class LocklatchExecution {

    final static int MAX_THREAD = 10000;

    final int quorm = 1 + MAX_THREAD/2;

    final CountDownLatch countDownLatch = new CountDownLatch(quorm);

    final Set<ProcessThread> processThreads = new HashSet<ProcessThread>();

    public void execute() {
        try {
            for (int i = 0; i < MAX_THREAD; i++) {
                ProcessThread th = new ProcessThread("localhost:" + (9000 + i), countDownLatch);
                processThreads.add(th);
                th.start();
            }
            countDownLatch.await();
            System.out.println("线程执行达到一半");
        } catch (InterruptedException e) {

        } finally {

        }
    }

}
