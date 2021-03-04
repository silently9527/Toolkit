package cn.silently9527.ui.toolset;

import cn.silently9527.ui.component.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Md5Panel extends AbstractPanel {
    private TextEditor sourceTextEditor = new TextEditor(8, 20);
    private TextEditor targetTextEditor = new TextEditor(8, 20);

    public Md5Panel(Project project) {
        super();
        this.add(createSourceTextEditor(), BorderLayout.NORTH);
        this.add(createTargetTextEditor(), BorderLayout.CENTER);
        this.add(createConvertButton(), BorderLayout.SOUTH);
    }

    private Component createConvertButton() {
        JButton encodeButton = new JButton("编码");
        encodeButton.addActionListener(encodeButtonListener());

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(encodeButton);
        horizontalBox.add(Box.createHorizontalStrut(10));
        horizontalBox.add(exceptionMessageLabel);
        return horizontalBox;
    }

    private JComponent createSourceTextEditor() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("输入源:"), BorderLayout.NORTH);
        panel.add(this.sourceTextEditor, BorderLayout.CENTER);
        return panel;
    }

    private JComponent createTargetTextEditor() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("结果:"), BorderLayout.NORTH);
        panel.add(this.targetTextEditor, BorderLayout.CENTER);
        return panel;
    }


    @NotNull
    private ActionListener encodeButtonListener() {
        return e -> {
            setFailureStyle();
            String sourceText = this.sourceTextEditor.getTextValue();
            if (StringUtil.isEmpty(sourceText)) {
                exceptionMessageLabel.setText("输入源必填");
                return;
            }

            String result = DigestUtils.md5Hex(sourceText);
            targetTextEditor.setTextValue(result);
            setSuccessStyle("编码完成");
        };
    }


}
