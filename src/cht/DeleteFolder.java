package cht;

import java.io.File;

public class DeleteFolder
{
	
	public static boolean deleteFile(File path) {
		//String path=new String(Path.getPath());
		//File file=new File(path+fileName);
		if(path.exists() && path.isFile())
		{
			if(path.delete())
			{
				System.out.println("文件删除successed");
				return true;
			}
			else
			{
				System.out.println("failed");
				return false;
			}
		}
		else
		{
			System.out.println("删除失败");
			return false;
		}
	}
	
	
	public static boolean deleteDirectory(File path) {
		///String dir=new String(Path.getPath()+name);
//		if (!dir.endsWith(File.separator))
//		{	//判断是否是目录
//			dir=dir+File.separator;
//		}
//		File dirFile=new File(dir);
		if ((!path.exists())||(!path.isDirectory())) {
			System.out.println("目录不存在");
			return false;
		}
		boolean flag=true;
		File[] files=path.listFiles();
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isFile())
			{
				flag=deleteFile(files[i]);
				if(!flag)
					break;
			}
			else if(files[i].isDirectory())
			{
				flag=deleteDirectory(files[i]);
				if(!flag)
					break;
			}
		}
		if(!flag)
		{
			System.out.println("删除目录失败");
			return false;
		}
		if(path.delete())
		{
			System.out.println("删除目录成功");
			return true;
		}
		else
		{
			return false;
		}
	}

	
	public static void main(String[] args)
	{
		File file=new File("E:\\Java资料\\test\\1.txt");
		deleteDirectory(file);
	}
	
}
