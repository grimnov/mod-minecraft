package net.mcreator.testblocs.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Block;

import net.mcreator.testblocs.TestBlocsMod;

import java.util.Random;
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
		double posX = 0;
		double posY = 0;
		double posZ = 0;
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
			posX = (double) (x - 1);
			posY = (double) (x - 1);
			posZ = (double) (x - 1);
			for (int index0 = 0; index0 < (int) (3); index0++) {
				for (int index1 = 0; index1 < (int) (3); index1++) {
					for (int index2 = 0; index2 < (int) (3); index2++) {
						if ((((itemstack).getOrCreateTag().getBoolean("stopMining")) == (false))) {
							if (((((world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ)))
									.getMaterial() == net.minecraft.block.material.Material.WOOD) == (true))
									|| ((((world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ)))
											.getMaterial() == net.minecraft.block.material.Material.GOURD) == (true))
											|| ((((world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ)))
													.getMaterial() == net.minecraft.block.material.Material.BAMBOO) == (true))
													|| (((world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ)))
															.getMaterial() == net.minecraft.block.material.Material.BAMBOO_SAPLING) == (true)))))) {
								if (world instanceof World) {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) posX, (int) posY, (int) posZ)), (World) world,
											new BlockPos((int) posX, (int) posY, (int) posZ));
									world.destroyBlock(new BlockPos((int) posX, (int) posY, (int) posZ), false);
								}
								if (((new Object() {
									public boolean checkGamemode(Entity _ent) {
										if (_ent instanceof ServerPlayerEntity) {
											return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
										} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
											NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
													.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
											return _npi != null && _npi.getGameType() == GameType.CREATIVE;
										}
										return false;
									}
								}.checkGamemode(entity)) == (false))) {
									{
										ItemStack _ist = (itemstack);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (((((itemstack)).getDamage()) == 0)) {
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos((int) posX, (int) posY, (int) posZ),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("ambient.cave")),
													SoundCategory.AMBIENT, (float) 1, (float) 0.9);
										} else {
											((World) world).playSound(posX, posY, posZ,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("ambient.cave")),
													SoundCategory.AMBIENT, (float) 1, (float) 0.9, false);
										}
										if (entity instanceof PlayerEntity) {
											ItemStack _stktoremove = (itemstack);
											((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
													((PlayerEntity) entity).container.func_234641_j_());
										}
										(itemstack).getOrCreateTag().putBoolean("stopMining", (true));
									}
								}
							}
						}
						posZ = (double) (posZ + 1);
					}
					posZ = (double) (z - 1);
					posX = (double) (posX + 1);
				}
				posX = (double) (x - 1);
				posZ = (double) (z - 1);
				posY = (double) (posY + 1);
			}
		}
	}
}
