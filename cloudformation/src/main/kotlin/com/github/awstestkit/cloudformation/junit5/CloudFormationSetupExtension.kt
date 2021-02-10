package com.github.awstestkit.cloudformation.junit5

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils
import software.amazon.awssdk.services.cloudformation.CloudFormationClient
import java.lang.reflect.AnnotatedElement
import java.util.Optional

class CloudFormationSetupExtension : BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {
    private lateinit var cloudFormationClient: SimpleCloudFormationClient

    override fun beforeAll(context: ExtensionContext) {
        val factory = CloudFormationClientFactory(CloudFormationClient.builder())
        cloudFormationClient = SimpleCloudFormationClient(factory.create(context))

        createResources(context.requiredTestClass)
    }

    override fun afterAll(context: ExtensionContext) {
        deleteResources(context.requiredTestClass)
    }

    override fun beforeEach(context: ExtensionContext) {
        createResources(context.requiredTestMethod)
    }

    override fun afterEach(context: ExtensionContext) {
        deleteResources(context.requiredTestMethod)
    }

    private fun createResources(annotatedElement: AnnotatedElement) {
        val annotation = findAnnotation(annotatedElement)
        if (annotation.isPresent) {
            annotation.get().stacks.forEach {
                cloudFormationClient.createStack(it.stackName, it.templateFile)
            }
        }
    }

    private fun deleteResources(annotatedElement: AnnotatedElement) {
        val annotation = findAnnotation(annotatedElement)
        if (annotation.isPresent) {
            annotation.get().stacks.forEach {
                cloudFormationClient.deleteStack(it.stackName)
            }
        }
    }

    private fun findAnnotation(annotatedElement: AnnotatedElement): Optional<CloudFormationSetup> {
        return AnnotationUtils.findAnnotation(annotatedElement, CloudFormationSetup::class.java)
    }
}
