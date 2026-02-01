package com.example.module.impl;

import com.ricedotwho.rsm.data.Colour;
import com.ricedotwho.rsm.data.Keybind;
import com.ricedotwho.rsm.event.annotations.SubscribeEvent;
import com.ricedotwho.rsm.event.impl.render.Render2DEvent;
import com.ricedotwho.rsm.module.Module;
import com.ricedotwho.rsm.module.api.Category;
import com.ricedotwho.rsm.module.api.ModuleInfo;
import com.ricedotwho.rsm.ui.clickgui.settings.impl.*;
import com.ricedotwho.rsm.utils.ChatUtils;
import com.ricedotwho.rsm.utils.render.render2d.NVGUtils;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import org.joml.Vector2d;
import org.lwjgl.glfw.GLFW;

import java.util.Arrays;

@Getter
@ModuleInfo(aliases = "ExampleModule", id = "example-module", category = Category.RENDER, hasKeybind = true, defaultKey = GLFW.GLFW_KEY_BACKSPACE)
public class Example extends Module {
    private final BooleanSetting booleanSetting = new BooleanSetting("Boolean", true);
    private final ButtonSetting buttonSetting = new ButtonSetting("Button", "A Button", () -> {
        ChatUtils.chat("woah that button did something");
    });
    private final ColourSetting colourSetting = new ColourSetting("Colour", new Colour(-1));
    private final KeybindSetting keybindSetting = new KeybindSetting("Keybind", new Keybind(GLFW.GLFW_KEY_6, false, () -> {
        ChatUtils.chat("woah that keybind did something");
    }));
    private final ModeSetting modeSetting = new ModeSetting("Mode", "Item 1", Arrays.asList("Item 1", "Item 2", "Item 3"));
    private final MultiBoolSetting multiBoolSetting = new MultiBoolSetting("MultiBool", Arrays.asList("Option 1", "Option 2", "Option 3"), Arrays.asList("Option 1", "Option 3"));
    private final NumberSetting numberSetting = new NumberSetting("Number", 0, 100, 67, 1);
    private final StringSetting stringSetting = new StringSetting("String", "A String Setting");

    private final GroupSetting groupSetting = new GroupSetting("Group 2");
    private final BooleanSetting booleanSetting2 = new BooleanSetting("Boolean 2", false);

    private final DragSetting dragSetting = new DragSetting("A Gui Element", new Vector2d(10, 10), new Vector2d(50, 15));

    public Example() {
        this.registerProperty(
                booleanSetting,
                buttonSetting,
                colourSetting,
                keybindSetting,
                modeSetting,
                multiBoolSetting,
                numberSetting,
                stringSetting,
                groupSetting,
                dragSetting // Drag settings must be registered for the editor to recognise them
        );
        groupSetting.add(booleanSetting2);
    }

    @Override
    public void onEnable() {
        ChatUtils.chat(ChatFormatting.GREEN + "Example module enabled!");
        this.keybindSetting.getValue().register();
    }

    @Override
    public void onDisable() {
        ChatUtils.chat(ChatFormatting.RED + "Example module disabled!");
        this.keybindSetting.getValue().unregister();
    }

    @Override
    public void reset() {

    }

    @SubscribeEvent
    public void onRender2D(Render2DEvent event) {
        // translates and scales the content
        this.dragSetting.renderScaled(event.getGfx(),
                () -> NVGUtils.drawText( "hello", 0, 0, 25f, Colour.WHITE, NVGUtils.JOSEFIN),
                NVGUtils.getTextWidth("hello", 25f, NVGUtils.JOSEFIN), // this isn't ideal, but I cba finding out what the width would be rn
                NVGUtils.getTextHeight(25f, NVGUtils.JOSEFIN)
        );
    }
}
