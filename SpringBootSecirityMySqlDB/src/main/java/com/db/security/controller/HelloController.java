package com.db.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloController {
	
    @ApiOperation(value = "getAll", notes="api accessible to all users without any security")	
    @GetMapping("/all")
    public String hello() {
        return "Hello All users, This is accessable to all";
    }
    
    @ApiOperation(value = "securedAll", notes="api accessible to only authenticated users having ADMIN level Authorization")	
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @ApiOperation(value = "securedAlternate", notes="api accessible to only authenticated users having any role(level of athorization)")	
    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

}
