package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.Base64DecodeUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class Base64DecodeToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    private static final String POPUP_TITLE = "Base64 Decode";

    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.Base64Decode.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new Base64DecodeUI(project).getPanel();

        JBDimension dimension = new JBDimension(400, 300);
        JBPopup popup = createPopup(POPUP_TITLE, dimension, AllIcons.Toolwindows.Documentation, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
