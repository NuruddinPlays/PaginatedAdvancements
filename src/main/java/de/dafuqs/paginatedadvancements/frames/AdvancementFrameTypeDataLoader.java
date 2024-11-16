package de.dafuqs.paginatedadvancements.frames;

import de.dafuqs.paginatedadvancements.*;
import de.dafuqs.paginatedadvancements.client.*;
import net.fabricmc.fabric.api.resource.*;
import net.minecraft.resource.*;
import net.minecraft.util.*;
import net.minecraft.util.profiler.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class AdvancementFrameTypeDataLoader extends JsonDataLoader<PaginatedAdvancementFrame> implements IdentifiableResourceReloadListener {
	
	public static final Identifier ID = PaginatedAdvancementsClient.locate("advancement_frame_types");
	public static final AdvancementFrameTypeDataLoader INSTANCE = new AdvancementFrameTypeDataLoader();
	
	protected static final Map<Identifier, PaginatedAdvancementFrame> ADVANCEMENT_TO_FRAME = new HashMap<>();
	
	public AdvancementFrameTypeDataLoader() {
		super(PaginatedAdvancementFrame.CODEC, "paginated_frame_types");
	}
	
	public static @Nullable PaginatedAdvancementFrame getFrameForAdvancement(Identifier id) {
		return ADVANCEMENT_TO_FRAME.getOrDefault(id, null);
	}
	
	@Override
	protected void apply(Map<Identifier, PaginatedAdvancementFrame> prepared, ResourceManager manager, Profiler profiler) {
		for (Map.Entry<Identifier, PaginatedAdvancementFrame> entry : prepared.entrySet()) {
			Identifier id = entry.getKey();
			PaginatedAdvancementFrame frame = entry.getValue();
			ADVANCEMENT_TO_FRAME.put(id, frame);
		}
	}
	
	@Override
	public Identifier getFabricId() {
		return ID;
	}
	
}