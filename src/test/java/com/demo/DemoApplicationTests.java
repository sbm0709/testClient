package com.demo;

import com.demo.service.RestTemplateService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    RestTemplateService restTemplateService;


    @Test
    void contextLoads() {
       log.error(restTemplateService.getShoplist("1", "5"));
    }

}
