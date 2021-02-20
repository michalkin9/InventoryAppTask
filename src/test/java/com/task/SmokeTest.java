package com.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
//check if the build is stable
@SpringBootTest
public class SmokeTest {

    @Autowired
    private InventoryController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
