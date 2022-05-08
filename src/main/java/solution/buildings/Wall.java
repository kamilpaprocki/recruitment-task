package solution.buildings;

import solution.exceptions.WrongArgumentException;
import solution.materials.Block;
import solution.materials.CompositeBlockMaterial;
import solution.materials.Structure;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Stream<Block> blocksInWall = blocks.stream();
        return Stream.concat(blocksInWall, blockInCompositeBlocks().stream())
                .filter(block -> block.getColor().equalsIgnoreCase(color))
                .findFirst();
    }

    private List<Block> blockInCompositeBlocks() {
        List<Block> blockInCompositeBlocks = new LinkedList<>();
        blocks.forEach(b -> {
            if (b instanceof CompositeBlockMaterial) {
                blockInCompositeBlocks.addAll(((CompositeBlockMaterial) b).getBlocks());
            }
        });
        return blockInCompositeBlocks;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null) {
            throw new WrongArgumentException("Material cannot be a null");
        }
        Stream<Block> blocksInWall = blocks.stream();
        return Stream.concat(blocksInWall, blockInCompositeBlocks()
                .stream())
                .filter(block -> block.getMaterial().equalsIgnoreCase(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        int blocksNumber = blocks.size();

        blocksNumber += blocks.stream()
                .filter(b -> b instanceof CompositeBlockMaterial)
                .mapToInt(b -> ((CompositeBlockMaterial) b).getBlocks().size())
                .sum();

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
