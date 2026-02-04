package com.example.command.impl;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.ricedotwho.rsm.command.Command;
import com.ricedotwho.rsm.command.api.CommandInfo;
import com.ricedotwho.rsm.utils.ChatUtils;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

@CommandInfo(name = "example", description = "An example command")
public class ExampleCommand extends Command {

    @Override
    public LiteralArgumentBuilder<ClientSuggestionProvider> build() {
        return literal(name())
                .executes(ctx -> {
                    ChatUtils.chat("...");
                    return 1;
                })
                .then(argument("input", StringArgumentType.word())
                        .executes(ctx -> {
                            String input = StringArgumentType.getString(ctx, "input");
                            if (input.equalsIgnoreCase("hi")) {
                                ChatUtils.chat("Hi!");
                            } else {
                                ChatUtils.chat("...");
                            }
                            return 1;
                        })
                );
    }
}
