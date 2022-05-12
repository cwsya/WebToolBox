package com.cwsya.wtxSystem;

import com.cwsya.wtxSystem.pojo.Tool;
import com.cwsya.wtxSystem.pojo.ToolData;
import com.cwsya.wtxSystem.service.ToolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WtxSystemApplicationTests {

    @Autowired
    private ToolService toolService;

    @Autowired
    private ToolData toolData;

    @Test
    void contextLoads() {
        List<String> toolsList = toolService.getToolsList(toolData.getPath());
        for (String s : toolsList) {
            Tool tool = toolService.loadTool(s);
            System.out.println(tool.getConfig().getAuthor());
            System.out.println(tool.getIndex().getIndex());
        }
    }

}
