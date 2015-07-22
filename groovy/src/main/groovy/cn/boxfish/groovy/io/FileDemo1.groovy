package cn.boxfish.groovy.io

import org.junit.Before
import org.junit.Test

import java.nio.file.Files
import java.nio.file.Path

/**
 * Created by LuoLiBing on 15/7/18.
 */
class FileDemo1 {

    private filePath;
    private basePath;

    @Before
    void init() {
        filePath = this.getClass().getClassLoader().getResource("luolibing.log").getPath();
        basePath = this.class.getClassLoader().getResource("").getPath()
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

    @Test
    void writeTest() {
        new File(filePath).withInputStream { stream ->

        }
    }

    @Test
    void writeFile1() {
        new File(filePath).withWriter('utf-8') { writer ->
            writer.writeLine '罗立兵'
            writer.writeLine 'A frog jumps'
            writer.writeLine 'age:27'
        }
    }

    @Test
    void writeFile2() {
        def file = new File(filePath)
        file.withWriterAppend { writer ->
            writer.writeLine '罗立兵' + System.currentTimeMillis()
            writer.writeLine  'A frog jumps'
            writer.writeLine  'age:27'
        }
    }

    @Test
    void writeFile3() {
        new File(filePath) <<
    '''<<test'
    姓名:罗立兵
    age:28
    公司:boxfish
    '''
    }

    @Test
    void writeFile4() {
        new File(filePath).bytes = "刘晓玲".bytes
    }

    @Test
    void writeFile5() {
        def os = new File(basePath, System.currentTimeMillis() + ".log").newOutputStream()
        os.write "罗立兵".bytes
        os.close()
    }

    @Test
    void writeFile6() {
        new File(basePath, System.currentTimeMillis()+".log").withOutputStream {
            stream ->  stream.write("刘晓玲".bytes)
        }
    }

    @Test
    void listFileTree1() {
        new File(basePath).eachFile { file ->
            println file.name
        }

        new File(basePath).eachFileMatch(~/.*\.log/) { file ->
            println file.name
        }
    }

    @Test
    void listFileTree2() {
        new File(basePath).eachFileRecurse { file ->
            println file.name
        }
    }

    @Test
    void createTempFile1() {
        def file = Files.createTempFile("groovy-", ".log")
        println file.toRealPath().toString()
        println file.fileName.toFile().getPath()
    }
}
