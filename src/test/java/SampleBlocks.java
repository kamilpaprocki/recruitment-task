import solution.materials.BlockMaterial;
import solution.materials.CompositeBlockMaterial;

public interface SampleBlocks {

    default BlockMaterial redGlassBlock(){
        return new BlockMaterial("red", "glass");
    }

    default BlockMaterial greenGlassBlock(){
        return new BlockMaterial("green", "glass");
    }

    default BlockMaterial redBrickBlock(){
        return new BlockMaterial("red", "brick");
    }

    default BlockMaterial blackSteelBlock(){
        return new CompositeBlockMaterial("black", "steel");
    }
}
