package com.github.awstestkit.dynamodb.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClientBuilder
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder
import software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsAsyncClient
import software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsAsyncClientBuilder
import software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient
import software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClientBuilder

typealias DynamoDbClientFactory =
        SdkClientFactory<DynamoDbClientBuilder, DynamoDbClient>
typealias DynamoDbAsyncClientFactory =
        SdkClientFactory<DynamoDbAsyncClientBuilder, DynamoDbAsyncClient>
typealias DynamoDbStreamsClientFactory =
        SdkClientFactory<DynamoDbStreamsClientBuilder, DynamoDbStreamsClient>
typealias DynamoDbStreamsAsyncClientFactory =
        SdkClientFactory<DynamoDbStreamsAsyncClientBuilder, DynamoDbStreamsAsyncClient>
