package WebDBEx1.WebDBEx1.model;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class departmentModel {

    @Id
    //@GeneratedValue
    @Column(name = "dept_no")
    int dept_no;

    public int getDept_no() {
        return dept_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    @Override
    public String toString() {
        return "departmentModel{" +
                "dept_no=" + dept_no +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }

    public departmentModel(String dept_name) {
        this.dept_name = dept_name;
    }

    public departmentModel(int dept_no, String dept_name) {
        this.dept_no = dept_no;
        this.dept_name = dept_name;
    }

    public departmentModel()
    {
        this.dept_no = 1;
        this.dept_name = "initial name";
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Column(name = "dept_name")
    String dept_name;


}
