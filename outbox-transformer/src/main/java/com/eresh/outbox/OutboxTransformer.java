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

		if ("c".equalsIgnoreCase(databaseOperation)) {

			Struct after = (Struct) kStruct.get("after");
			String UUID = after.getString("id");
			String payload = after.getString("payload");
			String eventName = after.getString("event_name").toLowerCase();
			String topic = eventName.toLowerCase();

			Headers headers = record.headers();
			headers.addString("eventId", UUID);

			// Prepare the event to be published.
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