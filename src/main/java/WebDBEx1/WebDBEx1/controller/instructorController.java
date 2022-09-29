package WebDBEx1.WebDBEx1.controller;

import WebDBEx1.WebDBEx1.model.instructorModel;
import WebDBEx1.WebDBEx1.repositories.departmentRepo;
import WebDBEx1.WebDBEx1.repositories.instructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allinstr")
public class instructorController {

    @Autowired
    public instructorController(instructorRepo instRepo, departmentRepo deptRepo) {
        this.instRepo = instRepo;
        this.deptRepo = deptRepo;
    }


    private final instructorRepo instRepo;
    private final departmentRepo deptRepo;


    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/ping")
    public String ping() {
        return "success";
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public List<instructorModel> getAll()
    {
        List<instructorModel> all = instRepo.findAll();
        return all;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInstructor(@RequestParam(value = "id", defaultValue = "1") String id,
                                @RequestParam(value = "inst_name", defaultValue = "defaultinstrname") String inst_name,
                                @RequestParam(value = "salary", defaultValue = "100") String salary,
                                @RequestParam(value = "dept_no", defaultValue = "defaultdeptno") String dept_no)
    {
        instructorModel instr = new instructorModel(Integer.parseInt(id), inst_name, Integer.parseInt(salary), Integer.parseInt(dept_no), deptRepo);
        System.out.println(instr);
        List<instructorModel> li = instRepo.findAll();
        for (instructorModel im: li) {
            if (im.getId() == instr.getId())
                return "FAILED: Instructor " + im + " already exist";
        }
        instRepo.save(instr);
        return "SUCCESS. instructor: " + instr + " has already been added";
    }
}
