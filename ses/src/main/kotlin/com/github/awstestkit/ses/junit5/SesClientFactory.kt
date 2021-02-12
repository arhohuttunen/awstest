package com.github.awstestkit.ses.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.ses.SesAsyncClient
import software.amazon.awssdk.services.ses.SesAsyncClientBuilder
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.ses.SesClientBuilder

typealias SesClientFactory = SdkClientFactory<SesClientBuilder, SesClient>
typealias SesAsyncClientFactory = SdkClientFactory<SesAsyncClientBuilder, SesAsyncClient>
