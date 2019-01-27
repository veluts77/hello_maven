package org.veluts.hello

import org.assertj.core.api.Assertions.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.*
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.boot.test.web.client.TestRestTemplate


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloApplicationTests {

    @Autowired
    lateinit var controller: HelloController

    @LocalServerPort
    var port: Int = 0

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun contextLoads() {
        assertThat(controller).isNotNull
    }

    @Test
    @Throws(Exception::class)
    fun defaultShouldReturnDefaultMessage() {
        assertThat(endpoint("")).startsWith("This is 'Hello Maven' application!!!")
    }

    @Test
    @Throws(Exception::class)
    fun aboutShouldReturnDefaultMessage() {
        assertThat(endpoint("about")).doesNotStartWith("Created by")
    }

    private fun endpoint(name: String) = restTemplate.getForObject("http://localhost:$port/$name",
            String::class.java)
}
