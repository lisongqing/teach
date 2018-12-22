package com.tt.teach.controller;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/sub")
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    @RequestMapping(value = "/subject")
    public String subject(Model model) {
        List<Grade> list = subjectService.getGrade();
        model.addAttribute("gradeList",list);
        return "/subject/subject";
    }

    @RequestMapping(value = "/getSubjectList",method = RequestMethod.GET)
    public @ResponseBody Object getSubjectList() {
        List<Subject> list = subjectService.getSubjectList();
        return list;
    }

    //删除
    @RequestMapping(value = "/deleteSubject/{subjectNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteSubject(@PathVariable Integer subjectNo) {
        int result = subjectService.deleteSubject(subjectNo);
        if (result>0){
            return JsonResult.ok("删除成功",result);
        }
        return JsonResult.no("删除失败",result);
    }

    //修改
    @RequestMapping(value = "/updateSubject",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateSubject(@RequestParam Integer subjectNo,@RequestParam String subjectName,@RequestParam Integer classHour) {
        Subject subject = new Subject();
        subject.setSubjectNo(subjectNo);
        subject.setSubjectName(subjectName);
        subject.setClassHour(classHour);
        int result = subjectService.updateSubject(subject);
        if (result>0){
            return JsonResult.ok("修改成功",result);
        }
        return JsonResult.no("修改失败",result);
    }

//    添加
    @RequestMapping(value = "addSubject",method = RequestMethod.PUT)
    @ResponseBody
    public Object addSubject(@RequestParam String subjectName, @RequestParam Integer classHour, @RequestParam Integer gradeID) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subject.setClassHour(classHour);
        subject.setGradeID(gradeID);
        int result = subjectService.addSubject(subject);
        if (result>0){
            return JsonResult.ok("添加成功",result);
        }
        return JsonResult.no("添加失败",result);
    }
}
