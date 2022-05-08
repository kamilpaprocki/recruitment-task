import solution.materials.BlockMaterial;
import solution.materials.CompositeBlockMaterial;

public interface SampleBlocks {

    default BlockMaterial redGlassBlock() {
        return new BlockMaterial("red", "glass");
    }

    default BlockMaterial greenGlassBlock() {
        return new BlockMaterial("green", "glass");
    }

    default BlockMaterial redBrickBlock() {
        return new BlockMaterial("red", "brick");
    }

    default BlockMaterial whiteStoneBlock() {
        return new BlockMaterial("white", "stone");
    }

    default BlockMaterial blackSteelBlockWithWhiteStoneBlock() {
        CompositeBlockMaterial compositeBlockMaterial = new CompositeBlockMaterial("black", "steel");
        compositeBlockMaterial.addBlock(whiteStoneBlock());
        return compositeBlockMaterial;
    }

    default BlockMaterial blackSteelBlockWithRedBrickBlockAndGreenGlassBlock() {
        CompositeBlockMaterial compositeBlockMaterial = new CompositeBlockMaterial("black", "steel");
        compositeBlockMaterial.addBlock(redBrickBlock());
        compositeBlockMaterial.addBlock(greenGlassBlock());
        return compositeBlockMaterial;
    }
}
