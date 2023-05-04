package com.liuhf.user.service.zeususerserivce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZeusUserApplicationTests {

    @Test
    void contextLoads() {
        int a =1;
        System.out.println(a++);
        System.out.println(">>>>");
        int b=1;
        System.out.println(++b);
    }

}
