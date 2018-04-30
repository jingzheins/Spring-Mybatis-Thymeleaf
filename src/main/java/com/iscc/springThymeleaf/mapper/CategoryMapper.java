package com.iscc.springThymeleaf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iscc.springThymeleaf.pojo.Category;

@Mapper
public interface CategoryMapper {
	@Select("select * from category_")
	List<Category> listCategory();

	@Insert("insert into category_ ( name ) values (#{name})")
	int addCategory(Category category);

	@Delete("delete from category_ where id= #{id}")
	int delCategory(Category category);

	@Update("update category_ set name=#{name} where id=#{id}")
	int updateCategory(Category category);

	@Select("select * from category_ where id = #{id}")
	Category editCategory(int id);

}