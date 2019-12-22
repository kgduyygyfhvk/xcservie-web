package xyz.xcservice.www.utils;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * @author wuwenchao
 * @date 2019/12/17
 */
@Slf4j
public class ResponseUtil {

    /**
     * 响应返回
     *
     * @param response
     * @param jsonStr
     */
    public static void writer(HttpServletResponse response, String jsonStr) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
            bufferedOutputStream.write(jsonStr.getBytes());
        } catch (IOException e) {
            log.error(Throwables.getStackTraceAsString(e));
        } finally {
            if (Objects.nonNull(bufferedOutputStream)) {
                try {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    log.error(Throwables.getStackTraceAsString(e));
                }
            }
        }
    }
}
