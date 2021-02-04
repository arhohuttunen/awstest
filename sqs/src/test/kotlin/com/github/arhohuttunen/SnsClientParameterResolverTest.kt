package com.github.arhohuttunen

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.amazon.awssdk.services.sqs.SqsAsyncClient
import software.amazon.awssdk.services.sqs.SqsClient

@ExtendWith(SqsClientParameterResolver::class)
class SnsClientParameterResolverTest {
    @Test
    fun `resolve SQS client as an argument`(@AwsClient sqsClient: SqsClient) {
        assertThat(sqsClient).isNotNull()
    }

    @Test
    fun `resolve SQS async client as an argument`(@AwsClient sqsAsyncClient: SqsAsyncClient) {
        assertThat(sqsAsyncClient).isNotNull()
    }
}