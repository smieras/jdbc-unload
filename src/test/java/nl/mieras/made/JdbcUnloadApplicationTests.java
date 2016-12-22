package nl.mieras.made;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.AssertFile;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcUnloadApplicationTests {
	
	private static final String EXPECTED_FILE = "src/test/resources/Customer.csv";
	private static final String OUTPUT_FILE = "target/Customer.csv";

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testFileEquality() throws Exception {
		AssertFile.assertFileEquals(new FileSystemResource(EXPECTED_FILE), new FileSystemResource(OUTPUT_FILE));
	}
}
