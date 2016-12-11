package nl.mieras.made;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import nl.mieras.made.unload.TableUnloader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcUnloadApplicationTests {
	
	@Autowired
	private TableUnloader tableUnloader;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testTableUnloader() {
		ReflectionTestUtils.invokeMethod(tableUnloader, "unloadTables");
	}

}
