package michaelj.leyline;

import michaelj.leyline.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("leyline")
public class Leyline {
    public static Leyline instance;
    public static final String modid = "leyline";
    private static final Logger logger = LogManager.getLogger(modid);

    public Leyline(){
        //able to reference mod class outside of mod
        instance = this;

        //Add listeners for all of the events inside of the setup and clientRegistries functions below
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        //registers mod to be compatiable with forge
        MinecraftForge.EVENT_BUS.register(this);
    }

    // the new version of prenit
    private void setup(final FMLCommonSetupEvent event){
        logger.info("Setup Method Registered");
    }

    private void clientRegistries(final FMLClientSetupEvent event){
        logger.info("clientRegistries Method Registered");

    }
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){
            event.getRegistry().registerAll(
            ItemList.ornate_sword = new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("ornate_sword"))
            );
            logger.info("Items Registered");
        }

        private static ResourceLocation location(String name){
            return new ResourceLocation(modid, name);
        }


    }

}
