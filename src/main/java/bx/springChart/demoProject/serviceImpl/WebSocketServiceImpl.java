package bx.springChart.demoProject.serviceImpl;

import bx.springChart.demoProject.mapper.WebSocketMapper;
import bx.springChart.demoProject.model.WeiBoNewModel;
import bx.springChart.demoProject.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("webSocketService")
public class WebSocketServiceImpl implements WebSocketService {
    @Autowired
    private WebSocketMapper webSocketMapper;
    @Override
    public List<WeiBoNewModel> getAllTimeStamps() {
        return webSocketMapper.getAllTimeStamps();
    }
}
