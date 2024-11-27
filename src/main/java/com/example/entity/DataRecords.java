package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataRecords {

    private int RecordID;

    private String RecordType;

    private String Data;

    private LocalDateTime CreatedAt;

    private LocalDateTime UpdatedAt;

//    public int getRecordID() {
//        return RecordID;
//    }
//
//    public void setRecordID(int recordID) {
//        RecordID = recordID;
//    }
//
//    public String getRecordType() {
//        return RecordType;
//    }
//
//    public void setRecordType(String recordType) {
//        RecordType = recordType;
//    }
//
//    public String getData() {
//        return Data;
//    }
//
//    public void setData(String data) {
//        Data = data;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return CreatedAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        CreatedAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return UpdatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        UpdatedAt = updatedAt;
//    }
//
//    @Override
//    public String toString() {
//        return "DataRecords{" +
//                "RecordID=" + RecordID +
//                ", RecordType='" + RecordType + '\'' +
//                ", Data='" + Data + '\'' +
//                ", CreatedAt=" + CreatedAt +
//                ", UpdatedAt=" + UpdatedAt +
//                '}';
//    }
}
