package me.cresterida.learning;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.grpc.example.Greeter;
import jakarta.inject.Singleton;

@Singleton
public class ServiceClient
{

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ServiceClient.class);
    @GrpcClient
    Greeter greeter;

    public void sayHello()
    {
        log.info("Sending a greeting");
        log.info(System.getenv("MY_HOST") );
        log.info(System.getenv("GRPC_HOST") );
        String defaultName = "Guest";
        String nameToSend = System.getenv("NAME") != null ? System.getenv("NAME") : defaultName;
        greeter.sayHello(io.quarkus.grpc.example.HelloRequest.newBuilder().setName(nameToSend).build())
                .subscribe().with(reply -> System.out.println(reply.getMessage()));
    }
}
