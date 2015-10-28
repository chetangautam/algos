package org.java.fileio;

// TODO - it didn't work. Need to study

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

public class RAFRead {

	public static void main(String[] args) {

		
		create();
		read();

	}

	public static void read() {
		
		// Create the set of options for appending to the file.
		Set<OpenOption> options = new HashSet<OpenOption>();
		options.add(StandardOpenOption.READ);

		Path file = Paths.get("./outfile.log");

		ByteBuffer buffer = ByteBuffer.allocate(4);
		try {
			SeekableByteChannel sbc = Files.newByteChannel(file, options);
			int nread;
			do {
				nread = sbc.read(buffer);
				if(nread!= -1) {
					//buffer.flip();
					System.out.println(buffer.getInt());
				}
			} while(nread != -1 && buffer.hasRemaining());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void create() {
		// Create the set of options for appending to the file.
		Set<OpenOption> options = new HashSet<OpenOption>();
		options.add(StandardOpenOption.APPEND);
		options.add(StandardOpenOption.CREATE);

		// Create the custom permissions attribute.
		Set<PosixFilePermission> perms = PosixFilePermissions
				.fromString("rw-r-----");
		FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions
				.asFileAttribute(perms);

		Path file = Paths.get("./outfile.log");

		ByteBuffer buffer = ByteBuffer.allocate(4);
		try {
			SeekableByteChannel sbc = Files.newByteChannel(file, options, attr);
			for (int i = 9; i >= 0; --i) {
				sbc = sbc.position(i * 4);
				buffer.clear();
				buffer.put(new Integer(i).byteValue());
				buffer.flip();
				sbc.write(buffer);
			}
			sbc.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
