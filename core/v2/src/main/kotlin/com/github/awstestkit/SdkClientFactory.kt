package com.github.awstestkit

import org.junit.jupiter.api.extension.ExtensionContext
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.awscore.client.builder.AwsClientBuilder
import software.amazon.awssdk.core.SdkClient
import software.amazon.awssdk.regions.Region

class SdkClientFactory<T : AwsClientBuilder<T, U>, U : SdkClient>(
    private val awsClientBuilder: AwsClientBuilder<T, U>
) {
    private val endpointResolver = AnnotationEndpointResolver()

    fun create(extensionContext: ExtensionContext): U {
        val endpoint = endpointResolver.resolveEndpoint(extensionContext)

        return awsClientBuilder
            .endpointOverride(endpoint.url())
            .region(Region.of(endpoint.region()))
            .credentialsProvider(
                StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(endpoint.accessKey(), endpoint.secretKey())
                )
            )
            .build()
    }
}
