import org.junit.Test;
import solution.buildings.Wall;
import solution.exceptions.WrongArgumentException;
import solution.materials.Block;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WallTest implements SampleBlocks {

    @Test
    public void should_return_any_block_when_is_color_given() {

        //given
        List<Block> blocks = Arrays.asList(redGlassBlock(), greenGlassBlock(), blackSteelBlock(), redBrickBlock());
        String color = "red";
        Wall wall = new Wall(blocks);
        //when
        Block blockByColor = wall.findBlockByColor(color).get();
        //then
        assertThat(blockByColor).hasFieldOrPropertyWithValue("color", color);
    }

    @Test
    public void should_throw_WrongArgumentException_when_given_color_is_null() {
        //given
        List<Block> blocks = Arrays.asList(redGlassBlock(), greenGlassBlock(), blackSteelBlock(), redBrickBlock());
        String color = null;
        Wall wall = new Wall(blocks);
        //when //then
        assertThrows(WrongArgumentException.class, () -> wall.findBlockByColor(color));
    }

    @Test
    public void should_return_list_of_blocks_when_is_given_material() {

        //given
        List<Block> blocks = Arrays.asList(redGlassBlock(), greenGlassBlock(), blackSteelBlock(), redBrickBlock());
        String material = "glass";
        Wall wall = new Wall(blocks);
        //when
        List<Block> expectedBlocks = wall.findBlocksByMaterial(material);
        //then
        assertThat(expectedBlocks.size()).isEqualTo(2);
    }

    @Test
    public void should_throw_WrongArgumentException_when_given_material_is_null() {

        //given
        List<Block> blocks = Arrays.asList(redGlassBlock(), greenGlassBlock(), blackSteelBlock(), redBrickBlock());
        String material = null;
        Wall wall = new Wall(blocks);
        //when //then
        assertThrows(WrongArgumentException.class, () -> wall.findBlocksByMaterial(material));
    }

    @Test
    public void should_return_number_of_blocks_in_structure() {
        //given
        List<Block> blocks = Arrays.asList(redGlassBlock(), greenGlassBlock(), blackSteelBlock(), redBrickBlock());
        Wall wall = new Wall(blocks);
        //when
        int expectedNumberOfBlocks = wall.count();
        //then
        assertThat(expectedNumberOfBlocks).isEqualTo(4);
    }
}
