package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.IPAndPhoneAddressUI;
import cn.silently9527.ui.QrcodeEncodeUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class QrcodeEncodeToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.QRCodeEncode.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new QrcodeEncodeUI(project).getPanel();

        JBDimension dimension = new JBDimension(530, 500);
        JBPopup popup = createPopup(command.getDescription(), dimension, AllIcons.Actions.Search, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
