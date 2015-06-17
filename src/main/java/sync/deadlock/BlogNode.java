package sync.deadlock;

/**
 * Created by LuoLiBing on 15/6/13.
 */
public class BlogNode  {

    public final String ident;


    public BlogNode(String _ident) {
        ident = _ident;
    }


    public String getIdent() {
        return ident;
    }

    public synchronized void propagateUpdate(Updater updater, BlogNode localNode) {
        System.out.println("blog " + localNode.getIdent() + "will update" + updater.getText() );
        confirmUpdate(localNode, updater);
    }


    public synchronized void confirmUpdate(BlogNode otherNode, Updater updater) {
        System.out.println("blog confirm update!" + updater.getText() + otherNode.getIdent());
    }

}
