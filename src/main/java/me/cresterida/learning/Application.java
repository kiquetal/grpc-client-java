package me.cresterida.learning;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Application
{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Application.class);
    public static void main(String[] args)
    {

        Quarkus.run(MyApp.class,
                (exitCode,exception) -> {

                },args);




    }
    public static class MyApp implements QuarkusApplication
    {

        @Inject
        ServiceClient serviceClient;
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Do startup logic here");
            serviceClient.sayHello();

            Quarkus.waitForExit();
            return 0;
        }
    }
}
