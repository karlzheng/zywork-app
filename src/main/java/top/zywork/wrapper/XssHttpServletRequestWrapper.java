package top.zywork.wrapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.HtmlUtils;
import top.zywork.common.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * XssHttpServletRequestWrapper包装类<br/>
 *
 * 创建于2019-01-25<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getHeader(String name) {
        String charset = request.getCharacterEncoding();
        String value = super.getHeader(HtmlUtils.htmlEscape(name, charset));
        if (StringUtils.isNotEmpty(value)) {
            value = HtmlUtils.htmlEscape(value, charset);
        }
        return value;
    }

    @Override
    public String getParameter(String name) {
        String charset = request.getCharacterEncoding();
        String value = super.getParameter(HtmlUtils.htmlEscape(name, charset));
        if (StringUtils.isNotEmpty(value)) {
            value = HtmlUtils.htmlEscape(value, charset);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String charset = request.getCharacterEncoding();
        String[] values = super.getParameterValues(HtmlUtils.htmlEscape(name, charset));
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = HtmlUtils.htmlEscape(values[i], charset);
        }
        return encodedValues;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public Map getParameterMap() {
        String charset = request.getCharacterEncoding();
        Map<String, String[]> paramMap = super.getParameterMap();
        Map<String, String[]> newParamMap = new HashMap<>(paramMap.size());
        for (Iterator iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String[]> entry = (Map.Entry) iterator.next();
            String key = entry.getKey();
            String[] values = entry.getValue();
            for (int i = 0; i < values.length; i++) {
                if (StringUtils.isNotEmpty(values[i])) {
                    values[i] = HtmlUtils.htmlEscape(values[i], charset);
                }
            }
            newParamMap.put(key, values);
        }
        return newParamMap;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        String charset = request.getCharacterEncoding();
        ServletInputStream servletInputStream = super.getInputStream();
        String text = IOUtils.getText(servletInputStream, charset);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(HtmlUtils.htmlEscape(text, charset)
                .replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'").getBytes());
        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) { }
        };
    }
}