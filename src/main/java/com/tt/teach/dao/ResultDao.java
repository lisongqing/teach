package com.tt.teach.dao;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResultDao {

    @Select("select result.*,student.studentName as studentName,subject.subjectName as subjectName from result,student,subject where result.studentNo = student.studentNo and result.subjectNo = subject.subjectNo order by result.examDate desc")
    List<Result> getResultList();

    @Delete("delete from result where resultNo = #{resultNo}")
    int deleteResult(Integer resultNo);

    @Update("update result set studentResult = #{studentResult} where resultNo = #{resultNo}")
    int updateResult(Result result);

    @Insert("insert into result (studentNo,subjectNo,examDate,studentResult) values (#{studentNo},#{subjectNo},#{examDate},#{studentResult})")
    int addResult(Result result);

    @Select("select * from subject")
    List<Subject> getSubject();
}
