package eyeq.raventofutouch.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RavenTofuTouchEventHandler {
    @SubscribeEvent
    public void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        World world = event.getWorld();
        EntityPlayer player = event.getEntityPlayer();
        if(world.isRemote || player.isCreative()) {
            return;
        }
        if(player.getHeldItemMainhand().isEmpty() && player.getHeldItemOffhand().isEmpty()) {
            world.setBlockState(event.getPos(), Blocks.GRAVEL.getDefaultState());
        }
    }

    @SubscribeEvent
    public void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        World world = event.getWorld();
        EntityPlayer player = event.getEntityPlayer();
        if(world.isRemote || player.isCreative()) {
            return;
        }
        if(player.getHeldItemMainhand().isEmpty() && player.getHeldItemOffhand().isEmpty()) {
            world.setBlockState(event.getPos(), Blocks.GRAVEL.getDefaultState());
        }
    }

    @SubscribeEvent
    public void onEntityItemPickup(EntityItemPickupEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        if(player.getEntityWorld().isRemote || player.isCreative()) {
            return;
        }
        EntityItem entity = event.getItem();
        ItemStack itemStack = entity.getEntityItem();
        Item item = itemStack.getItem();

        if(item instanceof ItemBlock && ((ItemBlock) item).getBlock() == Blocks.GRAVEL) {
            return;
        }
        entity.setEntityItemStack(new ItemStack(Blocks.GRAVEL, itemStack.getCount()));
        entity.onCollideWithPlayer(event.getEntityPlayer());
        event.setCanceled(true);
    }
}
