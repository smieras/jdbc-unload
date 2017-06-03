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
package nl.mierasmade.unload;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nl.mierasmade.configuration.ExternalConfiguration;
import nl.mierasmade.configuration.ReaderConfiguration;
import nl.mierasmade.record.Record;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableUnloader {
		
	@Autowired
	private ExternalConfiguration externalConfiguration;	
	@Autowired
	private ReaderConfiguration readerConfiguration;

	public void unload() {
		externalConfiguration.getTableDefinitions().forEach(tableDefinition -> {
			JdbcPagingItemReader<Record> reader = readerConfiguration.jdbcPagingItemReader(tableDefinition);
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(externalConfiguration.getOutputDir() + tableDefinition.getFileName(), false))) {
				int count = 0;
				List<Record> records = new ArrayList<>();
				Record record;
				while((record = reader.read()) != null) {
					records.add(record);
					count++;

					if (count == externalConfiguration.getCommitInterval()) {
						writeRecords(bw, records);
						records = new ArrayList<>();
						count = 0;
					}
				}

				writeRecords(bw, records);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private void writeRecords(BufferedWriter bw, List<Record> records) throws IOException {
		for (Record line : records) {
			bw.write(line.toString());
			bw.newLine();
		}
	}
}
