package com.example;

import com.example.command.impl.ExampleCommand;
import com.example.component.impl.ExampleComponent;
import com.example.module.impl.Example;
import com.ricedotwho.rsm.addon.Addon;
import com.ricedotwho.rsm.command.Command;
import com.ricedotwho.rsm.component.api.ModComponent;
import com.ricedotwho.rsm.module.Module;
import com.ricedotwho.rsm.utils.ChatUtils;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ExampleAddon implements Addon {
    @Getter
    private static final Logger logger = LogManager.getLogger("exampleaddon");

    // If you do not need mixins, delete the fabric.mod.json, and mixins.json files.
    // If you wish to use mixins, you may delete the addon.json file.

    @Override
    public void onInitialize() {
        ChatUtils.chat("Example addon loaded!");
    }

    @Override
    public void onUnload() {
        ChatUtils.chat("Example addon unloaded!");
    }

    @Override
    public List<Class<? extends Module>> getModules() {
        return List.of(Example.class);
    }

    @Override
    public List<Class<? extends ModComponent>> getComponents() {
        return List.of(ExampleComponent.class);
    }

    @Override
    public List<Class<? extends Command>> getCommands() {
        return List.of(ExampleCommand.class);
    }
}