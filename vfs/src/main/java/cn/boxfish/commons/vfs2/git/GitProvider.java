package cn.boxfish.commons.vfs2.git;

import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.provider.LocalFileProvider;
import org.apache.commons.vfs2.provider.local.DefaultLocalFileProvider;
import org.apache.commons.vfs2.provider.local.GenericFileNameParser;
import org.apache.commons.vfs2.provider.local.LocalFileName;

public class GitProvider extends DefaultLocalFileProvider implements LocalFileProvider
{

	public GitProvider()
	{
		super();
		setFileNameParser(new GenericFileNameParser());
	}

	@Override
	protected FileSystem doCreateFileSystem(FileName name, FileSystemOptions fileSystemOptions) throws FileSystemException
	{
		final LocalFileName rootName = (LocalFileName) name;
		return new GitFileSystem(rootName, fileSystemOptions);
	}

	@Override
	public FileSystemConfigBuilder getConfigBuilder()
	{
		return GitFileSystemConfigBuilder.getInstance();
	}

}
