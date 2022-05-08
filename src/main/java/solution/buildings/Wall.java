package solution.buildings;

import solution.exceptions.WrongArgumentException;
import solution.materials.Block;
import solution.materials.CompositeBlockMaterial;
import solution.materials.Structure;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null) {
            throw new WrongArgumentException("Color cannot be a null");
        }
        return blocks.stream().filter(b -> b.getColor().equalsIgnoreCase(color)).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null) {
            throw new WrongArgumentException("Material cannot be a null");
        }
        return blocks.stream().filter(b -> material.equalsIgnoreCase(b.getMaterial())).collect(Collectors.toList());
    }

    @Override
    public int count() {
        int blocksNumber = blocks.size();

        blocksNumber += blocks.stream().filter(b -> b instanceof CompositeBlockMaterial).mapToInt(b -> ((CompositeBlockMaterial) b).getBlocks().size()).sum();

        return blocksNumber;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "blocks=" + blocks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(blocks, wall.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }
}
