package cn.blockmc.Zao_hon.generator;

import java.util.HashMap;
import java.util.Map;

import cn.nukkit.block.Block;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.biome.Biome;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.math.Vector3;

public class VoidGenerator extends Generator {
	public static int TYPE_VOID = 4;
	private Map<String, Object> options;

	@SuppressWarnings("unused")
	private NukkitRandom random;
	private ChunkManager level;

	public VoidGenerator() {
		this(new HashMap<>());
	}

	public VoidGenerator(Map<String, Object> options) {
		this.options = options;
	}

	@Override
	public void generateChunk(int chunkX, int chunkZ) {
		FullChunk chunk = level.getChunk(chunkX, chunkZ);
		chunk.setGenerated();
		for (int Z = 0; Z < 16; Z++) {
			for (int X = 0; X < 16; X++) {
				chunk.setBiome(X, Z, Biome.getBiome(1));
				for (int y = 0; y < 256; y++) {
					chunk.setBlock(X, y, Z, 0);
				}
			}
		}

		if ((0 >= chunkX << 4) && (0 < chunkX + 1 << 4) && (0 >= chunkZ << 4) && (0 < chunkZ + 1 << 4)) {
			chunk.setBlock(0, 63, 0, Block.GLASS);
		}

	}

	@Override
	public ChunkManager getChunkManager() {
		return level;
	}

	@Override
	public int getId() {
		return TYPE_VOID;
	}

	@Override
	public String getName() {
		return "void";
	}

	@Override
	public Map<String, Object> getSettings() {
		return options;
	}

	@Override
	public Vector3 getSpawn() {
		return new Vector3(0, 65, 0);
	}

	@Override
	public void init(ChunkManager level, NukkitRandom random) {
		this.level = level;
		this.random = random;
	}

	@Override
	public void populateChunk(int arg0, int arg1) {
		return;
	}

}
