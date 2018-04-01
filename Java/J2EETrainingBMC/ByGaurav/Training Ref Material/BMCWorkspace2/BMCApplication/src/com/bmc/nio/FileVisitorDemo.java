package com.bmc.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorDemo extends SimpleFileVisitor<Path> {
	
	@Override
	public FileVisitResult visitFile(Path path,
			BasicFileAttributes basicFileAttributes) {

		if (basicFileAttributes.isRegularFile()) {
			System.out.println(path + " is a regular file with size "+ basicFileAttributes.size());
		} else if (basicFileAttributes.isSymbolicLink()) {
			System.out.println(path + " is a symbolic link.");
		} else {
			System.out.println(path+ " is not a regular file or symbolic link.");
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path path, IOException e) {
		System.out.println(path + " visited.");
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path path, IOException e) {
		System.out.println(e);
		return FileVisitResult.CONTINUE;
	}


}
