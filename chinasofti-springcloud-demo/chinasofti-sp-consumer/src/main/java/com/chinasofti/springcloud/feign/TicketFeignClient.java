package com.chinasofti.springcloud.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chinasofti.springcloud.entity.PyTicketBase;
import com.chinasofti.springcloud.hystrix.TicketFeignClientHystrix;

@FeignClient(name = "chinasofti-py-ticket",fallback=TicketFeignClientHystrix.class)
public interface TicketFeignClient {

	// 查询全部
	@RequestMapping("ticket/selectAll")
	List<PyTicketBase> selectAll();

	// 根据id查询
	@RequestMapping("ticket/selectById/{ids}")
	PyTicketBase selectById(@PathVariable("ids") String ids);
	
	@RequestMapping("ticket/addTicket")
	int addTicket(PyTicketBase pyTicketBase);
	
	
	// 根据id删除
	@RequestMapping("ticket/deleteById/{ids}")
	int deleteById(@PathVariable("ids") String ids);

	// 修改
	@RequestMapping("ticket/update")
	public int update(PyTicketBase pyTicketBase);
}
