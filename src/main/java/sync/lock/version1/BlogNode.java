package sync.lock.version1;

import sync.deadlock.Updater;

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

    public synchronized void propagateUpdate(Updater updater, BlogNode localNode) {
        lock.lock();
        try {
            System.out.println("blog " + localNode.getIdent() + "will update" + updater.getText());
            confirmUpdate(localNode, updater);
        } finally {
            lock.unlock();
        }
    }


    public synchronized void confirmUpdate(BlogNode otherNode, Updater updater) {
        lock.lock();
        try {
            System.out.println("收到更新确认!" + updater.getText() + otherNode.getIdent());
        } finally {
            lock.unlock();
        }
    }

}
