package solution.materials;

import java.util.LinkedList;
import java.util.List;

public class CompositeBlockMaterial extends BlockMaterial implements CompositeBlock{

    public CompositeBlockMaterial(String color, String material) {
        super(color, material);
        blocks = new LinkedList<>();
    }

    private List<Block> blocks;

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
