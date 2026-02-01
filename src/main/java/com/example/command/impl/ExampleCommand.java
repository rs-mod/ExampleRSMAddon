package com.example.command.impl;

import com.ricedotwho.rsm.command.Command;
import com.ricedotwho.rsm.command.api.CommandInfo;
import com.ricedotwho.rsm.utils.ChatUtils;

@CommandInfo(aliases = {"example"}, description = "An example command")
public class ExampleCommand extends Command {

    @Override
    public void execute(String[] args, String message) {
        if (args.length != 0 && args[0].equalsIgnoreCase("hi")) {
            ChatUtils.chat("Hi!");
        } else {
            ChatUtils.chat("...");
        }
    }
}
