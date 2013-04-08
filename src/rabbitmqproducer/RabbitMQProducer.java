package rabbitmqproducer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.*;
import java.io.IOException;

/**
 *
 * @author skuarch
 */
public class RabbitMQProducer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("192.168.208.9");
        factory.setPort(5672);
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        String exchangeName = "myExchange";
        String routingKey = "testRoute";
        byte[] messageBodyBytes = "joidete pinche perro !!!!!".getBytes();
        channel.basicPublish(exchangeName, routingKey, MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes);
        channel.close();
        conn.close();
    }
}
