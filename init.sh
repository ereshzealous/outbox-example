echo -e "\n-------- Creating Kafka Topics Initiated --------"

echo -e "\n-------- Creating Kafka Topics new_user --------"
docker exec -t kafka /usr/bin/kafka-topics \
--create --bootstrap-server :9092 \
      --topic new_user \
      --partitions 1 \
      --replication-factor 1
echo -e "\n-------- Creation Kafka Topics new_user Completed --------"

echo -e "\n-------- Creating Kafka Topics news_letter_subscription --------"
docker exec -t kafka /usr/bin/kafka-topics \
      --create --bootstrap-server :9092 \
      --topic news_letter_subscription \
      --partitions 1 \
      --replication-factor 1
echo -e "\n-------- Creation Kafka Topics news_letter_subscription Completed --------"

echo -e "\n-------- Creating Kafka Topics email_changed --------"
docker exec -t kafka /usr/bin/kafka-topics \
      --create --bootstrap-server :9092 \
      --topic email_changed \
      --partitions 1 \
      --replication-factor 1
echo -e "\n-------- Creation Kafka Topics email_changed Completed --------"

echo -e "\n-------- Creating Outbox Kafka Connector For Debezium --------"

curl -X POST  http://localhost:8083/connectors/ \
  -H 'content-type: application/json' \
  -d '{
   "name": "student-outbox-connector",
   "config": {
      "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
      "tasks.max": "1",
      "database.hostname": "postgres",
      "database.port": "5432",
      "database.user": "postgres",
      "database.password": "postgres",
      "database.dbname": "user_DB",
      "database.server.name": "pg-outbox-server",
      "tombstones.on.delete": "false",
      "table.whitelist": "public.outbox",
      "transforms": "outbox",
      "transforms.outbox.type": "com.eresh.outbox.OutboxTransformer"
   }
}'
echo -e "\n-------- Creating Outbox Kafka Connector For Debezium is Completed --------"




