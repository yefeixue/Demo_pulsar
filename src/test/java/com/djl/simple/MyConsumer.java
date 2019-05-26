package com.djl.simple;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

/**
 * @description:
 * @author: 丁金龙
 * @create: 2019-05-26 17:29
 **/
public class MyConsumer {

  public static void main(String[] args) throws PulsarClientException {
    String localClusterUrl = "pulsar://localhost:6650";

    PulsarClient client = PulsarClient.builder().serviceUrl(localClusterUrl).build();

    Consumer consumer = client.newConsumer()
        .topic(Config.topciName)
        .subscriptionName("my-subscription1")
        .subscribe();

    while (true){
      Message receive = consumer.receive();
      System.out.println(new String(receive.getData()));
      consumer.acknowledge(receive);
    }
  }
}
