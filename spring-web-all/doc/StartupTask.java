package com.xyt.cgqm.schedule;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.xyt.cgqm.bean.common.ResultBean;
import com.xyt.cgqm.service.common.CoreApplicationContext;
import com.xyt.cgqm.service.pro.ProductTypeService;
import com.xyt.cgqm.service.sa.SaIndustrialCommercialService;
import com.xyt.cgqm.service.sys.DictService;
import com.xyt.cgqm.service.sys.MenuService;
import com.xyt.cgqm.service.sys.RegionService;
import com.xyt.cgqm.service.sys.SysService;


public class StartupTask extends TimerTask
{
	@Autowired
	DictService dictService;
	
	@Autowired
	RegionService regionService;
	
	@Autowired
	MenuService menuServie;
	
	@Autowired
	ProductTypeService productTypeService;
	
	@Autowired
	private SaIndustrialCommercialService icOrgService;
	
	//private static final Logger log = LoggerFactory.getLogger(StartupTask.class); 
	
	@Override
	public void run()
	{
		SysService sysService = CoreApplicationContext.getApplicationContext().getBean(SysService.class);
		ResultBean rb = sysService.txAutoScanAnnotations();
		if (rb.getSuccess())
		{
			sysService.txAutoCreateDefaultSuperAdmin();
		}

		putDataToCache();
	}

	public void putDataToCache()
	{
		//DictService dictService = CoreApplicationContext.getApplicationContext().getBean(DictService.class);
		dictService.putDictToCache();

		//RegionService regionService = CoreApplicationContext.getApplicationContext().getBean(RegionService.class);
		regionService.putRegionToCache();

		//MenuService menuServie = CoreApplicationContext.getApplicationContext().getBean(MenuService.class);
		menuServie.putMenuToCache();
		
		productTypeService.putTypeToCache();
		
		icOrgService.putIcOrgToCache();
	}

}