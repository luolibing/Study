package sync;

/**
 * Created by LuoLiBing on 15/6/13.
 * 不可改变的对象
 */
public class Updater {

    private final Author author;

    private final String updateText;

    
    private Updater(UpdateBuilder _builder) {
        this.author = _builder.author;
        this.updateText = _builder.updateText;
    }


    static class UpdateBuilder implements ObjectBuilder<Updater> {

        private Author author;

        private String updateText;

        public UpdateBuilder author(Author _author) {
            this.author = _author;
            return this;
        }

        public UpdateBuilder updateText(String _updateText) {
            this.updateText = _updateText;
            return this;
        }

        public Updater build() {
            return new Updater(this);
        }
    }
}

class Author {}
