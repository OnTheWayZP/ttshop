package com.zp.ttshop.service.impl;

import com.zp.ttshop.ProductService;
import com.zp.ttshop.dao.ProductMapper;
import com.zp.ttshop.pojo.po.Product;
import com.zp.ttshop.pojo.po.ProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> getProducts() {
		
		ProductExample pe = new ProductExample();
//		Criteria pc = pe.createCriteria();
		List<Product> list = productMapper.selectByExample(pe);
		
		return list;
	}

	@Override
	public Product getProductById(String productId) {
		
		return productMapper.selectByPrimaryKey(productId);
	}

}
