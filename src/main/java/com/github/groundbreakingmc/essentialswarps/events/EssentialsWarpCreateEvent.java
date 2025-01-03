package com.github.groundbreakingmc.essentialswarps.events;

import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public final class EssentialsWarpCreateEvent extends PlayerEvent implements Cancellable {

    private final PlayerCommandPreprocessEvent commandPreprocessEvent;
    @Getter
    private final String warpName;

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public EssentialsWarpCreateEvent(final PlayerCommandPreprocessEvent commandPreprocessEvent, final String warpName) {
        super(commandPreprocessEvent.getPlayer());
        this.commandPreprocessEvent = commandPreprocessEvent;
        this.warpName = warpName;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.commandPreprocessEvent.setCancelled(cancel);
    }

    @Override
    public boolean isCancelled() {
        return this.commandPreprocessEvent.isCancelled();
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
