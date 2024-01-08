package org.example.config;
import org.apache.camel.builder.RouteBuilder;



public class CamelRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        //persist queue with 1000
        from("direct:topic1")
                .log("message recevie in seda ")
                .to("seda:eventQueue");
        // Consume event from SEDA and publish to Kafka
        from("seda:eventQueue")
                .log("message get from seda ")
                .process(t->{
                    //set for before process
                    var body =(String) t.getIn().getBody();
                    log.info("before process comes here for ... : {}" , body );

                })
                .to("kafka:topic1?brokers=localhost:9092")
                .errorHandler(defaultErrorHandler()
                        .onExceptionOccurred(p->{
                            //process if exception happen
                            log.info("process if exception goes here ...");})
                        .maximumRedeliveries(3))
                .process(exchange -> {
                    // set for after process
                    log.info("post process goes here after put kafka from seda successfully {}" , exchange.getIn().getBody().toString());

                });



    }

}
