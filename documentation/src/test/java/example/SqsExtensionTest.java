package example;

import com.github.awstestkit.AwsClient;
import com.github.awstestkit.localstack.junit5.LocalStackTest;
import com.github.awstestkit.sqs.junit5.SqsQueue;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.localstack.LocalStackContainer;
import software.amazon.awssdk.services.sqs.SqsClient;

import static org.junit.jupiter.api.Assertions.assertFalse;

// tag::user_guide[]
@LocalStackTest(services = LocalStackContainer.Service.SQS)
@SqsQueue("QueueName")
class SqsExtensionTest {
    @Test
    void setupQueues(@AwsClient SqsClient client) {
        assertFalse(client.listQueues().queueUrls().isEmpty());
    }
}
// end::user_guide[]
