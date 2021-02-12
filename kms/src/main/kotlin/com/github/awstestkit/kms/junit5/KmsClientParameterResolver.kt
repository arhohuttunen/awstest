package com.github.awstestkit.kms.junit5

import com.github.awstestkit.SdkClientFactory
import com.github.awstestkit.SdkClientParameterResolver
import software.amazon.awssdk.core.SdkClient
import software.amazon.awssdk.services.kms.KmsAsyncClient
import software.amazon.awssdk.services.kms.KmsClient
import kotlin.reflect.KClass

class KmsClientParameterResolver : SdkClientParameterResolver() {
    override val factories: Map<KClass<out SdkClient>, SdkClientFactory<*, out SdkClient>>

    init {
        factories = mapOf(
            KmsClient::class to KmsClientFactory(KmsClient.builder()),
            KmsAsyncClient::class to KmsAsyncClientFactory(KmsAsyncClient.builder())
        )
    }
}
