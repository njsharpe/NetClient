package net.njsharpe.netclient;

import net.njsharpe.netclient.dto.Sort;
import net.njsharpe.netclient.dto.creator.Creator;
import net.njsharpe.netclient.dto.creator.Creators;
import net.njsharpe.netclient.dto.image.Image;
import net.njsharpe.netclient.dto.image.Images;
import net.njsharpe.netclient.dto.model.Model;
import net.njsharpe.netclient.dto.model.Models;
import net.njsharpe.netclient.dto.model.Type;
import net.njsharpe.netclient.dto.model.version.ModelVersion;
import net.njsharpe.netclient.dto.tag.Tag;
import net.njsharpe.netclient.dto.tag.Tags;
import net.njsharpe.netclient.junit.ArrayAssertions;
import net.njsharpe.netclient.route.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CivitaiClientTests {

    private final CivitaiClient client = new CivitaiClient();

    @Test
    public void testFindCreators() {
        FindCreators request = new FindCreators() {{
            limit = 5;
        }};
        Creators response = this.client.findCreators(request);

        Assertions.assertNotNull(response);

        Creator[] creators = response.getItems();

        ArrayAssertions.assertNotEmpty(creators);
        Assertions.assertEquals(5, creators.length);
    }

    @Test
    public void testFindImages() {
        FindImages request = new FindImages() {{
            limit = 5;
        }};
        Images response = this.client.findImages(request);

        Assertions.assertNotNull(response);

        Image[] images = response.getItems();

        ArrayAssertions.assertNotEmpty(images);
        Assertions.assertEquals(5, images.length);
    }

    @Test
    public void testFindModels() {
        FindModels request = new FindModels() {{
            limit = 5;
            sort = Sort.Model.NEWEST;
            nsfw = true;
        }};
        Models response = this.client.findModels(request);

        Assertions.assertNotNull(response);

        Model[] models = response.getItems();

        ArrayAssertions.assertNotEmpty(models);
        Assertions.assertEquals(5, models.length);
    }

    @Test
    public void testGetModel() {
        GetModel request = new GetModel() {{
            modelId = 190384;
        }};
        Model response = this.client.getModel(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(190384, response.getId());
        Assertions.assertEquals(Type.LORA, response.getType());

        ModelVersion[] versions = response.getModelVersions();

        ArrayAssertions.assertNotEmpty(versions);
        Assertions.assertEquals(2, versions.length);
    }

    @Test
    public void testFindTags() {
        FindTags request = new FindTags() {{
            limit = 5;
        }};
        Tags response = this.client.findTags(request);

        Assertions.assertNotNull(response);

        Tag[] tags = response.getItems();

        ArrayAssertions.assertNotEmpty(tags);
        Assertions.assertEquals(5, tags.length);
    }

    @Test
    public void testGetModelVersion() {
        GetModelVersion request = new GetModelVersion() {{
            modelVersionId = 229;
        }};
        ModelVersion response = this.client.getModelVersion(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(212, response.getModelId());

        ModelVersion.Model model = response.getModel();

        Assertions.assertEquals(Type.TEXTUAL_INVERSION, model.getType());
    }

    @Test
    public void testGetModelVersionByHash() {
        GetModelVersionByHash request = new GetModelVersionByHash() {{
            hash = "607CDD5E1C";
        }};
        ModelVersion response = this.client.getModelVersionByHash(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(212, response.getModelId());

        ModelVersion.Model model = response.getModel();

        Assertions.assertEquals(Type.TEXTUAL_INVERSION, model.getType());
    }

}
