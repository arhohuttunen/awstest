package com.github.arhohuttunen

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AwsEndpoint(val endpointResolver: KClass<out EndpointResolver>)
