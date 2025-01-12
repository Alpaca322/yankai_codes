package com.example.service;

import com.example.utils.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

public interface LogService {
    Result getLogList();
    void getLogDetail(String name, HttpServletResponse response);
}