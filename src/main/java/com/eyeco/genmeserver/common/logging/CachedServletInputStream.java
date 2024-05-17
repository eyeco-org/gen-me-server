package com.eyeco.genmeserver.common.logging;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CachedServletInputStream extends ServletInputStream {

    private final ByteArrayInputStream inputStream;

    @Override
    public boolean isFinished() {
        return inputStream.available() == 0;
    }

    @Override
    public boolean isReady() {
        return inputStream.available() != 0;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        throw new UnsupportedOperationException("비동기 읽기는 이 클래스에서 지원되지 않습니다.");
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    public CachedServletInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }
}
