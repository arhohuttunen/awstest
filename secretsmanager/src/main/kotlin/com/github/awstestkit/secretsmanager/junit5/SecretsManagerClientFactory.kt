package com.github.awstestkit.secretsmanager.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.secretsmanager.SecretsManagerAsyncClient
import software.amazon.awssdk.services.secretsmanager.SecretsManagerAsyncClientBuilder
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClientBuilder

typealias SecretsManagerClientFactory =
        SdkClientFactory<SecretsManagerClientBuilder, SecretsManagerClient>
typealias SecretsManagerAsyncClientFactory =
        SdkClientFactory<SecretsManagerAsyncClientBuilder, SecretsManagerAsyncClient>
