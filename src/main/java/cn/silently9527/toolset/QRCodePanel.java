package cn.silently9527.toolset;

import cn.silently9527.utils.QRCodeUtils;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.UI;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class QRCodePanel extends AbstractPanel {
    private Project project;
    private JTextField textField = new JTextField(40);
    private JTextField logoTextField = new JTextField(40);
    private BufferedImage image;
    private JLabel imageLabel = new JBLabel();

    public QRCodePanel(Project project) {
        super();
        this.project = project;
        logoTextField.setEditable(false);
        this.add(createTextField(), BorderLayout.NORTH);
        this.add(createQRCodePanel(), BorderLayout.CENTER);
        this.add(exceptionMessageLabel, BorderLayout.SOUTH);
    }

    private JComponent createTextField() {
        Box verticalBox = Box.createVerticalBox();

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(new JLabel("二维码内容:"));
        horizontalBox.add(Box.createHorizontalStrut(10));
        horizontalBox.add(textField);
        verticalBox.add(horizontalBox);


        Box horizontalBox2 = Box.createHorizontalBox();
        horizontalBox2.add(new JLabel("Logo  图片:"));
        horizontalBox2.add(Box.createHorizontalStrut(10));
        horizontalBox2.add(logoTextField);
        horizontalBox2.add(Box.createHorizontalStrut(10));

        JButton fileButton = new JButton("浏览");
        horizontalBox2.add(fileButton);
        fileButton.addActionListener(fileActionListener());

        verticalBox.add(horizontalBox2);

        Box horizontalBox3 = Box.createHorizontalBox();
        JButton generateButton = new JButton("生成二维码");
        generateButton.addActionListener(generateActionListener());

        horizontalBox3.add(generateButton);
        horizontalBox3.add(Box.createHorizontalStrut(10));

        JButton downloadButton = new JButton("下载二维码");
        downloadButton.addActionListener(downloadActionListener());
        horizontalBox3.add(downloadButton);
        horizontalBox3.add(Box.createHorizontalStrut(10));

        verticalBox.add(horizontalBox3);

        return verticalBox;
    }

    private JComponent createQRCodePanel() {
        JPanel picHolder = new JPanel(new GridLayout(0, 1));
        picHolder.add(imageLabel);
        return picHolder;
    }

    @NotNull
    private ActionListener fileActionListener() {
        return e -> {
            FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true, false, false, false, false, false);
            VirtualFile virtualFile = FileChooser.chooseFile(chooserDescriptor, this.project, null);
            if (virtualFile != null) {
                logoTextField.setText(virtualFile.getPath());
            }
        };
    }

    @NotNull
    private ActionListener generateActionListener() {
        return e -> {
            setFailureStyle();
            String text = this.textField.getText();
            if (StringUtil.isEmpty(text)) {
                exceptionMessageLabel.setText("二维码内容必填");
                return;
            }
            String logoPath = logoTextField.getText();
            try {
                image = QRCodeUtils.createImage(text, logoPath, true);
            } catch (Exception ex) {
                exceptionMessageLabel.setText("生成图片出错");
                return;
            }
            imageLabel.setIcon(new ImageIcon(image));
            setSuccessStyle("生成图片成功");
        };
    }

    @NotNull
    private ActionListener downloadActionListener() {
        return e -> {
            setFailureStyle();
            FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
            VirtualFile virtualFile = FileChooser.chooseFile(chooserDescriptor, this.project, null);
            if (virtualFile == null) {
                exceptionMessageLabel.setText("请选择下载目录");
                return;
            }
            String destPath = virtualFile.getPath();
            String file = new Random().nextInt(99999999) + ".jpg";
            try {
                ImageIO.write(image, "JPG", new File(destPath + "/" + file));
            } catch (IOException ex) {
                exceptionMessageLabel.setText("下载图片出错");
                return;
            }
            setSuccessStyle("下载图片成功");
        };
    }


}
