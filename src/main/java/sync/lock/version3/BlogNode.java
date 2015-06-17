package sync.lock.version3;

import sync.deadlock.Updater;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LuoLiBing on 15/6/15.
 */
public class BlogNode {

    public final String ident;


    public BlogNode(String _ident) {
        ident = _ident;
    }


    public String getIdent() {
        return ident;
    }

    private final Lock lock = new ReentrantLock();

    public void propagateUpdate(Updater updater, BlogNode localNode) {
        boolean acquired = false;
        boolean done = false;
        while(!done) {
            int wait = (int) Math.random() * 10;
            try {
                acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
                if (acquired) {
                    System.out.println("blog " + localNode.getIdent() + "will update" + updater.getText());
                    done = confirmUpdate(localNode, updater);
                }
            } catch (InterruptedException e) {
            } finally {
                if (acquired)
                    lock.unlock();
            }

            if(!done) {
                try {
                    Thread.sleep(wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public boolean confirmUpdate(BlogNode otherNode, Updater updater) {
        boolean acquired = false;
        try {
            int wait = (int)Math.random()*10;
            acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
            if(acquired) {
                System.out.println("收到更新确认!" + updater.getText() + otherNode.getIdent());
                return true;
            } else {
                Thread.sleep(wait);
                return false;
            }
        } catch (InterruptedException e) {}
        finally {
            if(acquired)
                lock.unlock();
        }
        return false;
    }

}
