package com.mawuote.client.commands;

import com.mawuote.api.manager.command.*;
import com.mawuote.*;
import com.mawuote.api.manager.module.*;
import org.lwjgl.input.*;
import com.mawuote.api.manager.misc.*;
import java.util.*;

public class CommandBind extends Command
{
    public CommandBind() {
        super("bind", "Binds a module with commands.", "bind <name> <key> | clear", new String[] { "key", "keybind", "b" });
    }
    
    @Override
    public void onCommand(final String[] args) {
        if (args.length == 2) {
            boolean found = false;
            for (final Module module : Kaotik.getModuleManager().getModules()) {
                if (module.getName().equalsIgnoreCase(args[0])) {
                    module.setBind(Keyboard.getKeyIndex(args[1].toUpperCase()));
                    ChatManager.printChatNotifyClient(module.getName() + " bound to " + Keyboard.getKeyName(module.getBind()).toUpperCase());
                    found = true;
                    break;
                }
            }
            if (!found) {
                ChatManager.printChatNotifyClient("Could not find module.");
            }
        }
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                for (final Module module2 : Kaotik.getModuleManager().getModules()) {
                    module2.setBind(0);
                }
                ChatManager.printChatNotifyClient("Successfully cleared all binds.");
            }
            else {
                ChatManager.printChatNotifyClient(this.getSyntax());
            }
        }
        else {
            ChatManager.printChatNotifyClient(this.getSyntax());
        }
    }
}
