package utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private JsonUtils() {
	}
	
	public static void write(File file, Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(file, object);
			System.out.println("Write file " + file.getName() + " successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> T read(File file, Class<T> classType) {
		T t = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			t = objectMapper.readValue(file, classType);
			System.out.println("Read file " + file.getName() + " successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}
}
