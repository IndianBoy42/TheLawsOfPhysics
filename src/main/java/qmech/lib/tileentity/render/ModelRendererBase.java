package qmech.lib.tileentity.render;

import qmech.lib.tileentity.render.model.CustomModelBase;

/**
 * Created by anshuman on 16-05-2014.
 */
public class ModelRendererBase extends CustomRendererBase {

    private final CustomModelBase model;

    public ModelRendererBase(CustomModelBase model) {
        this.model = model;
    }

    @Override
    public void renderModel() {
        CustomRendererBase.modelRender(this.model);
    }

    @Override
    public String texPath() {
        return this.model.texPath();
    }
}
