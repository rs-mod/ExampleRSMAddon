package com.example.component.impl;

import com.ricedotwho.rsm.component.api.ModComponent;
import com.ricedotwho.rsm.event.api.SubscribeEvent;
import com.ricedotwho.rsm.event.impl.client.TimeEvent;
import com.ricedotwho.rsm.utils.ChatUtils;

public class ExampleComponent extends ModComponent {

    // Components are classes which are always subscribed to the event bus
    public ExampleComponent() {
        super("ExampleComponent");
    }

    @SubscribeEvent
    public void onSecond(TimeEvent.Second event) {
        ChatUtils.chat("On Second!");
    }
}
