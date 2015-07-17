package sync;

import org.junit.Test;
import sync.deadlock.BlogNode;
import sync.deadlock.Updater;

/**
 * Created by LuoLiBing on 15/6/15.
 */
public class DeadLockTest {

    @Test
    public void testDeadLock1() {
        final BlogNode localNode = new BlogNode("localhost:8080");
        final BlogNode otherNode = new BlogNode("localhost:8888");

        final Updater first = new Updater("1");
        final Updater second = new Updater("2");

        new Thread(new Runnable() {
            public void run() {
                localNode.propagateUpdate(first, otherNode);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                otherNode.propagateUpdate(second, localNode);
            }
        }).start();
    }


    @Test
    public void testDeadLock2() {
        final sync.lock.version1.BlogNode localNode = new sync.lock.version1.BlogNode("localhost:8080");
        final sync.lock.version1.BlogNode otherNode = new sync.lock.version1.BlogNode("localhost:8888");

        final Updater first = new Updater("1");
        final Updater second = new Updater("2");

        new Thread(new Runnable() {
            public void run() {
                localNode.propagateUpdate(first, otherNode);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                otherNode.propagateUpdate(second, localNode);
            }
        }).start();
    }

    @Test
    public void testDeadLock3() {
        final sync.lock.version2.BlogNode localNode = new sync.lock.version2.BlogNode("localhost:8080");
        final sync.lock.version2.BlogNode otherNode = new sync.lock.version2.BlogNode("localhost:8888");

        final Updater first = new Updater("1");
        final Updater second = new Updater("2");

        new Thread(new Runnable() {
            public void run() {
                localNode.propagateUpdate(first, otherNode);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                otherNode.propagateUpdate(second, localNode);
            }
        }).start();
    }


    @Test
    public void testDeadLock4() {
        final sync.lock.version3.BlogNode localNode = new sync.lock.version3.BlogNode("localhost:8080");
        final sync.lock.version3.BlogNode otherNode = new sync.lock.version3.BlogNode("localhost:8888");

        final Updater first = new Updater("1");
        final Updater second = new Updater("2");

        new Thread(new Runnable() {
            public void run() {
                localNode.propagateUpdate(first, otherNode);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                otherNode.propagateUpdate(second, localNode);
            }
        }).start();
    }


    @Test
    public void testLock2All() {
        for(int i=0; i<10; i++) {
            testDeadLock2();
            System.out.println("测试" + i);
            System.out.println();
        }
    }


    @Test
    public void testLock3All() {
        for(int i=0; i<10; i++) {
            testDeadLock3();
            System.out.println("测试" + i);
            System.out.println();
        }
    }


    @Test
    public void testLock4All() {
        for(int i=0; i<10; i++) {
            testDeadLock4();
            System.out.println("测试" + i);
            System.out.println();
        }
    }

}
