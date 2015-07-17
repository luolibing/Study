package sync.lock.version2;

import sync.deadlock.Updater;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LuoLiBing on 15/6/15.
 */
public class BlogNode {

    public final String ident;

    private Integer code = 2;


    public BlogNode(String _ident) {
        ident = _ident;
    }


    public String getIdent() {
        return ident;
    }

    private final Lock lock = new ReentrantLock();

    public void propagateUpdate(Updater updater, BlogNode localNode) {
        boolean acquired = false;
        try {
            int wait = (int)Math.random()*10;
            acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
            if(acquired) {
                System.out.println("blog " + localNode.getIdent() + "will update" + updater.getText());
                confirmUpdate(localNode, updater);
            } else {
                Thread.sleep(wait);
            }
        } catch (InterruptedException e) {}
        finally {
            if(acquired)
                lock.unlock();
        }
    }


    public void confirmUpdate(BlogNode otherNode, Updater updater) {
        boolean acquired = false;
        try {
            int wait = (int)Math.random()*10;
            acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
            if(acquired) {
                System.out.println("收到更新确认!" + updater.getText() + otherNode.getIdent());
            } else {
                Thread.sleep(wait);
            }
        } catch (InterruptedException e) {}
        finally {
            if(acquired)
                lock.unlock();
        }
    }

}
