package de.morgon.echocrafti.listener;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


import static de.morgon.echocrafti.claiming.ClaimBreakBlockBeneathBanner.onBreakBlockBeneathBanner;
import static de.morgon.echocrafti.claiming.ClaimBreak.onBreakClaimedBlock;
import static de.morgon.echocrafti.claiming.Unclaim.onBreakBanner;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        onBreakBlockBeneathBanner(e);
        onBreakClaimedBlock(e);
        onBreakBanner(e);
    }

}
