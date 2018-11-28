package com.pl.web.dao;

import java.util.List;

import com.pl.web.dto.EmpAverSat;
import org.apache.ibatis.annotations.Param;


/**
 * 工作饱和度平均值
 * 
 * @author root
 * 
 */
public interface EmpAverSatDao {

/*................A方法计算结果展示(8:30-17:30)...................*/
	// a计算结果的展示(8:30-17:30)
	//前七天数据展示
	public List<EmpAverSat> getEmpAverSats(@Param("mailname") String mailname,
										   @Param("startime") String startime, @Param("endtime") String endtime);
	//查询展示
	public List<EmpAverSat> searchEmpAverSats(
            @Param("department") String department,
            @Param("mailname") String mailname,
            @Param("startime") String startime, @Param("endtime") String endtime);


/*................B方法计算结果展示(全天)..........................*/
	// b计算结果的展示(全天)
	//前七天数据展示
	public List<EmpAverSat> getEmpAverSats_B(
            @Param("mailname") String mailname,
            @Param("startime") String startime, @Param("endtime") String endtime);
	//查询展示
	public List<EmpAverSat> SearchEmpAverSats_B(
            @Param("department") String department,
            @Param("mailname") String mailname,
            @Param("startime") String startime, @Param("endtime") String endtime);
}
