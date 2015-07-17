package cn.boxfish.jgit.test1;

import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by LuoLiBing on 15/7/8.
 */
public class RepositoryTest {


    private static Repository repository = null;


    public static void main(String[] args) throws IOException {


    }


    public synchronized Repository getInstance() throws IOException {
        if(repository==null)
            repository = createRepository();
        return repository;
    }


    private Repository createRepository() throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        return builder.setGitDir(Paths.get("/Users/boxfish/Documents/boxfish-crm").toFile())
                .readEnvironment()
                .findGitDir()
                .build();
    }


    public Object getHead() throws IOException {
        return repository.resolve("HEAD");
    }



}
