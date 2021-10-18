package net.mcreator.testblocs.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.testblocs.TestBlocsMod;

import java.util.Map;

public class HacheQuandLeBlocEstDetruitAvecLoutilProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TestBlocsMod.LOGGER.warn("Failed to load dependency entity for procedure HacheQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TestBlocsMod.LOGGER.warn("Failed to load dependency itemstack for procedure HacheQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TestBlocsMod.LOGGER.warn("Failed to load dependency x for procedure HacheQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TestBlocsMod.LOGGER.warn("Failed to load dependency y for procedure HacheQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TestBlocsMod.LOGGER.warn("Failed to load dependency z for procedure HacheQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TestBlocsMod.LOGGER.warn("Failed to load dependency world for procedure HacheQuandLeBlocEstDetruitAvecLoutil!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((itemstack).getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())
				&& ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.WOOD) == (true))
						|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.GOURD) == (true))
								|| ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.BAMBOO_SAPLING) == (true))
										|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
												.getMaterial() == net.minecraft.block.material.Material.BAMBOO) == (true))))))) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
		}
	}
}
