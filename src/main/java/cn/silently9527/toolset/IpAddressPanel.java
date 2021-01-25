package cn.silently9527.toolset;

import cn.hutool.http.HttpUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.ui.components.JBTextField;
import org.apache.commons.lang3.StringEscapeUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class IpAddressPanel extends AbstractPanel {
    private static final String URL = "https://tool.lu/ip/ajax.html";
    private JBTextField ipAddressTextField = new JBTextField(20);

    public IpAddressPanel(Project project) {
        super();
        this.add(createIpAddressTextEditor(), BorderLayout.NORTH);
    }

    private JComponent createIpAddressTextEditor() {
        JButton queryButton = new JButton("查询");
        queryButton.addActionListener(queryIpButtonListener());

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(new JLabel("请输入IP或网站域名:"), BorderLayout.WEST);
        panel.add(this.ipAddressTextField, BorderLayout.CENTER);
        panel.add(queryButton, BorderLayout.EAST);
        return panel;
    }

    @NotNull
    private ActionListener queryIpButtonListener() {
        return e -> {
            setFailureStyle();
//            String sourceText = this.ipAddressTextField.getTextValue();
//            if (StringUtil.isEmpty(sourceText)) {
//                exceptionMessageLabel.setText("IP地址必填");
//                return;
//            }
//            Map<String, Object> paramMap = new HashMap<>();
//            paramMap.put("mysqlStr", sqlText);
//            dslText = HttpUtil.post(URL, paramMap);
//            dslText = StringEscapeUtils.unescapeJava(dslText.substring(1, dslText.length() - 1));
        };
    }


}
