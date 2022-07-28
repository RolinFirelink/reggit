package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish、dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    //保存修改的菜品信息
    public void updateWithFlavor(DishDto dishDto);

    //删除菜品信息
    public List<DishDto> deleteWithFlavor(List<Long> ids);

    //改变菜品状态
    public void modifyStatus(Integer stu,List<Long> ids);
}
