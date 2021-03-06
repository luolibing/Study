package cn.tim.jgit.test.test;

import cn.tim.jgit.test.file.FileUtils;
import cn.tim.jgit.test.helper.RepositoryHelper;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by LuoLiBing on 15/7/8.
 */
public class FileUtilsTest {

    private Repository repository;

    private final String repPath = "/Users/tim/Documents/jgit_repository";

    @Before
    public void createRepository() throws IOException {
        //this.repository = RepositoryHelper.createNewRepository(repPath);
        this.repository = RepositoryHelper.getDefaultRepository(repPath);
    }

    @Test
    public void addFileAndDeleteTest() throws GitAPIException, IOException {
        Git git = FileUtils.addFile(repPath, cn.tim.jgit.test.utils.FileUtils.getClassPathFile("jgitres/1.txt"));
        FileUtils.commit(git, "提交测试，1.txt");
        FileUtils.deleteFile(new File(repPath,"1.txt"));
    }


    @Test
    public void addFileTest() throws GitAPIException, IOException {
        Git git = FileUtils.addFile(repPath, cn.tim.jgit.test.utils.FileUtils.getClassPathFile("jgitres/2.txt"));
        FileUtils.commit(git, "测试提交，2.txt");
        //FileUtils.deleteFile(new File(repPath,"2.txt"));
    }

}
