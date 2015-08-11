package cn.boxfish.groovy.metaclass

import org.junit.Test

/**
 * Created by LuoLiBing on 15/8/7.
 */
class GroovyKeyword {

    def num =1

    def add12 = {
        this.num++
    }

    def add13 = {
        owner.num++
    }

    def add14 = {
        delegate.num++
    }

    @Test
    void test1() {
        def t = new GroovyKeyword()
        t.add14()
        println t.num
    }

    def closure1 = {
        def closure2 = {
            println "this:" + this
            println "owner:" + owner
            println "delegate:" + delegate
        }
        closure2.call()
    }

    @Test
    void test2() {
        def keyword = new GroovyKeyword()
        keyword.closure1()

    }
}
