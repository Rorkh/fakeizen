package rorkh.fakeizen;

import org.bukkit.plugin.java.JavaPlugin;

import rorkh.fakeizen.debugging.FakeizenDebugSubmit;
import rorkh.fakeizen.commands.FakeizenCommand;

public class Fakeizen extends  JavaPlugin {
        @Override
        public void onEnable() {
            FakeizenDebugSubmit.init();
            this.getCommand("fakeizen").setExecutor(new FakeizenCommand());
        }

        @Override
        public void  onDisable() {}
}