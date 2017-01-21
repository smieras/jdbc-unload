package nl.mierasmade.reader;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class QueryProviderTest {
	
	@Test(expected= IllegalStateException.class)
	public void testConstructQueryProviderWithIllegalDataSource() {
		QueryProvider queryProvider = new QueryProvider();
		ReflectionTestUtils.setField(queryProvider, "dataSource", null);
		queryProvider.constructQueryProvider("", "", "");		
	}	
}
