package cn.boxfish.groovy.collection

import org.junit.Test

/**
 * Created by TIM on 2015/7/26.
 */
class List {

    @Test
    void listLiterals1() {
        def list = [1,2,3,4,5]
        assert list.get(2) == 3
        assert list[2] == 3
        assert list instanceof  java.util.List

        def emptyList = []
        assert emptyList.size() == 0
        emptyList.add(5)
        assert emptyList.size() == 1
    }

    @Test
    void listLiterals2() {
        def list1 = ['a', 'b', 'c']
        def list2 = new ArrayList<String>(list1)
        assert list1 == list2

        def list3 = list1.clone()
        assert list3 == list1
    }

    @Test
    void collectionObject1() {
        def list = [5, 6, 7, 8]
        assert list.size() == 4
        assert list.class == ArrayList

        assert list[2] == 7
        assert list.getAt(2) == 7
        assert list.get(2) == 7

        list[2] = 9
        assert list == [5, 6, 9, 8]

        list.putAt(2, 10)
        assert list == [5, 6, 10, 8]
        assert list.set(2, 11) == 10
        assert list == [5, 6, 11, 8]

        assert ['a', 1, 2, boolean, 2.5, 2.5d, null, 9 as byte]

        assert[1,2,3,4,5][-1] == 5
        assert[1,2,3,4,5][-2] == 4

        assert[1,2,3,4,5].getAt(-2) == 4
        try{
            [1,2,3,4,5].get(-1)==4
            assert false
        } catch (e) {
            assert e instanceof ArrayIndexOutOfBoundsException
        }
    }

    @Test
    void listAsBoolean() {
        assert ![]
    }

    @Test
    void listIterating1() {
        [1,2,3].each {
            println "item:${it}"
        }

        ['a', 'b', 'z', 'hello'].eachWithIndex{ it,  i ->
            println("$i:$it")
        }
    }

    @Test
    void listOperate1() {
        assert [1, 2, 3].collect { it*2 } == [2, 4, 6]
        assert [1, 2, 3]*.multiply(2) == [2, 4, 6]

        def list = [0]
        assert [1, 2, 3].collect(list) { it*2 } == [0, 2, 4, 6]
    }

    @Test
    public void maniPulatingList() {
        assert [1,2,3].find{ it > 2 } == 3
        assert [1, 2, 3].findAll { it > 1} == [2, 3]
        assert ['a', 'b', 'c', 'd', 'e'].findIndexOf {
            it in ['c', 'e', 'g']
        } == 2
    }
}
