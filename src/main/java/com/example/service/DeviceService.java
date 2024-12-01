package com.example.service;

import com.example.entity.Devices;
import com.example.utils.Result;

public interface DeviceService {
    /**
     * 获取设备列表
     * @return
     */
    Result getDevices();

    /**
     * 更新设备
     * @param device
     * @return
     */
    Result updateDevice(Devices device);

    /**
     * 添加设备
     * @param device
     * @return
     */
    Result addDevice(Devices device);

    /**
     * 根据id获取设备
     * @param id
     * @return
     */
    Result getDeviceById(Long id);

    /**
     * 删除设备
     * @param id
     * @return
     */
    Result deleteDevice(Long id);

    /**
     * 查询设备
     * @param deviceName
     * @param deviceType
     * @return
     */
    Result query(String deviceName, String deviceType);
}
