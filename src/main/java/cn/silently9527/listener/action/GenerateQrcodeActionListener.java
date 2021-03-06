package cn.silently9527.listener.action;

import cn.silently9527.notification.ToolkitNotifier;
import cn.silently9527.utils.QRCodeUtils;
import com.intellij.ui.EditorTextField;
import com.intellij.util.IconUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GenerateQrcodeActionListener implements ActionListener {
    private EditorTextField contentTextField;
    private EditorTextField logoTextField;
    private JLabel imageLabel;

    public GenerateQrcodeActionListener(EditorTextField contentTextField, EditorTextField logoTextField, JLabel imageLabel) {
        this.contentTextField = contentTextField;
        this.logoTextField = logoTextField;
        this.imageLabel = imageLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = this.contentTextField.getText();
//        if (StringUtils.isBlank(text)) {
//            return;
//        }

        try {
            String logoPath = logoTextField.getText();
            BufferedImage image = QRCodeUtils.createImage(text, logoPath, true);
            imageLabel.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            ToolkitNotifier.error("Generate Qrcode Fail");
        }
    }
}
