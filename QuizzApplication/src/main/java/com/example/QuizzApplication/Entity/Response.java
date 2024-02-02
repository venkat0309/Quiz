package com.example.QuizzApplication.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.StringReader;

@Data
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response;
}
