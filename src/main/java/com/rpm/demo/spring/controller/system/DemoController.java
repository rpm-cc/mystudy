package com.rpm.demo.spring.controller.system;

import com.rpm.demo.spring.beans.LogBean;
import com.rpm.demo.spring.beans.TreeItem;
import com.rpm.demo.spring.commons.JsonUtil;
import com.rpm.demo.spring.controller.BaseController;
import com.rpm.demo.spring.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gc-rise on 2017/7/24.
 */
@Controller
public class DemoController extends BaseController {
    @Autowired
    SystemService sysService;

    @RequestMapping("wellcome")
    public String wellcome(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.init(request, model);
        return "sys/wellcome";
    }

    @RequestMapping("grid")
    public String grid(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.init(request, model);
        return "sys/grid";
    }

    @RequestMapping("jqgrid")
    public String jqgrid(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.init(request, model);

        return "sys/jqgrid";
    }

    @RequestMapping("tables")
    public String tables(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.init(request, model);
        return "sys/tables";
    }

    @RequestMapping("jqueryui")
    public String jqueryui(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.init(request, model);
        return "sys/jquery-ui";
    }

    @RequestMapping("treeview")
    public String treeview(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.init(request, model);


        try {
            sysService.getMenues(user.getId());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sys/treeview";
    }
}
