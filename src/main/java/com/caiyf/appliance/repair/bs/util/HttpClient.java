package com.caiyf.appliance.repair.bs.util;

import com.caiyf.appliance.repair.bs.exception.BusinessException;
import com.caiyf.appliance.repair.bs.model.result.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.net.URI;

/**
 * @desc http请求工具
 * @date 2019/05/10
 * @author caiyf
 */
@Slf4j
public class HttpClient {

    /** 编码格式。发送编码格式统一用UTF-8 */
    private static final String ENCODING = "UTF-8";
    /** 设置连接超时时间，单位毫秒 */
    private static final Integer CONNECT_TIMEOUT = 6000;
    /** 请求获取数据的超时时间(即响应时间)，单位毫秒 */
    private static final Integer SOCKET_TIMEOUT = 6000;
    /** 成功码 */
    private static final Integer OK = 200;

    /**
     * get方法
     * @param uri
     * @return
     */
    public static JSONObject doGet(String uri) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = null;
        JSONObject jsonObject = null;
        try {
            URIBuilder builder = new URIBuilder(uri);
            URI httpUri = builder.build();
            HttpGet httpGet = new HttpGet(httpUri);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() != OK) {
                log.error("[get-code-error], error code: {}", response.getStatusLine().getStatusCode());
                throw new BusinessException(CodeEnum.GET_CODE_ERROR);
            }
            resultString = EntityUtils.toString(response.getEntity(), ENCODING);
            jsonObject = new JSONObject(resultString);
        } catch (Exception e) {
            log.error("[http-get-error]", e);
            throw new BusinessException(CodeEnum.HTTP_GET_ERROR, e);
        }
        return jsonObject;
    }

}
