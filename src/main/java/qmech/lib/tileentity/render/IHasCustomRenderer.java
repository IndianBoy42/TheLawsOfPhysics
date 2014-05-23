package qmech.lib.tileentity.render;

/**
 * Created by anshuman on 17-05-2014.
 */
public interface IHasCustomRenderer {

    public CustomRendererBase customRenderer();

    public void registerRenderer();

    public static interface IBlockHasCustomRenderer {

    }

}
