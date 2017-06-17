package cn.tim.jgit.remote;

import cn.tim.jgit.test.file.FileUtils;
import cn.tim.jgit.test.remote.RemoteRepositoryUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by LuoLiBing on 15/7/9.
 */
public class RemoteRepositoryUtilsTest {

    private String localPath = "/Users/tim/Downloads/gitrep";

    @Test
    public void cloneTest() throws GitAPIException {
        RemoteRepositoryUtils.cloneFromRemote("https://github.com/luolibing/Study.git", Paths.get(localPath));
    }


    @Test
    public void commitTest() throws IOException, GitAPIException {
        Git git = Git.open(Paths.get(localPath).toFile());
        FileUtils.createTempFile(localPath);
        RemoteRepositoryUtils.commit(git, "功能添加" + System.currentTimeMillis());
        RemoteRepositoryUtils.push(git);
    }

}
