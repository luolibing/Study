package cn.boxfish.groovy.closure

import groovy.util.logging.Slf4j
import org.junit.Test

/**
 * Created by LuoLiBing on 15/8/11.
 */
@Slf4j
class ClosureTest {

    @Test
    void sleepTest() {
        sleep 1000l, {
            println "hand"
            return true
        }

        sleep(100) {

        }

        sleep(1000l, {
            println "hander"
            return false
        })
    }

    @Test
    void slf4jTest() {
        log.info("hello world")
    }
}
