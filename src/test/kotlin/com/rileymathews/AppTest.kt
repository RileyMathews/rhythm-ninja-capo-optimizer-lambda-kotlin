package com.rileymathews

import com.amazonaws.services.lambda.runtime.ClientContext
import com.amazonaws.services.lambda.runtime.CognitoIdentity
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent
import kotlin.test.Test
import kotlin.test.assertEquals

class AppTest {
    @Test fun testAppCanRunEndToEnd() {
        val app = App()
        val request = APIGatewayV2ProxyRequestEvent()
        request.queryStringParameters = mapOf("keys" to "Ab,Bb")

        val actual = app.handleRequest(request, MockContext())

        assertEquals("application/json", actual.headers["Content-Type"])
        assertEquals(true, actual.body.contains("root\":\"G\""))
    }
}

class MockContext : Context {
    override fun getAwsRequestId(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLogStreamName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getClientContext(): ClientContext {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFunctionName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRemainingTimeInMillis(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLogger(): LambdaLogger {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInvokedFunctionArn(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMemoryLimitInMB(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLogGroupName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFunctionVersion(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIdentity(): CognitoIdentity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
