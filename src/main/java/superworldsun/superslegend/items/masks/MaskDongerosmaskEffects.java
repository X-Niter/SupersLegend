package superworldsun.superslegend.items.masks;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import superworldsun.superslegend.SupersLegend;
import superworldsun.superslegend.items.NonEnchantArmor;
import superworldsun.superslegend.lists.ArmourMaterialList;
import superworldsun.superslegend.lists.ItemList;


public class MaskDongerosmaskEffects extends NonEnchantArmor {
    public MaskDongerosmaskEffects(String name, EquipmentSlotType slot) 
    
    {
        super(ArmourMaterialList.dongerosmask, slot, new Properties().group(SupersLegend.supers_legend));
        setRegistryName(SupersLegend.modid, name);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
    {
        if (!world.isRemote)
        {
                boolean isHelmeton = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(ItemList.mask_dongerosmask);
                if(isHelmeton) player.addPotionEffect(new EffectInstance(Effect.get(8), 10, 1, false, false));
                
        }
            
    }

    public void addInformation(ItemStack stack, World world, java.util.List<ITextComponent> list, ITooltipFlag flag)
 	{
 		super.addInformation(stack, world, list, flag);				
 		list.add(new StringTextComponent(TextFormatting.DARK_GREEN + "This Hood is Hoppin!"));
 		list.add(new StringTextComponent(TextFormatting.GRAY + "Grants a jump boost"));
 	}
}