package com.product.hub.controller;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.hub.apiresponse.ApiResponse;
import com.product.hub.apiresponse.SuccessResponse;
import com.product.hub.dtos.request.ProductRequest;
import com.product.hub.dtos.response.ProductRespoonse;
import com.product.hub.entity.Product;
import com.product.hub.service.ProductService;


@RestController
@RequestMapping("/api-product")

public class ProductController {
	
	@Autowired
	private ProductService pService;
	@PostMapping("/add")
	public ResponseEntity<?> addProduct( @RequestBody ProductRequest request){
		
		ApiResponse response= new SuccessResponse<ProductRespoonse>(HttpStatus.CREATED.value(), true, LocalDateTime.now(), "product added", pService.addProduct(request));
		
		System.out.println(request);
		return ResponseEntity.status(201).body(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct( @RequestBody ProductRequest request, @PathVariable Long id){
		
		ApiResponse response= new SuccessResponse<ProductRespoonse>(HttpStatus.CREATED.value(), true, LocalDateTime.now(), "product updated", pService.updateProduct(request,id));
		
		System.out.println(request);
		return ResponseEntity.status(201).body(response);
	}


	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> viewProduct( @PathVariable Long id){
		
		ApiResponse response= new SuccessResponse<ProductRespoonse>(HttpStatus.OK.value(), true, LocalDateTime.now(), "product fteched", pService.viewProduct(id));
		
		return ResponseEntity.status(200).body(response);
	}

	
	@GetMapping("/view-product-page/{pageNo}/{pageSize}")
	public ResponseEntity<?> viewPageProduct( @PathVariable int pageNo, @PathVariable int pageSize){
		
		
		List<ProductRespoonse> p=new ArrayList<ProductRespoonse>();
		
	Page<Product> pages =	 pService.pageWise(pageSize, pageNo);
	
	Iterator<Product> itr = pages.iterator();
	
	while(itr.hasNext()) {
		
		ProductRespoonse response= ProductRespoonse.builder().build();
		BeanUtils.copyProperties(itr.next(), response);
		p.add(response);
		
	}
	
		ApiResponse response= new SuccessResponse<List<ProductRespoonse>>(HttpStatus.OK.value(), true, LocalDateTime.now(), "product fteched", p);
		
		
		return ResponseEntity.status(200).body(response);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct( @PathVariable Long id){
		
		ApiResponse response= new SuccessResponse<String>(HttpStatus.OK.value(), true, LocalDateTime.now(), "product deleted", pService.deleteProduct(id));
		
		
		return ResponseEntity.status(200).body(response);
	}

	
}
