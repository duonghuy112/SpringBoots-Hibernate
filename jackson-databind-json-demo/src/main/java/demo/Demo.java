package demo;

import java.io.File;

import bean.Student;
import utils.JsonUtils;

public class Demo {
	private static final String FILE_INPUT = "data/sample-lite.json";
	private static final String FILE_INPUT2 = "data/sample-full.json";

	public static void main(String[] args) {
		File file1 = new File(FILE_INPUT);
		File file2 = new File(FILE_INPUT2);
		
		Student s1 = JsonUtils.read(file1, Student.class);
		Student s2 = JsonUtils.read(file2, Student.class);
		System.out.println(s1);
		System.out.println(s2);
	}
}
