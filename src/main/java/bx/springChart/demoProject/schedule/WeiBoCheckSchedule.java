package bx.springChart.demoProject.schedule;

import bx.springChart.demoProject.model.WeiBoNewModel;
import bx.springChart.demoProject.service.WebSocketService;
import bx.springChart.demoProject.socket.WebSocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * 警情定时器，通知websocket
 * author:lin
 */
@Component
public class WeiBoCheckSchedule {

    @Resource
    private WebSocketService webSocketService;
    private List<WeiBoNewModel> currentTimeList = null;
    private WebSocketServer socket = new WebSocketServer();

    /**
     *
     */
    @Scheduled(cron = "*/5 * * * * ?")//五秒轮询
    public void TimeStampsSearch() {
        try {
            if (currentTimeList == null) {
                currentTimeList = webSocketService.getAllTimeStamps();

            } else {
                List<WeiBoNewModel> newTimeList = webSocketService.getAllTimeStamps();

                    for (int i = 0; i < currentTimeList.size(); i++) {
                        if (currentTimeList.size()!=newTimeList.size()) {
                            System.out.println("list长度不相等");
                            System.out.println("数据更新了");
                            socket.sendInfo("10", "1");
                            break;
                        }
                        if (!currentTimeList.get(i).getOnboardTime().equals(newTimeList.get(i).getOnboardTime())) {
                            System.out.println("数据时间不一致");
                            System.out.println("数据更新了");
                            socket.sendInfo("10", "1");
                            break;
                        }
                    }
                    currentTimeList = newTimeList;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
