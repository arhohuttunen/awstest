package example;

import com.github.awstestkit.AwsClient;
import com.github.awstestkit.localstack.junit5.LocalStackTest;
import com.github.awstestkit.sns.junit5.SnsTest;
import com.github.awstestkit.sns.junit5.SnsTopic;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.sns.SnsClient;

import static org.junit.jupiter.api.Assertions.assertFalse;

// tag::user_guide[]
@LocalStackTest
@SnsTest
@SnsTopic("TopicName")
class SnsExtensionTest {
    @Test
    void setupTopics(@AwsClient SnsClient client) {
        assertFalse(client.listTopics().topics().isEmpty());
    }
}
// end::user_guide[]
