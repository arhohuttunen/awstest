package com.github.awstestkit.sns.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.sns.SnsAsyncClient
import software.amazon.awssdk.services.sns.SnsAsyncClientBuilder
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sns.SnsClientBuilder

typealias SnsClientFactory = SdkClientFactory<SnsClientBuilder, SnsClient>
typealias SnsAsyncClientFactory = SdkClientFactory<SnsAsyncClientBuilder, SnsAsyncClient>
