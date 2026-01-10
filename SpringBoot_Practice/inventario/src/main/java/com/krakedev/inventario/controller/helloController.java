package com.krakedev.inventario.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


/*RestController
 * Es un anotación de Spring que marca una clase como un controlador REST.
 * Esto permite que la clase maneje solicitudes HTTP y devuelva respuestas en formato JSON.
 */
//@RestController
//@RequestMapping("/mycontroller")
public class helloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
