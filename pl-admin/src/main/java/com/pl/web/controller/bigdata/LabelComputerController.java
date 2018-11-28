package com.pl.web.controller.bigdata;

import com.pl.web.dao.EmpLabelDAO;
import com.pl.web.dao.EmpTargetDAO;
import com.pl.web.dao.LabelTargetDAO;
import com.pl.web.model.EmpLabel;
import com.pl.web.model.EmpTarget;
import com.pl.web.model.LabelTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 标签计算
 * 
 * @author root
 *
 */
@Controller
public class LabelComputerController {

	@Autowired
	private EmpTargetDAO empTargetDAO;
	@Autowired
	private EmpLabelDAO empLabelDAO;
	@Autowired
	private LabelTargetDAO LabelTargetDAO;

	@RequestMapping(value = "labelcompute.do")
	@Scheduled(cron="0 0 0 * * ?")
	public void computeLabel() {
		System.out.println("正在执行标签计算");
		// 获取年月形式的格式yyyy-MM
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		// 获取标签指标表中的所有值
		List<LabelTarget> lts = LabelTargetDAO.queryAll();
       System.out.println("标签指标表所有内容：" + lts);
		// 满足条件的用户
		List<EmpLabel> lists = new ArrayList<EmpLabel>();

		// 不满足条件的用户
		Map<String, Object> map = new HashMap<String, Object>();
		// 解决labelid重复的问题
		int oldLabelId = -1;
		for (LabelTarget labelTarget : lts) {
			System.out.println("labelTarget:==========" + labelTarget);
			// 获取标签指标表中的tag_id
			String tagId = labelTarget.getTagId();
			System.out.println("指标id" + tagId);
			// 获取标签指标表中的lable_id
			int labelId = labelTarget.getLabelId();
			// 获取标签指标表中的目标值
			String tagValue = labelTarget.getTargetValue();
			// 获取标签指标表中的操作符
			String computerOperation = labelTarget.getCompareOperation();
			// 获取指标id下所有用户的指标值，用户名，然后进行判断
			List<EmpTarget> empTargets = empTargetDAO.queryById(tagId);
			for (EmpTarget empTarget : empTargets) {
				//判断在同一个labelid下,如果不是则可以直接插入数据库，清除map和lists
				if (oldLabelId != labelId && oldLabelId != -1) {
					for (EmpLabel empLabel : lists) {
						if (map.get(empLabel.getUserId()) == null) {
							empLabelDAO.insert(empLabel);
						}
					}
					map.clear();
					lists.clear();
				}
				//用户指标实际值
				String actualValue = empTarget.getTagValue();
				//用户名
				String mailName = empTarget.getMailName();
				//进行指标实际值与目标值的比较，如果不符合则直接跳过循环
				if (computerOperation.equals(">")) {
					if (Double.parseDouble(actualValue) > Double.parseDouble(tagValue)) {
						EmpLabel empLabel = new EmpLabel();
						empLabel.setLabelId(labelId);
						empLabel.setUserId(mailName);
						empLabel.setCoputeDate(sdf.format(System.currentTimeMillis()));
						lists.add(empLabel);
						// empLabelDAO.insert(empLabel);
					} else {
						map.put(mailName, new Object());
						continue;
					}
				} else if (computerOperation.equals(">=")) {
					if (Double.parseDouble(actualValue) >= Double.parseDouble(tagValue)) {
						EmpLabel empLabel = new EmpLabel();
						empLabel.setLabelId(labelId);
						empLabel.setUserId(mailName);
						empLabel.setCoputeDate(sdf.format(System.currentTimeMillis()));
						// empLabelDAO.insert(empLabel);
						lists.add(empLabel);
					} else {
						map.put(mailName, new Object());
						continue;
					}
				} else if (computerOperation.equals("<")) {
					if (Double.parseDouble(actualValue) < Double.parseDouble(tagValue)) {
						EmpLabel empLabel = new EmpLabel();
						empLabel.setLabelId(labelId);
						empLabel.setUserId(mailName);
						empLabel.setCoputeDate(sdf.format(System.currentTimeMillis()));
						// empLabelDAO.insert(empLabel);
						lists.add(empLabel);
					} else {
						map.put(mailName, new Object());
						continue;
					}
				} else if (computerOperation.equals("<=")) {
					if (Double.parseDouble(actualValue) <= Double.parseDouble(tagValue)) {
						EmpLabel empLabel = new EmpLabel();
						empLabel.setLabelId(labelId);
						empLabel.setUserId(mailName);
						empLabel.setCoputeDate(sdf.format(System.currentTimeMillis()));
						// empLabelDAO.insert(empLabel);
						lists.add(empLabel);
					} else {
						map.put(mailName, new Object());
						continue;
					}
				}
			}

			oldLabelId = labelId;
		}
		//将最后一个指标输出到数据库
		for (EmpLabel empLabel : lists) {
			if (map.get(empLabel.getUserId()) == null) {
				empLabelDAO.insert(empLabel);
			}

		}
	}

}
