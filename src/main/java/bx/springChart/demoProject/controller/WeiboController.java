package bx.springChart.demoProject.controller;

import bx.springChart.demoProject.model.WeiBoNewModel;
import bx.springChart.demoProject.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/weibo")
public class WeiboController {

    @Autowired
    private WeiboService weiboService;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<WeiBoNewModel> findAll(){

        return weiboService.findAll();
    }

    @RequestMapping("/weiBoTopReDraw")
    public String myWeiBoTopReDraw(){
        return "weiBoTopReDraw";
    }

    @RequestMapping("/mapChina")
    public String myWeiBoMapChina(){
        return "mapChina";
    }

}
