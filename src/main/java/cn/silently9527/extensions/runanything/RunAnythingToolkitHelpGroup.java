package cn.silently9527.extensions.runanything;

import com.intellij.ide.actions.runAnything.activity.RunAnythingProvider;
import com.intellij.ide.actions.runAnything.groups.RunAnythingHelpGroup;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class RunAnythingToolkitHelpGroup extends RunAnythingHelpGroup<RunAnythingToolkitProvider> {

    @NotNull
    @Override
    public String getTitle() {
        return "Toolkit";
    }

    @NotNull
    @Override
    public Collection<RunAnythingToolkitProvider> getProviders() {
        return ContainerUtil.immutableSingletonList(RunAnythingProvider.EP_NAME.findExtension(RunAnythingToolkitProvider.class));

    }
}
