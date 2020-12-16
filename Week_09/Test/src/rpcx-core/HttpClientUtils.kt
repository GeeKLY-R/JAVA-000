package `rpcx-core`

import lombok.extern.slf4j.Slf4j

import org.apache.http.client.config.RequestConfig

import org.apache.http.client.methods.CloseableHttpResponse

import org.apache.http.client.methods.HttpPost

import org.apache.http.entity.StringEntity

import org.apache.http.impl.client.CloseableHttpClient

import org.apache.http.impl.client.HttpClients

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager

import org.apache.http.protocol.HTTP

import org.apache.http.util.EntityUtils


import java.nio.charset.StandardCharsets

/**
 * @PROJECT_NAME: rpcfx
 * @PACKAGE_NAME: io.kimmking.rpcfx.api
 * @NAME: HttpClientUtils
 * @Author: guanys
 * @DATE: 12/16/20:5:04 PM
 * @Description: TODO
 * @Version: 1.0
 */
object HttpClientUtils {
    private var httpClient: CloseableHttpClient? = null
    private const val CONNECT_TIMEOUT = 5000
    private var requestConfig: RequestConfig? = null
    fun httpPostJson(json: String?, url: String?): String {
        val httpPost = HttpPost(url)
        httpPost.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE)
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8")
        val requestEntity = StringEntity(json, StandardCharsets.UTF_8)
        httpPost.setEntity(requestEntity)
        return try {
            val response: CloseableHttpResponse = httpClient.execute(httpPost)
            EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8)
        } catch (e: Exception) {
            throw RpcfxException("httpclient请求失败!")
        }
    }

    init {
        val connectionManager = PoolingHttpClientConnectionManager()
        connectionManager.setMaxTotal(500)
        connectionManager.setDefaultMaxPerRoute(50)
        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(CONNECT_TIMEOUT).build()
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build()
    }
}