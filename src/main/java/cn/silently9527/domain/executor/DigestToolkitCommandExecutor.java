package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.DigestUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;
import java.util.Arrays;

public class DigestToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    @Override
    public boolean support(ToolkitCommand command) {
        return Arrays.asList(ToolkitCommand.MD5, ToolkitCommand.SHA1, ToolkitCommand.SHA224,
                ToolkitCommand.SHA256, ToolkitCommand.SHA384, ToolkitCommand.SHA512).contains(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new DigestUI(project).getPanel();

        JBDimension dimension = new JBDimension(550, 350);
        JBPopup popup = createPopup("字符串加密", dimension, AllIcons.Toolwindows.Documentation, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
