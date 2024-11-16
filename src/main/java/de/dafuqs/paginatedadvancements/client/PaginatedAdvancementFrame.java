package de.dafuqs.paginatedadvancements.client;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.text.*;
import net.minecraft.util.*;
import net.minecraft.util.dynamic.*;

public class PaginatedAdvancementFrame {
	
	public static final Codec<PaginatedAdvancementFrame> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
			Codecs.rangedInt(-16, 16).optionalFieldOf("item_offset_x", 0).forGetter(PaginatedAdvancementFrame::getItemOffsetX),
			Codecs.rangedInt(-16, 16).optionalFieldOf("item_offset_y", 0).forGetter(PaginatedAdvancementFrame::getItemOffsetY),
			Formatting.CODEC.optionalFieldOf("formatting", Formatting.GREEN).forGetter(PaginatedAdvancementFrame::getTitleFormat)
	).apply(instance, PaginatedAdvancementFrame::new));
	
	protected final Identifier textureObtained;
	protected final Identifier textureUnobtained;
	protected final int itemOffsetX;
	protected final int itemOffsetY;
	protected final Formatting titleFormat;
	protected final Text toastText;
	
	public PaginatedAdvancementFrame(int itemOffsetX, int itemOffsetY, Formatting titleFormat) {
		this.textureObtained = Identifier.of("todo"); // Identifier.of(id.getNamespace(), "advancements/" + id.getPath() + "_obtained");
		this.textureUnobtained = Identifier.of("todo"); // Identifier.of(id.getNamespace(), "advancements/" + id.getPath() + "_unobtained");
		this.itemOffsetX = itemOffsetX;
		this.itemOffsetY = itemOffsetY;
		this.titleFormat = titleFormat;
		this.toastText = Text.of("todo"); // Text.translatable("advancements.toast." + id);
	}
	
	public Identifier getTextureObtained() {
		return this.textureObtained;
	}
	
	public Identifier getTextureUnobtained() {
		return this.textureUnobtained;
	}
	
	public Formatting getTitleFormat() {
		return this.titleFormat;
	}
	
	public Text getToastText() {
		return this.toastText;
	}
	
	public int getItemOffsetX() {
		return this.itemOffsetX;
	}
	
	public int getItemOffsetY() {
		return this.itemOffsetY;
	}
	
}
