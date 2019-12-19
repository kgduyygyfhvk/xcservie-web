package xyz.xcservice.www.utils;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            writer = response.getWriter();
            writer.write(jsonStr);
        } catch (IOException e) {
            log.info("系统异常{}", Throwables.getStackTraceAsString(e));
        } finally {
            writer.close();
        }
    }
}
