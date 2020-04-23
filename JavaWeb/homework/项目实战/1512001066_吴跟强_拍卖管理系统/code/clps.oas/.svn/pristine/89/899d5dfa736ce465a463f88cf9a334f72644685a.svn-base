/**
 * 
 */
package com.clps.oas.sm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clps.oas.sm.pojo.Position;
import com.clps.oas.sm.service.IPositionService;
import com.clps.oas.util.date.DateUtil;



/**
 * 
* @ClassName: PositionController  
* @Description: position controller  
* @author leonardo.wang 
* @date 2018年5月17日 上午11:23:17  
*
 */
@Controller
@RequestMapping(value="/sm")
public class PositionController {

	@Autowired
	@Qualifier("positionService")
	private IPositionService positionService;
	

	/**
	 * 
	 * list页面展示所有数据
	 * date: 2018年5月17日 上午11:24:00.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	@RequestMapping(value="/positionList")
	public String showUser(Model model){
		List<Position> positions= positionService.queryAllPosition();
		model.addAttribute("positions", positions);
		
		return "sm/position_list";
	}

	/**
	 * 
	 * 删除操作
	 * date: 2018年5月17日 上午11:24:31.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	@RequestMapping(value="/positionDel")
	public String delPosition(HttpServletRequest request, Model model){
		Integer id=Integer.parseInt(request.getParameter("positionId"));
		positionService.deletePositionbyId(id);
		List<Position> positions= positionService.queryAllPosition();
		model.addAttribute("positions", positions);
		return "sm/position_list";
	}
	
	
	/**
	 * 
	 * 跳转到添加页面
	 * date: 2018年5月17日 上午11:24:50.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	@RequestMapping(value="/positionAdd")
	public String addPosition(Integer id, Model model){
		model.addAttribute("positionCreatedName", id);
		return "sm/position_add";
	}
	
	/**
	 * 
	 * 执行添加操作
	 * date: 2018年5月17日 上午11:25:02.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	@RequestMapping(value="/positionAddsuccess",method=RequestMethod.POST)
	public String addPosition2(Position position, Model model){
		DateUtil time=new DateUtil();
		position.setPositionCreatedDatetime(time.getTimestamp());
		position.setPositionUpdatedName(position.getPositionCreatedName());
		position.setPositionUpdatedDatetime(time.getTimestamp());
		positionService.savePosition(position);
		List<Position> positions= positionService.queryAllPosition();
		model.addAttribute("positions", positions);
		return "sm/position_list";
	}
	
	/**
	 * 
	 * 跳转到更新页面  
	 * 
	 * date: 2018年5月21日 上午11:24:19.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	@RequestMapping(value="/positionUpdate")
	public String updatePosition(HttpServletRequest request, Model model){
		Integer id=Integer.parseInt(request.getParameter("positionId"));
		Position position= positionService.queryPositionById(id);
		model.addAttribute("position", position);
		return "sm/position_update";
	}
	
	/**
	 * 
	 * 更新并跳转回list
	 * date: 2018年5月21日 上午11:24:42.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	@RequestMapping(value="/positionUpdateSuccess",method=RequestMethod.POST)
	public String updatePosition2(Position position, Model model){
		positionService.updatePosition(position);
		List<Position> positions= positionService.queryAllPosition();
		model.addAttribute("positions", positions);
		return "sm/position_list";
	}
	
	
	
}
