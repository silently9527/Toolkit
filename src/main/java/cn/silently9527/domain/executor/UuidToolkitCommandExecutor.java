package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import com.intellij.openapi.actionSystem.DataContext;

public class UuidToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.UUID.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {

    }
}
