package com.company.ship.util;


/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 对象转换：将 Page 对象转换成 Pagination,
 * 主要是为了解决dubbo无法序列化Page对象的问题
 * @author BennyTian
 * @date 2015/02/05
 * @param <E>
 */
public class PageUtil{
    
	/**
	 * 将Page对象转换成Pagination <br/>
	 * 主要是为了解决dubbo无法序列化Page对象的问题
	 * @param result
	 * @return
	 */
	public static <T> PageInfo<T> toPageInfo(List<T> result){
		if(!(result instanceof Page)){
			throw new IllegalArgumentException("result must instanceof Page.");
		}
		PageInfo<T> pagination = new PageInfo<T>(result,1);
		return pagination;
	}
	public static <T> Pagination<T> toPagination(PageInfo<T> pageInfo){
		return new Pagination<T>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal(), pageInfo.getList());
	}
	
	public static <T> Pagination<T> toPagination(int pageNum,int pageSize,int pages,long total,List<T> list){
		return new Pagination<T>(pageNum, pageSize, pages, total, list);
	}
	
	public static <T> Pagination<T> toPagination(Page page,List<T> list){
		return new Pagination<T>(page.getPageNum(), page.getPageSize(), page.getPages(), page.getTotal(), list);
	}
	
	
}
