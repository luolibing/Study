package cn.boxfish.groovy.grammar

import org.junit.Test

/**
 * Created by LuoLiBing on 15/7/27.
 */
class UseGrammar1 {

    @Test
    public void useTest1() {
        Entity entity = new Entity();
        use(UseGrammar){
            println entity.hello
        }
    }

    class Entity {
        String getHello() {
            return "hello entity"
        }
    }

    static class UseGrammar {
        static String getHello() {
            return "hello grammer"
        }

        static String getGoodbye(Entity entity) {
            return "hello grammer goodbye"
        }
    }

}
