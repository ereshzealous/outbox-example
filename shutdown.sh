echo -e "\nStopping containers ....."
docker stop $(docker ps -a | grep outbox* | cut -d ' ' -f 1)
docker stop $(docker ps -a | grep outbox-example_postgres_1 | cut -d ' ' -f 1)
docker stop $(docker ps -a | grep kafka* | cut -d ' ' -f 1)
docker stop $(docker ps -a | grep zookeeper | cut -d ' ' -f 1)
docker rmi -f outbox-example_postgres
docker rmi -f *kafka*
docker rmi -f zookeeper*
echo -e "\nAll Containers stopped."