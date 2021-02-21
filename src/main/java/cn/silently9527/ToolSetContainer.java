package cn.silently9527;

import cn.silently9527.toolset.Base64Panel;
import cn.silently9527.toolset.CronPanel;
import cn.silently9527.toolset.IpAddressPanel;
import cn.silently9527.toolset.JSONPanel;
import cn.silently9527.toolset.Md5Panel;
import cn.silently9527.toolset.MobilePanel;
import cn.silently9527.toolset.RegularExpressionPanel;
import cn.silently9527.toolset.Sql2DslPanel;
import cn.silently9527.toolset.TimestampPanel;
import cn.silently9527.toolset.URLPanel;
import com.intellij.openapi.project.Project;
import com.intellij.ui.tabs.TabInfo;
import com.intellij.ui.tabs.impl.JBTabsImpl;

import javax.swing.*;
import java.awt.*;

public class ToolSetContainer {
    private Project project;

    private JPanel content;

    public ToolSetContainer(Project project) {
        this.project = project;
        init();
    }

    private void init() {
        JBTabsImpl tabs = new JBTabsImpl(project);

        TabInfo Sql2DslTabInfo = new TabInfo(new Sql2DslPanel(project));
        Sql2DslTabInfo.setText("Sql2Dsl");
        tabs.addTab(Sql2DslTabInfo);

        TabInfo base64TabInfo = new TabInfo(new Base64Panel(project));
        base64TabInfo.setText("Base64");
        tabs.addTab(base64TabInfo);

        TabInfo md5TabInfo = new TabInfo(new Md5Panel(project));
        md5TabInfo.setText("Md5");
        tabs.addTab(md5TabInfo);

        TabInfo jsonTabInfo = new TabInfo(new JSONPanel(project));
        jsonTabInfo.setText("JSON格式化");
        tabs.addTab(jsonTabInfo);

        TabInfo ipAddressTabInfo = new TabInfo(new IpAddressPanel(project));
        ipAddressTabInfo.setText("Ip查询");
        tabs.addTab(ipAddressTabInfo);

        TabInfo mobileTabInfo = new TabInfo(new MobilePanel(project));
        mobileTabInfo.setText("手机归属地");
        tabs.addTab(mobileTabInfo);

        TabInfo urlTabInfo = new TabInfo(new URLPanel(project));
        urlTabInfo.setText("URL编解码");
        tabs.addTab(urlTabInfo);

        TabInfo timeTabInfo = new TabInfo(new TimestampPanel(project));
        timeTabInfo.setText("时间戳");
        tabs.addTab(timeTabInfo);

        TabInfo regularTabInfo = new TabInfo(new RegularExpressionPanel(project));
        regularTabInfo.setText("正则表达式");
        tabs.addTab(regularTabInfo);

        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(tabs.getComponent(), BorderLayout.CENTER);
    }

    public JPanel getContent() {
        return content;
    }

}
