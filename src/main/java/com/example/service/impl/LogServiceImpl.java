package com.example.service.impl;

import com.example.service.LogService;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LogServiceImpl implements LogService {

    private final ResourceLoader resourceLoader;
    private static final String LOG_PATH = "classpath:logs/";

    public LogServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Result getLogList() {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader);
            Resource[] resources = resolver.getResources(LOG_PATH + "*.log");
            List<String> fileList = new ArrayList<>();
            for (Resource resource : resources) {
                String filename = resource.getFilename();
                if (filename != null) {
                    fileList.add(filename);
                }
            }
            return Result.success(fileList);
        } catch (IOException e) {
            log.error("获取日志列表失败: {}", e.getMessage());
            return Result.error("获取日志列表失败");
        }
    }

    @Override
    public void getLogDetail(String name, HttpServletResponse response) {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader);
            Resource resource = resolver.getResource(LOG_PATH + name + ".log");

            if (!resource.exists()) {
                log.warn("日志文件不存在: {}", name);
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "日志文件不存在");
                return;
            }

            if (!resource.isReadable()) {
                log.warn("日志文件不可读: {}", name);
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "日志文件不可读");
                return;
            }

            // 设置响应头
            response.setContentType("text/plain;charset=UTF-8");
            response.setHeader("Content-Disposition", "inline; filename=" + name + ".log");

            // 读取并写入响应
            try (InputStream is = resource.getInputStream();
                 OutputStream os = response.getOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.flush();
            }
        } catch (IOException e) {
            log.error("读取日志文件失败: {}", e.getMessage());
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "读取日志文件失败");
            } catch (IOException ex) {
                log.error("发送错误响应失败", ex);
            }
        }
    }
}