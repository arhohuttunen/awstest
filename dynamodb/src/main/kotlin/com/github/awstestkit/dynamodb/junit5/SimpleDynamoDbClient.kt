package com.github.awstestkit.dynamodb.junit5

import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition
import software.amazon.awssdk.services.dynamodb.model.BillingMode
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest
import software.amazon.awssdk.services.dynamodb.model.DeleteTableRequest
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement
import software.amazon.awssdk.services.dynamodb.model.KeyType
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType

class SimpleDynamoDbClient(private val dynamoDbClient: DynamoDbClient) {
    fun createTable(name: String, keys: Map<String, KeyType>, attributeDefinitions: Map<String, ScalarAttributeType>) {
        val requestBuilder = CreateTableRequest.builder()
            .tableName(name)

        attributeDefinitions.forEach { (name, type) ->
            requestBuilder
                .attributeDefinitions(
                    AttributeDefinition.builder()
                        .attributeName(name)
                        .attributeType(type)
                        .build()
                )
        }

        keys.forEach { (name, type) ->
            requestBuilder
                .keySchema(
                    KeySchemaElement.builder()
                        .attributeName(name)
                        .keyType(type)
                        .build()
                )
        }
        requestBuilder.billingMode(BillingMode.PAY_PER_REQUEST)

        dynamoDbClient.createTable(requestBuilder.build())
    }

    fun deleteTable(name: String) {
        val request = DeleteTableRequest.builder()
            .tableName(name)
            .build()
        dynamoDbClient.deleteTable(request)
    }
}
