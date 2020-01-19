package cn.blockmc.Zao_hon;

import cn.blockmc.Zao_hon.generator.VoidGenerator;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;

public class VoidGeneratorNK extends PluginBase {
	@Override
	public void onEnable() {
		this.getLogger().info("VoidGeneratorNK have enabled successfully");
		Generator.addGenerator(VoidGenerator.class, "void", VoidGenerator.TYPE_VOID);
	}

	public void log(String str) {
		this.getLogger().info(str);
	}
}
