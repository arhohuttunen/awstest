package com.github.awstestkit.cloudformation.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.cloudformation.CloudFormationAsyncClient
import software.amazon.awssdk.services.cloudformation.CloudFormationAsyncClientBuilder
import software.amazon.awssdk.services.cloudformation.CloudFormationClient
import software.amazon.awssdk.services.cloudformation.CloudFormationClientBuilder

typealias CloudFormationClientFactory =
        SdkClientFactory<CloudFormationClientBuilder, CloudFormationClient>
typealias CloudFormationAsyncClientFactory =
        SdkClientFactory<CloudFormationAsyncClientBuilder, CloudFormationAsyncClient>
