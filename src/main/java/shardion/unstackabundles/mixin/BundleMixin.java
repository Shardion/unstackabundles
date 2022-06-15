package shardion.unstackabundles.mixin;

import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(BundleItem.class)
public class BundleMixin {
    @Inject(method = "getItemOccupancy", at = @At("RETURN"), cancellable = true)
    private static void getItemOccupancy(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        // unstackables only count as 16 items instead of 64
        if (stack.getMaxCount() == 1) {
            cir.setReturnValue(16);
        }
    }

    @Inject(method = "canMergeStack", at = @At("HEAD"), cancellable = true)
    private static void canMergeStack(ItemStack stack, NbtList items, CallbackInfoReturnable<Optional<NbtCompound>> cir) {
        // never merge unstackables, to prevent obtaining illegal stacks of them
        // bundles do not check item maximum stack sizes when merging stacks
        // normally, this is not an issue, because they can never hold more than a single maximum-size stack anyways
        // however, this mod allows putting 4 unstackable items in a bundle, which is 4 maximum-size stacks!
        // this check prevents merging unstackable items, as otherwise, the bundle would merge unstackables beyond their
        // maximum stack size, creating situations where it is possible to create, say, a 4 stack of minecarts
        if (stack.getMaxCount() == 1)
            cir.setReturnValue(Optional.empty());
    }
}
