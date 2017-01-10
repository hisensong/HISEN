package com.dmall.hisen.dubbo.comsumer;

import com.dmall.hisen.dubbo.service.api.DemoApi;
import com.dmall.hisen.dubbo.service.api.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2017/1/10 19:29
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoApi demoApi;

    @ResponseBody
    @RequestMapping(value="/query", method= RequestMethod.GET)
    public String demoQuery(DemoEntity demoEntity){
        return demoApi.demoQuery(demoEntity);
    }

}
