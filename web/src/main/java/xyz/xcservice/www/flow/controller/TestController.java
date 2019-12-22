package xyz.xcservice.www.flow.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wuwenchao
 * @create 2019/10/26
 */
@RequestMapping("/")
@Controller
@Api(value = "swagger", description = "测试swagger")
public class TestController {

    @ApiIgnore
    @ApiOperation(value = "swagger", notes = "swagger模板", response = String.class )
    @RequestMapping(value = "/swagger",method = {RequestMethod.GET,RequestMethod.POST})
    public String index() {
        return "redirect:swagger-ui.html";
    }


}
