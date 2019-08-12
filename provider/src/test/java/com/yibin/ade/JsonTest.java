package com.yibin.ade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yibin.ade.biz.vo.UserVo;
import com.yibin.ade.commonn.utils.JsonUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @author yibin.zou Date: 2019/8/12 Time: 8:40 PM
 */
public class JsonTest {

    @Test
    public void test() throws JsonProcessingException {

        UserVo vo = UserVo.builder().nickName("111").userCode("3123").build();
        System.out.println(JsonUtil.toJson(new Date()));
    }
}
