package WebDBEx1.WebDBEx1.model;

import WebDBEx1.WebDBEx1.repositories.departmentRepo;
import WebDBEx1.WebDBEx1.repositories.instructorRepo;

import javax.persistence.*;
import java.util.List;

@Table(name = "instructor")
@Entity
public class instructorModel {


    //@AutoIncrement
    @Column(name = "id")
    @Id
    //@GeneratedValue
    int id;

    @Column(name = "inst_name")
    String inst_name;

    @Column(name = "salary")
    int salary;

    @JoinColumn(name = "dept_no")
    @ManyToOne
    departmentModel department;

    @Override
    public String toString() {
        return "InstructorModel{" +
                "id=" + id +
                ", instructor_name='" + inst_name + '\'' +
                ", salary=" + salary +
                ", dept_no=" + department.dept_no +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInst_name(String inst_name) {
        this.inst_name = inst_name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDept_no(int dept_no) {
        this.department.dept_no = dept_no;
    }

    public int getId() {
        return id;
    }

    public String getInst_name() {
        return inst_name;
    }

    public int getSalary() {
        return salary;
    }

    public int getDept_no() {
        return department.dept_no;
    }

    public instructorModel(int id, String instructor_name, int salary, int dept_no, departmentRepo deptRepo) {
        this.id = id;
        this.inst_name = instructor_name;
        this.salary = salary;
        //SecDeptRepo = deptRepo;
        List<departmentModel> li = deptRepo.findAll();
        for (departmentModel dm: li) {
            if (dm.getDept_no() == dept_no)
                this.department = new departmentModel(dm.getDept_no(), dm.getDept_name());
        }
        if (department == null)
            this.department = new departmentModel(1, "IT");
        System.out.println(this.toString());
    }

    public instructorModel()
    {
//        this.id = 9;
//        this.inst_name = "default instructor name";
//        this.salary = 0;
//        this.department = new departmentModel(1, "IT");
//        //this.department.dept_no = 1; //default for dept_no
    }
}
