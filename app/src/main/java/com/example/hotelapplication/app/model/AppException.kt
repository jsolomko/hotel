package com.example.hotelapplication.app.model

open class AppException : RuntimeException {
    constructor() : super()
}

class EmptyFieldException(
    val field: Field
) : AppException()

class EmailValidationException(
    val field: Field

) : AppException()