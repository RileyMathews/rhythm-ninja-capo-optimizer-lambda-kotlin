package com.rileymathews

import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyResponseEvent
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.Context
import com.google.gson.Gson
import com.rileymathews.models.Key
import com.rileymathews.models.Song
import com.rileymathews.services.CapoService

class App : RequestHandler<APIGatewayV2ProxyRequestEvent, APIGatewayV2ProxyResponseEvent> {
    override fun handleRequest(event: APIGatewayV2ProxyRequestEvent, context: Context): APIGatewayV2ProxyResponseEvent {
        val keysParam = event.queryStringParameters["keys"] ?: throw RuntimeException("no keys given")
        val keys = keysParam.split(",").map { Key.fromRoot(it) }
        val song = Song(keys)
        val transpositionOptions = CapoService(song).optimize()
        val response = APIGatewayV2ProxyResponseEvent()
        val gson = Gson()
        response.body = gson.toJson(transpositionOptions)
        response.headers = mapOf("Access-Control-Allow-Origin" to "*")
        response.statusCode = 200
        return response
    }
}
