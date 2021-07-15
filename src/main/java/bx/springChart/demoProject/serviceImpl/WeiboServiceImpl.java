package bx.springChart.demoProject.serviceImpl;

import bx.springChart.demoProject.mapper.WeiboMapper;
import bx.springChart.demoProject.model.WeiBoNewModel;
import bx.springChart.demoProject.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("weiboService")
public class WeiboServiceImpl implements WeiboService {

    @Autowired
    private WeiboMapper weiboMapper;

    @Override
    public List<WeiBoNewModel> findAll() {
        return weiboMapper.findAll();
    }
}
