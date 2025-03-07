#version 310 es

precision mediump float;

uniform sampler2D uTexture;
uniform sampler2D uNormalMap;

in vec3 vLightPosTan;
in vec3 vPosTan;
in vec2 vTexCoords;

layout(location = 0) out vec4 outColor;
layout(location = 1) out vec4 outPosition;

void main() {
    vec3 cameraDirection = normalize(vLightPosTan - vPosTan);

    vec4 color = texture(uTexture, vTexCoords);

    if (color.a < 0.01) {
        discard;
    }

    vec3 normal = texture(uNormalMap, vTexCoords).rgb;
    normal = normalize(normal * 2.0 - 1.0);

    if (!gl_FrontFacing) {
        normal = -normal;
        color = vec4(0.5, 0.5, 0.5, color.a);
    }

    float exposure = max(dot(cameraDirection, normal), 0.0) * 0.6 + 0.4;

    outColor = vec4(color.rgb * exposure, color.a);
    outPosition = gl_FragCoord;
}
