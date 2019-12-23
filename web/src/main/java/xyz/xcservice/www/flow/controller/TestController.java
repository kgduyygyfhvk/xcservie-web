package xyz.xcservice.www.flow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import xyz.xcservice.www.dto.UserDetailDTO;
import xyz.xcservice.www.dto.base.ResultResponse;
import xyz.xcservice.www.flow.entity.UserLoginPO;
import xyz.xcservice.www.flow.mapper.UserLoginMapper;
import xyz.xcservice.www.flow.service.UserLoginService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wuwenchao
 * @create 2019/10/26
 */
@RequestMapping("/")
@Controller
@Api(value = "swagger", description = "测试swagger")
public class TestController {
    @Resource
    private UserLoginService userLoginService;
    @Resource
    private UserLoginMapper userLoginMapper;


    @ApiIgnore
    @ApiOperation(value = "swagger", notes = "swagger模板", response = String.class )
    @RequestMapping(value = "/swagger",method = {RequestMethod.GET,RequestMethod.POST})
    public String index() {
        return "redirect:swagger-ui.html";
    }

    @PostMapping("/page")
    @ResponseBody
    @ApiOperation(value = "登录接口分页查询",  response = ResultResponse.class)
    public ResultResponse<Map<String, Object>> page(@RequestBody UserDetailDTO userDetailDTO) {
        Integer pageNo = Integer.valueOf(1);
        Integer pageSize = Integer.valueOf(10);
        IPage<UserLoginPO> page = new Page<>(pageNo, pageSize);
        IPage<Map<String, Object>> result = userLoginService.pageMaps(page,Wrappers.<UserLoginPO>lambdaQuery().eq(UserLoginPO::getLoginCode, userDetailDTO.getLoginCode()));
        return new ResultResponse(result);
    }
}
