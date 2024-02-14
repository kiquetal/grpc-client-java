### To run using docker,must provide --network host, to allow access the process runing on localhost

docker run --name grpc-java-client -e MY_HOST=local --network host grpc-java-client  

### TO run locally on linux

export MY_HOST=local
java -jar target/grpc-client-1.0.0-SNAPSHOT-runner.jar
