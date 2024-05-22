package com.medicalpractitioner.mapper;

import com.medicalpractitioner.entity.Doctor;
import com.medicalpractitioner.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DoctorMapper {
     Doctor queryInfo(@Param("doctorId") int doctorId);

     int quaryAppointmentPatientNum(@Param("doctorId") int doctorId);
     List<Record> selectRecordByTimeIdAndDcotorIdAndDate(@Param("doctorId") int doctorId ,
                                                               @Param("timeId") int timeId,
                                                               @Param("date") LocalDate date,
                                                         @Param("status")int status);
    // 查询医生可用的时间段
    List<Integer> selectAValiableTimeLine(@Param("doctorId") int doctorId);
    boolean insertRecord(Record rcd);
    boolean updateInfo(Doctor doctor,@Param("paramId") int doctorId);
    boolean updateModifyRight(@Param("flag") int right,@Param("doctorId") int doctorId );
    boolean updateAppointmentRight(@Param("flag") int right,@Param("doctorId") int doctorId );
    List<Record> queryRecord(@Param("doctorId") int doctorId);
    boolean updatePatientNum(@Param("num")int num,@Param("doctorId")int doctorId);
    boolean updateRecordStaus(@Param("recordIdx")int recordIdx,@Param("flag") int flag);
    List<Integer> findDoctorTimeLine(@Param("timeId") int timeId,@Param("doctorId") int doctorId);
    boolean addDoctorTimeLine(@Param("timeId") int timeId,@Param("doctorId") int doctorId);
    boolean deleteDoctorTimeLine(@Param("timeId") int timeId,@Param("doctorId") int doctorId);
}
