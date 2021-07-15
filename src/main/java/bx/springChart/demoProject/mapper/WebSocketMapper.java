package bx.springChart.demoProject.mapper;

import bx.springChart.demoProject.model.WeiBoNewModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebSocketMapper {
    List<WeiBoNewModel> getAllTimeStamps();
}
