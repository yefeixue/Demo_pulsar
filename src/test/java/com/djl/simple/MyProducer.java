package com.djl.simple;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

/**
 * @description:
 * @author: 丁金龙
 * @create: 2019-05-26 17:09
 **/
public class MyProducer {

  public static void main(String[] args) throws PulsarClientException {
    String localClusterUrl = "pulsar://localhost:6650";

    PulsarClient client = PulsarClient.builder().serviceUrl(localClusterUrl).build();
    Producer<byte[]> producer = client.newProducer().topic(Config.topciName).create();
    for (int i = 0; i < 10; i++) {
      String msg = "hello world "+ i;
      producer.send(msg.getBytes());
    }
  }
}
