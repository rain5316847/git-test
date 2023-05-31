package com.example.fastlocal.utils.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.BoundedInputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

@Slf4j
public class MultiReadHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public static final Integer MAX_BYTE_SIZE = 1_048_576; // 1 MB

    public StringBuilder body;

    public MultiReadHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        body = new StringBuilder();
        try (
                // 将将request的body转换为字节数组并放在缓存区，在转换为“含有读取界限的输入流，超过这个界限读取将会停止”并放在缓存区（BoundedInputStream），大小为1M
                InputStream bounded = new BoundedInputStream(request.getInputStream(), MAX_BYTE_SIZE);
                //将缓存区的字节流转化为字符流，否则不能通过String类型的对象读取
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bounded))){
                String line;
                //读取缓冲区的全部内容
                while ((line = bufferedReader.readLine()) != null) {
                    // log.info("line:{}",line);
                    body.append(line);
                }
        } catch(Exception e) {
             log.error(e.getMessage());
        }
    }

    @Override
    public ServletInputStream getInputStream() {
        //将request的body转换为字节数组放置在字节数组缓存区，从输入流读取的数据（body）保存在该字节数组缓冲区中。
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.toString().getBytes());
        return new ServletInputStream() {
            @Override
            public int read() {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;//byteArrayInputStream.available() == 0
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

}
