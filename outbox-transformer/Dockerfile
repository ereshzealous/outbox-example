FROM debezium/connect
ENV DEBEZIUM_DIR=$KAFKA_CONNECT_PLUGINS_DIR/debezium-transformer

RUN mkdir $DEBEZIUM_DIR
COPY build/libs/outbox-transformer-0.0.1-SNAPSHOT.jar $DEBEZIUM_DIR