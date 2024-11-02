package com.github.iunius118.tolaserblade.exmodels;

import com.github.iunius118.tolaserblade.exmodels.data.ExModelsRecipeProvider;
import com.mojang.logging.LogUtils;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TLBExModels.MOD_ID)
public class TLBExModels {
    public static final String MOD_ID = "tlbexmodels";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TLBExModels(FMLJavaModLoadingContext context) {
        final IEventBus modEventBus = context.getModEventBus();

        // Register event handler
        modEventBus.addListener(this::gatherData);
    }

    // Generate Data
    private void gatherData(final GatherDataEvent event) {
        var dataGenerator = event.getGenerator();
        var packOutput = dataGenerator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        boolean includesServer = event.includeServer();

        dataGenerator.addProvider(includesServer, new ExModelsRecipeProvider.Runner(packOutput, lookupProvider));
    }
}
