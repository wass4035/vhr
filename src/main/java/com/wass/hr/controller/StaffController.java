package com.wass.hr.controller;

import com.wass.hr.Basic.controller.BaseController;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.Staff;
import com.wass.hr.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/staff")
public class StaffController extends BaseController {

	@Autowired
	private StaffService staffService;

	/**
	 * 查询员工信息
	 * @return
	 */
	@RequestMapping("/getStaffList")
	public Message getStaffList(){
		return staffService.getStaffList();
	}

	/**
	 * 新增员工信息
	 * @param staff   员工信息
	 * @return
	 */
	@RequestMapping("/addStaff")
	public Message addStaff(Staff staff){
		Message msg = staffService.addStaff(staff);
		return msg;
	}

	/***
	 * 修改员工信息
	 * @param staff   员工信息
	 * @return
	 */
	@RequestMapping("/modifyStaff")
	public Message modifyStaff(Staff staff){
		Message msg = staffService.modifyStaff(staff);
		return msg;
	}

	/**
	 * 删除员工信息
	 * @param staffId   员工信息ID
	 * @return
	 */
	@RequestMapping("/delStaff")
	public Message delStaff(Long staffId){
		Message msg = staffService.delStaff(staffId);
		return msg;
	}















//	private static final long serialVersionUID = 1L;
//	private Employee employee;
//	private String s_employeeNo;
//	private String s_name;
//	private String s_sex;
//	private String s_bbirthday;
//	private String s_ebirthday;
//	private String s_nationality;
//	private String s_education;
//	private String s_departmentId;
//	private String s_position;
//	private String page;
//	private String rows;
//	private String delIds;
//	private String employeeId;
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//	public String getS_employeeNo() {
//		return s_employeeNo;
//	}
//	public void setS_employeeNo(String s_employeeNo) {
//		this.s_employeeNo = s_employeeNo;
//	}
//	public String getS_name() {
//		return s_name;
//	}
//	public void setS_name(String s_name) {
//		this.s_name = s_name;
//	}
//	public String getS_sex() {
//		return s_sex;
//	}
//	public void setS_sex(String s_sex) {
//		this.s_sex = s_sex;
//	}
//	public String getS_bbirthday() {
//		return s_bbirthday;
//	}
//	public void setS_bbirthday(String s_bbirthday) {
//		this.s_bbirthday = s_bbirthday;
//	}
//	public String getS_ebirthday() {
//		return s_ebirthday;
//	}
//	public void setS_ebirthday(String s_ebirthday) {
//		this.s_ebirthday = s_ebirthday;
//	}
//	public String getS_nationality() {
//		return s_nationality;
//	}
//	public void setS_nationality(String s_nationality) {
//		this.s_nationality = s_nationality;
//	}
//	public String getS_education() {
//		return s_education;
//	}
//	public void setS_education(String s_education) {
//		this.s_education = s_education;
//	}
//	public String getS_departmentId() {
//		return s_departmentId;
//	}
//	public void setS_departmentId(String s_departmentId) {
//		this.s_departmentId = s_departmentId;
//	}
//	public String getS_position() {
//		return s_position;
//	}
//	public void setS_position(String s_position) {
//		this.s_position = s_position;
//	}
//	public String getPage() {
//		return page;
//	}
//	public void setPage(String page) {
//		this.page = page;
//	}
//	public String getRows() {
//		return rows;
//	}
//	public void setRows(String rows) {
//		this.rows = rows;
//	}
//	public String getDelIds() {
//		return delIds;
//	}
//	public void setDelIds(String delIds) {
//		this.delIds = delIds;
//	}
//	public String getEmployeeId() {
//		return employeeId;
//	}
//	public void setEmployeeId(String employeeId) {
//		this.employeeId = employeeId;
//	}
//
//	public ResultSet search() throws Exception {
//		Connection con=null;
//		con=dbUtil.getCon();
//		if(page==null){
//			page = "1";
//			rows = "10";
//		}else{
//			page = page;
//			rows = rows;
//		}
//		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
//		employee=new Employee();
//		if(s_employeeNo!=null){
//			employee.setEmployeeNo(s_employeeNo);
//			employee.setName(s_name);
//			employee.setSex(s_sex);
//			employee.setEducation(s_education);
//			employee.setPosition(s_position);
//			employee.setNationality(s_nationality);
//			if(StringUtil.isNotEmpty(s_departmentId)){
//				employee.setDepartmentId(Integer.parseInt(s_departmentId));
//			}
//		}
//		ResultSet rs = employeeDao.employeeList(con,pageBean,employee,s_bbirthday,s_ebirthday);
//		return rs;
//	}
//
//	DbUtil dbUtil=new DbUtil();
//	EmployeeDao employeeDao=new EmployeeDao();
//	@Override
//	public String execute() throws Exception {
//		Connection con=null;
//		try {
//			con=dbUtil.getCon();
//			JSONObject result=new JSONObject();
//			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(search());
//			int total=employeeDao.employeeCount(con,employee,s_bbirthday,s_ebirthday);
//			result.put("rows", jsonArray);
//			result.put("total", total);
//			ResponseUtil.write(ServletActionContext.getResponse(), result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				dbUtil.closeCon(con);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//	public String delete()throws Exception{
//		Connection con=null;
//		try {
//			con=dbUtil.getCon();
//			JSONObject result=new JSONObject();
//			int delNums=employeeDao.employeeDelect(con, delIds);
//			if(delNums>0){
//				result.put("success", "true");
//				result.put("delNums", delNums);
//			}else{
//				result.put("errorMeg", "删除失败");
//			}
//			result.put("delNum", delNums);
//			ResponseUtil.write(ServletActionContext.getResponse(), result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				dbUtil.closeCon(con);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//	public String save()throws Exception{
//		if(StringUtil.isNotEmpty(employeeId)){
//			employee.setEmployeeId(Integer.parseInt(employeeId));
//		}
//		Connection con=null;
//		try {
//			con=dbUtil.getCon();
//			int saveNums=0;
//			JSONObject result=new JSONObject();
//			if(StringUtil.isNotEmpty(employeeId)){
//				saveNums=employeeDao.employeeModify(con, employee);
//			}else{
//				saveNums=employeeDao.employeeAdd(con, employee);
//			}
//			if(saveNums>0){
//				result.put("success", "true");
//			}else{
//				result.put("success", "true");
//				result.put("errorMeg", "删除失败");
//			}
//			ResponseUtil.write(ServletActionContext.getResponse(), result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				dbUtil.closeCon(con);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//
//	public void ExportEmployee() throws Exception{
//		Connection con = null;
//		con=dbUtil.getCon();
//		List<Employee> list = employeeDao.getData(con,search());
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		try {
//			HSSFSheet sheet = workbook.createSheet("employee");
//			HSSFRow row = sheet.createRow(0);
//			String[] cellTitle = {"ID", "编号", "姓名", "性别","出生日期", "民族", "学历", "专业","部门", "职务", "基本工资", "加班费","工龄工资", "考勤费", "旷工费", "保险费"};
//			for (int i = 0; i < cellTitle.length; i++) {
//				HSSFCell cell = row.createCell(i);
//				cell.setCellValue(cellTitle[i]);
//			}
//
//			for(int rowIndex=0;rowIndex<list.size();rowIndex++){
//				row = sheet.createRow(rowIndex+1);
//				HSSFCell cell = row.createCell(rowIndex);
//				cell.setCellValue(cellTitle[rowIndex]);
//				Employee employee = list.get(rowIndex);
//				for(int cellnum = 0; cellnum < 17; cellnum++){
//					cell = row.createCell(cellnum);
//					switch(cellnum){
//					case 0:
//						cell.setCellValue(employee.getEmployeeId());
//						break;
//					case 1:
//						cell.setCellValue(employee.getEmployeeNo());
//						break;
//					case 2:
//						cell.setCellValue(employee.getName());
//						break;
//					case 3:
//						cell.setCellValue(employee.getSex());
//						break;
//					case 4:
//						cell.setCellValue(DateUtil.formatDate(employee.getBirthday(), "yyyy-MM-dd"));
//						break;
//					case 5:
//						cell.setCellValue(employee.getNationality());
//						break;
//					case 6:
//						cell.setCellValue(employee.getEducation());
//						break;
//					case 7:
//						cell.setCellValue(employee.getProfession());
//						break;
//					case 8:
//						cell.setCellValue(employee.getDepartmentNameSrc());
//						break;
//					case 9:
//						cell.setCellValue(employee.getPosition());
//						break;
//					case 10:
//						cell.setCellValue(employee.getBaseMoney());
//						break;
//					case 11:
//						cell.setCellValue(employee.getOvertime());
//						break;
//					case 12:
//						cell.setCellValue(employee.getAge());
//						break;
//					case 13:
//						cell.setCellValue(employee.getCheck1());
//						break;
//					case 14:
//						cell.setCellValue(employee.getAbsent());
//						break;
//					case 15:
//						cell.setCellValue(employee.getSafety());
//						break;
//					}
//				}
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		String exportFileName = "employee.xls";
//
//		ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment;filename=" + new String((exportFileName).getBytes(), "ISO8859-1"));//设定输出文件头
//		ServletActionContext.getResponse().setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
//
//
//		OutputStream out = ServletActionContext.getResponse().getOutputStream();
//		workbook.write(out);
//		out.flush();
//		out.close();
//	}

}
