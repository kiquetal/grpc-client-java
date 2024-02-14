### To run using docker,must provide --network host, to allow access the process runing on localhost

docker run --name grpc-java-client -e MY_HOST=local --network host grpc-java-client  
