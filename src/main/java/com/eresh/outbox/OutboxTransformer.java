package com.eresh.outbox;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.header.Headers;
import org.apache.kafka.connect.transforms.Transformation;

import java.util.Map;

/**
 * Created on 16/August/2021 By Author Eresh, Gorantla
 **/
public class OutboxTransformer<R extends ConnectRecord<R>> implements Transformation<R> {

	@Override
	public R apply(R record) {
		Struct kStruct = (Struct) record.value();
		String databaseOperation = kStruct.getString("op");

		//Handle only the Create's
		if ("c".equalsIgnoreCase(databaseOperation)) {

			// Get the details.
			Struct after = (Struct) kStruct.get("after");
			String UUID = after.getString("uuid");
			String payload = after.getString("payload");
			String eventType = after.getString("event_type").toLowerCase();
			String topic = eventType.toLowerCase();

			Headers headers = record.headers();
			headers.addString("eventId", UUID);

			// Build the event to be published.
			record = record.newRecord(topic, null, Schema.STRING_SCHEMA, UUID,
			                          null, payload, record.timestamp(), headers);
		}

		return record;
	}

	@Override
	public ConfigDef config() {
		return new ConfigDef();
	}

	@Override
	public void close() {

	}

	@Override
	public void configure(Map<String, ?> configs) {

	}
}