package com.example.mapper;

import com.example.entity.Devices;
import com.example.utils.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeviceMapper {

    /**
     * 获取设备列表
     * @return
     */
    @Select("select * from Devices")
    List<Devices> getDevices();

    /**
     * 删除设备
     * @param id
     */
    @Delete("delete from Devices where DeviceID = #{id}")
    void deleteDevice(Long id);

    void updateDevice(Devices device);

    @Insert("insert into Devices(DeviceID, DeviceType, DeviceName, Status, LastMaintenance, FirmwareVersion) values(#{DeviceID}, #{DeviceType}, #{DeviceName}, #{Status}, #{LastMaintenance}, #{FirmwareVersion})")
    void addDevice(Devices device);

    List<Devices> query(Devices device);
}
