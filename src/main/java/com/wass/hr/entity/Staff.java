package com.wass.hr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工信息实体类
 * @author wass
 */
public class Staff implements Serializable {
    private Long staff_id;//员工编号
    private String staff_name;//员工姓名
    private String staff_sex;//员工性别
    private Long dept_id;//所属部门ID
    private Date birthday;//出生日期
    private int identity_car_id;//身份证号
    private String wed_lock;//婚姻状况
    private String race;//民族
    private String native_place;//籍贯
    private String politic;//政治面貌
    private String E_mail;//邮箱
    private String phone;//电话
    private String address;//地址
    private String job;//职位
    private int basis_salary;//基本工资
    private String engage_from;//聘用形式
    private String tiptop_degree;//最高学历
    private String specialty;//所属专业
    private String school;//学校
    private Date begin_word_date;//入职日期
    private String work_state;//在职状态
    private int work_id;//工号
    private int contract_term;//合同期限
    private Date becom_from_date;//转正日期
    private Date not_work_date;//离职日期
    private Date begin_contract;//合同起始日期
    private Date end_contract;//合同终止日期
    private int work_age;//工龄

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_sex() {
        return staff_sex;
    }

    public void setStaff_sex(String staff_sex) {
        this.staff_sex = staff_sex;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getIdentity_car_id() {
        return identity_car_id;
    }

    public void setIdentity_car_id(int identity_car_id) {
        this.identity_car_id = identity_car_id;
    }

    public String getWed_lock() {
        return wed_lock;
    }

    public void setWed_lock(String wed_lock) {
        this.wed_lock = wed_lock;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getBasis_salary() {
        return basis_salary;
    }

    public void setBasis_salary(int basis_salary) {
        this.basis_salary = basis_salary;
    }

    public String getEngage_from() {
        return engage_from;
    }

    public void setEngage_from(String engage_from) {
        this.engage_from = engage_from;
    }

    public String getTiptop_degree() {
        return tiptop_degree;
    }

    public void setTiptop_degree(String tiptop_degree) {
        this.tiptop_degree = tiptop_degree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBegin_word_date() {
        return begin_word_date;
    }

    public void setBegin_word_date(Date begin_word_date) {
        this.begin_word_date = begin_word_date;
    }

    public String getWork_state() {
        return work_state;
    }

    public void setWork_state(String work_state) {
        this.work_state = work_state;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public int getContract_term() {
        return contract_term;
    }

    public void setContract_term(int contract_term) {
        this.contract_term = contract_term;
    }

    public Date getBecom_from_date() {
        return becom_from_date;
    }

    public void setBecom_from_date(Date becom_from_date) {
        this.becom_from_date = becom_from_date;
    }

    public Date getNot_work_date() {
        return not_work_date;
    }

    public void setNot_work_date(Date not_work_date) {
        this.not_work_date = not_work_date;
    }

    public Date getBegin_contract() {
        return begin_contract;
    }

    public void setBegin_contract(Date begin_contract) {
        this.begin_contract = begin_contract;
    }

    public Date getEnd_contract() {
        return end_contract;
    }

    public void setEnd_contract(Date end_contract) {
        this.end_contract = end_contract;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
}
