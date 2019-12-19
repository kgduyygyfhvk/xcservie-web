package xyz.xcservice.www.config;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * 校验数据源是否正确
 *
 * @author wuwenchao
 * @create 2019/12/16
 **/
@Component
@Slf4j
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            context = applicationContext;
            log.info("数据库连接开始");
            DataSource dataSource = (DataSource) context.getBean("dataSource");
            dataSource.getConnection().close();
            log.info("数据库连接结束");
        } catch (Exception e) {
            log.error("数据库连接异常:{}", Throwables.getStackTraceAsString(e));
            // ===== 当检测数据库连接失败时, 停止项目启动
            System.exit(-1);
        }
    }
}

