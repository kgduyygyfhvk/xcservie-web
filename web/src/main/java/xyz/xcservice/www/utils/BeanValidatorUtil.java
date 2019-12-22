package xyz.xcservice.www.utils;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author wuwenchao
 * @date 2019/12/21
 */
@Component
public class BeanValidatorUtil {

    /**
     * 验证某个bean的参数
     *
     * @throws ValidationException 如果参数校验不成功则抛出此异常
     */
    public static void validate(Validator validator,Object object) {
        //获得验证器
        //执行验证
        Set constraintViolations = validator.validate(object);
        //如果有验证信息，则将第一个取出来包装成异常返回
        ConstraintViolation constraintViolation = getFirst(constraintViolations);
        if (constraintViolation != null) {
            throw new ValidationException(constraintViolation.getMessage());
        }
    }

    public static ConstraintViolation getFirst(Set<ConstraintViolation> constraintViolations) {
        if (constraintViolations == null || constraintViolations.size() == 0) {
            return null;
        }
        return constraintViolations.iterator().next();
    }

}
