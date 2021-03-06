package superworldsun.superslegend.items;

import java.util.List;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superworldsun.superslegend.SupersLegend;
import superworldsun.superslegend.lists.ArmourMaterialList;
import superworldsun.superslegend.lists.ItemList;
import superworldsun.superslegend.models.masks.ModelBunnyhoodMask;
import superworldsun.superslegend.models.masks.ModelRocsCape;

public class RocsCapeEffects extends NonEnchantArmor {
    public RocsCapeEffects(String name, EquipmentSlotType slot) 
    
    {
        super(ArmourMaterialList.rocscape, slot, new Properties().group(SupersLegend.supers_legend));
        setRegistryName(SupersLegend.modid, name);
    }

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
	{
		return (A) new ModelRocsCape(0);
	}


    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) 
    {
    	if (!world.isRemote){
    		boolean isChestplateOn = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(ItemList.rocs_cape);
            if(isChestplateOn)
            	{
            	if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(ItemList.hover_boots)) 
            	{
            		player.removePotionEffect(Effect.get(28));
            	}
            	else if(player.isOnGround())
		        {
            		player.addPotionEffect(new EffectInstance(Effect.get(28), 24, 0, false, false));
					player.addPotionEffect(new EffectInstance(Effect.get(8), 1, 3, false, false));
		        }
                
            	}
    	}

    }
        

		    @Override
			public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
			{
				super.addInformation(stack, world, list, flag);				
				list.add(new StringTextComponent(TextFormatting.WHITE + "Wearing this will grant better ground mobility"));
			}   
} 