package com.eyeco.genmeserver.common.logging;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.StreamUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CachedHttpRequestServlet extends HttpServletRequestWrapper {

    private final String cachedRequestData;

    public CachedHttpRequestServlet(HttpServletRequest request) throws IOException {
        super(request);
        this.cachedRequestData = requestDataToByte(request);
    }

    private String requestDataToByte(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        byte[] rawData = StreamUtils.copyToByteArray(inputStream);
        return new String(rawData);
    }

    @Override
    public ServletInputStream getInputStream() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                this.cachedRequestData.getBytes(StandardCharsets.UTF_8));
        return new CachedServletInputStream(inputStream);
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    public String getCachedRequestData() {
        return this.cachedRequestData;
    }
}
