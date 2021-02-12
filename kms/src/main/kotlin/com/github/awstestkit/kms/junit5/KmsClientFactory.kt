package com.github.awstestkit.kms.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.kms.KmsAsyncClient
import software.amazon.awssdk.services.kms.KmsAsyncClientBuilder
import software.amazon.awssdk.services.kms.KmsClient
import software.amazon.awssdk.services.kms.KmsClientBuilder

typealias KmsClientFactory = SdkClientFactory<KmsClientBuilder, KmsClient>
typealias KmsAsyncClientFactory = SdkClientFactory<KmsAsyncClientBuilder, KmsAsyncClient>
