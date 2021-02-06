package com.github.awstest.s3.junit5

import com.github.awstest.AwsClientFactory
import com.github.awstest.s3.SimpleS3Client
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.S3ClientBuilder
import java.lang.reflect.AnnotatedElement
import java.util.Optional

class S3SetupExtension : BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {
    private lateinit var s3Client: SimpleS3Client

    override fun beforeAll(context: ExtensionContext) {
        val factory = AwsClientFactory<S3ClientBuilder, S3Client>(S3Client.builder())
        s3Client = SimpleS3Client(factory.create(context) as S3Client)

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
            annotation.get().bucketNames.forEach {
                s3Client.createBucket(it)
            }
            annotation.get().objects.forEach {
                s3Client.putObject(it.bucketName, it.key, it.content)
            }
        }
    }

    private fun deleteResources(annotatedElement: AnnotatedElement) {
        val annotation = findAnnotation(annotatedElement)
        if (annotation.isPresent) {
            annotation.get().objects.forEach {
                s3Client.deleteObject(it.bucketName, it.key)
            }
            annotation.get().bucketNames.forEach {
                s3Client.deleteBucket(it)
            }
        }
    }

    private fun findAnnotation(annotatedElement: AnnotatedElement): Optional<S3Setup> {
        return AnnotationUtils.findAnnotation(annotatedElement, S3Setup::class.java)
    }
}