package rorkh.fakeizen.commands;

import com.denizenscript.denizen.utilities.command.manager.messaging.Messaging;
import com.denizenscript.denizencore.utilities.debugging.Debug;
import com.denizenscript.denizencore.utilities.debugging.DebugSubmitter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.function.Supplier;

public class FakeizenCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return true;
        }

        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("submit")) {
                Messaging.send(sender, "Submitting Fakeizen...");

                DebugSubmitter.submitCurrentRecording((s) -> {
                    if (s == null) {
                        Messaging.sendError(sender, "Error while submitting.");
                    }
                    else if (s.equals("disabled")) {
                        Messaging.sendError(sender, "Submit failed: not recording.");
                    }
                    else {
                        Messaging.send(sender, "Successfully submitted to " + s);
                    }
                });

                return true;
            }
        }

        return false;
    }
}