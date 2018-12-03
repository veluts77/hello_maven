package org.veluts.hello

import java.time.LocalDateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/")
    fun root() = "This is 'Hello Maven' application!!! Accessed at ${LocalDateTime.now()}."
	
    @GetMapping("/about")
    fun about() = "Created by me!!!"
	
 	@GetMapping("/hello")
    fun hello() = "change by Olja"
}