package solution.materials;


import solution.exceptions.WrongArgumentException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CompositeBlockMaterial extends BlockMaterial implements CompositeBlock {

    private List<Block> blocks;

    public CompositeBlockMaterial(String color, String material) {
        super(color, material);
        this.blocks = new LinkedList<>();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        if (block == null) {
            throw new WrongArgumentException("You cannot add null block!");
        }
        blocks.add(block);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeBlockMaterial that = (CompositeBlockMaterial) o;
        return Objects.equals(blocks, that.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }
}
