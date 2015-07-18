package cn.boxfish.groovy.io

import org.junit.Before
import org.junit.Test

/**
 * Created by LuoLiBing on 15/7/18.
 */
class FileDemo1 {

    private filePath;

    @Before
    void init() {
        filePath = this.getClass().getClassLoader().getResource("crm_2015-07-02.sql").getPath();
    }

    @Test
    void readFile1() {
        new File(filePath).eachLine { line, i ->
            println "Line $i: $line"
        }
    }

    @Test
    void readFile2() {
        def count = 0;
        new File(filePath).withReader { reader ->
            count = reader.readLines().size()
        }
        println "count line is $count"
    }

    @Test
    void collect() {
        def list = new File(filePath).collect()
        println list.size()

        def strings = new File(filePath) as String[]
        println strings.length

        def bytes = new File(filePath).bytes
        println bytes.length
    }

    @Test
    void inputstreamTest() {
        def stream = new File(filePath).newInputStream()
        stream.close()
    }


}
