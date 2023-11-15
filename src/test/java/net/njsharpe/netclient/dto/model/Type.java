package net.njsharpe.netclient.dto.model;

import com.google.gson.annotations.SerializedName;

public enum Type {

    @SerializedName("Checkpoint")
    CHECKPOINT,
    @SerializedName("Model")
    MODEL,
    @SerializedName("LORA")
    LORA,
    @SerializedName("TextualInversion")
    TEXTUAL_INVERSION,
    @SerializedName("Controlnet")
    CONTROLNET,
    @SerializedName("Hypernetwork")
    HYPERNETWORK,
    @SerializedName("AestheticGradient")
    AESTHETIC_GRADIENT,
    @SerializedName("Poses")
    POSES

}