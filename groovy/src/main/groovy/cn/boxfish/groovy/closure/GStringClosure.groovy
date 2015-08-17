package cn.boxfish.groovy.closure

import org.junit.Test

/**
 * Created by LuoLiBing on 15/8/15.
 */
class GStringClosure {

    @Test
    void run1() {
        def x = 1
        def gs = "x = ${x}"
        //assert gs == 'x = 1'

        x = 2
        assert gs == 'x = 2'
    }

    @Test
    void run2() {
        def x = 1
        def gs = "x = ${ -> x}"
        assert gs == 'x = 1'

        x = 2
        assert gs == 'x = 2'
    }

    class Person {
        String name
        String toString() { name }
    }

    @Test
    void run3() {
        def sam = new Person(name: 'sam')
        def lucy = new Person(name: 'lucy')
        def  p = sam
        def gs = "Name: ${p}"
        assert gs == "Name: sam"
        p = lucy
        println gs

        sam.name = 'lucy'
        println gs
    }

    @Test
    void run4() {
        def sam = new Person(name: 'sam')
        def lucy = new Person(name: 'lucy')
        def p = sam
        def gs = "Name: ${ -> p}"
        p = lucy
        println gs
    }

}
