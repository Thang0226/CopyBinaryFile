import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter source file path: ");
		String sourcePath = input.nextLine();
		System.out.print("Enter destination file path: ");
		String destinationPath = input.nextLine();

		File source = new File(sourcePath);
		File destination = new File(destinationPath);

		try {
//			copyFileUsingJava7Files(source, destination);
			copyFileUsingStream(source, destination);

		} catch (IOException e) {
			System.out.println("Cannot copy file");
			System.out.println(e.getMessage());
		}
	}

	private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}

	private static void copyFileUsingStream(File source, File dest) throws IOException {
		try (
				InputStream inputStream = new FileInputStream(source);
				OutputStream outputStream = new FileOutputStream(dest);
		) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}
		}
	}
}
