package WebDBEx1.WebDBEx1.controller;

import WebDBEx1.WebDBEx1.model.departmentModel;
import WebDBEx1.WebDBEx1.repositories.departmentRepo;
import WebDBEx1.WebDBEx1.repositories.instructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alldept")
public class departmentController {

    private final departmentRepo deptRepo;

    @Autowired
    public departmentController(departmentRepo repo) {
        this.deptRepo = repo;
    }




    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/ping")
    public String ping() {
        return "success";
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public List<departmentModel> getAll()
    {
      //  return "success";

        List<departmentModel> all = deptRepo.findAll();
        return all;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addDepartment(@RequestParam(value = "deptno" , defaultValue = "defaultdeptno") String deptno,
                                @RequestParam(value = "deptname" , defaultValue = "defaultdeptname") String deptname)
    {
        try
        {
            //departmentModel m = new departmentModel(9, deptname);
            departmentModel m = new departmentModel( Integer.parseInt(deptno), deptname);

            List<departmentModel> li = deptRepo.findAll();
            for (departmentModel dm: li) {
                if (dm.getDept_name().equals(deptname))
                    return "FAILED: department " + dm + " already exists";
            }
            deptRepo.save(m);
            return "SUCCESS: department " + m + " has been added successfully";

        }
        catch(Exception exc)
        {
            System.out.println("exception: " + exc.getMessage());
            exc.getStackTrace();
            return "FAILED";
        }
      }

}
