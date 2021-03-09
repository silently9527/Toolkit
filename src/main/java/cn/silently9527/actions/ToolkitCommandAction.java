package cn.silently9527.actions;

import cn.silently9527.Constants;
import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.service.ToolkitCommandService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ToolkitCommandAction extends AnAction {
    private ToolkitCommandService toolkitCommandService;
    private ToolkitCommand command;

    public ToolkitCommandAction(ToolkitCommand command) {
        this.command = command;
        this.toolkitCommandService = ServiceManager.getService(ToolkitCommandService.class);

        Presentation presentation = getTemplatePresentation();
        presentation.setText(command.getCommand(), false);
        presentation.setIcon(Constants.Icons.Toolbox);
        presentation.setDescription(command.getDescription());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        toolkitCommandService.execute(this.command, e.getDataContext());
    }

    @Nullable
    @Override
    public String getTemplateText() {
        return this.command.getCommand();
    }
}
