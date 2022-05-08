package solution.buildings;

import solution.exceptions.WrongArgumentException;
import solution.materials.Block;
import solution.materials.Structure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null){
            throw new WrongArgumentException("Color cannot be a null");
        }
        return blocks.stream().filter(b -> b.getColor().equalsIgnoreCase(color)).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null){
            throw new WrongArgumentException("Material cannot be a null");
        }
        return blocks.stream().filter(b -> material.equalsIgnoreCase(b.getMaterial())).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
