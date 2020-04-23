/**    
 * @Title: ExcelImportExportController.java  
 * @Package com.clps.oas.util.excel.controller  
 * @Description: 实现对前台表格数据的导出以及从表格中数据传入前台页面显示
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-22 10:59:47
 * @version V1.0    
 */
package com.clps.oas.util.excel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clps.oas.util.factory.UtilFactory;

/**  
 * @ClassName: ExcelImportExportController  
 * @Description: 实现对前台表格数据的导出以及从表格中数据传入前台页面显示  
 * @author weigion.wu
 * @param <Position>
 * @date  2018-05-22 10:59:47  
 */
@Controller
@RequestMapping(value = "/excel")
public class ExcelImportExportController<Position> {
	
	private Logger logger = Logger.getLogger(ExcelImportExportController.class);
	
	
	  //  String[] headers = {"职位编号", "职位名称", "职位描述", "职位等级", "职位部门编号"};
	   
	 
	
	//从表格中读取Position信息上传到页面显示出来
	@RequestMapping(value ="/positionVo_list")
	public String importPositionVoFromExcel(Model model){
		List<Object> list = null;
		ArrayList<Position> lists = new ArrayList<Position>();
		try {
			list = UtilFactory.getInstanceOfExcelUtilHandlePositionVo()
					.ImportFromExcel(new File("f:\\positionVo.xls"), 0);
			if(list.size()>0){
			
				}else{
				logger.info("position list.size()==0");
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	    
		model.addAttribute("positionList", list);
		return "util/excel/positionVo_list";

	}
	
	
}
