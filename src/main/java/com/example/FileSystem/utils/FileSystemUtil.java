package com.example.FileSystem.utils;

import com.example.FileSystem.model.APIResponseDTO;
import org.modelmapper.ModelMapper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystemUtil {
    public static <S, D> List<D> convertToDtoList(List<S> sourceList, Class<D> destinationType) {

        ModelMapper mapper = new ModelMapper();
        return sourceList.stream().map(item -> {

            return mapper.map(item, destinationType);
        }).collect(Collectors.toList());

    }
    public static <T> T convertToDto(Object entity, Class<T> destinationType) {

        return new ModelMapper().map(entity, destinationType);

    }

    public static <T> T convertToEntity(Object dto, Class<T> destinationType) {
        return new ModelMapper().map(dto, destinationType);
    }
    public static APIResponseDTO prepeareAPIResponse(Object obj) {
        APIResponseDTO apiResponse = new APIResponseDTO();
        apiResponse.setResponseCode("200");
        apiResponse.setResponseMessage("SUCCESS");
        apiResponse.setResponseDate(DateTimeUtils.createDateStringFromDate(new Date()));
        apiResponse.setData(obj);
        return apiResponse;

    }
    public static APIResponseDTO prepeareAPIResponse(String message, Object obj, String code) {
        APIResponseDTO apiResponse = new APIResponseDTO();
        apiResponse.setResponseCode(code);
        apiResponse.setResponseDate(DateTimeUtils.createDateStringFromDate(new Date()));
        apiResponse.setResponseMessage(message);
        apiResponse.setData(obj);
        return apiResponse;

    }

    public static Date getDateWithoutTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getLastSecondDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getDateWithoutTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date getLastSecondDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
