package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.QrcodeDecodeUI;
import cn.silently9527.ui.QrcodeEncodeUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class QrcodeDecodeToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.QRCodeDecode.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new QrcodeDecodeUI(project).getPanel();

        JBDimension dimension = new JBDimension(400, 300);
        JBPopup popup = createPopup(command.getDescription(), dimension, AllIcons.Actions.Install, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
