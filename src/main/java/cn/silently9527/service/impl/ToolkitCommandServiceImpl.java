package cn.silently9527.service.impl;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.domain.executor.ToolkitCommandExecutor;
import cn.silently9527.domain.executor.ToolkitCommandExecutorComposite;
import cn.silently9527.service.ToolkitCommandService;
import com.intellij.openapi.actionSystem.DataContext;

public class ToolkitCommandServiceImpl implements ToolkitCommandService {
    private ToolkitCommandExecutor toolkitCommandExecutor = new ToolkitCommandExecutorComposite();

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        toolkitCommandExecutor.execute(command, dataContext);
    }
}
