package java8inaction;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExploringJava8Streams {

	public static void main(String[] args) {
		
		// Way-1
		File[] directories = new File("C:\\Calypso Training").listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		});
		
		for (File file : directories) {
			System.out.println(file);
		}
		
		// Way-2
		// Using lambdas: 
		// In the case f -> f.isDirectory() it's a Predicate: <T> -> boolean: or FileFilter <T> -> boolean
		// In the case f -> System.out.println(f) it's a Consumer: <T> -> void
		File[] directoriesLambdas = new File("C:\\Calypso Training").listFiles(f -> f.isDirectory());
		Arrays.asList(directoriesLambdas).stream().forEach(f -> System.out.println(f));
		
		// Way-3
		// Cannot pass arguments to Method References method, for e.g. if we want to print f.getName
		File[] directoriesMethodReference = new File("C:\\Calypso Training").listFiles(File::isDirectory);
		Arrays.asList(directoriesMethodReference).stream().forEach(System.out::println);
		
		// Way-4
		Arrays.asList(new File("C:\\Calypso Training").listFiles(File::isDirectory)).stream().forEach(System.out::println);
		
		// Way-5
		Arrays.asList(new File("C:\\Calypso Training").listFiles()).stream().filter(File::isDirectory).forEach(System.out::println);
		
		// Creating map grouping by file type (directory or file)
		Map<Boolean,List<File>> filesByType = Arrays.asList(new File("C:\\Calypso Training").listFiles()).stream().collect(Collectors.groupingBy(File::isDirectory));
		System.out.println(filesByType);
		
		// Creating a map grouping by file extension from a list of files
		Map<String,List<File>> filesByExtension = Arrays.asList(new File("C:\\Calypso Training").listFiles()).stream().collect(Collectors.groupingBy(f -> f.getName().contains(".")?f.getName().substring(f.getName().indexOf(".")):".dir"));
		System.out.println(filesByExtension);
		
		// Creating a map grouping by file extension from a list of file names
		Map<String,List<String>> filesByExtensionOnlyFileNames = Arrays.asList(new File("C:\\Calypso Training").listFiles()).stream().map(f -> f.getName()).collect(Collectors.groupingBy(s -> s.contains(".")?s.substring(s.indexOf(".")):".dir"));
		System.out.println(filesByExtensionOnlyFileNames);
		
		Arrays.asList(new File("C:\\Calypso Training").listFiles()).stream().filter(File::isFile).sorted().forEach(System.out::println);
		
		List<File> fileList = Arrays.asList(new File("C:\\Calypso Training").listFiles());
		fileList.sort(Comparator.comparing(File::length));
		
	}

}
