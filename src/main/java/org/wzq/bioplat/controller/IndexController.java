package org.wzq.bioplat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wzq.bioplat.service.SearchContrastServiceImpl;
import org.wzq.bioplat.service.SearchDifGeneAlsServiceImpl;
import org.wzq.bioplat.service.SearchRedisServiceImpl;
import org.wzq.bioplat.utils.RedisHelper;

@Controller
//@RequestMapping()
public class IndexController {
    @Autowired
    SearchRedisServiceImpl searchRedisServiceImpl;
    @Autowired
    SearchContrastServiceImpl searchContrastServiceImpl;
    @Autowired
    RedisHelper redisHelper;
    @Autowired
    SearchDifGeneAlsServiceImpl searchDifGeneAlsServiceImpl;
    @RequestMapping("/")
    public String test(Model model){
        model.addAttribute("xxx","dad");
        model.addAttribute("link","https://www.baidu.com");
        return "search";
    }

    @ResponseBody
    @RequestMapping ("/pname")
    public String searchForPertId(@RequestParam String pname){
        return searchRedisServiceImpl.darkQueryLimit(pname);

    }
    @RequestMapping ("/search")
    public String searchForPertIdAll(@RequestParam String pname, Model model){
        model.addAttribute("perts",searchRedisServiceImpl.darkQueryAll(pname.trim()));
        model.addAttribute("pname",pname);
        return "pertsearchall";

    }
    @RequestMapping ("/pid/{pid}")
    public String intoContrastInfo(@PathVariable long pid, Model model){
//        if(pid<=0 || pid>21391)
//            return "404";
        model.addAttribute("contrasts",searchContrastServiceImpl.getByPertId(pid));
        model.addAttribute("pert",redisHelper.getKey("Pert:"+String.valueOf(pid)));
        return "pertsearch";
    }
    @RequestMapping ("/cid/{cid}")
    public String intoGeneAnalysisList(@PathVariable long cid, Model model){
        model.addAttribute("genes",searchDifGeneAlsServiceImpl.getBycontrastId(cid));
        return "genelist";
    }
}
