package superworldsun.superslegend.util;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;

public class RenderTypes extends RenderType {

    protected static final RenderState.TransparencyState GHOST_TRANSPARANCY = new RenderState.TransparencyState("translucent_ghost_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public RenderTypes(String p_i225992_1_, VertexFormat p_i225992_2_, int p_i225992_3_, int p_i225992_4_, boolean p_i225992_5_, boolean p_i225992_6_, Runnable p_i225992_7_, Runnable p_i225992_8_) {
        super(p_i225992_1_, p_i225992_2_, p_i225992_3_, p_i225992_4_, p_i225992_5_, p_i225992_6_, p_i225992_7_, p_i225992_8_);
    }

    public static RenderType getPoeInDayTime(ResourceLocation p_228652_0_) {
        TextureState lvt_1_1_ = new TextureState(p_228652_0_, false, false);
        return makeType("poe_in_day", DefaultVertexFormats.ENTITY, 7, 262144, false, true, RenderType.State.getBuilder().texture(lvt_1_1_).writeMask(COLOR_DEPTH_WRITE).depthTest(DEPTH_LEQUAL).alpha(DEFAULT_ALPHA).diffuseLighting(DIFFUSE_LIGHTING_ENABLED).lightmap(LIGHTMAP_DISABLED).overlay(OVERLAY_ENABLED).transparency(TRANSLUCENT_TRANSPARENCY).fog(FOG).cull(RenderState.CULL_ENABLED).build(true));
    }

    public static RenderType getGhost(ResourceLocation p_228652_0_) {
        TextureState lvt_1_1_ = new TextureState(p_228652_0_, false, false);
        return makeType("ghost_iaf", DefaultVertexFormats.ENTITY, 7, 262144, false, true, RenderType.State.getBuilder().texture(lvt_1_1_).writeMask(COLOR_DEPTH_WRITE).depthTest(DEPTH_LEQUAL).alpha(DEFAULT_ALPHA).diffuseLighting(DIFFUSE_LIGHTING_ENABLED).lightmap(LIGHTMAP_DISABLED).overlay(OVERLAY_ENABLED).transparency(GHOST_TRANSPARANCY).fog(FOG).cull(RenderState.CULL_ENABLED).build(true));
    }

}