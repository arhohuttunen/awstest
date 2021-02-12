package com.github.awstestkit

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils
import java.util.Optional
import kotlin.reflect.full.createInstance

class AnnotationEndpointResolver : EndpointResolver {
    override fun resolveEndpoint(extensionContext: ExtensionContext): Endpoint {
        val requiredClass = extensionContext.requiredTestClass
        val annotation: Optional<AwsEndpoint> = AnnotationUtils.findAnnotation(requiredClass, AwsEndpoint::class.java)

        return if (annotation.isPresent) {
            annotation.get().endpointResolver.createInstance().resolveEndpoint(extensionContext)
        } else {
            DefaultEndpoint()
        }
    }
}
