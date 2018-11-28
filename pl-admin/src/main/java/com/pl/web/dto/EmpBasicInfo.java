package com.pl.web.dto;
/**
 * 用户基本信息
 * @author songwubian
 *
 */
public class EmpBasicInfo {
	// 基本信息
		// 唯一用户名
		private String mailName;
		// 中文名
		private String cnName;
		// 唯一标识
		private String ldapDn;
		// 部门
		private String department;
		// 职务
		private String title;
		// 电话号码
		private String mobile;
		// 域名
		private String domainName;
		// 邮箱
		private String email;
		// 办公室编号
		private String officeCode;
		// 更新日期
		private String statisticDate;
		// 收入
		private String income;
		// 星座
		private String constellation;
		// 家庭人口
		private String familyMembers;
		// 部门编号
		private String departmentId;
        
		public String getMailName() {
			return mailName;
		}

		public void setMailName(String mailName) {
			this.mailName = mailName;
		}

		public String getCnName() {
			return cnName;
		}

		public void setCnName(String cnName) {
			this.cnName = cnName;
		}

		public String getLdapDn() {
			return ldapDn;
		}

		public void setLdapDn(String ldapDn) {
			this.ldapDn = ldapDn;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getDomainName() {
			return domainName;
		}

		public void setDomainName(String domainName) {
			this.domainName = domainName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getOfficeCode() {
			return officeCode;
		}

		public void setOfficeCode(String officeCode) {
			this.officeCode = officeCode;
		}

		public String getStatisticDate() {
			return statisticDate;
		}

		public void setStatisticDate(String statisticDate) {
			this.statisticDate = statisticDate;
		}

		public String getIncome() {
			return income;
		}

		public void setIncome(String income) {
			this.income = income;
		}

		public String getConstellation() {
			return constellation;
		}

		public void setConstellation(String constellation) {
			this.constellation = constellation;
		}

		public String getFamilyMembers() {
			return familyMembers;
		}

		public void setFamilyMembers(String familyMembers) {
			this.familyMembers = familyMembers;
		}

		public String getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}

		@Override
		public String toString() {
			return "EmpBasicInfo [mailName=" + mailName + ", cnName=" + cnName + ", ldapDn=" + ldapDn + ", department="
					+ department + ", title=" + title + ", mobile=" + mobile + ", domainName=" + domainName + ", email="
					+ email + ", officeCode=" + officeCode + ", statisticDate=" + statisticDate + ", income=" + income
					+ ", constellation=" + constellation + ", familyMembers=" + familyMembers + ", departmentId="
					+ departmentId + "]";
		}
		

}
