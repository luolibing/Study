package sync.deadlock;

/**
 * Created by LuoLiBing on 15/6/15.
 */
public class Updater {

    String id;
    String text;

    public Updater(String id) {
        this.id = id;
    }

    public Updater getUpdate(String id) {
        return new Updater(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
