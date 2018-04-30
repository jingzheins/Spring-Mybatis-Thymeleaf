package com.iscc.springThymeleaf.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iscc.springThymeleaf.pojo.Category;
import com.iscc.springThymeleaf.mapper.CategoryMapper;
@Controller
public class CategoryController {
	@Autowired
	CategoryMapper categoryMapper;
	@RequestMapping("listCategory")
	public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<Category> cs=categoryMapper.listCategory();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);        
        return "listCategory";
    }
	@RequestMapping("addCategory")
	public String addCategory(Category category){
		categoryMapper.addCategory(category);
		return "redirect:listCategory";
	}
	@RequestMapping("delCategory")
	public String delCategory(Category category){
		categoryMapper.delCategory(category);
		return "redirect:listCategory";
	}
	@RequestMapping("updateCategory")
	public String updateCategory(Category category){
		categoryMapper.updateCategory(category);
		return "redirect:listCategory";
	}
	@RequestMapping("editCategory")
	public String editCategory(int id,Model m){
		Category category = categoryMapper.editCategory(id);
		m.addAttribute("cs",category);
		return "editCategory";
	}
}
