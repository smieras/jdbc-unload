/*******************************************************************************
 * Copyright 2017 Mieras Made
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package nl.mierasmade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.AssertFile;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcUnloadApplicationTests {
	
	private static final String EXPECTED_CUSTOMER_FILE = "src/test/resources/Customer.csv";
	private static final String EXPECTED_PRODUCT_FILE = "src/test/resources/Product.csv";
	private static final String ACTUAL_CUSTOMER_FILE = "target/Customer.csv";
	private static final String ACTUAL_PRODUCT_FILE = "target/Product.csv";

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testFileEquality() throws Exception {
		AssertFile.assertFileEquals(new FileSystemResource(EXPECTED_CUSTOMER_FILE), new FileSystemResource(ACTUAL_CUSTOMER_FILE));
		AssertFile.assertFileEquals(new FileSystemResource(EXPECTED_PRODUCT_FILE), new FileSystemResource(ACTUAL_PRODUCT_FILE));
	}
}
