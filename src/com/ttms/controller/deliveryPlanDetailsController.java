/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.controller;

import com.ttms.daoimpl.deliveryPlanDetailDaoImpl;
import com.ttms.model.deliveryPlanDetails;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class deliveryPlanDetailsController {

    public static ResultSet getAllDeliveryPlanDetails() throws SQLException {
        return new deliveryPlanDetailDaoImpl().getAllDeliveryPlanDetails();
    }

    public static ResultSet getAllOrderedDeliveryPlanDetails() throws SQLException {
        return new deliveryPlanDetailDaoImpl().getAllOrderedDeliveryPlanDetails();
    }

    public static ResultSet getDeliveryPlanDetailByOneAttribute(String attribute,
            String condition, String value) throws SQLException {
        return new deliveryPlanDetailDaoImpl().getDeliveryPlanDetailsByOneAttribute(attribute, condition, value);
    }

    public static ResultSet getDeliveryPlanDetailsByMoreAttributes(ArrayList<String[]> attributeConditionValueList,
            String operator) throws SQLException {
        return new deliveryPlanDetailDaoImpl().getDeliveryPlanDetailsByMoreAttributes(
                attributeConditionValueList, operator);
    }

    public static boolean addDeliveryPlanDetailRecord(String day, int deliveryPlanId,
            String remark, int timeOrderNo, Date timeTableDate, String time, String level,
            String moduleName, String modleCode, String type, String lecturerName,
            String roomName, String courseName, String groupName,
            String lectureStartTime, String duration, String lectueEndTime) throws SQLException {

        deliveryPlanDetails planDetails = new deliveryPlanDetails();

        planDetails.setDeliveryPlanid(deliveryPlanId);
        planDetails.setDate(timeTableDate);
        planDetails.setTimeString(time);
        planDetails.setTimeOrder(timeOrderNo);
        planDetails.setStatus(1);
        planDetails.setRemark(remark);
        planDetails.setDay(day);
        planDetails.setLevel(level);
        planDetails.setModueName(moduleName);
        planDetails.setModuleCode(modleCode);
        planDetails.setType(type);
        planDetails.setLecturerName(lecturerName);
        planDetails.setRoomName(roomName);
        planDetails.setCourseName(courseName);
        planDetails.setGroupName(groupName);
        planDetails.setLectureStartTime(java.sql.Time.valueOf(lectureStartTime));
        planDetails.setDuration(duration);
        planDetails.setLectureEndTime(commonController.getMysqlEndTimeFromStartTimeAndTimeGap(lectureStartTime, duration));

        return new deliveryPlanDetailDaoImpl().addDeliveryPlanDetailRecord(planDetails);
    }

    public static int getNextTimeOrderNo(Date date) throws SQLException {
        return new deliveryPlanDetailDaoImpl().getNextTimeOrderNo(date);
    }

    public static boolean isRecordAvailableInDeliveryPlanDetailUiTable(Date SelectedDate, 
            String LectureStartTime, String Level, String Location, String LecName) throws SQLException {
        boolean status = false;
        ResultSet rset = new deliveryPlanDetailDaoImpl().isRecordAvailableInDeliveryPlanDetailUiTable(SelectedDate, 
                LectureStartTime, Level, Location, LecName);
        if (rset.next()) {
            status = true;
        }
        return status;
    }

}
