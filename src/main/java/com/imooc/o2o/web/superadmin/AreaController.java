package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

@Controller
@RequestMapping("/superadmin")
public class AreaController {

	Logger logger =LoggerFactory.getLogger(AreaController.class);
	long startTime=	System.currentTimeMillis();
	@Autowired
	private AreaService areaService;
	//定位路由位置。
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	//返回对象自动转换为jason
	@ResponseBody
	private  Map<String,Object> listArea(){
		logger.info("-----------start------------");
		Map<String,Object> modelMap=new HashMap<String,Object>();
		List<Area> list=new ArrayList<Area>();
		try{
			list=areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		}catch(Exception e){
			e.printStackTrace();
			//成功的话，不返回任何信息
			modelMap.put("success", false);
			//不成功的话，返回错误信息
			modelMap.put("errMsg", e.toString());
			
		}
		logger.error("test error");
		long endTime=	System.currentTimeMillis();
		logger.debug("costTime:[{}ms]", endTime-startTime);
		logger.info("-----------end------------");
		return modelMap;
	}
	
	
}
