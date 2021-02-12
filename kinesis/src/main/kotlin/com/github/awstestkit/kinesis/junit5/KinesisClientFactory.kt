package com.github.awstestkit.kinesis.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient
import software.amazon.awssdk.services.kinesis.KinesisAsyncClientBuilder
import software.amazon.awssdk.services.kinesis.KinesisClient
import software.amazon.awssdk.services.kinesis.KinesisClientBuilder

typealias KinesisClientFactory = SdkClientFactory<KinesisClientBuilder, KinesisClient>
typealias KinesisAsyncClientFactory = SdkClientFactory<KinesisAsyncClientBuilder, KinesisAsyncClient>
